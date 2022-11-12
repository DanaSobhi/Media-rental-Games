package application;

import java.io.File;


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

public class DeleteCustomer extends CustomersShow {
	Pane customers = new Pane();

	DeleteCustomer(MediaRental c, File forCustomers) {
		super(c, forCustomers);
		this.setTitle("Delete Customer");
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

		Text deletedComfirms = new Text("Enter The ID to Delete");
		deletedComfirms.setFill(Color.BLUE);

		VBox data = new VBox(idBox, deletedComfirms);
		data.setSpacing(10);
		data.setLayoutX(30);
		data.setLayoutY(40);

		Button findC = new Button("Find");
		ImageView findCI = new ImageView(new Image("https://img.icons8.com/dusk/26/find-user-female.png"));
		HBox findSection = new HBox(findC, findCI);
		findSection.setLayoutY(350);
		findSection.setLayoutX(10);

		Button deleteC = new Button("Delete");
		ImageView deleteCI = new ImageView(new Image("https://img.icons8.com/dusk/26/delete-forever.png"));

		HBox deleteSection = new HBox(deleteC, deleteCI);
		deleteSection.setLayoutY(350);
		deleteSection.setLayoutX(150);
		customers.getChildren().add(data);
		customers.getChildren().add(returnSection);
		customers.getChildren().add(findSection);
		customers.getChildren().add(deleteSection);

		this.centerOnScreen();

		this.show();
		returne.setOnAction(t -> {
			new CustomersShow(c, forCustomers);
			this.close();
		});
		
		
		findC.setOnAction(r ->{
			if ((enterId.getText() != null && !enterId.getText().isEmpty())) {
			
			deletedComfirms.setText(c.searchCustomer(enterId.getText().trim()).toString());
			}
		});
		deleteC.setOnAction(r -> {

			if ((enterId.getText() != null && !enterId.getText().isEmpty())) {
				c.removeCustomer(enterId.getText().trim());

				deletedComfirms.setText("Deleted successfully ");
			}
		});
	}

}
