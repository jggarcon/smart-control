package jggarcon.smartcontrol.model;

public class Fan implements Appliance {

    private final String id;
    private final String name;
    private int speed;

    public Fan(String id, String name) {
        this.id = id;
        this.name = name;
        this.speed = 0;
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
        speed = 1;
    }

    @Override
    public void turnOff() {
        speed = 0;
    }

    @Override
    public String stateLabel() {
        return switch (speed) {
            case 0 -> "Fan is OFF";
            case 1 -> "Fan speed LOW";
            case 2 -> "Fan speed HIGH";
            default -> "Unknown state";
        };
    }

    public void setSpeed(int speed) {
        if (speed < 0 || speed > 2) {
            throw new IllegalArgumentException("Speed must be 0, 1, or 2");
        }
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String getKind() {
        return "Fan";
    }

}
