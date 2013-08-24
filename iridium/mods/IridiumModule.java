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

    @Override
    public void setKeybind(int keycode) {
        this.keybind = keycode;
    }

    @Override
    public int getKeybind() {
        return this.keybind;
    }

}
