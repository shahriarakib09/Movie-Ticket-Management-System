package repository;

import java.lang.*;
import java.util.ArrayList;

import entity.*;
import interfaces.*;

public class MovieTicketRepo implements IMovieTicketRepo
{
	DatabaseConnection dbc;
	
	public MovieTicketRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(MovieTicket mt)
	{
		String query = "INSERT INTO movies VALUES (null,'"+mt.getMovieTicketId()+"','"+mt.getMovieName()+"','"+mt.getTheater()+"','"+mt.getMovieTicketPrice()+"',"+mt.getMovieTime()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String movieTicketId)
	{
		String query = "DELETE from movies WHERE movieTicketId='"+movieTicketId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(MovieTicket mt)
	{
		String query = "UPDATE movies SET movieName='"+mt.getMovieName()+"', theater = '"+mt.getTheater()+"', movieTicketPrice = "+mt.getMovieTicketPrice()+", movieTime = "+mt.getMovieTime()+" WHERE movieTicketId='"+mt.getMovieTicketId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public MovieTicket searchMovie(String movieTicketId)
	{
		MovieTicket mt = null;
		String query = "SELECT movieName, theater, movieTicketPrice, movieTime FROM movies WHERE movieTicketId='"+movieTicketId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String movieName = dbc.result.getString("movieName");
				String theater = dbc.result.getString("theater");
				double movieTicketPrice = dbc.result.getDouble("movieTicketPrice");
				String movieTime = dbc.result.getString("movieTime");
				
				mt = new MovieTicket();
				mt.setMovieTicketId(movieTicketId);
				mt.setMovieName(movieName);
				mt.setTheater(theater);
				mt.setMovieTicketPrice(movieTicketPrice);
				mt.setMovieTime(movieTime);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return mt;
	}
	public String[][] getAllMovie()
	{
		ArrayList<MovieTicket> ar = new ArrayList<MovieTicket>();
		String query = "SELECT * FROM movies;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String movieTicketId = dbc.result.getString("movieTicketId");
				String movieName = dbc.result.getString("movieName");
				String theater = dbc.result.getString("theater");
				double movieTicketPrice = dbc.result.getDouble("movieTicketPrice");
				String movieTime = dbc.result.getString("movieTime");
				
				MovieTicket mt = new MovieTicket(movieTicketId,movieName,theater,movieTicketPrice,movieTime);
				ar.add(mt);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((MovieTicket)obj[i]).getMovieTicketId();
			data[i][1] = ((MovieTicket)obj[i]).getMovieName();
			data[i][2] = ((MovieTicket)obj[i]).getTheater();
			data[i][3] = ((MovieTicket)obj[i]).getMovieTime();
			data[i][4] = (((MovieTicket)obj[i]).getMovieTicketPrice())+"";
		}
		return data;
	}
}












































