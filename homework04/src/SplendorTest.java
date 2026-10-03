import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SplendorTest {
	
	@Test
	void checkCardChoice_basic() {
		Player player = new Player();
		player.addTokens(Gem.DIAMOND, 2);
	    player.addTokens(Gem.SAPPHIRE, 1);
	    Card card = new Card(1, 0, new int[] { 2, 1, 0, 0, 0 }, Gem.RUBY, "");
        Optional<int[]> result = player.checkCardChoice(card);
        assertTrue(result.isPresent());
        assertArrayEquals(new int[] { 2, 1, 0, 0, 0, 0 }, result.get());
	}

	record CardChoiceCase(
		int[] gems,
	    int[] tokens,
	    int[] cost,
	    int[] expected
	) {}
	
	static Stream<CardChoiceCase> cardChoice_ValidCases() {
		return Stream.of(
			new CardChoiceCase(
	            new int[] {0, 0, 0, 0, 0},
	            new int[] {2, 1, 0, 0, 0, 0},
	            new int[] {2, 1, 0, 0, 0},
	            new int[] {2, 1, 0, 0, 0, 0}
	        ),
	        
	        new CardChoiceCase(
	            new int[] {0, 2, 2, 2, 0},
	            new int[] {0, 1, 0, 1, 0, 0},
	            new int[] {0, 3, 1, 2, 0},
	            new int[] {0, 1, 0, 0, 0, 0}
	        ),

	        new CardChoiceCase(
	            new int[] {1, 0, 0, 0, 0},
	            new int[] {0, 1, 0, 0, 0, 1},
	            new int[] {2, 1, 0, 0, 0},
	            new int[] {0, 1, 0, 0, 0, 1}
	        ),
	        
	        new CardChoiceCase(
	            new int[] {1, 0, 0, 1, 0},
	            new int[] {0, 1, 0, 0, 0, 2},
	            new int[] {2, 1, 0, 2, 0},
	            new int[] {0, 1, 0, 0, 0, 2}
	        )
		);
	}
	
	@ParameterizedTest(name = "case #{index}")
	@MethodSource("cardChoice_ValidCases")
	void checkCardChoice_validcases(CardChoiceCase c) {
        Player player = new Player();
        player.addTokens(c.tokens);
        
        for(int i = 0; i < c.gems.length; ++i) {
        	if(c.gems[i] > 0) {
        		for(int j = 0; j < c.gems[i]; ++j)
        			player.addCard(new Card(1, 0, new int[] {0, 0, 0, 0, 0}, Gem.valueOf(i), ""));
        	}
        }

        Card card = new Card(1, 0, c.cost, Gem.DIAMOND, "");
        Optional<int[]> result = player.checkCardChoice(card);
        assertTrue(result.isPresent());
        assertArrayEquals(c.expected, result.get());
	}
	
	static Stream<CardChoiceCase> cardChoice_InvalidCases() {
		return Stream.of(
			new CardChoiceCase(
	            new int[] {0, 0, 0, 0, 0},
	            new int[] {1, 1, 0, 0, 0, 0},
	            new int[] {2, 1, 0, 0, 0},
	            null
	        ),
	        
	        new CardChoiceCase(
	            new int[] {0, 2, 2, 0, 0},
	            new int[] {0, 0, 0, 2, 0, 0},
	            new int[] {0, 3, 1, 2, 0},
	            null
	        ),
	        
	        new CardChoiceCase(
	            new int[] {0, 1, 2, 2, 0},
	            new int[] {0, 0, 0, 1, 0, 1},
	            new int[] {0, 3, 1, 2, 0},
	            null
	        ),

	        new CardChoiceCase(
	            new int[] {1, 0, 1, 2, 1},
	            new int[] {1, 1, 0, 0, 0, 1},
	            new int[] {2, 1, 1, 3, 2},
	            null
	        )
		);
	}
	
	@ParameterizedTest(name = "case #{index}")
	@MethodSource("cardChoice_InvalidCases")
	void checkCardChoice_invalidcases(CardChoiceCase c) {
	    Player player = new Player();
        player.addTokens(c.tokens);
        
        for(int i = 0; i < c.gems.length; ++i) {
        	if(c.gems[i] > 0) {
        		for(int j = 0; j < c.gems[i]; ++j)
        			player.addCard(new Card(1, 0, new int[] {0, 0, 0, 0, 0}, Gem.valueOf(i), ""));
        	}
        }

        Card card = new Card(1, 0, c.cost, Gem.DIAMOND, "");
        Optional<int[]> result = player.checkCardChoice(card);
        assertFalse(result.isPresent());
	}
	
	record LegendCardCase(
		int[] gems,
	    Card[] legendCards,
	    List<Integer> expected
	) {}
	
	
	static Stream<LegendCardCase> legendCardCases() {
		return Stream.of(
			new LegendCardCase(
	        	new int[] {0, 3, 3, 0, 3},
	            new Card[] {
	            	new Card(0, 0, new int[] {3, 3, 0, 3, 0}, Gem.DIAMOND, ""),	
	            	new Card(0, 0, new int[] {0, 3, 3, 0, 3}, Gem.DIAMOND, ""),	
	            	new Card(0, 0, new int[] {0, 3, 0, 3, 3}, Gem.DIAMOND, ""),	
	            	new Card(0, 0, new int[] {4, 4, 0, 0, 0}, Gem.DIAMOND, "")
	            },
	            List.of(1)
	        ),
	        
	        new LegendCardCase(
	        	new int[] {0, 3, 3, 4, 4},
	            new Card[] {
	            	new Card(0, 0, new int[] {3, 3, 0, 3, 0}, Gem.DIAMOND, ""),	
	            	new Card(0, 0, new int[] {0, 3, 3, 0, 3}, Gem.DIAMOND, ""),	
	            	new Card(0, 0, new int[] {0, 3, 0, 3, 3}, Gem.DIAMOND, ""),	
	            	new Card(0, 0, new int[] {4, 4, 0, 0, 0}, Gem.DIAMOND, "")
	            },
	            List.of(1, 2)
	        ),
	        
	        new LegendCardCase(
	        	new int[] {5, 5, 0, 0, 0},
	            new Card[] {
	            	new Card(0, 0, new int[] {3, 3, 0, 3, 0}, Gem.DIAMOND, ""),	
	            	new Card(0, 0, new int[] {0, 3, 3, 0, 3}, Gem.DIAMOND, ""),	
	            	null,	
	            	new Card(0, 0, new int[] {4, 4, 0, 0, 0}, Gem.DIAMOND, "")
	            },
	            List.of(3)
	        ),
	        
	        new LegendCardCase(
	        	new int[] {2, 3, 0, 0, 3},
	            new Card[] {
	            	new Card(0, 0, new int[] {3, 3, 0, 3, 0}, Gem.DIAMOND, ""),	
	            	new Card(0, 0, new int[] {0, 3, 3, 0, 3}, Gem.DIAMOND, ""),	
	            	null,	
	            	new Card(0, 0, new int[] {4, 4, 0, 0, 0}, Gem.DIAMOND, "")
	            },
	            List.of()
	        )
		);
	}
	
	@ParameterizedTest(name = "case #{index}")
	@MethodSource("legendCardCases")
	void checkLegendCards_cases(LegendCardCase c) {
		Player player = new Player();
        for(int i = 0; i < c.gems.length; ++i) {
        	if(c.gems[i] > 0) {
        		for(int j = 0; j < c.gems[i]; ++j)
        			player.addCard(new Card(1, 0, new int[] {0, 0, 0, 0, 0}, Gem.valueOf(i), ""));
        	}
        }
        
        List<Integer> result = player.checkLegendCards(c.legendCards);
        assertEquals(c.expected, result);
	}

}
