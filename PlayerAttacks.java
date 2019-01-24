import java.util.Scanner;
import java.util.Random;

public class PlayerAttacks
{
	public int PlayerAttack(int playerLevel, int playerLimit, int playerSword)
	{
		int playerAttack;
		int damage;
		Scanner in = new Scanner(System.in);
		Random rand = new Random();

		System.out.println("Select an action:");
		System.out.println("1: Sword Slash");
		System.out.println("2: Defend");
		System.out.println("3: Healing Aura (Costs 6 SP)");

		if (playerLevel >= 5) {
			System.out.println("4: Flamethrower (Costs 10 SP)");
		}

		if (playerLevel >= 8) {
			System.out.println("5: Cold Snap (Costs 8 SP)");
		}

		if (playerLevel >= 13) {
			System.out.println("6: Shock Bolt (Costs 18 SP)");
		}

		if (playerLimit >= 100) {
			System.out.println("0: Limit Attack Ready!");
		}

		playerAttack = in.nextInt();

		//Sword Slash
		if (playerAttack == 1) {
			if (playerSword == 0) {
				damage = rand.nextInt(10) + 10;
				return damage;
			}
		}

		//Defend
		if (playerAttack == 2) {
			damage = 10001;
			return damage;
		}

		//Healing Aura
		if (playerAttack == 3) {
			damage = 10002;
			return damage;
		}

		//Flamethrower
		if (playerAttack == 4 && playerLevel >= 5) {
			damage = 10003;
			return damage;
		}

		//Cold Snap
		if (playerAttack == 5 && playerLevel >= 8) {
			damage = 10004;
			return damage;
		}

		//Shock Bolt
		if (playerAttack == 6 && playerLevel >= 13) {
			damage = 10005;
			return damage;
		}

		//Limit Attacks
		if (playerAttack == 0 && playerLimit >= 100) {
			System.out.println("Select a Limit Attack!");
			System.out.println("1: Mega Slash");
			System.out.println("2: Healing Halo");

			if (playerLevel >= 5) {
				System.out.println("3: Sacred Fire");
			}

			if (playerLevel >= 8) {
				System.out.println("4: Permafrost");
			}

			if (playerLevel >= 13) {
				System.out.println("5: Strike of Judgement");
			}

			if (playerLevel >= 18) {
				System.out.println("6: Final Limit");
			}

			playerAttack = in.nextInt();

			//Mega Slash
			if (playerAttack == 1) {
				if (playerSword == 0) {
					damage = rand.nextInt(25) + 75;
					System.out.println("You unleashed a wicked slash with your blade!");
					return damage;
				}
			}

			//Healing Halo
			if (playerAttack == 2) {
				damage = 10006;
				System.out.println("A soft ray of light wraps aroung you!");
				return damage;
			}

			//Sacred Fire
			if (playerAttack == 3 && playerLevel >= 5) {
				damage = 10007;
				System.out.println("A pillar of blue fire consumes the enemy!");
				return damage;
			}

			//Permafrost
			if (playerAttack == 4 && playerLevel >= 8) {
				damage = 10008;
				System.out.println("The enemy was encased in a block of ice!");
				return damage;
			}

			//Strike of Judgement
			if (playerAttack == 5 && playerLevel >= 13) {
				damage = 10009;
				System.out.println("A bolt of lightning strikes the enemy from the tip of your sword!");
				return damage;
			}

			//Final Limit
			if (playerAttack == 6 && playerLevel >= 18) {
				damage = 10010;
				System.out.println("You unleash a beam of ultra-powerful energy from your hand at the enemy!");
				return damage;
			}
		}

		//Should Not Be Accessible
			return 0;
	}
}