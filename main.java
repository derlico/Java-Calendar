package calendare;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class Main {
    public static void main(String[] args) {
        try { //Initializing a try-catch exception loop
        	Scanner input = new Scanner(System.in);
//Prompt for output file name
        	System.out.print("Enter the output file name: ");
        	String filename= input.nextLine();
//Prompt for mandatory year input
        	System.out.print("Enter a year: ");
	        int y = input.nextInt();
//Prompt for further input (month) which is optional
	        System.out.print("Would you also like to enter a month \n 1. Yes \n 2. No \nSelect: ");
	        int x = input.nextInt();
//Instantiation of the FileWriter and PrintWriter class for file management
	        FileWriter fileWriter = new FileWriter(filename);
            try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
				switch (x){ //addressing the selections made
//Generating a one month calendar		    
				    case 1: 
				    System.out.print("Enter a month (e.g. 6): ");
				    int m = input.nextInt();
				    m = m-1;
				    int d = 1;
				    Calendar calendar = new GregorianCalendar(y, m, d); //Using the Gregorian Calendar
				    Locale.setDefault(new Locale("en","UK")); //Setting default Locale
				    calendar.set(Calendar.DAY_OF_MONTH, 1); //Setting the day of month to 1
				    calendar.setFirstDayOfWeek(Calendar.MONDAY); //Setting the first day of the week to Monday
				    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); //getting day of week for 1st month
				    int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

//Printing the header of the calendar; including month, year and day abbreviations
				    printWriter.println(new SimpleDateFormat("MMMM YYYY").format(calendar.getTime())); 
				    printWriter.println(" M  T  W  T  F  S  S ");

//Printing initial spaces before actual month first date
				    String initialSpace = "";
				    for (int i = 0; i < dayOfWeek - 2; i++) {
				        initialSpace += "   ";
				    }
				    printWriter.print(initialSpace);

//Printing the days of the month
				    for (int i = 0, dayOfMonth = 1; dayOfMonth <= daysInMonth; i++) {
				        for (int j = ((i == 0) ? dayOfWeek - 2: 0); j < 7 && (dayOfMonth <= daysInMonth); j++) {
				            printWriter.printf("%2d ", dayOfMonth);
				            dayOfMonth++;
				        }
				        printWriter.println();
				    }
//Command-line prompt to declare completion to writing file				    
				    System.out.println("File written");
				    break;
				    
//Generating a whole year calendar				    
				    case 2:
				    Calendar cal = new GregorianCalendar(); //Using the Gregorian Calendar
				    Locale.setDefault(new Locale("en","UK")); //Setting default Locale
				    cal.set(Calendar.DAY_OF_MONTH, 1); //Setting day of month to 1
				    cal.setFirstDayOfWeek(Calendar.MONDAY); //Setting the first day of the week to Monday
				    
				    for (int n=0; n<12; n++){
				        cal.set(y, n, 1);
				        int dayInWeek = cal.get(Calendar.DAY_OF_WEEK); //getting day of week for the 1st month
					    int daysMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//Printing the header of the calendar; including month, year and day abbreviations				        
					    printWriter.print(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.UK));
				        printWriter.println( " " + y);
		
				        printWriter.println(" M  T  W  T  F  S  S ");

//Printing initial spaces before actual month first date
		                              String initSpace = "";
		                              for (int k = 0; k < dayInWeek - 2; k++) {
		                                  initSpace += "   ";
		                              }
		                              printWriter.print(initSpace);

//Printing the days of each month
		                              for (int k = 0, dayOfMonth = 1; dayOfMonth <= daysMonth; k++) {
		                                  for (int l = ((k == 0) ? dayInWeek - 2: 0); l < 7 && (dayOfMonth <= daysMonth); l++) {
		                                      printWriter.printf("%2d ", dayOfMonth);
		                                      dayOfMonth++;
		                                  }
				        
				        
				        printWriter.println();
				    }
				    }
				    System.out.println("File written");
				    break;
				    default:
//Setting the system response to invalid or no input
				    printWriter.print("Selection Error!! Please rerun the program");
				    System.out.println("Selection Error!! Please rerun the program");
				        
				    }
			}
        }catch (IOException e){
        	System.out.println("An error occurred."); //Reports error in the file creation process
            e.printStackTrace();
        	
        }
    }
}

                              