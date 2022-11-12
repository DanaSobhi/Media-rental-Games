package application;

import java.io.*;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CustomersShow extends Stage {

	GridPane customers = new GridPane();

	CustomersShow(MediaRental m,File forCustomers) {
		
		this.setTitle("Customer Operation");
		this.setScene(new Scene(customers, 400, 400));
		this.setMaximized(true);
		Button returne = new Button("Close");
		Image arrow = new Image("https://img.icons8.com/material-outlined/1x/return.png");
		ImageView returnB = new ImageView(arrow);
		HBox returnSection = new HBox(returne, returnB);
		returnSection.setLayoutX(300);
		returnSection.setLayoutY(350);
		Button addC = new Button("Add Customer");
		addC.setMaxSize(1000, 700);
		addC.setTextFill(Color.DARKSLATEBLUE);
		ImageView customersAdd = new ImageView(
				new Image("https://img.icons8.com/color-glass/45/add-user-group-man-man.png"));

		Button findC = new Button("Delete Customer");
		findC.setMaxSize(1000, 700);
		findC.setTextFill(Color.DARKSLATEBLUE);
		ImageView customerDelete = new ImageView(
				new Image("https://img.icons8.com/color-glass/45/delete-user-male.png"));

		Button updateC = new Button("Update informations");
		updateC.setMaxSize(1000, 700);
		updateC.setTextFill(Color.DARKSLATEBLUE);
		ImageView updateCustomers = new ImageView(
				new Image("https://img.icons8.com/color-glass/45/change-user-male.png"));

		Button SearchC = new Button("Search Customer");
		SearchC.setMaxSize(1000, 700);
		SearchC.setTextFill(Color.DARKSLATEBLUE);
		ImageView searchCustomerss = new ImageView(
				new Image("https://img.icons8.com/color-glass/45/find-user-male.png"));

		customers.setAlignment(Pos.CENTER);
		customers.add(addC, 0, 0);
		customers.add(customersAdd, 1, 0);

		customers.add(findC, 0, 1);
		customers.add(customerDelete, 1, 1);

		customers.add(updateC, 0, 2);
		customers.add(updateCustomers, 1, 2);

		customers.add(SearchC, 0, 3);
		customers.add(searchCustomerss, 1, 3);

		customers.add(returnSection, 5, 5);

		customers.setVgap(40);
		customers.setHgap(20);
		customers.setScaleX(1.3);
		customers.setScaleY(1.3);

		this.show();
		addC.setOnAction(a -> { //it opens the customer add window and close this one 
			new AddCustomer(m, forCustomers);
			this.close();
		});
		findC.setOnAction(f -> { //open delete and close this window
			new DeleteCustomer(m, forCustomers);
			this.close();
		});
		updateC.setOnAction(e -> { //open update and close this window
			new UpdateClass(m, forCustomers);
			this.close();
		});
		SearchC.setOnAction(c -> { //open search and close this window
			new SearchCustomer(m, forCustomers);
			this.close();
		});

		PrintWriter forCustomersappend;
		try {
			forCustomersappend = new PrintWriter(forCustomers);
			returne.setOnAction(t ->{ this.close(); //when closing the window by clicking close button it save everything 
			
			forCustomersappend.append(m.getAllCustomersInfo());
			//to add all the data after changing or deleting etc 
				//	forCustomers.append("***********************\n");
			forCustomersappend.close();
					System.out.println(m.getAllCustomersInfo());
			}
			);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}
}
