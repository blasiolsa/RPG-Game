import java.util.Scanner;

public class RpgOverworldCommands
{
	public void basicCommands(PlayerStats stats)
	{
		Scanner in = new Scanner(System.in);
		String input;

		System.out.println("Welcome to the Overworld. Please input a command (Type \"help\" if you are confused)");

		input = in.next();

		if (input.equals("help")) {
			help();
		}
		if (input.equals("status")) {
			status(stats);
		}
		if (input.equals("rest")) {
			rest();
		}
		if (input.equals("explore")) {
			explore(stats);
		}
		if (input.equals("save")){
			save();
		}
		if (input.equals("quit")) {
			quit();
		}
	}

	public static void help()
	{
		System.out.println("status: Check the status of your character");
		System.out.println("inventory: Check your inventory");
		System.out.println("rest: Recover HP and SP");
		System.out.println("explore: Explore an area to fight enemies, discover loot, and more");
		System.out.println("save: Save your in-game progress");
		System.out.println("quit: Return to the title screen");
	}

	public void status(PlayerStats stats)
	{
		System.out.println("Player Level: " + stats.getLevel(stats.playerExp));
		System.out.println("HP: " + stats.getHp(stats.playerExp));
		System.out.println("SP: " + stats.getSp(stats.playerExp));
		System.out.println("Gold: " + stats.playerGold);
		System.out.println("Total EXP: " + stats.playerExp);
	}

	public void inventory()
	{
		System.out.println("FIXME: Need to add inventory support");
	}

	public void rest()
	{
		System.out.println("FIXME: Add rest support");
	}

	public void explore(PlayerStats stats)
	{
		int input;
		Scanner in = new Scanner(System.in);
		Locations locations = new Locations();

		System.out.println("Where would you like to explore? (Type the number)");
		System.out.println("1: Fertile Fields");
		System.out.println("2: Crescent Coast");
		System.out.println("3: Frosty Forest");
		System.out.println("4: Mighty Mountain");
		System.out.println("5: Kingdom's Heart");
		System.out.println("6: Cliffs of Revelation");
		
		input = in.nextInt();

		if (input == 1) {
			locations.FertileFieldsActions(stats);
		}
		if (input == 2 && stats.fertileFieldsBoss) {
			locations.crescentCoastActions(stats);
		}
	}

	public void save()
	{
		System.out.println("FIXME: Add save support");
	}

	public void quit()
	{
		System.exit(1);
	}
}