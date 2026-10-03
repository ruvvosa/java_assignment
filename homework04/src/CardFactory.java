import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CardFactory {

    private CardFactory() {}

    private static final List<List<Card>> decks = new ArrayList<>(Card.NUM_CARD_LEVELS);
	static {
		decks.add(Collections.unmodifiableList(buildNobleCards()));
		decks.add(Collections.unmodifiableList(buildLevel1Cards()));
		decks.add(Collections.unmodifiableList(buildLevel2Cards()));
		decks.add(Collections.unmodifiableList(buildLevel3Cards()));
	}
    
    public static List<List<Card>> getOriginalDecks() {
        return decks;
    }

    // ── Noble cards (level 0) ────────────────────────────────────────────────
    private static List<Card> buildNobleCards() {
        List<Card> deck = new ArrayList<>(10);
        deck.add(new Card(0, 3, new int[]{3, 3, 3, 0, 0}, Gem.RUBY, "image/000.png")); // 000: gerard
        deck.add(new Card(0, 3, new int[]{3, 0, 0, 3, 3}, Gem.ONYX, "image/001.png")); // 001: baggio
        deck.add(new Card(0, 3, new int[]{0, 3, 3, 3, 0}, Gem.ONYX, "image/002.png")); // 002: platini
        deck.add(new Card(0, 3, new int[]{0, 0, 3, 3, 3}, Gem.ONYX, "image/003.png")); // 003: daglish
        deck.add(new Card(0, 3, new int[]{3, 3, 0, 0, 3}, Gem.RUBY, "image/004.png")); // 004: zico
        deck.add(new Card(0, 3, new int[]{0, 0, 4, 4, 0}, Gem.RUBY, "image/005.png")); // 005: zidane
        deck.add(new Card(0, 3, new int[]{0, 0, 0, 4, 4}, Gem.ONYX, "image/006.png")); // 006: maradona
        deck.add(new Card(0, 3, new int[]{0, 4, 4, 0, 0}, Gem.ONYX, "image/007.png")); // 007: best
        deck.add(new Card(0, 3, new int[]{4, 4, 0, 0, 0}, Gem.ONYX, "image/008.png")); // 008: cryuff
        deck.add(new Card(0, 3, new int[]{4, 0, 0, 0, 4}, Gem.RUBY, "image/009.png")); // 009: pele
        return deck;
    }

    // ── Level-1 development cards ────────────────────────────────────────────
    private static List<Card> buildLevel1Cards() {
        List<Card> deck = new ArrayList<>(20);
        deck.add(new Card(1, 3, new int[]{0, 3, 3, 5, 3}, Gem.DIAMOND, "image/100.png"));    // 100: vinnie
        deck.add(new Card(1, 4, new int[]{0, 0, 0, 0, 7}, Gem.DIAMOND, "image/101.png"));    // 101: mbappe 
        deck.add(new Card(1, 4, new int[]{3, 0, 0, 3, 6}, Gem.DIAMOND, "image/102.png"));    // 102: bellingham
        deck.add(new Card(1, 5, new int[]{4, 0, 0, 0, 7}, Gem.DIAMOND, "image/103.png"));    // 103: TAA

        deck.add(new Card(1, 3, new int[]{3, 0, 3, 3, 5}, Gem.SAPPHIRE, "image/104.png"));   // 104: yamal
        deck.add(new Card(1, 4, new int[]{7, 0, 0, 0, 0}, Gem.SAPPHIRE, "image/105.png"));   // 105: kdb
        deck.add(new Card(1, 4, new int[]{6, 3, 0, 0, 3}, Gem.SAPPHIRE, "image/106.png"));   // 106: haland
        deck.add(new Card(1, 5, new int[]{7, 3, 0, 0, 0}, Gem.SAPPHIRE, "image/107.png"));   // 107: messi
        
        deck.add(new Card(1, 3, new int[]{5, 3, 0, 3, 3}, Gem.EMERALD, "image/108.png"));    // 108: allison
        deck.add(new Card(1, 4, new int[]{3, 6, 3, 0, 0}, Gem.EMERALD, "image/109.png"));    // 109: kvaratskhelia
        deck.add(new Card(1, 4, new int[]{0, 7, 0, 0, 0}, Gem.EMERALD, "image/110.png"));    // 110: dembele
        deck.add(new Card(1, 5, new int[]{0, 7, 3, 0, 0}, Gem.EMERALD, "image/111.png"));    // 111: ronaldo

        deck.add(new Card(1, 3, new int[]{3, 5, 3, 0, 3}, Gem.RUBY, "image/112.png"));       // 112: vvd
        deck.add(new Card(1, 4, new int[]{0, 3, 6, 3, 0}, Gem.RUBY, "image/113.png"));       // 113: szbo
        deck.add(new Card(1, 4, new int[]{0, 0, 7, 0, 0}, Gem.RUBY, "image/114.png"));       // 114: modric
        deck.add(new Card(1, 5, new int[]{0, 0, 7, 3, 0}, Gem.RUBY, "image/115.png"));       // 115: olise
        
        deck.add(new Card(1, 3, new int[]{3, 3, 5, 3, 0}, Gem.ONYX, "image/116.png"));       // 116: son
        deck.add(new Card(1, 4, new int[]{0, 0, 0, 7, 0}, Gem.ONYX, "image/117.png"));       // 117: pedri
        deck.add(new Card(1, 4, new int[]{0, 0, 3, 6, 3}, Gem.ONYX, "image/118.png"));       // 118: salah
        deck.add(new Card(1, 5, new int[]{0, 0, 0, 7, 3}, Gem.ONYX, "image/119.png"));       // 119: kane
        return deck;
    }

    // ── Level-2 development cards ────────────────────────────────────────────
    private static List<Card> buildLevel2Cards() {
        List<Card> deck = new ArrayList<>(30);
        deck.add(new Card(2, 1, new int[]{2, 3, 0, 3, 0}, Gem.DIAMOND, "image/200.png"));    // 200: saliba
        deck.add(new Card(2, 1, new int[]{0, 3, 2, 0, 2}, Gem.DIAMOND, "image/201.png"));    // 201: van de van
        deck.add(new Card(2, 2, new int[]{0, 0, 1, 4, 2}, Gem.DIAMOND, "image/202.png"));    // 202: alvalez
        deck.add(new Card(2, 2, new int[]{0, 0, 0, 5, 3}, Gem.DIAMOND, "image/203.png"));    // 203: foden
        deck.add(new Card(2, 2, new int[]{0, 0, 0, 5, 0}, Gem.DIAMOND, "image/204.png"));    // 204: rodri
        deck.add(new Card(2, 3, new int[]{6, 0, 0, 0, 0}, Gem.DIAMOND, "image/205.png"));    // 205: valverde

        deck.add(new Card(2, 1, new int[]{0, 2, 3, 0, 3}, Gem.SAPPHIRE, "image/206.png"));   // 206: bastoni
        deck.add(new Card(2, 1, new int[]{0, 2, 2, 3, 0}, Gem.SAPPHIRE, "image/207.png"));   // 207: hakimi
        deck.add(new Card(2, 2, new int[]{5, 3, 0, 0, 0}, Gem.SAPPHIRE, "image/208.png"));   // 208: grealish
        deck.add(new Card(2, 2, new int[]{0, 5, 0, 0, 0}, Gem.SAPPHIRE, "image/209.png"));   // 209: caceido
        deck.add(new Card(2, 2, new int[]{2, 1, 0, 0, 4}, Gem.SAPPHIRE, "image/210.png"));   // 210: palmer
        deck.add(new Card(2, 3, new int[]{0, 6, 0, 0, 0}, Gem.SAPPHIRE, "image/211.png"));   // 211: kang in

        deck.add(new Card(2, 1, new int[]{2, 3, 0, 0, 2}, Gem.EMERALD, "image/212.png"));    // 212: mane
        deck.add(new Card(2, 1, new int[]{3, 0, 2, 3, 0}, Gem.EMERALD, "image/213.png"));    // 213: neur
        deck.add(new Card(2, 2, new int[]{0, 0, 5, 0, 0}, Gem.EMERALD, "image/214.png"));    // 214: vitinha
        deck.add(new Card(2, 2, new int[]{0, 5, 3, 0, 0}, Gem.EMERALD, "image/215.png"));    // 215: lewan
        deck.add(new Card(2, 2, new int[]{4, 2, 0, 0, 1}, Gem.EMERALD, "image/216.png"));    // 216: odegaard
        deck.add(new Card(2, 3, new int[]{0, 0, 6, 0, 0}, Gem.EMERALD, "image/217.png"));    // 217: gavi

        deck.add(new Card(2, 1, new int[]{0, 3, 2, 0, 3}, Gem.RUBY, "image/218.png"));       // 218: writz
        deck.add(new Card(2, 1, new int[]{2, 2, 0, 3, 0}, Gem.RUBY, "image/219.png"));       // 219: macallister
        deck.add(new Card(2, 2, new int[]{1, 4, 2, 0, 0}, Gem.RUBY, "image/220.png"));       // 220: saka
        deck.add(new Card(2, 2, new int[]{0, 0, 0, 0, 5}, Gem.RUBY, "image/221.png"));       // 221: musiala
        deck.add(new Card(2, 2, new int[]{3, 0, 0, 0, 5}, Gem.RUBY, "image/222.png"));       // 222: diaz
        deck.add(new Card(2, 3, new int[]{0, 0, 0, 6, 0}, Gem.RUBY, "image/223.png"));       // 223: rice

        deck.add(new Card(2, 1, new int[]{3, 0, 3, 0, 2}, Gem.ONYX, "image/224.png"));       // 224: joao neves
        deck.add(new Card(2, 1, new int[]{3, 2, 2, 0, 0}, Gem.ONYX, "image/225.png"));       // 225: bruno
        deck.add(new Card(2, 2, new int[]{5, 0, 0, 0, 0}, Gem.ONYX, "image/226.png"));       // 226: rogers
        deck.add(new Card(2, 2, new int[]{0, 1, 4, 2, 0}, Gem.ONYX, "image/227.png"));       // 227: tonali
        deck.add(new Card(2, 2, new int[]{0, 0, 5, 3, 0}, Gem.ONYX, "image/228.png"));       // 228: guimaraes
        deck.add(new Card(2, 3, new int[]{0, 0, 0, 0, 6}, Gem.ONYX, "image/229.png"));       // 229: courtoui
        return deck;
    }

    // ── Level-3 development cards ────────────────────────────────────────────
    private static List<Card> buildLevel3Cards() {
        List<Card> deck = new ArrayList<>(40);
        deck.add(new Card(3, 0, new int[]{0, 2, 2, 0, 1}, Gem.DIAMOND, "image/300.png"));    // 300: heechan
        deck.add(new Card(3, 0, new int[]{3, 1, 0, 0, 1}, Gem.DIAMOND, "image/301.png"));    // 301: marmoush
        deck.add(new Card(3, 0, new int[]{0, 1, 1, 1, 1}, Gem.DIAMOND, "image/302.png"));    // 302: gallagher
        deck.add(new Card(3, 0, new int[]{0, 3, 0, 0, 0}, Gem.DIAMOND, "image/303.png"));    // 303: semenyo
        deck.add(new Card(3, 0, new int[]{0, 2, 0, 0, 2}, Gem.DIAMOND, "image/304.png"));    // 304: de paul
        deck.add(new Card(3, 0, new int[]{0, 0, 0, 2, 1}, Gem.DIAMOND, "image/305.png"));    // 305: huijsen
        deck.add(new Card(3, 0, new int[]{0, 1, 2, 1, 1}, Gem.DIAMOND, "image/306.png"));    // 306: mctominay
        deck.add(new Card(3, 1, new int[]{0, 0, 4, 0, 0}, Gem.DIAMOND, "image/307.png"));    // 307: wharton

        deck.add(new Card(3, 0, new int[]{0, 1, 3, 1, 0}, Gem.SAPPHIRE, "image/308.png"));   // 308: mitoma
        deck.add(new Card(3, 0, new int[]{1, 0, 2, 2, 0}, Gem.SAPPHIRE, "image/309.png"));   // 309: garner
        deck.add(new Card(3, 0, new int[]{0, 0, 0, 0, 3}, Gem.SAPPHIRE, "image/310.png"));   // 310: cowill
        deck.add(new Card(3, 0, new int[]{1, 0, 0, 0, 2}, Gem.SAPPHIRE, "image/311.png"));   // 311: james
        deck.add(new Card(3, 0, new int[]{1, 0, 1, 2, 1}, Gem.SAPPHIRE, "image/312.png"));   // 312: cucurella
        deck.add(new Card(3, 0, new int[]{0, 0, 2, 0, 2}, Gem.SAPPHIRE, "image/313.png"));   // 313: enzo fernandez
        deck.add(new Card(3, 0, new int[]{1, 0, 1, 1, 1}, Gem.SAPPHIRE, "image/314.png"));   // 314: marquihos
        deck.add(new Card(3, 1, new int[]{0, 0, 0, 4, 0}, Gem.SAPPHIRE, "image/315.png"));   // 315: nunez

        deck.add(new Card(3, 0, new int[]{1, 1, 0, 1, 1}, Gem.EMERALD, "image/316.png"));    // 316: anderson
        deck.add(new Card(3, 0, new int[]{0, 0, 0, 3, 0}, Gem.EMERALD, "image/317.png"));    // 317: gibs white
        deck.add(new Card(3, 0, new int[]{0, 2, 0, 2, 0}, Gem.EMERALD, "image/318.png"));    // 318: pickford
        deck.add(new Card(3, 0, new int[]{1, 1, 0, 1, 2}, Gem.EMERALD, "image/319.png"));    // 319: davies
        deck.add(new Card(3, 0, new int[]{2, 1, 0, 0, 0}, Gem.EMERALD, "image/320.png"));    // 320: in beom
        deck.add(new Card(3, 0, new int[]{1, 3, 1, 0, 0}, Gem.EMERALD, "image/321.png"));    // 321: kimmish
        deck.add(new Card(3, 0, new int[]{0, 1, 0, 2, 2}, Gem.EMERALD, "image/322.png"));    // 322: torres
        deck.add(new Card(3, 1, new int[]{0, 0, 0, 0, 4}, Gem.EMERALD, "image/323.png"));    // 323: min jae

        deck.add(new Card(3, 0, new int[]{2, 1, 1, 0, 1}, Gem.RUBY, "image/324.png"));       // 324: isak
        deck.add(new Card(3, 0, new int[]{2, 0, 0, 2, 0}, Gem.RUBY, "image/325.png"));       // 325: ekiteke
        deck.add(new Card(3, 0, new int[]{1, 1, 1, 0, 1}, Gem.RUBY, "image/326.png"));       // 326: chiesa
        deck.add(new Card(3, 0, new int[]{2, 0, 1, 0, 2}, Gem.RUBY, "image/327.png"));       // 327: mount
        deck.add(new Card(3, 0, new int[]{1, 0, 0, 1, 3}, Gem.RUBY, "image/328.png"));       // 328: gravenberch
        deck.add(new Card(3, 0, new int[]{3, 0, 0, 0, 0}, Gem.RUBY, "image/329.png"));       // 329: eze
        deck.add(new Card(3, 0, new int[]{0, 2, 1, 0, 0}, Gem.RUBY, "image/330.png"));       // 330: scott
        deck.add(new Card(3, 1, new int[]{4, 0, 0, 0, 0}, Gem.RUBY, "image/331.png"));       // 331: robertson
        
        deck.add(new Card(3, 0, new int[]{0, 0, 1, 3, 1}, Gem.ONYX, "image/332.png"));       // 332: barkley
        deck.add(new Card(3, 0, new int[]{1, 1, 1, 1, 0}, Gem.ONYX, "image/333.png"));       // 333: sancho
        deck.add(new Card(3, 0, new int[]{2, 0, 2, 0, 0}, Gem.ONYX, "image/334.png"));       // 334: gordon
        deck.add(new Card(3, 0, new int[]{2, 2, 0, 1, 0}, Gem.ONYX, "image/335.png"));       // 335: oblak
        deck.add(new Card(3, 0, new int[]{0, 0, 3, 0, 0}, Gem.ONYX, "image/336.png"));       // 336: rashford
        deck.add(new Card(3, 0, new int[]{0, 0, 2, 1, 0}, Gem.ONYX, "image/337.png"));       // 337: martinez
        deck.add(new Card(3, 0, new int[]{1, 2, 1, 1, 0}, Gem.ONYX, "image/338.png"));       // 338: oshimen
        deck.add(new Card(3, 1, new int[]{0, 4, 0, 0, 0}, Gem.ONYX, "image/339.png"));       // 339: gyu sung
        return deck;
    }
    
    public static List<Card> buildBackCards() {
    	List<Card> deck = new ArrayList<>(4);
    	deck.add(new Card(3, 0, new int[]{0, 0, 0, 0, 0}, Gem.DIAMOND, "image/legend.png"));    
        deck.add(new Card(3, 1, new int[]{0, 0, 0, 0, 0}, Gem.DIAMOND, "image/level1.png"));   
        deck.add(new Card(3, 2, new int[]{0, 0, 0, 0, 0}, Gem.DIAMOND, "image/level2.png"));    
        deck.add(new Card(3, 3, new int[]{0, 0, 0, 0, 0}, Gem.DIAMOND, "image/level3.png"));
        return deck;
    }
}
