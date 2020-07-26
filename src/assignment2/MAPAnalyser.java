/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author acer
 */
public class MAPAnalyser {
    private Record[] data;
    private int nRecords;
    
    public MAPAnalyser(){
        nRecords = 0;
        data = new Record[nRecords];
        // this method populate the data with array initilizers 
        this.loadFromTables();
        // this method will sort data array in ascending order by student id 
        this.sortById();
    }
    
    /* This method implement binary search to search for student records
    Implemented Binary search from "Java How to Program" by Deitel and Deitel
    */
    public Record find(String id){
        int low = 0;
        // assigning high variable to the last element of array
        int high = data.length -1;
        // calculating middle index of the array
        int middle = (low + high +1)/2;
        int location = -1;
        String currentSId;
        
        // This loop will execute till position of searched key found or till the last array element
        do{
            currentSId = data[middle].getId();
            // Checking if searched key is equal to current student Id using equals() string method
            if(id.equals(currentSId)){
                location = middle;
            }
            // Checking if searched key is less than current student Id using compareTo() string method
            else if(id.compareTo(currentSId) < 0){
                high = middle -1;
            }
            // If searched key is greater than current student Id, below statement will execute
            else{
                low = middle + 1;
            }
            // Calculating middle index again using new high and low value
            middle = (low + high +1)/2;
        }while((low <= high) && (location == -1));
        
        // Return the record if searched student Id is found 
        if(location != -1){
            return data[location];
        }
        // Return null otherwise
        else{
         return null;   
        }
    }
    
    // This method will return the lowest map value within the array
    public int lowest(){
        int low = 0;
        // Looping through the array find lowest map value
        for(int i = 0; i < data.length; i++)
        {
            // Assign low with map value of first element 
            if(low == 0){
                low = data[i].getMap();
            }
            // Assign low with current map value if it is lesser than current lower value
            else if(data[i].getMap() < low){
                low = data[i].getMap();
            }
        }
        return low;
    }
    
    // This method will return the highest map value within the array
    public int highest(){
        int high = 0;
        for(int i = 0; i < data.length; i++)
        {
            // Assign high with map value of first element 
            if(high == 0){
                high = data[i].getMap();
            }
            // Assign high with current map value if it is higher than current high value
            else if(data[i].getMap() > high){
                high = data[i].getMap();
            }
        }
        return high;
    }
    
    // This method will return the map value of middle element within the array
    public int median(){
        int median;
        // Copying elements of data array to mData array
        Record[] mData = new Record[data.length];
        System.arraycopy( data, 0, mData, 0, data.length );
        
        /* Implementing selection sort to sort new mData array by map value
        Implemented selection sort from "Java How to Program" by Deitel and Deitel
        */
        // This loop will iterate through each element of array
        for(int i=0; i < mData.length; i++){
            
            // Assign smallest with current element of array, i.e, first element in the beginning
            int smallest = i;
            /* This loop will compares the current element of array with 
            the remaining element to find the smallest element*/
            for(int j=i+1; j < mData.length; j++){
                if(mData[j].getMap() < mData[smallest].getMap()){
                    smallest = j;
                }
            }
            // Swapping the position of smallest element with the current element 
            Record rec = mData[i];
            mData[i] = mData[smallest];
            mData[smallest] = rec;
        }
        System.out.println("\nArray after sorting by MAP value in Ascending order:\n");
        for(int i = 0; i < mData.length; i++)
        {
            System.out.printf("%s %n", mData[i].toString());
        }
        int recLength = mData.length;
        // Checking if length of records if even
        if(recLength%2 == 0){
            // Median is the average of two middle value if length if even
            int median1 = mData[recLength/2].getMap();
            int median2 = mData[(recLength/2)-1].getMap();
            median = (median1 + median2)/2;
        }
        // Execute below code if length of data array is odd 
        else{
            median = mData[recLength/2].getMap();
        }
        return median;
    }
    
    // This method will return the records within the range of map1 and map2
    public Record[] find(int map1, int map2){
        // Declaring Arraylist of type records since we won't know the length of records within the range
        ArrayList<Record> rList = new ArrayList<Record>();
        for(int i = 0; i < data.length; i++)
        {
            // Checking if records within the range of map1 and map2
            if(data[i].getMap() >= map1 && data[i].getMap() <= map2){
               // Add the records to arraylist if within the range
               rList.add(data[i]);
            }
        }
        // Declaring the size of array as length of arraylist
        Record[] rec = new Record[rList.size()];
        // This method will convert arraylist to array  
        rList.toArray(rec);
        return rec;
    }
    
    /*This method will sort the array by ascending order of Student Id using Selection sort
    Implemented selection sort from "Java How to Program" by Deitel and Deitel*/
    private void sortById(){
        // This loop will iterate through each element of array
        for(int i=0; i < data.length; i++){
            // Assign smallest with current element of array, i.e, first element in the beginning
            int smallest = i;
            /* This loop will compares the current element of array with 
            the remaining element to find the smallest element*/
            for(int j=i+1; j < data.length; j++){
                if(data[j].getId().compareTo(data[smallest].getId()) < 0){
                    smallest = j;
                }
            }
            // Swapping the position of smallest element with the current element 
            Record rec = data[i];
            data[i] = data[smallest];
            data[smallest] = rec;
        }
    }
    
    // This method will load the data array with static records
    private void loadFromTables(){
        // Initilizing id, sbp and dbp with static values
        String[] id = {"S02", "S04", "S01", "S03", "S06", "S05"};
        int[] sbp = {120, 100, 130, 110, 90, 80};
        int[] dbp = {90, 80, 90, 60, 40, 70};
        
        // Declaring the size of array as length of id array
        nRecords = id.length;
        data = new Record[nRecords];
        int mapVal;
        String category;
        
        // Creating array of records by calculating map value and classifying its category
        for(int i=0; i < nRecords; i++){
            // Calculate MAP value using given formula
            mapVal = (int)(1.0/3.0 * sbp[i] + 2.0/3.0 * dbp[i]);
            // Invoking classify method to classify the category of map value
            category = this.classify(mapVal);
            // Assigning records to data array of type records
            data[i] = new Record(id[i], sbp[i], dbp[i], mapVal, category);
        }
    }
    
    /* This method will return the blood pressure level 
    based on given MAP value */
    private String classify(int map){
        String mapCategory;
        // If MAP value is greater than 100 then it is high
        if(map > 100){
            mapCategory = "high";
        }
        // If MAP value is lesser than 70 then it is low
        else if(map < 70){
            mapCategory = "low";
        }
        // If MAP value is in between 70 and 100 then it is normal
        else{
            mapCategory = "normal";
        }
        return mapCategory;
    }
    
}
