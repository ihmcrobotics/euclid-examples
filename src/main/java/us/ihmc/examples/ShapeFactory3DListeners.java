package us.ihmc.examples;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import us.ihmc.examples.ApplicationController.Colors;
import us.ihmc.examples.ApplicationController.Shapes;

public class ShapeFactory3DListeners
{
   FXMLLoader loader = new FXMLLoader(getClass().getResource("Application.fxml"));
   ApplicationController applicationController = loader.getController();

   
  
   //@applicationController
   public void shapeListener()
   {
      System.out.println("aldsfj");
      applicationController.shapeComboBox.valueProperty().addListener(new ChangeListener<Shapes>()
      {
         //@Override
         public void changed(ObservableValue<? extends Shapes> observable, Shapes oldValue, Shapes newValue)
         {
            //method, used to be makeShape
              System.out.println("asfjlds");
         }

      });
   }

   public void colorListener()
   {
      applicationController.colorComboBox.valueProperty().addListener(new ChangeListener<Colors>()
      {

         @Override
         public void changed(ObservableValue<? extends Colors> observable, Colors oldValue, Colors newValue)
         {
            //method, used to be makeShape

         }

      });
   }

   public void textFieldListener()
   {
      applicationController.xPosition.textProperty().addListener(new ChangeListener<String>()
      {

         @Override
         public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
         {
            // TODO Auto-generated method stub

         }
      });

      applicationController.yPosition.textProperty().addListener(new ChangeListener<String>()
      {

         @Override
         public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
         {
            // TODO Auto-generated method stub

         }
      });

      applicationController.zPosition.textProperty().addListener(new ChangeListener<String>()
      {

         @Override
         public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
         {
            // TODO Auto-generated method stub

         }
      });
   }

   public void sliderListener()
   {
      applicationController.yawSlider.valueProperty().addListener(new ChangeListener<Number>()
      {

         @Override
         public void changed(ObservableValue<? extends Number> observable, Number newValue, Number oldValue)
         {
            // TODO Auto-generated method stub

         }

      });
      
      applicationController.pitchSlider.valueProperty().addListener(new ChangeListener<Number>()
      {

         @Override
         public void changed(ObservableValue<? extends Number> observable, Number newValue, Number oldValue)
         {
            // TODO Auto-generated method stub

         }

      });
      
      applicationController.rollSlider.valueProperty().addListener(new ChangeListener<Number>()
      {

         @Override
         public void changed(ObservableValue<? extends Number> observable, Number newValue, Number oldValue)
         {
            // TODO Auto-generated method stub

         }

      });
      
      applicationController.radiusSlider.valueProperty().addListener(new ChangeListener<Number>()
      {

         @Override
         public void changed(ObservableValue<? extends Number> observable, Number newValue, Number oldValue)
         {
            // TODO Auto-generated method stub

         }

      });
      
      applicationController.heightSlider.valueProperty().addListener(new ChangeListener<Number>()
      {

         @Override
         public void changed(ObservableValue<? extends Number> observable, Number newValue, Number oldValue)
         {
            // TODO Auto-generated method stub

         }

      });
      
      applicationController.widthSlider.valueProperty().addListener(new ChangeListener<Number>()
      {

         @Override
         public void changed(ObservableValue<? extends Number> observable, Number newValue, Number oldValue)
         {
            // TODO Auto-generated method stub

         }

      });
      
      applicationController.lengthSlider.valueProperty().addListener(new ChangeListener<Number>()
      {

         @Override
         public void changed(ObservableValue<? extends Number> observable, Number newValue, Number oldValue)
         {
            // TODO Auto-generated method stub

         }

      });
   }
}
