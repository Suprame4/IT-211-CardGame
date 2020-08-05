import java.awt.BorderLayout;
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
  private JLabel cardBack;
  private JLabel cardImg;
  private JTextArea dropDownText;
  private JFrame window;
  private JPanel gameContainer;
  private JPanel dropDownContainer;
  private JTextArea gameInfo;
  private JComboBox suits;
  private JComboBox ranks;
  private JButton buttonGo;
  private JButton buttonSubtract;

  public int wins = 0;
  public int count = 0;
  public int cardsLeft = 52;

  public cardGUI() throws IOException {
    // Frame creation
    window = new JFrame("Card Game");
    // gameContainer creation
    gameContainer = new JPanel(new GridLayout(3, 3, 10, 10));

    //game info for player
    gameInfo = new JTextArea("Correct Guesses: " 
                              + wins
                            + "\nTotal Attempts: "
                              + count
                            +  "\nCards Left: "
                              + cardsLeft);
    gameInfo.setEditable(false);

    // dropdown lists creation
    suits = new JComboBox<>(card.Suit.values());
    ranks = new JComboBox<>(card.Rank.values());

    // dropdown listeners
    suits.addItemListener(this);
    ranks.addItemListener(this);

    // Instructions for game
    dropDownText = new JTextArea("Guess the next card from the suit and rank selection");
    dropDownText.setEditable(false);

    dropDownContainer = new JPanel(new GridLayout(1, 3));
    dropDownContainer.add(ranks);
    dropDownContainer.add(new JLabel("of", JLabel.CENTER));
    dropDownContainer.add(suits);

    // set card pictures
    cardBack = new JLabel(new ImageIcon(ImageIO.read(new File("cards/b.gif"))));
    
    cardImg = new JLabel(new ImageIcon(deckOfCards.deck[1].getCardImage()));

    // create button to guess
    buttonGo = new JButton("Click me to guess");

    // default closing operation and addition of gameContainer to window
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.add(gameContainer);

    gameContainer.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
    gameContainer.add(cardBack);
    gameContainer.add(cardImg);
    gameContainer.add(buttonGo);
    gameContainer.add(dropDownContainer);
    gameContainer.add(gameInfo);
    gameContainer.add(dropDownText);

    window.pack();
    window.setVisible(true);
  }

  private void printEntireDeck() {
    int n = 0;
    for (card c : deckOfCards.deck) {
      cardImg = new JLabel(new ImageIcon(deckOfCards.deck[n].getCardImage()));
      cardImg.setSize(50, 80);
      gameContainer.add(cardImg);
      deckOfCards.deck[n] = c;
      n++;
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String actionCommand = e.getActionCommand();

    if (actionCommand.equals("Reset")) {
      count = 0;
    } else if (actionCommand.equals("Add")) {
      count++;
    } else if (actionCommand.equals("Subtract")) {
      count--;
    }

    cardImg.setText("Number of clicks: " + count);
  }

  @Override
  public void itemStateChanged(ItemEvent e) {


  }

}