package missile;

public class UnsignedLaunchCodes implements LaunchCode {
    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean isSigned() {
        return false;
    }
}
