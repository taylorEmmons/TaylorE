package casino;

public class Casino {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeckOfCards deck = new DeckOfCards(52);
		deck.shuffle(52);
			System.out.println(deck.deal(0).toString());
			System.out.println(deck.deal(0).toString());
	}

}
