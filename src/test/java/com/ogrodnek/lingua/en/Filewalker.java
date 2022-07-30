package com.ogrodnek.lingua.en;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.jsoup.select.Evaluator.ContainsText;

import com.ogrodnek.lingua.en.Fathom.Stats;

public class Filewalker {

    public void walk( String path ) {

        File root = new File( path );
        File[] list = root.listFiles();

        if (list == null) return;

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                walk( f.getAbsolutePath() );
                System.out.println( "Dir:" + f.getAbsoluteFile() );
            }
            else {
                System.out.println( "File:" + f.getAbsoluteFile() );
                String finData = " ";
                int no_of_lines = 0;
                String fname = f.getAbsoluteFile().toString();
                File myObj = new File(fname);
                String [] checkTableNotContains = {"<td>", "</td>", "<tr>", "</tr>"};
                Scanner myReader;
                try {
                    //System.out.println("Inside the Reader method");
                    myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        for(String item : checkTableNotContains){
                            if((data.contains(item))){
                                //System.out.println("Do Nothing!!!");
                            }   
                            else{
                                finData += data;
                                no_of_lines += 1;
                            } 
                        }
                    }    
                    //System.out.println("Data read is:"+finData);
                    myReader.close();
                    //check if the total length of document is >3000 words
                    if(finData.length()>3000 || no_of_lines > 100){
                        Stats s = Fathom.analyze(finData);
                        //System.out.println(s);
                        float NumBySentences = (float)s.getNumWords()/s.getNumSentences();
                        float ComByWords = (float)s.getNumComplexWords()/s.getNumWords();
                        float gFogIndex = (float)(0.4 * (NumBySentences + (100 * ComByWords)));
                        System.out.println("Gunning-fog Index:"+gFogIndex);
                    }
                    else{
                        System.out.println("Document not long enough! \n No of lines/words are:"+ no_of_lines + '/' +finData.length());
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Filewalker fw = new Filewalker();
        fw.walk("/Users/vignesh/ASAP- Yokun/java_fathom/src/testFiles");
    }

}