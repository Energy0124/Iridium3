/*
 * IridiumModuleManager
 *
 * 8/24/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.mods;

import com.gmail.mstojcevich.lib.module.Module;
import com.gmail.mstojcevich.lib.module.ModuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of ModuleManager for IridiumModules
 * @author marcusant
 * @version 1
 * @since 8/24/13 12:14 AM
 */
public class IridiumModuleManager extends ModuleManager {
	
	/**
	 * Array of loaded modules
	 */
    private IridiumModule[] modules;

    /**
     * Creates a new module manager using 
     * com.gmail.mstojcevich.iridium.mods.modules
     * as the module directory
     */
    public IridiumModuleManager() {
    	this.loadModules();
    }
    
    /**
     * Loads modules from the default module
     * package
     */
    private void loadModules() {
        this.modules = this.createIridiumModulesFromPackage("com.gmail.mstojcevich.iridium.mods.modules");
    }

    /**
     * Creates IridiumModules for every valid module in the specified package
     * @param targetPackage Package to search for mods in
     * @return Array of created IridumModules
     */
    private IridiumModule[] createIridiumModulesFromPackage(String targetPackage) {
        List<IridiumModule> iridiumModules = new ArrayList<IridiumModule>();
        for (Module module : this.createModuleInstancesFromPackage(targetPackage)) {
            if(module instanceof IridiumModule) {
                iridiumModules.add((IridiumModule)module);
            }
        }
        return iridiumModules.toArray(new IridiumModule[iridiumModules.size()]);
    }

    @Override
    /**
     * Returns an array of the currently loaded modules
     */
    public IridiumModule[] getModules() {
        return this.modules;
    }
}
