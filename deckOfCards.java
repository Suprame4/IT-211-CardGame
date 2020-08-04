import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class deckOfCards {
    private card[] deck;
    private int currentCard; // index of the next card to be dealt

    public deckOfCards() throws IOException {
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
                System.out.println(deck[i]);                    
                i++;
            }
        }
    }

    public void shuffle() {

    }

    public void deal(){
        
    }
}