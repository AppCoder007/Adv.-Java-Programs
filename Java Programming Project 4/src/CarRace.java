/*-----------------------------------------------
Student ID : 4000028991
COP 2805C –Java Programming 4
Spring Short- T Th 6:15 PM - 9:30PM
Project # 4
Plagiarism Statement: I certify that this assignment is my own work and that I have not copied in part or
whole or otherwise plagiarized the work of other students and/or persons.
----------------------------------------------------------*/
import static java.lang.Math.random;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.image.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.collections.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.*;
import javafx.scene.control.Label;

public class CarRace extends Application  {
       // main method
    public static void main(String[] args) {
        launch(args);
  
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
         primaryStage.setTitle("CarRace");
         
          // create a pane to draw racing track
          Pane pane = new Pane();
         
            // create a image for subaru car 
            Image subaru  = new Image("https://github.com/AppCoder007/java-image-files-2/blob/master/subaru.jpg?raw=true");
            // create a rectangle to insert image of subaru car
            Rectangle rectangle1 = new Rectangle();
        	rectangle1.setWidth(60);
			rectangle1.setHeight(30);
			rectangle1.setY(385);
			rectangle1.setX(-5);
			rectangle1.setFill(new ImagePattern(subaru));
     
			// create a image for bmw car 
			Image bmwm3 = new Image("https://github.com/AppCoder007/java-image-files-2/blob/master/BMWm3.jpg?raw=true");
			// create a rectangle to insert image of bmw car        
			 Rectangle rectangle2 = new Rectangle();
	         rectangle2.setWidth(60);
			 rectangle2.setHeight(30);
			 rectangle2.setY(285);
			 rectangle2.setX(-5);
			 rectangle2.setFill(new ImagePattern(bmwm3));
				
		    // create a image for lancer car 
            Image lancerevo = new Image("https://github.com/AppCoder007/java-image-files-2/blob/master/lancer%20evo.jpg?raw=true");
            // create a rectangle to insert image of lancer car 
            Rectangle rectangle3 = new Rectangle();
     	    rectangle3.setWidth(60);
     		rectangle3.setHeight(30);
     		rectangle3.setY(185);
     		rectangle3.setX(-5);
     		rectangle3.setFill(new ImagePattern(lancerevo));
                     
            // create a image of civic car
            Image civicR = new Image("https://github.com/AppCoder007/java-image-files-2/blob/master/civic%20type%20r.png?raw=true");
            // create a rectangle to insert image of civic car 
            Rectangle rectangle4 = new Rectangle();
          	rectangle4.setWidth(60);
          	rectangle4.setHeight(30);
          	rectangle4.setY(85);
          	rectangle4.setX(-5);
            rectangle4.setFill(new ImagePattern(civicR));
        
          				      
            // create a Stert button to start race        
            Button StartButton = new Button("Start");
            // create reset button to to reset game
            Button resetButton = new Button("Reset");
            
            // create a text to display info to user
            Text text1 = new Text("Select Bet Amount Max.($1000):");
            Text text2 = new Text("Choose Car");
            
            // combo box for car list
            ComboBox<String> cbo = new ComboBox<>();
            cbo.getItems().addAll("1. Subaru WRX STI","2. BMW M3","3. Lancer Evo","4. Civic Type-R");
            cbo.setValue("");
            cbo.setMaxWidth(100);
            
            	//	combo box for Amount 0 to 1000
            ComboBox<String> cbo2 = new ComboBox<>();
            cbo2.setValue("0");
            for(int i =0; i<= 1000; i++){
         	   String x = String.valueOf(i);
         	   cbo2.getItems().add(x);
            }
        	
            // textfield to display winner info to user
            TextField displayMessageToUser = new TextField();
            displayMessageToUser.setPrefWidth(600); 
            displayMessageToUser.setPrefHeight(50);
            displayMessageToUser.setLayoutX(0);
            displayMessageToUser.setLayoutY(500);
            displayMessageToUser.setText("Select Car and Amount then Press Start Button to Start Race");
            displayMessageToUser.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
            
            // create a image for finish line and set it into specified width and height
            Image image = new Image("https://github.com/AppCoder007/java-image-files-2/blob/master/checer.png?raw=true");
            ImageView imageview = new ImageView(image);
            imageview.setFitWidth(50);
            imageview.setFitHeight(550);
        
            // carposition number 1
            Text one = new Text();
            one.setText("1");
            one.setX(20);
            one.setY(450);
            one.setFill(Color.WHITE);
            one.setFont(Font.font(22));
            
            // carposition number 2
            Text two = new Text();
            two.setText("2");
            two.setX(20);
            two.setY(350);
            two.setFill(Color.WHITE);
            two.setFont(Font.font(22));
            
            // carposition number 3
            Text three = new Text();
            three.setText("3");
            three.setX(20);
            three.setY(240);
            three.setFill(Color.WHITE);
            three.setFont(Font.font(22));
            
            // carposition number 4
            Text four = new Text();
            four.setText("4");
            four.setX(20);
            four.setY(130);
            four.setFill(Color.WHITE);
            four.setFont(Font.font(22));
            
            // start line of race
            Line start = new Line();
            start.setStrokeWidth(5);
            start.setStartX(60);
	        start.setStartY(50);
	        start.setEndY(450);
	        start.setEndX(60);
            start.setStroke(Color.WHITE);
           
            // start line text
            Text StartLine = new Text("START LINE");
            StartLine.setFill(Color.WHITE);
            StartLine.setX(14);
            StartLine.setY(267);
            StartLine.setRotate(-90);
            StartLine.setFont(Font.font(22));
            
            // create a image finsh line and insert into rectangle
            Image img2 = new Image("https://github.com/AppCoder007/java-image-files-2/blob/master/FINISH%20LINE.png?raw=true");
            Rectangle rectangleforText = new Rectangle();
            rectangleforText.setFill(new ImagePattern(img2));
            rectangleforText.setWidth(20);
			rectangleforText.setHeight(200);
            
            // rectangle for finish line
            Rectangle rectangle = new Rectangle();
            rectangle.setFill(new ImagePattern(image));
        	rectangle.setWidth(40);
			rectangle.setHeight(550);
			
			// stack pane for finish line
            StackPane stackpane = new StackPane();
            stackpane.getChildren().addAll(rectangle,rectangleforText);
            
            // hbox for Start buttons and combo box
            HBox hbox = new HBox(15);
            hbox.setPadding(new Insets(15,15,15,15));
            hbox.setStyle("-fx-background-color: green");
            hbox.getChildren().addAll(StartButton,resetButton,text1,cbo2,text2,cbo);
            
       // Start button mouse click event function 
       StartButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
        @Override public void handle(MouseEvent event) {
        	
              // get value from combo box of amount and convert into integer
              String number = cbo2.getValue();
              int x = Integer.valueOf(number);
    		 
              // race starts only if amount is greter than zero and a car is selected
        	  if(cbo.getValue() != "" && x>0 ){
        		
        	
              // create a path for car position 1
              Path path1 = new Path();
              HLineTo line1;
              line1 = new HLineTo(570);
              path1.getElements().addAll(new MoveTo(25,400),line1);
              path1.setFill(Color.AQUA);
      
              
              // create a path for car position 2
              Path path2 = new Path();
              HLineTo line2;
              line2 = new HLineTo(570);
              path2.getElements().addAll(new MoveTo(25,300),line1);
              path2.setFill(Color.AQUA);
       
              
              
              // create a path for car position 3
              Path path3 = new Path();
              HLineTo line3;
              line3 = new HLineTo(570);
              path3.getElements().addAll(new MoveTo(25,200),line3);
              path3.setFill(Color.AQUA);
   
              
              // create a path for car position 4
              Path path4 = new Path();
              HLineTo line4;
              line4 = new HLineTo(570);
              path4.getElements().addAll(new MoveTo(25,100),line4);
              path4.setFill(Color.AQUA);
              
             //  create an array of four elemenrts
             int randomValue[]=new int[4]; 
             int n=0;
             // add four random value to array
             while(n<4){
    	     randomValue[n]=new Random().nextInt(500 + 500)  + 2000;
    	     n++;
             }
             // copy of array
             int[] randomValueCopy = randomValue.clone();
             // sort the copy of first array 
             Arrays.sort(randomValueCopy);


 

              // path for animation car 1
            PathTransition pt1;
            pt1 = new PathTransition(Duration.millis(randomValue[0]),path1,rectangle1);
            pt1.setAutoReverse(false);
            pt1.play();
            
            // path for animation car 2
            PathTransition pt2;
            pt2 = new PathTransition(Duration.millis(randomValue[1]),path2,rectangle2);
            pt2.setAutoReverse(false);
            pt2.play();
            
            // path for animation car 3
            PathTransition pt3;
            pt3 = new PathTransition(Duration.millis(randomValue[2]),path3,rectangle3);
            pt3.setAutoReverse(false);
            pt3.play();
            
            // path for animation car 4
            PathTransition pt4;
            pt4 = new PathTransition(Duration.millis(randomValue[3]),path4,rectangle4);
            pt4.setAutoReverse(false);
            pt4.play();
            
            // create a timer to call a method 
            Timer timer = new Timer();
            TimerTask task = new TimerTask()
            {
            	// method to determine selected car win at which position
                public void run()
                
                {
                	// create String variable to display winner and amount to user
                	String subaru;
                	String bmw;
                	String lancer;
                	String civic;
                	
                	    // display the user if subaru wins the first place
                	if(randomValue[0]== randomValueCopy[0] && cbo.getValue()=="1. Subaru WRX STI"){
                	
                         subaru ="Congratulations 1.Subaru WRX STI wins at first place and  you won  $"+ x*1000;
                         displayMessageToUser.setText(subaru);
                         
                     	// display the user if bmw wins the first place
                	}else if(randomValue[1]== randomValueCopy[0] && cbo.getValue()=="2. BMW M3"){
                    	
                         bmw = "Congratulations 2. BMW M3 wins at first place and  you won  $"+ x*1000;
                         displayMessageToUser.setText(bmw);
                 
                     	// display the user if lancer wins the first place
            	    }else if(randomValue[2]== randomValueCopy[0] && cbo.getValue()=="3. Lancer Evo"){
                    	
                        lancer = "Congratulations 3. Lancer Evo wins at first place and  you won  $"+ x*1000;
                        displayMessageToUser.setText(lancer);
                        
                    	// display the user if civic wins the first place
            	    }else if(randomValue[3]== randomValueCopy[0] && cbo.getValue()=="4. Civic Type-R"){
                	
                        civic = "Congratulations 4. Civic Typr-R wins at first place and  you won  $"+ x*1000;
                        displayMessageToUser.setText(civic);
                        
                        // display the user if subaru wins the second place
        	        }else if(randomValue[0]== randomValueCopy[1] && cbo.getValue()=="1. Subaru WRX STI"){
            	
                        subaru = "Congratulations 1.Subaru WRX STI wins at Second place and  you won  $"+ x*500;
                        displayMessageToUser.setText(subaru);
                
                        // display the user if bmw wins the second place
    	            }else if(randomValue[1]== randomValueCopy[1] && cbo.getValue()=="2. BMW M3"){
        	
                        bmw = "Congratulations 2. BMW M3 wins at Second place and  you won  $"+ x*500;
                        displayMessageToUser.setText(bmw);
            
                        // display the user if lancer wins the second place
	                }else if(randomValue[2]== randomValueCopy[1] && cbo.getValue()=="3. Lancer Evo"){
        	
                        lancer = "Congratulations 3. Lancer Evo wins at Second place and  you won  $"+ x*500;
                        displayMessageToUser.setText(lancer);
        	
                        // display the user if civic wins the second place
	                }else if(randomValue[3]== randomValueCopy[1] && cbo.getValue()=="4. Civic Type-R"){
    	
                        civic = "Congratulations 4. Civic Typr-R wins at Second place and  you won  $"+ x*500;
                        displayMessageToUser.setText(civic);
        
                        // display the user if subaru wins the third place
                    }else if(randomValue[0]== randomValueCopy[2] && cbo.getValue()=="1. Subaru WRX STI"){
	
                        subaru = "Congratulations 1.Subaru WRX STI wins at Third place and  you won  $"+ x*250;
                        displayMessageToUser.setText(subaru);
    
                        // display the user if bmw wins the third place
                    }else if(randomValue[1]== randomValueCopy[2] && cbo.getValue()=="2. BMW M3"){

                        bmw = "Congratulations 2. BMW M3 wins at Third place and  you won  $"+ x*250;
                        displayMessageToUser.setText(bmw);

                        // display the user if lancer wins the third place
                    }else if(randomValue[2]== randomValueCopy[2] && cbo.getValue()=="3. Lancer Evo"){

                        lancer = "Congratulations 3. Lancer Evo wins at Third place and  you won  $"+ x*250;
                        displayMessageToUser.setText(lancer);

                        // display the user if civic wins the third place
                    }else if(randomValue[3]== randomValueCopy[2] && cbo.getValue()=="4. Civic Type-R"){

                        civic = "Congratulations 4. Civic Typr-R wins at Third place and  you won  $"+ x*250;
                        displayMessageToUser.setText(civic);
                        // else display the user if lost the race and no money won
                    }else{
	                    displayMessageToUser.setText("Sorry you Don't Win any money at this time try again later ");
                    }// end of if else statement

                    }// end of run method

        }; // end of timer function
        
     // call timer function when last car reach the finish line
        timer.schedule(task,randomValueCopy[3]);
 
        	} // end of if statement of start button conditions
        	else{
        		// if user forgot to select amount or car this alert the user
        		JOptionPane.showMessageDialog(null, "Select a Amount greater than Zero or Select a Car");
      
        	}// end of start button if statement
        }// end of  handle(MouseEvent event) 
        }); // end of Start button onClick mouse event function
                 
       
               
           // reset button function to clear amount, car selection, display message, set car into starting point with animation 
                 resetButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                     @Override public void handle(MouseEvent event) {
               cbo.setValue("");
               cbo2.setValue("0");
               displayMessageToUser.setText("Select Car and Amount then Press Start Button to Start Race");
                    

                    // first path
                      Path path1 = new Path();
                      HLineTo line1;
                      line1 = new HLineTo(25);
                      path1.getElements().addAll(new MoveTo(-30,400),line1);
       
                      
                      // 2nd path
                      Path path2 = new Path();
                      HLineTo line2;
                      line2 = new HLineTo(25);
                      path2.getElements().addAll(new MoveTo(-30,300),line2);
         
                      
                      
                      // 3rd path
                      Path path3 = new Path();
                      HLineTo line3;
                      line3 = new HLineTo(25);
                      path3.getElements().addAll(new MoveTo(-30,200),line3);
               
                      
                      //4th path
                      Path path4 = new Path();
                      HLineTo line4;
                      line4 = new HLineTo(25);
                      path4.getElements().addAll(new MoveTo(-30,100),line4);
                
                      

                      
                     // animation for place car 1 into start line 
                    PathTransition pt1;
                    pt1 = new PathTransition(Duration.millis(2000),path1,rectangle1);
                    pt1.setAutoReverse(false);
                    pt1.play();
                    
                    // animation for place car  into start line 
                    PathTransition pt2;
                    pt2 = new PathTransition(Duration.millis(2000),path2,rectangle2);
                    pt2.setAutoReverse(false);
                    pt2.play();
                    
                    // animation for place car 3 into start line 
                    PathTransition pt3;
                    pt3 = new PathTransition(Duration.millis(2000),path3,rectangle3);
                    pt3.setAutoReverse(false);
                    pt3.play();
                    
                    // animation for place car 4 into start line 
                    PathTransition pt4;
                    pt4 = new PathTransition(Duration.millis(2000),path4,rectangle4);
                    pt4.setAutoReverse(false);
                    pt4.play();
                   
                     }// end of handle(MouseEvent event)
         		});// end of mouse event on reset button
            
              
             
            // create a image for race track
            ImageView imageview1 = new ImageView(new Image("https://github.com/AppCoder007/java-image-files-2/blob/master/race%20track%20trim%20size.png?raw=true"));
                 

            // place all shapes in pane for display to users
            pane.getChildren().addAll(imageview1,StartLine,start,one,two,three,four,rectangle1,rectangle2,rectangle3,rectangle4,displayMessageToUser);
          
            // border pane to place hbox , finish line, pane for race track
            BorderPane borderPane = new BorderPane();
            borderPane.setBottom(hbox);
            borderPane.setRight(stackpane);
            borderPane.setCenter(pane);
           

            // create a scene with 600x600 size
            Scene scene = new Scene(borderPane,600,600);
            primaryStage.setScene(scene);
            primaryStage.show();      
    
    }// end of start method
}// end of CarRace class