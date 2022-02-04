package missile;

public class FakeUsedLaunchCodesTest extends UsedLaunchCodesContract {
    @Override
    protected UsedLaunchCodes createUsedLaunchCodes() {
        return new FakeUsedLaunchCodes();
    }
}
