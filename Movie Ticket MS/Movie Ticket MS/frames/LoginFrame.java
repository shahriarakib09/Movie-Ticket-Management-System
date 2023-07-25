package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.sql.*;

import repository.*;
import entity.*;

public class LoginFrame extends JFrame implements MouseListener, ActionListener
{
	private JLabel title, userLabel, passLabel, star, star1;
	private JTextField userTF;
	private JPasswordField passPF;
	private JButton loginBtn, exitBtn, showPassBtn, bookTicketBtn;
	private JPanel panel;
	private JCheckBox passChk;
	
	public LoginFrame()
	{
		super("Movie Booking System - Login Window");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Movie Booking System");
		title.setBounds(365, 40, 350, 30);
		panel.add(title);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(300, 100, 60, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(370, 100, 120, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(285, 150, 70, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(370, 150, 120, 30);
		passPF.setEchoChar('*');
		panel.add(passPF);

		star = new JLabel("*");
		star.setBounds(500, 155, 30, 30);
		star.setForeground(Color.RED);
		star.setVisible(false);
		panel.add(star);

		star1 = new JLabel("*");
		star1.setBounds(500, 105, 30, 30);
		star1.setForeground(Color.RED);
		star1.setVisible(false);
		panel.add(star1);

		passChk = new JCheckBox("Show Password");
		passChk.setBounds(366, 180, 150, 30);
		passChk.addActionListener(this);
		panel.add(passChk);

		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(320, 230, 80, 30);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(430, 230, 80, 30);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);

		bookTicketBtn = new JButton("Book Ticket");
		bookTicketBtn.setBounds(320, 280, 190, 60);
		bookTicketBtn.setEnabled(false);
		panel.add(bookTicketBtn);
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			 UserRepo ur = new UserRepo();
			 User user = ur.getUser(userTF.getText(), passPF.getText());
			
			 if(user != null)
			 {
			 	String username = userTF.getText().toString();

				 if(user.getStatus() == 0)
				 {
					ManageMovieFrame mmf = new ManageMovieFrame(this, username);
					mmf.setVisible(true);
					this.setVisible(false);
				 }
				 else if(user.getStatus() == 1)
				 {
				 	BookingTicket bt = new BookingTicket();
				 	bt.setVisible(true);
				 	this.setVisible(false);
				 }
				 else{}
			 }
			 else
			 {

			 	star.setVisible(true);
			 	star1.setVisible(true);
				JOptionPane.showMessageDialog(this,"Invaild User or Password");
			 }
			
		}

		else if(command.equals(passChk.getText())){

			if(passChk.isSelected()){
				passPF.setEchoChar((char)0);
			}else{
				passPF.setEchoChar('*');
			}
		}

		else if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
	}

	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
}