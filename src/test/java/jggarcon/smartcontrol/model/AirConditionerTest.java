package jggarcon.smartcontrol.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AirConditionerTest {

    @Test
    void testTurnOnAndOff() {
        AirConditioner ac = new AirConditioner("ac-1", "John's Bedroom AC");

        assertEquals("Air Conditioner is OFF", ac.stateLabel());

        ac.turnOn();
        ac.setTemperatureC(22);
        assertEquals("Air Conditioner set to 22°C", ac.stateLabel());

        ac.setTemperatureC(28);
        assertEquals("Air Conditioner set to 28°C", ac.stateLabel());

        ac.turnOff();
        assertEquals("Air Conditioner is OFF", ac.stateLabel());
    }
}

