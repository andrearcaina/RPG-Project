package arc;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * <h1>ARC TextOutputFile</h1>
 * This class allows you to open up a text file for writing<br>
 * <p>
 *
 * @author  Alfred Cadawas
 * @version 1.0
 * @since   2017-04-20 
 */

public class TextOutputFile{

  // Properties
    private FileWriter thefilewriter = null;
    private PrintWriter theprintwriter = null;
    private boolean blnFileOpen = false;
    
    // Methods
    private void printIfClosed(){
        if(this.blnFileOpen == false){
        System.out.println("Attemped to write to a file that is already closed");
        }
    }
    
    /** Print whatever is in the boolean variable to the open file followed by a newline 
        * @param blnX boolean value to print
        */
    public void println(boolean blnX){
        this.theprintwriter.println(blnX + ""); 
        this.theprintwriter.flush();
        this.printIfClosed();
    }
    /** Print whatever is in the char variable to the open file followed by a newline 
        * @param chrX character value to print
        */
    public void println(char chrX){
        this.theprintwriter.println(chrX + ""); 
        this.theprintwriter.flush();
        this.printIfClosed();
    }
    /** Print whatever is in the char array variable to the open file followed by a newline 
        * @param chrX character array to print
        */
    public void println(char[] chrX){
        this.theprintwriter.println(String.valueOf(chrX) + ""); 
        this.theprintwriter.flush();
        this.printIfClosed();
    }
    /** Print whatever is in the double variable to the open file followed by a newline 
        * @param dblX double value to print
        */  
    public void println(double dblX){
        this.theprintwriter.println(dblX + ""); 
        this.theprintwriter.flush();
        this.printIfClosed();
    }
    /** Print whatever is in the float variable to the open file followed by a newline 
        * @param fltX float value to print
        */  
    public void println(float fltX){
        this.theprintwriter.println(fltX + ""); 
        this.theprintwriter.flush();
        this.printIfClosed();
    }
    /** Print whatever is in the int variable to the open file followed by a newline 
        * @param intX integer value to print
        */
    public void println(int intX){
        this.theprintwriter.println(intX + ""); 
        this.theprintwriter.flush();
        this.printIfClosed();
    }
    /** Print whatever is in the long variable to the open file followed by a newline 
        * @param lngX long value to print
        */
    public void println(long lngX){
        this.theprintwriter.println(lngX + ""); 
        this.theprintwriter.flush();
        this.printIfClosed();
    }
    /** Print whatever is in the Object variable to the open file followed by a newline 
        * @param objX object to print
        */
    public void println(Object objX){
        this.theprintwriter.println(objX + ""); 
        this.theprintwriter.flush();
        this.printIfClosed();
    }
    /** Print whatever is in the String variable to the open file followed by a newline 
        * @param strX String value to print
        */
    public void println(String strX){
        this.theprintwriter.println(strX); 
        this.theprintwriter.flush();
        this.printIfClosed();
    }
    /** Print whatever is in the boolean variable to the open file and stay on the same line 
        * @param blnX boolean value to print
        */
    public void print(boolean blnX){
        this.theprintwriter.print(blnX + ""); 
        this.theprintwriter.flush();
        this.printIfClosed();
    }
    /** Print whatever is in the char variable to the open file and stay on the same line 
        * @param chrX character value to print
        */
    public void print(char chrX){
        this.theprintwriter.print(chrX + ""); 
        this.theprintwriter.flush();
        this.printIfClosed();
    }
    /** Print whatever is in the char array variable to the open file and stay on the same line 
        * @param chrX character array to print
        */
    public void print(char[] chrX){
        this.theprintwriter.print(String.valueOf(chrX) + ""); 
        this.theprintwriter.flush();
        this.printIfClosed();
    }
    /** Print whatever is in the double variable to the open file and stay on the same line 
        * @param dblX double value to print
        */
    public void print(double dblX){
        this.theprintwriter.print(dblX + ""); 
        this.theprintwriter.flush();
        this.printIfClosed();
    }
    /** Print whatever is in the float variable to the open file and stay on the same line 
        * @param fltX float value to print
        */
    public void print(float fltX){
        this.theprintwriter.print(fltX + ""); 
        this.theprintwriter.flush();
        this.printIfClosed();
    }
    /** Print whatever is in the int variable to the open file and stay on the same line 
        * @param intX integer value to print
        */
    public void print(int intX){
        this.theprintwriter.print(intX + ""); 
        this.theprintwriter.flush();
        this.printIfClosed();
    }
    /** Print whatever is in the long variable to the open file and stay on the same line 
        * @param lngX long value to print
        */
    public void print(long lngX){
        this.theprintwriter.print(lngX + ""); 
        this.theprintwriter.flush();
        this.printIfClosed();
    }
    /** Print whatever is in the Object variable to the open file and stay on the same line 
        * @param objX object to print
        */
    public void print(Object objX){
        this.theprintwriter.print(objX + ""); 
        this.theprintwriter.flush();
        this.printIfClosed();
    }
    /** Print whatever is in the String variable to the open file and stay on the same line 
        * @param strX String value to print
        */
    public void print(String strX){
        this.theprintwriter.print(strX); 
        this.theprintwriter.flush();
        this.printIfClosed();
    }
    /** Close the open text file 
        */
    public void close(){
        this.theprintwriter.close();
        try{
        this.thefilewriter.close();
        }catch(IOException e){
        System.out.println(e.toString());
        }
        this.blnFileOpen = false;
    }
    
    // Constructors
    /** Open a text file for writing based on an input file name
        * @param strFileName name of the file you would like to open for writing overwritting any old data in the file
        */  
    public TextOutputFile(String strFileName){
        try{
        this.thefilewriter = new FileWriter(strFileName);
        }catch(IOException e){
        System.out.println(e.toString());
        }
        this.theprintwriter = new PrintWriter(this.thefilewriter);
        this.blnFileOpen = true;
    }

    /** Open a text file for writing based on an input file name
        * @param strFileName name of the file you would like to open for writing
        * @param blnAppend will determine if any new data will be appended (true) or overwritten (false)
        */  
    public TextOutputFile(String strFileName, boolean blnAppend){
        try{
        this.thefilewriter = new FileWriter(strFileName, blnAppend);
        }catch(IOException e){
        System.out.println(e.toString());
        }
        this.theprintwriter = new PrintWriter(this.thefilewriter);
        this.blnFileOpen = true;
    }
}