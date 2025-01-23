package uangbocoran;

public class Monster {
	private String name;
	private int att;
	private int health;
	private int reward;
	public Monster(String name, int att, int health, int reward) {
		super();
		this.name = name;
		this.att = att;
		this.health = health;
		this.reward = reward;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAtt() {
		return att;
	}
	
	public void setAtt(int att) {
		this.att = att;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getReward() {
		return reward;
	}
	
	public void setReward(int reward) {
		this.reward = reward;
	}
	
	
}
