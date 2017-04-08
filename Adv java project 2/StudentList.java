/*-----------------------------------------------
Student Name : Dona Varghese
Student ID   : 4000028991
COP 2805C –Java Programming 2
Spring - T Th 6:15 PM - 9:30PM
Project # 2
Plagiarism Statement: I certify that this assignment is my own work and that I have not copied in part or
whole or otherwise plagiarized the work of other students and/or persons.
----------------------------------------------------------*/


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.sql.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.mysql.jdbc.StringUtils;

public class StudentList {
 private ArrayList < Student > studentList = new ArrayList < Student > ();

 Connection conn;
 /*
  read text file 
 */
 public void readStudents() {
	 JOptionPane.showMessageDialog(null, "Choose a text file for read data ");
  JFileChooser fc = new JFileChooser();
  int retValue = fc.showOpenDialog(new JPanel());
  String[] data;
  File students = fc.getSelectedFile();
  try {
   InputStream is = new FileInputStream(students); {
    BufferedReader buf = new BufferedReader(new InputStreamReader(is));
    String line = buf.readLine();
    StringBuilder sb = new StringBuilder();
    while (line != null) {
     data = line.toString().split("\\|");
     double[] grade = new double[10];
     String[] names = new String[2];
grade[1]=0;
grade[2]=0;
grade[3]=0;
     for (int i = 0; i < 2; i++) {
      names[i] = data[i];
      System.out.print(names[i] + " ");
     
     }

     for (int i = 2; i < data.length; i++) {

      grade[i - 1] = Double.parseDouble(data[i]);
      System.out.print(grade[i - 1] + " ");
    
      if (i == (data.length - 1)) {
       System.out.print("\n");
      }
     }
     Student studentName = new Student(names[0], names[1]);
     studentList.add(studentName);
    
     Student student = new Student(grade[1], grade[2], grade[3]);
     studentList.add(student);
     

     line = buf.readLine();
    }

   }
   System.out.print("\n");
  } catch (IOException e) {
   e.printStackTrace();
  }

 }
 
/*
 * write text file to database
 */
 public void saveStudentsToDB() {
	 JOptionPane.showMessageDialog(null, "Choose a text file with student data for upload to database");
  // insert data to data base table
  JFileChooser fc = new JFileChooser();
  int retValue = fc.showOpenDialog(new JPanel());
  String[] data;
  File students = fc.getSelectedFile();
  try {
   InputStream is = new FileInputStream(students); {
    BufferedReader buf = new BufferedReader(new InputStreamReader(is));
    String line = buf.readLine();
    StringBuilder sb = new StringBuilder();

    Class.forName("com.mysql.jdbc.Driver");
     
     String DataBase = null;
     String user = JOptionPane.showInputDialog ( "Enter the username for database" );
     String pass = JOptionPane.showInputDialog ( "Enter the password for database" );
     String port = JOptionPane.showInputDialog ( "Enter the port number\nUse default value '3306' \nif you don't know your port number" );
     Properties connProperties;
     connProperties = new Properties();
     connProperties.setProperty("user", user);
     connProperties.setProperty("password", pass);

     DataBase =  JOptionPane.showInputDialog ( "Enter the name of database  you want to create" );
     conn = DriverManager.getConnection("jdbc:mysql://localhost:" +port+"/?user="+user+"&password="+pass);
     Statement stmt = conn.createStatement();
     int sqrt =  stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DataBase);
     int table = stmt.executeUpdate("CREATE TABLE "+ DataBase + ".StudentsTb1 " + "(id  INT(64) NOT NULL AUTO_INCREMENT, "  +
    		 		" FirstName VARCHAR(255), " + " LastName VARCHAR(255), " + " Grade1 DOUBLE, " + " Grade2 DOUBLE, " + " Grade3 DOUBLE, " +
    		 		" Average DOUBLE, " + " Status VARCHAR(7), " + " LetterGrade VARCHAR(1), "+ " PRIMARY KEY ( id ))");
     int usedb = stmt.executeUpdate("USE " + DataBase);
     int drop = stmt.executeUpdate("ALTER TABLE studentstb1 DROP id");
     System.out.println("DATABASE and  studentstb1 TABLE created succesfully");

    String query = "select * from studentstb1 ;";
    while (line != null) {
    
     data = line.toString().split("\\|");
     double[] grade = new double[10];
     String[] names = new String[2];
     grade[1]=0;
     grade[2]=0;
     grade[3]=0;
     for (int i = 0; i < 2; i++) {
      names[i] = data[i];

     }

     for (int i = 2; i < data.length; i++) {

      grade[i - 1] = Double.parseDouble(data[i]);

     }
     Student studentName = new Student(names[0], names[1]);
     studentList.add(studentName);
    
     Student student = new Student(grade[1], grade[2], grade[3]);
     studentList.add(student);
     
     String sql = "INSERT INTO studentstb1 (FirstName,LastName,Grade1,Grade2,Grade3,Average,Status,LetterGrade)" + "VALUES (?,?,?,?,?,?,?,?)";

     PreparedStatement preparedStatement = conn.prepareStatement(sql);
     preparedStatement.setString(1, names[0]);
     preparedStatement.setString(2, names[1]);
     if (grade[1] != 0) {
      preparedStatement.setDouble(3, grade[1]);
     } else {
      preparedStatement.setString(3, null);
     }
     if (grade[2] != 0) {
      preparedStatement.setDouble(4, grade[2]);
     } else {
      preparedStatement.setString(4, null);
     }
     if (grade[3] != 0) {

      preparedStatement.setDouble(5, grade[3]);
     } else {
      preparedStatement.setString(5, null);
     }
     preparedStatement.setDouble(6, Student.computeAverage());
     preparedStatement.setString(7, Student.getStatus());
     preparedStatement.setString(8, Student.getLetterGrade());
     preparedStatement.executeUpdate();
     
     line = buf.readLine();

    }

    buf.close();
    System.out.print("Data uploaded to database\n");
   }
  } catch (Exception e) {
   System.out.println(e);
   System.out.println(" not Connected");
   
  }
 }
/*
 * write data from database to text file
 */
 public void writeStudents() {
	 JOptionPane.showMessageDialog(null, "Choose a text file to print student data from database");
	 JFileChooser fc = new JFileChooser();
		int retValue = fc.showSaveDialog(new JPanel());
		File students = fc.getSelectedFile();
		
		System.out.println(students.getPath());
		
StringBuilder outPutText = new StringBuilder();

		PrintWriter writer = null;

			try {
				writer = new PrintWriter(students.getPath(), "UTF-8");

		outPutText.append(String.format("\r%20s","FirstName"));
		outPutText.append(String.format("\r%21s","LastName"));
		outPutText.append(String.format("\r%22s","Grade 1"));
		outPutText.append(String.format("\r%20s","Grade 2"));
		outPutText.append(String.format("\r%20s","Grade 3"));
		outPutText.append(String.format("\r%19s","Average"));
		outPutText.append(String.format("\r%18s","Status"));
		outPutText.append(String.format("\r%25s","Letter Grade"));
		writer.println(outPutText.toString());
		outPutText.setLength(0);
    
		try {
			Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("SELECT * FROM studentstb1");
	while(rs.next()) {
		String name1 = rs.getString("FirstName");
		String name2 = rs.getString("Lastname");
		Double grade11 = rs.getDouble("Grade1");
		Double grade12 = rs.getDouble("Grade2");
		Double grade13 = rs.getDouble("Grade3");
		Double average = rs.getDouble("Average");
		String status = rs.getString("Status");
		String letterGrade = rs.getString("LetterGrade");
		
		outPutText.append(String.format("\r%20s",name1));
		outPutText.append(" ");
		outPutText.append(String.format("\r%20s",name2));
		outPutText.append(String.format("\r%20s",grade11));
		outPutText.append(String.format("\r%20s",grade12));
		outPutText.append(String.format("\r%20s",grade13));
		outPutText.append(String.format("\r%20s",average));
		outPutText.append(String.format("\r%20s",status));
		outPutText.append(String.format("\r%20s",letterGrade));

		writer.println(outPutText.toString());
		outPutText.setLength(0);
	}
		
		
	    writer.close();
		    System.out.println("Done writing!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
/*
 * write sort data from database and write it in a text file 
 */
 public void writeSortedStudents() {
	 JOptionPane.showMessageDialog(null, "Choose a text file to print sorted Average student data from database");
	 JFileChooser fc = new JFileChooser();
		int retValue = fc.showSaveDialog(new JPanel());
		File students = fc.getSelectedFile();
		
		System.out.println(students.getPath());
		
StringBuilder outPutText = new StringBuilder();

		PrintWriter writer = null;

			try {
				writer = new PrintWriter(students.getPath(), "UTF-8");

		outPutText.append(String.format("\r%20s","FirstName"));
		outPutText.append(String.format("\r%21s","LastName"));
		outPutText.append(String.format("\r%22s","Grade 1"));
		outPutText.append(String.format("\r%20s","Grade 2"));
		outPutText.append(String.format("\r%20s","Grade 3"));
		outPutText.append(String.format("\r%19s","Average"));
		outPutText.append(String.format("\r%18s","Status"));
		outPutText.append(String.format("\r%25s","Letter Grade"));
		writer.println(outPutText.toString());
		outPutText.setLength(0);
 
		try {
			Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("SELECT FirstName,LastName,Grade1,Grade2,Grade3,Average,Status,LetterGrade FROM studentstb1" +
            " ORDER BY Average ASC");
	while(rs.next()) {
		String name1 = rs.getString("FirstName");
		String name2 = rs.getString("Lastname");
		Double grade11 = rs.getDouble("Grade1");
		Double grade12 = rs.getDouble("Grade2");
		Double grade13 = rs.getDouble("Grade3");
		Double average = rs.getDouble("Average");
		String status = rs.getString("Status");
		String letterGrade = rs.getString("LetterGrade");
		
		outPutText.append(String.format("\r%20s",name1));
		outPutText.append(" ");
		outPutText.append(String.format("\r%20s",name2));
		outPutText.append(String.format("\r%20s",grade11));
		outPutText.append(String.format("\r%20s",grade12));
		outPutText.append(String.format("\r%20s",grade13));
		outPutText.append(String.format("\r%20s",average));
		outPutText.append(String.format("\r%20s",status));
		outPutText.append(String.format("\r%20s",letterGrade));

		writer.println(outPutText.toString());
		outPutText.setLength(0);
	}
		
		
	    writer.close();
		    System.out.println("Done writing!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}


 /*
  * search student First name and Last name in Database
  */

 public void findStudent() {
	  PreparedStatement st,st1 = null;
	   JFrame frame = new JFrame();
	   String text;
	   do{
	    String message = "Enter the student FirstName and LastName witha a space";
	    text = JOptionPane.showInputDialog(frame, message);
	    if (text == null){
	    	try {
				conn.close();
				System.out.println("DataBase Connection closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	break;
	    }
	    String[] splitText = text.split(" ");
	    splitText = text.split(" ");

	try {
		
		st = conn.prepareStatement("select * from studentstb1 where FirstName=?");
		st1 = conn.prepareStatement("select * from studentstb1 where  LastName=?");
		String str1 = splitText[0];
		String str2 = splitText[1];
		st.setString(1, str1);
		st1.setString(1, str2);
		  ResultSet rs = st.executeQuery();
		  ResultSet rs1 =  st1.executeQuery();
		  if (rs.next()) {
			  
	          String s = rs.getString(1);
	          String s1 = rs.getString(2);
	          String s2 = rs.getString(3);
	          String s3 = rs.getString(4);
	          JOptionPane.showMessageDialog(null, "FirstName  Found");
	          }  else {

		          JOptionPane.showMessageDialog(null, "FirstName not Found");
	          }
	          if(rs1.next())
	          {
	        	   String s = rs1.getString(1);
	 	          String s1 = rs1.getString(2);
	 	          String s2 = rs1.getString(3);
	 	          String s3 = rs1.getString(4);
	 	         JOptionPane.showMessageDialog(null, "LastName  Found");
	      } else {

	          JOptionPane.showMessageDialog(null, "LastName not Found");

	      }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}while (text != null);

}
}
