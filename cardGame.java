import java.io.IOException;

public class cardGame {
	public static void main(String[] args) throws IOException {
		deckOfCards deck = new deckOfCards();
		deck.createDeckOfCards();
		deck.shuffle();
		new GUI();
	}
}

