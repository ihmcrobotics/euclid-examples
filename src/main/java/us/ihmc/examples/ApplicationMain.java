package us.ihmc.examples;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import us.ihmc.javaFXToolkit.scenes.View3DFactory;
import us.ihmc.javaFXToolkit.scenes.View3DFactory.SceneType;

public class ApplicationMain extends Application
{

   public static View3DFactory view3dFactory = new View3DFactory(298, 300, true, SceneAntialiasing.BALANCED, SceneType.SUB_SCENE);

   @Override
   public void start(Stage primaryStage) throws Exception
   {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Application.fxml"));
      BorderPane primaryPane = loader.load();
      Pane modelPane = new Pane();

      primaryPane.setCenter(modelPane);
      modelPane.getChildren().add(ApplicationMain.view3dFactory.getSubScene());

      primaryStage.setTitle(getClass().getSimpleName());
      primaryStage.setScene(new Scene(primaryPane));
      ApplicationMain.view3dFactory.getSubScene().heightProperty().bind(modelPane.heightProperty());
      ApplicationMain.view3dFactory.getSubScene().widthProperty().bind(modelPane.widthProperty());
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