/*
 * Event
 *
 * 8/23/13
 *
 * Copyright (c) 2013, Marcus Stojcevich
 * All rights reserved.
 * See the included LICENSE file
 */

package com.gmail.mstojcevich.lib.event;

/**
 * @author marcusant
 * @version 1
 * @since 8/23/13 2:49 PM
 */
public class Event {

    /**
     * Title of the event used for debugging.
     */
    public String name;

    /**
     * Creates an event with the name being the class name.
     */
    public Event() {
        this.name = this.getClass().getSimpleName();
    }

    /**
     * Creates an event with the specified name
     * @param name name of the event
     */
    public Event(String name) {
        this.name = name;
    }

}
