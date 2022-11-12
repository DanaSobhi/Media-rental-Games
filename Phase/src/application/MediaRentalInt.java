package application;

import java.util.*;

interface MediaRentalInt {
	/*
	 * all the methods should be public since its interface Class Adds the specified
	 * customer to the database. The address is a physical address (not e-mail). The
	 * plan options available are: LIMITED and UNLIMITED. LIMITED defines a default
	 * maximum of two media that can be rented.
	 */

	public void addCustomer(String id,String name, String address, String plan,String mobile);

	/*
	 * Adds the specified movie to the database. The possible values for rating are
	 * "DR", "HR", "AC"
	 */
	public void updateCustomers(String id,String name, String address, String plan,String mobile);
	
	public void addMovie(String idm,String title, int copiesAvailable, String rating);

	public void upDateMovie(String idm,String title, int copiesAvailable, String rating);
	// Adds the specified game to the database.
	public void addGame(String idm,String title, int copiesAvailable, double weight);

	public void upDateGame(String idm,String title, int copiesAvailable, double weight);
	/*
	 * Adds the specified album to the database. The songs String includes a list of
	 * the title of songs in the album (song titles are separated by commas).
	 */

	public void addAlbum(String idm,String title, int copiesAvailable, String artist, String songs);

	public void upDateAlbum(String idm,String title, int copiesAvailable, String artist, String songs);
	// This set the number of media associated with the LIMITED plan.
	public void setLimitedPlanLimit(int value);

	/*
	 * Returns information about the customers in the database. The information is
	 * presented sorted by customer name.
	 */
	public String getAllCustomersInfo();

	/*
	 * Returns information about all the media (movies, albums, and games) that are
	 * part of the database. The information is presented sorted by media title.
	 */
	public String getAllMediaInfo();

	/*
	 * Adds the specified media title to the cart associated with a customer
	 */
	public boolean addToCart(String customerName, String mediaTitle);

	/*
	 * Removes the specified media title from the customer's cart.
	 */
	public boolean removeFromCart(String customerName, String mediaTitle);

	/*
	 * Processes the requests cart of each customer. The customers will be processed
	 * in alphabetical order. For each customer, the requests cart will be checked
	 * and media will be added to the rented cart, if the plan associated with the
	 * customer allows it, and if there is a copy of the media available. For
	 * UNLIMITED plans the media will be added to the rented cart always, as long as
	 * there are copies associated with the media available. For LIMITED plans, the
	 * number of entries moved from the requests cart to the rented cart will depend
	 * on the number of currently rented media, and whether copies associated with
	 * the media are available.For each media that is rented, the following message
	 * will be generated: "Sending [mediaTitle] to [customerName]"
	 */
	public String processRequests();

	/*
	 * This is how a customer returns a rented media. This method will remove the
	 * item from the rented cart and adjust any other values that are necessary
	 * (e.g., copiesAvailable)
	 */
	public boolean returnMedia(String customerName, String mediaTitle);

	/*
	 * Returns a SORTED ArrayList with media titles that satisfy the provided
	 * parameter values. If null is specified for a parameter, then that parameter
	 * should be ignore in the search. Providing null for all parameters will return
	 * all media titles.
	 */

	public ArrayList<String> searchCustomer(String id);
	/* 
	 * A Searching  List Made for Search Customers 
	 */
	public ArrayList<String> searchMedia(String id);
	
	/*
	 * To remove Media and to remove Customers . 
	 */
	public void removeMedia(String idm);
	public void removeCustomer(String id);
	
	


}
