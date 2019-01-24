import java.util.Scanner;

public class MainGame
{
	public static void mainGame()
	{
		String input = "";
		int t = 4;
		Scanner in = new Scanner(System.in);
		RpgOverworldCommands overworldCommands = new RpgOverworldCommands();
		PlayerStats stats = new PlayerStats();
		
		while (t == 4) {
			overworldCommands.basicCommands(stats);
		}
	}
}