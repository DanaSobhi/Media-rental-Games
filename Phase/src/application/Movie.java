package application;

public class Movie extends Media { // media is a movie

	protected String rating;

	public Movie() {

	}

	public Movie(String idm, String title, int copiesAvailable, String rating) {

		super(idm, title, copiesAvailable);
		this.rating = rating;
		if (rating.trim().equalsIgnoreCase("DR") || rating.trim().equalsIgnoreCase("HR")
				|| rating.trim().equalsIgnoreCase("AC")) {
			// test rate to and see if the rating DR or HR or AC
			this.rating = rating.toUpperCase().trim();
		} else {
			throw new IllegalArgumentException("Invalid rating!");
		}

	}

	public String getIdm(String idm) {
		return super.idm;
	}

	public String getTitle(String title) {
		return super.title;
	}

	public String getRating() {
		return rating;
	}

	@Override
	public String toString() {

		return super.idm + " " + super.title + " " + super.copiesAvailable + " " + rating; // return all info
																							// of the movie

	}



}
