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
    private static final int MAX_TASKS = 100;
    private String[][] taskDataArray;
    private int Task_Number;
    private String[] Task_Duration;
    private int Task_Counter;
    private String[] Task_Name;
    private String[] Task_Description;
    private String[] Developer_Details;
    private int[] Task_Status;
    private String[] Task_ID;
    private String[] User_Options = {"To do", "Done", "Doing"};
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
    
    String Foxtrot = Character.toString(Task_Name[getTask_Counter()]
            .charAt(1));
    
    String Delta = Character.toString(Developer_Details[getTask_Counter()]
    .length() -3);
    
    String Zeke = Character.toString(Developer_Details[getTask_Counter()]
    .length() -2);
    
    String Nova = Character.toString(Developer_Details[getTask_Counter()]
    .length() -1);
    
    return Alpha.toUpperCase()+ Foxtrot.toUpperCase()+":"+ Task_Counter+
            Delta.toUpperCase()+ Zeke.toUpperCase()+ Nova.toUpperCase();
}
        
    public TaskClass() {
        taskDataArray = new String[MAX_TASKS][6];
    }
    private void addTaskDetails() {
        try {
          
            taskDataArray[Task_Counter][0] = Task_Name[Task_Counter];
            taskDataArray[Task_Counter][1] = Developer_Details[Task_Counter];
            taskDataArray[Task_Counter][2] = Task_ID[Task_Counter];
            taskDataArray[Task_Counter][3] = Task_Duration[Task_Counter];
            taskDataArray[Task_Counter][4] = User_Options[Task_Status[Task_Counter]];
            taskDataArray[Task_Counter][5] = Task_Description[Task_Counter];

            // Increment task counter
            setTask_Counter(getTask_Counter() + 1);

        } catch(ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, 
                "Maximum number of tasks reached!", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // New methods for searching and managing tasks
    public void searchByDeveloperName(String developerName) {
        StringBuilder results = new StringBuilder();
        boolean found = false;
        
        for (int i = 0; i < Task_Counter; i++) {
            if (taskDataArray[i][1].equalsIgnoreCase(developerName)) {
                results.append(formatTaskDetails(i));
                found = true;
            }
        }
        
        displaySearchResults(found, results.toString());
    }

    public void searchByTaskName(String taskName) {
        StringBuilder results = new StringBuilder();
        boolean found = false;
        
        for (int i = 0; i < Task_Counter; i++) {
            if (taskDataArray[i][0].equalsIgnoreCase(taskName)) {
                results.append(formatTaskDetails(i));
                found = true;
            }
        }
        
        displaySearchResults(found, results.toString());
    }

    public void searchByTaskDuration(String duration) {
        StringBuilder results = new StringBuilder();
        boolean found = false;
        
        for (int i = 0; i < Task_Counter; i++) {
            if (taskDataArray[i][3].equalsIgnoreCase(duration)) {
                results.append(formatTaskDetails(i));
                found = true;
            }
        }
        
        displaySearchResults(found, results.toString());
    }

    public void searchByTaskStatus(String status) {
        StringBuilder results = new StringBuilder();
        boolean found = false;
        
        for (int i = 0; i < Task_Counter; i++) {
            if (taskDataArray[i][4].equalsIgnoreCase(status)) {
                results.append(formatTaskDetails(i));
                found = true;
            }
        }
        
        displaySearchResults(found, results.toString());
    }

    public void deleteTask(String taskName) {
        for (int i = 0; i < Task_Counter; i++) {
            if (taskDataArray[i][0].equalsIgnoreCase(taskName)) {
                // Shift tasks to fill the gap
                for (int j = i; j < Task_Counter - 1; j++) {
                    taskDataArray[j] = taskDataArray[j + 1];
                    Task_Name[j] = Task_Name[j + 1];
                    Developer_Details[j] = Developer_Details[j + 1];
                    Task_ID[j] = Task_ID[j + 1];
                    Task_Duration[j] = Task_Duration[j + 1];
                    Task_Status[j] = Task_Status[j + 1];
                    Task_Description[j] = Task_Description[j + 1];
                }
                
                // Decrement task counter
                Task_Counter--;
                
                JOptionPane.showMessageDialog(null, 
                    "Task deleted successfully!", 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        
        JOptionPane.showMessageDialog(null, 
            "Task not found!", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }

    private String formatTaskDetails(int index) {
        return "Task Name: " + taskDataArray[index][0] + "\n" +
               "Developer: " + taskDataArray[index][1] + "\n" +
               "Task ID: " + taskDataArray[index][2] + "\n" +
               "Duration: " + taskDataArray[index][3] + "\n" +
               "Status: " + taskDataArray[index][4] + "\n" +
               "Description: " + taskDataArray[index][5] + "\n\n";
    }

    private void displaySearchResults(boolean found, String results) {
        if (found) {
            JOptionPane.showMessageDialog(null, 
                results, 
                "Search Results", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, 
                "No matching tasks found.", 
                "Search Results", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void displayFullReport() {
        if (Task_Counter == 0) {
            JOptionPane.showMessageDialog(null, 
                "No tasks have been added yet!", 
                "Task Report", 
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder fullReport = new StringBuilder
        ("Full Task Report:\n\n");
        for (int i = 0; i < Task_Counter; i++) {
            fullReport.append("Task #").append(i + 1).append("\n");
            fullReport.append(formatTaskDetails(i));
            fullReport.append("-------------------\n");
        }

        JOptionPane.showMessageDialog(null, 
            fullReport.toString(), 
            "Full Task Report", 
            JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayMenu() {
        boolean running = true;
        
        while(running) {
            String menu = "Choose an option:\n\n"
                    + "1. Add Task Details\n"
                    + "2. Search by Developer Name\n"
                    + "3. Search by Task Name\n"
                    + "4. Search by Task Duration\n"
                    + "5. Search by Task Status\n"
                    + "6. Delete Task\n"
                    + "7. Display Full Report\n"
                    + "8. Exit";
            
            String choice = JOptionPane.showInputDialog
             (null, menu);
            
            if(choice != null) {
                switch(choice) {
                    case "1":
                        addTaskDetails();
                        break;
                    case "2":
                        searchByDeveloperName(
                                JOptionPane.showInputDialog(
                                        "Enter Developer Name:"));
                        break;
                    case "3":
                        searchByTaskName(JOptionPane.showInputDialog(
                                "Enter Task Name:"));
                        break;
                    case "4":
                        searchByTaskDuration(JOptionPane.showInputDialog
                         ("Enter Task Duration:"));
                        break;
                    case "5":
                        searchByTaskStatus(JOptionPane.showInputDialog(
                                "Enter Task Status:"));
                        break;
                    case "6":
                        deleteTask(JOptionPane.showInputDialog(
                                "Enter Task Name to Delete:"));
                        break;
                    case "7":
                        displayFullReport();
                        break;
                    case "8":
                        int confirm = JOptionPane.showConfirmDialog
                         (null, 
                            "Are you sure you want to exit?", 
                            "Exit Confirmation", 
                            JOptionPane.YES_NO_OPTION);
                        if(confirm == JOptionPane.YES_OPTION) {
                            running = false;
                            JOptionPane.showMessageDialog(null,
                                    "Goodbye!");
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, 
                            "Invalid option. Please choose 1-8.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                running = false;
            }
        }
    }
}