package com.techlabs.multisource.singlelistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WelcomeFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btn1 = new JButton("wish");
	private JButton btn2 = new JButton("wish2");
	private JButton btn3 = new JButton("wish3");
	final JTextField tf = new JTextField();

	public WelcomeFrame() {
		this.setLayout(null);
		this.setBounds(10, 10, 300, 300);
		
		tf.setBounds(10, 10, 50, 20);
		btn1.setBounds(50, 60, 95, 30);
		btn1.addActionListener(this);
		btn2.setBounds(50,91, 95, 30);
		btn2.addActionListener(this);
		btn3.setBounds(50,121, 95, 30);
		btn3.addActionListener(this);
		
		this.add(tf);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1){
			tf.setText("hello");
		}
		else if(e.getSource()==btn2){
			tf.setText("hi");
		}
		else if(e.getSource()==btn3){
			tf.setText("hey");
		}
	}
}