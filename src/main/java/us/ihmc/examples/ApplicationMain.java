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
   ShapeFactory3D shapeFactory3D = new ShapeFactory3D();
   //ShapeFactory3DListeners listeners = new ShapeFactory3DListeners();

   @Override
   public void start(Stage primaryStage) throws Exception
   {
      FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/Application.fxml"));
      BorderPane primaryPane = loader.load(); //get loader controller
      @SuppressWarnings("unused")
      ApplicationController applicationController = loader.getController();
      //applicationController.
      //should return application controller
      //should allow us to call the controller in separate classes and return data
      Pane modelPane = new Pane();

      primaryPane.setCenter(modelPane);
      modelPane.getChildren().add(shapeFactory3D.view3dFactory.getSubScene());

      primaryStage.setTitle(getClass().getSimpleName());
      primaryStage.setScene(new Scene(primaryPane));
      shapeFactory3D.view3dFactory.getSubScene().heightProperty().bind(modelPane.heightProperty());
      shapeFactory3D.view3dFactory.getSubScene().widthProperty().bind(modelPane.widthProperty());
      primaryStage.setOnCloseRequest(event -> stop());
      primaryStage.show();
      
//      listeners.shapeListener();
//      listeners.textFieldListener();
//      listeners.sliderListener();
//      listeners.colorListener();

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