package TicTacToe;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;



import TicTacToe.Window.Mode;


public class indexPage extends JFrame implements ActionListener {
	
	public JFrame f;
	public JPanel p1,p2,p3;
	public JButton b1;
	public JButton b2;
	
	indexPage()
	{
		f=new JFrame("TIC-TAC-TOE");
		
		f.setSize(600,600);
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		
		p1.setBackground(Color.DARK_GRAY);
		p2.setBackground(Color.DARK_GRAY);
		p3.setBackground(Color.DARK_GRAY);
		Font font=new Font("Courier",Font.BOLD,24);
		
		JLabel lbl=new JLabel("TIC TAC TOE");
		lbl.setForeground(Color.white);
		lbl.setFont(font);
		p3.add(lbl);
		f.setLayout(new GridLayout(3,1));
		
		
		
		
		
		b1=new JButton("Player  Vs  AI");
		b1.setPreferredSize(new Dimension(150,50));
		b1.setBackground(Color.LIGHT_GRAY);
		p1.add(b1);
		b1.addActionListener(this);
		b2=new JButton("Player Vs Player");
		b2.setPreferredSize(new Dimension(150,50));
		b2.setBackground(Color.LIGHT_GRAY);
		
		p2.add(b2);
		b2.addActionListener(this);
		f.add(p3);
		f.add(p1);
		f.add(p2);
		f.setResizable(false);
		f.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1) {
			new difficulty();
		   f.dispose();}
		else
		{
			SwingUtilities.invokeLater(() -> new Window(Mode.Player));
			f.dispose();
			
		}
		
	}
	

	
		
}
	
	
	


