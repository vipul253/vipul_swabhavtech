package com.techlabs.javaui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WelcomeFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btn = new JButton("wish");
	final JTextField tf = new JTextField();

	public WelcomeFrame() {
		this.setLayout(null);
		this.setBounds(10, 10, 300, 300);
		
		tf.setBounds(10, 10, 50, 20);
		btn.setBounds(50, 100, 95, 30);
		btn.addActionListener(this);
		
		this.add(tf);
		this.add(btn);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tf.setText("Hello");
	}
}
