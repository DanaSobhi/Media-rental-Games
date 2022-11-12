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


public class UpdateAblums extends UpdateMedia {


	GridPane albums = new GridPane();
	 UpdateAblums(MediaRental a,File moviesInfo,File albumInfo,File gameInfo) {

		super(a,moviesInfo, albumInfo, gameInfo);
		this.setTitle("Update Albums");
		this.setScene(new Scene(albums,500,400));
		Label idM = new Label("Media ID");
		TextField enterId = new TextField();
		
		albums.add(idM, 0, 0);
		albums.add(enterId, 1, 0);
		
		Label titleM = new Label("Media Title");
		TextField enternameM = new TextField();
		
		albums.add(titleM, 0, 1);
		albums.add(enternameM, 1, 1);
		
		
		Label copiesM = new Label("Copies Available");
		TextField enterCopies = new TextField();

		
		albums.add(copiesM, 0, 2);
		albums.add(enterCopies, 1, 2);
		
		Label artistA = new Label("Enter Artist Name ");
		TextField enterAr= new TextField();

		albums.add(artistA, 0, 3);
		albums.add(enterAr, 1, 3);
		
		Label songsAl = new Label("Enter Songs");
		TextField enterAl= new TextField();
	
		
		albums.add(songsAl, 0, 4);
		albums.add(enterAl, 1, 4);
		Button add = new Button("Update Album");
		ImageView addA = new ImageView(new Image("https://img.icons8.com/dusk/26/music-record.png"));
		HBox addButton = new HBox(add,addA);
		albums.add(addButton, 1, 5);
		
		Button returnS = new Button("Return");
		ImageView returnB = new ImageView( new Image("https://img.icons8.com/material-outlined/1x/return.png"));
		HBox returnButton = new HBox(returnS,returnB);
		Label test = new Label("Enter data to update");

		
		albums.setScaleX(1.2);
		albums.setScaleY(1.2);
		
		albums.add(returnButton, 3, 5);	
		albums.setAlignment(Pos.CENTER);
		
		albums.add(test, 0, 5);

		albums.setVgap(20);
		albums.setHgap(20);
		
		add.setOnAction(t ->{
			 if ((enterId.getText() != null && !enterId.getText().isEmpty()) ) {
			 int copies = Integer.parseInt(enterCopies.getText().trim());
			
			 a.upDateAlbum(enterId.getText().trim(), enternameM.getText().trim(), copies, enterAr.getText(), enterAl.getText());
			 test.setText(enterId.getText() + " " + enternameM.getText() + ", "+ "Updated");

			 System.out.println(a.getAllMediaInfo());
			 }
			 else {
			    	test.setText("Please Enter all info");

			 }
			 
			 });

		returnS.setOnAction(t -> {
			
			new UpdateMedia(a,moviesInfo, albumInfo, gameInfo);
			this.close();
		});

		this.centerOnScreen();
		this.show();
	}
}
