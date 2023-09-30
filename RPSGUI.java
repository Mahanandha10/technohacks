package dow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class RPSGUI {
	

	
	    private JFrame frame;
	    private JPanel panel;
	    private JButton rockButton, paperButton, scissorsButton;
	    private JLabel resultLabel;

	    public RPSGUI() {
	        frame = new JFrame("RPS Game");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(300, 200);
            ImageIcon image = new ImageIcon("C:/Users/DELL/eclipse-workspace/dow/src/dow/rps1.png") ; 
            frame.setIconImage(image.getImage());
	        panel = new JPanel();
	        panel.setLayout(new GridLayout(4, 1));

	        rockButton = new JButton("Rock");
	        paperButton = new JButton("Paper");
	        scissorsButton = new JButton("Scissors");
	        resultLabel = new JLabel("");

	        rockButton.addActionListener(new ButtonClickListener("Rock"));
	        paperButton.addActionListener(new ButtonClickListener("Paper"));
	        scissorsButton.addActionListener(new ButtonClickListener("Scissors"));

	        panel.add(rockButton);
	        panel.add(paperButton);
	        panel.add(scissorsButton);
	        panel.add(resultLabel);

	        frame.add(panel);
	        frame.setVisible(true);
	    }

	    private class ButtonClickListener implements ActionListener {
	        private String userChoice;

	        public ButtonClickListener(String choice) {
	            userChoice = choice;
	        }

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String[] options = {"Rock", "Paper", "Scissors"};
	            Random random = new Random();
	            int computerChoiceIndex = random.nextInt(3);
	            String computerChoice = options[computerChoiceIndex];

	            String result = determineWinner(userChoice, computerChoice);
	            resultLabel.setText("Computer chose " + computerChoice + ". " + result);
	        }

	        private String determineWinner(String userChoice, String computerChoice) {
	            if (userChoice.equalsIgnoreCase(computerChoice)) {
	                return "It's a tie!";
	            } else if ((userChoice.equalsIgnoreCase("Rock") && computerChoice.equalsIgnoreCase("Scissors")) ||
	                    (userChoice.equalsIgnoreCase("Scissors") && computerChoice.equalsIgnoreCase("Paper")) ||
	                    (userChoice.equalsIgnoreCase("Paper") && computerChoice.equalsIgnoreCase("Rock"))) {
	                return "You win!";
	            } else {
	                return "Computer wins!";
	            }
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new RPSGUI());
	    }
	}
