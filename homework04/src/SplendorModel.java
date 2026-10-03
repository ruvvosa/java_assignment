import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class SplendorModel {
	public static final int WIN_THRESHOLD = 15;
	public static final int NUM_PLAYERS    = 3;
    public static final int FLOOR_COLUMNS  = 4;
    
    private List<Deque<Card>> decks = new ArrayList<>();
	private int[] gemTokens = new int[] {5, 5, 5, 5, 5, 5};
	private Card[][] floorCards = new Card[Card.NUM_CARD_LEVELS][FLOOR_COLUMNS];
	
	public SplendorModel() {
		for(int i = 0; i < Card.NUM_CARD_LEVELS; ++i) {
			decks.add(new ArrayDeque<Card>(Card.getTotalNumberOfLevelCards(i)));
		}
	}
	
	public void init(List<List<Card>> originalDecks) {
		for(int i = 0; i < Card.NUM_CARD_LEVELS; ++i) {
			List<Card> tmp = new ArrayList<>(originalDecks.get(i));
			Collections.shuffle(tmp);
			decks.get(i).clear();
			decks.get(i).addAll(tmp);
		}
		
		for(int L = 0; L < Card.NUM_CARD_LEVELS; ++L)
			for(int i = 0; i < FLOOR_COLUMNS; ++i)
				floorCards[L][i] = decks.get(L).removeLast();
		decks.get(0).clear();
		Arrays.fill(gemTokens, 5);
	}
	
	public Card[] getLegendCards() {
		return floorCards[0];
	}
	
	public void removeLegendCard(int index) {
		if(index < 0 && index >= FLOOR_COLUMNS) 
			throw new IndexOutOfBoundsException(String.format("Index %d for Size %d", index, FLOOR_COLUMNS));
		if(floorCards[0][index] == null) 
			throw new IllegalArgumentException("Already deleted legend card");
		floorCards[0][index] = null;
	}
	
	public Card[][] getFloorCards() {
		return floorCards;
	}
	
	/**
	 * 바닥에서 카드를 구매하거나 예약할 때 사용하는 메소드
	 * @param cardChoice 용량이 2인 정수 배열, [0] 카드 레벨, [1] 색인 (0 ~ 4)
	 *  색인 4이면 레벨 카드 뭉치 맨 위에 있는 카드 (이 카드를 예약할 수 있음)
	 * @return 구매 또는 예약한 카드
	 */
	public Card removeCard(int[] cardChoice) {
		int level = cardChoice[0], index = cardChoice[1];
		Card removed = null;
		if(index == FLOOR_COLUMNS) removed = decks.get(level).removeLast();
		else {
			removed = floorCards[level][index];
			floorCards[level][index] = decks.get(level).isEmpty()?
					null: decks.get(level).removeLast();
		}
		return removed;
	}
}
