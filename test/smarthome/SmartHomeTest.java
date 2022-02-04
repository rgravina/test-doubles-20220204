package smarthome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SmartHomeTest {
    @Test
    void whenSwitchIsOn_turnsOnLightBulb() {
        Switch toggle = new AlwaysOnSwitch();
        BulbSpy bulb = new BulbSpy();

        new SmartHome().run(bulb, toggle);

        assertTrue(bulb.turnOnWasCalled());
    }
}