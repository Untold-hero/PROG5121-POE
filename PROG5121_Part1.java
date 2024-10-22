/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog5121_part1;
import javax.swing.JOptionPane;



/**
 *
 * @author RC_Student_lab
 */
public class PROG5121_Part1 {
    
     



    public static void main(String[] args) {
        
        LoginClass LOG = new LoginClass();
        TaskClass Tasks = new TaskClass();
        
      
        Tasks.setTask_Number(10); // Set maximum number of tasks
        Tasks.setTask_Counter(0); // Initialize counter
        Tasks.displayMenu();
     
  }
}
