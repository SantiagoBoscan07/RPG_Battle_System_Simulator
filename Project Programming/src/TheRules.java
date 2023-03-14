import java.io.IOException;
import java.util.Scanner;

public class TheRules  {
	
	public static void Rules() throws IOException
	{
		System.out.println("Rules of Tic Tac Toe:"
				+ "\n1-The game takes place on a 3 by 3 grid where two players will take turns to put a symbol on each empty space."
				+ "\n2-Each player can only put one symbol per turn."
				+ "\n3-Players are not allowed to put symbols on spaces that are already taken."
				+ "\n4-The winner is the first player that manages to put three of the same symbol in a row, either horizontally, vertically or diagonally."
				+ "\n5-If all spaces are taken but none of the players manage to create a winning row, the game ends on a draw. "
				+ "\nAdditional Information:"
				+ "\nAfter each round the winner of the last round will be recorded alongside their winning streak. "
				+ "\nYou can see this information on the High Score section of the main menu."
				+"\n ");
		
		// Set scanner and if...else statement to allow users to go back to the main menu
		System.out.println("Would you like to go back to the main menu? (Y/N)");
		Scanner inputOpt = new Scanner(System.in);
		String option = inputOpt.nextLine();
		if (!option.equals("Y")) 
		{
			System.out.println("Thanks For Playing! Exiting program...");
			System.exit(0);
		}
		else 
		{
			// Calling main menu module
			TicTacToeMainMenu.menu();
		}
		inputOpt.close();
		
	}

}
