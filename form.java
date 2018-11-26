//form version 1.0.1

//-------------------------------------MASTER COPY--------------------------------------------

/*Update notes
 * 
 * 
 * Changed YN()
 * got rid of .toLowerCaseand changed the .equals to .equalsIgnoreCase
 * 
 */



//Casher Haggerty Period 7
import java.util.*;
//import static java.lang.Math.*;
import java.io.*;



public class form{
   //public Math math=new Math();
   int x=10;
   static Scanner input = new Scanner(System.in);
   
   public static void errorMessage(){//prints out an error messagee
      System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      System.out.println("!! PLEASE INSERT A VALID NUMBER !!");
      System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      System.out.println("");
      System.out.println("");
   }
   
   public static String YN(){//creates a Yes/No menu used to comfirm later inputs
      Scanner input = new Scanner(System.in);
      boolean YesNo = true;
      String YN = "x";
      while(YesNo){//allows user to comfirm their value
         System.out.println("Comfirm Selection? (Y/N)");
         
      
         if (!(YN.equalsIgnoreCase("y"))&&!(YN.equalsIgnoreCase("n"))){//if the user does not input a valid option
            YesNo = true;
         }
         else{
            YesNo = false;
         }
      }//make a method that is a loop and only returns if the user puts in a valid input
      return YN.toLowerCase();
   }
   
   public void reset(){
      x=10;
   
   }

   public static String[] formString(String[] askFor){//Ask user for string vals and returns an array of entered val
      int numOfVals = askFor.length;//finds the number of item in the array that is put in(how many things are we asking three user for???
      int counter=0;//sets up a counter so we know how may time we have run theh program.
      String [] saved = new String[numOfVals];//This an array of the user's responces
      String yn;//creates a string that will save the value that the YN() meathod returns
      while(counter<numOfVals){//runs this code as many time as there are item in the array inputs when called by the program
         do{
        	 /*/ tells the user to input ________(the string will be the index of the inputed arry 
        	  * index is decide on how many valid vals have been put in by the user*/
            System.out.println("please input "+(askFor[counter])+": ");
            saved[counter]= (input.nextLine());
            yn=YN();;
            if(!(yn.equals("n"))){
               counter++;
            }
         }while(yn.equals("n"));
      }
      return saved;
      
   }
   
   public static double[] formDouble(String[] askFor){//ask for the unser to imput a double then error checks
      boolean finalVal=false;
      int counter=0;
      int numOfVals=askFor.length;
      double [] saved = new double[numOfVals];
      while(counter<numOfVals){
         finalVal=false;
         System.out.println("please input "+(askFor[counter])+": ");
         do{
            //saved[counter]
            String x= (input.nextLine());
            if(form.validDouble(x)){
               System.out.println("current "+askFor[counter]+"= "+x);
               String yn=YN();;
               if((!(yn.equals("n")))){
                  finalVal=true;
                  saved[counter]=(form.stringToDouble(x));
                  }
               else{
                  System.out.println("please input "+(askFor[counter])+": ");
               }
            }
            else{
               System.out.println("Please Insert A Valid Number");
                }
             }while(!(finalVal));
         counter++;
      }
      return saved;
   
   }

   public static String menu(String[] askfor){//takes an array and makes a menu for the user
      int menuSize= askfor.length;
      String selectedString="null";
      ArrayList<String> counterList = new ArrayList<String>();//creates a list of valid options the user can input
      int counterOne=0;
      while(counterOne<menuSize){//puts the values off the valid options into a list
         counterList.add(counterOne, Integer.toString(counterOne) );
         counterOne++;
         //Double.parseDouble(BBB.trim());
      }
      
      while(!(counterList.contains(selectedString))){
         int counterTwo = 0;
         
         System.out.println("Type the number corrisponding to the desired option");
         while(counterTwo<menuSize){
         
         
            System.out.println(counterTwo+". "+askfor[counterTwo]);
            counterTwo++;
            
         }
         System.out.println("select: ");
         selectedString=input.nextLine();
      
      }
     
      
      
      
      return selectedString;
   }

   
   
   
   
   
   
   
   
   public static boolean validDouble(String w)
   {
      boolean valid=false;
      try
      {
         double v = Double.parseDouble(w.trim());
         valid=true;
      }
      catch(NumberFormatException nfe)
      {
         valid=false;
      }
      return valid;
   }

   public static boolean validInt(String i){
      boolean valid=false;
      try
      {
         double v = Integer.parseInt(i.trim());
         valid=true;
      }
      catch(NumberFormatException nfe)
      {
         valid=false;
      }
      return valid;
   
   }
   
   public static double stringToDouble(String y){
      {
      
         try
         {
            double finalDouble = Double.parseDouble(y.trim());
            return finalDouble;
            
         }
         catch(NumberFormatException nfe)
         {
            System.out.println("ERROR TRIED TO CONVERT INVALID STRING TO DOUBLE");
            System.out.println(1);
            
            System.out.println(2);
            System.exit(0);
            return 0;
            
         }
      
      }
   }
   public static Integer stringToInt(String y){
	      {
	      
	         try
	         {
	            int finalInt = Integer.parseInt(y.trim());
	            return finalInt;
	            
	         }
	         catch(NumberFormatException nfe)
	         {
	            System.out.println("ERROR TRIED TO CONVERT INVALID STRING TO INTEGER");
	            System.out.println(1);
	            
	            System.out.println(2);
	            System.exit(0);
	            return 0;
	            
	         }
	      
	      }
	   }
   
   public static double percentOf(double percent, double x){
      percent=percent/100;
      x=x*percent;
      
      return x;
   }
   public static void space(int x) {
	   int c = 0;
	   while(c<x) {
		   System.out.println("");
		   c=c+1;
		   
	   }
   }
   
   public static double findAvg(double [] vals) {
	   int x=(vals.length);
	   int counter=0;
	   int y=0;
	   while(counter<x) {
		   y=(int) (y+(vals[counter]));
		   
		   
		   counter++;
	   }
	   return y;
   }
   
   public static ArrayList<Double> inputNums() {//allows uses to input vals without a set limit of how many can be inputed 
	   ArrayList<Double> counterList = new ArrayList<Double>();
	   int counter=0;
	   String x;
	   double xy;
	   boolean finalVal=false;
	   String yn;
	   System.out.println("Enter values then press /'x/'when all values have been entered");
	  
	   do {
	   //while(!(x.equals(""))) {
		   finalVal=false;
		   System.out.println("Val "+(counter+1)+".");
		   do {
			   
			   x=(input.nextLine());
			   if(x.equals("x")) {
				   break;
			   }
			   if(form.validDouble(x)) {
				   xy=form.stringToDouble(x);
				   System.out.println("current "+(counter+1)+"= "+x);
				   yn=YN();
				   if((!(yn.equals("n")))){
		                  finalVal=true;
		                  counterList.add(xy);
		                  }
				   else{
		                  System.out.println("please input val"+(counter+1)+": ");
				   }
			   }
		               }while((!(finalVal)));
		   
		   
		   counter=counter+1;
			  // }
	   } while(!(x.equals("x")));
		               
		   return counterList;
		   
	   }
		   
   public static double sum(ArrayList<Double> input) {
		int length = input.size();
		int counter=0;
		double sum=0;
		while(counter<length) {
			sum= sum+(input.get(counter));
			counter=counter+1;
		}
		return sum;
	}
	
	public static double average(ArrayList<Double> input ) {
		double output;
		int length = input.size();
		double r = sum(input);
		output=(r/length);
		return output;
	}
	
	public static ArrayList<String> inputString() {//allows uses to input vals without a set limit of how many can be inputed 
		   ArrayList<String> counterList = new ArrayList<String>();
		   int counter=0;
		   String x;
		   String xy="y";
		   boolean finalVal=false;
		   String yn;
		   System.out.println("Enter values then press 'x'when all values have been entered");
		  
		   do {
			   //if(!(counter==1)) {
			   finalVal=false;
			   System.out.println("List item "+(counter+1)+".");
			   do {
				   
				   x=(input.nextLine());
				   if(x.equals("x")) {
					   break;
				   }
				   
					  
					   System.out.println("Current List Item "+(counter+1)+". "+ x);
					   yn=YN();
					   if((!(yn.equals("n")))){
			                  finalVal=true;
			                  counterList.add(x);
			                  }
					   else{
			                  System.out.println("List item "+(counter+1)+".");
					   }
				   
			               }while((!(finalVal)));
			   
			   
			   counter=counter+1;
				 // }
		   } while(!(x.equals("x")));
		   
			               
			   return counterList;
			   
		   }
	///////////////////////////////////////////////////////////////////////////////SEL SORT
	public static void swap(int[] nums, int indexOne, int indexTwo) {
	
		int x=nums[indexOne];
		int y=nums[indexTwo];
		nums[indexOne]=y;
		nums[indexTwo]=x;
	}
	
	public static void selSort(int[] nums)
	{
		System.out.println(Arrays.toString(nums));
	     int min, size = nums.length;
	     for (int i=0; i < size; i++)
	     {
	            min = i;
	            for (int j = i + 1; j < size; j++)
	          {
	               if (nums[j] <nums[min])//change "<" to">" to change sort from ascending to descending
	                   min = j;
	           }
	           swap (nums, i, min);
	           System.out.println(Arrays.toString(nums));
	    }
	}
				   
	//////////////////////////////////////////////////////////////////////////////////////////
	
	public static double askForDouble(String askFor) {
		Scanner scanner = new Scanner(System.in);
		double userInput = 0;
		while (true) {
		    System.out.println(askFor);
		    try {
		        userInput = Integer.parseInt(scanner.next());
		        return userInput;
		        
		    } catch (NumberFormatException ignore) {
		        System.out.println("Invalid input");
		    }
		}
	}
	
	
	
}

