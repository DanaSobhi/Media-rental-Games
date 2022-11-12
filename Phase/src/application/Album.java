package application;

public class Album extends Media { // media is an album

	// An album has a title, number of copies available, an artist and the songs
	// that are part of the album

	protected String artist;
	protected String songs;

	public Album() {

	}

	public Album(String idm, String title, int copiesAvailable, String artist, String songs) {

		super(idm, title, copiesAvailable);
		this.artist = artist;
		this.songs = songs;

	}

	public String getIdm() {
		return super.idm;
	}

	public String getTitle() {
		return super.title;
	}

	public String getArtist() {
		return artist;
	}

	public String getSongs() {
		return songs;
	}

	@Override
	public String toString() {
		// to return all info about Album

		return super.idm + " " + super.title + " " + super.copiesAvailable + " " + artist + " " + songs;
	}


}
