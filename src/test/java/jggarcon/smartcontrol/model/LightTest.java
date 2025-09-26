package jggarcon.smartcontrol.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LightTest {

    @Test
    void testTurnOnAndOff() {
        Light light = new Light("light-1", "Bedroom Light");

        assertEquals("Light is OFF", light.stateLabel());

        light.turnOn();
        assertEquals("Light is ON", light.stateLabel());

        light.turnOff();
        assertEquals("Light is OFF", light.stateLabel());
    }
}

