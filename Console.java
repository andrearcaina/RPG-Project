import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.text.DefaultCaret;
import javax.swing.text.BadLocationException;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;

/**
 * <h1>ARC Console</h1>
 * This class allows you to create an easy to program Console window<br>
 * It has simple input and ouput methods that beginner programmers can use to learn<br>
 * This Console has two layers: <br>
 * * Text layer controlled by print and read methods<br>
 * * Graphical layer below that is controlled by draw methods
 * <p>
 *
 * @author  Alfred Cadawas
 * @version 1.1
 * @since   2017-11-09 
 */
public class Console{
    private String strTitle = "Console";
    private int intWidth = 960;
    private int intHeight = 540;
    private ARCTextArea theArea;
    private JFrame theFrame;
    
    // Console Text Output Methods
    /** Print a newline */
    public void println(){
        this.deleteFirstLineIfNeeded();
        this.theArea.append("\n"); 
    }
    /** Print whatever is in the boolean variable to the Console followed by a newline 
        * @param blnX boolean value to print
        */
    public void println(boolean blnX){
        this.deleteFirstLineIfNeeded();
        this.theArea.append(blnX + "\n"); 
    }
    /** Print whatever is in the char variable to the Console followed by a newline 
        * @param chrX character value to print
        */
    public void println(char chrX){
        this.deleteFirstLineIfNeeded();
        this.theArea.append(chrX + "\n"); 
    }
    /** Print whatever is in the char array variable to the Console followed by a newline 
        * @param chrX character array to print
        */
    public void println(char[] chrX){
        this.deleteFirstLineIfNeeded();
        this.theArea.append(chrX + "\n"); 
    }
    /** Print whatever is in the double variable to the Console followed by a newline 
        * @param dblX double value to print
        */  
    public void println(double dblX){
        this.deleteFirstLineIfNeeded();
        this.theArea.append(dblX + "\n"); 
    }
    /** Print whatever is in the float variable to the Console followed by a newline 
        * @param fltX float value to print
        */  
    public void println(float fltX){
        this.deleteFirstLineIfNeeded();
        this.theArea.append(fltX + "\n"); 
    }
    /** Print whatever is in the int variable to the Console followed by a newline 
        * @param intX integer value to print
        */
    public void println(int intX){
        this.deleteFirstLineIfNeeded();
        this.theArea.append(intX + "\n"); 
    }
    /** Print whatever is in the long variable to the Console followed by a newline 
        * @param lngX long value to print
        */
    public void println(long lngX){
        this.deleteFirstLineIfNeeded();
        this.theArea.append(lngX + "\n"); 
    }
    /** Print whatever is in the Object variable to the Console followed by a newline 
        * @param objX object to print
        */
    public void println(Object objX){
        this.deleteFirstLineIfNeeded();
        this.theArea.append(objX + "\n"); 
    }
    /** Print whatever is in the String variable to the Console followed by a newline 
        * @param strX String value to print
        */
    public void println(String strX){
        this.deleteFirstLineIfNeeded();
        this.theArea.append(strX + "\n"); 
    }
    /** Print whatever is in the boolean variable to the Console and stay on the same line 
        * @param blnX boolean value to print
        */
    public void print(boolean blnX){
        this.theArea.append(blnX + ""); 
    }
    /** Print whatever is in the char variable to the Console and stay on the same line 
        * @param chrX character value to print
        */
    public void print(char chrX){
        this.theArea.append(chrX + ""); 
    }
    /** Print whatever is in the char array variable to the Console and stay on the same line 
        * @param chrX character array to print
        */
    public void print(char[] chrX){
        this.theArea.append(chrX + ""); 
    }
    /** Print whatever is in the double variable to the Console and stay on the same line 
        * @param dblX double value to print
        */
    public void print(double dblX){
        this.theArea.append(dblX + ""); 
    }
    /** Print whatever is in the float variable to the Console and stay on the same line 
        * @param fltX float value to print
        */
    public void print(float fltX){
        this.theArea.append(fltX + ""); 
    }
    /** Print whatever is in the int variable to the Console and stay on the same line 
        * @param intX integer value to print
        */
    public void print(int intX){
        this.theArea.append(intX + ""); 
    }
    /** Print whatever is in the long variable to the Console and stay on the same line 
        * @param lngX long value to print
        */
    public void print(long lngX){
        this.theArea.append(lngX + ""); 
    }
    /** Print whatever is in the Object variable to the Console and stay on the same line 
        * @param objX object to print
        */
    public void print(Object objX){
        this.theArea.append(objX + ""); 
    }
    /** Print whatever is in the String variable to the Console and stay on the same line 
        * @param strX String value to print
        */
    public void print(String strX){
        this.theArea.append(strX); 
    }
    /** Set the color of the text of the top layer controlled by print methods 
        * @param theColor color object value
        */
    public void setTextColor(Color theColor){
        this.theArea.setForeground(theColor);
        this.theArea.setCaretColor(theColor);
    }
    /** Set the color of the brackround of the entire Console window<br>
        * Draws a full window filled rectangle in the color specified to the lower draw layer
        * @param theColor color object value
        */
    public void setBackgroundColor(Color theColor){
        this.theArea.drawGraphics.setColor(theColor);
        this.theArea.drawGraphics.fillRect(0,0, this.intWidth, this.intHeight);
        this.theArea.repaint();
    }
    /** Sets the font of the text in the top pauer controlled by print methods 
        * @param theFont font object value
        */
    public void setTextFont(Font theFont){
        this.theArea.setFont(theFont); 
    }
    /** Clears any text in the top layer */
    public void clear(){
        theArea.blnBackPressed = true;
        this.theArea.setText("");
    }
    // Console Draw Output Methods
    /** Draw an arc at the designated coordinates and angles 
        * @param intX x location of the start of the arc
        * @param intY y location of the start of the arc
        * @param intWidth width of the arc
        * @param intHeight height of the arc
        * @param intStartAngle start angle of the arc in degrees
        * @param intArcAngle angle of the arc in degrees
        */
    public void drawArc(int intX, int intY, int intWidth, int intHeight, int intStartAngle, int intArcAngle){
        this.theArea.drawGraphics.drawArc(intX, intY, intWidth, intHeight, intStartAngle, intArcAngle);
    }
    /** Draw an Image at the designated coordinates
        * <br>Anchor point for the image will be top left corner 
        * @param theImage image object to draw
        * @param intX x location of the upper left corner of the image
        * @param intY y location of the upper left corner of the image
        */
    public void drawImage(BufferedImage theImage, int intX, int intY){
        this.theArea.drawGraphics.drawImage(theImage, intX, intY, null);
    }
    /** Draw a line at the designated coordinates 
        * @param intX1 x location of the first point on the line
        * @param intY1 y location of the first point on the line
        * @param intX2 x location of the second point on the line
        * @param intY2 y location of the second point on the line
        */
    public void drawLine(int intX1, int intY1, int intX2, int intY2){
        this.theArea.drawGraphics.drawLine(intX1, intY1, intX2, intY2);
    }
    /** Draw an oval at the designaged coordinates with the designated width and height
        * <br>Anchor point for the oval will be the top left corner 
        * @param intX x location of the upper left corner of the oval
        * @param intY y location of the upper left corner of the oval
        * @param intWidth width of the oval
        * @param intHeight height of the oval
        */
    public void drawOval(int intX, int intY, int intWidth, int intHeight){
        this.theArea.drawGraphics.drawOval(intX, intY, intWidth, intHeight);
    }
    /** Draw a polygon at the designated coordinates 
        * @param intXPoints array specifying the x coordinates of the polygon
        * @param intYPoints array specifying the y coordinates of the polygon
        * @param intNPoints the number of points in the polygon
        */
    public void drawPolygon(int[] intXPoints, int[] intYPoints, int intNPoints){
        this.theArea.drawGraphics.drawPolygon(intXPoints, intYPoints, intNPoints);
    }
    /** Draw a rectangle at the designated coordinates with the designated width and height
        * <br>Anchor poirnt for the rectangle will be the top left corner 
        * @param intX x location of the upper left corner of the rectangle
        * @param intY y location of the upper left corner of the rectangle
        * @param intWidth width of the rectangle
        * @param intHeight height of the rectangle
        */
    public void drawRect(int intX, int intY, int intWidth, int intHeight){
        this.theArea.drawGraphics.drawRect(intX, intY, intWidth, intHeight);
    }
    /** Draw a rounded rectangle at the designated coordinates with the designated width and height
        * <br>Anchor poirnt for the rectangle will be the top left corner 
        * @param intX x location of the upper left corner of the rectangle
        * @param intY y location of the upper left corner of the rectangle
        * @param intWidth width of the rectangle
        * @param intHeight height of the rectangle
        * @param intArcWidth the width of the rounded corner arc
        * @param intArcHeight the height of the rounded corner arc
        */  
    public void drawRoundRect(int intX, int intY, int intWidth, int intHeight, int intArcWidth, int intArcHeight){
        this.theArea.drawGraphics.drawRoundRect(intX, intY, intWidth, intHeight, intArcWidth, intArcHeight);
    }
    /** Draw a string at the designated coordinates<br>
        * The string will be drawn in the lower draw layer
        * @param strLine line of text to be printed to the lower draw layer
        * @param intX x location of the start of the line
        * @param intY y location of the start of the line
        */
    public void drawString(String strLine, int intX, int intY){
        
        this.theArea.drawGraphics.drawString(strLine, intX, intY+this.theArea.drawGraphics.getFontMetrics().getHeight());
    }
    /** Draw a filled arc at the designated coordinates and angles 
        * @param intX x location of the start of the arc
        * @param intY y location of the start of the arc
        * @param intWidth width of the arc
        * @param intHeight height of the arc
        * @param intStartAngle start angle of the arc in degrees
        * @param intArcAngle angle of the arc in degrees
        * 
        */
    public void fillArc(int intX, int intY, int intWidth, int intHeight, int intStartAngle, int intArcAngle){
        this.theArea.drawGraphics.fillArc(intX, intY, intWidth, intHeight, intStartAngle, intArcAngle);
    }
    /** Draw a filled oval at the designaged coordinates with the designated width and height
        * <br>Anchor point for the oval will be the top left corner 
        * @param intX x location of the upper left corner of the oval
        * @param intY y location of the upper left corner of the oval
        * @param intWidth width of the oval
        * @param intHeight height of the oval
        */
    public void fillOval(int intX, int intY, int intWidth, int intHeight){
        this.theArea.drawGraphics.fillOval(intX, intY, intWidth, intHeight);
    }
    /** Draw a filled polygon at the designated coordinates 
        * @param intXPoints array specifying the x coordinates of the polygon
        * @param intYPoints array specifying the y coordinates of the polygon
        * @param intNPoints the number of points in the polygon
        */
    public void fillPolygon(int[] intXPoints, int[] intYPoints, int intNPoints){
        this.theArea.drawGraphics.fillPolygon(intXPoints, intYPoints, intNPoints);
    }
    /** Draw a filled rectangle at the designated coordinates with the designated width and height
        * <br>Anchor poirnt for the rectangle will be the top left corner 
        * @param intX x location of the upper left corner of the rectangle
        * @param intY y location of the upper left corner of the rectangle
        * @param intWidth width of the rectangle
        * @param intHeight height of the rectangle
        */
    public void fillRect(int intX, int intY, int intWidth, int intHeight){
        this.theArea.drawGraphics.fillRect(intX, intY, intWidth, intHeight);
    }
    /** Draw a filled rounded rectangle at the designated coordinates with the designated width and height
        * <br>Anchor poirnt for the rectangle will be the top left corner
        * @param intX x location of the upper left corner of the rectangle
        * @param intY y location of the upper left corner of the rectangle
        * @param intWidth width of the rectangle
        * @param intHeight height of the rectangle
        * @param intArcWidth the width of the rounded corner arc
        * @param intArcHeight the height of the rounded corner arc
        */
    public void fillRoundRect(int intX, int intY, int intWidth, int intHeight, int intArcWidth, int intArcHeight){
        this.theArea.drawGraphics.fillRoundRect(intX, intY, intWidth, intHeight, intArcWidth, intArcHeight);
    }
    /** Sets the color for the lower draw layer 
        * @param theColor color object value
        */
    public void setDrawColor(Color theColor){
        this.theArea.drawGraphics.setColor(theColor);
    }
    /** Sets the font for the lower draw layer 
        * @param theFont font object value
        */
    public void setDrawFont(Font theFont){
        this.theArea.drawGraphics.setFont(theFont);
    }
    /** Repaints the lower draw layer<br>
        * Any draw methods that were executed before this will be finally drawn on the console draw layer<br>
        * Fill the "draw buffer" with shapes and colors and use this method to draw that buffer to the screen
        */
    public void repaint(){
        this.theArea.repaint();
    }
    // Console Input Methods
    /** Reads a line of text from the top layer and returns a String 
        * @return a String of the line that the user types into the console's top layer
        */
    public String readLine(){
        // Enable text field.
        this.deleteFirstLineIfNeeded();
        this.theArea.setEditable(true);
        this.theArea.addCaretListener(theArea);
        this.theArea.getCaret().setVisible(true);
        // Ensure that the cursor remains at the bottom... as they type
        // By capturing the current position... so they can't go back beyond that.
        this.theArea.strLine = "";
        this.theArea.strCurrentText = this.theArea.getText();
        this.theArea.intCaretStartPos = this.theArea.getDocument().getLength();
        this.theArea.setCaretPosition(this.theArea.getDocument().getLength());
        this.theArea.blnLineRequest = true;
        this.theArea.blnBackPressed = false;
        // Detect the enter key
        // Once enter key has been selected, capture the last line
        synchronized(this.theArea.strHolder) {
        try{
            this.theArea.strHolder.wait();
        }catch(InterruptedException e){
        }
        }
        this.sleep(1);
        // Disable the text field
        this.theArea.getCaret().setVisible(false);
        this.theArea.removeCaretListener(theArea);
        this.theArea.setEditable(false);
        return this.theArea.strLine;
    }
    /** Reads an integer number from the top layer and returns an int 
        * @return an integer number of what the user types into the console's top layer
        */
    public int readInt(){
        String  strLine;
        int intValue;
        strLine = this.readLine();
        intValue = Integer.parseInt(strLine);
        return intValue;
    }
    /** Reads a double number from the top layer and returns a double 
        * @return a double number of what the user types into the console's top layer
        */
    public double readDouble(){
        String strLine;
        double dblValue;
        strLine = this.readLine();
        dblValue = Double.parseDouble(strLine);
        return dblValue;
    }
    // Gets the next character after the enter key 
    /** Reads a character from the top layer and returns a char<br>
        * If the user enters multiple characters before pressing enter, only the first character will be returned
        * @return a character value of what the user types into the console's top layer
        */
    public char readChar(){
        String strLine;
        char chrValue;
        strLine = this.readLine();
        chrValue = strLine.charAt(0);
        return chrValue;
    }
    // Gets the next character pressed without waiting for enter key
    /** Reads the next character pressed without waiting for the return key 
        * @return a character value of what the user types into the console
        */
    public char getChar(){
        this.theArea.blnKeyRequest = true;
        synchronized(this.theArea.strHolder) {
        try{
            this.theArea.strHolder.wait();
        }catch(InterruptedException e){
        }
        }
        // Need to sleep becuase it seems that if I don't, the char pressed might appear
        // in the next readline
        this.sleep(1);
        return this.theArea.chrCharPressed;
    }
    /** Reads the next character pressed without waiting for the return key<br>
        * Returns an integer keycode for that character<br>
        * You can use this method to capture arrow presses or other special keys
        * @return an integer value of the character code of what the user types into the console
        */
    public int getKey(){
        this.theArea.blnKeyRequest = true;
        synchronized(this.theArea.strHolder) {
        try{
            this.theArea.strHolder.wait();
        }catch(InterruptedException e){
        }
        }
        // Need to sleep becuase it seems that if I don't, the char pressed might appear
        // in the next readline
        this.sleep(1);
        return this.theArea.intKeyPressed;
    }
    // Gets whatever character is in the "buffer"
    // realtime character... no waiting for keypress or enter key
    /** Immediately returns the current character pressed if any<br>
        * No waiting for a key to be pressed<br>
        * Can be used for realtime input
        * @return a character value of what the user types into the console
        */
    public char currentChar(){
        // Need to sleep for a millisecond just in case the programmer using the method
        // puts this in a while loop with no sleep
        // thus creating a blocking situation
        // Don't really want to do this becuase 60 fps is 17ms.
        // So adding a millisecond creates about a 5% delay.
        // The student programmer should put a sleep in themselves... but oh well
        this.sleep(1);
        return this.theArea.chrCurrentChar;
    }
    /** Immediately returns the current keycode pressed if any<br>
        * No waiting for a key to be pressed<br>
        * Can be used for realtime input
        * @return an integer value of the character code of what the user types into the console
        */
    public int currentKey(){
        // Need to sleep for a millisecond just in case the programmer using the method
        // puts this in a while loop with no sleep
        // thus creating a blocking situation
        // Don't really want to do this becuase 60 fps is 17ms.
        // So adding a millisecond creates about a 5% delay.
        // The student programmer should put a sleep in themselves... but oh well
        this.sleep(1);
        return this.theArea.intCurrentKey;
    }
    // realtime mouse location methods
    /** Immediately returns the X location of the mouse<br>
        * Realtime input
        * @return current x location of the mouse
        */
    public int currentMouseX(){
        // Need to sleep for a millisecond just in case the programmer using the method
        // puts this in a while loop with no sleep
        // thus creating a blocking situation
        // Don't really want to do this becuase 60 fps is 17ms.
        // So adding a millisecond creates about a 5% delay.
        // The student programmer should put a sleep in themselves... but oh well
        this.sleep(1);
        return this.theArea.intMouseX;
    }
    /** Immediately returns the Y location of the mouse<br>
        * Realtime input
        * @return current y location of the mouse
        */
    public int currentMouseY(){
        // Need to sleep for a millisecond just in case the programmer using the method
        // puts this in a while loop with no sleep
        // thus creating a blocking situation
        // Don't really want to do this becuase 60 fps is 17ms.
        // So adding a millisecond creates about a 5% delay.
        // The student programmer should put a sleep in themselves... but oh well
        this.sleep(1);
        return this.theArea.intMouseY;
    }
    /** Immediately returns the current mouse button being pressed<br>
        * Realtime input
        * @return current button the mouse being pressed
        */
    public int currentMouseButton(){
        // Need to sleep for a millisecond just in case the programmer using the method
        // puts this in a while loop with no sleep
        // thus creating a blocking situation
        // Don't really want to do this becuase 60 fps is 17ms.
        // So adding a millisecond creates about a 5% delay.
        // The student programmer should put a sleep in themselves... but oh well
        this.sleep(1);
        return this.theArea.intMouseBut;
    }
    // Console Utility Methods
    /** Load an image based on filename and returns a BufferedImage object<br>
        * The object can be used in the drawImage method<br>
        * Can only load jpg, png, and gif (not animated) picture files
        * @param strFileName name of the image file you want to load
        * @return an image object that can be used in the drawImage method
        */
    public BufferedImage loadImage(String strFileName){  
        // Try to read the file from the jar file
        InputStream imageclass = null;
        imageclass = this.getClass().getResourceAsStream(strFileName);
        if(imageclass == null){
        //System.out.println("Unable to load image file: \""+strFileName+"\"");
        //return null;
        }else{
        try{
            return ImageIO.read(imageclass);
        }catch(IOException e){
            //System.out.println(e.toString());
            //System.out.println("Unable to load image file: \""+strFileName+"\"");
            //return null;
        }
        }
        // Then try to read the local file
        try{
        BufferedImage theimage = ImageIO.read(new File(strFileName));
        return theimage;
        }catch(IOException e){
        System.out.println("Unable to load local image file: \""+strFileName+"\"");
        return null;
        }
    }
    /** Load a font based on a filename and returns a Font object<br>
        * The object can be used in the setTextFont and setDrawFont methods<br>
        * Can only load ttf (TrueType) fonts
        * @param strFileName name of the font file you want to load
        * @param intSize size of the font you would like to load
        * @return a font object that can be used to set the text font or draw font
        */
    public Font loadFont(String strFileName, int intSize){    
        Font theFont = null;
        // Try to load the font from the jar file
        try{
        theFont = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream(strFileName)); 
        return theFont.deriveFont(Font.PLAIN, intSize);
        }catch(Exception e){
        //System.out.println(e.toString());
        }
        
        // Then try to load the font from the local filesystem
        try{
        theFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(strFileName)); 
        return theFont.deriveFont(Font.PLAIN, intSize);
        }catch(Exception e){
        //System.out.println(e.toString());
        System.out.println("Unable to load font file \""+strFileName+"\". Setting default font"); 
        }
        
        // Then load the default font if all else fails
        try{
        theFont = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("Hack-Regular.ttf")); 
        return theFont.deriveFont(Font.PLAIN, 20);
        }catch(Exception e){
        //System.out.println(e.toString());
        System.out.println("Unable to load default font file \"Hack-Regular.tff\".  Will default to Java's native font for your OS");
        }
        return theFont;
    }
    /** Closes the console window and exits the program */
    public void closeConsole(){
        this.theFrame.dispatchEvent(new WindowEvent(this.theFrame, WindowEvent.WINDOW_CLOSING));
    }
    /** Closes the console window without exiting the program<br>
        * Useful for multi-window applications 
        */
    public void closeWindow(){
        this.theFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.theFrame.dispatchEvent(new WindowEvent(this.theFrame, WindowEvent.WINDOW_CLOSING));
    }
    /** Pauses the program for the designated number of milliseconds 
        * @param intMS number of milliseconds to pause the program for
        */
    public void sleep(int intMS){
        try{
        Thread.sleep(intMS);
        }catch(InterruptedException e){
        }
    }
    // Used in any println method. Before writing the next line, check if you are at the bottom.
    // If you are, delete the top line to ensure that the next line will fit
    private void deleteFirstLineIfNeeded(){
        int intFontHeight;
        int intLineCount;
        int intMaxLines;
        int intEnd;
        intFontHeight = this.theArea.getFontMetrics( this.theArea.getFont() ).getHeight();
        intMaxLines = this.intHeight/intFontHeight;
        intLineCount = this.theArea.getDocument().getDefaultRootElement().getElementCount();
        if(intLineCount > intMaxLines){
        try{
            intEnd = this.theArea.getLineEndOffset(0);
            this.theArea.blnBackPressed = true;
            this.theArea.replaceRange("", 0, intEnd);
        }catch(BadLocationException e){
        }
        }
    }
    private void setupConsole(){
        this.theArea = new ARCTextArea(this.intWidth, this.intHeight);
        Font theFont = this.loadFont("Hack-Regular.ttf", 20);
        this.setTextFont(theFont);
        this.setDrawFont(theFont);
        this.theArea.setForeground(Color.WHITE);
        this.theArea.setCaretColor(Color.WHITE);    
        this.theArea.setPreferredSize(new Dimension(this.intWidth, this.intHeight));
        this.theFrame = new JFrame(this.strTitle);
        this.theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.theFrame.setResizable(false);    
        this.theFrame.setContentPane(this.theArea);
        this.theFrame.pack();
        this.theFrame.setVisible(true); 
    }
    // Constructors
    /** Create a standard Console window<br>
        * Resolution: 960x540<br>
        * Title: Console
        */
    public Console(){
        this.setupConsole();
    }
    /** Create a Console window with a specific title
        * @param strTitle title you would like at the top of the console window
        */
    public Console(String strTitle){
        this.strTitle = strTitle;
        this.setupConsole();
    }
    /** Create a Console window with specific dimensions
        * @param intWidth desired pixel width of the new console window
        * @param intHeight desired pixel height of the new console window
        */
    public Console(int intWidth, int intHeight){
        this.intWidth = intWidth;
        this.intHeight = intHeight;
        this.setupConsole();    
    }
    /** Create a Console window with a specific title and dimensions
        * @param strTitle title you would like at the top of the console window
        * @param intWidth desired pixel width of the new console window
        * @param intHeight desired pixel height of the new console window
        */
    public Console(String strTitle, int intWidth, int intHeight){
        this.strTitle = strTitle;
        this.intWidth = intWidth;
        this.intHeight = intHeight;
        this.setupConsole();
    }
    
    
    // New TextArea class that is a subclass of JTextArea
    // Will be used for text input and output
    private class ARCTextArea extends JTextArea implements KeyListener, CaretListener, MouseListener, MouseMotionListener{
        public boolean blnKeyRequest = false;
        public boolean blnLineRequest = false;
        public boolean blnBackPressed = false;
        public int intCaretStartPos = 0;
        public int intCaretEndPos = 0;
        public String strLine = "";
        public String strHolder = "";
        public String strCurrentText = "";
        public int intKeyPressed = 0;
        public char chrCharPressed = 0;
        public int intCurrentKey = 0;
        public char chrCurrentChar = 0;
        public int intMouseX = 0;
        public int intMouseY = 0;
        public int intMouseBut = 0;
        public BufferedImage drawCanvas = null;
        public Graphics2D drawGraphics = null;
        public int intAreaWidth = 0;
        public int intAreaHeight = 0;
        public void keyReleased(KeyEvent evt){
        if(evt.getKeyCode() == this.intCurrentKey){
            this.intCurrentKey = 0;
        }
        if(evt.getKeyChar() == this.chrCurrentChar){
            this.chrCurrentChar = 0;
        }
        }
        public void keyTyped(KeyEvent evt){}
        public void keyPressed(KeyEvent evt){
        // for currentChar and all related methods
        this.intCurrentKey = evt.getKeyCode();
        this.chrCurrentChar = evt.getKeyChar();
        if(this.blnKeyRequest == true){
            // for getChar and all related methods you will have to wait for keypressed.
            // This will notify that a key was pressed
            this.intKeyPressed = evt.getKeyCode();
            this.chrCharPressed = evt.getKeyChar();
            synchronized(this.strHolder) {
            this.strHolder.notify();
            }
            this.blnKeyRequest = false;
        }
        // for readLine and all related methods
        // This if statement will activate to read a string from the text area
        if(evt.getKeyCode() == KeyEvent.VK_ENTER && this.blnLineRequest == true){
            // capture the length of the newly entered text
            this.intCaretEndPos = this.getDocument().getLength();
            try{
            // get the difference between the original text and the updated text
            // to get the string that was newly entered
            this.strLine = this.getText(intCaretStartPos, (intCaretEndPos-intCaretStartPos));
            }catch(BadLocationException e){
            }
            // notify the readLine method that the data is ready
            synchronized(this.strHolder) {
            this.strHolder.notify();
            }
            this.blnLineRequest = false;
        }
        // This if statement should stop the user from deleting previously
        // establised lines in the text area
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.blnBackPressed = true;
            // We also need to check if they are at the start of the line
            if(this.intCaretStartPos == this.getDocument().getLength()){
            // getting close to start of line
            this.setText(this.strCurrentText + "\n");
            this.blnBackPressed = true;   
            }
        }  
        
        }
        public void caretUpdate(CaretEvent evt){
        if(this.blnBackPressed == false){
            // Always force the caret to be at the end of the bottom line in the textarea
            this.setCaretPosition(this.getDocument().getLength());
        }else{
            // if it is true... we ignored the caret position
            // So set it back to false
            this.blnBackPressed = false;
        }   
        }
        public void mouseExited(MouseEvent evt){}
        public void mouseEntered(MouseEvent evt){
        this.requestFocus();
        }
        public void mouseReleased(MouseEvent evt){
        this.intMouseX = evt.getX();
        this.intMouseY = evt.getY();
        this.intMouseBut = 0;     
        }
        public void mousePressed(MouseEvent evt){
        this.intMouseX = evt.getX();
        this.intMouseY = evt.getY();
        this.intMouseBut = this.getMouseBut(evt);
        
        if(this.blnBackPressed == false){
            // Always force the caret to be at the end of the bottom line in the textarea
            this.setCaretPosition(this.getDocument().getLength());
        }else{
            // if it is true... we ignored the caret position
            // So set it back to false
            this.blnBackPressed = false;
        }   
        }
        public void mouseClicked(MouseEvent evt){}
        public void mouseMoved(MouseEvent evt){
        this.intMouseX = evt.getX();
        this.intMouseY = evt.getY();
        this.intMouseBut = this.getMouseBut(evt);
        }
        public void mouseDragged(MouseEvent evt){
        this.intMouseX = evt.getX();
        this.intMouseY = evt.getY();
        this.intMouseBut = this.getMouseBut(evt);
        
        if(this.blnBackPressed == false){
            // Always force the caret to be at the end of the bottom line in the textarea
            this.setCaretPosition(this.getDocument().getLength());
        }else{
            // if it is true... we ignored the caret position
            // So set it back to false
            this.blnBackPressed = false;
        }         
        }
        private int getMouseBut(MouseEvent evt){
        if(SwingUtilities.isLeftMouseButton(evt)){
            return 1;
        }else if(SwingUtilities.isRightMouseButton(evt)){
            return 3;
        }else if(SwingUtilities.isMiddleMouseButton(evt)){
            return 2;
        }else{
            return 0;
        }
        
        }
        public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g; 
        g2d.drawImage(drawCanvas, 0, 0, null);
        try{
            // For some weird reason, this method below gets a null pointer.  But the program still works after
            // And it is very random
            // I think it may happen because we might be trying to do a readline before the window is ready
            super.paintComponent(g2d);
        }catch(NullPointerException e){
            //System.out.println("null");
            // So let's ignore the exception if it happens
        }
        
        g2d.dispose();
        }
        public ARCTextArea(int intWidth, int intHeight){
        super();
        this.intAreaWidth = intWidth;
        this.intAreaHeight = intHeight;
        this.setOpaque(false);
        this.setEditable(false);
        this.setHighlighter(null);
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        this.setDragEnabled(false);
        DefaultCaret caret = (DefaultCaret)this.getCaret();
        caret.setUpdatePolicy(DefaultCaret.UPDATE_WHEN_ON_EDT); 
        this.drawCanvas = new BufferedImage(this.intAreaWidth, this.intAreaHeight, BufferedImage.TYPE_INT_RGB);
        this.drawGraphics = (Graphics2D)drawCanvas.getGraphics();
        this.drawGraphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }
    }
}