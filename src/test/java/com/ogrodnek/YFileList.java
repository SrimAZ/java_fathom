package com.ogrodnek;

// Java program to print all files
// in a folder(and sub-folders)
 
import java.io.File;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import com.ogrodnek.lingua.en.FathomTest;


public class YFileList extends FathomTest {

    FathomTest t1 = new FathomTest();

    public static void readgivenfile(String fName){
        String finData = "";
        System.out.println("The File Name passed is: "+fName);
        File myObj = new File("src/testFiles/A/10-K/0000013573-06-000015/full-submission.txt");
        Scanner myReader;
        try {
            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                finData += data;
            }    
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void RecursivePrint(File[] arr, int index, int level)
    {   
        String[] fileList; 
        // terminate condition
        if (index == arr.length)
            return;
 
        // tabs for internal levels
        for (int i = 0; i < level; i++)
            System.out.print("\t");
 
        // for files
        if (arr[index].isFile())
            //System.out.println("End File: "+ arr[index].getName());            
            readgivenfile(arr[index].getName());
           

        // for sub-directories
        else if (arr[index].isDirectory()) {
            
            System.out.println("[" + arr[index].getName()
                               + "]");

            // recursion for sub-directories
            RecursivePrint(arr[index].listFiles(), 0,
                           level + 1);
        }
 
        // recursion for main directory
        RecursivePrint(arr, ++index, level);
    }
     // Driver Method
     public static void main(String[] args)
     {
         // Provide full path for directory(change
         // accordingly)
         String maindirpath
             = "/Users/vignesh/ASAP- Yokun/java_fathom/src/testFiles";
  
         // File object
         File maindir = new File(maindirpath);
  
         if (maindir.exists() && maindir.isDirectory()) {
              
               // array for files and sub-directories
             // of directory pointed by maindir
             File arr[] = maindir.listFiles();
  
             System.out.println(
                 "**********************************************");
             System.out.println(
                 "Files from main directory : " + maindir);
             System.out.println(
                 "**********************************************");
  
             // Calling recursive method
             RecursivePrint(arr, 0, 1);
        
         }
     }

     
}
