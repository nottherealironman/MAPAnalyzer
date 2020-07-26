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
public class Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creating object of MAPAnalyser class
        MAPAnalyser a = new MAPAnalyser();
        /* Creating object of View class and passing MAPAnalyser 
        object as parameter to constructor of View class*/
        View v = new View(a);
        // Invoking commandloop method to display menu
        v.commandLoop();
        
    }
    
}
