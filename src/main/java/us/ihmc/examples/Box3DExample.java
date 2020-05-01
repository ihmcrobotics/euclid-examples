package us.ihmc.examples;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.AmbientLight;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.stage.Stage;
import us.ihmc.euclid.axisAngle.AxisAngle;
import us.ihmc.euclid.geometry.Pose3D;
import us.ihmc.euclid.shape.primitives.Box3D;
import us.ihmc.graphicsDescription.MeshDataGenerator;
import us.ihmc.graphicsDescription.MeshDataHolder;
import us.ihmc.javaFXToolkit.cameraControllers.FocusBasedCameraMouseEventHandler;
import us.ihmc.javaFXToolkit.graphics.JavaFXMeshDataInterpreter;
import us.ihmc.javaFXToolkit.scenes.View3DFactory;

public class Box3DExample extends Application
{
   @Override
   public void start(Stage primaryStage) throws Exception
   {
      View3DFactory view3dFactory = new View3DFactory(600, 400);
      FocusBasedCameraMouseEventHandler cameraController = view3dFactory.addCameraController(0.001, 100.0, true);
      cameraController.setMinLatitude(Double.NEGATIVE_INFINITY);
      cameraController.setMaxLatitude(Double.POSITIVE_INFINITY);
      view3dFactory.addWorldCoordinateSystem(0.1);
      view3dFactory.addNodeToView(new AmbientLight(Color.GRAY));
      view3dFactory.addPointLight(-10.0, 0.0, -1.0, Color.WHEAT);

      // 1- We create a Euclid Box3D
      // This is the position and orientation of the box, in order: position (x, y, z) orientation (yaw, pitch, roll)
      double x = 0.1;
      double y = 0.2;
      double z = 0.3;
      double yaw = Math.PI / 4.0;
      double pitch = Math.toRadians(50.0);
      double roll = Math.toRadians(25.0);
      Pose3D pose = new Pose3D(x, y, z, yaw, pitch, roll);
      double sizeX = 0.25;
      double sizeY = 0.50;
      double sizeZ = 0.75;
      Box3D box3D = new Box3D(pose, sizeX, sizeY, sizeZ);
      // 2- We generate the triangle mesh that can be rendered by JavaFX.
      MeshDataHolder mesh = MeshDataGenerator.Cube(sizeX, sizeY, sizeZ, true); // boolean is to generate the mesh such that the box is centered at its centroid.
      mesh = MeshDataHolder.rotate(mesh, new AxisAngle(box3D.getOrientation()));
      mesh = MeshDataHolder.translate(mesh, box3D.getPosition());
      // The mesh up to now is generic, i.e. it is still not consumable by JavaFX for rendering.
      // We use a converter "JavaFXMeshDataInterpreter" that can translate the mesh into something JavaFX can consume.
      TriangleMesh javaFXMesh = JavaFXMeshDataInterpreter.interpretMeshData(mesh);
      // 3- We create a JavaFX node that can be attached to the scene. A MeshView can be used to visualize a mesh.
      MeshView javaFXBoxNode = new MeshView(javaFXMesh);
      Color color = Color.CORNFLOWERBLUE;
      javaFXBoxNode.setMaterial(new PhongMaterial(color)); // Give some color to the box
      view3dFactory.addNodeToView(javaFXBoxNode); // Attach the node to the scene so we can see it.

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