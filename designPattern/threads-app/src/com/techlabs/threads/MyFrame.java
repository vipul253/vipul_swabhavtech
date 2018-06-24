package com.techlabs.threads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JButton showDateBtn = new JButton("showDate");
	private JButton asyncBtn = new JButton("Async");
	private JButton wishBtn = new JButton("sayHello");
	private DisplayDate date = new DisplayDate();
	private AsyncDisplayDate async = new AsyncDisplayDate();

	public MyFrame() {
		this.setLayout(null);
		this.setBounds(600, 600, 400, 200);
		
		showDateBtn.setBounds(30, 40, 95, 30);
		asyncBtn.setBounds(130, 40, 95, 30);
		wishBtn.setBounds(230, 40, 95, 30);
		showDateBtn.addActionListener(this);
		asyncBtn.addActionListener(this);
		wishBtn.addActionListener(this);
		
		this.add(showDateBtn);
		this.add(asyncBtn);
		this.add(wishBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==showDateBtn){
			date.displayDate();
		}
		else if(e.getSource()==asyncBtn){
			Thread t = new Thread(async);
			t.start();
		}
		else if(e.getSource()==wishBtn){
			JOptionPane.showMessageDialog(null, "hello", "wish", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
