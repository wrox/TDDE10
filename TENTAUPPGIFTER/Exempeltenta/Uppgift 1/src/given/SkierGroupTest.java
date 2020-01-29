package given;

import given.SkierGroup;
import snowgoers.Skier;
import snowgoers.SnowGoer;
import snowgoers.Snowboarder;

/**
 * Created by erini02 on 30/01/17.
 */
public class SkierGroupTest {

    public static void main(String[] args) {
        SnowGoer anders = new Skier("Anders", 22, 2);
        Skier katie = new Skier("Katie", 18, 0);
        Snowboarder john = new Snowboarder("John Henry", 34);
        SnowGoer stephen = new Snowboarder("Stephen", 30);

        SkierGroup group = new SkierGroup("Cousins");
        group.add(anders);
        group.add(katie);
        group.add(john);
        group.add(stephen);
        group.remove(anders);

        group.haveFun();
//        Ut på skärmen kommer:
//        Katie, 18 years old
//        Skier with 0 poles
//        Points ski tips towards each other
//        John Henry, 34 years old
//        Snowboarder
//        Swoops in and sprays lots of snow
//        Stephen, 30 years old
//        Snowboarder
//        Swoops in and sprays lots of snow
    }
}
