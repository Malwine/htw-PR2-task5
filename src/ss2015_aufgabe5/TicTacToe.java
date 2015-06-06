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
	
	/**
	 * Game constructor.
	 */
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
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		
		TicTacToe ttt = new TicTacToe();
	}

	
}
