import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class cardGUI implements ActionListener{
	private int count = 0;
	private JLabel card;
	private JFrame window;
	private JPanel container;
	private JButton buttonAdd;
	private JButton buttonReset;
  private JButton buttonSubtract;

  public cardGUI(){
		//Frame creation
    window = new JFrame("Card Game");
    container = new JPanel(new BorderLayout());
    
    window.setSize(400,600);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);
    window.add(container);
    
		container.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    container.setLayout(new GridLayout(4, 13));
    
    int n = 0;// Which card.
    for(card c : deckOfCards.deck) {
      card = new JLabel(new ImageIcon(deckOfCards.deck[n].getCardImage()));
      card.setSize(50, 80);
      container.add(card);
      deckOfCards.deck[n] = c;
      n++;
    }
    
    window.setVisible(true);
	}
  @Override
  public void actionPerformed(ActionEvent e) {
    String actionCommand = e.getActionCommand();
		
		if(actionCommand.equals("Reset")){
			count = 0;
		}else if (actionCommand.equals("Add")) {
			count++;
		}else if (actionCommand.equals("Subtract")) {
			count--;
		}
		
		card.setText("Number of clicks: " + count);
	}

}