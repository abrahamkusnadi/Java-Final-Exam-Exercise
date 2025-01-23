package uangbocoran;

public class Armor extends Equipment {
	private int defense;

	public Armor(String name, int price, String type, int defense) {
		super(name, price, type);
		this.defense = defense;
	}
	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
	@Override
	public int getStat() {
		return defense;
	}
	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		
	}
	
	
}
