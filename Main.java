package uangbocoran;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static ArrayList<Equipment> eqList = new ArrayList<>();
	public static ArrayList<Monster> mList = new ArrayList<>();
	public static void main(String[] args) {
		Random random = new Random();
		Player p = new Player(150, 100, new Weapon("Iron Sword", 0, "Weapon", 25), new Armor("Iron Chest Guard", 0, "Armor", 15));
		
		
		eqList.add(new Weapon("Silver Sword", 30, "Weapon", 50));
		eqList.add(new Weapon("Wyvern Piercer", 40, "Weapon", 60));
		eqList.add(new Weapon("Dark Moon Great Sword", 80, "Weapon", 100));
		eqList.add(new Armor("Siver Chest Guard", 30, "Armor", 30));
		eqList.add(new Armor("Primal Cuirass of the Forests", 40, "Armor", 40));
		eqList.add(new Armor("Blessed Mithril Armor of Silent Glory", 80, "Armor", 80));
		
		mList.add(new Monster("Raging Bull", 100, 200, 40));
		mList.add(new Monster("Monster Bunny", 110, 250, 50));
		mList.add(new Monster("Emperor class Elder Dragon", 200, 400, 100));

		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		do {
			System.out.println("1. Buy Equipment");
			System.out.println("2. Fight Monster");
			System.out.println("3. Exit");
			System.out.print("Choose: ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1:
				eqMenu(p, sc);
				System.out.println("Press enter to continue!");
				sc.nextLine();
				break;
			case 2:
				fightMonster(p, sc, random);
				System.out.println("Press enter to continue!");
				sc.nextLine();
				break;
			}
			
		}while(choice != 3);
	}
	
	private static void eqMenu(Player player, Scanner sc) {
		System.out.println("============================================================================================================");
		System.out.printf("|%-5s|%-50s|%-15s|%-15s|%-15s|\n", "No", "Name", "Price", "Atk/Def", "Type");
		System.out.println("============================================================================================================");
		
		int idx = 1;
		int choice = 0;
		
		for(Equipment eq : eqList) {
			System.out.printf("|%-5d|%-50s|%-15d|%-15d|%-15s|\n", idx, eq.getName(), eq.getPrice(), eq.getStat(), eq.getType());
			idx++;
		}
		System.out.println("============================================================================================================");

		System.out.printf("Choose Equipment to buy [your gold : %d]: ", player.getGold());

		choice = sc.nextInt();
		sc.nextLine();
		
		Equipment selected = eqList.get(choice - 1);
		
		if(selected.getPrice() > player.getGold()) {
			System.out.println("Not enough Gold");
			return;
		}else {
			if(selected instanceof Weapon) {
				player.setWeapon((Weapon) selected);
				System.out.printf("Bought %s\n", player.getWeapon().getName());
			}else if(selected instanceof Armor) {
				player.setArmor((Armor) selected);
				System.out.printf("Bought %s\n", player.getArmor().getName());
			}
			player.setGold(player.getGold() - selected.getPrice());
		}
		
	
		
		
	}
	
	private static void fightMonster(Player player, Scanner sc, Random random) {
		System.out.println("=====================================================================");
		System.out.printf("|%-5s|%-10s|%-5s|%-5s|%-5s|\n", "No", "Monster Name", "Attack", "Health", "Reward");
		System.out.println("=====================================================================");
		
		int idx = 1;
		int choice = 0;
		
		
		for(Monster m : mList) {
			System.out.printf("|%-5d|%-10s|%-5d|%-5d|%-5d|\n", idx, m.getName(), m.getAtt(), m.getHealth(), m.getReward());
			idx++;
		}
		System.out.println("=====================================================================");
		System.out.printf("Choose Monster to fight: ");
		choice = sc.nextInt();
		
		System.out.printf("You are fighting %s\n", mList.get(choice - 1).getName());
		
		Monster selected = mList.get(choice-1);
		
		int turn = 1;
		while(true) {
			if(turn % 2 != 0) {
				System.out.println("Player attack!");
				int damage = random.nextInt(player.getWeapon().getDamage() + 1);
				selected.setHealth(selected.getHealth() - damage);
				if(selected.getHealth() < 0) {
					selected.setHealth(0);
					System.out.printf("Remaining Health: %d\n", selected.getHealth());
					break;
				}
				System.out.printf("Raging Bull received %d damage\n", damage);
				System.out.printf("Remaining Health: %d\n", selected.getHealth());
				turn++;
			}else {
				System.out.println("Raging Bull Attack !");
				int damage = random.nextInt(selected.getAtt() - player.getArmor().getDefense());
				player.setHealth(player.getHealth() - damage);
					if(player.getHealth() < 0) {
						player.setHealth(0);
						System.out.printf("Remaining Health: %d\n", player.getHealth());
						break;
					}
				System.out.printf("Player received %d damage\n", damage);
				System.out.printf("Remaining Health: %d\n", player.getHealth());
				turn++;
			}
		}
		
		if(player.getHealth() > 0) {
			int prizepool = selected.getReward();
			System.out.printf("You win. Receives: %d gold!\n", prizepool);
			player.setGold(player.getGold() + prizepool);
			player.setHealth(150);
		}else if(player.getHealth() == 0) {
			System.out.println("You Died. Nice Try mate!");
			player.setHealth(150);
		}
	}
}
