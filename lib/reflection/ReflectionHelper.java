/*
 * ReflectionHelper
 *
 * 8/23/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.lib.reflection;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides utilities to assist with reflection
 * @author marcusant
 * @version 1
 * @since 8/23/13 11:53 PM
 */
public class ReflectionHelper {

    /**
     * Returns an array of classes within a target package
     * @param targetPackage target package
     * @return an array of classes within a target package
     */
    public static Class[] getClassesInPackage(String targetPackage) {
        List<Class> classList = new ArrayList<Class>();
        URL packageResource = Thread.currentThread()
                .getContextClassLoader()
                .getResource(targetPackage.replace(".", "/")
                        .trim());
        if (packageResource == null) {
            System.out.println("Could not create resource for package "
                    + targetPackage);
            return null;
        }
        File packageDirectory = new File(packageResource.getFile());
        for (String filename : packageDirectory.list()) {
            if (filename.endsWith(".class")) {
                String className = targetPackage + "." + filename;
                try {
                    classList.add(Class.forName(className.replace(".class", "")));
                } catch (ClassNotFoundException e) {
                    System.out.println("Error attempting to load classes from "
                        + targetPackage);
                    e.printStackTrace();
                }
            }
        }
        return classList.toArray(new Class[classList.size()]);
    }
    
    /**
     * Returns an array of classes inside of a package within a jar
     * @param jarFile target jar file
     * @param targetPackage target package within jar file
     * @return array of classes inside of a package within a jar
     */
    public static Class[] getClassesFromExternalJar(File jarFile, String targetPackage) {
        List<Class> classList = new ArrayList<Class>();
        try {
            @SuppressWarnings("resource")
            ClassLoader classLoader = new URLClassLoader(new URL[] { 
                    jarFile.toURI().toURL() });
             URL packageResource = classLoader
                        .getResource(targetPackage.replace(".", "/")
                        .trim());
            if (packageResource == null) {
                   System.out.println("Could not create resource for package "
                           + targetPackage);
                   return null;
            }
            File packageDirectory = new File(packageResource.getFile());
            for (String filename : packageDirectory.list()) {
                if (filename.endsWith(".class")) {
                    String className = targetPackage + (targetPackage.trim().length() > 0 ? "." : "") + filename;
                    try {
                        classList.add(Class.forName(className.replace(".class", "")));
                    } catch (ClassNotFoundException e) {
                        System.out.println("Error attempting to load classes from "
                            + targetPackage);
                        e.printStackTrace();
                    }
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        
        return classList.toArray(new Class[classList.size()]);
    }

}
