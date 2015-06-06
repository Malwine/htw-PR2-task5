package ss2015_aufgabe5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener {
	
	JButton[] buttons; 
	JLabel label1;
	JButton redStarts;
	JButton blackStarts;
	boolean redsTurn;
	boolean end;
	boolean isNumber;
	boolean start;

	TicTacToe(){
		super();													// inherit from JFrame
		this.setTitle("TicTacToe");									// set title of frame
		buttons = new JButton [9];									// create button array
		
		for(int i=0; i<buttons.length; i++) {						// go through array
			buttons[i] = new JButton();								// create button
			buttons[i].setFont(new Font("Verdana", Font.BOLD, 24)); // set button font
			buttons[i].setText("");									// set button text to empty string
			buttons[i].setActionCommand(new Integer(i).toString()); // set action command to an integer object and turn into string
			buttons[i].addActionListener(this);						// apply action listener
		}
		
		redStarts = new JButton("red starts");						// create button for red starts
		redStarts.setActionCommand("redStarts");					// set action command
		redStarts.addActionListener(this);							// apply action listener
		
		blackStarts = new JButton("black starts");					// create button for black starts
		blackStarts.setActionCommand("blackStarts");				// set action command
		blackStarts.addActionListener(this);						// apply action listener
		
		label1 = new JLabel("Choose who starts"); 					// create label and set text
		label1.setFont(new Font("Verdana", Font.BOLD, 24));			// set label font
		label1.setForeground(Color.BLACK);							// set label color

		this.add(label1, BorderLayout.NORTH);						// add label to frame
		JPanel mainPanel = initMainPanel();							// call create method for main panel
		this.add(mainPanel, BorderLayout.CENTER);					// add main panel to center
		JPanel controlPanel = initControlPanel();					// call create method for player control panel
		this.add(controlPanel, BorderLayout.SOUTH);					// add player control panel to south
		this.setSize(400,400);										// set frame size
		this.setVisible(true);										// set visible
		
	}
	
	JPanel initMainPanel() {
		JPanel panel = new JPanel();								// create panel
		panel.setLayout(new GridLayout(3,3,10,10));					// set layout
		for(int i=0; i<buttons.length; i++) {						// add all buttons 
			panel.add(buttons[i]); 			
		}
		return panel;												// return panel
	}
	
	JPanel initControlPanel() {
		JPanel panel = new JPanel();								// create panel
		panel.add(redStarts);										// add red starts button
		panel.add(blackStarts);										// add black starts button
		return panel;												// return panel
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		int index = 0;
		try {
			index = Integer.parseInt(command); 
			isNumber = true; 
		}
		catch(NumberFormatException nfe) {
			isNumber = false;
		}
		
		if (command.equals("redStarts")){
			newGame();
			setLabel(Color.RED, "red starts");
			redsTurn = true;
			start = true;
		}
		else if (command.equals("blackStarts")){
			newGame();
			setLabel(Color.BLACK, "black starts");
			redsTurn = false;
			start = true;
		}
		else if (isNumber && !checkField(index,"X") && !checkField(index,"O") && start) {
			if(redsTurn){
				buttons[index].setForeground(Color.RED);
				buttons[index].setText("O");
				
				if (verticalWin("O") || horizontalWin("O") || diagonalWin("O")){		// check if game is won
					setLabel(Color.RED, "red won!");
					disableFields();
					end = true;
				}
				else if(tie()) {
					setLabel(Color.BLACK, "it's a tie! start again");
				}
				else {
					setLabel(Color.BLACK, "blacks turn");
					redsTurn = false;													// toggle the turn to black 
				}
			}
			else {
				buttons[index].setForeground(Color.BLACK);
				buttons[index].setText("X");
				
				if (verticalWin("X") || horizontalWin("X") || diagonalWin("X")){
					setLabel(Color.BLACK, "black won!");
					disableFields();
					end = true;
				}
				else if(tie()) {
					setLabel(Color.BLACK, "it's a tie! start again");
				}
				else {
					setLabel(Color.RED, "reds turn");
					redsTurn = true;													// toggle the turn to red
				}
			}
		}		
	}
	
	public boolean verticalWin(String s){
		return (checkField(0, s) && checkField(3, s) && checkField(6, s) ||
				checkField(1, s) && checkField(4, s) && checkField(7, s) ||
				checkField(2, s) && checkField(5, s) && checkField(8, s));
	}
	
	public boolean horizontalWin(String s){
		return (checkField(0, s) && checkField(1, s) && checkField(2, s) ||
				checkField(3, s) && checkField(4, s) && checkField(5, s) ||
				checkField(6, s) && checkField(7, s) && checkField(8, s));
	}
	
	public boolean diagonalWin(String s){
		return (checkField(0, s) && checkField(4, s) && checkField(8, s) ||
				checkField(2, s) && checkField(4, s) && checkField(6, s));
	}
	public boolean tie(){
		int count = 0;
		for(int i=0; i<buttons.length; i++){
			if (checkField(i, "X") || checkField(i, "O")){
				count++;
			}
		}
		return (count == 9);
	}
	
	public void disableFields(){
		for(int i = 0; i < buttons.length; i++) {
			if(buttons[i].getText().equals("")) {
				buttons[i].setEnabled(false); 
			}								  
		}
	}
	
	public boolean checkField(int index, String input){
		return buttons[index].getText().equals(input);
	}
	
	public void setLabel(Color c,String input) {
		label1.setForeground(c);
		label1.setText(input);
	}
	
	public void newGame(){
		for(int i=0; i<buttons.length; i++){
			buttons[i].setText("");
			buttons[i].setEnabled(true); 
		}
		end = false;
	}

	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();
	}
}
