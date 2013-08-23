/*
 * marcusant
 *
 * August 23, 2013
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */
package com.gmail.mstojcevich.iridium;

import com.gmail.mstojcevich.lib.event.EventHandler;
import net.minecraft.src.Minecraft;

/**
 * Main class for Iridium, contains instances for many of the handlers
 * amongst other things such as project information.
 * @version 1
 * @author marcusant
 * @since 8/23/13 1:21 PM
 */
public class Iridium {

    /**
     * Singleton instance of the client
     */
    public static final Iridium instance = new Iridium();

    /**
     * The title of the client. Used when giving information on the client.
     */
    public static final String CLIENT_NAME = "Iridium";

    /**
     * The version of the client. Used when giving information on the client.
     */
    public static final String CLIENT_REVISION = "3.0";

    /**
     * The version of the Minecraft Coder Pack used to decompile and
     * deobfuscate Minecraft.
     */
    public static final int MCP_VERSION = 805;

    /**
     * The instance of Minecraft used for the Iridium instance.
     * @param Minecraft instance
     */
    private Minecraft mc;

    /**
     * Event handler used for all Iridium events
     */
    public final EventHandler eventHandler = new EventHandler();

    /**
     * Runs on startup of Minecraft
     * @param mc Minecraft instance
     */
    public void startupIridium(Minecraft mc){
        this.mc = mc;
        System.out.println(Iridium.CLIENT_NAME + " startup");
    }

}
