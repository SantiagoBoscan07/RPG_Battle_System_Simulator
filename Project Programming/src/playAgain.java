import java.io.IOException;
import java.util.Scanner;

public class playAgain {
	public static void pveAgain() throws IOException {
		boolean runProgram = true;
		Scanner inputTry = new Scanner (System.in);
		while (runProgram) {
				System.out.println("Would you like to play again? (Y/N)");
				String option = inputTry.nextLine();
				if (!option.equals("Y")) 
				{
					System.out.println("Thanks for playing! Exiting program...");
					runProgram = false;
				}
				else 
				{
				PvE.game();
				}
			}
		inputTry.close();
		}
	
	public static void pvpAgain() throws IOException {
		boolean runProgram = true;
		Scanner inputTry2 = new Scanner (System.in);
		while (runProgram) {
				System.out.println("Would you like to play again? (Y/N)");
				String option = inputTry2.nextLine();
				if (!option.equals("Y")) 
			{
				System.out.println("Thanks for playing! Exiting program...");
				runProgram = false;
			}
			else 
			{
			PvP.game();
			}
		}
	inputTry2.close();
	}
}
