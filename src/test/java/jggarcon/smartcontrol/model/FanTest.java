package jggarcon.smartcontrol.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FanTest {

    @Test
    void testTurnOnAndOff() {
        Fan fan = new Fan("fan-1", "Living Room Fan");

        assertEquals("Fan is OFF", fan.stateLabel());

        fan.turnOn();
        assertEquals("Fan speed LOW", fan.stateLabel());

        fan.setSpeed(2);
        assertEquals("Fan speed HIGH", fan.stateLabel());

        fan.turnOff();
        assertEquals("Fan is OFF", fan.stateLabel());
    }

    @Test
    void testInvalidSpeedThrowsException() {
        Fan fan = new Fan("fan-1", "Living Room Fan");
        assertThrows(IllegalArgumentException.class, () -> fan.setSpeed(3));
    }
}
