package casino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DeckOfCards {
	
	private int numOfCards;
	private ArrayList<Card> cards;
	
	public DeckOfCards(int numOfCards) {
		cards = new ArrayList<Card>();
		genDeck(numOfCards);
	}
	
	private void genDeck(int numOfCards) {
		int i = 0;
			for(House house : House.values()) {
				for(Value value : Value.values()) {
					cards.add(new Card(house,value,i));
					i++;
				}
			}
	}

	public void shuffle(int strength) {
		Collections.shuffle(cards);
		
		for(Card card : cards) {		
		//	System.out.println(card.toString());
		}
	}
	
	public Card deal(int i) {
		Random rand = new Random();

		return cards.get(rand.nextInt(52));
	}
	
	public int getNumOfCards() {
		return numOfCards;
	}

	public void setNumOfCards(int numOfCards) {
		this.numOfCards = numOfCards;
	}
}

