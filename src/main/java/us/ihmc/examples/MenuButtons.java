package us.ihmc.examples;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class MenuButtons {
	
	MenuItem sphere = new MenuItem();
	MenuItem ellipsoid = new MenuItem();
	MenuItem cube = new MenuItem();
	MenuItem torus = new MenuItem();
	MenuItem ramp = new MenuItem();
	MenuItem cylinder = new MenuItem();
	MenuItem capsule = new MenuItem();
	MenuItem red = new MenuItem();
	MenuItem orange = new MenuItem();
	MenuItem yellow = new MenuItem();
	MenuItem green = new MenuItem();
	MenuItem blue = new MenuItem();
	MenuItem purple = new MenuItem();
	MenuItem black = new MenuItem();
	
	MenuButton shapeMenuButton = new MenuButton("Shape" , null, sphere, ellipsoid, cube, torus, ramp,
			cylinder, capsule);
	
	MenuButton colorMenuButton = new MenuButton("Color", null, red, orange, yellow, green, blue, purple, black);
	
	
	
	
	
	
}
