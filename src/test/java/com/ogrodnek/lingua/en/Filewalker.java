package com.ogrodnek.lingua.en;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
                String fname = f.getAbsoluteFile().toString();
                File myObj = new File(fname);
                Scanner myReader;
                try {
                    System.out.println("Inside the Reader method");
                    myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        finData += data;
                    }    
                    System.out.println("Data read is:"+finData);
                    myReader.close();
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