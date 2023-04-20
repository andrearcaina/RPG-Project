import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <h1>ARC TextInputFile</h1>
 * This class allows you to open up a text file for reading<br>
 * <p>
 *
 * @author  Alfred Cadawas
 * @version 1.0
 * @since   2017-04-20 
 */

public class TextInputFile{
    private BufferedReader theBufferedReader = null;
    private FileReader theFileReader = null;
    // Going to use this to "read ahead" so that I can check for the end of file
    private String strLine = null;
    private boolean blnEOF = false;
    
    // Methods
    /** Check to see of the the file is at the end and return true if it is
        * @return true if the "cursor" is at the end of file, false if it isn't
        */
    public boolean eof(){
        return this.blnEOF; 
    }
    /** Read a line of text from the opened text file
        * @return a String of a line read from the file
        */
    public String readLine(){
        String strOldLine;
        if(this.blnEOF == true){
        System.out.println("Attempting to read past the end of the file");
        }
        try{
        strOldLine = this.strLine;
        this.strLine = this.theBufferedReader.readLine();
        if(this.strLine == null || this.strLine.length() == 0){
            this.blnEOF = true;
        }     
        return strOldLine;
        }catch(IOException e){
        System.out.println(e.toString());
        return null;
        }
        
    }
    /** Read a line of text from the opened text file and convert it to an integer
        * @return an integer converted from a line read from the file
        */  
    public int readInt(){
        return Integer.parseInt(this.readLine());
    }
    /** Read a line of text from the opened text file and convert it to a double
        * @return a double converted from a line read from the file
        */  
    public double readDouble(){
        return Double.parseDouble(this.readLine());
    }
    /** Read a line of text from the opened text file and get the first character
        * @return the first character taken from a line read from the file
        */    
    public char readChar(){
        return this.readLine().charAt(0);
    }
    /** Close the text file
        */    
    public void close(){
        try{
        this.theBufferedReader.close();
        }catch(IOException e){
        System.out.println(e.toString());
        }
        try{
        this.theFileReader.close();
        }catch(IOException e){
        System.out.println(e.toString());
        }
        this.blnEOF = true;
    }
    
    // Constructors
    /** Open a text file for reading based on an input file name
        * @param strFileName name of the file you would like to open for reading
        */  
    public TextInputFile(String strFileName){
        try{
        this.theFileReader = new FileReader(strFileName);    
        }catch(FileNotFoundException e){
        System.out.println(e.toString());
        }
        if(this.theFileReader != null){
        this.theBufferedReader = new BufferedReader(this.theFileReader);
        // now that the file is opened for reading... read the first line but don't return it
        try{
            this.strLine = this.theBufferedReader.readLine();
            if(this.strLine == null || this.strLine.length() == 0){
            this.blnEOF = true;
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
        }else{
        this.blnEOF = true;
        }
        
    }
    
    
}