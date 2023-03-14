import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TicTacToeMainMenu {

	public static void main(String[] args) throws IOException {
		
		// Introduce Program 
		System.out.println("Welcome to Tic Tac Toe!"
				+ "\nType a number to get access to the different sections of the program.");
		TicTacToeMainMenu.score();
		// Accessing method for the menu
		TicTacToeMainMenu.menu();
	}
	
	public static void score()  throws IOException {
		// Access Score Files 
		File pvpScore = new File("C:\\\\temp\\\\highscore.txt");
		pvpScore.getParentFile().mkdirs();
		pvpScore.createNewFile();
		File pveScore = new File("C:\\\\temp\\\\highscorePvE.txt");
		pveScore.getParentFile().mkdirs();
		pveScore.createNewFile();
	}
	
	public static void menu() throws IOException {

		
		System.out.println("Choose an option (1-5):"
				+ "\n1.Rules"
				+ "\n2.Play against Computer"
				+ "\n3.Play a 2 player Game"
				+ "\n4.See high Score"
				+ "\n5.Quit");
		
		// Set Scanner for User to Type Option
		Scanner inputOpt = new Scanner(System.in);
		int option = inputOpt.nextInt();
		// Input validation for options
		while (option < 1 || option > 5) 
		{
			System.out.println("Invalid input. Please type a number between 1 and 5.");
			option = inputOpt.nextInt();
		}
		// Switch case to access the different parts of the program
		switch(option)
		{
		case 1:
			// Calling method for the rules module
			TheRules.Rules();
			break;
		case 2:
			// Calling method for the player versus computer module
			PvE.game();
			playAgain.pveAgain();
			break;
		case 3:
			// Calling method for the player versus player module
			PvP.game();
			playAgain.pvpAgain();
			break;
		case 4:
			// Calling method for the high score module
			highScore.ScoreKeeper();
			break;
		case 5:
			System.out.println("Thanks For Playing! Exiting program...");
			break;
			
		}
		inputOpt.close();	
	}
}
