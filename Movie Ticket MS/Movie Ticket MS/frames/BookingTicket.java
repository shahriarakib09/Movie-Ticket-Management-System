package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;

import repository.*;
import entity.*;


public class BookingTicket extends JFrame implements ActionListener
{
	private JLabel movieLabel,timeLabel,seatsLabel,priceLabel,theatreLabel,priceLabel2,Yourseats;
	private JButton confirmbtn,exitbtn,Yourseats1;
	private JComboBox combomovie,combotime,combotheatre,comboprice;
	private JCheckBox chk, A1,A2,A3,A4,B1,B2,B3,B4,C1,C2,C3,C4;
	private JPanel panel;
	
	DatabaseConnection dbc;
	
	public BookingTicket()
	{
		super("Booking Ticket");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setLayout(null);


		movieLabel=new JLabel("Select Movie:");
		movieLabel.setBounds(150,50,80,30);
		panel.add(movieLabel);
		

		combomovie=new JComboBox();
		combomovie.setBounds(230,50,120,30);
		panel.add(combomovie);
		
		timeLabel=new JLabel("Select Time:");
		timeLabel.setBounds(150,100,80,30);
		panel.add(timeLabel);
		
		combotime=new JComboBox();
		combotime.setBounds(230,100,80,30);
		panel.add(combotime);
		
		theatreLabel=new JLabel("Theatre:");
		theatreLabel.setBounds(320,100,80,30);
		panel.add(theatreLabel);
		
		combotheatre=new JComboBox();
		combotheatre.setBounds(370,100,80,30);
		panel.add(combotheatre);
		
		seatsLabel=new JLabel("Seats:");
		seatsLabel.setBounds(150,150,80,30);
		panel.add(seatsLabel);
		
		A1=new JCheckBox("A1");
		A1.setBounds(230,150,50,30);
		panel.add(A1);
		
		A2=new JCheckBox("A2");
		A2.setBounds(230,170,50,30);
		panel.add(A2);
		
		A3=new JCheckBox("A3");
		A3.setBounds(230,190,50,30);
		panel.add(A3);
		
		A4=new JCheckBox("A4");
		A4.setBounds(230,210,50,30);
		panel.add(A4);
		
		B1=new JCheckBox("B1");
		B1.setBounds(280,150,50,30);
		panel.add(B1);
		
		B2=new JCheckBox("B2");
		B2.setBounds(280,170,50,30);
		panel.add(B2);
		
		B3=new JCheckBox("B3");
		B3.setBounds(280,190,50,30);
		panel.add(B3);
		
		B4=new JCheckBox("B4");
		B4.setBounds(280,210,50,30);
		panel.add(B4);
		
		C1=new JCheckBox("C1");
		C1.setBounds(330,150,50,30);
		panel.add(C1);
		
		C2=new JCheckBox("C2");
		C2.setBounds(330,170,50,30);
		panel.add(C2);
		
		C3=new JCheckBox("C3");
		C3.setBounds(330,190,50,30);
		panel.add(C3);
		
		C4=new JCheckBox("B4");
		C4.setBounds(330,210,50,30);
		panel.add(C4);
		
		priceLabel=new JLabel("Price:");
		priceLabel.setBounds(150,250,80,30);
		panel.add(priceLabel);
		
		comboprice=new JComboBox();
		comboprice.setBounds(230,250,80,30);
		panel.add(comboprice);
	
		confirmbtn=new JButton("CONFIRM");
		confirmbtn.setBounds(150,300,90,30);
		confirmbtn.addActionListener(this);
		panel.add(confirmbtn);
		
		exitbtn=new JButton("EXIT");
		exitbtn.setBounds(250,300,90,30);
		exitbtn.addActionListener(this);
		panel.add(exitbtn);

		setValues();
			
		this.add(panel);	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		List<String> Check = new ArrayList<>();
		double amount=0; 
		String command = ae.getActionCommand();
		
		if(command.equals(exitbtn.getText()))
		{
			System.exit(0);
		}
		else if(command.equals(confirmbtn.getText()))
		{
			String MovieItem = combomovie.getSelectedItem().toString();
			String TimeIteam = combotime.getSelectedItem().toString();
			String TheatreItem = combotheatre.getSelectedItem().toString();
			String BdtPrice = comboprice.getSelectedItem().toString();
			// String Check;
			Double price = Double.parseDouble(BdtPrice);
			
			if(A1.isSelected())
			{
				Check.add(A1.getText());
				amount+=price;
			}
			if(A2.isSelected())
			{
				Check.add(A2.getText());
				amount+=price;
			}
			if(A3.isSelected())
			{
				Check.add(A3.getText());
				amount+=price;
			}
			if(A4.isSelected())
			{
				Check.add(A4.getText());
				amount+=price;
			}
			if(B1.isSelected())
			{
				Check.add(B1.getText());
				amount+=price;
			}
			if(B2.isSelected())
			{
				Check.add(B2.getText());
				amount+=price;
			}
			if(B3.isSelected())
			{
				Check.add(B3.getText());
				amount+=price;
			}
			if(B4.isSelected())
			{
				Check.add(B4.getText());
				amount+=price;
			}
			if(C1.isSelected())
			{
				Check.add(C1.getText());
				amount+=price;
			}
			if(C2.isSelected())
			{
				Check.add(C2.getText());
				amount+=price;
			}
			if(C3.isSelected())
			{
				Check.add(C3.getText());
				amount+=price;
			}
			if(C4.isSelected())
			{
				Check.add(C4.getText());
				amount+=price;
			}
			else
			{
				Check.add("");
			}
				
			
			String chk = Check.toString();
			
			Recipt RT= new Recipt(this, MovieItem, TimeIteam, TheatreItem, amount, chk);
			RT.setVisible(true);
			this.setVisible(false);
		}
		
		
		else{}
		
	}

	public void setValues(){


		try
		{
			String query = "SELECT movieName, theater, movieTicketPrice, movieTime FROM movies;";  
			dbc = new DatabaseConnection();
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
			//combomovie.removeAllItems();
			while(dbc.result.next())
			{

				combomovie.addItem(dbc.result.getString("movieName"));
				combotheatre.addItem(dbc.result.getString("theater"));
				comboprice.addItem(dbc.result.getString("movieTicketPrice"));
				combotime.addItem(dbc.result.getString("movieTime"));

				//String movieName = dbc.result.getString("movieName");
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
	}
}
