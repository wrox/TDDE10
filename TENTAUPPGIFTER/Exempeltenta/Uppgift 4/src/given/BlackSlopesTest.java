package given;

import java.awt.*;

import test.AnchorLift;
import test.HasDifficulty;
import test.OffPistArea;
import test.Slope;
import test.SnowyArea;

/**
 * Created by erini02 on 31/01/17.
 */
public class BlackSlopesTest {

    public static void main(String[] args) {
        Slope anAverageSlope = new Slope(Color.RED);
        SnowyArea area = anAverageSlope;
        HasDifficulty<Color> dif = anAverageSlope;

        AnchorLift anchorLift = new AnchorLift();
        HasDifficulty<Color> dif2 = anchorLift;

        if (anAverageSlope.getDifficulty().equals(anchorLift.getDifficulty())) {
            Color c = anchorLift.getDifficulty();
            System.out.println("Samma svårighetsgrad: " + c);
        }

        OffPistArea off = new OffPistArea(3);
        SnowyArea area2 = off;
        HasDifficulty<Integer> dif3 = off;
        int i = off.getDifficulty();

        //area.getDifficulty();       // FEL, en SnowyArea har inte svårighetsgrad
        //anAverageSlope = anchorLift // FEL, en lift är inte en pist
        //dif2 = dif3;                // FEL, olika typer av svårighetsgrad
        //area = dif;                 // FEL, en HasDifficulty är inte en SnowyArea
        //dif = area;                 // FEL, en SnowyArea är inte en HasDifficulty.

        if (anAverageSlope.getDifficulty().equals(off.getDifficulty())) {
            // VARNING, går ej att jämföra pister med offpistområden.
        }
    }
}
