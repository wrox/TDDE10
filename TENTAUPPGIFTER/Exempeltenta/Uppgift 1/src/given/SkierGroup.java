package given;

import snowgoers.SnowGoer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by erini02 on 30/01/17.
 */
public class SkierGroup  {
    private final String name;
    private ArrayList<SnowGoer> snowGoerData = new ArrayList<>();

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
    
	public void add(SnowGoer person) {
		snowGoerData.add(person);
		
	}

	public void remove(SnowGoer person) {
		snowGoerData.remove(person);
	}
	
    public void haveFun()  {
    	for (SnowGoer snowGoer : snowGoerData) {
    		snowGoer.printYourself();
    		snowGoer.slowDown();
    	}
    }
}
