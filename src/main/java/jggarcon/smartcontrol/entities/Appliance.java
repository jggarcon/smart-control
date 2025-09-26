package jggarcon.smartcontrol.entities;

public interface Appliance {

    String getId();

    String getName();

    void turnOn();

    void turnOff();

    String stateLabel();
}
