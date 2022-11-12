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


public class AddCustomer extends CustomersShow {
	Pane customers = new Pane();


	AddCustomer(MediaRental c, File forCustomers) {

		super(c, forCustomers);
		this.setTitle("add Customer");
		this.setScene(new Scene(customers, 400, 400));

		Button returne = new Button("Return");
		Image arrow = new Image("https://img.icons8.com/material-outlined/1x/return.png");
		ImageView returnB = new ImageView(arrow);

		HBox returnSection = new HBox(returne, returnB);
		returnSection.setLayoutX(300);
		returnSection.setLayoutY(350);

		Label idC = new Label("Customer ID");
		idC.setMinWidth(100);
		TextField enterId = new TextField();

		HBox idBox = new HBox(idC, enterId);
		idBox.setSpacing(10);

		idBox.setAlignment(Pos.CENTER);

		Label nameC = new Label("Customer Name");
		TextField enternameC = new TextField();
		enternameC.setDisable(true);
		enterId.setOnKeyTyped(r -> {
			enternameC.setDisable(false);

		});
		nameC.setMinWidth(100);
		HBox nameBox = new HBox(nameC, enternameC);
		nameBox.setSpacing(10);

		Label cAddress = new Label("Customer Address:");
		TextField entercAddress = new TextField();
		entercAddress.setDisable(true);
		enternameC.setOnKeyTyped(g -> {
			entercAddress.setDisable(false);
		});
		cAddress.setMinWidth(100);
		HBox addressBox = new HBox(cAddress, entercAddress);
		addressBox.setSpacing(10);

		Label cPlan = new Label("Customer Plan:");
		TextField entercPlan = new TextField();
		entercPlan.setDisable(true);
		entercAddress.setOnKeyTyped(t -> {
			entercPlan.setDisable(false);
		});

		cPlan.setMinWidth(100);

		HBox PlanBox = new HBox(cPlan, entercPlan);
		PlanBox.setSpacing(10);

		Label cMobile = new Label("Customer Mobile");
		TextField entercMobile = new TextField();
		entercMobile.setDisable(true);
		entercPlan.setOnKeyTyped(t -> {
			entercMobile.setDisable(false);
		});
		cMobile.setMinWidth(100);
		HBox mobileBox = new HBox(cMobile, entercMobile);
		mobileBox.setSpacing(10);
		
		Label test = new Label("Enter your Data ");
		test.setTextFill(Color.BLUEVIOLET);
		
		VBox data = new VBox(idBox, nameBox, addressBox, PlanBox, mobileBox ,test);
		data.setSpacing(10);
		data.setLayoutX(30);
		data.setLayoutY(40);

		Button addCustomer = new Button("Add");
		ImageView addS = new ImageView(new Image("https://img.icons8.com/dusk/26/add-user-female.png"));
		HBox addSection = new HBox(addCustomer, addS);
		addSection.setLayoutY(350);
		addSection.setLayoutX(20);

		
		
		
		nameBox.setAlignment(Pos.CENTER);
		addressBox.setAlignment(Pos.CENTER);
		PlanBox.setAlignment(Pos.CENTER);
		mobileBox.setAlignment(Pos.CENTER);

		customers.getChildren().add(data);
		customers.getChildren().add(returnSection);
		customers.getChildren().add(addSection);
		this.show();

		this.centerOnScreen();

		returne.setOnAction(t -> {
			new CustomersShow(c, forCustomers);
			this.close();

		});

		addCustomer.setOnAction(r -> {

			if ((enterId.getText() != null && !enterId.getText().isEmpty())) {
				c.addCustomer(enterId.getText(), enternameC.getText(), entercAddress.getText(), entercPlan.getText(),
						entercMobile.getText());
				test.setText("Added "+enterId.getText()+" "+enternameC.getText());
				// System.out.println(c.getAllCustomersInfo());
			}

		});

	}

}
