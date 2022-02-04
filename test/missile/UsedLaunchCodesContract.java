package missile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class UsedLaunchCodesContract {
    private UsedLaunchCodes usedLaunchCodes;
    protected abstract UsedLaunchCodes createUsedLaunchCodes();

    @BeforeEach
    void setUp() {
        usedLaunchCodes = createUsedLaunchCodes();
    }

    @Test
    void contains() {
        LaunchCode validLaunchCode = new ValidLaunchCode();
        assertFalse(usedLaunchCodes.contains(validLaunchCode));
        usedLaunchCodes.add(validLaunchCode);
        assertTrue(usedLaunchCodes.contains(validLaunchCode));
    }
}
