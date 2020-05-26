package us.ihmc.examples;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.AmbientLight;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import us.ihmc.euclid.axisAngle.AxisAngle;
import us.ihmc.euclid.geometry.Pose3D;
import us.ihmc.euclid.shape.primitives.Box3D;
import us.ihmc.euclid.shape.primitives.Capsule3D;
import us.ihmc.euclid.shape.primitives.Cylinder3D;
import us.ihmc.euclid.shape.primitives.Ellipsoid3D;
import us.ihmc.euclid.shape.primitives.Ramp3D;
import us.ihmc.euclid.shape.primitives.Sphere3D;
import us.ihmc.euclid.shape.primitives.Torus3D;
import us.ihmc.graphicsDescription.MeshDataGenerator;
import us.ihmc.graphicsDescription.MeshDataHolder;
import us.ihmc.javaFXToolkit.cameraControllers.FocusBasedCameraMouseEventHandler;
import us.ihmc.javaFXToolkit.graphics.JavaFXMeshDataInterpreter;

public class ApplicationController
{

   @FXML
   public Pane modelPane;

   @FXML
   public TextField xPosition;

   @FXML
   public TextField yPosition;

   @FXML
   public TextField zPosition;

   @FXML
   private Slider heightSlider;

   @FXML
   private Slider widthSlider;

   @FXML
   private Slider lengthSlider;

   @FXML
   private Slider radiusSlider;

   @FXML
   public Button updateButton;

   @FXML
   public Slider yawSlider;

   @FXML
   public Slider pitchSlider;

   @FXML
   public Slider rollSlider;

   @FXML
   public Label heightLabel;

   @FXML
   public Label widthLabel;

   @FXML
   public Label lengthLabel;

   @FXML
   public Label yawLabel;

   @FXML
   public Label pitchLabel;

   @FXML
   public Label rollLabel;

   @FXML
   public Button createSecondObjectButton;

   @FXML
   public Button clear3DSpaceButton;

   @FXML
   public ComboBox<shapes> shapeComboBox = new ComboBox<shapes>(FXCollections.observableArrayList(shapes.values()));

   @FXML
   public ComboBox<colors> colorComboBox = new ComboBox<colors>(FXCollections.observableArrayList(colors.values()));

   public double length;

   public double height;

   public double width;

   public double radius;

   public double yaw;

   public double pitch;

   public double roll;

   public double x;

   public double y;

   public double z;

   public double xRadius;

   public double yRadius;

   public double zRadius;

   public double minorRadius;

   public double startAngle;

   public double endAngle;

   public int N = 100;

   public int S = 100;

   public boolean multipleNodes = false;

   public Color color;

   public Node saveNode;

   public MeshView javaFXSphereNode;

   public MeshView javaFXTorusNode;

   public MeshView javaFXRampNode;

   public MeshView javaFXEllipsoidNode;

   public MeshView javaFXCylinderNode;

   public MeshView javaFXCubeNode;

   public MeshView javaFXCapsuleNode;

   @FXML
   public void makeCapsule()
   {
      setPosition();
      setDimensions();
      setRadius();
      modelCapsule();
   }

   @FXML
   public void makeCube()
   {

      setPosition();
      setDimensions();
      setOrientation();
      radiusSlider.setDisable(true);
      modelCube();
   }

   @FXML
   public void makeCylinder()
   {
      setPosition();
      setDimensions();
      setRadius();
      yawSlider.setDisable(true);
      pitchSlider.setDisable(true);
      rollSlider.setDisable(true);
      modelCylinder();
   }

   @FXML
   public void makeEllipsoid()
   {
      ellipsoidRadiusAccomodation();
      setPosition();
      setDimensions();
      setOrientation();
      modelEllipsoid();
   }

   @FXML
   public void makeRamp()
   {

      setPosition();
      setDimensions();
      setOrientation();
      radiusSlider.setDisable(true);
      modelRamp();
   }

   public void makeSphere()
   {
      setPosition();
      setRadius();
      heightSlider.setDisable(true);
      widthSlider.setDisable(true);
      lengthSlider.setDisable(true);
      modelSphere();
   }

   @FXML
   public void makeTorus()
   {
      setPosition();
      setDimensions();
      setOrientation();
      torusRadiusAccomodation();
      modelTorus();
   }

   public void makeShape()
   {
      shapes currentValue = shapeComboBox.getValue();

      enableAllSliders();
      orientationLabelsReset();

      if (currentValue == shapes.Capsule)
      {
         makeCapsule();
      }
      if (currentValue == shapes.Cube)
      {
         makeCube();
      }
      if (currentValue == shapes.Cylinder)
      {
         makeCylinder();
      }
      if (currentValue == shapes.Ellipsoid)
      {
         makeEllipsoid();
      }
      if (currentValue == shapes.Ramp)
      {
         makeRamp();
      }
      if (currentValue == shapes.Torus)
      {
         makeTorus();
      }
      if (currentValue == shapes.Sphere)
      {
         makeSphere();
      }
   }

   private void shapeListener()
   {
      shapeComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<shapes>()
      {
         @Override
         public void changed(ObservableValue<? extends shapes> observable, shapes oldValue, shapes newValue)
         {
            makeShape();
         }
      });
   }

   private void textFieldListener()
   {
      xPosition.textProperty().addListener(new ChangeListener<String>()
      {
         @Override
         public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
         {
            makeShape();
         }
      });
      yPosition.textProperty().addListener(new ChangeListener<String>()
      {
         @Override
         public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
         {
            makeShape();

         }
      });
      zPosition.textProperty().addListener(new ChangeListener<String>()
      {
         @Override
         public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
         {
            makeShape();

         }
      });
   }

   private void sliderListener()
   {
      radiusSlider.valueProperty().addListener(new ChangeListener<Number>()
      {
         @Override
         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
         {
            makeShape();
         }
      });
      heightSlider.valueProperty().addListener(new ChangeListener<Number>()
      {
         @Override
         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
         {
            makeShape();
         }
      });
      widthSlider.valueProperty().addListener(new ChangeListener<Number>()
      {
         @Override
         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
         {
            makeShape();
         }
      });
      lengthSlider.valueProperty().addListener(new ChangeListener<Number>()
      {
         @Override
         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
         {
            makeShape();
         }
      });
      yawSlider.valueProperty().addListener(new ChangeListener<Number>()
      {
         @Override
         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
         {
            makeShape();
         }
      });
      pitchSlider.valueProperty().addListener(new ChangeListener<Number>()
      {
         @Override
         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
         {
            makeShape();
         }
      });
      rollSlider.valueProperty().addListener(new ChangeListener<Number>()
      {
         @Override
         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
         {
            makeShape();
         }
      });
   }

   private void colorListener()
   {
      colorComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<colors>()
      {
         @Override
         public void changed(ObservableValue<? extends colors> observable, colors oldValue, colors newValue)
         {
            changeColor();
            makeShape();
         }
      });
   }

   public void changeColor()
   {
      colors currentValue = colorComboBox.getValue();
      if (currentValue == colors.Red)
      {
         color = Color.RED;
      }
      if (currentValue == colors.Orange)
      {
         color = Color.ORANGE;
      }
      if (currentValue == colors.Yellow)
      {
         color = Color.YELLOW;
      }
      if (currentValue == colors.Green)
      {
         color = Color.GREEN;
      }
      if (currentValue == colors.Blue)
      {
         color = Color.BLUE;
      }
      if (currentValue == colors.Purple)
      {
         color = Color.PURPLE;
      }
      if (currentValue == colors.Black)
      {
         color = Color.BLACK;
      }
   }

   // INFO RETRIEVAL FUNCTIONS //
   public void setXPosition()
   {
      if (xPosition.getText().contentEquals(""))
      {
         x = 0;
      }
      else
      {
         x = Double.parseDouble(xPosition.getText());
      }
   }

   public void setYPosition()
   {
      if (yPosition.getText().contentEquals(""))
      {
         y = 0;
      }
      else
      {
         y = Double.parseDouble(yPosition.getText());
      }
   }

   public void setZPosition()
   {
      if (zPosition.getText().contentEquals(""))
      {
         z = 0;
      }
      else
      {
         z = Double.parseDouble(zPosition.getText());
      }
   }

   public void setPosition()
   {
      setXPosition();
      setYPosition();
      setZPosition();
   }

   public void setYaw()
   {
      yaw = Math.toRadians(yawSlider.getValue());
   }

   public void setPitch()
   {
      pitch = Math.toRadians(pitchSlider.getValue());
   }

   public void setRoll()
   {
      roll = Math.toRadians(rollSlider.getValue());
   }

   public void setOrientation()
   {
      setYaw();
      setPitch();
      setRoll();
   }

   public void setRadius()
   {
      radius = radiusSlider.getValue();
   }

   public void setHeight()
   {
      height = heightSlider.getValue();
   }

   public void setLength()
   {
      length = lengthSlider.getValue();
   }

   public void setWidth()
   {
      width = widthSlider.getValue();
   }

   public void setDimensions()
   {
      setHeight();
      setLength();
      setWidth();
   }

   public void enableAllSliders()
   {
      radiusSlider.setDisable(false);
      heightSlider.setDisable(false);
      lengthSlider.setDisable(false);
      widthSlider.setDisable(false);
      yawSlider.setDisable(false);
      pitchSlider.setDisable(false);
      rollSlider.setDisable(false);
   }

   @FXML
   public void createSecondObject(ActionEvent event)
   {
      multipleNodes = true;
      saveCurrentNode();
      multipleNodeViewing();
      makeShape();
   }

   public void saveCurrentNode()
   {
      shapes currentValue = shapeComboBox.getValue();

      if (currentValue == shapes.Capsule)
      {
         saveNode = javaFXCapsuleNode;
      }
      if (currentValue == shapes.Cube)
      {
         saveNode = javaFXCubeNode;
      }
      if (currentValue == shapes.Cylinder)
      {
         saveNode = javaFXCylinderNode;
      }
      if (currentValue == shapes.Ellipsoid)
      {
         saveNode = javaFXEllipsoidNode;
      }
      if (currentValue == shapes.Ramp)
      {
         saveNode = javaFXRampNode;
      }
      if (currentValue == shapes.Torus)
      {
         saveNode = javaFXTorusNode;
      }
      if (currentValue == shapes.Sphere)
      {
         saveNode = javaFXSphereNode;
      }
   }

   public void clear3DSpace(ActionEvent event)
   {
      multipleNodes = false;
      makeNewView3DFactory();
      resetSliderValues();
   }

   public void resetSliderValues() {
      heightSlider.adjustValue(0.2);
      widthSlider.adjustValue(0.2);
      lengthSlider.adjustValue(0.2);
      radiusSlider.adjustValue(0.2);
      pitchSlider.adjustValue(0);
      rollSlider.adjustValue(0);
      yawSlider.adjustValue(0);
   }
   
   public enum shapes
   {
      Capsule, Cube, Cylinder, Ellipsoid, Ramp, Sphere, Torus
   }

   public enum colors
   {
      Red, Orange, Yellow, Green, Blue, Purple, Black
   }

   public void setComboBoxOptions()
   {
      shapeComboBox.getItems().addAll(FXCollections.observableArrayList(shapes.values()));
      colorComboBox.getItems().addAll(FXCollections.observableArrayList(colors.values()));
   }

   public void ellipsoidRadiusAccomodation()
   {
      radiusSlider.setDisable(true);
      heightLabel.setText("x Radius");
      widthLabel.setText("y Radius");
      lengthLabel.setText("z Radius");

   }

   public void torusRadiusAccomodation()
   {
      heightLabel.setText("xy Radius");
      widthLabel.setText("z Radius");
      lengthSlider.setDisable(true);
      radiusSlider.setDisable(true);
      yawSlider.setDisable(true);
      pitchSlider.setDisable(true);
      rollSlider.setDisable(true);
   }

   public void orientationLabelsReset()
   {
      heightLabel.setText("Height");
      widthLabel.setText("Width");
      lengthLabel.setText("Length");
      pitchLabel.setText("Pitch");
      yawLabel.setText("Yaw");
      rollLabel.setText("Roll");

   }

   @FXML
   public void initialize()
   {
      setComboBoxOptions();
      shapeListener();
      textFieldListener();
      sliderListener();
      colorListener();
   }

   public void makeNewView3DFactory()
   {
      colorTransparencyTest();
      FocusBasedCameraMouseEventHandler cameraController = ApplicationMain.view3dFactory.addCameraController(0.001, 100.0, true);
      cameraController.setMinLatitude(Double.NEGATIVE_INFINITY);
      cameraController.setMaxLatitude(Double.POSITIVE_INFINITY);
      multipleNodeViewing();
      ApplicationMain.view3dFactory.addWorldCoordinateSystem(0.4); //determines size of axes 
      ApplicationMain.view3dFactory.addNodeToView(new AmbientLight(Color.WHEAT));
      ApplicationMain.view3dFactory.addPointLight(-10.0, 0.0, 1.0, Color.WHEAT);
   }

   public void multipleNodeViewing()
   {
      if (multipleNodes == false)
      {
         ApplicationMain.view3dFactory.getRoot().getChildren().clear();
      }
      else {
      ApplicationMain.view3dFactory.getRoot().getChildren().clear();
      ApplicationMain.view3dFactory.getRoot().getChildren().add(saveNode);
      }
   }

   public void colorTransparencyTest()
   {
      if (color == null)
      {
         color = Color.PINK;
      }
   }

   public void modelSphere()
   {
   
      makeNewView3DFactory();
      Sphere3D sphere3D = new Sphere3D();
      sphere3D.set(x, y, z, radius);
   
      MeshDataHolder mesh = MeshDataGenerator.Sphere(radius, N, S);
      mesh = MeshDataHolder.translate(mesh, sphere3D.getPosition());
   
      TriangleMesh javaFXMesh = JavaFXMeshDataInterpreter.interpretMeshData(mesh);
      javaFXSphereNode = new MeshView(javaFXMesh);
   
      javaFXSphereNode.setMaterial(new PhongMaterial(color));
      ApplicationMain.view3dFactory.addNodeToView(javaFXSphereNode);
   
   }

   public void modelCube()
   {
   
      makeNewView3DFactory();
   
      Box3D box3D = new Box3D();
      Pose3D pose = new Pose3D(x, y, z, yaw, pitch, roll);
      box3D.set(pose, length, width, height);
   
      MeshDataHolder mesh = MeshDataGenerator.Cube(length, width, height, true);
      mesh = MeshDataHolder.rotate(mesh, new AxisAngle(box3D.getOrientation()));
      mesh = MeshDataHolder.translate(mesh, box3D.getPosition());
   
      TriangleMesh javaFXMesh = JavaFXMeshDataInterpreter.interpretMeshData(mesh);
      javaFXCubeNode = new MeshView(javaFXMesh);
   
      javaFXCubeNode.setMaterial(new PhongMaterial(color));
   
      ApplicationMain.view3dFactory.addNodeToView(javaFXCubeNode);
   }

   public void modelRamp()
   {
   
      makeNewView3DFactory();
   
      Ramp3D ramp3D = new Ramp3D();
      Pose3D pose = new Pose3D(x, y, z, yaw, pitch, roll);
      ramp3D.set(pose, length, width, height);
   
      MeshDataHolder mesh = MeshDataGenerator.Wedge(length, width, height);
      mesh = MeshDataHolder.rotate(mesh, new AxisAngle(ramp3D.getOrientation()));
      mesh = MeshDataHolder.translate(mesh, ramp3D.getPosition());
   
      TriangleMesh javaFXMesh = JavaFXMeshDataInterpreter.interpretMeshData(mesh);
      javaFXRampNode = new MeshView(javaFXMesh);
   
      javaFXRampNode.setMaterial(new PhongMaterial(color));
   
      ApplicationMain.view3dFactory.addNodeToView(javaFXRampNode);
   }

   public void modelCapsule()
   {
   
      makeNewView3DFactory();
   
      Capsule3D capsule3D = new Capsule3D();
   
      capsule3D.getPosition().setX(x);
      capsule3D.getPosition().setY(y);
      capsule3D.getPosition().setZ(z);
      capsule3D.set(capsule3D.getPosition(), capsule3D.getAxis(), length, radius);
   
      MeshDataHolder mesh = MeshDataGenerator.Capsule(height, width, length, radius, 100, 100);
      mesh = MeshDataHolder.translate(mesh, capsule3D.getPosition());
   
      TriangleMesh javaFXMesh = JavaFXMeshDataInterpreter.interpretMeshData(mesh);
      javaFXCapsuleNode = new MeshView(javaFXMesh);
   
      javaFXCapsuleNode.setMaterial(new PhongMaterial(color));
   
      ApplicationMain.view3dFactory.addNodeToView(javaFXCapsuleNode);
   }

   public void modelCylinder()
   {
   
      makeNewView3DFactory();
   
      Cylinder3D cylinder3D = new Cylinder3D();
      cylinder3D.set(cylinder3D.getPosition(), cylinder3D.getAxis(), height, radius);
      
      cylinder3D.getPosition().setX(x);
      cylinder3D.getPosition().setY(y);
      cylinder3D.getPosition().setZ(z);
   
      MeshDataHolder mesh = MeshDataGenerator.Cylinder(radius, height, N);
      mesh = MeshDataHolder.translate(mesh, cylinder3D.getPosition());
   
      TriangleMesh javaFXMesh = JavaFXMeshDataInterpreter.interpretMeshData(mesh);
      javaFXCylinderNode = new MeshView(javaFXMesh);
   
      javaFXCylinderNode.setMaterial(new PhongMaterial(color));
   
      ApplicationMain.view3dFactory.addNodeToView(javaFXCylinderNode);
   
   }

   public void modelEllipsoid()
   {
   
      makeNewView3DFactory();
   
      Ellipsoid3D ellipsoid3D = new Ellipsoid3D();
   
      Pose3D pose = new Pose3D(x, y, z, yaw, pitch, roll);
      ellipsoid3D.set(pose, height, width, length);
   
      MeshDataHolder mesh = MeshDataGenerator.Ellipsoid(height, width, length, 100, 100);
      mesh = MeshDataHolder.translate(mesh, ellipsoid3D.getPosition());
      mesh = MeshDataHolder.rotate(mesh, new AxisAngle(ellipsoid3D.getOrientation()));
   
      TriangleMesh javaFXMesh = JavaFXMeshDataInterpreter.interpretMeshData(mesh);
      javaFXEllipsoidNode = new MeshView(javaFXMesh);
   
      javaFXEllipsoidNode.setMaterial(new PhongMaterial(color));
   
      ApplicationMain.view3dFactory.addNodeToView(javaFXEllipsoidNode);
   
   }

   public void modelTorus()
   {
   
      makeNewView3DFactory();
      Torus3D torus3D = new Torus3D();
   
      //height -> radius
      //width -> minorRadius
   
      torus3D.getPosition().setX(x);
      torus3D.getPosition().setY(y);
      torus3D.getPosition().setZ(z);
   
      torus3D.set(torus3D.getPosition(), torus3D.getAxis(), height, width);
   
      MeshDataHolder mesh = MeshDataGenerator.ArcTorus(0, 360, height, width, 600);
      mesh = MeshDataHolder.translate(mesh, torus3D.getPosition());
   
      TriangleMesh javaFXMesh = JavaFXMeshDataInterpreter.interpretMeshData(mesh);
      javaFXTorusNode = new MeshView(javaFXMesh);
   
      javaFXTorusNode.setMaterial(new PhongMaterial(color));
   
      ApplicationMain.view3dFactory.addNodeToView(javaFXTorusNode);
   }
}
