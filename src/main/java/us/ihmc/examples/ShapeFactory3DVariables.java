package us.ihmc.examples;

import javafx.fxml.FXMLLoader;

public class ShapeFactory3DVariables
{
   FXMLLoader loader = new FXMLLoader(getClass().getResource("Application.fxml"));
   ApplicationController applicationController = loader.getController();

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

   public void setXPosition()
   {

      if (applicationController.xPosition.getText().contentEquals(""))
      {
         x = 0;
      }
      else
      {
         x = Double.parseDouble(applicationController.xPosition.getText());
      }
   }

   public void setYPosition()
   {
      if (applicationController.yPosition.getText().contentEquals(""))
      {
         y = 0;
      }
      else
      {
         y = Double.parseDouble(applicationController.yPosition.getText());
      }
   }

   public void setZPosition()
   {
      if (applicationController.zPosition.getText().contentEquals(""))
      {
         z = 0;
      }
      else
      {
         z = Double.parseDouble(applicationController.zPosition.getText());
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
      yaw = Math.toRadians(applicationController.yawSlider.getValue());
   }

   public void setPitch()
   {
      pitch = Math.toRadians(applicationController.pitchSlider.getValue());
   }

   public void setRoll()
   {
      roll = Math.toRadians(applicationController.rollSlider.getValue());
   }

   public void setOrientation()
   {
      setYaw();
      setPitch();
      setRoll();
   }

   public void setRadius()
   {
      radius = applicationController.radiusSlider.getValue();
   }

   public void setHeight()
   {
      height = applicationController.heightSlider.getValue();
   }

   public void setLength()
   {
      length = applicationController.lengthSlider.getValue();
   }

   public void setWidth()
   {
      width = applicationController.widthSlider.getValue();
   }

   public void setDimensions()
   {
      //getParameters(.)
      //applicationController.pitchSlider
      setHeight();
      setLength();
      setWidth();
   }

   //shapeComboBox = new ComboBox<Shapes>(FXCollections.observableArrayList(Shapes.values()));

}
