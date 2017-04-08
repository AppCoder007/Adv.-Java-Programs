import java.text.DecimalFormat;

/*-----------------------------------------------
Student ID : 4000028991
COP 2805C –Java Programming 2
Spring - T Th 6:15 PM - 9:30PM
Project # 2
Plagiarism Statement: I certify that this assignment is my own work and that I have not copied in part or
whole or otherwise plagiarized the work of other students and/or persons.
----------------------------------------------------------*/


public class Student {
    static String firstName,lastName,status;
    static  String letterGrade;
    static  double grade1=0,grade2=0,grade3=0;
	static double average=0;
 
     public Student(String firstName,String lastName){
         this.firstName = firstName;
         this.lastName = lastName;
        
     }
     
     public Student(double grade1,double grade2,double grade3){
         this.grade1 = grade1;
         this.grade2 = grade2;
         this.grade3 = grade3;
         setAverage(Student.computeAverage());
         setStatus(this.computeStatus());
         setLetterGrade(this.computeLetterGrade());
     }
    
 

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static String getStatus() {
        return status;
    }

    public static String getLetterGrade() {
        return letterGrade;
    }

    public static double getGrade1() {
        return grade1;
    }

    public static double getGrade2() {
        return grade2;
    }

    public static double getGrade3() {
        return grade3;
    }

    public static double getAverage() {
        return average;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public void setGrade1(double grade1) {
        this.grade1 = grade1;
    }

    public void setGrade2(double grade2) {
        this.grade2 = grade2;
    }

    public void setGrade3(double grade3) {
        this.grade3 = grade3;
    }

    public void setAverage(double average) {
        this.average = average;
    }
    
    
    public static double computeAverage(){
    	
        double computedAverage=0;
        double sum=0;
        sum = getGrade1()+getGrade2()+getGrade3();
 
        computedAverage =Double.parseDouble(new DecimalFormat("##.##").format(sum / 3));
        sum=0;
        
        
        return computedAverage;
        
    }


    public String computeStatus(){
        if (computeAverage() < 70){
            return "Failing";
        }
        return "Passing";
    } 

    
     public String computeLetterGrade() {
    	 
    	  if (computeAverage() >= 90){
              letterGrade = "A";
          }else if (computeAverage() >= 80){
        	  letterGrade = "B";
          }else if (computeAverage() >= 70){
        	  letterGrade = "C";
          }else if (computeAverage() >= 60){
        	  letterGrade = "D";
          }else{
        	  letterGrade = "F";
          }
		return letterGrade;
   
}
    
}
