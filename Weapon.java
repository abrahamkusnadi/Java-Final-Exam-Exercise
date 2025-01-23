package uangbocoran;

public class Weapon extends Equipment {
	private int damage;

	public Weapon(String name, int price, String type, int damage) {
		super(name, price, type);
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	@Override
	public int getStat() {
		return damage;
	}

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
