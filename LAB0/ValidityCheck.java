//import java.util.Scanner;

public class ValidityCheck {

    public static int checkNr(String personNr, Integer multiplyAmount, Integer i) {
	int number = 0;
	int result = 0;

	char c = personNr.charAt(i);
	number = c - '0';
	result = multiplyAmount * number;
	if (result > 9) {
	    // Denna raden gör allt nedan.
	    //result -= 9;
	    // Slut på raden.
	    char charA = String.valueOf(result).charAt(0);
	    char charB = String.valueOf(result).charAt(1);
	    //int x = a - '0';
	    //int y = b - '0';
	    int intA = Character.digit(charA, 10);
	    int intB = Character.digit(charB, 10);
	    result = intA + intB;
	}
	return result;
    }

    public static boolean isValidSSNR(String personNr) {
	boolean isMultipliedByOne = true;
	int[] result = new int[10];
	int sum = 0;

        if (personNr.length() != 10) {
	    return false;
	}

        for(int i=0; i<10; i++) {
	    if (i % 2 == 0) { // Om jämn
		result[i] = checkNr(personNr, 2, i);
		isMultipliedByOne = !isMultipliedByOne;
	    } else {
		result[i] = checkNr(personNr, 1, i);
		isMultipliedByOne = !isMultipliedByOne;
	    }
	    //sum = sum + result[i];
	    sum += result[i];
        }
	return (sum % 10) == 0;
    }

    public static void main(String[] args) {
	System.out.print("Slå in ditt personnummer: ");
	//Scanner sc = new scanner(System.in)
	//String personNr = sc.next(); 
	//sc.close();
	String personNr = System.console().readLine();
	System.out.println("Ditt personummer är: " + personNr);

	if (isValidSSNR(personNr)) {
	    System.out.println("Giltigt nummer.");
	} else {
	    System.out.println("Ej ett giltigt nummer.");
	}
    }

}
