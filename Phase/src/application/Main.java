package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Main extends Application {
	public MediaRental m = new MediaRental();

	public MediaRental getMediarental() {
		return m;

	}

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		// m.setLimitedPlanLimit(4); //you change change here the limited plan number.
		// so the data will be applied to all database
		try {

			// i added the print to console to check the data if they got added or not ,
			// there no need for them , but they are helpful for checking datas
			File customerinformations = new File("Customers.txt");

			File moviesInfo = new File("Movies.txt");
			// FileWriter movieReading = new FileWriter(moviesInfo,true); //there's no need
			// for them anymore , made them to chack the file if it can still read using
			// printwriter
			// PrintWriter forMovies = new PrintWriter(movieReading); //no need

			File albumInfo = new File("Albums.txt");
			// FileWriter albumReading = new FileWriter(albumInfo,true); //no need
			// PrintWriter forAlbums = new PrintWriter(albumReading);//no need

			File gameInfo = new File("Games.txt");
			// FileWriter gameReading = new FileWriter(gameInfo,true);//no need
			// PrintWriter forGames = new PrintWriter(gameReading); //no need

			Button processing = new Button("restore Data");
			processing.setOnAction(t -> {

				Scanner input;
				try {
					input = new Scanner(customerinformations); // read the file
					while (input.hasNext()) { // while the scanner read nextline
						String temp = input.nextLine();
						String[] temps = temp.split(" "); // split them with spaces

						m.addCustomer(temps[0], temps[1], temps[2], temps[3], temps[4]);
						// add the customer to the database
					}
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				Scanner o;
				try {
					o = new Scanner(moviesInfo); // read the file
					while (o.hasNext()) { // while the scanner read nextline
						String temp = o.nextLine();
						String[] temps = temp.split(" ");
						int copies = Integer.parseInt(temps[2].trim());
						m.addMovie(temps[0], temps[1], copies, temps[3]);
						// add the game to the media database
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Scanner e;
				try {
					e = new Scanner(albumInfo); // read the file
					while (e.hasNext()) {// while the scanner read nextline
						String temp = e.nextLine();
						String[] temps = temp.split(" ");
						int copies = Integer.parseInt(temps[2].trim());
						m.addAlbum(temps[0], temps[1], copies, temps[3], temps[4]);
						// add the album
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Scanner g;
				try {
					g = new Scanner(gameInfo); // read the file using scanner
					while (g.hasNext()) { // while the scanner read nextline
						String temp = g.nextLine();
						String[] temps = temp.split(" ");
						int copies = Integer.parseInt(temps[2].trim());
						double weight = Double.parseDouble(temps[3].trim());
						m.addGame(temps[0], temps[1], copies, weight);
						// add the game
					}
				} catch (FileNotFoundException e1) {

					e1.printStackTrace();
				}

			});

			GridPane root2 = new GridPane();
			Scene scene = new Scene(root2, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setMaximized(true);

			Button cusomer = new Button("Customer");
			cusomer.setMaxSize(1000, 1000);
			cusomer.setTextFill(Color.DARKCYAN);
			cusomer.setOnAction(t -> {
				// opens the customer operatrion window
				new CustomersShow(getMediarental(), customerinformations);
			});

			Button media = new Button("Media");
			media.setMaxSize(1000, 1000);
			media.setTextFill(Color.DARKCYAN);
			media.setOnAction(a -> new MediaShows(getMediarental(), moviesInfo, albumInfo, gameInfo));// open the media
																										// operation
																										// window
			Button rent = new Button("rent");
			rent.setMaxSize(1000, 1000);
			rent.setTextFill(Color.DARKCYAN);
			processing.setMaxSize(1000, 1000);
			processing.setTextFill(Color.DARKCYAN);
			
			Label setLimits = new Label("set Limits");
			TextField limit = new TextField();
			limit.setMaxSize(40, 40);
			Button set = new Button  ("set");
			set.setMaxSize(1000, 1000);
			set.setTextFill(Color.DARKCYAN);
			
			HBox setSection = new HBox(setLimits,limit,set);
			setSection.setSpacing(5);
			setSection.setMaxSize(160, 40);
		//	setSection.setScaleY(0.4);
			
			

			rent.setOnAction(h -> new RentShow(getMediarental()));// open rent operation window

			VBox mainBox = new VBox(0, cusomer, media, rent, processing);
			mainBox.setSpacing(30);

			ImageView photos = new ImageView(new Image(
					"https://img.icons8.com/external-icongeek26-linear-colour-icongeek26/250/external-shop-ecommerce-icongeek26-linear-colour-icongeek26.png"));
			photos.setLayoutX(120);
			photos.setLayoutY(0);

			set.setOnAction(t -> { //it when clicking on set it will set limit to givin number
				if ((limit.getText() != null && !limit.getText().isEmpty())) { //as soon the text field not null or empty 
				int number = Integer.parseInt(limit.getText().toString());
				m.setLimitedPlanLimit(number);
				setLimits.setText("limit is "+limit.getText());
				}
			});
			
			root2.add(mainBox, 0, 0);
			root2.add(photos, 1, 0);
			root2.add(setSection, 0, 1);

			root2.setVgap(0);
			root2.setHgap(50);

			root2.setScaleX(2);
			root2.setScaleY(2);

			root2.setAlignment(Pos.CENTER);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Rental Media System");
			primaryStage.show();

			// System.out.println(m.getAllCustomersInfo());
			// System.out.println(m.getAllMediaInfo());

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
