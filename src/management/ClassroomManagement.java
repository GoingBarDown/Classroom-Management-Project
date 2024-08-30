package management;
//---------------------------------------
// Assignment 4
// Written by: Chandler Higgins 40156534
// For COMP 248 Section S - Winter 2022
//---------------------------------------

/*This program is to create a program in which a professor can manage registrants and classroom activities. The program allows the user to enrol students, unenrol students, 
 * enter each student's scores, update each student's information, display the report card for each student and the entire class' report card. */

import java.util.Scanner; // Scanner is initiated



public class ClassroomManagement {
public static void main(String[] args) {
	int arrIdx=0;
	System.out.println("Welcome to the Simple Classroom Management System:");
	
	System.out.println("Enter instructor's particulars (FirstName, LastName, LectureRoom, Semester, MaxclassSize) as a single-line entry: ");
	Scanner scanner = new Scanner(System.in); // Instantiation of the Scanner
	
	//Input for Instructors particulars
	String iFname = scanner.next(); 
	String iLname = scanner.next();
	String room = scanner.next();
	String semester = scanner.next();
	boolean sizebool = scanner.hasNextInt(); // Input to check whether input is an integer
	if (sizebool) // If the input is an integer, the program will be ran
	{
		// input for the class size
		int Classsize = scanner.nextInt();
	
	// The constructor is instantiated with the previous inputs as the parameters
	Comp248secU constructor = new Comp248secU (iFname,iLname ,room ,semester, Classsize); // Instantiating the Constructor. Instantiated outside of the loop so there aren't any complications
	
	// The menu screen
	System.out.println("\nCode Description => Description");
	System.out.println("--------------------------------");	
	
	System.out.println("103 => Enrol New Student");
	System.out.println("106 => Find Student Position in Class List");
	System.out.println("109 => Retrieve Student's Information");
	System.out.println("112 => Unenrol Student");
	System.out.println("115 => Update Student's Particulars");
	System.out.println("118 => Update Assignment Scores");
	System.out.println("121 => Update Other Scores");
	System.out.println("124 => Display Student's Report Card");
	System.out.println("127 => Display Class Report Card");
	System.out.println("0 ===> Exit\n");
	
	System.out.print("Please enter a Code, from the aforementioned, that corresponds to your task: ");
	
	//-----------------------------------------------------
	/* Both a while loop and an over-arching if statement has been used. The over-arching if statement has been used to replicate the menu.
	 * The while loop has been used so when the if statement ends, it loops back to the beginning. This will allow the user to be able to be constantly 
	 * circulating through the menu when needed. */
	while(true) { // While loop used at the beginning so it loops back to the beginning
		boolean bytebool = scanner.hasNextByte();
		
		if (bytebool == true) {
		int byteinp = scanner.nextByte();
			if (byteinp == 103) { // if user enters 103
				 // Have the array index increase by one every time 103 is called so we can keep track of the amount of students added
				System.out.println("\n\nEnrolling New Student...");
				System.out.println("------------------------");	
				System.out.println("Enter student's particulars (FirstName, LastName, StudentID) as a single line entry: ");
				
				// User input for the student's particulars
				String fname = scanner.next();
				String lname = scanner.next();
				boolean isid = scanner.hasNextInt();
				if (isid == true) {
				
					int studID = scanner.nextInt();
					constructor.addStudent(fname, lname, studID, arrIdx);
					arrIdx++; // The index of the array is increased every time that 103 is called by the user and the input is an actual integer
					System.out.print("Kindly continue by entering a code a Code, from the menu above, that corresponds to your task: ");	
	
					} else {
				System.out.println("Your entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
				System.out.print("Kindly continue by entering a code a Code, from the menu above, that corresponds to your task: ");
				String a =scanner.nextLine();
			}
			}
				else if (byteinp == 106) { // If the user enters 106
				System.out.println("\n\nFinding Students Position in Class List...");
				System.out.println("------------------------------------------");	
				System.out.println("Enter StudentID: ");
				boolean bool2 = scanner.hasNextInt();
				if (bool2 == false) {
				// If the user enters a non-integer, the error screen will pop up
					System.out.println("Error: Your input/entry for 'StudentID' is Not a valid integer. Kindly retry again!");	
				}
				if (bool2 == true) {
					// If the user enters an integer, it will be used for the Student ID
					int id = scanner.nextInt(); 
					// If the getStudentIndex method doesn't return a negative one, then the getStudentIndx method will be initiated
					if (constructor.getStudentIdx(id) != -1) 
					{
						System.out.println("The position of student with ID: " + id + ", in the class list, is: " + constructor.getStudentIdx(id));
						System.out.print("Kindly continue by entering a code a Code, from the menu above, that corresponds to your task: ");
					}
					else 
					{
						//If -1 is returned and there is no Student ID match, the error screen shows and the user is asked to enter another code
						System.out.println("Student with ID: " + id + " does NOT exist...");
						System.out.print("Kindly continue by entering a code a Code, from the menu above, that corresponds to your task: ");

					}
				}
				}
				else if (byteinp == 109) { // If user enters 109
				System.out.println("\n\nRetrieving Students Information");
				System.out.println("------------------------------------------");	
				System.out.println("Enter StudentID: ");
				boolean isid3 = scanner.hasNextInt();
				if (isid3 == false) {
					// If the user enters a non-integer, the error screen will pop up

					System.out.println("Error: Your input/entry for 'StudentID' is Not a valid integer. Kindly retry again!");	
				}
				if (isid3 == true) {
					int id = scanner.nextInt();
					// If the getStudentIndex method doesn't return a negative one, then the getStudentInfo method will be initiated
					if (constructor.getStudentIdx(id) != -1) 
					{
						System.out.println(constructor.getStudentInfo(id));
						
					}
					else 
					{
						//If -1 is returned and there is no Student ID match, the error screen shows and the user is asked to enter another code
						System.out.println("Student with ID: " + id + " doesn't exist");
						System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
					}
					
				}
			
				
		}	
				else if (byteinp == 112) {// If user enters 109
					System.out.println("\n\nUnenrolling Student");
					System.out.println("------------------------------------------");	
					System.out.println("Enter StudentID: ");
					boolean isid3 = scanner.hasNextInt();
					if (isid3 == false) {
						// If the user enters a non-integer, the error screen will pop up
						System.out.println("Error: Your input/entry for 'StudentID' is Not a valid integer. Kindly retry again!");	
					}
					if (isid3 == true) {
						int id = scanner.nextInt();
						// If the getStudentIndex method doesn't return a negative one, then the delStudent method will be initiated
						if (constructor.getStudentIdx(id) != -1)
						{
							constructor.delStudent(id);
							System.out.println("Successfully removed student with ID: " + id);
							System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");

						}
						else 
						{
							//If -1 is returned and there is no Student ID match, the error screen shows and the user is asked to enter another code
							System.out.println("Student with ID: " + id + " doesn't exist");
							System.out.println("Unable to retrieve information for student with ID: " + id);
							System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
						}
						
					}	
			}	
				else if (byteinp == 115) // If the user enters 115
				{
					
						System.out.println("\n\nUpdating Student Particulars...");
						System.out.println("------------------------");	
						System.out.println("Enter student's particulars (FirstName, LastName, StudentID) as a single line entry: ");
						// The scanner is called for the updated first name, last name and Student ID
						String fname = scanner.next();
						String lname = scanner.next();
						boolean isid = scanner.hasNextInt();

						if (isid == true) {
							int studID = scanner.nextInt();
							// If the getStudentIndex method doesn't return a negative one, then the updateStudentPart method will be initiated

							if (constructor.getStudentIdx(studID) != -1)
							{
							constructor.updateStudentPart(fname, lname, studID);
							System.out.println("Successfully updated indentification particulars student with ID" + studID);
							System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");	
							}
							 else 
							 {
									//If -1 is returned and there is no Student ID match, the error screen shows and the user is asked to enter another code
								System.out.println("Student with ID: " + studID + " does NOT exist...");
								System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
							 }
						}
						else 	
						{
							//If the user enters a non-integer then an error message will pop up
					System.out.println("Your entry for 'StudentID' is NOT a valid integer. Kindly retry again!");
					System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
					String a =scanner.nextLine(); // We are asking for a String input here so the input is compatible with the loop and if loops correctly after the input
						}
				}
				else if (byteinp == 118) 
				{
					// Have the array index increase by one every so keep track of the students added
						System.out.println("\n\nUpdating Student's Assignment Scores");
						System.out.println("------------------------------");	
						System.out.println("Enter student's Assignment Scores (Assignment1, Assignment2, Assignment3, Assignment4, StudentID) a single line entry: ");
						double ass1 = scanner.nextDouble();
						double ass2 = scanner.nextDouble();
						double ass3 = scanner.nextDouble();
						double ass4 = scanner.nextDouble();
						boolean isid = scanner.hasNextInt();
						if (isid == true) {
							int studID = scanner.nextInt();
							// If the getStudentIndex method doesn't return a negative one, then the updateStudentPart method will be initiated
							if (constructor.getStudentIdx(studID) != -1)
							{
							constructor.updateAssgtScore(ass1, ass2, ass3, ass4, studID);
							System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");	
							}
							 else 
							 {
									//If -1 is returned and there is no Student ID match, the error screen shows and the user is asked to enter another code
								System.out.println("Student with ID: " + studID + " does NOT exist...");
								System.out.println("Unable to retrieve information for student with ID: " + studID);
								System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
							 }
							
					
						}
						else 
							
						{
							//If the user enters a non-integer an error message will pop up
					System.out.println("Error: Your input/entry for 'Student ID' is not a valid integer. Kindly retry again!");
					System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
					String a =scanner.nextLine(); // We are asking for a String input here so the input is compatible with the loop and if loops correctly after the input
						}
				}
				else if (byteinp == 121) 
				{
						 // Have the array index increase by one every time 103 is called so we can keep track of the amount of students added
						System.out.println("\n\nUpdating Student's Assignment Scores");
						System.out.println("------------------------------");	
						System.out.println("Enter student's Assignment Scores (Cumulative Labs, MidTerm, FinalExam, StudentID) a single line entry: ");
						double cumlabs = scanner.nextDouble();
						double mid = scanner.nextDouble();
						double fin = scanner.nextDouble();
						boolean isid = scanner.hasNextInt();
                 
						if (isid == true) {
							int studID = scanner.nextInt();
							
							// If the getStudentIndex method doesn't return a negative one, then the updateStudentPart method will be initiated
							if (constructor.getStudentIdx(studID) != -1)
							{
							constructor.updateOtherScore(cumlabs, mid, fin, studID);
							System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");	
							}
							 else 
							 {
									//If -1 is returned and there is no Student ID match, the error screen shows and the user is asked to enter another code
								System.out.println("Student with ID: " + studID + " does NOT exist...");
								System.out.println("Unable to retrieve information for student with ID: " + studID);
								System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
							 }
							
					
						}
						//Else statement for if the user doesn't enter a valid integer
						else { 
					System.out.println("Error: Your input/entry for 'Student ID' is not a valid integer. Kindly retry again!");
					System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
					String a =scanner.nextLine(); // We are asking for a String input here so the input is compatible with the loop and if loops correctly after the input
						}
				}
				else if (byteinp == 124) 
				{
					 //Have the array index increase by one every time 103 is called so we can keep track of the amount of students added
						System.out.println("\n\nDisplaying Student's Report Card...");
						System.out.println("------------------------------");	
						System.out.println("Enter Student ID: "); 
						boolean isid = scanner.hasNextInt();
								if (isid == true) {
									int studID = scanner.nextInt();
									
									// If the getStudentIndex method doesn't return a negative one, then the students report card will be displayed
									// If the report card is displayed, for each variable, the constructor is called for both that specific variable and the student's corresponding index
									if (constructor.getStudentIdx(studID) != -1)
									{
									System.out.println("Student's First Name = " + constructor.studFname[constructor.getStudentIdx(studID)]);
									System.out.println("Student's Last Name = " + constructor.studLname[constructor.getStudentIdx(studID)]);
									System.out.println("Student's ID = " + constructor.findid(studID));
									System.out.println("Student's Assignment 1 = " + constructor.findass1(studID));
									System.out.println("Student's Assignment 2 = " + constructor.findass2(studID));
									System.out.println("Student's Assignment 3 = " + constructor.findass3(studID));
									System.out.println("Student's Assignment 4 = " + constructor.findass4(studID));
									System.out.println("Cumulative Score in Labs = " + constructor.findcumlabs(studID));
									System.out.println("Mid-Term Test Score = " + constructor.findmidterm(studID));
									System.out.println("Final Examination = " + constructor.findfinal(studID));
									System.out.println("------------------------------");	
									System.out.println("Student's Cumulative Weighted Score = " + constructor.computeWeightScore(studID));
									double weight = constructor.computeWeightScore(studID); // A weight variable is created to we can use it as a parameter for the computerGrade method
									System.out.println("Student's Final Letter Grade = " + constructor.computeGrade(weight));
									System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
									}
									else {
										//If -1 is returned and there is no Student ID match, the error screen shows and the user is asked to enter another code
										System.out.println("Student with ID: " + studID + " does NOT exist...");
										System.out.println("Unable to retrieve information for student with ID: " + studID);
										System.out.print("Kindly continue by entering a code a Code, from the menu above, that corresponds to your task: ");
									}
								}
								else 
								{
									//Else statement for if the user doesn't enter a valid integer
							System.out.println("Error: Your input/entry for 'Student ID' is not a valid integer. Kindly retry again!");
							System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
							String a =scanner.next(); // We are asking for a String input here so the input is compatible with the loop and if loops correctly after the input
								}
						}
			// If the user enters 127
				else if (byteinp == 127) { 
					constructor.classReportCard(); // The classReportCard method is called on
					System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
								}
			// If the user enters a number that isn't between -128 and 127, an error message will pop up
				else if (scanner.hasNextInt()) { 
					System.out.println
					("Error: Your input/entry is not a valid integer between -128 and 127. Kindly retry again! ");
				}
			// If the user enters a 0, the exit message will show
				else if (byteinp == 0) {
					System.out.println("Thank you for patronizing or Simple Classroom Management System.");
				}
		
	}
	}
	}
	else // If the original input isn't an integer, this message will show
	{
		System.out.println("Error: Your input/entry for 'MaxClassSize' is Not a valid integer. Kindly retry again!");	
		
		
	}
}
}


	class Comp248secU {
	//Variables are created for use and can be expanded later
	private static int Classsize;
	private static boolean sizebool;
	private static String semester;
	private static String room;
	private static String iFname;
	private static String iLname;
	public static String[] studFname;
	public static String[] studLname; 
	private static int[] studID;
	private double[] assgt1;
	static int number = 0;
	

	private double[] assgt2;
	private double[] assgt3;	
	private double[] assgt4;
	private double[] labs;
	private double[] midTerm;
	private double[] finalExam;
	private static int arrIdx;
	private double[] wgtscore;
	private double[] minscore;
	private double[] maxscore;
	private double[] avgscore;
	private double[] dataArr;
	
	
	
	
	public Comp248secU( String iFname, String iLname,String room, String semester, int size) {
		iFname = iFname;
		iLname = iLname;
		semester = semester;
		room = room;
		Classsize = size;
		
		// Arrays are created for later use
		this.studID = new int [size]; 
		this.studFname = new String[size];
		this.studLname = new String[size];
		assgt1 = new double[size];
		assgt2 = new double[size];
		assgt3 = new double[size];
		assgt4 = new double[size]; 
		labs = new double[size];
		midTerm = new double[size];
		finalExam = new double[size];
		studFname=new String[size];
		studLname=new String[size];
		wgtscore = new double[size];
		//These arrays are set to index 7 to be able to account for each particular and each school related grade
		minscore = new double[7];
		maxscore = new double[7];
		avgscore = new double[7];
		dataArr = new double[7];

	}
	
	

//Methods to find particular attributes so we can have them imputed into the program
public int findid(int StudentID)
{
	int i=getStudentIdx(StudentID);
	return studID[i];
}

public double findass1(int StudentID)
{
	int i=getStudentIdx(StudentID);
	return assgt1[i];
}
public double findass2(int StudentID)
{
	int i=getStudentIdx(StudentID);
	return assgt2[i];
}
public double findass3(int StudentID)
{
	int i=getStudentIdx(StudentID);
	return assgt3[i];
}
public double findass4(int StudentID)
{
	int i=getStudentIdx(StudentID);
	return assgt4[i];
}
public double findcumlabs(int StudentID)
{
	int i=getStudentIdx(StudentID);
	return labs[i];
	
}
public double findmidterm(int StudentID)
{
	int i=getStudentIdx(StudentID);
	return midTerm[i];
}
public double findfinal(int StudentID)
{
	int i=getStudentIdx(StudentID);
	return finalExam[i];
}
public double findweight(int StudentID)
{
	int i=getStudentIdx(StudentID);
	return wgtscore[i];
}

/*An addStudent method whose purpose, when called in the main method, is to take the input from the user: first name, 
 *last name, and Student ID, and to insert them into the corresponding array. An if-else statement is used to confirm
 *that the student which is being added does not go over the limit of the class size*/
 
	public void addStudent(String fname, String lname, int studID, int arrIdx) {
		
		if (arrIdx >= this.Classsize) { // If the user goes to enter a student and that student goes over the limit, it will notify the user that the class if full
			System.out.println("Student with ID " + studID + " CANNOT be added. Class is already FULL");
		} else {
			//This calls the initialized but null arrays and adds each value to its corresponding array.
			//The array index puts a size on the array in which it cannot exceed
			this.studFname[arrIdx] = fname;
			this.studLname[arrIdx] = lname;
			this.studID[arrIdx] = studID;
			number++;
			
			System.out.println("Student with ID: " + studID + " added successfully");
		}
	}
	
	// A getStudentIdx method is created to find the correct index of the student that has been entered
	  public int getStudentIdx(int studID) {
		  int j = -1;
		  for (int i = 0; i < this.studID.length; i++) { // for loop to circle through student ID's until there is a match
			  //If there is a match, j then becomes the value of i, which would be the index number of the matched student ID
			  if (studID == this.studID[i])
			  {
				  j = i;
				  break;
			  }
		  }
	    if (j==-1)
	    {
	    	return -1; // In the main method, it is stated that if the method returns -1, then the studID does not exist since there was not a match.
	    }
	    
	   else {
		return j; 
	       }
	  }
	  // A 
	    public String getStudentInfo(int studID) 
	    {
	    	getStudentIdx(studID);
	    	int i = getStudentIdx(studID); // The variable i becomes the index of the corresponding studID
	    	
	    	// A string including the necessary variables are returned
	    	return "Students First Name: " + this.studFname[i] + "\nStudents Last Name: " + this.studLname[i] + "\nStudent's ID Number: " + this.studID[i] + 
	    			"\nScore in  Assignment 1: " + this.assgt1[i] + "\nScore in  Assignment 2: " + this.assgt2[i] + "\nScore in  Assignment 3: " + this.assgt3[i] + "\nScore in  Assignment 4: " + this.assgt4[i] +
	    			"\nCummulative Score in Labs = " + this.labs[i] + "\nMid-Term Test Score = " + this.midTerm[i] + "\nFinal Examination Score = " + this.finalExam[i] +
	    			"\nKindly continue by entering a Code, from the menu above, that corresponds to your task: " ;
	        
	    }
	// This method
	    public int delStudent(int studID) {
	    	int i = getStudentIdx(studID);
	    	for(int c = i;c <Classsize-1; c++)
	    	{
	    		// Since a student is being deleted, each student's particulars and grades are moved an index up to maintain their original position in the class list
	    		this.studFname[c]=this.studFname[c+1];
	    		this.studLname[c]=this.studLname[c+1];
	    		this.studID[c]=this.studID[c+1];
	    		this.assgt1[c]=this.assgt1[c+1];
	    		this.assgt2[c]=this.assgt2[c+1];
	    		this.assgt3[c]=this.assgt3[c+1];
	    		this.assgt4[c]=this.assgt4[c+1];
	    		this.labs[c]=this.labs[c+1];
	    		this.midTerm[c]=this.midTerm[c+1];
	    		this.finalExam[c]=this.finalExam[c+1];

	    
	    	}
	  Classsize--; // When this method is called upon, the Classsize variable is decreased so we maintain an accurate class size
	  number--;
	    			return 0;
	    		}
	    
	    //When this method is called upon, the user is allowed to update both the first and last name to their choosing
	    public int updateStudentPart(String fname, String lname, int studID) {
	    	
	    	   int i = getStudentIdx(studID); // i is initialized as the index of the corresponding studID
	     
	    		this.studFname[i]= fname;
	    		this.studLname[i]= lname;
	    		return 0;
	    		
	    
	    }
	    //When this method is called upon, the user is allowed to update Assignment 1-4 to their choosing

	    public int updateAssgtScore(double a1, double a2, double a3, double a4, int studID) 
	    {
	    	   int i = getStudentIdx(studID); // i is initialized as the index of the corresponding studID
	    	   this.assgt1[i]=a1;
	    	   this.assgt2[i]=a2;
	    	   this.assgt3[i]=a3;
	    	   this.assgt4[i]=a4;

	    	
	        return 0;
	    }
	  
	    public int updateOtherScore(double lab, double test, double exam, int studID) {
	    	  int i = getStudentIdx(studID); // i is initialized as the index of the corresponding studID
	    	  // The user inputs the lab, test and exam scores and the method then inserts them into the array
	    	  this.labs[i]=lab;
	    	  this.midTerm[i]=test;
	    	  this.finalExam[i]=exam;
			
	        return 0;
	    }
	// This method computes the weighted score and displays it when called upon
	    public double computeWeightScore(int studID) {
	    	  int i = getStudentIdx(studID); // i is initialized as the index of the corresponding studID
	    	  /*The assignment associated with the corresponding index is multiplied by the corresponding weighted
	    	   *percentage and then added together to give the weighted grade*/
	    	double ass1=assgt1[i]*0.02;
	    	double ass2=assgt2[i]*0.03;
	    	double ass3=assgt3[i]*0.05;
	    	double ass4=assgt4[i]*0.08;
	    	double lb=labs[i]*.12;
	    	double mid = midTerm[i]*.30;
	    	double fin = finalExam[i]*.40;
	    	// The indexed weighted score variable is initialized as the weighted score
	    	wgtscore[i] = ass1+ass2+ass3+ass4+lb+mid+fin;
	    	return ass1+ass2+ass3+ass4+lb+mid+fin;
	    	
	       
	    }
	    	
	     
// This method references the weighted score and returns the correct letter grade associated with the score
	    public static char computeGrade(double wgtscore) {
	    	if (wgtscore>=88)
	    	{
	       return 'A';
	    	}
	    	else if (wgtscore>=80)
	    	{
	    		return 'B';
	    	}
	    	else if (wgtscore>=67)
	    	{
	    		return 'C';
	    	}
	    	else if (wgtscore>=60)
	    	{
	    		return 'D';
	    	}
	    	else {
	    		return 'F';
	    	}
	    }
	    
	    // This method runs a loop in order to find the minimum score
	    public static double findMin(double[] dataArr) {
	    	double min = dataArr[0];
	    	for (int i = 0; i < number; i++) {
	    		if (min>dataArr[i]) { // If statement to show if
	    			min=dataArr[i];
	    		}
	    	}
	        return min;
	    }
	 // This method finds the maximum value of whatever array the method is being used for
	    public static double findMax(double[]dataArr) {
	    	double max = dataArr[0];
	    	for (int i = 0; i < number; i++) {
	    		if (max<dataArr[i]) {
	    			max=dataArr[i];
	    		}
	    	}
	    	return max;
	    }
		 // This method finds the average value of whatever array the method is being used for
	    public static double findAvg(double[]dataArr) {
	    	double total = 0;
	    	for(int i = 0; i < number; i++) {
	    		total += dataArr[i];
	    	}
	    	double avg = total/number;
	        return avg;
	    }
	// Method created to find the Class minimum
	    public double[] getClassMin() {
	    	
	    	// Setting each index of the minscore array to the lowest score of the corresponding assignment, lab, midterm or final
	    	minscore[0]=findMin(assgt1);
	    	minscore[1]=findMin(assgt2);
	    	minscore[2]=findMin(assgt3);
	    	minscore[3]=findMin(assgt4);
	    	minscore[4]=findMin(labs);
	    	minscore[5]=findMin(midTerm);
	    	minscore[6]=findMin(finalExam);
	    	return minscore;
	    	    }
		// Method created to find the Class maximum
	    public double[] getClassMax() {
	    	// Setting each index of the maxscore array to the lowest score of the corresponding assignment, lab, midterm or final
	    	maxscore[0]=findMax(assgt1);
	    	maxscore[1]=findMax(assgt2);
	    	maxscore[2]=findMax(assgt3);
	    	maxscore[3]=findMax(assgt4);
	    	maxscore[4]=findMax(labs);
	    	maxscore[5]=findMax(midTerm);
	    	maxscore[6]=findMax(finalExam);
	    	return maxscore;
	    }
		// Method created to find the Class average
	    public double[] getClassAvg() {
	    	avgscore[0]=findAvg(assgt1);
	    	avgscore[1]=findAvg(assgt2);
	    	avgscore[2]=findAvg(assgt3);
	    	avgscore[3]=findAvg(assgt4);
	    	avgscore[4]=findAvg(labs);
	    	avgscore[5]=findAvg(midTerm);
	    	avgscore[6]=findAvg(finalExam);

	    	return avgscore;
	    }
	   // Method that brings up the Class Report Cart
	    public void classReportCard() {
	  
			System.out.println("Displaying Class Report Card...");
			System.out.println("-------------------------------");
			System.out.printf("%-107s%n","--------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-15s %-15s %-8s %6s %9s %9s %9s %9s %9s %9s %9s %1s%n", "First Name","Last Name" ,"Stud. ID", "A1", "A2" , "A3", "A4", "Labs","Test", "Exam","Wgt.", "*");
			System.out.printf("%-107s%n","--------------------------------------------------------------------------------------------------------------");
	

			//  // If the index of the studFname array isn't null, each student's particular's and scores will be displayed
			for (int i = 0; i < studFname.length; i++) {
				if (studFname[i] != null) {
					double wgt = computeWeightScore(studID[i]);
					char lgrade = computeGrade(wgt);
					System.out.println(studFname[i] + "\t\t" + 
							studLname[i] + "\t\t" +
							studID[i] + "\t\t" +
							assgt1[i] + "\t" +
							assgt2[i] + "\t" +
							assgt3[i] + "\t" +
							assgt4[i] + "\t" +
							labs[i] + "\t" +
							midTerm[i] + "\t" +
							finalExam[i] + "\t" +
							wgt + "\t" +
							lgrade);
				}
			}
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			// Creating double arrays for the Class minimum, average and maximum. Then setting them to the corresponding method and printing them out
			double[] min = getClassMin();
			double[] avg = getClassAvg();
			double[] max = getClassMax();
			System.out.println("\t\tMinimum Score in Class:\t\t" + min[0]+ "\t" + min[1] + "\t"
					+ min[2] + "\t" + min[3] + "\t" + min[4] + "\t" + min[5] + "\t" + min[6]);
			System.out.println("\t\tAverage Score in Class:\t\t" + avg[0]+ "\t" + avg[1] + "\t"
					+ avg[2] + "\t" + avg[3] + "\t" + avg[4] + "\t" + avg[5] + "\t" + avg[6]);
			System.out.println("\t\tMaximum Score in Class:\t\t" + max[0]+ "\t" + max[1] + "\t"
					+ max[2] + "\t" + max[3] + "\t" + max[4] + "\t" + max[5] + "\t" + max[6]);
			System.out.printf("%-107s%n","--------------------------------------------------------------------------------------------------------------");

			
		}
	    	
			
		}
	



