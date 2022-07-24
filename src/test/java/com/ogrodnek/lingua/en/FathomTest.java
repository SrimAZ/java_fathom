package com.ogrodnek.lingua.en;

// import org.junit.Assert;
import org.junit.Test;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import com.ogrodnek.lingua.en.Fathom.Stats;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import com.ogrodnek.lingua.en.ReadFile;
public class FathomTest {
 @Test

  public void testSimple() {
    //FileKeeper();
    try{

      String Filepath = "/Users/vignesh/ASAP- Yokun/java_fathom/src/testFiles/A/10-K/0000013573-06-000015";
      int count_files=0;
      int count_lines=0; 
      ArrayList<String> list_row = new ArrayList<String>();
      File dir = new File(Filepath);
      System.out.println(dir);
      if(dir.exists())
      {
          int i=0;
          for (File file : dir.listFiles())
          {                                       
              Scanner s = new Scanner(file); 
              System.out.println(file.getAbsoluteFile());
              File fl = file.getAbsoluteFile();
              while (s.hasNext())
              {
                  list_row.add(s.next());//adding all elements 
                  count_lines++;
                  if(count_lines > 50 & count_lines < 100){
                    //System.out.println(s.next());
                  }
              }   
              String str[];
              str=new String[count_lines];    
              for(int p=0 ; p<count_lines ; p++)
              {
                str[p]=list_row.get(p);
  
              }
              count_files++;
              s.close();
          }    
        File f = new File("/Users/vignesh/ASAP- Yokun/java_fathom/src/testFiles");
        String [] pathnames;
        pathnames = f.list(); 
        for (String pathname : pathnames) {
          // Print the names of files and directories
          System.out.println(pathname);
            
      }
      } 
      System.out.print(count_files);
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
    //end of code for reading files from directory
    try {
      String finData = "";
      File myObj = new File("/Users/vignesh/ASAP- Yokun/java_fathom/src/testFiles/A/10-K/0000013573-06-000015/full-submission.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        finData += data;
      }
      myReader.close();
      Stats s = Fathom.analyze(finData);
      System.out.println(s);
      float NumBySentences = (float)s.getNumWords()/s.getNumSentences();
      float ComByWords = (float)s.getNumComplexWords()/s.getNumWords();
      float gFogIndex = (float)(0.4 * (NumBySentences + (100 * ComByWords)));
      System.out.println(gFogIndex);
      //Parsing the HTML string
      String HTMLSTring = finData;
      Document html = Jsoup.parse(HTMLSTring);
      //String title = html.title();
      String h1 = html.body().getElementsByTag("SEC-HEADER").text();
      System.out.println("Title:" +h1);
      //System.out.println(count_files);
  
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

  }
  
}
