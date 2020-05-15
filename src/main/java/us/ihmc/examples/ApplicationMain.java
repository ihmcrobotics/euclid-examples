package us.ihmc.examples;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ApplicationMain extends Application
{	
	
   @Override
   public void start(Stage primaryStage) throws Exception
   {
	   FXMLLoader loader = new FXMLLoader(getClass().getResource("Application.fxml"));
	   BorderPane primaryPane = loader.load();
	   Pane modelPane = new Pane();
	   
	   primaryPane.setCenter(modelPane);
       modelPane.getChildren().add(Shape3DBasics.view3dFactory.getSubScene());
      
      primaryStage.setTitle(getClass().getSimpleName());
      primaryStage.setScene(new Scene(primaryPane));
      Shape3DBasics.view3dFactory.getSubScene().heightProperty().bind(modelPane.heightProperty());
      Shape3DBasics.view3dFactory.getSubScene().widthProperty().bind(modelPane.widthProperty());
      primaryStage.setOnCloseRequest(event -> stop());
      primaryStage.show();
      
   }

   @Override
   public void stop()
   {
      Platform.exit();
   }

   public static void main(String[] args)
   {
      launch(args);
   }
}