import java.io.IOException;

public class cardGame {
	public static deckOfCards deck = new deckOfCards();

	public static void main(String[] args) throws IOException {
		deck.createDeckOfCards();
		// deck.shuffle();
		new cardGUI();
	}
}

