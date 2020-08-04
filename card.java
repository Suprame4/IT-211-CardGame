import java.awt.image.BufferedImage;

public class card {
    private BufferedImage cardImage;
    private int value;
    private String rank, suit;

    
    public card(String rank, String suit, int value, BufferedImage cardImage) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
        this.cardImage = cardImage;
    }

    //Returns string values from 
    public String toString(){
        return rank + " of " + suit;
    }

    //Returns image for a card
    public void getCardImage(BufferedImage cardImage) {

    }

    //Returns numeric value of Card object
    public int getRankValue(){
        return value;
    }
    
    //Returns suit of Card object
    public String getSuit(){
        return suit;
    }

    
}