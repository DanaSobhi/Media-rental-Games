package application;

public class Game extends Media { // media is a game
	protected double weight;
//A game has title,number of copies,and the weight (in grams) is also stored

	public Game() {

	}

	public Game(String idm, String title, int copiesAvailable, double weight) {
		super(idm, title, copiesAvailable);
		this.weight = weight;

	}

	public String getIdm() {
		return super.idm;
	}

	public String getTitle() {
		return super.title;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
//to be able to return all the info 

		return (super.idm + " " + super.title + " " + super.copiesAvailable + " " + weight);
	}



}
