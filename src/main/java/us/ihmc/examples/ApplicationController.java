package us.ihmc.examples;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ApplicationController
{

   ShapeFactory3DListeners listeners = new ShapeFactory3DListeners();

   @FXML
   private Pane modelPane;

   @FXML
   public TextField xPosition;

   @FXML
   public TextField yPosition;

   @FXML
   public TextField zPosition;

   @FXML
   public Slider heightSlider;

   @FXML
   public Slider widthSlider;

   @FXML
   public Slider lengthSlider;

   @FXML
   public Slider radiusSlider;

   @FXML
   private Button updateButton;

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
   private Button createSecondObjectButton;

   @FXML
   private Button clear3DSpaceButton;

   @FXML
   public ComboBox<Shapes> shapeComboBox = new ComboBox<Shapes>(FXCollections.observableArrayList(Shapes.values()));

   @FXML
   public ComboBox<Colors> colorComboBox = new ComboBox<Colors>(FXCollections.observableArrayList(Colors.values()));

   public enum Shapes
   {
      CAPSULE, CUBE, CYLINDER, ELLIPSOID, RAMP, SPHERE, TORUS
   }

   public enum Colors
   {
      RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE, BLACK
   }

   @FXML
   public void createSecondObject(ActionEvent event)
   {
      //      multipleNodes = true;
      //      saveCurrentNode();
      //      multipleNodeViewing();
      //      makeShape();
   }

   public void clear3DSpace(ActionEvent event)
   {
      //      multipleNodes = false;
      //      makeNewView3DFactory();
      //resetSliderValues();
   }

   //   @FXML
   //   public void makeCapsule()
   //   {
   //      setPosition();
   //      setDimensions();
   //      setRadius();
   //      modelCapsule();
   //   }
   //
   //   @FXML
   //   public void makeCube()
   //   {
   //
   //      setPosition();
   //      setDimensions();
   //      setOrientation();
   //      radiusSlider.setDisable(true);
   //      modelCube();
   //   }
   //
   //   @FXML
   //   public void makeCylinder()
   //   {
   //      setPosition();
   //      setDimensions();
   //      setRadius();
   //      yawSlider.setDisable(true);
   //      pitchSlider.setDisable(true);
   //      rollSlider.setDisable(true);
   //      modelCylinder();
   //   }
   //
   //   @FXML
   //   public void makeEllipsoid()
   //   {
   //      ellipsoidRadiusAccomodation();
   //      setPosition();
   //      setDimensions();
   //      setOrientation();
   //      modelEllipsoid();
   //   }
   //
   //   @FXML
   //   public void makeRamp()
   //   {
   //
   //      setPosition();
   //      setDimensions();
   //      setOrientation();
   //      radiusSlider.setDisable(true);
   //      modelRamp();
   //   }
   //
   //   public void makeSphere()
   //   {
   //      setPosition();
   //      setRadius();
   //      heightSlider.setDisable(true);
   //      widthSlider.setDisable(true);
   //      lengthSlider.setDisable(true);
   //      modelSphere();
   //   }
   //
   //   @FXML
   //   public void makeTorus()
   //   {
   //      setPosition();
   //      setDimensions();
   //      setOrientation();
   //      torusRadiusAccomodation();
   //      modelTorus();
   //   }
   //
   //   public void makeShape()
   //   {
   //      shapes currentValue = shapeComboBox.getValue();
   //
   //      enableAllSliders();
   //      orientationLabelsReset();
   //
   //      if (currentValue == shapes.Capsule)
   //      {
   //         makeCapsule();
   //      }
   //      if (currentValue == shapes.Cube)
   //      {
   //         makeCube();
   //      }
   //      if (currentValue == shapes.Cylinder)
   //      {
   //         makeCylinder();
   //      }
   //      if (currentValue == shapes.Ellipsoid)
   //      {
   //         makeEllipsoid();
   //      }
   //      if (currentValue == shapes.Ramp)
   //      {
   //         makeRamp();
   //      }
   //      if (currentValue == shapes.Torus)
   //      {
   //         makeTorus();
   //      }
   //      if (currentValue == shapes.Sphere)
   //      {
   //         makeSphere();
   //      }
   //   }
   //
   //   private void shapeListener()
   //   {
   //      shapeComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<shapes>()
   //      {
   //         @Override
   //         public void changed(ObservableValue<? extends shapes> observable, shapes oldValue, shapes newValue)
   //         {
   //            makeShape();
   //         }
   //      });
   //   }
   //
   //   private void textFieldListener()
   //   {
   //      xPosition.textProperty().addListener(new ChangeListener<String>()
   //      {
   //         @Override
   //         public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
   //         {
   //            makeShape();
   //         }
   //      });
   //      yPosition.textProperty().addListener(new ChangeListener<String>()
   //      {
   //         @Override
   //         public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
   //         {
   //            makeShape();
   //
   //         }
   //      });
   //      zPosition.textProperty().addListener(new ChangeListener<String>()
   //      {
   //         @Override
   //         public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
   //         {
   //            makeShape();
   //
   //         }
   //      });
   //   }
   //
   //   private void sliderListener()
   //   {
   //      radiusSlider.valueProperty().addListener(new ChangeListener<Number>()
   //      {
   //         @Override
   //         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
   //         {
   //            makeShape();
   //         }
   //      });
   //      heightSlider.valueProperty().addListener(new ChangeListener<Number>()
   //      {
   //         @Override
   //         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
   //         {
   //            makeShape();
   //         }
   //      });
   //      widthSlider.valueProperty().addListener(new ChangeListener<Number>()
   //      {
   //         @Override
   //         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
   //         {
   //            makeShape();
   //         }
   //      });
   //      lengthSlider.valueProperty().addListener(new ChangeListener<Number>()
   //      {
   //         @Override
   //         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
   //         {
   //            makeShape();
   //         }
   //      });
   //      yawSlider.valueProperty().addListener(new ChangeListener<Number>()
   //      {
   //         @Override
   //         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
   //         {
   //            makeShape();
   //         }
   //      });
   //      pitchSlider.valueProperty().addListener(new ChangeListener<Number>()
   //      {
   //         @Override
   //         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
   //         {
   //            makeShape();
   //         }
   //      });
   //      rollSlider.valueProperty().addListener(new ChangeListener<Number>()
   //      {
   //         @Override
   //         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
   //         {
   //            makeShape();
   //         }
   //      });
   //   }
   //
   //   private void colorListener()
   //   {
   //      colorComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<colors>()
   //      {
   //         @Override
   //         public void changed(ObservableValue<? extends colors> observable, colors oldValue, colors newValue)
   //         {
   //            changeColor();
   //            makeShape();
   //         }
   //      });
   //   }
   //
   //   public void changeColor()
   //   {
   //      colors currentValue = colorComboBox.getValue();
   //      if (currentValue == colors.Red)
   //      {
   //         color = Color.RED;
   //      }
   //      if (currentValue == colors.Orange)
   //      {
   //         color = Color.ORANGE;
   //      }
   //      if (currentValue == colors.Yellow)
   //      {
   //         color = Color.YELLOW;
   //      }
   //      if (currentValue == colors.Green)
   //      {
   //         color = Color.GREEN;
   //      }
   //      if (currentValue == colors.Blue)
   //      {
   //         color = Color.BLUE;
   //      }
   //      if (currentValue == colors.Purple)
   //      {
   //         color = Color.PURPLE;
   //      }
   //      if (currentValue == colors.Black)
   //      {
   //         color = Color.BLACK;
   //      }
   //   }

   // INFO RETRIEVAL FUNCTIONS //
   //   public void setXPosition()
   //   {
   //      if (xPosition.getText().contentEquals(""))
   //      {
   //         x = 0;
   //      }
   //      else
   //      {
   //         x = Double.parseDouble(xPosition.getText());
   //      }
   //   }
   //
   //   public void setYPosition()
   //   {
   //      if (yPosition.getText().contentEquals(""))
   //      {
   //         y = 0;
   //      }
   //      else
   //      {
   //         y = Double.parseDouble(yPosition.getText());
   //      }
   //   }
   //
   //   public void setZPosition()
   //   {
   //      if (zPosition.getText().contentEquals(""))
   //      {
   //         z = 0;
   //      }
   //      else
   //      {
   //         z = Double.parseDouble(zPosition.getText());
   //      }
   //   }
   //
   //   public void setPosition()
   //   {
   //      setXPosition();
   //      setYPosition();
   //      setZPosition();
   //   }
   //
   //   public void setYaw()
   //   {
   //      yaw = Math.toRadians(yawSlider.getValue());
   //   }
   //
   //   public void setPitch()
   //   {
   //      pitch = Math.toRadians(pitchSlider.getValue());
   //   }
   //
   //   public void setRoll()
   //   {
   //      roll = Math.toRadians(rollSlider.getValue());
   //   }
   //
   //   public void setOrientation()
   //   {
   //      setYaw();
   //      setPitch();
   //      setRoll();
   //   }
   //
   //   public void setRadius()
   //   {
   //      radius = radiusSlider.getValue();
   //   }
   //
   //   public void setHeight()
   //   {
   //      height = heightSlider.getValue();
   //   }
   //
   //   public void setLength()
   //   {
   //      length = lengthSlider.getValue();
   //   }
   //
   //   public void setWidth()
   //   {
   //      width = widthSlider.getValue();
   //   }
   //
   //   public void setDimensions()
   //   {
   //      setHeight();
   //      setLength();
   //      setWidth();
   //   }
   //
   //   public void enableAllSliders()
   //   {
   //      radiusSlider.setDisable(false);
   //      heightSlider.setDisable(false);
   //      lengthSlider.setDisable(false);
   //      widthSlider.setDisable(false);
   //      yawSlider.setDisable(false);
   //      pitchSlider.setDisable(false);
   //      rollSlider.setDisable(false);
   //   }

   //   @FXML
   //   public void createSecondObject(ActionEvent event)
   //   {
   ////      multipleNodes = true;
   ////      saveCurrentNode();
   ////      multipleNodeViewing();
   ////      makeShape();
   //   }

   //   public void saveCurrentNode()
   //   {
   //      shapes currentValue = shapeComboBox.getValue();
   //
   //      if (currentValue == shapes.Capsule)
   //      {
   //         saveNode = javaFXCapsuleNode;
   //      }
   //      if (currentValue == shapes.Cube)
   //      {
   //         saveNode = javaFXCubeNode;
   //      }
   //      if (currentValue == shapes.Cylinder)
   //      {
   //         saveNode = javaFXCylinderNode;
   //      }
   //      if (currentValue == shapes.Ellipsoid)
   //      {
   //         saveNode = javaFXEllipsoidNode;
   //      }
   //      if (currentValue == shapes.Ramp)
   //      {
   //         saveNode = javaFXRampNode;
   //      }
   //      if (currentValue == shapes.Torus)
   //      {
   //         saveNode = javaFXTorusNode;
   //      }
   //      if (currentValue == shapes.Sphere)
   //      {
   //         saveNode = javaFXSphereNode;
   //      }
   //   }

   //   public void clear3DSpace(ActionEvent event)
   //   {
   //      multipleNodes = false;
   //      makeNewView3DFactory();
   //      resetSliderValues();
   //   }

   //   public void resetSliderValues() {
   //      heightSlider.adjustValue(0.2);
   //      widthSlider.adjustValue(0.2);
   //      lengthSlider.adjustValue(0.2);
   //      radiusSlider.adjustValue(0.2);
   //      pitchSlider.adjustValue(0);
   //      rollSlider.adjustValue(0);
   //      yawSlider.adjustValue(0);
   //   }

   //look at type naming conventions. Capital letters! Static! add underscores where necessary
   // THIS_IS_A_CONSTANT ie CAPSULE, CUBE, ETC

   public void setComboBoxOptions()
   {
      shapeComboBox.getItems().addAll(FXCollections.observableArrayList(Shapes.values()));
      colorComboBox.getItems().addAll(FXCollections.observableArrayList(Colors.values()));
   }
   //
   //   public void ellipsoidRadiusAccomodation()
   //   {
   //      radiusSlider.setDisable(true);
   //      heightLabel.setText("x Radius");
   //      widthLabel.setText("y Radius");
   //      lengthLabel.setText("z Radius");
   //
   //   }
   //
   //   public void torusRadiusAccomodation()
   //   {
   //      heightLabel.setText("xy Radius");
   //      widthLabel.setText("z Radius");
   //      lengthSlider.setDisable(true);
   //      radiusSlider.setDisable(true);
   //      yawSlider.setDisable(true);
   //      pitchSlider.setDisable(true);
   //      rollSlider.setDisable(true);
   //   }
   //
   //   public void orientationLabelsReset()
   //   {
   //      heightLabel.setText("Height");
   //      widthLabel.setText("Width");
   //      lengthLabel.setText("Length");
   //      pitchLabel.setText("Pitch");
   //      yawLabel.setText("Yaw");
   //      rollLabel.setText("Roll");
   //
   //   }

   @FXML
   public void initialize()
   {
      setComboBoxOptions();
          listeners.shapeListener();
      //    listeners.textFieldListener();
      //    listeners.sliderListener();
      //    listeners.colorListener();

   }
}
