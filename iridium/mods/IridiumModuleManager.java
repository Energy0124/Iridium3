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
 * @author marcusant
 * @version 1
 * @since 8/24/13 12:14 AM
 */
public class IridiumModuleManager extends ModuleManager {

    public static IridiumModule[] modules;

    public IridiumModuleManager() {
        this.modules = this.createIridiumModulesFromPackage("com.gmail.mstojcevich.iridium.mods.modules");
    }

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
    public IridiumModule[] getModules() {
        return this.modules;
    }
}
