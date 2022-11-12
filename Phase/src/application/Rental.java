package application;

import java.io.*;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class Rental extends RentShow {
	
	GridPane renting = new GridPane();

	 static void writeToAFileProcessing(String rent,java.util.Date Date) {
		File cartProcess = new File("Cart processes.txt");
		try {
			PrintWriter theprocesses = new PrintWriter(cartProcess);
			theprocesses.append(rent +Date +"\n");
			theprocesses.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 static void DataAfter(String c,String m) {
		File cartProcess = new File("Data After.txt");
		try {
			PrintWriter theprocesses = new PrintWriter(cartProcess);
			theprocesses.append("****** Customers After ******\n");
			theprocesses.append(c);
			theprocesses.append("******** Media After *******\n");
			theprocesses.append(m);
			theprocesses.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	 Rental(MediaRental r) {
		super(r);
		this.setTitle("Cart");
		this.setScene(new Scene(renting, 1400, 600));
		this.setMaximized(true);
		
		
		Button returne = new Button("Close");
		Image arrow = new Image("https://img.icons8.com/material-outlined/1x/return.png");
		ImageView returnB = new ImageView(arrow);
		HBox returnSection = new HBox(returne, returnB);
		returnSection.setLayoutX(520);
		returnSection.setLayoutY(350);

		
		
		Label nameC = new Label("Customer Id:");
		TextField cID = new TextField();
		Pane infoC = new Pane();
		Scene inforC = new Scene(infoC, 300, 300);
		Text informations = new Text("Enter The Id");
		informations.setLayoutX(10);
		informations.setLayoutY(13);
		informations.setFill(Color.DARKRED);
		infoC.getChildren().add(informations);
		inforC.setRoot(infoC);
		
		
		VBox allC = new VBox(cID, infoC);

		HBox infoBoxC = new HBox(nameC, allC);
		infoBoxC.setSpacing(25);
		

		Label Mname = new Label("Media Id:");
		TextField mID = new TextField();
		Pane infoM = new Pane();
		Scene inforM = new Scene(infoM, 300, 300);
		Text informationsM = new Text("Enter The Id");
		informationsM.setLayoutX(10);
		informationsM.setLayoutY(13);
		informationsM.setFill(Color.DARKRED);
		infoM.getChildren().add(informationsM);
		inforM.setRoot(infoM);

		VBox allM = new VBox(mID, infoM);
		HBox infoBoxM = new HBox(Mname, allM);
		infoBoxM.setSpacing(40);

		Label datee = new Label("Rented Date");

		Text time = new Text();

		HBox dateBox = new HBox(datee, time);
		dateBox.setSpacing(30);

		VBox rents = new VBox(infoBoxC, infoBoxM, dateBox);
		rents.setSpacing(60);
		rents.setLayoutX(20);
		rents.setLayoutY(30);

		ImageView carts = new ImageView(new Image("https://img.icons8.com/office/30/add-shopping-cart.png"));
		ImageView processCart = new ImageView(
				new Image("https://img.icons8.com/office/30/buy--v1.png"));

		Button addToCart = new Button("Add to Cart");
		HBox cartIn = new HBox(addToCart, carts);
		
		Button processing = new Button("Process Cart");
		HBox processCartin = new HBox(processing, processCart);
		
		Button removeFrom = new Button("Remove from Cart");
		ImageView removeing = new ImageView(
				new Image("https://img.icons8.com/office/30/clear-shopping-cart.png"));
		HBox removingitem = new HBox(removeFrom, removeing);

		Button returnItems = new Button("Retun item");
		ImageView returningItems = new ImageView(
				new Image("https://img.icons8.com/office/30/return-purchase.png"));
		HBox retrning =new HBox(returnItems,returningItems);

		
		
		HBox buttonsBox = new HBox(cartIn, processCartin, removingitem,retrning);
		buttonsBox.setSpacing(22);
		buttonsBox.setLayoutX(10);
		buttonsBox.setLayoutY(350);
		
		renting.add(rents,0,0);
		renting.add(buttonsBox,0,1);
		renting.add(returnSection,3,2);
		renting.setScaleX(1.4);
		renting.setScaleY(1.4);

		renting.setVgap(40);
		renting.setHgap(30);

		this.centerOnScreen();
		this.setMaximized(true);
		renting.setAlignment(Pos.CENTER);
		
		java.util.Date Date = new java.util.Date();
		this.show();
		returne.setOnAction(t -> {
			new RentShow(r);
			DataAfter(r.getAllCustomersInfo(),r.getAllMediaInfo());
		this.close();}
		);



		addToCart.setOnAction(n -> {
			if ((cID.getText() != null && !cID.getText().isEmpty())
					&& (mID.getText() != null && !mID.getText().isEmpty())) {

				r.addToCart(cID.getText(), mID.getText());
				datee.setText(Date.toString());

				informations.setText(r.searchCustomer(cID.getText()).toString().trim());

				informationsM.setText(r.searchMedia(mID.getText()).toString());

			//	System.out.println(r.getAllCustomersInfo());
			}

		});
		processing.setOnAction(f -> {

			if ((cID.getText() != null && !cID.getText().isEmpty())
					&& (mID.getText() != null && !mID.getText().isEmpty())) {
				r.processRequests();
				informations.setText(r.searchCustomer(cID.getText()).toString());

				informationsM.setText(r.searchMedia(mID.getText()).toString());
				writeToAFileProcessing(r.getAllCustomersInfo(),Date);
				
			//	System.out.println(r.getAllCustomersInfo());
			}

		});

		removeFrom.setOnAction(v -> {
			if ((cID.getText() != null && !cID.getText().isEmpty())
					&& (mID.getText() != null && !mID.getText().isEmpty())) {

				r.removeFromCart(cID.getText(), mID.getText());
				datee.setText(Date.toString());
				informations.setText(r.searchCustomer(cID.getText()).toString());

				informationsM.setText(r.searchMedia(mID.getText()).toString());
			//	System.out.println(r.getAllCustomersInfo());
			}

		});
		returnItems.setOnAction( c ->{
			if ((cID.getText() != null && !cID.getText().isEmpty())&& (mID.getText() != null && !mID.getText().isEmpty())) {
				
				r.returnMedia(cID.getText(), mID.getText());
				datee.setText(Date.toString());
				informations.setText(r.searchCustomer(cID.getText()).toString());

				informationsM.setText(r.searchMedia(mID.getText()).toString());
				
				
			}
			
			
			
		} );

	}

}
