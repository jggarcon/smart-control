package jggarcon.smartcontrol.model;

public class AirConditioner implements  Appliance{

    public enum Mode {
        OFF, COOL, HEAT, FAN_ONLY
    }

    private final String id;
    private final String name;
    private Mode mode;

    public AirConditioner(String id, String name) {
        this.id = id;
        this.name = name;
        this.mode = Mode.OFF;
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
        mode = Mode.COOL; // default ON mode
    }

    @Override
    public void turnOff() {
        mode = Mode.OFF;
    }

    @Override
    public String stateLabel() {
        return switch (mode) {
            case OFF -> "Air Conditioner is OFF";
            case COOL -> "Air Conditioner COOL mode";
            case HEAT -> "Air Conditioner HEAT mode";
            case FAN_ONLY -> "Air Conditioner FAN_ONLY mode";
        };
    }
    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Mode getMode() {
        return mode;
    }
}
