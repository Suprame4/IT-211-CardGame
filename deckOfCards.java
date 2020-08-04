import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class deckOfCards {
	private card[] deck;
	private int currentCard; // index of the next card to be dealt

	public card[] createDeckOfCards() throws IOException {
		deck = new card[52];
		int i = 0;
		//for loop through 4 suits
		for (card.Suit s : card.Suit.values()){
			// for loop through 13 ranks
			for (card.Rank r : card.Rank.values()){
				deck[i] = new card (r.getRank(),
														s.getSuit(),
														r.getRankValue(),
														ImageIO.read(new File("cards/" + r.getImgAbbr() + s.getImgAbbr() + ".gif")));                   
				i++;
			}
		}
		return deck;
	}

	public card[] shuffle() {
		//create randomizer variable
		Random rand = new Random();
		card temp;

		//loop through deck
		for(int i = 0; i < deck.length; i++) {
			//set variable equal to a random number
			int num = rand.nextInt(deck.length - 1);
			//temp number becomes equal 
			temp = deck[i];
			deck[i] = deck[num];
			deck[num] = temp;
			System.out.println(deck[i]);
		}
		return deck;
	}

	public void deal(){
		
	}
}