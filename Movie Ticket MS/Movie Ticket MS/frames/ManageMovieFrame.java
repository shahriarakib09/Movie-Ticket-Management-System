package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class ManageMovieFrame extends JFrame implements ActionListener
{
	private JLabel movieIdLabel, movieNameLabel, theaterLabel, movieTimeLabel, moviePriceLabel, welcomeLabel;
	private JTextField movieIdTF, movieNameTF, theaterTF, movieTimeTF, moviePriceTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, resetBtn, getAllBtn, backBtn, bookBtn;
	private JPanel panel;
	private JTable movieTable;
	private JScrollPane movieTableSP;
	
	private User user;
	private MovieTicketRepo mtr;
	private UserRepo ur;
	
	
	public ManageMovieFrame(LoginFrame lf, String username)
	{
		super("Manage Movie");
		this.setSize(800,460);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		mtr = new MovieTicketRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", "", ""}};
		
		String head[] = {"Moive Id", "Movie Name", "Theater", "Movie Time", "Movie Price"};

		movieTable = new JTable(data,head);
		movieTableSP = new JScrollPane(movieTable);
		movieTableSP.setBounds(345, 100, 430, 150);
		movieTable.setEnabled(false);
		panel.add(movieTableSP);

		welcomeLabel = new JLabel("Welcome "+username);
		welcomeLabel.setBounds(570,30,150,30);
		panel.add(welcomeLabel);
		
		movieIdLabel = new JLabel("Movie ID :");
		movieIdLabel.setBounds(130,100,100,30);
		panel.add(movieIdLabel);

		movieIdTF = new JTextField();
		movieIdTF.setBounds(220,100,100,30);
		panel.add(movieIdTF);
		
		movieNameLabel = new JLabel("Movie Name :");
		movieNameLabel.setBounds(106,150,100,30);
		panel.add(movieNameLabel);

		movieNameTF = new JTextField();
		movieNameTF.setBounds(220,150,100,30);
		panel.add(movieNameTF);
		
		theaterLabel = new JLabel("Theater : ");
		theaterLabel.setBounds(130,200,100,30);
		panel.add(theaterLabel);

		theaterTF = new JTextField();
		theaterTF.setBounds(220,200,100,30);
		panel.add(theaterTF);
		
		moviePriceLabel = new JLabel("Ticket Price :");
		moviePriceLabel.setBounds(111,250,100,30);
		panel.add(moviePriceLabel);

		moviePriceTF = new JTextField();
		moviePriceTF.setBounds(220,250,100,30);
		panel.add(moviePriceTF);

		movieTimeLabel = new JLabel("Movie Time :");
		movieTimeLabel.setBounds(108,300,100,30);
		panel.add(movieTimeLabel);

		movieTimeTF = new JTextField();
		movieTimeTF.setBounds(220,300,100,30);
		panel.add(movieTimeTF);

		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,350,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,350,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,350,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,350,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		resetBtn = new JButton("Reset");
		resetBtn.setBounds(500,350,80,30);
		resetBtn.addActionListener(this);
		resetBtn.setEnabled(false);
		panel.add(resetBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,260,70,25);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Logout");
		backBtn.setBounds(695, 30, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);

		bookBtn = new JButton("Book Ticket");
		bookBtn.setBounds(100, 30, 150, 30);
		bookBtn.addActionListener(this);
		panel.add(bookBtn);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!movieIdTF.getText().equals("") || !movieIdTF.getText().equals(null))
			{
				MovieTicket mt = mtr.searchMovie(movieIdTF.getText());
				if(mt!= null)
				{
					movieNameTF.setText(mt.getMovieName());
					theaterTF.setText(mt.getTheater());
					movieTimeTF.setText(mt.getMovieTime());
					moviePriceTF.setText(mt.getMovieTicketPrice()+"");
					
					movieIdTF.setEnabled(false);
					movieNameTF.setEnabled(true);
					theaterTF.setEnabled(true);
					movieTimeTF.setEnabled(true);
					moviePriceTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					resetBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			MovieTicket mt = new MovieTicket();
			
			mt.setMovieTicketId(movieIdTF.getText());
			mt.setMovieName(movieNameTF.getText());
			mt.setTheater(theaterTF.getText());
			mt.setMovieTime(movieTimeTF.getText());
			mt.setMovieTicketPrice(Double.parseDouble(moviePriceTF.getText()));
			
			mtr.insertInDB(mt);
			
			JOptionPane.showMessageDialog(this, "Inserted");
			
			movieIdTF.setText("");
			movieNameTF.setText("");
			theaterTF.setText("");
			movieTimeTF.setText("");
			moviePriceTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			resetBtn.setEnabled(false);
			
		}
		else if(command.equals(resetBtn.getText()))
		{
			movieIdTF.setText("");
			movieNameTF.setText("");
			theaterTF.setText("");
			movieTimeTF.setText("");
			moviePriceTF.setText("");
			
			movieIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			resetBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			MovieTicket mt = new MovieTicket();
			
			mt.setMovieTicketId(movieIdTF.getText());
			mt.setMovieName(movieNameTF.getText());
			mt.setTheater(theaterTF.getText());
			mt.setMovieTime(movieTimeTF.getText());
			mt.setMovieTicketPrice(Double.parseDouble(moviePriceTF.getText()));
			
			mtr.updateInDB(mt);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			movieIdTF.setText("");
			movieNameTF.setText("");
			theaterTF.setText("");
			movieTimeTF.setText("");
			moviePriceTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			resetBtn.setEnabled(false);
			
			movieIdTF.setEnabled(true);
			movieNameTF.setEnabled(true);
			theaterTF.setEnabled(true);
			movieTimeTF.setEnabled(true);
			moviePriceTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			mtr.deleteFromDB(movieIdTF.getText());
			ur.deleteUser(movieIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			movieIdTF.setText("");
			movieNameTF.setText("");
			theaterTF.setText("");
			movieTimeTF.setText("");
			moviePriceTF.setText("");
			
			movieIdTF.setEnabled(true);
			movieNameTF.setEnabled(true);
			theaterTF.setEnabled(true);
			movieTimeTF.setEnabled(true);
			moviePriceTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			resetBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = mtr.getAllMovie();
			String head[] = {"Movie ID", "Movie Name", "Theater", "Movie Time", "Ticket Price"};
			
			panel.remove(movieTableSP);
			
			movieTable = new JTable(data,head);
			movieTable.setEnabled(false);
			movieTableSP = new JScrollPane(movieTable);
			movieTableSP.setBounds(345, 100, 430, 150);
			panel.add(movieTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(backBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(bookBtn.getText()))
		{
			BookingTicket bt = new BookingTicket();
			bt.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
}