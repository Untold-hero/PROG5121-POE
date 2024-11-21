/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog5121_part1;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**  
 *
 * @author RC_Student_lab
 */ 
public class LoginClass {


    public String Call() {
        
        Scanner Reader = new Scanner(System.in);
        
        String Firstname;
        String Lastname;
        String Username;
        String Password;
        
        System.out.println("Please enter your first name: ");
        Firstname = Reader.nextLine();
        System.out.println("Please enter your last name: ");
        Lastname = Reader.nextLine();
        System.out.println("Please enter a user name: ");
        Username = Reader.nextLine();
        System.out.println("Please enter a password: ");
        Password = Reader.nextLine(); 
        System.out.println("=========DATA CAPTURING PROCESS===========");
        
        
        if(CheckUsername(Username)==true){
            
            System.out.println("Username Captured");
        }
        else{
            System.out.println("Username is "
                    + "not correctly formatted , please ensure that your "
                    + "username contains a underscore and is no more than 5 "
                    + "characters in length");
        }
        
       
           if(CheckPassword(Password)== true){
            System.out.println("Password Captured");
        }
           else{
               System.out.println("Password is "
                    + "not correctly formatted , please ensure that your "
                    + "password contains 8 characters , a capital , a number "
                    + "and a special character");
           }
           
           System.out.println("==============lOGIN PROCESS============");
           
           String LoginUsername;
           String LoginPassword;
           System.out.println("Please enter your user name: ");
           LoginUsername = Reader.nextLine();
           System.out.println("Please enter your password: ");
           LoginPassword = Reader.nextLine();
           
           if(CheckLoginUsername(LoginUsername)== true){
               
               System.out.println("Welcome back! its great"
                       + " to see you again "+ Firstname + Lastname);
           }
           
           else if(CheckLoginUsername(LoginUsername)==false){
               
               System.out.println("Username or password is incorrect "
                       + "please try again later");
           }
           
           if(CheckLoginPassword(LoginPassword)==true){
               
           }
           else if(CheckLoginPassword(LoginPassword)== false){
               
                System.out.println("Username or password is incorrect "
                       + "please try again later");
           }
           
           System.out.println("===========OUTPUT============");
        return null;
    }

    
    public static boolean CheckUsername(String Username){
        
        return Username.length()<=5;
      
      }
    public static boolean CheckPassword(String Password){
        int length = Password.length();
        
        if(length<=8){
            return true;
           
        }
        
        boolean hasNum = false;
        boolean hasCap = false;
        boolean hasLower = false;
        char C;
        
        for(int i =0;i<Password.length(); i++){
            C=Password.charAt(i);
            if(Character.isDigit(C)){
                hasNum = true;
            }
            else if(Character.isUpperCase(C)){
                hasCap =true;
            }
            else if(Character.isLowerCase(C)){
                hasLower = true;
            }
            if(hasNum){
                return true;
            }
            else if(hasCap){
                return true;
            }
            else if(hasLower){
                return true;
            }
        }
    Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z0-9])[a-zA-Z0-9_]+$");
    Matcher matcher = pattern.matcher(Password);
       
         return matcher.matches();
         
         
    }
    
    
       public static boolean CheckLoginUsername(String LoginUsername){
        
           return LoginUsername.length()<=5;
      
      }
    public static boolean CheckLoginPassword(String LoginPassword){
        int length = LoginPassword.length();
        
        if(length<=8){
            return true;
           
        }
        
        boolean hasNum = false;
        boolean hasCap = false;
        boolean hasLower = false;
        char C;
        
        for(int i =0;i<LoginPassword.length(); i++){
            C=LoginPassword.charAt(i);
            if(Character.isDigit(C)){
                hasNum = true;
            }
            else if(Character.isUpperCase(C)){
                hasCap =true;
            }
            else if(Character.isLowerCase(C)){
                hasLower = true;
            }
            if(hasNum){
                return true;
            }
            else if(hasCap){
                return true;
            }
            else if(hasLower){
                return true;
            }
        }
    Pattern spattern = Pattern.compile("^(?=.*[a-zA-Z0-9])[a-zA-Z0-9_]+$");
    Matcher smatcher = spattern.matcher(LoginPassword);
       
         return smatcher.matches();
         
         
    }
   
}
