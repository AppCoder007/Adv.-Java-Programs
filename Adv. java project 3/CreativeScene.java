/*-----------------------------------------------
Student ID : 4000028991
COP 2805C –Java Programming 3
Spring Short- T Th 6:15 PM - 9:30PM
Project # 3
Plagiarism Statement: I certify that this assignment is my own work and that I have not copied in part or
whole or otherwise plagiarized the work of other students and/or persons.
----------------------------------------------------------*/
import javafx.scene.image.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CreativeScene extends Application {

   // main method 
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Title of the Window");
     
        
        // create a backgroung image (sky )
        ImageView imageview = new ImageView(new Image("https://yourhighestpath.files.wordpress.com/2014/03/551173_583448501717825_528141157_n.jpg"));
        
        
        // create a pane to draw shapes and place in different coordinates
        Pane pane = new Pane();
        
        // create a line for umbrella (umbrella stick) 
        Line line1 = new Line(10,10,10,10);
        line1.setStartX(150);
        line1.setStartY(350);
        line1.setEndY(600);
        line1.setEndX(150);
        line1.setStrokeWidth(5);
        line1.setStroke(Color.GREEN);
        
        
        // create a image for place inside the circle shape
        Image img2 = new Image("https://images-na.ssl-images-amazon.com/images/I/31eZfz2aiGL.jpg");
        
        // create a circle shape for beach ball
    	Circle circle1 = new Circle();
		circle1.setStroke(Color.BLACK);
		circle1.setFill(new ImagePattern(img2));
		circle1.setCenterX(60);
		circle1.setCenterY(600);
		circle1.setRadius(25);
			
		
		// create a image for umbrella design
		Image img = new Image("https://s-media-cache-ak0.pinimg.com/736x/7c/0f/5e/7c0f5e4d8962391490c430246c19d650.jpg");
		
		// Draw the large semicircle for umbrella
		Arc arc = new Arc(150,350,150,100,0,180);
	    arc.setFill(new ImagePattern(img));
		
	    // draw a polyline for umbrella design
	    Polyline polyline = new Polyline();
	    polyline.getPoints().addAll(new Double[]{
	        0.0, 350.0,
	        15.0, 370.0,
	        30.0,350.0,
	        45.0,370.0,
	        60.0,350.0,
	        75.0,370.0,
	        90.0,350.0,
	        105.0,370.0,
	        120.0,350.0,
	        135.0,370.0,
	        150.0,350.0,
	        165.0,370.0,
	        180.0,350.0,
	        195.0,370.0,
	        210.0,350.0,
	        225.0,370.0,
	        240.0,350.0,
	        255.0,370.0,
	        270.0,350.0,
	        285.0,370.0,
	        300.0,350.0
	         });
	     polyline.setStrokeWidth(5);
	     polyline.setStroke(Color.YELLOW);
	     
	     // draw a line just above the polyline for umbrella
	     Line line2 = new Line(10,10,10,10);
	        line2.setStartX(0);
	        line2.setStartY(350);
	        line2.setEndY(350);
	        line2.setEndX(300);
	        line2.setStrokeWidth(5);
	        line2.setStroke(Color.BROWN);
	    
	        
	    // draw ellipse for umbrella stand
	    Ellipse ellipse = new Ellipse(150, 600, 50, 25);
	    ellipse.setStroke(Color.GREEN);
	    ellipse.setFill(Color.BROWN);
	    
	    // draw a polygon for breach sand
	    Polygon polygon1 = new Polygon();
	    polygon1.getPoints().addAll(new Double[]{
	            0.0,550.0,
	            0.0, 650.0,
	            650.0, 650.0,
	            650.0,300.0,
	            400.0,500.0,
	            });
	    // create a image for beach sand
	    Image img3 = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0LR6AZ1zv3ZiD1Kyg3eA2HjTmE34bA--l8O8DDUXUjBYSN3xYLQ");
       polygon1.setFill(new ImagePattern(img3));
	
       // create a polygon for sea water
       Polygon polygon2 = new Polygon();
	    polygon2.getPoints().addAll(new Double[]{
	            0.0,550.0,
	            400.0,500.0,
	            650.0,300.0,
	            650.0,200.0,
	            0.0,200.0
	            });
	    // create a image for sea water
	    Image img4 = new Image("https://image.freepik.com/free-photo/sea-water_1160-2.jpg");
	       polygon2.setFill(new ImagePattern(img4));
	       
	      // draw a polygon for the beach chair 
	       Polygon polygon3 = new Polygon();
	       polygon3.getPoints().addAll(new Double[]{
		            130.0,560.0,
	    		    140.0,550.0,
		            250.0,550.0,
		            280.0,500.0,
		            270.0,500.0,
		            245.0,535.0,
		            137.0,547.0,
		            130.0,557.0
		            });
	       polygon3.setFill(Color.WHITE);
	       
	   		// draw a rectangle for chair sand 1 and rotate to 110 degree angle
			Rectangle rectangle1 = new Rectangle();
			rectangle1.setFill(Color.WHITE);
			rectangle1.setWidth(5);
			rectangle1.setHeight(60);
			rectangle1.setY(530);
			rectangle1.setX(180);
			rectangle1.setRotate(110.0);
			
			// draw a rectangle for chair sand 2 and rotate to 70 degree angle
			Rectangle rectangle2 = new Rectangle();
			rectangle2.setFill(Color.WHITE);
			rectangle2.setWidth(5);
			rectangle2.setHeight(75);
			rectangle2.setY(520);
			rectangle2.setX(200);
			rectangle2.setRotate(70.0);
			
			// create a image file for the cooler with beer bottle
			Image img5 = new Image("https://github.com/AppCoder007/java-image-files-2/blob/master/k.jpg?raw=true");
			
			// draw a rectangle for place picture of cooler with beer bottle
			Rectangle rectangle3 = new Rectangle();
			rectangle3.setWidth(75);
			rectangle3.setHeight(50);
			rectangle3.setY(550);
			rectangle3.setX(220);
			rectangle3.setFill(new ImagePattern(img5));
	       
			
			// place all shapes in pane for display to users
			pane.getChildren().addAll(imageview,polygon1,polygon2,polygon3,ellipse,line1,circle1,arc,polyline,line2,rectangle1,rectangle2,rectangle3);
       

        Scene scene = new Scene(pane, 650, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}