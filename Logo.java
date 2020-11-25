// needed for doing graphics
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;
import java.awt.event.ActionListener;
/**
* @author -Alex Rogers
* Test strings are (ABBBBA, ABAABA, ABABBB)
* sources used: https://www.clear.rice.edu/comp310/JavaResources/animation.html
 * --------------------------
 */

public class Logo extends JPanel implements ActionListener
{
    // instance variables
    // 
    // 
    Timer tm = new Timer(1000,this);
    //private viewAdapter adapt = viewAdapter.NULL_OBJECT;
    int testString1 = 3;  //example instance variable
    int q0x = 100;
    int q0y = 100;
    int q1x = 500;
    int q1y = q0y;
    int q2x = q1x;
    int q2y = 400;
    int q3x = q0x;
    int q3y = q2y;
    
    
    static int framex = 900;
    static int framey = 700;
    boolean goForward = false;
    boolean goBackwards = false;
    int currentState = 0;
    int currentFrame = 0;
    String currentStack = " ";
    
    
    public static void main(String[] args)
    {
        //Create a window frame
        JFrame myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(framex,framey);

        // put the picture in the frame
        
        Logo logo = new Logo();
        logo.init();
        myFrame.setVisible(true);
        myFrame.add(logo);
        
       
        //go(logo);
        
        
        
        
        
        
        //myFrame.setVisible(true);
        //System.out.println("hello again");
        
        
        
        
        
    }
    public void paint(Graphics g){
        super.paintComponent(g);
        initPaint(g,currentState,testString1);
        go();
        tm.start();
    }
    public void actionPerformed(ActionEvent e){
        go();
        currentFrame++;
        repaint();
    
    }
    public void go(){
        
            
            
            //initPaint(g,stateNum,testString);
            //Test strings are (ABBBBA, ABAABA, ABABBB)
            if(testString1 == 1){
                switch(currentFrame){
                    case 0:
                    currentState =0;
                    currentStack = " ";
                    break;
                    case 1:
                    currentState =1;
                    currentStack = "$";
                    break;
                    case 2:
                    currentState =1;
                    currentStack = "$ A";
                    break;
                    case 3:
                    currentState =1;
                    currentStack = "$ A B";
                    break;
                    case 4:
                    currentState =1;
                    currentStack = "$ A B B";
                    break;
                    case 5:
                    currentState =2;
                    currentStack = "$ A B B";
                    break;
                    case 6:
                    currentState =2;
                    currentStack = "$ A B";
                    break;
                    case 7:
                    currentState =2;
                    currentStack = "$ A";
                    break;
                    case 8:
                    currentState =2;
                    currentStack = "$";
                    break;
                    case 9:
                    currentState =3;
                    currentStack = " ";
                    break;
                }
            }
            if(testString1 == 2){
                switch(currentFrame){
                    case 0:
                    currentState =0;
                    currentStack = " ";
                    break;
                    case 1:
                    currentState =1;
                    currentStack = "$";
                    break;
                    case 2:
                    currentState =1;
                    currentStack = "$ A";
                    break;
                    case 3:
                    currentState =1;
                    currentStack = "$ A B";
                    break;
                    case 4:
                    currentState =1;
                    currentStack = "$ A B A";
                    break;
                    case 5:
                    currentState =2;
                    currentStack = "$ A B A";
                    break;
                    case 6:
                    currentState =2;
                    currentStack = "$ A B";
                    break;
                    case 7:
                    currentState =2;
                    currentStack = "$ A";
                    break;
                    case 8:
                    currentState =2;
                    currentStack = "$";
                    break;
                    case 9:
                    currentState =3;
                    currentStack = " ";
                    break;
                }
            }
            if(testString1 == 3){
                switch(currentFrame){
                    case 0:
                    currentState =0;
                    currentStack = " ";
                    break;
                    case 1:
                    currentState =1;
                    currentStack = "$";
                    break;
                    case 2:
                    currentState =1;
                    currentStack = "$ A";
                    break;
                    case 3:
                    currentState =1;
                    currentStack = "$ A B";
                    break;
                    case 4:
                    currentState =1;
                    currentStack = "$ A B A";
                    break;
                    case 5:
                    currentState =1;
                    currentStack = "$ A B A B";
                    break;
                    case 6:
                    currentState =1;
                    currentStack = "$ A B A B B";
                    break;
                    case 7:
                    currentState =1;
                    currentStack = "$ A B A B B B";
                    break;
                }
            }
            
            repaint();
        
    }
     
    
    public void init() 
    {      
        String question = "What string would you like to test? (Enter 1, 2, or 3)";
        String numString = JOptionPane.showInputDialog(question);
        testString1 = Integer.parseInt(numString); 
        
    }
    
    
    public void initPaint(Graphics g,int stateNum, int stringNum){
        drawState(g, q1x+75, q0y-75,4); //q1 arrow to itself, 4 removes it from accept color possiblity
        drawState(g, q2x+75, q2y+75,4);
        
        drawState(g, q0x, q0y,0); //q0 
        drawState(g, q1x, q0y,1); //q1
        drawState(g, q2x, q2y,2);//q2
        drawState(g, q3x, q3y,3);//q3
        //accept circle
        g.setColor(Color.BLACK);
        g.fillOval(q3x+10,q3y+10,130,130);
        g.setColor(Color.WHITE);
        g.fillOval(q3x+15,q3y+15,120,120);  
        g.setColor(Color.BLACK);
        
        g.fillRect(150+q0x,70+q0y,q1x-145-q0x,10);
        g.fillRect(q1x+70,150+q0y,10,q2y-145-q1y);
        g.fillRect(150+q0x,70+q3y,q1x-145-q0x,10);
        g.fillPolygon(new int[] {q1x+5, q1x-10,q1x-10}, new int[] {75+q0y,90+q0y,60+q0y}, 3);//first arrow
        g.fillPolygon(new int[] {q2x+75, q1x+90,q1x+60}, new int[] {q2y+5,q2y-10,q2y-10}, 3);//seccond arrowhead
        g.fillPolygon(new int[] {q3x+145, q3x+160,q3x+160}, new int[] {75+q3y,95+q3y,55+q3y}, 3);//third arrowhead
        
        g.fillPolygon(new int[] {q2x+75,q2x+65, q2x+85}, new int[] {145+q2y,160+q2y,160+q2y}, 3);
        g.fillPolygon(new int[] {q2x+75, q2x+65,q2x+85}, new int[] {q1y+5,q1y-10,q1y-10}, 3);

        
        initText(g);
        initStack(g);
    }
    
    public void drawState(Graphics g, int x, int y, int stateNum)
    {
        // state with black outline
        g.setColor(Color.BLACK);
        if(stateNum ==4){
            g.drawOval(x+0,y+0,150,150);
        }
        else{
            g.fillOval(x+0,y+0,150,150);
            if(currentState == stateNum && stateNum != 4){
            g.setColor(Color.GREEN);
            }
            else{
            g.setColor(Color.WHITE);
            } 
        
            g.fillOval(x+5,y+5,140,140);  
        }
    }
    
    public void initText(Graphics g){
        //testString if cases, ex. Test strings are (ABBBBA, ABAABA, ABABBB)
        int stringLabelY = 50;
        g.setColor(Color.BLACK);
        if(testString1 == 1){
            g.drawString("A B B B B A", 400, stringLabelY);
        }
        if(testString1 == 2){
            g.drawString("A B A A B A", 400, stringLabelY);
        }
        if(testString1 == 3){
            g.drawString("A B A B B B", 400, stringLabelY);
        }
        //directed graph labels
        g.drawString("ε,ε->$", 400, q0y + 50);
        g.drawString("0, ε->0 ", q1x +250, q0y);
        g.drawString(" 1,ε->1", q1x +250, q0y+ 15);
        g.drawString(" ε,ε->ε", q1x +100, framey/2);
        g.drawString("0, 0->ε", q1x +250, q2y + 150);
        g.drawString("1,1->ε", q1x +250, q2y+ 165);
        g.drawString("ε,$->ε", 400, q3y + 50);
    }
    public void initStack(Graphics g){
        //initializes stack graphic
        g.setColor(Color.WHITE);
        g.fillRect(framex/2-100,framey/2 -20, 100, 30);
        g.setColor(Color.BLACK);
        g.drawString(currentStack,framex/2 -90, framey/2);
    
    }
}