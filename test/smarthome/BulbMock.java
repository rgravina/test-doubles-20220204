package smarthome;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BulbMock implements Bulb {
    private boolean turnOn_wasCalled = false;
    private boolean turnOff_wasCalled = false;

    @Override
    public void turnOn() {
        turnOn_wasCalled = true;
    }

    @Override
    public void turnOff() {
        turnOff_wasCalled = true;
    }

    public boolean turnOnWasCalled() {
        return turnOn_wasCalled;
    }

    public boolean turnOffWasCalled() {
        return turnOff_wasCalled;
    }

    public void verifyTurnedOn() {
        assertTrue(this.turnOnWasCalled());
        assertFalse(this.turnOffWasCalled());
    }

    public void verifyTurnedOff() {
        assertTrue(this.turnOffWasCalled());
        assertFalse(this.turnOnWasCalled());
    }
}
