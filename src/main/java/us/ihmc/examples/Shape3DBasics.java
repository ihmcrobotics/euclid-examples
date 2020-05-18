package us.ihmc.examples;

import javafx.scene.AmbientLight;
import javafx.scene.SceneAntialiasing;
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
import us.ihmc.javaFXToolkit.scenes.View3DFactory;
import us.ihmc.javaFXToolkit.scenes.View3DFactory.SceneType;

public class Shape3DBasics {
	
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
    public double tubeRadius;
    public double startAngle;
    public double endAngle;
	public int N = 100;
	public int S = 100;
	public boolean multipleNodes = false;
	public Color color;
	
	
	public static View3DFactory view3dFactory = 
			new View3DFactory(298, 300, true, SceneAntialiasing.BALANCED, SceneType.SUB_SCENE);
	
	public void makeNewView3DFactory() {
		colorTransparencyTest();
	      FocusBasedCameraMouseEventHandler cameraController = view3dFactory.addCameraController(0.001, 100.0, true);
	      cameraController.setMinLatitude(Double.NEGATIVE_INFINITY);
	      cameraController.setMaxLatitude(Double.POSITIVE_INFINITY);
	      multipleNodeViewing();
	      view3dFactory.addWorldCoordinateSystem(0.4); //determines size of axes 
	      view3dFactory.addNodeToView(new AmbientLight(Color.WHEAT));
	      view3dFactory.addPointLight(-10.0, 0.0, 1.0, Color.WHEAT);
	}
	
	public void multipleNodeViewing() {
		if (multipleNodes == false) {
			view3dFactory.getRoot().getChildren().clear();
		}
		
	}
	
	public void colorTransparencyTest() {
		if (color == null) {
			color = Color.PINK;
		}
	}
	
	public void makeSphere() {
		
		makeNewView3DFactory();
		Sphere3D sphere3D = new Sphere3D();
	    sphere3D.set(x,y,z,radius);
	      
	    MeshDataHolder mesh = MeshDataGenerator.Sphere(radius, N, S);
	    mesh = MeshDataHolder.translate(mesh, sphere3D.getPosition());
	   
	      
	    TriangleMesh javaFXMesh = JavaFXMeshDataInterpreter.interpretMeshData(mesh);
	    MeshView javaFXSphereNode = new MeshView(javaFXMesh);

	    javaFXSphereNode.setMaterial(new PhongMaterial(color));
	    view3dFactory.addNodeToView(javaFXSphereNode);
	    
	}
	
	public void makeCube() {
		
	      makeNewView3DFactory();
	      
	      Box3D box3D = new Box3D();
	      Pose3D pose = new Pose3D(x, y, z, yaw, pitch, roll);
	      box3D.set(pose, length, width, height);
	     
	      MeshDataHolder mesh = MeshDataGenerator.Cube(length, width, height, true);
	      mesh = MeshDataHolder.rotate(mesh, new AxisAngle(box3D.getOrientation()));
	      mesh = MeshDataHolder.translate(mesh, box3D.getPosition());
	     
	      TriangleMesh javaFXMesh = JavaFXMeshDataInterpreter.interpretMeshData(mesh);
	      MeshView javaFXBoxNode = new MeshView(javaFXMesh);
	     
	      javaFXBoxNode.setMaterial(new PhongMaterial(color)); 
	      
	      view3dFactory.addNodeToView(javaFXBoxNode); 
	}

	public void makeRamp() {
		
		makeNewView3DFactory();
		
		Ramp3D ramp3D = new Ramp3D();
		Pose3D pose = new Pose3D(x, y, z, yaw, pitch, roll);
	    ramp3D.set(pose, length, width, height);
    
	    
	    MeshDataHolder mesh = MeshDataGenerator.Wedge(length, width, height);
	    mesh = MeshDataHolder.rotate(mesh, new AxisAngle(ramp3D.getOrientation()));
	    mesh = MeshDataHolder.translate(mesh, ramp3D.getPosition());
    
	    TriangleMesh javaFXMesh = JavaFXMeshDataInterpreter.interpretMeshData(mesh);
	    MeshView javaFXRampNode = new MeshView(javaFXMesh);
   
	    
	    javaFXRampNode.setMaterial(new PhongMaterial(color)); 
   
   
	    view3dFactory.addNodeToView(javaFXRampNode);
	}
	
	public void makeCapsule() {
		
		makeNewView3DFactory();
	    
	    Capsule3D capsule3D = new Capsule3D();
	   
	    capsule3D.getPosition().setX(x);
	    capsule3D.getPosition().setY(y);
	    capsule3D.getPosition().setZ(z);
	    capsule3D.set(capsule3D.getPosition(), capsule3D.getAxis(), length, radius);
	    
	    MeshDataHolder mesh = MeshDataGenerator.Capsule(height, width, length, radius, 100, 100);
	    mesh = MeshDataHolder.translate(mesh, capsule3D.getPosition());
	    
	    TriangleMesh javaFXMesh = JavaFXMeshDataInterpreter.interpretMeshData(mesh);
	    MeshView javaFXCapsuleNode = new MeshView(javaFXMesh);
	   
	    
	    javaFXCapsuleNode.setMaterial(new PhongMaterial(color)); 
	   
	   
	    view3dFactory.addNodeToView(javaFXCapsuleNode);  
	}
	
	public void makeCylinder() {
		
		makeNewView3DFactory();
		
	   Cylinder3D cylinder3D = new Cylinder3D();
	   cylinder3D.set(cylinder3D.getPosition(), cylinder3D.getAxis(), height, radius);
	    
	   MeshDataHolder mesh = MeshDataGenerator.Cylinder(radius, height, N);
	   mesh = MeshDataHolder.translate(mesh, cylinder3D.getPosition());
	  
	   
	   TriangleMesh javaFXMesh = JavaFXMeshDataInterpreter.interpretMeshData(mesh);
	   MeshView javaFXCylinderNode = new MeshView(javaFXMesh);
	   
	   javaFXCylinderNode.setMaterial(new PhongMaterial(color));
	   
	   view3dFactory.addNodeToView(javaFXCylinderNode);
	    
	    
	}

	public void makeEllipsoid() {
		
		makeNewView3DFactory();
	    
	    Ellipsoid3D ellipsoid3D = new Ellipsoid3D();
	    
	    Pose3D pose = new Pose3D(x, y , z, yaw, pitch, roll);
	    ellipsoid3D.set(pose, length, width, height);
	   
	    MeshDataHolder mesh = MeshDataGenerator.Ellipsoid(length, width, height, 100, 100);
	    mesh = MeshDataHolder.translate(mesh, ellipsoid3D.getPosition());
	    mesh = MeshDataHolder.rotate(mesh, new AxisAngle(ellipsoid3D.getOrientation()));
	    
	    TriangleMesh javaFXMesh = JavaFXMeshDataInterpreter.interpretMeshData(mesh);
	    MeshView javaFXEllipsoidNode = new MeshView(javaFXMesh);
	   
	   
	    javaFXEllipsoidNode.setMaterial(new PhongMaterial(color)); 
	   
	   
	    view3dFactory.addNodeToView(javaFXEllipsoidNode);  
		
	}

	public void makeTorus() {
		
		makeNewView3DFactory();
	    Torus3D torus3D = new Torus3D();
	    
	    startAngle = Math.toRadians(0);
	    endAngle = Math.toRadians(360);
	    tubeRadius = (radius/2);
	    torus3D.getPosition().setX(x);
	    torus3D.getPosition().setY(y);
	    torus3D.getPosition().setZ(z);
	    
	    torus3D.set(torus3D.getPosition(), torus3D.getAxis(), radius, tubeRadius);
	   
	    MeshDataHolder mesh = MeshDataGenerator.ArcTorus(startAngle, endAngle, radius, tubeRadius, N);
	    mesh = MeshDataHolder.translate(mesh, torus3D.getPosition());
	    
	    TriangleMesh javaFXMesh = JavaFXMeshDataInterpreter.interpretMeshData(mesh);
	    MeshView javaFXTorusNode = new MeshView(javaFXMesh);
	   
	   
	    javaFXTorusNode.setMaterial(new PhongMaterial(color)); 
	   
	   
	    view3dFactory.addNodeToView(javaFXTorusNode); 
	}

	


}
