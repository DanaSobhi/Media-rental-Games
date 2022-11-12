package application;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class UpdateMovies extends UpdateMedia  {

	GridPane moviees = new GridPane();
	 UpdateMovies(MediaRental m,File moviesInfo,File albumInfo,File gameInfo) {
		super(m,moviesInfo, albumInfo, gameInfo);
		this.setTitle("Movie Update");
		this.setScene(new Scene(moviees,500,400));
		Label idM = new Label("Media ID");
		TextField enterId = new TextField();
		
		moviees.add(idM, 0, 0);
		moviees.add(enterId, 1, 0);
		
		Label titleM = new Label("Media Title");
		TextField enternameM = new TextField();
		moviees.add(titleM, 0, 1);
		moviees.add(enternameM, 1, 1);
		
		
		Label copiesM = new Label("Copies Available");
		TextField enterCopies = new TextField();
		
		moviees.add(copiesM, 0, 2);
		moviees.add(enterCopies, 1, 2);
		
		Label ratingM = new Label("Enter Rating ");
		TextField enterMr= new TextField();
		
		moviees.add(ratingM, 0, 3);
		moviees.add(enterMr, 1, 3);
		
		Button add = new Button("Update Movie");
		
		ImageView addA = new ImageView(new Image("https://img.icons8.com/dusk/26/add-image.png"));
		HBox addButton = new HBox(add,addA);
		addButton.setAlignment(Pos.CENTER);
		Label test = new Label("Enter data to update");
		
		
		Button returnS = new Button("Return");
		ImageView returnB = new ImageView( new Image("https://img.icons8.com/material-outlined/1x/return.png"));
		HBox returnButton = new HBox(returnS,returnB);
		moviees.setScaleX(1.2);
		moviees.setScaleY(1.2);
		
		moviees.add(returnButton, 3, 5);
		moviees.setAlignment(Pos.CENTER);
		moviees.add(addButton, 1, 5);
		moviees.add(test, 0, 5);
		moviees.setVgap(20);
		moviees.setHgap(20);
		
		this.centerOnScreen();
		
		add.setOnAction(t -> {
			 if ((enterId.getText() != null && !enterId.getText().isEmpty()) ) {
				 test.setText(enterId.getText() + " " + enternameM.getText() + ", "+ "Updated");
				 
				m.upDateMovie(enterId.getText(), enternameM.getText(), Integer.parseInt(enterCopies.getText()),enterMr.getText());
				 	
				 System.out.println(m.getAllMediaInfo());
				    } 
			 else {
				    	test.setText("Please Enter all info");
				    }
				
		});
		returnS.setOnAction(t -> {
			
			new UpdateMedia(m,moviesInfo, albumInfo, gameInfo);
			this.close();
		});

		this.show();
	}

}
