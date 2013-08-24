/*
 * IridiumModule
 *
 * 8/23/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.iridium.mods;

import com.gmail.mstojcevich.lib.module.Bindable;
import com.gmail.mstojcevich.lib.module.Module;

/**
 * Abstract module class used for Iridium mods.
 * @author marcusant
 * @version 1
 * @since 8/23/13 11:29 PM
 */
public abstract class IridiumModule extends Module implements Bindable {

    /**
     * Keycode to toggle the mod
     */
    private int keybind;
    /**
     * Current toggle state for the mod
     */
    private boolean toggle;
    /**
     * The title of the mod
     */
    private String title;
    /**
     * The category of the mod
     */
    private ModCategory category = ModCategory.OTHER;

    //Disabled constructors
    private IridiumModule() {
        super();
    }
    private IridiumModule(String name) {
        super();
    }

    //Protected constructors

    /**
     * Creates an Iridium module with the specified name and category
     * @param name
     * @param category
     */
    protected IridiumModule(String name, ModCategory category) {
        super(name);
        this.category = category;
    }

    /**
     * Creates an Iridium module with the specified category
     * @param category
     */
    protected IridiumModule(ModCategory category) {
        super();
        this.category = category;
    }

    @Override
    public void setKeybind(int keycode) {
        this.keybind = keycode;
    }

    @Override
    public int getKeybind() {
        return this.keybind;
    }

}
