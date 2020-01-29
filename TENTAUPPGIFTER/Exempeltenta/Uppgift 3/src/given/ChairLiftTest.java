package given;

import chairlift.ChairLift;

import java.util.ArrayList;
import java.util.List;

public class ChairLiftTest {

    public static void main(String[] args) {
        System.out.println("Testing lift");
        ChairLift lift = new ChairLift(8);   // max 8 grupper kan åka upp samtidigt
        // vi kan rita detta så här:
        // []-[]-[]-[]-[]-[]-[]-[]-

        List<SkierGroup> groups = new ArrayList<>();
        groups.add(new SkierGroup("A"));
        groups.add(new SkierGroup("B"));
        groups.add(new SkierGroup("C"));

        lift.runSteps(5, groups);  // Grupp A, B och C kliver på, två sitsar tomma.
        // []-[]-[C]-[B]-[A]-[]-[]-[]-

        lift.runSteps(2);          // två sitsar till blir tomma.
        // []-[]-[]-[]-[C]-[B]-[A]-[]-

        groups.add(new SkierGroup("D"));
        groups = lift.runSteps(2, groups); // Grupp D kliver på, en sits till
                                           // blir tom, A kliver av.
        // []-[D]-[]-[]-[]-[]-[C]-[B]-

        groups = lift.runSteps(3);      // Tre sitsar till blir tomma, B kliver av,
                                        // C kliver av, en tom sits kommer upp.
        // []-[]-[]-[]-[D]-[]-[]-[]-

        for (SkierGroup sg : groups) {
            System.out.print(sg.getName() + " ");  // ut på skärmen kommer "B C "
        }
    }
}
