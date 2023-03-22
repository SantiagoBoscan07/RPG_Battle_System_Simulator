
public class EnemyStats {
	private double enemyHealth, enemyAttack, enemyDefense, enemySpeed, enemyMana;
	public double accuracy, damage;
	public EnemyStats(double enemyHealth, double enemyMana, double enemyAttack, double enemyDefense, double enemySpeed) {
		// Initialize all Stats
		this.enemyHealth = enemyHealth;
		this.enemyMana = enemyMana;
		this.enemyAttack = enemyAttack;
		this.enemyDefense = enemyDefense;
		this.enemySpeed = enemySpeed;
	}

		// Getters and Setters
	public double getHealth(){
		return enemyHealth;
	}

	public void setHealth(double playerHealth) {
		this.enemyHealth = playerHealth;
	}

	public double getAttack(){
		return enemyAttack;
	}

	public void setAttack(double playerAttack) {
		this.enemyAttack = playerAttack;
	}

	public double getDefense(){
		return enemyDefense;
	}

	public void setDefense(double playerDefense) {
		this.enemyDefense = playerDefense;
	}

	public double getSpeed(){
		return enemySpeed;
	}

	public void setSpeed(double playerSpeed) {
		this.enemySpeed = playerSpeed;
	}

	public double getMana(){
		return enemyMana;
	}

	public void setMana(double playerMana) {
		this.enemyMana = playerMana;
	}
	public void substractHealth(double amount) {
		enemyHealth -= amount;
	}
	public void addSpeed(double amount) {
		enemySpeed *= amount;
	}
	public void addHealth(double amount) {
		enemyHealth += amount;
	}
}