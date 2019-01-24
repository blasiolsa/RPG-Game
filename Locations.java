import java.util.Scanner;
import java.util.Random;

public class Locations
{

	//Fertile Fields
	public void FertileFieldsActions(PlayerStats stats)
	{
		int playerAction = 0;
		int enemyNum;
		int lotteryChance;
		String shopSelection = "";
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		EnemyBattles enemyBattle = new EnemyBattles();
		RpgOverworldCommands overworldCommands = new RpgOverworldCommands();

		while (playerAction != 5) {

			System.out.println("FERTILE FIELDS");
			System.out.println("Select an action:");
			System.out.println("1: Hunt Monsters");
			System.out.println("2: Visit Shop");
			System.out.println("3: Challenge Boss");
			System.out.println("4: Inspect Landscape");
			System.out.println("5: Return to Overworld");

			playerAction = in.nextInt();

			//Hunt Monsters
			if (playerAction == 1) {
				enemyNum = rand.nextInt(3);

				if (enemyNum == 0) {
					enemyBattle.slimeBattle(stats.getLevel(stats.playerExp), stats.getHp(stats.playerExp), stats.getSp(stats.playerExp), stats.getSword(), stats);
				}

				if (enemyNum == 1) {
					enemyBattle.spiderBattle(stats.getLevel(stats.playerExp), stats.getHp(stats.playerExp), stats.getSp(stats.playerExp), stats.getSword(), stats);
				}

				if (enemyNum == 2) {
					enemyBattle.thiefBattle(stats.getLevel(stats.playerExp), stats.getHp(stats.playerExp), stats.getSp(stats.playerExp), stats.getSword(), stats);
				}
			}

			//Visit Shop
			if (playerAction == 2) {
				System.out.println("Welcome, traveler! Please, take a look around, I'm sure you'll find something to aid you in your travels. (Type \"quit\" to exit)");

				while (!shopSelection.equals("quit")) {
					System.out.println("Steel Sword (Increases damage dealt to enemies when using the Sword Slash attack): 150 Gold");
					System.out.println("Health Pot (Increases max HP by 20): 100 Gold");
					System.out.println("EXP Soup (Grants you an extra 50 EXP): 100 Gold");
					System.out.println("Lottery Ticket (Chance to win 500 Gold! Or lose 20 Gold...): 20 Gold");

					System.out.println("Type your selection:");
					shopSelection = in.nextLine();

					if (shopSelection.equals("Steel Sword")) {
						if (stats.playerSword < 1 && stats.playerGold >= 150) {
							stats.playerGold = stats.playerGold - 150;
							stats.playerSword = 1;
							System.out.println("Thank you kindly! You'll be much safer out there now.");
						}
						else if (stats.playerSword >= 1 && stats.playerGold >= 150) {
							System.out.println("Looks like you don't need that. Choose another item.");
						}
						else if (stats.playerGold < 150) {
							System.out.println("Looks like you don't have enough gold for that.");
						}
					}

					else if (shopSelection.equals("Health Pot")) {
						if (stats.playerGold >= 100) {
							stats.playerGold = stats.playerGold - 100;
							stats.playerHp = stats.playerHp + 20;
							System.out.println("Thank you kindly! You look much more invigorated now.");
						}
						else if (stats.playerGold < 100) {
							System.out.println("Looks like you don't have enough gold for that.");
						}
					}

					else if (shopSelection.equals("EXP Soup")) {
						if (stats.playerGold >= 100) {
							stats.playerExp = stats.playerExp + 50;
							System.out.println("Thank you kindly! You look much wiser already.");
						}
						else if (stats.playerGold < 100) {
							System.out.println("Looks like you don't have enough gold for that.");
						}
					}

					else if (shopSelection.equals("Lottery Ticket")) {
						if (stats.playerGold >= 20) {
							System.out.println("A fellow gambler, eh? Let's see if you've struck it big...");
							stats.playerGold = stats.playerGold - 20;
							lotteryChance = rand.nextInt(25);

							if (lotteryChance == 20) {
								stats.playerGold = stats.playerGold + 500;
								System.out.println("Congratulations! You're a winner! Here's your 500 Gold!");
							}
							else {
								System.out.println("Too bad! Your ticket wasn't a winner.");
							}
						}
						else if (stats.playerGold < 20) {
							System.out.println("Looks like you don't have enough gold for that.");
						}
					}

					else {
						System.out.println("Hmm, I don't think we carry that... Why not choose something else?");
					}
				}
			}

			//Challenge Boss
			if (playerAction == 3) {
				if (!stats.fertileFieldsBoss) {
					System.out.println("Something big is coming...!");
					stats.fertileFieldsBoss = EnemyBattles.arachnidQueenBattle(stats.getLevel(stats.playerExp), stats.getHp(stats.playerExp), stats.getSp(stats.playerExp), stats.getSword(), stats);
				}
				else if (stats.fertileFieldsBoss) {
					System.out.println("The guardian of this area now sleeps...");
				}
			}

			//Inspect Landscape
			if (playerAction == 4) {
				System.out.println("You stand in the midst of a vast grassy landscape. Rolling hills and blue skies fill ");
				System.out.println("your view for miles. A shop is run in a dingy hut inbetween two larger hills. The ");
				System.out.println("enemies that reside here include slimes, spiders, and thieves. Be cautious, traveller!");
			}

			//Return to Overworld
			if (playerAction == 5) {
				overworldCommands.basicCommands(stats);
			}
		}
	}

	//Crescent Coast-------------------------------------------------------------------------------------------------------------
	public void crescentCoastActions(PlayerStats stats)
	{
		int playerAction = 0;
		int enemyNum;
		int lotteryChance;
		String shopSelection = "";
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		EnemyBattles enemyBattle = new EnemyBattles();
		RpgOverworldCommands overworldCommands = new RpgOverworldCommands();

		while (playerAction != 5) {

			System.out.println("CRESCENT COAST");
			System.out.println("Select an action:");
			System.out.println("1: Hunt Monsters");
			System.out.println("2: Visit Shop");
			System.out.println("3: Challenge Boss");
			System.out.println("4: Inspect Landscape");
			System.out.println("5: Return to Overworld");

			playerAction = in.nextInt();

			//Hunt Monsters
			if (playerAction == 1) {
				enemyNum = rand.nextInt(3);

				if (enemyNum == 0) {
					enemyBattle.giantCrabBattle(stats.getLevel(stats.playerExp), stats.getHp(stats.playerExp), stats.getSp(stats.playerExp), stats.getSword(), stats);
				}

				if (enemyNum == 1) {
					enemyBattle.bansheeBattle(stats.getLevel(stats.playerExp), stats.getHp(stats.playerExp), stats.getSp(stats.playerExp), stats.getSword(), stats);
				}

				if (enemyNum == 2) {
					enemyBattle.manOWarBattle(stats.getLevel(stats.playerExp), stats.getHp(stats.playerExp), stats.getSp(stats.playerExp), stats.getSword(), stats);
				}
			}

			//Visit Shop
			if (playerAction == 2) {
				System.out.println("Welcome, traveler! Please, take a look around, I'm sure you'll find something to aid you in your travels. (Type \"quit\" to exit)");

				while (!shopSelection.equals("quit")) {
					System.out.println("Titanium Sword (Increases damage dealt to enemies when using the Sword Slash attack): 500 Gold");
					System.out.println("Health Pot (Increases max HP by 20): 100 Gold");
					System.out.println("EXP Soup (Grants you an extra 50 EXP): 100 Gold");
					System.out.println("Lottery Ticket (Chance to win 500 Gold! Or lose 20 Gold...): 20 Gold");

					System.out.println("Type your selection:");
					shopSelection = in.nextLine();

					if (shopSelection.equals("Titanium Sword")) {
						if (stats.playerSword < 2 && stats.playerGold >= 500) {
							stats.playerGold = stats.playerGold - 500;
							stats.playerSword = 2;
							System.out.println("Thank you kindly! You'll be much safer out there now.");
						}
						else if (stats.playerSword >= 1 && stats.playerGold >= 150) {
							System.out.println("Looks like you don't need that. Choose another item.");
						}
						else if (stats.playerGold < 150) {
							System.out.println("Looks like you don't have enough gold for that.");
						}
					}

					else if (shopSelection.equals("Health Pot")) {
						if (stats.playerGold >= 100) {
							stats.playerGold = stats.playerGold - 100;
							stats.playerHp = stats.playerHp + 20;
							System.out.println("Thank you kindly! You look much more invigorated now.");
						}
						else if (stats.playerGold < 100) {
							System.out.println("Looks like you don't have enough gold for that.");
						}
					}

					else if (shopSelection.equals("EXP Soup")) {
						if (stats.playerGold >= 100) {
							stats.playerExp = stats.playerExp + 50;
							System.out.println("Thank you kindly! You look much wiser already.");
						}
						else if (stats.playerGold < 100) {
							System.out.println("Looks like you don't have enough gold for that.");
						}
					}

					else if (shopSelection.equals("Lottery Ticket")) {
						if (stats.playerGold >= 20) {
							System.out.println("A fellow gambler, eh? Let's see if you've struck it big...");
							stats.playerGold = stats.playerGold - 20;
							lotteryChance = rand.nextInt(25);

							if (lotteryChance == 20) {
								stats.playerGold = stats.playerGold + 500;
								System.out.println("Congratulations! You're a winner! Here's your 500 Gold!");
							}
							else {
								System.out.println("Too bad! Your ticket wasn't a winner.");
							}
						}
						else if (stats.playerGold < 20) {
							System.out.println("Looks like you don't have enough gold for that.");
						}
					}

					else {
						System.out.println("Hmm, I don't think we carry that... Why not choose something else?");
					}
				}
			}

			//Challenge Boss
			if (playerAction == 3) {
				if (!stats.fertileFieldsBoss) {
					System.out.println("Something big is coming...!");
					stats.fertileFieldsBoss = EnemyBattles.arachnidQueenBattle(stats.getLevel(stats.playerExp), stats.getHp(stats.playerExp), stats.getSp(stats.playerExp), stats.getSword(), stats);
				}
				else if (stats.fertileFieldsBoss) {
					System.out.println("The guardian of this area now sleeps...");
				}
			}

			//Inspect Landscape
			if (playerAction == 4) {
				System.out.println("FIXME: Add Landscape");
			}

			//Return to Overworld
			if (playerAction == 5) {
				overworldCommands.basicCommands(stats);
			}
		}
	}
}