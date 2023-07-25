package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import entity.*;
import repository.*;

public class Recipt extends JFrame implements ActionListener
{
	private JLabel MovieLabel,TimeLabel,TheatreLabel,SeatsLabel,MovieLabel2,TimeLabel2,TheatreLabel2,SeatsLabel2,PriceLabel,PriceLabel2; 
	private JButton exitbtn,backbtn;
	private JPanel panel;
	private BookingTicket BT;
	
	public Recipt(BookingTicket BT,String MovieItem,String TimeIteam,String TheatreItem,double bdtPrice,String Check)
	{
		super("Recipt");
		this.setSize(600,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.BT=BT;
		
		panel=new JPanel();
		panel.setLayout(null);
		
		MovieLabel=new JLabel("MOVIE NAME:");
		MovieLabel.setBounds(133,50,100,50);
		panel.add(MovieLabel);
		
		MovieLabel2=new JLabel("");
		MovieLabel2.setBounds(220,50,120,50);
		MovieLabel2.setText(MovieItem);
		panel.add(MovieLabel2);
		
		TimeLabel=new JLabel("TIME :");
		TimeLabel.setBounds(174,70,50,50);
		panel.add(TimeLabel);
		
		TimeLabel2=new JLabel("");
		TimeLabel2.setBounds(220,70,120,50);
		TimeLabel2.setText(TimeIteam);
		panel.add(TimeLabel2);
		
		TheatreLabel=new JLabel("THEATRE :");
		TheatreLabel.setBounds(150,90,60,50);
		panel.add(TheatreLabel);
		
		TheatreLabel2=new JLabel("");
		TheatreLabel2.setBounds(220,90,120,50);
		TheatreLabel2.setText(TheatreItem);
		panel.add(TheatreLabel2);
		
		SeatsLabel=new JLabel("SEATS :");
		SeatsLabel.setBounds(163,110,60,50);
		panel.add(SeatsLabel);
		
		SeatsLabel2=new JLabel("");
		SeatsLabel2.setBounds(220,110,250,50);
		SeatsLabel2.setText(Check);
		panel.add(SeatsLabel2);
		
		PriceLabel=new JLabel("PRICE :");
		PriceLabel.setBounds(168,130,60,50);
		panel.add(PriceLabel);
		
		
		PriceLabel2=new JLabel("");
		PriceLabel2.setBounds(220,130,150,50);
		PriceLabel2.setText(""+bdtPrice);
		panel.add(PriceLabel2);
		
		
		backbtn=new JButton("Back");
		backbtn.setBounds(150,200,70,30);
		backbtn.addActionListener(this);
		panel.add(backbtn);
		
		exitbtn=new JButton("PRINT");
		exitbtn.setBounds(250,200,70,30);
		exitbtn.addActionListener(this);
		panel.add(exitbtn);
		
		
		
		
		
		
		
		
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(exitbtn.getText()))
		{
			JOptionPane.showMessageDialog(this,"Enjoy The Movie :) ");
			BookingTicket bt = new BookingTicket();
			bt.setVisible(true);
			this.setVisible(false);
			// System.exit(0);
		}
		else if(command.equals(backbtn.getText()))
		{
			BT.setVisible(true);
			this.setVisible(false);
		}
		else{};
	}
	
}
