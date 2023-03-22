
public class PlayerStats {
private double playerHealth, playerAttack, playerDefense, playerSpeed, playerMana;
public double  accuracy, damage, damageMana;
public PlayerStats(double playerHealth, double playerMana, double playerAttack, double playerDefense, double playerSpeed) {
	// Initialize all Stats
	this.playerHealth = playerHealth;
	this.playerMana = playerMana;
	this.playerAttack = playerAttack;
	this.playerDefense = playerDefense;
	this.playerSpeed = playerSpeed;
}

	// Getters and Setters
public double getHealth(){
	return playerHealth;
}

public void setHealth(double playerHealth) {
	this.playerHealth = playerHealth;
}

public double getAttack(){
	return playerAttack;
}

public void setAttack(double playerAttack) {
	this.playerAttack = playerAttack;
}

public double getDefense(){
	return playerDefense;
}

public void setDefense(double playerDefense) {
	this.playerDefense = playerDefense;
}

public double getSpeed(){
	return playerSpeed;
}

public void setSpeed(double playerSpeed) {
	this.playerSpeed = playerSpeed;
}

public double getMana(){
	return playerMana;
}

public void setMana(double playerMana) {
	this.playerMana = playerMana;
}
public void addHealth(double amount) {
	playerHealth += amount;
}
public void addMana(double amount) {
	playerMana += amount;
}
public void addAttack(double amount) {
	playerAttack *= amount;
}
public void addDefense(double amount) {
	playerDefense *= amount;
}
public void addSpeed(double amount) {
	playerSpeed *= amount;
}
public void substractMana(double amount) {
	playerMana -= amount;
}
public void substractHealth(double amount) {
	playerHealth -= amount;
}
}
