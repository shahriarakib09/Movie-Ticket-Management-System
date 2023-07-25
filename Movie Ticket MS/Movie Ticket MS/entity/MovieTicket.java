package entity;

import java.lang.*;

public class MovieTicket
{
	private String movieTicketId;
	private String movieName;
	private String theater;
	private double movieTicketPrice;
	private String movieTime;
	
	public MovieTicket(){}
	public MovieTicket(String movieTicketId, String movieName, String theater, double movieTicketPrice, String movieTime)
	{
		this.movieTicketId = movieTicketId;
		this.movieName = movieName;
		this.theater = theater;
		this.movieTicketPrice = movieTicketPrice;
		this.movieTime = movieTime;
	}
	
	public void setMovieTicketId(String movieTicketId){
		this.movieTicketId = movieTicketId;
	}
	public void setMovieName(String movieName){
		this.movieName = movieName;
	}
	public void setTheater(String theater){
		this.theater = theater;
	}
	public void setMovieTicketPrice(double movieTicketPrice){
		this.movieTicketPrice = movieTicketPrice;
	}
	public void setMovieTime(String movieTime){
		this.movieTime = movieTime;
	}

	
	public String getMovieTicketId(){
		return this.movieTicketId;
	}
	public String getMovieName(){
		return this.movieName;
	}
	public String getTheater(){
		return this.theater;
	}
	public double getMovieTicketPrice(){
		return this.movieTicketPrice;
	}
	public String getMovieTime(){
		return this.movieTime;
	}
}