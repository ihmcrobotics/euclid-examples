package us.ihmc.examples;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ApplicationController extends Shape3DBasics {
	
	
	 @FXML
	 public Pane modelPane;
	 
	 @FXML
	 public MenuButton shapeMenuButton;
	 
	 @FXML
	 public MenuButton colorMenuButton;
	 
	 @FXML
	 private MenuItem capsule;

	 @FXML
     private MenuItem cube;

     @FXML
     private MenuItem cylinder;

     @FXML
	 private MenuItem ellipsoid;

	 @FXML
	 private MenuItem ramp;

	 @FXML
	 private MenuItem sphere;

	 @FXML
	 private MenuItem torus;

	 @FXML
	 public  TextField xPosition;
	 
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
	 public MenuItem red;
	 
	 @FXML
	 public MenuItem orange;
	 
	 @FXML
	 public MenuItem yellow;
	 
	 @FXML 
	 public MenuItem green;
	 
	 @FXML
	 public MenuItem blue;
	 
	 @FXML
	 public MenuItem purple;
	 
	 @FXML
	 public MenuItem black;
	 
	 
	@FXML 
 	public void makeCapsule(ActionEvent event) {
		 resetSliders();
		 shapeMenuButton.setText("Capsule");
		 setPosition();
		 setDimensions();
		 setRadius();
		 makeCapsule();
	}
	 
	@FXML 
	public void makeCube(ActionEvent event) {
		resetSliders();
		shapeMenuButton.setText("Cube");
		setPosition();
		setDimensions();
		setOrientation();
		radiusSlider.setDisable(true);
		makeCube();
	}
	
	@FXML 
	public void makeCylinder(ActionEvent event) {
		resetSliders();
		shapeMenuButton.setText("Cylinder");
		setPosition();
		setDimensions();
		setRadius();
		yawSlider.setDisable(true);
		pitchSlider.setDisable(true);
		rollSlider.setDisable(true);
		makeCylinder();
	}
	
	@FXML 
	public void makeEllipsoid(ActionEvent event) {
		resetSliders();
		shapeMenuButton.setText("Ellipsoid");
		radiusSlider.setDisable(true);
		setPosition();
		setDimensions();
		setOrientation();
		makeEllipsoid();
	}
	
	@FXML 
	public void makeRamp(ActionEvent event) {
		resetSliders();
		shapeMenuButton.setText("Ramp");
		setPosition();
		setDimensions();
		setOrientation();
		radiusSlider.setDisable(true);
		makeRamp();
	}
	
	@FXML 
	public void makeSphere(ActionEvent event) {
		resetSliders();
		shapeMenuButton.setText("Sphere");
		setPosition();
		setRadius();
		heightSlider.setDisable(true);
		widthSlider.setDisable(true);
		lengthSlider.setDisable(true);
		makeSphere();
	}
	
	@FXML 
	public void makeTorus(ActionEvent event) {
		resetSliders();
		shapeMenuButton.setText("Torus");
		setRadius();
		setPosition();
		makeTorus();
		yawSlider.setDisable(true);
		pitchSlider.setDisable(true);
		rollSlider.setDisable(true);
	}
	
	@FXML
    public void orange(ActionEvent event) {
		color = Color.ORANGE; 
		colorMenuButton.setText("Orange");
    }

    @FXML
    public void purple(ActionEvent event) {
    	color = Color.PURPLE;
    	colorMenuButton.setText("Purple");
    }

    @FXML
    public void red(ActionEvent event) {
    	color = Color.DARKRED;
    	colorMenuButton.setText("Red");
    }

    @FXML
    public void yellow(ActionEvent event) {
    	color = Color.YELLOW;
    	colorMenuButton.setText("Yellow");
    }

    @FXML
    public void green(ActionEvent event) {
    	color = Color.DARKGREEN;
    	colorMenuButton.setText("Green");
    }
    
    @FXML 
    public void blue(ActionEvent event) {
    	color = Color.BLUE;
    	colorMenuButton.setText("Blue");
    }
    
    @FXML
    public void black(ActionEvent event) {
    	color = Color.BLACK;
    	colorMenuButton.setText("Black");
    }

	public void update(ActionEvent event) {
		//
	}
    
	
	
	
	
	
	// INFO RETRIEVAL FUNCTIONS //
	
	
	
	
	public void getXPosition() {
		Double.parseDouble(xPosition.getText());
	}
	
	public void getYPosition() {
		Double.parseDouble(yPosition.getText());
	}
	
	public void getZPosition() {
		Double.parseDouble(zPosition.getText());
	}
	
	public void getPosition() {
		getXPosition();
		getYPosition();
		getZPosition();
	}
	
	public void setXPosition() {
		if (xPosition.getText().contentEquals("")) {
		x = 0;
		}
		else {
		x = Double.parseDouble(xPosition.getText());
		}
	}
	
	public void setYPosition() {
		if (yPosition.getText().contentEquals("")) {
		y = 0;
		}
		else {
		y = Double.parseDouble(yPosition.getText());
		}
	}
	
	public void setZPosition() {
		if (zPosition.getText().contentEquals("")) {
		z = 0 ;
		}
		else {
			z = Double.parseDouble(zPosition.getText());
		}
	}
		
	public void setPosition() {
		setXPosition();
		setYPosition();
		setZPosition();	}

	public void getYaw() {
		yawSlider.getValue();
	}
	
	public void getPitch() {
		pitchSlider.getValue();
	}
	
	public void getRoll() {
		rollSlider.getValue();
	}
	
	public void setYaw() {
		yaw = Math.toRadians(yawSlider.getValue());
	}
	
	public void setPitch() {
		pitch = Math.toRadians(pitchSlider.getValue());
	}
	
	public void setRoll() {
		roll = Math.toRadians(rollSlider.getValue());
	}
	
	public void setOrientation() {
		setYaw();
		setPitch();
		setRoll();
	}
	
	public void getRadius() {
		radiusSlider.getValue();
	}
	
	public void setRadius() {
		radius = radiusSlider.getValue();
	}
	
	public void getHeight() {
		heightSlider.getValue();
	}
	
	public void getLength() {
		lengthSlider.getValue();
	}
	
	public void getWidth() {
		widthSlider.getValue();
	}
	
	public void setHeight() {
		height = heightSlider.getValue();
	}
	
	public void setLength() {
		length = lengthSlider.getValue();
	}
	
	public void setWidth() {
		width = widthSlider.getValue();
	}
		
	public void setDimensions() {
			setHeight();
			setLength();
			setWidth();
	}

	
	
	
	
	
	
	public void resetSliders() {
		radiusSlider.setDisable(false);
		heightSlider.setDisable(false);
		lengthSlider.setDisable(false);
		widthSlider.setDisable(false);
		yawSlider.setDisable(false);
		pitchSlider.setDisable(false);
		rollSlider.setDisable(false);
	}
	
	@FXML
	public void initialize() {
	
		 
	}
}
