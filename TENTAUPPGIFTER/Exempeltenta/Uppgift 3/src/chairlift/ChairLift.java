package chairlift;

import given.SkierGroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChairLift {
	List<SkierGroup> lift = new LinkedList<SkierGroup>();

	public ChairLift(int groupCount) { //max antal grupper samtidigt som kan åka upp

	}

	public List<SkierGroup> runSteps(int count, List<SkierGroup> group) {
//        for (Iterator<SkierGroup> iterate = this.lift.iterator(); iterate.hasNext();) {
//            SkierGroup itLift = iterate.next();
//            if (itLift.equals(group)) {
//                    iterate.next();
//                    System.out.println(iterate);
//            }
//        }
		
		return lift;
	}

	public List<SkierGroup> runSteps(int count) {
		return lift;
	}
}
