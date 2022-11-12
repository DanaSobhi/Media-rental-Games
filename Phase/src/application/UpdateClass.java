package application;

import java.io.*;


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

public class UpdateClass extends CustomersShow {

	Pane customers = new Pane();

	UpdateClass(MediaRental c, File forCustomers) {
		super(c, forCustomers);
		this.setTitle("Update Customers");
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
		idC.setMinWidth(100);
		idBox.setSpacing(10);

		idBox.setAlignment(Pos.CENTER);

		Label nameC = new Label("Customer Name");
		TextField enternameC = new TextField();
		HBox nameBox = new HBox(nameC, enternameC);
		nameC.setMinWidth(100);
		nameBox.setSpacing(10);

		nameBox.setAlignment(Pos.CENTER);

		Label cAddress = new Label("Customer Address:");
		TextField entercAddress = new TextField();
		HBox addressBox = new HBox(cAddress, entercAddress);
		cAddress.setMinWidth(100);
		addressBox.setSpacing(10);

		addressBox.setAlignment(Pos.CENTER);

		Label cPlan = new Label("Customer Plan:");
		TextField entercPlan = new TextField();
		HBox PlanBox = new HBox(cPlan, entercPlan);
		cPlan.setMinWidth(100);
		PlanBox.setSpacing(10);

		PlanBox.setAlignment(Pos.CENTER);

		Label cMobile = new Label("Customer Mobile");
		TextField entercMobile = new TextField();
		cMobile.setMinWidth(100);
		HBox mobileBox = new HBox(cMobile, entercMobile);
		mobileBox.setSpacing(10);

		mobileBox.setAlignment(Pos.CENTER);
		
		Label test = new Label("Enter your Data ");
		test.setTextFill(Color.BLUEVIOLET);

		VBox data = new VBox(idBox, nameBox, addressBox, PlanBox, mobileBox,test);
		data.setSpacing(10);
		data.setLayoutX(30);
		data.setLayoutY(40);

		Button upDateCustomer = new Button("Update");
		ImageView addS = new ImageView(new Image("https://img.icons8.com/dusk/24/restart.png"));
		HBox updateSection = new HBox(upDateCustomer, addS);
		updateSection.setAlignment(Pos.CENTER);
		updateSection.setLayoutY(350);
		updateSection.setLayoutX(20);

		customers.getChildren().add(data);
		customers.getChildren().add(returnSection);
		customers.getChildren().add(updateSection);
		this.centerOnScreen();
		this.show();
		returne.setOnAction(t -> {
			new CustomersShow(c, forCustomers);
			this.close();
		});

		upDateCustomer.setOnAction(t -> {
			if ((enterId.getText() != null && !enterId.getText().isEmpty())) {
				c.updateCustomers(enterId.getText(), enternameC.getText(), entercAddress.getText(),
						entercPlan.getText(), entercMobile.getText());
				
				test.setText("updated "+enterId.getText()+" "+enternameC.getText());
			//	System.out.println(c.getAllCustomersInfo());
			}
		});

	}
}
