package uangbocoran;

public class Player {
	private int health;
	private int gold;
	private Weapon weapon;
	private Armor armor;
	public Player(int health, int gold, Weapon weapon, Armor armor) {
		super();
		this.health = health;
		this.gold = gold;
		this.weapon = weapon;
		this.armor = armor;
	}

	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}

	public int getGold() {
		return gold;
	}
	
	public void setGold(int gold) {
		this.gold = gold;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public Armor getArmor() {
		return armor;
	}
	public void setArmor(Armor armor) {
		this.armor = armor;
	}
	
	
	
	
}
