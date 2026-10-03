
public record Card (
	int level, int point, int[] gems, 
	Gem bonus, String fileName) {
	public static final int NUM_CARD_LEVELS = 4;
	private static final int[] TOTAL_NUM_OF_LEVEL_CARDS = {10, 40, 30, 20};
	public static int getTotalNumberOfLevelCards(int level) {
		return TOTAL_NUM_OF_LEVEL_CARDS[level];
	}
}
 