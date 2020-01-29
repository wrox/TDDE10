package given;

import snowgoers.SnowGoer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by erini02 on 30/01/17.
 */
public class SkierGroup  {
    private final String name;

    public SkierGroup(String a) {
        this.name = a;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[ " + getName() + "]";
    }
}
