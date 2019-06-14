package com.sample.moviecatalogservice.model;

public class Rating {

	private int movieId;
	private int ratings;
	
	
	public Rating(int movieId, int ratings) {
		super();
		this.movieId = movieId;
		this.ratings = ratings;
	}
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
}
