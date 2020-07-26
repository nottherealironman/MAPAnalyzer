/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.util.Scanner;
/**
 *
 * @author acer
 */
public class View {
    private MAPAnalyser result;
    
    public View(MAPAnalyser a){
        // Initilizing result with MAPAnalyser object
        result = a;
    }
    
    public void commandLoop(){
        int cmdNum, map1, map2, low, high, med;
        String id;
        /* Displaying the command options at the beginning of program execution
        I have implemented it in method to avoid coding it multiple times
        */
        this.displayOptions();
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("\nEnter your choice:");
            // cmdNum variable will store command number (first paramater of each command)
            cmdNum = input.nextInt();
        
            switch(cmdNum){
                case 0:
                    // Invoking the command options when help command is entered
                    this.displayOptions();
                    break;

                case 1:
                    // id variable will store the student id
                    id = input.nextLine();
                    // trim() method removes the space between command and student id 
                    id = id.trim();
                    // Invoking the find method of Record class to search for record of the passed student id
                    Record recSId = result.find(id);
                    // Display the record if record is found(not null)
                    if(recSId != null){
                        System.out.println("\nStudent "+id+" record found:");
                        System.out.println(recSId.toString());
                    }
                    // Display error message if record is not found
                    else{
                        System.out.println("\nStudent "+id+" record not found");
                    }
                    break;

                case 2:
                    // map1 and map2 will store the range for the record to be searched for
                    map1 = input.nextInt();
                    map2 = input.nextInt();
                    // Display error message if map1 is smaller than map2
                    if(map1 > map2){
                        System.out.println("\nMap2 should be greater than Map1");
                    }
                    // Display error message if map1 or map2 is less than 0 or greater than 200
                    else if(map1 < 0 || map1 >200 || map2 < 0 || map2 > 200){
                        System.out.println("\nMap1 and Map2 should be in the range of 0-200");
                    }
                    else{
                        /* Invoking the find method of Record class 
                        (with 2 parameters) to search for record between given map range*/
                        Record[] recRange = result.find(map1, map2);
                        // Display the record(s) if records between the range is found
                        if(recRange.length != 0){
                            System.out.println("\n"+recRange.length+" record(s) found in the range "+map1+"-"+map2+":");
                            // As the find method return the records found in an array, we need to loop to display them
                            for(int i = 0; i < recRange.length; i++)
                            {
                                System.out.printf("%s %n", recRange[i].toString()); 
                            }
                        }
                        // Display error message if record is not found
                        else{
                            System.out.println("\nNo records in this range "+map1+"-"+map2);
                        }
                    }
                    break;

                case 3:
                    /* Display lowest, highest, and median MAP values by invoking 
                    the respective method method of MAPAnalyser class*/
                    low = result.lowest();
                    high = result.highest();
                    med = result.median();
                    System.out.printf("\nLowest MAP is %d\n",low);
                    System.out.printf("Highest MAP is %d\n",high);
                    System.out.printf("Median MAP is %d\n",med);
                    break;

                case 9:
                    // Exit the program if command 9 is entered
                    System.exit(0);
                
                default:
                    System.out.println("\nPlease, enter valid choice or type 0 for HELP menu");
                    break;
            }
        }
        
    }
    
    public void displayOptions(){
        // Display the command for user interaction
        System.out.println("The following commands are recognised:");
        System.out.printf("Display this message %32s\n","> 0");
        System.out.printf("Display a specific subject record: %21s\n","> 1 id");
        System.out.printf("Display records for all subjects within the range > 2 map1 map2\n");
        System.out.printf("Display statistics (minimum, maximum and median) %4s\n","> 3");
        System.out.printf("Exit the application %32s\n","> 9");
    }
}
