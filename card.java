public class card {
    private java.awt.image.BufferedImage cardImage;
    private int value;
    private String rank, suit;

    
    public card(String rank, String suit, int value, java.awt.image.BufferedImage cardImage) {
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
    public void getCardImage(BufferedImage card) {

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