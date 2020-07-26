/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author acer
 */
public class Record {
    // Member variable declarations
    private String id; // student id declaration
    private int sbp; // systolic blood pressure declaration
    private int dbp; // diostolic blood pressure declaration
    private int map; // mean arterial pressure declaration
    private String category; // map category declaration
    
    // Record constructer will inilize the value of the member variable 
    public Record(String id, int sbp, int dbp, int map, String category){
           this.id = id; //  initializing id 
           this.sbp = sbp; //  initializing sbp 
           this.dbp = dbp; //  initializing dbp
           this.map = map; //  initializing map 
           this.category = category; //  initializing category
    }
    
    // This method will format the record in specified format by concatinating variables
    public String toString(){
        return "<"+this.id+","+this.sbp+","+this.dbp+","+this.map+", "+this.category+">";
    }

    // This getter method will return the student id of current record
    public String getId(){
	return this.id;
    }

    // This getter method will return the SBP value of current record
    public int getSbp(){
	return this.sbp;
    }

    // This getter method will return the DBP value of current record
    public int getDbp(){
	return this.dbp;
    }

    // This getter method will return the MAP value of current record
    public int getMap(){
	return this.map;
    }

    // This getter method will return the category of current record
    public String getCategory(){
	return this.category;
    }
}
