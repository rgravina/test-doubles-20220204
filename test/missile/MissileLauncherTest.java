package missile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static missile.MissileLauncher.launchMissile;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MissileLauncherTest {
    private FakeUsedLaunchCodes usedLaunchCodes;

    @BeforeEach
    void setUp() {
        usedLaunchCodes = new FakeUsedLaunchCodes();
    }

    @Test
    void givenExpiredLaunchCodes_doesNotFireMissile_usingDummy() {
        LaunchCode expiredLaunchCodes = new ExpiredLaunchCodes();
        Missile missile = new DummyMissile();

        launchMissile(missile, expiredLaunchCodes, usedLaunchCodes);
    }

    @Test
    void givenExpiredLaunchCodes_doesNotFireMissile_usingSpy() {
        LaunchCode expiredLaunchCodes = new ExpiredLaunchCodes();
        MockMissile missile = new MockMissile();

        launchMissile(missile, expiredLaunchCodes, usedLaunchCodes);

        missile.verifyCodeRedAbort();
    }

    @Test
    void givenUnsignedLaunchCodes_doesNotFireMissile_usingSpy() {
        LaunchCode unsignedLaunchCodes = new UnsignedLaunchCodes();
        MockMissile missile = new MockMissile();

        launchMissile(missile, unsignedLaunchCodes, usedLaunchCodes);

        missile.verifyCodeRedAbort();
    }

    @Test
    void givenValidLaunchCodes_callsLaunch() {
        LaunchCode validLaunchCodes = new ValidLaunchCode();
        MockMissile missile = new MockMissile();

        launchMissile(missile, validLaunchCodes, usedLaunchCodes);

        assertTrue(missile.launchWasCalled());
    }

    @Test
    void givenReusedLaunchCodes_codeRedAbort() {
        LaunchCode validLaunchCodes = new ValidLaunchCode();
        MockMissile missile = new MockMissile();

        launchMissile(new MockMissile(), validLaunchCodes, usedLaunchCodes);
        launchMissile(missile, validLaunchCodes, usedLaunchCodes);

        missile.verifyCodeRedAbort();
    }
}