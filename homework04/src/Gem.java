/**
 * Gem: 보석 토큰을 나타내는 열거형
 */
public enum Gem {
	DIAMOND, SAPPHIRE, EMERALD, RUBY, ONYX, GOLD;
	public static final int TOTAL_GEM_TYPES = 6;
	public static final int TOTAL_CARD_GEM_TYPES = 5;
	public static Gem valueOf(int index) {
		Gem[] gems = Gem.values();
		if(index < 0 || index >= gems.length) 
			throw new IndexOutOfBoundsException("Gem::valueOf, index 범위 오류");
		return gems[index];
	}
};
