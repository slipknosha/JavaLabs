package defaultdroid;
import droid.Droid;

public class DefaultDroid extends Droid {

    private final int defaultWeapon = 25;

    public DefaultDroid() { }

    public int getDefaultWeapon() {
        return defaultWeapon;
    }
}
