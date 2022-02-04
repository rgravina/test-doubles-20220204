package smarthome;

import org.junit.jupiter.api.Test;

class SmartHomeTest {
    @Test
    void whenSwitchIsOn_turnsOnLightBulb() {
        Switch toggle = new AlwaysOnSwitch();
        BulbMock bulb = new BulbMock();

        new SmartHome().run(bulb, toggle);

        bulb.verifyTurnedOn();
    }

    @Test
    void whenSwitchIsOff_turnsOffLightBulb() {
        Switch toggle = new AlwaysOffSwitch();
        BulbMock bulb = new BulbMock();

        new SmartHome().run(bulb, toggle);

        bulb.verifyTurnedOff();
    }
}