public class PlayerStats
{
	public int playerLevel;
	public int playerHp;
	public int playerSp;
	public int playerGold;
	public int playerExp;
	public int playerSword;
	public boolean fertileFieldsBoss = false;
	public boolean crescentCoastBoss = false;
	public boolean frostyForestBoss = false;
	public boolean mightyMountainBoss = false;
	public boolean kingdomsHeartBoss = false;

	public PlayerStats()
	{
		playerLevel = 1;
		playerHp = 500;
		playerSp = 50;
		playerGold = 0;
		playerExp = 0;
		playerSword = 0;
	}

	public void addExp(int newExp)
	{
		playerExp = playerExp + newExp;
	}

	public void addGold(int newGold)
	{
		playerGold = playerGold + newGold;
	}

	public int getLevel(int playerExp)
	{
		if (playerExp < 20) {
			playerLevel = 1;
		}
		return this.playerLevel;
	}

	public int getHp(int playerExp)
	{
		if (playerExp < 20) {
			playerHp = 500;
		}
		return playerHp;
	}

	public int getSp(int playerExp) 
	{
		if (playerExp < 20) {
			playerSp = 50;
		}
		return playerSp;
	}

	public int getSword() {
		return playerSword;
	}
}