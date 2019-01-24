import java.util.Random;

public class EnemyBattles
{
	//Battle System
	public static boolean battleSystem(int playerLevel, int playerHp, int playerSp, int playerSword, String enemyName, int enemyLevel, int enemyHp, PlayerStats stats)
	{
		int playerDamage;
		int playerLimit = 0;
		int freezeRoll;
		int enemyAttack;
		boolean freezeChance;
		boolean enemyDefenseDown = false;
		boolean playerDefenseUp = false;
		boolean playerDefenseDown = false;
		PlayerAttacks playerAttack = new PlayerAttacks();
		Random rand = new Random();

		System.out.println(enemyName + " appears!");

		while (enemyHp > 0 && playerHp > 0) {
			System.out.println("___________________________________");
			System.out.println("Player:");
			System.out.println("LV: " + playerLevel);
			System.out.println("HP: " + playerHp);
			System.out.println("SP: " + playerSp);
			System.out.println("___________________________________");
			System.out.println(enemyName);
			System.out.println("LV: " + enemyLevel);
			System.out.println("HP: " + enemyHp);
			System.out.println();

			playerDamage = playerAttack.PlayerAttack(playerLevel, playerLimit, playerSword);

			//Sword Slash
			if (playerDamage < 9999) {
				if (enemyDefenseDown) {
					playerDamage = playerDamage * 2;
					enemyDefenseDown = false;
				}
				enemyHp = enemyHp - playerDamage;
				System.out.println("Dealt " + playerDamage + " points of damage!");
			}

			//Defend
			if (playerDamage == 10001) {
				playerDefenseUp = true;
				playerSp = playerSp + 10;
				System.out.println("You braced yourself for the next attack! Defense rose! Recovered 10 SP!");
				if (playerSp >= stats.playerSp) {
					playerSp = stats.playerSp;
					System.out.println("SP Maxed out!");
				}
			}

			//Healing Aura
			if (playerDamage == 10002) {
				if (playerSp >= 25) {
					playerSp = playerSp - 25;
					playerHp = playerHp + 500;
					System.out.println("Recovered 500 HP!");
					if (playerHp >= stats.playerHp) {
						playerHp = stats.playerHp;
						System.out.println("Health was maxed out!");
					}
				}
				if (playerSp < 25) {
					System.out.println("You tried to cast the spell, but you did not have enough SP!");
				}
			}

			//Flamethrower
			if (playerDamage == 10003 && playerLevel >= 5) {
				if (playerSp >= 10) {
					playerSp = playerSp - 10;
					playerDamage = 50;
					enemyHp = enemyHp - playerDamage;
					System.out.println("Dealt 50 points of damage!");
				}
				if (playerSp < 10) {
					System.out.println("You tried to cast the spell, but you did not have enough SP!");
				}
			}

			//Cold Snap
			if (playerDamage == 10004 && playerLevel >= 8) {
				if (playerSp >= 8) {
					playerSp = playerSp - 8;
					playerDamage = 30;
					freezeRoll = rand.nextInt(2);
					enemyHp = enemyHp - playerDamage;
					System.out.println("Dealt 30 points of damage!");
					if (freezeRoll > 0) {
						freezeChance = true;
						System.out.println("The enemy was frozen solid! It can't move!");
					}
				}
				if (playerSp < 8) {
					System.out.println("You tried to cast the spell, but you did not have enough SP!");
				}
			}

			//Shock Bolt
			if (playerDamage == 10005 && playerLevel >= 13) {
				if (playerSp >= 18) {
					playerSp = playerSp - 18;
					playerDamage = 100;
					enemyHp = enemyHp - playerDamage;
					System.out.println("Dealt 100 points of damage!");
				}
				if (playerSp < 18) {
					System.out.println("You tried to cast the spell, but you did not have enough SP!");
				}
			}

			//Healing Halo
			if (playerDamage == 10006 && playerLimit >= 100) {
				playerHp = playerHp + 1000;
				playerSp = playerSp + 100;
				playerLimit = 0;
				System.out.println("HP was restored! SP was restored!");
			}

			//Sacred Fire
			if (playerDamage == 10007 && playerLimit >= 100 && playerLevel >= 5) {
				playerDamage = 100;
				enemyHp = enemyHp - playerDamage;
				playerLimit = 0;
				System.out.println("Dealt 100 points of damage!");
			}

			//Permafrost
			if (playerDamage == 10008 && playerLimit >= 100 && playerLevel >= 8) {
				playerDamage = 65;
				enemyHp = enemyHp - playerDamage;
				freezeChance = true;
				playerLimit = 0;
				System.out.println("Dealt 65 points of damage! The enemy was frozen! It can't move!");
			}

			//Strike of Judgement
			if (playerDamage == 10009 && playerLimit >= 100 && playerLevel >= 13) {
				playerDamage = 150;
				enemyHp = enemyHp - playerDamage;
				playerLimit = 0;
				System.out.println("Dealt 150 points of damage!");
			}

			//Final Limit
			if (playerDamage == 10010 && playerLimit >= 100 && playerLevel >= 18) {
				playerDamage = 500;
				enemyHp = enemyHp - playerDamage;
				playerLimit = 0;
				System.out.println("Dealt 500 points of damage!");
			}

			enemyAttack = rand.nextInt(10);

			//Slime Actions
			if (enemyName.equals("Slime") && enemyHp > 0) {
				if (enemyAttack < 7) {
					playerHp = playerHp - 10;
					System.out.println("Slime dealt 10 points of damage!");
				}
				if (enemyAttack >= 7) {
					System.out.println("Slime is sloshing around!");
				}
			}

			//Spider Actions
			if (enemyName.equals("Spider") && enemyHp > 0) {
				if (enemyAttack < 6) {
					if (!playerDefenseDown) {
						playerHp = playerHp - 22;
						System.out.println("Spider dealt 22 points of damage!");
					}
					if (playerDefenseDown) {
						playerHp = playerHp - 35;
						playerDefenseDown = false;
						System.out.println("Spider dealt 35 points of damage! Defense returned to normal!");
					}
				}
				if (enemyAttack >= 6 && enemyAttack < 8) {
					playerDefenseDown = true;
					System.out.println("Spider hissed at you! Your defense dropped!");
				}
				if (enemyAttack >= 8) {
					System.out.println("Spider is scuttling about!");
				}
			}

			//Thief Actions
			if (enemyName.equals("Thief") && enemyHp > 0) {
				if (enemyAttack < 6) {
					playerHp = playerHp - 38;
					System.out.println("Thief dealt 38 points of damage!");
				}
				if (enemyAttack >= 6 && enemyAttack < 8) {
					if (stats.playerGold >= 5) {
						stats.playerGold = stats.playerGold - 5;
						System.out.println("Thief stole 5 gold!");
					}
					if (stats.playerGold < 5) {
						System.out.println("Thief tried to steal gold... but you didn't have enough to steal!");
					}
				}
				if (enemyAttack >= 8) {
					System.out.println("Thief called you a nasty name!");
				}
			}

			//Arachnid Queen
			if (enemyName.equals("Arachnid Queen") && enemyHp > 0) {
				if (enemyAttack < 7) {
					if (!playerDefenseDown) {
						playerHp = playerHp - 75;
						System.out.println("Arachnid Queen dealt 75 points of damage!");
					}
					else if (playerDefenseDown) {
						playerHp = playerHp - 150;
						playerDefenseDown = false;
						System.out.println("Arachnid Queen dealt 150 points of damage! Your defense returned to normal!");
					}
				}

				else if (enemyAttack >=7 && enemyAttack < 9) {
					playerDefenseDown = true;
					playerHp = playerHp - 48;
					System.out.println("Arachnid Queen cast a fire spell! Dealt 48 points of damage! Your defense dropped!");
				}

				else {
					System.out.println("Arachnid Queen is making clicking sounds...");
				}
			}
		}

		if (playerHp <= 0) {
			System.out.println("You were defeated...");
			return false;
		}

		if (enemyHp <= 0 && playerHp > 0) {
			System.out.println("You were victorious!");
			return true;
		}

		else {
			return false;
		}
	}

	//Slime
	public static void slimeBattle(int playerLevel, int playerHp, int playerSp, int playerSword, PlayerStats stats)
	{
		int enemyLevel = 1;
		int enemyHp = 35;
		int enemyExp = 5;
		int enemyGold = 5;
		String enemyName = "Slime";
		boolean playerDefenseUp;
		boolean enemyDefenseDown = false;
		boolean enemyDefeat;

		enemyDefeat = battleSystem(playerLevel, playerHp, playerSp, playerSword, enemyName, enemyLevel, enemyHp, stats);

		if (enemyDefeat) {
			stats.addExp(enemyExp);
			stats.addGold(enemyGold);

			System.out.println(enemyName + " was defeated!");
			System.out.println("Gained " + enemyExp + " Exp!");
			System.out.println("Gained " + enemyGold + " Gold!");
		}

		if (!enemyDefeat) {
			stats.playerGold = stats.playerGold / 2;

			System.out.println("Lost the battle...");
			System.out.println("Lost half your gold!");
			System.out.println();
		}
	}

	//Spider
	public static void spiderBattle(int playerLevel, int playerHp, int playerSp, int playerSword, PlayerStats stats)
	{
		int enemyLevel = 2;
		int enemyHp = 45;
		int enemyExp = 8;
		int enemyGold = 12;
		String enemyName = "Spider";
		boolean enemyDefeat;

		enemyDefeat = battleSystem(playerLevel, playerHp, playerSp, playerSword, enemyName, enemyLevel, enemyHp, stats);

		if (enemyDefeat) {
			stats.playerExp = stats.playerExp + enemyExp;
			stats.playerGold = stats.playerGold + enemyGold;

			System.out.println(enemyName + " was defeated!");
			System.out.println("Gained " + enemyExp + " Exp!");
			System.out.println("Gained " + enemyGold + " Gold!");
		}

		if (!enemyDefeat) {
			stats.playerGold = stats.playerGold / 2;

			System.out.println("Lost the battle...");
			System.out.println("Lost half your gold!");
			System.out.println();
		}
	}

	//Theif
	public static void thiefBattle(int playerLevel, int playerHp, int playerSp, int playerSword, PlayerStats stats)
	{
		int enemyLevel = 3;
		int enemyHp = 60;
		int enemyExp = 18;
		int enemyGold = 20;
		String enemyName = "Thief";
		boolean enemyDefeat;

		enemyDefeat = battleSystem(playerLevel, playerHp, playerSp, playerSword, enemyName, enemyLevel, enemyHp, stats);

		if (enemyDefeat) {
			stats.playerExp = stats.playerExp + enemyExp;
			stats.playerGold = stats.playerGold + enemyGold;

			System.out.println(enemyName + " was defeated!");
			System.out.println("Gained " + enemyExp + " Exp!");
			System.out.println("Gained " + enemyGold + " Gold!");
		}

		if (!enemyDefeat) {
			stats.playerGold = stats.playerGold / 2;

			System.out.println("Lost the battle...");
			System.out.println("Lost half your gold!");
			System.out.println();
		}
	}

	//Arachnid Queen
	public static boolean arachnidQueenBattle(int playerLevel, int playerHp, int playerSp, int playerSword, PlayerStats stats)
	{
		int enemyLevel = 8;
		int enemyHp = 400;
		int enemyExp = 130;
		int enemyGold = 100;
		String enemyName = "Arachnid Queen";
		boolean enemyDefeat;

		enemyDefeat = battleSystem(playerLevel, playerHp, playerSp, playerSword, enemyName, enemyLevel, enemyHp, stats);

		if (enemyDefeat) {
			stats.playerExp = stats.playerExp + enemyExp;
			stats.playerGold = stats.playerGold + enemyGold;

			System.out.println(enemyName + " was defeated!");
			System.out.println("Gained " + enemyExp + " Exp!");
			System.out.println("Gained " + enemyGold + " Gold!");

			return true;
		}

		if (!enemyDefeat) {
			stats.playerGold = stats.playerGold / 2;

			System.out.println("Lost the battle...");
			System.out.println("Lost half your gold!");
			System.out.println();

			return false;
		}
		else {
			return false;
		}
	}

	//Giant Crab
	public static void giantCrabBattle(int playerLevel, int playerHp, int playerSp, int playerSword, PlayerStats stats)
	{
		int enemyLevel = 5;
		int enemyHp = 100;
		int enemyExp = 38;
		int enemyGold = 44;
		String enemyName = "Giant Crab";
		boolean enemyDefeat;

		enemyDefeat = battleSystem(playerLevel, playerHp, playerSp, playerSword, enemyName, enemyLevel, enemyHp, stats);

		if (enemyDefeat) {
			stats.playerExp = stats.playerExp + enemyExp;
			stats.playerGold = stats.playerGold + enemyGold;

			System.out.println(enemyName + " was defeated!");
			System.out.println("Gained " + enemyExp + " Exp!");
			System.out.println("Gained " + enemyGold + " Gold!");
		}

		if (!enemyDefeat) {
			stats.playerGold = stats.playerGold / 2;

			System.out.println("Lost the battle...");
			System.out.println("Lost half your gold!");
			System.out.println();
		}
	}

	//Banshee
	public static void bansheeBattle(int playerLevel, int playerHp, int playerSp, int playerSword, PlayerStats stats)
	{
		int enemyLevel = 6;
		int enemyHp = 135;
		int enemyExp = 48;
		int enemyGold = 56;
		String enemyName = "Banshee";
		boolean enemyDefeat;

		enemyDefeat = battleSystem(playerLevel, playerHp, playerSp, playerSword, enemyName, enemyLevel, enemyHp, stats);

		if (enemyDefeat) {
			stats.playerExp = stats.playerExp + enemyExp;
			stats.playerGold = stats.playerGold + enemyGold;

			System.out.println(enemyName + " was defeated!");
			System.out.println("Gained " + enemyExp + " Exp!");
			System.out.println("Gained " + enemyGold + " Gold!");
		}

		if (!enemyDefeat) {
			stats.playerGold = stats.playerGold / 2;

			System.out.println("Lost the battle...");
			System.out.println("Lost half your gold!");
			System.out.println();
		}
	}

	//Man-O-War
	public static void manOWarBattle(int playerLevel, int playerHp, int playerSp, int playerSword, PlayerStats stats)
	{
		int enemyLevel = 7;
		int enemyHp = 150;
		int enemyExp = 57;
		int enemyGold = 72;
		String enemyName = "Man-O-War";
		boolean enemyDefeat;

		enemyDefeat = battleSystem(playerLevel, playerHp, playerSp, playerSword, enemyName, enemyLevel, enemyHp, stats);

		if (enemyDefeat) {
			stats.playerExp = stats.playerExp + enemyExp;
			stats.playerGold = stats.playerGold + enemyGold;

			System.out.println(enemyName + " was defeated!");
			System.out.println("Gained " + enemyExp + " Exp!");
			System.out.println("Gained " + enemyGold + " Gold!");
		}

		if (!enemyDefeat) {
			stats.playerGold = stats.playerGold / 2;

			System.out.println("Lost the battle...");
			System.out.println("Lost half your gold!");
			System.out.println();
		}
	}

	//Kraken
	public static boolean krakenBattle(int playerLevel, int playerHp, int playerSp, int playerSword, PlayerStats stats)
	{
		int enemyLevel = 12;
		int enemyHp = 800;
		int enemyExp = 360;
		int enemyGold = 558;
		String enemyName = "Kraken";
		boolean enemyDefeat;

		enemyDefeat = battleSystem(playerLevel, playerHp, playerSp, playerSword, enemyName, enemyLevel, enemyHp, stats);

		if (enemyDefeat) {
			stats.playerExp = stats.playerExp + enemyExp;
			stats.playerGold = stats.playerGold + enemyGold;

			System.out.println(enemyName + " was defeated!");
			System.out.println("Gained " + enemyExp + " Exp!");
			System.out.println("Gained " + enemyGold + " Gold!");

			return true;
		}

		if (!enemyDefeat) {
			stats.playerGold = stats.playerGold / 2;

			System.out.println("Lost the battle...");
			System.out.println("Lost half your gold!");
			System.out.println();

			return false;
		}

		else {
			return false;
		}
	}
}