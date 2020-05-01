package us.ihmc.examples;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.AmbientLight;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.stage.Stage;
import us.ihmc.euclid.shape.primitives.Sphere3D;
import us.ihmc.graphicsDescription.MeshDataGenerator;
import us.ihmc.graphicsDescription.MeshDataHolder;
import us.ihmc.javaFXToolkit.cameraControllers.FocusBasedCameraMouseEventHandler;
import us.ihmc.javaFXToolkit.graphics.JavaFXMeshDataInterpreter;
import us.ihmc.javaFXToolkit.scenes.View3DFactory;

public class Sphere3DExample extends Application
{
   @Override
   public void start(Stage primaryStage) throws Exception
   {
      View3DFactory view3dFactory = new View3DFactory(600, 400);
      FocusBasedCameraMouseEventHandler cameraController = view3dFactory.addCameraController(0.001, 100.0, true);
      cameraController.setMinLatitude(Double.NEGATIVE_INFINITY);
      cameraController.setMaxLatitude(Double.POSITIVE_INFINITY);
      view3dFactory.addWorldCoordinateSystem(0.4); //determines size of axes 
      view3dFactory.addNodeToView(new AmbientLight(Color.BLUE));
      view3dFactory.addPointLight(-10.0, 0.0, 1.0, Color.WHEAT);

      Sphere3D sphere3D = new Sphere3D();
      sphere3D.setToZero();
      double centerx = 0;
      double centery = 0;
      double centerz = 0; 
      double radius = .1; 
      int nLatitude = 100; // These latitudes seem to affect the number of triangles used in the mesh
      //the higher this number the rounder the sphere becomes
      int sLatitude = 100;
      sphere3D.set(centerx,centery,centerz,radius);
      sphere3D.getPose(); //sets pose to null
      
      MeshDataHolder mesh = MeshDataGenerator.Sphere(radius, nLatitude, sLatitude);
      mesh = MeshDataHolder.translate(mesh, sphere3D.getPosition());
      
      TriangleMesh javaFXMesh = JavaFXMeshDataInterpreter.interpretMeshData(mesh);
      MeshView javaFXSphereNode = new MeshView(javaFXMesh);
      Color color = Color.PINK;
      javaFXSphereNode.setMaterial(new PhongMaterial(color)); // Give some color to the box
      view3dFactory.addNodeToView(javaFXSphereNode);
      
     
      primaryStage.setTitle(getClass().getSimpleName());
      primaryStage.setMaximized(true);
      primaryStage.setScene(view3dFactory.getScene());
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