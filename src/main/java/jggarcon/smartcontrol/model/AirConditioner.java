package jggarcon.smartcontrol.model;

public class AirConditioner implements Appliance {

    private final String id;
    private final String name;
    private boolean on;
    private int temperatureCelsius;

    public AirConditioner(String id, String name) {
        this.id = id;
        this.name = name;
        this.on = false;
        this.temperatureCelsius = 22;
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
        this.on = true;
    }

    @Override
    public void turnOff() {
        this.on = false;
    }

    @Override
    public String stateLabel() {
        return on ? ("Air Conditioner ON at " + temperatureCelsius + "°C")
                : "Air Conditioner is OFF";
    }

    @Override
    public String getKind() {
        return "AirConditioner";
    }

    public boolean isOn() {
        return on;
    }

    public int getTemperatureC() {
        return temperatureCelsius;
    }

    public void setTemperatureC(int temperatureC) {
        if (temperatureC < 16 || temperatureC > 30) {
            throw new IllegalArgumentException("Temperature must be between 16 and 30°C");
        }
        this.temperatureCelsius = temperatureC;
    }

}
