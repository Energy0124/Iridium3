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
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides utilities to assist with reflection
 * @author marcusant
 * @version 1
 * @since 8/23/13 11:53 PM
 */
public class ReflectionHelper {

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
                    System.out.println("Error attempting to load classes from " + targetPackage);
                    e.printStackTrace();
                }
            }
        }
        return classList.toArray(new Class[classList.size()]);
    }

}
