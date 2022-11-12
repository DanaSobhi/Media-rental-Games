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


public class DeleteMedia extends MediaShows {

	Pane medias = new Pane();
	 DeleteMedia(MediaRental m,File moviesInfo,File albumInfo,File gameInfo) {
		super(m,moviesInfo, albumInfo, gameInfo);
		this.setTitle("Delete Media");
		this.setScene(new Scene(medias, 400, 400));
		Button returne = new Button("Return");
		Image arrow = new Image("https://img.icons8.com/material-outlined/1x/return.png");
		ImageView returnB = new ImageView(arrow);

		HBox returnSection = new HBox(returne, returnB);
		returnSection.setLayoutX(300);
		returnSection.setLayoutY(350);
		
		
		Label idM = new Label("Media ID");
		TextField enterId = new TextField();
		HBox idBox = new HBox(idM, enterId);
		idBox.setSpacing(44);
		idBox.setLayoutX(50);
		idBox.setLayoutY(50);
		
		Text deletedComfirms = new Text("Enter The ID to Delete");
		deletedComfirms.setFill(Color.BLUE);
		
		VBox data = new VBox(idBox,deletedComfirms);
		data.setSpacing(10);
		data.setLayoutX(30);
		data.setLayoutY(40);
		
		
		
		Button findM = new Button("Find");
		ImageView findMI = new ImageView(new Image("https://img.icons8.com/dusk/26/search--v1.png"));
		HBox findSection = new HBox(findM, findMI);
	   	findSection.setLayoutY(350);
		findSection.setLayoutX(10);
		


		Button deleteM = new Button("Delete");
		ImageView deleteMI = new ImageView(new Image("https://img.icons8.com/dusk/26/delete-forever.png"));
		
		HBox deleteSection = new HBox(deleteM, deleteMI);
		deleteSection.setLayoutY(350);
		deleteSection.setLayoutX(150);

		
		medias.getChildren().add(data);
		medias.getChildren().add(findSection);
		medias.getChildren().add(returnSection);
		medias.getChildren().add(deleteSection);
		
		this.centerOnScreen();
		this.show();
		
		returne.setOnAction(t -> {new MediaShows(m,moviesInfo, albumInfo, gameInfo);
			this.close();
		});
		
		
		findM.setOnAction(t ->{
			if ((enterId.getText() != null && !enterId.getText().isEmpty()) ) {
			deletedComfirms.setText(m.searchMedia(enterId.getText().trim()).toString());
			}
		});
		
		deleteM.setOnAction(r -> {
			
			if ((enterId.getText() != null && !enterId.getText().isEmpty()) ) {
				m.removeMedia(enterId.getText().trim());
				
				deletedComfirms.setText("Deleted successfully ");
			}
		});
	}

}
