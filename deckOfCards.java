import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class deckOfCards {
    private card[] deck;
    private int currentCard; // index of the next card to be dealt

    public deckOfCards() throws IOException {
        deck = new card[52];
        int i = 0;
        for (card.Suit s : card.Suit.values()){
            for (card.Rank r : card.Rank.values()){
                deck[i] = new card (r.getRank(), s, r.getRankValue(), ImageIO.read(new File ("cards/" + s.getImgAbbr() + r.getImgAbbr() + ".gif")));
                i++;
            }
        }
    }
    public static void main(String[] args) {

    }

    public void shuffle() {
        
    }

    public void deal(){
        
    }
}