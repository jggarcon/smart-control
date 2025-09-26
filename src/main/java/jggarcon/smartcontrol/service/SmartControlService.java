package jggarcon.smartcontrol.service;

import jggarcon.smartcontrol.model.AirConditioner;
import jggarcon.smartcontrol.model.Appliance;
import jggarcon.smartcontrol.model.Fan;
import jggarcon.smartcontrol.model.Light;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class SmartControlService {

    private final Map<String, Appliance> devices = new LinkedHashMap<>();

    public SmartControlService() {
        devices.put("light-1", new Light("light-1", "John's Bedroom Light"));
        devices.put("fan-1", new Fan("fan-1", "Living Room Ceiling Fan"));
        devices.put("ac-1", new AirConditioner("ac-1", "John's Bedroom AC"));
    }

    public Collection<Appliance> getAll() {
        return devices.values();
    }

    public Appliance getById(String id) {
        return devices.get(id);
    }

    public void toggleLight(String id) {
        Appliance a = devices.get(id);
        if(a instanceof Light light) {
            if(light.isOn()) {
                light.turnOff();
            } else {
                light.turnOn();
            }
        } else {
            throw new IllegalArgumentException("Light is not on");
        }
    }

    public void setFanSpeed(String id, int speed) {
        Appliance a = devices.get(id);
        if (a instanceof Fan fan) {
            fan.setSpeed(speed);
        } else {
            throw new IllegalArgumentException("Device " + id + " is not a Fan");
        }
    }

    public void setAcPower(String id, boolean on) {
        Appliance a = devices.get(id);
        if (a instanceof AirConditioner ac) {
            if (on) ac.turnOn(); else ac.turnOff();
        } else {
            throw new IllegalArgumentException("Device " + id + " is not an AirConditioner");
        }
    }

    public void setAcTemperature(String id, int tempC) {
        Appliance a = devices.get(id);
        if (a instanceof AirConditioner ac) {
            ac.setTemperatureC(tempC);
        } else {
            throw new IllegalArgumentException("Device " + id + " is not an AirConditioner");
        }
    }
}

