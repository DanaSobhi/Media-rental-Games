package application;

import java.util.*;

class MediaRental implements MediaRentalInt {
//in this part limited plans will remain 2, by defaults.  unless the use change it from main window

	private int limitedPlans;

	/*
	 * The database for your system needs to be represented using two ArrayList
	 * objects. One ArrayList will represent the customers present in the database;
	 * the second will represent the media (movies, albums , and games).
	 */

	protected ArrayList<Customer> customerInfor = new ArrayList<Customer>();

	protected ArrayList<Media> mediaInfor = new ArrayList<Media>();

	public MediaRental() {

		this.limitedPlans = 2; // LIMITED restricts the media to a default value of 2

	}

	@Override
	public void addCustomer(String id, String name, String address, String plan, String mobile) {

		if (customerInfor.size() == 0) {
			customerInfor.add(new Customer(id, name, address, plan, mobile));
		}
		for (int i = 0; i < customerInfor.size(); i++) {
			Customer customers = new Customer(id, name, address, plan, mobile);

			if (!customerInfor.contains(customers)) { // here we will use equal , since contain have equal (o==null ?
														// e==null : o.equals(e)).
														// it also will check the id .
				customerInfor.add(customers); // if the customer isn't in the arraylist add it
			}
		}

	}

	@Override
	public void removeCustomer(String id) {
		Collections.sort(customerInfor);// sort them all , they will be sorted by Id.
		for (int m = 0; m < customerInfor.size(); m++) {
			Customer temp = customerInfor.get(m);
			if (temp.getId().equals(id)) { // if the id exist
				customerInfor.remove(m); // remove this customer

			}

		}

	}

	@Override

	public void removeMedia(String idm) {
		Collections.sort(mediaInfor);// sort them all , they will be sorted by Id.
		for (int m = 0; m < mediaInfor.size(); m++) {
			Media temp = mediaInfor.get(m);
			if (temp.getIdm().equals(idm)) { // if the Id matched , remove this Media
				mediaInfor.remove(m);

			}

		}

	}

	@Override
	public void addMovie(String idm, String title, int copiesAvailable, String rating) {

		if (mediaInfor.size() == 0) {
			mediaInfor.add(new Movie(idm, title, copiesAvailable, rating));
		}
		for (int m = 0; m < mediaInfor.size(); m++) { // get all media
			Movie mov = new Movie(idm, title, copiesAvailable, rating);
			if (!mediaInfor.contains(mov)) { // using equal overrided from class media, it will check if the movie
												// already exist or there's another similar id
				mediaInfor.add(mov); // if none , it will add the movie
			}

		}

	}

	@Override
	public void addGame(String idm, String title, int copiesAvailable, double weight) {
		if (mediaInfor.size() == 0) {
			mediaInfor.add(new Game(idm, title, copiesAvailable, weight));
		}
		for (int g = 0; g < mediaInfor.size(); g++) {
			Game gm = new Game(idm, title, copiesAvailable, weight);
			// same with what happen in add movie.
			if (!mediaInfor.contains(gm)) {
				mediaInfor.add(gm);

			}

		}
	}

	@Override
	public void addAlbum(String idm, String title, int copiesAvailable, String artist, String songs) {

		if (mediaInfor.size() == 0) {
			mediaInfor.add(new Album(idm, title, copiesAvailable, artist, songs));
		}
		for (int a = 0; a < mediaInfor.size(); a++) {
			Album al = new Album(idm, title, copiesAvailable, artist, songs);
			if (!mediaInfor.contains(al)) {
				mediaInfor.add(al);

			}

		}

	}

	@Override
	public void setLimitedPlanLimit(int value) {
		this.limitedPlans = value; // This set the number of media associated with the LIMITED plan.

	}

	@Override
	public String getAllCustomersInfo() {
		String allcInfo = ""; // make an empty string to store the data in it , and return all customers info
								// in it

		Collections.sort(customerInfor);// sort them all , they will be sorted by ID.

		for (int i = 0; i < customerInfor.size(); i++) {

			allcInfo += customerInfor.get(i).toString() + "\n";

		}

		return allcInfo;

	}

	@Override
	public String getAllMediaInfo() {
		String allmInfo = ""; // all media info , The string will return all the info of media .
		Collections.sort(mediaInfor); // sort them all , they will be sorted by title.
		for (int i = 0; i < mediaInfor.size(); i++) {
			allmInfo += mediaInfor.get(i).toString() + "\n"; // store all the data in the string

		}
		return allmInfo;
	}

	@Override
	public boolean addToCart(String customerId, String mediaId) {

		// search if the customer exist
		int cstmrNumber = -1; // since the ArrayList defaults start from 0
		for (int i = 0; i < customerInfor.size(); i++) {
			if (customerInfor.get(i).getId().equals(customerId)) {
//we need to get Customer ID that will be presented as a String so it will be case sensitive . 
				cstmrNumber = i; // change customerNumber into i
			}
		}
		if (cstmrNumber == -1) {
			return false; // customer doesn't exist
		}
		// if the customer exist
		for (int i = 0; i < customerInfor.get(cstmrNumber).receiving.size(); i++) {
			// then check the receiving array
			if (customerInfor.get(cstmrNumber).receiving.get(i).equals(mediaId)) {
				return false; // the media already in cart
			}
		}
		// if the customer exist , and the media title isn't in the cart , add it .

		customerInfor.get(cstmrNumber).receiving.add(mediaId);
		return true;
	}

	@Override
	public boolean removeFromCart(String customerId, String mediaId) {

		for (int i = 0; i < customerInfor.size(); i++) {
			if (customerInfor.get(i).getId().equals(customerId))
			// by default if the customer doesn't exist it return false .
			{
				customerInfor.get(i).receiving.remove(mediaId);
				return true; // remove it from cart
			}
		}

		return false; // no data will be removed from cart

	}

	@Override
	public String processRequests() {
		String processing = ""; // A string to return all the processing in.
		// The customers will be processed in alphabetical order
		java.util.Collections.sort(customerInfor);
		// go through customers , and get each of them
		for (int i = 0; i < customerInfor.size(); i++) {

			Customer temp = customerInfor.get(i);// Get the customer i from the list

			// we need to check how many items the customers want to receive "request cart"
			int size = temp.receiving.size();
			int planNumer = 0; // number of plans
			switch (temp.getPlan()) { // get the plan name

			case "UNLIMITED": { // in case the plan is unlimited
				for (int k = 0; k < size; k++) { // get in a loop of each element in cart
					for (int n = 0; n < mediaInfor.size(); n++) {// loop in the items of media
						Media tempM = mediaInfor.get(n); // get the items

						String mediaId = tempM.getIdm(); // get the item Id
						// if this is the item we need then check the number of copies
						if (mediaId.equals(temp.receiving.get(planNumer))) {
							if (tempM.getCopiesAvailable() > 0) { // if there's more copies
								temp.receiving.remove(planNumer); // remove the request
								temp.rented.add(mediaId); // add the media item

								tempM.addOrRemoveCopies(false);// remove a copy
								String customerName = temp.getName(); // get the customer name
								processing += "Sending " + "[" + mediaId + "]" + " to " + "[" + customerName + "]\n";

								break;
							} else {// if none of the copies left , check other plans
								planNumer++;
							}

						}
					}
				}

			}
				break;

			case "LIMITED": { // in case the plan is limited
				// same steps above
				for (int k = 0; k < size; k++) {
					for (int n = 0; n < mediaInfor.size(); n++) {
						Media tempM = mediaInfor.get(n);

						String mediaId = tempM.getIdm();

						if (mediaId.equals(temp.receiving.get(planNumer))) {
							// check for number of copies
							if (tempM.getCopiesAvailable() > 0) {
								// check if the number of ranted items is less than the limit
								if (temp.rented.size() < limitedPlans) {
									temp.receiving.remove(planNumer);
									temp.rented.add(mediaId);

									tempM.addOrRemoveCopies(false);// remove a copy
									String customerName = temp.getName();
									processing += "Sending " + "[" + mediaId + "]" + " to " + "[" + customerName
											+ "]\n";

									break;// to stop it , when we reach 2 plans the other will remain in cart
								}
							} else {// else check to next plan
								planNumer++;

							}
						}

					}
				}

			}
				break;
			}

		}

		return processing;
	}

	@Override
	public boolean returnMedia(String customerId, String mediaId) {
		// we need to check if the customer exist
		int cstmrNumber = -1;
		for (int i = 0; i < customerInfor.size(); i++) {
			if (customerInfor.get(i).getId().equals(customerId))// check the number of the customer from
																// the array

			{
				cstmrNumber = i; // change customerNumber into i
			}
		}
		if (cstmrNumber == -1) {
			return false; // customer doesn't exist
		}

		Customer cTemp = customerInfor.get(cstmrNumber); // Get the customer i from the list
		// to check if it have the mediaTitle in it ranted list

		for (int i = 0; i < cTemp.rented.size(); i++) {// get the size of ranted array
			if (cTemp.rented.get(i).equals(mediaId)) { // if the media title exists
				cTemp.rented.remove(mediaId);
				for (int k = 0; k < mediaInfor.size(); k++) {
					if (mediaInfor.get(k).getIdm().equals(mediaId)) // if the title is equal to the media
																	// title
					{
						mediaInfor.get(k).addOrRemoveCopies(true);// add a copy
					}
				}

				return true; // return true

			}
		}
		return false; // else from all return false , this mean the mediaTitle doesn't exist in all
	}

	@Override
	public ArrayList<String> searchMedia(String id) {
		ArrayList<String> findMedia = new ArrayList<>();

		// this loop will test all mediaInfor list
		for (int m = 0; m < mediaInfor.size(); m++) {
			Media temp = mediaInfor.get(m); // Get the media object number m to test it

			if (temp instanceof Movie) { /* Perform casting if temp is an instance of Movie */

				Movie mvi = (Movie) temp; // make temp object of movie
				if (temp.getIdm().trim().equals(id)) {
					findMedia.add(mvi.toString());
					return findMedia; // return item

				}

			} else if (temp instanceof Album) { /* Perform casting if temp is an instance of Album */

				Album albm = (Album) temp; // turn temp into class from type Album
				if (temp.getIdm().equals(id)) {
					findMedia.add(albm.toString());
					return findMedia; // return the item

				}
			} else if (temp instanceof Game) { /* Perform casting if temp is an instance of Game */

				Game gme = (Game) temp;
				if (temp.getIdm().equals(id)) {
					findMedia.add(gme.toString());
					return findMedia; // return the item
				}
			}

		}

		for (int r = 0; r < mediaInfor.size(); r++) {
			Media temp = mediaInfor.get(r);
			if (!temp.getIdm().equals(id)) { // if the id didn't match return all the media

				findMedia.add(temp.toString() + "\n");
			}
		}

		Collections.sort(findMedia);// sort them all

		return findMedia; // return the arrayList sorted.

	}

	@Override
	public ArrayList<String> searchCustomer(String id) {
		ArrayList<String> findCustomer = new ArrayList<>();

		// this loop will test all Customer Information list
		for (int m = 0; m < customerInfor.size(); m++) {
			Customer temp = customerInfor.get(m); // Get the customer object number m to test it

			if (temp.getId().equals(id)) {
				findCustomer.add(temp.toString());

				return findCustomer; // return the item , which will be the only in the list

			}

		}

		for (int r = 0; r < customerInfor.size(); r++) {
			Customer temp = customerInfor.get(r);
			if (!temp.getId().equals(id)) { // if the customer id didn't match the one entered , add it to the list
				findCustomer.add(temp.toString() +"\n");
			}
		}

		Collections.sort(findCustomer);// sort them all

		return findCustomer; // return the arrayList sorted.

	}

// we will not use the same method in adding the media and customer in the beginning as the id won't change. 
	@Override
	public void updateCustomers(String id, String name, String address, String plan, String mobile) {

		Collections.sort(customerInfor);// sort them all , they will be sorted by Id.
		for (int m = 0; m < customerInfor.size(); m++) {
			Customer temp = customerInfor.get(m);
			if (temp.getId().equals(id)) {
				customerInfor.remove(m); // remove the old data
				temp = new Customer(id, name, address, plan, mobile);

				customerInfor.add(temp); // replace them with the new ones

			}

		}

	}

	@Override
	public void upDateMovie(String idm, String title, int copiesAvailable, String rating) {
		Collections.sort(mediaInfor);
		for (int m = 0; m < mediaInfor.size(); m++) {
			Media temp = mediaInfor.get(m);
			if (temp.getIdm().equals(idm)) {
				mediaInfor.remove(m); // remove the old data

				temp = new Movie(idm, title, copiesAvailable, rating);

				mediaInfor.add(temp); // replace them with the new ones

			}

		}

	}

	@Override
	public void upDateGame(String idm, String title, int copiesAvailable, double weight) {
		Collections.sort(mediaInfor);
		for (int m = 0; m < mediaInfor.size(); m++) {
			Media temp = mediaInfor.get(m);
			if (temp.getIdm().equals(idm)) {
				mediaInfor.remove(m); // remove the old data

				temp = new Game(idm, title, copiesAvailable, weight);

				mediaInfor.add(temp); // replace them with the new ones

			}

		}

	}

	@Override
	public void upDateAlbum(String idm, String title, int copiesAvailable, String artist, String songs) {
		Collections.sort(mediaInfor);
		for (int m = 0; m < mediaInfor.size(); m++) {
			Media temp = mediaInfor.get(m);
			if (temp.getIdm().equals(idm)) {
				mediaInfor.remove(m); // remove the old data

				temp = new Album(idm, title, copiesAvailable, artist, songs);

				mediaInfor.add(temp); // replace them with the new ones

			}

		}

	}

}
