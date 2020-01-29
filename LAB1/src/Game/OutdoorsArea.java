/*
 * Class: OutdoorsArea
 * 
 * Version: 1.0
 * 
 * 25/1 -17
 */

package Game;

import java.util.Random;

public class OutdoorsArea extends Location {

	private String weather;

	public OutdoorsArea (String name, String description, String descriptionShort) {
		super(name, description, descriptionShort);
	}

	private static int randInt() {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(7);
	}
	
	private static String randomWeather() {
		final String sunnyCool = "The pale sun is pale and a cool breeze carresses your skin.";
		final String sunnyHot = "The sun is strong and bright, heating your surroundings up to a near unbearable temperature.\nYou should probably put some sunscreen on..";
		final String cloudyWind = "Clouds have taken over the sky and the wind has started to gain strenght. Maybe it will storm?";
		final String cloudyStorm = "The clouded sky is accompanied by strong winds almost lifting you up from the ground. Atleast there is no such thing as an umbrella in this game..";
		final String snowyCalm = "Snow has started to fall, gently, towards the ground. It all should feel very peacefull.";
		final String snowyStorm = "The snow has turned in to hard pellets of ice, almost piercing the skin on your face as the wind\nthrows them at you with a tremendous velocity.";
		final String rainyCalm = "A drizzle of rain slowly soakes the pieces clothing you are wearing.";
		final String rainyStorm = "The rain completely soakes your clothing. It's raining cats and dogs to say the least.";
		
		String[] weatherArray = new String[8];
		weatherArray[0] = sunnyCool;
		weatherArray[1] = sunnyHot;
		weatherArray[2] = cloudyWind;
		weatherArray[3] = cloudyStorm;
		weatherArray[4] = snowyCalm;
		weatherArray[5] = snowyStorm;
		weatherArray[6] = rainyCalm;
		weatherArray[7] = rainyStorm;
											
		return weatherArray[randInt()];

	}

	public void introduceYourself() {
		this.weather = randomWeather();
		super.introduceYourself();
		System.out.println(this.weather);
	}
}


