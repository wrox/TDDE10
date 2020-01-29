import java.util.Scanner;

import given.LiftPass;

public class FamilyPass extends LiftPass{
	String[] pnrs;

	public FamilyPass(int memberCount) {
		super((200*memberCount), 7); // cost * memberCount, days to be active
		String[] pnrs = new String[memberCount];
		
		Scanner sc = new Scanner(System.in);
		
		for (int a = 0; a < pnrs.length; a++) {
			System.out.println("Slå in ett giltigt personnr (ÅÅMMDD-NNNN): ");
			String input = sc.nextLine();
			for (String pnr : pnrs) {
				if (pnr != null && pnr.equals(input)) {
					throw new DuplicatePersonNumberException("Det fanns redan ett sådant personnr i listan. Försök igen.");
				} else {
					pnrs[a] = input;
				}
			}
		}
		System.out.println("Tack. Priset för ert veckopass som inkluderar " + pnrs.length + " personer är " + (200*memberCount) + " SEK.");
		sc.close();
	}
	
	public static void main(String[] args) {
		FamilyPass fp = new FamilyPass(5);
	}
}
