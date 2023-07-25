package interfaces;

import java.lang.*;

import entity.*;

public interface IMovieTicketRepo
{
	public void insertInDB(MovieTicket mt);
	public void deleteFromDB(String movieTicketId);
	public void updateInDB(MovieTicket mt);
	public MovieTicket searchMovie(String movieTicketId);
	public String[][] getAllMovie();
}