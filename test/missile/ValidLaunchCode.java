package missile;

public class ValidLaunchCode implements LaunchCode {
    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean isSigned() {
        return true;
    }
}
