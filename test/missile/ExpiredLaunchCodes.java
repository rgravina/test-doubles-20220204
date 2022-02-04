package missile;

public class ExpiredLaunchCodes implements LaunchCode {
    @Override
    public boolean isExpired() {
        return true;
    }

    @Override
    public boolean isSigned() {
        return true;
    }
}
