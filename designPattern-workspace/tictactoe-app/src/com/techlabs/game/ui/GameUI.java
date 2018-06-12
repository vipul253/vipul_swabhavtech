package com.techlabs.game.ui;

import java.awt.event.*;

import javax.swing.*;

import com.techlabs.game.*;

public class GameUI extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	final JTextField tf = new JTextField();
	private JButton btn1 = new JButton("1");
	private JButton btn2 = new JButton("2");
	private JButton btn3 = new JButton("3");
	private JButton btn4 = new JButton("4");
	private JButton btn5 = new JButton("5");
	private JButton btn6 = new JButton("6");
	private JButton btn7 = new JButton("7");
	private JButton btn8 = new JButton("8");
	private JButton btn9 = new JButton("9");
	private JButton start = new JButton("start new game");
	
	private Game g1;
	
	
	public GameUI(){
		this.setLayout(null);
		this.setBounds(600, 600, 250, 350);
		
		btn1.setBounds(30, 20, 50, 50);
		btn2.setBounds(90, 20, 50, 50);
		btn3.setBounds(150, 20, 50, 50);
		btn4.setBounds(30, 80, 50, 50);
		btn5.setBounds(90, 80, 50, 50);
		btn6.setBounds(150, 80, 50, 50);
		btn7.setBounds(30, 140, 50, 50);
		btn8.setBounds(90, 140, 50, 50);
		btn9.setBounds(150, 140, 50, 50);
		tf.setBounds(30, 200, 170, 30);
		start.setBounds(30, 240, 170, 30);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		start.addActionListener(this);
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		this.add(btn6);
		this.add(btn7);
		this.add(btn8);
		this.add(btn9);
		this.add(tf);
		this.add(start);
		
		g1 = new Game();
		g1.start();
		tf.setText(""+g1.getAnalyser().checkState());
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btn1){
			g1.play(0);
			display(btn1);
		}
		else if(e.getSource()==btn2){
			g1.play(1);
			display(btn2);
		}
		else if(e.getSource()==btn3){
			g1.play(2);
			display(btn3);
		}
		else if(e.getSource()==btn4){
			g1.play(3);
			display(btn4);
		}
		else if(e.getSource()==btn5){
			g1.play(4);
			display(btn5);
		}
		else if(e.getSource()==btn6){
			g1.play(5);
			display(btn6);
		}
		else if(e.getSource()==btn7){
			g1.play(6);
			display(btn7);
		}
		else if(e.getSource()==btn8){
			g1.play(7);
			display(btn8);
		}
		else if(e.getSource()==btn9){
			g1.play(8);
			display(btn9);
		}
		
	}
	
	public void display(JButton btn){
		Board board = g1.getBoard();
		Cell[] grid = board.getGrid();
		int pos = Integer.parseInt(btn.getText())-1;
		btn.setText(grid[pos].getMark());
		btn.setEnabled(false);
		tf.setText(""+g1.getAnalyser().checkState());
		
	}

}
