package jggarcon.smartcontrol.model;

public class Light implements Appliance{

    private final String id;
    private final String name;
    private boolean isOn;

    public Light(String id, String name) {
        this.id = id;
        this.name = name;
        this.isOn = false;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void turnOn() {
        isOn = true;
    }

    @Override
    public void turnOff() {
        isOn = false;
    }

    @Override
    public String stateLabel() {
        return isOn ? "Light is ON" : "Light is OFF";
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public String getKind() {
        return "Light";
    }

}
