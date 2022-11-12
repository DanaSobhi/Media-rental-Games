package application;

public class Media implements Comparable<Media> {
	
	protected String idm;
	protected String title;
	protected int copiesAvailable;

	public Media() { // construct
	}

	public Media(String idm,String title, int copiesAvailable) {
		this.idm = idm;
		this.title = title;
		this.copiesAvailable = copiesAvailable;
	}
	public Media(String idm) {

		this.idm = idm;	
	}
	public String getIdm () {
		return idm;
	}
	
	public String getTitle() {
		return title;
	}

	public int getCopiesAvailable() {
		return copiesAvailable;
	}
	
	public void addOrRemoveCopies(boolean add) { //to add or remove a copy ,when it rented it remove one . 

		if (add) {
			this.copiesAvailable++;
		} else {
			this.copiesAvailable--;
		}

	}
@Override
	public int compareTo(Media o) {// this method for comparing  the instance of
		Media temp = (Media) o;

		return this.getIdm().compareTo(temp.getIdm());

	}
@Override
public boolean equals(Object obj) {
	if (obj == this) { // if this object is equally to this object "Media"
		return true; // return true
	}
	if (obj == null || getClass() != obj.getClass()) { // if this object is null or not from this class
		return false; // return false
	}
	Media md = (Media) obj; // make this object a Media object

	return idm.equals(md.getIdm()); //see if the id is matched 
}
	
}
