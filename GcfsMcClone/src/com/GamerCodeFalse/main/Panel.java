package com.GamerCodeFalse.main;

import java.awt.Dimension;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

import com.GamerCodeFalse.input.KeyboardInput;
import com.GamerCodeFalse.input.MouseInput;

public class Panel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public Panel() {
		this.addKeyListener(new KeyboardInput());
		this.addMouseListener(new MouseInput());
		this.addMouseMotionListener((MouseMotionListener) this.getMouseListeners()[0]);
		this.addMouseWheelListener((MouseWheelListener) this.getMouseListeners()[0]);
		
		this.setPreferredSize(new Dimension(Game.WINDOW_WIDTH,Game.WINDOW_HEIGHT));
	}

}
