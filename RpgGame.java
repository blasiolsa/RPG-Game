import java.util.Scanner;

public class RpgGame
{
	public static void title()
	{
		System.out.println("RPG GAME");
		System.out.println("A Mini Adventure by Sidney Blasiol");
		System.out.println("To start a new adventure, type \"begin\"");
		System.out.println("To load a save file, type \"load\"");
		System.out.println("To exit, type \"quit\"");
	}

	public static void main(String[] args)
	{
		String input = "";
		Scanner in = new Scanner(System.in);
		MainGame game = new MainGame();
		title();

		input = in.next();

		if (input.equals("begin")) {
			System.out.println("An epic quest is about to unfold! Go forth!");
			game.mainGame();
		}

		if (input.equals("load")) {

		}

		if (input.equals("quit")) {

		}
	}
}