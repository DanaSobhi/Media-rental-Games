package application;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class SearchCustomer extends CustomersShow {

	Pane customers = new Pane();

	SearchCustomer(MediaRental c,File forCustomers) {
		super(c, forCustomers);
		this.setTitle("Search Customer");
		this.setScene(new Scene(customers, 400, 400));
		Button returne = new Button("Return");
		Image arrow = new Image("https://img.icons8.com/material-outlined/1x/return.png");
		ImageView returnB = new ImageView(arrow);

		HBox returnSection = new HBox(returne, returnB);
		returnSection.setLayoutX(300);
		returnSection.setLayoutY(350);

		Label idC = new Label("Customer ID");
		TextField enterId = new TextField();
		HBox idBox = new HBox(idC, enterId);
		idBox.setSpacing(44);

		Label cInfo = new Label("Customer informations");
		Pane infoC = new Pane();
		Scene infor = new Scene(infoC, 300, 300);
		Text informations = new Text("Enter ID to search");
		informations.setLayoutX(10);
		informations.setLayoutY(13);
		informations.setFill(Color.DARKRED);
		infoC.getChildren().add(informations);
		infor.setRoot(infoC);

		HBox infoBox = new HBox(cInfo, infoC);
		infoBox.setSpacing(10);

		VBox data = new VBox(idBox, infoBox);
		data.setSpacing(10);
		data.setLayoutX(30);
		data.setLayoutY(40);

		Button searchCustomer = new Button("Search");
		ImageView addS = new ImageView(new Image("https://img.icons8.com/dusk/26/search--v1.png"));
		HBox searchSection = new HBox(searchCustomer, addS);
		searchSection.setLayoutY(350);
		searchSection.setLayoutX(20);
		searchSection.setAlignment(Pos.CENTER);

		customers.getChildren().add(data);
		customers.getChildren().add(returnSection);
		customers.getChildren().add(searchSection);
		this.centerOnScreen();
		this.show();
		returne.setOnAction(t -> {
			new CustomersShow(c, forCustomers);
			this.close();
		});

		searchCustomer.setOnAction(s -> {
			if ((enterId.getText() != null && !enterId.getText().isEmpty())) {

				informations.setText(c.searchCustomer(enterId.getText()).toString());
				// System.out.println(c.searchCustomer(enterId.getText()));
			}

		});

	}

}
