package def;

import java.util.ArrayList;
import java.util.List;

public class GlassCounter {

    private List<Cookie> onDisplay;

    public GlassCounter() {
        onDisplay = new ArrayList<>();
    }

    public void add(Cookie c) {
        onDisplay.add(c);
    }

    public int noOfCookies() {
        return onDisplay.size();
    }

	public Cookie bakeNew(int selection) {
		return onDisplay.get(selection-1).bakeNew();
	}

}
