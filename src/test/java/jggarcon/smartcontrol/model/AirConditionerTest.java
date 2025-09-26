package jggarcon.smartcontrol.model;


import jggarcon.smartcontrol.model.AirConditioner.Mode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirConditionerTest {

    @Test
    void testTurnOnAndOff() {
        AirConditioner ac = new AirConditioner("ac-1", "Bedroom AC");

        assertEquals("Air Conditioner is OFF", ac.stateLabel());

        ac.turnOn();
        assertEquals("Air Conditioner COOL mode", ac.stateLabel());

        ac.setMode(Mode.HEAT);
        assertEquals("Air Conditioner HEAT mode", ac.stateLabel());

        ac.turnOff();
        assertEquals("Air Conditioner is OFF", ac.stateLabel());
    }
}

