import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Player {
	private int points = 0;
	private List<Card> cards = new ArrayList<>();
	private List<Card> novelCards = new ArrayList<>();
	protected List<Card> reservedCards = new ArrayList<>();
	protected int[] gemTokens = new int[Gem.TOTAL_GEM_TYPES];
	protected int[] gems = new int[Gem.TOTAL_GEM_TYPES];
	
	public Player() {}
	public void clear() {
		points = 0;
		cards.clear();
		novelCards.clear();
		reservedCards.clear();
		Arrays.fill(gemTokens, 0);
		Arrays.fill(gems, 0);
	}
	
	public int getPoints() {
		return points;
	}
	
	public int getNumberOfCards() {
		return cards.size();
	}
	
	public int getNumTokens() {
		int sum = 0;
		for(var n: gemTokens) sum += n;
		return sum;
	}
	
	public int[] getGemTokens() {
		return gemTokens;
	}
	
	public int[] getGems() {
		return gems;
	}
	
	public List<Card> getReservedCards() {
		return reservedCards;
	}
	
	public int getNumberOfReservedCards() {
		return reservedCards.size();
	}
	
	public void addCard(Card card) {
		points += card.point();
		if(card.level() == 0) novelCards.add(card);
		else {
			cards.add(card);
			++gems[card.bonus().ordinal()];
		}
	}
	
	public void addReserveCard(Card card) {
		reservedCards.add(card);
	}
	
	public void addTokens(Gem gem, int count) {
		gemTokens[gem.ordinal()] += count;
	}
	
	public void addTokens(int[] gemTokens) {
		for(int i = 0; i < gemTokens.length; ++i)
			this.gemTokens[i] += gemTokens[i];
	}
	
	public void removeTokens(int[] gemTokens) {
		for(int i = 0; i < gemTokens.length; ++i) 
			this.gemTokens[i] -= gemTokens[i];
	}
	
	/*
	 * 과목명: 자바프로그래밍(01분반)
	 * 학번:2025100066
	 * 성명: 최수빈
	 */
	
	/**
	 * 카드를 구매할 수 있는지 검사하는 메소드
	 * @param card 구매하고 싶은 카
	 * @return 구매할 수 있으면 반납해야 하는 토큰 정보
	 */
	public Optional<int[]> checkCardChoice(Card card) {
		int[] cost = card.gems();
		int[] pay = new int[Gem.TOTAL_GEM_TYPES];
		int goldNeeded = 0;

		for (int i = 0; i < Gem.TOTAL_CARD_GEM_TYPES; ++i) {
			int need = Math.max(0, cost[i] - gems[i]);   // 보너스로 할인한 뒤 남은 비용
			pay[i] = Math.min(need, gemTokens[i]);       // 같은 색 토큰을 먼저 사용
			goldNeeded += need - pay[i];                 // 모자란 만큼은 황금으로 대체
		}

		if (goldNeeded > gemTokens[Gem.GOLD.ordinal()])
			return Optional.empty();

		pay[Gem.GOLD.ordinal()] = goldNeeded;
		return Optional.of(pay);
	}
	/**
	 * 바닥에 공개되어 있는 레전드 카드를 얻을 수 있는지 검사하는 메소드
	 * @param legendCards 바닥에 공개되어 있는 4장의 레전드 카드 
	 * @return 보유한 개발 카드 보석 수가 레전드 카드의 조건을 만족하는 색인 목
	 */
	public List<Integer> checkLegendCards(Card[] legendCards) {
		List<Integer> indices = new ArrayList<>();
		for (int k = 0; k < legendCards.length; ++k) {
			if (legendCards[k] == null) continue;
			int[] cost = legendCards[k].gems();
			boolean ok = true;
			for (int i = 0; i < Gem.TOTAL_CARD_GEM_TYPES; ++i)
				if (gems[i] < cost[i]) { ok = false; break; }
			if (ok) indices.add(k);
		}
		return indices;
	}
}
