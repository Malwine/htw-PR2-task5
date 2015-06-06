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
	
	TicTacToe(){
		super();
		this.setTitle("TicTacToe");
		buttons = new JButton [9];
		
		for(int i=0; i<buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setFont(new Font("Verdana", Font.BOLD, 24));
			buttons[i].setText("");
			buttons[i].setActionCommand(new Integer(i).toString());
			buttons[i].addActionListener(this);
		}
		
		redStarts = new JButton("red starts");
		redStarts.setActionCommand("redStarts");
		redStarts.addActionListener(this);
		
		blackStarts = new JButton("black starts");
		blackStarts.setActionCommand("blackStarts");
		blackStarts.addActionListener(this);
		
		label1 = new JLabel("Choose who starts"); 
		label1.setFont(new Font("Verdana", Font.BOLD, 24));
		label1.setForeground(Color.RED);

		this.add(label1, BorderLayout.NORTH);
		JPanel mainPanel = initMainPanel();
		this.add(mainPanel, BorderLayout.CENTER); 
		JPanel controlPanel = initControlPanel();
		this.add(controlPanel, BorderLayout.SOUTH);
		this.setSize(400,400);
		this.setVisible(true);
		
	}
	
	JPanel initMainPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,3,10,10));
		for(int i=0; i<buttons.length; i++)
		{
			panel.add(buttons[i]); 
		}
		return panel;
	}
	
	JPanel initControlPanel() {
		JPanel panel = new JPanel();
		panel.add(redStarts);
		panel.add(blackStarts);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		
		TicTacToe ttt = new TicTacToe();
	}

	
}
