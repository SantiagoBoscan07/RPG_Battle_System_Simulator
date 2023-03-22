import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
public class BattleTest {
	static Scanner scanner = new Scanner(System.in);
	static Random random = new Random();
	static boolean endTurn;
	static boolean enemyEndTurn;
	static boolean escape;
	public static void main(String[] args) {
		EnemyStats enemyStats = new EnemyStats(500, 40, 10, 10, 15);
		PlayerStats playerStats = new PlayerStats(500, 100, 10, 50, 15);
		escape = false;
		// Battle Loop
		while (playerStats.getHealth() > 0 && enemyStats.getHealth() > 0 && !escape) {
		// Boolean to Begin Turn
		endTurn = false;
		enemyEndTurn = false;
		//Display Battle Information
			System.out.println("\n"
				+ "Player Turn Begins!"
				+"\n");
			System.out.println("Player Health is: " + playerStats.getHealth());
			System.out.println("Player Mana is: " + playerStats.getMana());
			System.out.println("Enemy Health is: " + enemyStats.getHealth());
			System.out.println("Enemy Speed is: " + enemyStats.getSpeed());
			System.out.println("Player Attack is: " + playerStats.getAttack());
			System.out.println("Player Defense is: " + playerStats.getDefense());
			System.out.println("Player Speed is: " + playerStats.getSpeed());		
		// Player's Turn Prompt 
			System.out.println("What would you do? (Please type a number 1-6)");
			System.out.println(" 1.Attack"
					+ "\n 2.Heal (50 Mana)"
					+ "\n 3.Increase Attack (20 Mana)"
					+"\n 4.Increase Defense (10 Mana)"
					+ "\n 5.Increase Speed (5 Mana)"
					+"\n 6.Run Away");
		// Scanner to Allow User to Make a Choice // Call Function for Player's Turn // Loop to Check when Turn Begins and Ends
		while (!endTurn) {
		String playerChoice = scanner.next();
		playerTurn(playerChoice, playerStats, enemyStats);
		}
		// Call Function for Enemy's Turn // Loop to Check when Enemy Turn Begins and Ends
		while (!enemyEndTurn) {
		enemyTurn(playerStats, enemyStats);
		}
	}
		scanner.close();
}
	
	public static void playerTurn (String playerChoice, PlayerStats playerStats, EnemyStats enemyStats) {
		// Random Damage Value for Player and Enemy
				int playerRandomVal = random.nextInt(50)+1;
				// Escape Random Value
				int escRandomValue = random.nextInt(10)+1;
		switch (playerChoice)
		{
		case "1":
			// User Decides to Attack
	// Accuracy Formula
				playerStats.accuracy =(100)*((playerStats.getSpeed())/(playerStats.getSpeed() + enemyStats.getSpeed()));
				System.out.println("Accuracy is " +playerStats.accuracy);
	// Random Accuracy Stat
				int randomAccuracy = random.nextInt(100);
	// Attack is successful 
	if (randomAccuracy < Math.round(playerStats.accuracy)) {
		// Damage Formula
		if (playerStats.getAttack() >= enemyStats.getDefense()) {
			playerStats.damage = Math.round(((Math.round(playerStats.getAttack()) * 2) - enemyStats.getDefense()) * (playerRandomVal));
		} else {
			playerStats.damage = Math.round((Math.round(playerStats.getAttack()) * Math.round(playerStats.getAttack()) / enemyStats.getDefense() ) * (playerRandomVal));
		}
		enemyStats.substractHealth(playerStats.damage);
	// Mana Recover Formula
		playerStats.damageMana = Math.round((playerStats.damage * 10) / 100);
		if (playerStats.damageMana == 0) {
			playerStats.damageMana = 1;
		}
		playerStats.addMana(playerStats.damageMana);
		System.out.println("Your attack landed!"
				+ "\nDamage dealt: " + playerStats.damage +" !"
						+ "\nEnemy health is now " + enemyStats.getHealth() +
						"\n ");
	// Check if Enemy is Defeated
		if (enemyStats.getHealth() <= 0) {
			System.out.println("The Enemy Was Defeated!");
			enemyEndTurn = true;
		}
		endTurn = true;
		}
	// Attack failed
	else {
		System.out.println("Your attack missed!");
		endTurn = true;
	}
				break;
		case "2":
			// Heal Command
				// Check if Player has Enough Mana
				if (playerStats.getMana() < 50) {
					System.out.println("Not Enough Mana!"
							+ "\nPlease type another option (1-6)"
							+"\n");
				}
	// Heal successfully 
				else if (playerStats.getMana() >= 50) {
					playerStats.addHealth(50);
					playerStats.substractMana(50);
		System.out.println("You Healed 50 Health Points!");	
		endTurn = true;
			}
		break;
		case "3":
			// Attack Buff Command 
				// Check if Player has Enough Mana
			if (playerStats.getMana() < 20) {
				System.out.println("Not Enough Mana!"
						+ "\nPlease type another option (1-6)"
						+"\n");
			}
			// Attack Buff Successfully 
			else if (playerStats.getMana() >= 20) {
				playerStats.addAttack(1.5);
				playerStats.substractMana(20);
	System.out.println("Your Attack Increased!"
			+ "\n");		
	endTurn = true;
	}
		break;
		case "4":
			// Defense Buff Command
				// Check if Player has Enough Mana
				if (playerStats.getMana() < 10) {
					System.out.println("Not Enough Mana!"
							+ "\nPlease type another option (1-6)"
							+"\n");
				}
	// Defense Buff Successfully 
				else if (playerStats.getMana() >= 10) {
					playerStats.addDefense(1.5);
					playerStats.substractMana(10);
		System.out.println("Your Defense Increased!"
				+ "\n");
	endTurn = true;
		}	
				break;
		case "5":
			// Speed Buff Command
				// Check if Player has Enough Mana
				if (playerStats.getMana() < 5) {
					System.out.println("Not Enough Mana!"
							+ "\nPlease type another option (1-6)"
							+"\n");
				}
	// Speed Buff Successfully 
				else if (playerStats.getMana() >= 5) {
					playerStats.addSpeed(1.5);
					playerStats.substractMana(5);
		System.out.println("Your Speed Increased!"
				+ "\n");	
	endTurn = true;
		}
				break;
		case "6":
			// Escape Command
	// If Player Has Higher Speed than Enemy it is a Guaranteed Escape
			while (playerStats.getSpeed() > enemyStats.getSpeed()) {
				System.out.println("You Ran Away Safely!");
				escape = true;
				endTurn = true;
				enemyEndTurn = true;
			}
	// Otherwise There is a Roll Dice to Decide the Escape
			if (escRandomValue < 5) {
				System.out.println("Escape Failed!"
						+"\n");
				endTurn = true;
			} else {
				System.out.println("You Ran Away Safely!");
				escape = true;
				endTurn = true;
				enemyEndTurn = true;
			}
			break;
		default:
	// Input Validation 
			System.out.println("Invalid input, please type a number 1-6");
			break;
		}
				}
	
	public static void enemyTurn (PlayerStats playerStats, EnemyStats enemyStats) {
		int enemyRandomVal = random.nextInt(50)+1;
		int enemyBehaviorVal = random.nextInt(3)+1;
		// Enemy's Turn
		System.out.println("\n"
				+ "Enemy Turn Begins!"
				+"\n");
		switch (enemyBehaviorVal) {
		case 1:
			// Enemy Decides to Attack
		// Accuracy Formula
			enemyStats.accuracy =(100)*((enemyStats.getSpeed())/(playerStats.getSpeed() + enemyStats.getSpeed()));
			System.out.println("Accuracy is " +enemyStats.accuracy);
// Random Accuracy Stat
			int randomAccuracy = random.nextInt(100);
// Attack is successful 
if (randomAccuracy < Math.round(enemyStats.accuracy)) {
	// Damage Formula
	if (enemyStats.getAttack() >= playerStats.getDefense()) {
		enemyStats.damage = Math.round(((Math.round(enemyStats.getAttack()) * 2) - playerStats.getDefense()) * (enemyRandomVal));
	} else {
		enemyStats.damage = Math.round((Math.round(enemyStats.getAttack()) * Math.round(enemyStats.getAttack()) / playerStats.getDefense() ) * (enemyRandomVal));
	}
	playerStats.substractHealth(enemyStats.damage);
	System.out.println("The Enemy Attack Landed!"
			+ "\nYou received " + enemyStats.damage +" damage."
					+ "\nYour Total Health is " + playerStats.getHealth()
					+"\n");
	enemyEndTurn = true;
		}
//Attack failed
	else {
		System.out.println("The Enemy Attack Failed!");
		enemyEndTurn = true;
	}
				break;
		case 2:
		// Enemy Decides to Increase their Speed
			System.out.println("The Enemy Raised Their Speed!");
			enemyStats.addSpeed(1.5);
			enemyEndTurn = true;
			break;
		case 3:
		// Enemy Decides to Perform Special Move
			System.out.println("The Enemy Drained Your Health!");
			enemyStats.damage = Math.round((enemyStats.getAttack()) / (enemyRandomVal));
			playerStats.substractHealth(enemyStats.damage);
			enemyStats.addHealth(Math.round((enemyStats.damage * 50) / 100));
			System.out.println(enemyStats.damage + " Health Points Were Drained!"
					+ "\n");
			enemyEndTurn = true;
			break;
	}
				}
}
				


