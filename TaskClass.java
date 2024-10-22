/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog5121_part1;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class TaskClass {
    
    private int Task_Number;
    private String [] Task_Duration;
    private int Task_Counter;
    private String [] Task_Name;
    private String [] Task_Description;
    private String [] Developer_Details;
    private int [] Task_Status;
    private String [] Task_ID;
    private String [] User_Options = {"To do","Done","Doing"};
    private String User_input;
    private int Hours;
   
    public String getUser_input(){
       
        return User_input;
    }
    
    public void setUser_input(String User_input){
        
        this.User_input = User_input;
    }
    
    public int getTask_Counter(){
        return Task_Counter;
    }
    
    public void setTask_Counter(int Task_Counter){
        
        this.Task_Counter = Task_Counter;
        
    }
    
    public String[]getUser_Options(){
        
        return User_Options;
    }
    
    public void setUser_Option(String[] User_Options){
        this.User_Options = User_Options;
    }
    
    public int getHours(){
        return Hours;
    }
    
    public void setHours(int Hours){
        this.Hours = Hours;
    }
    
    public String[] getTask_Duration(){
        return Task_Duration;
    }
    
    public void setTask_Duration(String[] Task_Duration){
        this.Task_Duration = Task_Duration;
    }
    
    public int getTask_Number(){
        return Task_Number;
    }
    
    public void setTask_Number(int Task_Number){
        this.Task_Number = Task_Number;
        this.Task_Name = new String [Task_Number];
        this.Task_Description = new String[Task_Number];
        this.Task_ID = new String[Task_Number];
        this.Task_Status =  new int[Task_Number];
        this.Developer_Details = new String[Task_Number];
        this.Task_Duration = new String[Task_Number];
    }
    
    public String[]getTask_Name(){
        return Task_Name;
    }
    
    public void setTask_Name(String[]Task_Name){
        this.Task_Name = Task_Name;
    }
    
    public String[]getTask_Descript(){
        return Task_Description;
    }
    
    public void setTask_Descript(String[]Task_Descript){
        this.Task_Description = Task_Descript;
    }
    
    public String[]getTaskID(){
        return Task_ID;
    }
    
    public void setTaskID(String[]Task_ID){
        this.Task_ID = Task_ID;
    }
    
    public int[]getTask_Status(){
        return Task_Status;
    }
    
    public void setTask_Status(int[] Task_Status){
        this.Task_Status = Task_Status;
    }
    
    public String[] getDeveloper_Details(){
        return Developer_Details;
    }
    
    public void setDeveloper_Details(String[]Developer_Details){
        this.Developer_Details = Developer_Details;
    }
    
    public boolean CheckDescript(String Descript){
        return Descript.length()<=50 && Descript.length() > 0;
    }
    
    public String CheckID(){
        
        String Alpha = Character.toString(Task_Name[getTask_Counter()]
                .charAt(0));
        
        String Foxtrot = Character.toString(Task_Name[getTask_Counter()].
                charAt(1));
        
        String Delta = Character.toString(Developer_Details[getTask_Counter()]
        .length() -3);
        
        String Zeke = Character.toString(Developer_Details[getTask_Counter()]
        .length() -2);
        
        String Nova = Character.toString(Developer_Details[getTask_Counter()]
        .length() -1);
        
        return Alpha.toUpperCase()+ Foxtrot.toUpperCase()+":"+ Task_Counter+
                Delta.toUpperCase()+ Zeke.toUpperCase()+ Nova.toUpperCase();
        
    }
    
    public String ShowingTaskDetails(){
        return "Status: " + User_Options[Task_Status[getTask_Counter()]]
        + "Developer:" + Developer_Details[getTask_Counter()]
        + "Task Number:" + getTask_Counter()
        + "Task Name: " + Task_Name[getTask_Counter()]
        + "Task Description: " + Task_Description[getTask_Counter()]
        + "Task Duration: " + Task_Duration[getTask_Counter()]
        + "Task Id Number" + CheckID();
    }
    public int Hours(){
        
        return Hours;
    }
     public void displayMenu() {
        boolean running = true;
        
        while(running) {
            String menu = "Choose an option:\n\n"
                    + "1. Add Task Details\n"
                    + "2. Display Task Report\n"
                    + "3. Exit";
            
            String choice = JOptionPane.showInputDialog(null, menu);
            
            if(choice != null) {
                switch(choice) {
                    case "1":
                        addTaskDetails();
                        break;
                    case "2":
                        displayTaskReport();
                        break;
                    case "3":
                        int confirm = JOptionPane.showConfirmDialog(null, 
                            "Are you sure you want to exit?", 
                            "Exit Confirmation", 
                            JOptionPane.YES_NO_OPTION);
                        if(confirm == JOptionPane.YES_OPTION) {
                            running = false;
                            JOptionPane.showMessageDialog(null, "Goodbye!");
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, 
                            "Invalid option. Please choose 1, 2, or 3.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                running = false;
            }
        }
    }

    private void addTaskDetails() {
        try {
            // Get task name
            String taskName = JOptionPane.showInputDialog("Enter Task Name:");
            if(taskName == null) return;
            Task_Name[getTask_Counter()] = taskName;

            // Get developer details
            String devDetails = JOptionPane.showInputDialog("Enter Developer Details:");
            if(devDetails == null) return;
            Developer_Details[getTask_Counter()] = devDetails;

            // Get task description
            String taskDesc = JOptionPane.showInputDialog("Enter Task Description:");
            if(taskDesc == null) return;
            if(!CheckDescript(taskDesc)) {
                JOptionPane.showMessageDialog(null, 
                    "Description must be between 1 and 50 characters!", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            Task_Description[getTask_Counter()] = taskDesc;

            // Get hours duration
            String hoursStr = JOptionPane.showInputDialog("Enter Task Duration (hours):");
            if(hoursStr == null) return;
            try {
                setHours(Integer.parseInt(hoursStr));
                Task_Duration[getTask_Counter()] = hoursStr + " hours";
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, 
                    "Please enter a valid number for hours!", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Set task status
            String status = (String) JOptionPane.showInputDialog(
                null,
                "Select Task Status:",
                "Task Status",
                JOptionPane.QUESTION_MESSAGE,
                null,
                User_Options,
                User_Options[0]
            );
            if(status == null) return;
            for(int i = 0; i < User_Options.length; i++) {
                if(User_Options[i].equals(status)) {
                    Task_Status[getTask_Counter()] = i;
                    break;
                }
            }

            // Generate and set Task ID
            Task_ID[getTask_Counter()] = CheckID();

            JOptionPane.showMessageDialog(null, 
                "Task added successfully!", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);

            // Increment task counter
            setTask_Counter(getTask_Counter() + 1);

        } catch(ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, 
                "Maximum number of tasks reached!", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayTaskReport() {
        if(getTask_Counter() == 0) {
            JOptionPane.showMessageDialog(null, 
                "No tasks have been added yet!", 
                "Error", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder report = new StringBuilder("Task Report:\n\n");
        
        for(int i = 0; i < getTask_Counter(); i++) {
            report.append("Task #").append(i + 1).append("\n");
            report.append("-------------------\n");
            report.append("Task ID: ").append(Task_ID[i]).append("\n");
            report.append("Task Name: ").append(Task_Name[i]).append("\n");
            report.append("Developer: ").append(Developer_Details[i]).append("\n");
            report.append("Description: ").append(Task_Description[i]).append("\n");
            report.append("Duration: ").append(Task_Duration[i]).append("\n");
            report.append("Status: ").append(User_Options[Task_Status[i]]).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, 
            report.toString(), 
            "Task Report", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}
    
    

