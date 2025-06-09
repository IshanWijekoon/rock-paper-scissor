import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// frontend
@SuppressWarnings("serial")
public class RockPaperScissorGUI extends JFrame implements ActionListener{
	//player buttons
	JButton rockButton, paperButton, scissorButton;
	
	// will display the choice of the computer
	JLabel computerChoice;
	
	// will display the score of the computer and the player
	JLabel computerScoreLabel, playerScoreLabel;
	
	// backend obj
	RockPaperScissor rockPaperScissor;
	
	public RockPaperScissorGUI(){
		// invoke jframe constructor and add title to the GUI
		super("Rock Paper Scissor");
	
		// set the size of the GUI
		setSize(450, 574);
		
		// set layout to null to disable layout management, so we can use absolute positionaning for the elements
		// (i.e. setting x,y coordinates and width/height values)
		setLayout(null);
		
		// terminate the java cirual machine when closing the GUI
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// load GUI in the center of the screen every time we run the application
		setLocationRelativeTo(null);
		
		// initialize the backend obj
		rockPaperScissor = new RockPaperScissor();
		
		// add GUI components
		addGuiComponents();
	}
	
	public void addGuiComponents() {
		// create computer score lable
		computerScoreLabel = new JLabel("Computer: 0");
		
		
		// set x,y coordinates and width/height values
		computerScoreLabel.setBounds(0, 43, 450, 30);
		
		// set the font to have font family of dialog, font-weight of bold, and font-size of 26
		computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
		
		// place the text in the center
		computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Add the label to the JFrame
	    add(computerScoreLabel);
	    
	    // create computer choice
	    computerChoice = new JLabel("?");
	    computerChoice.setBounds(175, 118, 98, 81);
	    computerChoice.setFont(new Font("Dialog", Font.PLAIN, 18));
	    computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    // create a black border around
	    computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    add(computerChoice);
	    
	    // create player score label
	    playerScoreLabel = new JLabel("Player: 0");
	    playerScoreLabel.setBounds(0, 317, 450, 30);
	    playerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
	    playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    add(playerScoreLabel);
	    
	    // player buttons
	    
	    // rock button
	    rockButton = new JButton("Rock");
	    rockButton.setBounds(40, 387, 105, 81);
	    rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
	    rockButton.addActionListener(this);
	    add(rockButton);
	    
	    // paper button
	    paperButton = new JButton("Paper");
	    paperButton.setBounds(165, 387, 105, 81);
	    paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
	    paperButton.addActionListener(this);
	    add(paperButton);
	    
	    // scissor button
	    scissorButton = new JButton("Scissors");
	    scissorButton.setBounds(290, 387, 105, 81);
	    scissorButton.setFont(new Font("Dialog", Font.PLAIN, 18));
	    scissorButton.addActionListener(this);
	    add(scissorButton);
	    
	    showDialog("Text Message");
	}
	
	// displays a message dialog which will show the winner and a try again button to play again
	private void showDialog(String message) {
		JDialog resultDialog = new JDialog(this, "Result", true);
		resultDialog.setSize(227, 124);
		resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		resultDialog.setResizable(false);
		
		// message label
		JLabel resultLabel = new JLabel(message);
		resultLabel.setFont(new Font("Dialog", Font.BOLD, 18) );
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultDialog.add(resultLabel, BorderLayout.CENTER);
		
		// try again button
		JButton tryAgainButton = new JButton("Try Again?");
		tryAgainButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// reset computer choice
				computerChoice.setText("?");
				
				// close the dialog box
				resultDialog.dispose();
			}
		});
		resultDialog.add(tryAgainButton, BorderLayout.SOUTH);
		
		resultDialog.setLocationRelativeTo(this);
		resultDialog.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// get player choice
		String playerChoice = e.getActionCommand().toString();
		
		// play rock paper scissor and store result into string var
		String result = rockPaperScissor.playRockPaperScissor(playerChoice);
		
		// load computer's choice
		computerChoice.setText(rockPaperScissor.getComputerChoice());
		
		// update score
		computerScoreLabel.setText("Computer: " + rockPaperScissor.getComputerScore());
		playerScoreLabel.setText("Player: " + rockPaperScissor.getPlayerScore());
		
		showDialog(result);
	}
}






















