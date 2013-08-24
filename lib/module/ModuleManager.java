/*
 * ModuleManager
 *
 * 8/23/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.lib.module;

import com.gmail.mstojcevich.lib.reflection.ReflectionHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides management for modules
 * @author marcusant
 * @version 1
 * @since 8/23/13 6:17 PM
 */
public abstract class ModuleManager {

    /**
     * Loads classes and creates module objects from an internal package
     * @param targetPackage The package location with folders separated with periods
     */
    public Module[] createModuleInstancesFromPackage(String targetPackage) {
        List<Module> moduleList = new ArrayList<Module>();
        for(Class indexClass : ReflectionHelper.getClassesInPackage(targetPackage)) {
            try {
                Module module = (Module)indexClass.newInstance();
                moduleList.add(module);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassCastException e) {
            	e.printStackTrace();
            }
        }
        return moduleList.toArray(new Module[moduleList.size()]);
    }

    public abstract Module[] getModules();

}
