package com.GamerCodeFalse.main;

import javax.swing.JFrame;

public class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	
	
	public Window(Panel panel) {
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(panel);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);

	}

}
