package jggarcon.smartcontrol.model;

public interface Appliance {

    String getId();

    String getName();

    void turnOn();

    void turnOff();

    String stateLabel();

    String getKind();
}
