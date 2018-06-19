package com.techlabs.game.ui;

import java.awt.event.*;

import javax.swing.*;

import com.techlabs.game.*;

public class GameUI extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	final JLabel tf = new JLabel();
	final JLabel p1 = new JLabel();
	final JLabel p2 = new JLabel();
	private JButton[] btn = new JButton[9];
	private JButton start = new JButton("start new game");
	
	private Game g1;
	
	
	public GameUI(){
		
		this.setLayout(null);
		this.setBounds(600, 600, 250, 400);
		
		for(int i=0;i<btn.length;i++){
			btn[i] = new JButton(""+(i+1));
			btn[i].addActionListener(this);
			btn[i].setEnabled(false);
			this.add(btn[i]);
		}
		
		btn[0].setBounds(30, 20, 50, 50);
		btn[1].setBounds(90, 20, 50, 50);
		btn[2].setBounds(150, 20, 50, 50);
		btn[3].setBounds(30, 80, 50, 50);
		btn[4].setBounds(90, 80, 50, 50);
		btn[5].setBounds(150, 80, 50, 50);
		btn[6].setBounds(30, 140, 50, 50);
		btn[7].setBounds(90, 140, 50, 50);
		btn[8].setBounds(150, 140, 50, 50);
		tf.setBounds(30, 200, 170, 30);
		p1.setBounds(30, 230, 170, 30);
		p2.setBounds(30, 260, 170, 30);
		start.setBounds(30, 290, 170, 30);
		
		start.addActionListener(this);
		
		tf.setText("press start to play");
		p1.setText("player one: CROSS (X)");
		p2.setText("player two: NOUGHT (O)");
		
		this.add(tf);
		this.add(p1);
		this.add(p2);
		this.add(start);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btn[0]){
			g1.play(0);
			display(btn[0]);
		}
		if(e.getSource()==btn[1]){
			g1.play(1);
			display(btn[1]);
		}
		if(e.getSource()==btn[2]){
			g1.play(2);
			display(btn[2]);
		}
		if(e.getSource()==btn[3]){
			g1.play(3);
			display(btn[3]);
		}
		if(e.getSource()==btn[4]){
			g1.play(4);
			display(btn[4]);
		}
		if(e.getSource()==btn[5]){
			g1.play(5);
			display(btn[5]);
		}
		if(e.getSource()==btn[6]){
			g1.play(6);
			display(btn[6]);
		}
		if(e.getSource()==btn[7]){
			g1.play(7);
			display(btn[7]);
		}
		if(e.getSource()==btn[8]){
			g1.play(8);
			display(btn[8]);
		}
		if(e.getSource()==start){
			startNewGame();
		}
	}
	
	public void display(JButton button){
		Board board = g1.getBoard();
		Cell[] grid = board.getGrid();
		int pos = Integer.parseInt(button.getText())-1;
		button.setText(grid[pos].getMark());
		button.setEnabled(false);
		tf.setText(""+g1.getAnalyser().checkState());
		if(g1.getAnalyser().checkState()!=State.PLAYING){
			for(int i=0;i<btn.length;i++){
				btn[i].setEnabled(false);
			}
		}
	}
	
	public void startNewGame(){
		g1 = new Game();
		g1.start();
		tf.setText("PLAYING");
		for(int i=0;i<btn.length;i++){
			btn[i].setText(""+(i+1));
			btn[i].setEnabled(true);
		}
	}
}
