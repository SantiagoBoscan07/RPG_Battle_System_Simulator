import java.io.*;
import java.util.Scanner;

public class highScore {
	
	static void ScoreKeeper()throws IOException {
		
		// Access to files for high scores
		File pvpScore = new File("C:\\\\temp\\\\highscore.txt");
		File pveScore = new File("C:\\\\temp\\\\highscorePvE.txt");
		
		// Show Options to User
		System.out.println("Choose an option:"
				+ "\n1.Player vs. Player High Scores"
				+ "\n2.Player vs. Computer High Scores"
				+ "\n3.Go Back To Main Menu");
		
		// Set scanner to allow users to access menu options
		Scanner numOpt = new Scanner(System.in);
		Scanner stringOpt = new Scanner(System.in);
		String charOpt;
		int numOption = numOpt.nextInt();
		// Input validation
		while (numOption < 1 || numOption > 3) 
		{
			System.out.println("Invalid input. Please type a number between 1 and 3.");
			numOption = numOpt.nextInt();
		}
		// Switch cases for high score menu
		switch(numOption)
		{
		case 1:
			// Accessing player versus player scores in the console
			Scanner pvpOpt = new Scanner(pvpScore);
			while(pvpOpt.hasNext()) {
				System.out.println(pvpOpt.nextLine());
				System.out.println(" ");
			}
			// Set scanner to allow user go back to the main menu
			System.out.println("Would you like to go back to the main menu? (Y/N)");
			charOpt = stringOpt.nextLine();
			if (!charOpt.equals("Y")) 
			{
				System.out.println("Thanks For Playing! Exiting program...");
				break;
			}
			else 
			{
				// Calling method to go back to the main menu
				TicTacToeMainMenu.menu();
			}
			pvpOpt.close();
			break;
		case 2:
			// Accessing player versus computer scores in the console
			Scanner pveOpt = new Scanner(pveScore);
			while(pveOpt.hasNext()) {
				System.out.println(pveOpt.nextLine());
				System.out.println(" ");
			}
			// Set scanner to allow user go back to the main menu
			System.out.println("Would you like to go back to the main menu? (Y/N)");
			charOpt = stringOpt.nextLine();
			if (!charOpt.equals("Y")) 
			{
				System.out.println("Thanks For Playing! Exiting program...");
				break;
			}
			else 
			{
				// Calling method to go back to the main menu
				TicTacToeMainMenu.menu();
			}
			pveOpt.close();
			break;
		case 3:
			// Calling method to go back to the main menu
			TicTacToeMainMenu.menu();
		}
stringOpt.close();
numOpt.close();
	}
}