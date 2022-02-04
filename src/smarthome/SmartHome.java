package smarthome;

public class SmartHome {
    public void run(Bulb bulb, Switch toggle) {
        if (toggle.isOn()) {
            bulb.turnOn();
        } else {
            bulb.turnOff();
        }
    }
}
