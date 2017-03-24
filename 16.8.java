// need to fix overlapping code

import javafx.scene.shape.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javafx.application.*;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.layout.GridPane;

public class TwoCircleIntersect extends Application {
	@Override
	
	public void start(Stage primaryStage){
		
		Label lb = new Label("Two circles intersect? No");
		 lb.setContentDisplay(ContentDisplay.TOP);
		 
		 // two circle objects
		Circle circle1 = new Circle();
		circle1.setStroke(Color.BLACK);
		circle1.setFill(Color.WHITE);
		circle1.setCenterX(100);
		circle1.setCenterY(100);
		circle1.setRadius(50);
		
		
		Circle circle2 = new Circle();
		circle2.setStroke(Color.BLACK);
		circle2.setFill(Color.WHITE);
		circle2.setCenterX(250);
		circle2.setCenterY(100);
		circle2.setRadius(50);
		
		
	
		
		// text feild for show coordinates
		  TextField t1 = new TextField();
		  TextField t2 = new TextField();
		  TextField t3 = new TextField();
		  TextField t4 = new TextField();
		  TextField t5 = new TextField();
		  TextField t6 = new TextField();
		  
		  
		  // on mouse drag event
		circle1.setOnMouseDragged(e ->  {
			double x;
			 double y;
		     x=e.getSceneX();
		     y=e.getY();			
			circle1.setCenterX(x);
			 circle1.setCenterY(y);
			    t1.setText(String.valueOf(x));
			    t2.setText(String.valueOf(y));
			    t3.setText(String.valueOf(circle1.getRadius()));
		//	 to know the coordinates
		   // System.out.println(x+","+y);//these co-ords are relative to the component
		});
		
		
	circle2.setOnMouseDragged(e ->  {
		double n;
		 double m;
		     n=e.getSceneX();
		     m=e.getY();
			circle2.setCenterX(n);
			circle2.setCenterY(m);
			  t4.setText(String.valueOf(n));
			    t5.setText(String.valueOf(m));
			    t6.setText(String.valueOf(circle2.getRadius()));
		});
		
/// pane for display text box
	GridPane textbox = new GridPane();
    textbox.setStyle("-fx-border-width: 2px; -fx-border-color: green");
    textbox.add(new Label("Enter circle 1 info;"),0,0);
    textbox.add(new Label("Center x:"),0,1);
    textbox.setConstraints(t1, 1, 1);
    textbox.add(new Label("Center y:"),0,2);
    textbox.setConstraints(t2, 1, 2);
    textbox.add(new Label("Radius:"),0,3);
    textbox.setConstraints(t3, 1, 3);
   
// resize the circle
    t3.textProperty().addListener(e -> {
    	//String text = t3.getText();
    	//double text1 = Double.parseDouble(text);
    	circle1.setRadius(Double.parseDouble(t3.getText()));
    
        //System.out.println("textfield changed from " + oldValue + " to " + newValue);
    });
 
    textbox.getChildren().addAll(t1,t2,t3);
    
    GridPane textbox1 = new GridPane();
	
    textbox1.setStyle("-fx-border-width: 2px; -fx-border-color: green");
    textbox1.add(new Label("Enter circle 1 info;"),0,0);
    textbox1.add(new Label("Center x:"),0,1);
    textbox1.setConstraints(t4, 1, 1);
    textbox1.add(new Label("Center y:"),0,2);
    textbox1.setConstraints(t5, 1, 2);
    textbox1.add(new Label("Radius:"),0,3);
    textbox1.setConstraints(t6, 1, 3);
    textbox1.getChildren().addAll(t4,t5,t6);
    t6.textProperty().addListener(e -> {
    	//String text = t3.getText();
    	//double text1 = Double.parseDouble(text);
    	circle2.setRadius(Double.parseDouble(t6.getText()));
    
        //System.out.println("textfield changed from " + oldValue + " to " + newValue);
    });
    
    
	    // clear button probably not work :)
	    Pane Button = new Pane();
	    Button bt = new Button("Redraw Circle");
	    Button.getChildren().add(bt);
	    
	    // pane for display two different circle coordinates
	    HBox panefortextbox = new HBox(20);
	    panefortextbox.getChildren().addAll(textbox,textbox1);

	    Pane pane = new Pane();
		pane.getChildren().addAll(lb,circle1,circle2);
	    
		BorderPane pane1 = new BorderPane();
		pane1.setTop(pane);
		pane1.setCenter(panefortextbox);
		pane1.setBottom(Button);
		

		Scene scene = new Scene(pane1, 450, 450);
		
		primaryStage.setTitle("TwoCircles");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	 
	public static void main(String[] args) {
		    launch(args);
		  }

}
