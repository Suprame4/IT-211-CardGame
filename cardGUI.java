import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class cardGUI implements ItemListener, ActionListener {
  private ImageIcon cardBack;
  private ImageIcon cardImg;
  private JTextArea dropDownText;
  private JFrame window;
  private JPanel gameContainer;
  private JPanel dropDownContainer;
  private JTextArea gameInfo;
  private JComboBox suits;
  private JComboBox ranks;
  private JButton buttonGo;
  private String suitGuess;
  private String rankGuess;
  private String combinedGuess;
  private JLabel imgHolder;
  private card currentCard;

  public int wins = 0;
  public int count = 0;
  public int cardsLeft = 52;


  public cardGUI() throws IOException {
    // Frame creation
    window = new JFrame("Card Game");
    // gameContainer creation
    gameContainer = new JPanel(new GridLayout(3, 3, 10, 10));

    // game info for player
    gameInfo = new JTextArea("Correct Guesses: " + wins + "\nTotal Attempts: " + count + "\nCards Left: " + cardsLeft);
    gameInfo.setEditable(false);

    // dropdown lists creation
    suits = new JComboBox<>(card.Suit.values());
    ranks = new JComboBox<>(card.Rank.values());  

    // dropdown listeners
    suits.addItemListener(this);
    ranks.addItemListener(this);

    // Instructions for game
    dropDownText = new JTextArea("Guess the next card from the suit and rank selection\nPlease select something in BOTH drop downs first or it will not work and return null");
    dropDownText.setEditable(false);

    dropDownContainer = new JPanel(new GridLayout(1, 3));
    dropDownContainer.add(ranks);
    dropDownContainer.add(new JLabel("of", JLabel.CENTER));
    dropDownContainer.add(suits);

    // set card pictures
    cardBack = new ImageIcon(ImageIO.read(new File("cards/b.gif")));
    cardImg = new ImageIcon();
    imgHolder = new JLabel(cardImg);
    
    // create button to guess
    buttonGo = new JButton("Click me to guess");
    buttonGo.addActionListener(this);

    // default closing operation and addition of gameContainer to window
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.add(gameContainer);

    gameContainer.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
    gameContainer.add(new JLabel(cardBack));
    gameContainer.add(imgHolder);
    gameContainer.add(dropDownText);
    gameContainer.add(gameInfo);
    gameContainer.add(buttonGo);
    gameContainer.add(dropDownContainer);

    window.pack();
    window.setVisible(true);
  }

  // unneeded method, wanted to make sure all cards would work
  private void printEntireDeck() {
    int n = 0;
    for (card c : deckOfCards.deck) {
      cardImg = new ImageIcon(deckOfCards.deck[n].getCardImage());
      gameContainer.add(new JLabel(cardImg));
      deckOfCards.deck[n] = c;
      n++;
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    currentCard = cardGame.deck.deal();

    if (currentCard == null)
      return;
      
    if (cardsLeft > 0)
      cardImg.setImage(currentCard.getCardImage());

    System.out.println(currentCard.toString());
    System.out.println(combinedGuess);

    if (combinedGuess.equalsIgnoreCase(currentCard.toString()))
      wins++;

    imgHolder.repaint();

    cardsLeft--;
    count++;
    gameInfo.setText("Correct Guesses: " + wins + "\nTotal Attempts: " + count + "\nCards Left: " + cardsLeft);
  }

  @Override
  public void itemStateChanged(ItemEvent e) {
    Object source = e.getItemSelectable();
    
    if(source == suits)
      suitGuess = suits.getSelectedItem().toString();

    if(source == ranks)
      rankGuess = ranks.getSelectedItem().toString();

    combinedGuess = rankGuess + " of " + suitGuess;
  }
}