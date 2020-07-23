package TicTacToe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

import TicTacToe.Window.Mode;

public class difficulty extends JFrame implements ActionListener {
	
	JFrame f;
	JButton b1;
	JButton b2;
	JButton b3;
	public JPanel p1,p2,p3,p4;
	
	difficulty()
	{
		f=new JFrame();
		f.setSize(600,600);
		f.setResizable(false);
		//f.setLayout(new FlowLayout());
		f.setLayout(new GridLayout(4,1));
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		JLabel lbl=new JLabel("DIFFICULTY LEVEL");
		//Font font=new Font("Courier",Font.BOLD,24);
		
		
		p1.setBackground(Color.DARK_GRAY);
		p2.setBackground(Color.DARK_GRAY);
		p3.setBackground(Color.DARK_GRAY);
		p4.setBackground(Color.DARK_GRAY);
		Font font=new Font("Courier",Font.BOLD,24);
		lbl.setForeground(Color.white);
		lbl.setFont(font);
		p1.add(lbl);
		b1=new JButton("EASY");
		
		b2=new JButton("MEDIUM");
		
		b3=new JButton("DIFFICULT");
		
		//p3.add(lbl);
		
		
		b1.setPreferredSize(new Dimension(150,50));
		b1.setBackground(Color.LIGHT_GRAY);
		p2.add(b1);
		
		b2.setPreferredSize(new Dimension(150,50));
		b2.setBackground(Color.LIGHT_GRAY);
		
		p3.add(b2);
		b3.setPreferredSize(new Dimension(150,50));
		b3.setBackground(Color.LIGHT_GRAY);
		p4.add(b3);
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.add(p4);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		f.setVisible(true);
	}
	

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1) {
			SwingUtilities.invokeLater(() -> new Window(Mode.AI));
			f.dispose();	
			Window.flag=1;
			}
		else if(e.getSource()==b2)
		{
			SwingUtilities.invokeLater(() -> new Window(Mode.AI));
			f.dispose();	
			Window.flag=2;
		}
		else {
			SwingUtilities.invokeLater(() -> new Window(Mode.AI));
			f.dispose();	
			Window.flag=3;
			
		}
		
	}

}
