//Basic Game Application
// Basic Object, Image, Movement
// Threaded

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

//*******************************************************************************

public class TyppyToes implements Runnable, KeyListener {

    //Variable Definition Section
    //Declare the variables used in the program
    //You can set their initial values too
    public Character Typpy;
    public Image TyppyPic;

    public Character[] Ghoul;
    public Image GhoulA; public Image GhoulB; public Image GhoulC; public Image GhoulD; public Image GhoulE; public Image GhoulF; public Image GhoulG; public Image GhoulH; public Image GhoulI; public Image GhoulJ; public Image GhoulK; public Image GhoulL; public Image GhoulM; public Image GhoulN; public Image GhoulO; public Image GhoulP; public Image GhoulQ; public Image GhoulR; public Image GhoulS; public Image GhoulT; public Image GhoulU; public Image GhoulV; public Image GhoulW; public Image GhoulX; public Image GhoulY; public Image GhoulZ;

    public Image BackgroundPic;
    //Sets the width and height of the program window
    final int WIDTH = 1300;
    final int HEIGHT = 700;

    public int points;
    public boolean TypIsIntersectingGho;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;

    public boolean startScreen1=true;
    public boolean level1;
    public boolean startScreen2;
    public boolean level2;
    public boolean gameOver;

    // Main method definition
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        TyppyToes ex = new TyppyToes();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }


    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public TyppyToes() { // BasicGameApp constructor

        setUpGraphics();

        //creating and constructing images
            GhoulA = Toolkit.getDefaultToolkit().getImage("A-Photoroom.png");
            GhoulB = Toolkit.getDefaultToolkit().getImage("B-Photoroom.png");
            GhoulC = Toolkit.getDefaultToolkit().getImage("C-Photoroom.png");
            GhoulD = Toolkit.getDefaultToolkit().getImage("D-Photoroom.png");
            GhoulE = Toolkit.getDefaultToolkit().getImage("E-Photoroom.png");
            GhoulF = Toolkit.getDefaultToolkit().getImage("F-Photoroom.png");
            GhoulG = Toolkit.getDefaultToolkit().getImage("G-Photoroom.png");
            GhoulH = Toolkit.getDefaultToolkit().getImage("H-Photoroom.png");
            GhoulI = Toolkit.getDefaultToolkit().getImage("I-Photoroom.png");
            GhoulJ = Toolkit.getDefaultToolkit().getImage("J-Photoroom.png");
            GhoulK = Toolkit.getDefaultToolkit().getImage("K-Photoroom.png");
            GhoulL = Toolkit.getDefaultToolkit().getImage("L-Photoroom.png");
            GhoulM = Toolkit.getDefaultToolkit().getImage("M-Photoroom.png");
            GhoulN = Toolkit.getDefaultToolkit().getImage("N-Photoroom.png");
            GhoulO = Toolkit.getDefaultToolkit().getImage("O-Photoroom.png");
            GhoulP = Toolkit.getDefaultToolkit().getImage("P-Photoroom.png");
            GhoulQ = Toolkit.getDefaultToolkit().getImage("Q-Photoroom.png");
            GhoulR = Toolkit.getDefaultToolkit().getImage("R-Photoroom.png");
            GhoulS = Toolkit.getDefaultToolkit().getImage("S-Photoroom.png");
            GhoulT = Toolkit.getDefaultToolkit().getImage("T-Photoroom.png");
            GhoulU = Toolkit.getDefaultToolkit().getImage("U-Photoroom.png");
            GhoulV = Toolkit.getDefaultToolkit().getImage("V-Photoroom.png");
            GhoulW = Toolkit.getDefaultToolkit().getImage("W-Photoroom.png");
            GhoulX = Toolkit.getDefaultToolkit().getImage("X-Photoroom.png");
            GhoulY = Toolkit.getDefaultToolkit().getImage("Y-Photoroom.png");
            GhoulZ = Toolkit.getDefaultToolkit().getImage("Z-Photoroom.png");

        TyppyPic = Toolkit.getDefaultToolkit().getImage("Typpy.png");
        BackgroundPic = Toolkit.getDefaultToolkit().getImage("TyppyBack.png");

    } // end BasicGameApp constructor


//*******************************************************************************
//User Method Section
//
// put your code to do things here.
public void runCorrectLevel(){
    if (startScreen1) {
    startScreen1=false;
    level1=true;
    startLevel1();
    } if (level1 && points>15){
        level1=false;
        startScreen2=true;
    } if (startScreen2){
        startScreen2=false;
        level2=true;
        startLevel2();
    } if (gameOver){
        gameOver=false;
        level1=true;
        startLevel1();
    }
}
public void startLevel1(){
    Typpy = new Character(600, 500, 1, 1, 130, 200);
    Ghoul=new Character[26];
    for (int i=0; i<Ghoul.length; i++){
        int xpos = (int) (Math.random()*1300)*2;
        int ypos = (int) (Math.random()*1000)-400;
        Ghoul[i] = new Character(xpos, ypos, 1, 1, 80, 80);
    }
    points=0;
}
    public void startLevel2(){
        Typpy = new Character(600, 500, 1, 1, 130, 200);
        Ghoul=new Character[26];
        for (int i=0; i<Ghoul.length; i++){
            int xpos = (int) (Math.random()*1300)*2;
            int ypos = (int) (Math.random()*1000)-400;
            Ghoul[i] = new Character(xpos, ypos, 1, 1, 80, 80);
        }
        points=0;
    }

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        //for the moment we will loop things forever.
        while (true) {
            GhoulAttack();
            moveThings();//move all the game objects
            render();  // paint the graphics
            pause(10); // sleep for 10 ms
        }
    }
    public void GhoulAttack() {
        if (Ghoul !=null && Typpy !=null) {
            for (int i = 0; i < Ghoul.length; i++) {
                double dx = Typpy.xpos - Ghoul[i].xpos;
                double dy = Typpy.ypos - Ghoul[i].ypos;

                // Calculate the distance between the ghoul and Typpy
                // This is going to allow you to "normalize" the vector and turn it into a speed of 1
                double distance = Math.sqrt(dx * dx + dy * dy);

                // Avoid division by zero
                if (distance != 0) {
                    double speed = 0.5; // you can pick any speed you want 1, 2, 5 etc.
                    Ghoul[i].dx = ((dx / distance) * speed);
                    Ghoul[i].dy = ((dy / distance) * speed);
                }
            }
        }
    }


    public void moveThings() {
        //call the move() code for each object
        if (Ghoul!=null) {
            for (int i = 0; i < Ghoul.length; i++) {
                Ghoul[i].simpleMove();
//                System.out.println("i: " + i + " dx " + Ghoul[i].dx + " dy " + Ghoul[i].dy);

                checkIntersections();
            }
        }
    }

    public void checkIntersections() {
        TypIsIntersectingGho = false;
        if (Typpy != null && Ghoul != null) {
            for (int i = 0; i < Ghoul.length; i++) {
                if (Ghoul[i].rec.intersects(Typpy.rec) && TypIsIntersectingGho == false) {
                    TypIsIntersectingGho = true;
                    points = points - 1;
                    Ghoul[i].ypos = (int) -(Math.random() * 700);
                    Ghoul[i].xpos = (int) (Math.random() * 1300);
                } if (Ghoul[i].rec.intersects(Typpy.rec) == false) {
                    TypIsIntersectingGho = false;
                }
            }
        }
    }

    //Paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //draw the images
        if (startScreen1){
            g.setColor(new Color(20, 30, 100));
            g.fillRect(0, 0, WIDTH, HEIGHT);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.BOLD, 15));
            g.drawString("11 P.M. 31st December, 1999.", 50, 100);
            g.drawString("You woke up in dismay, sensing the imminent end of the world. ", 50, 200);
            g.drawString("You feel disembodied. You do not know who you are, where you are, and most importantly, what to do. ", 50, 300);
            g.drawString("Out of the blue, you feel the urge to type.", 50, 400);
            g.drawString("*PRESS SPACE BAR TO BEGIN*", 50, 600);
        }
        if (level1){
            g.drawImage(BackgroundPic, 0, 0, WIDTH, HEIGHT, null);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.BOLD, 15));
            g.drawString("Points:" + points, 50, 50);
        if (Typpy!=null) {
            if (Typpy.isAlive == true) {
                g.drawImage(TyppyPic, (int) Typpy.xpos, (int) Typpy.ypos, Typpy.width, Typpy.height, null);
                g.drawRect(Typpy.rec.x, Typpy.rec.y, Typpy.rec.width, Typpy.rec.height);
            }
        }

        if (Ghoul!=null){
            if (Ghoul[0].isAlive == true) {
                g.drawImage(GhoulA, (int) Ghoul[0].xpos, (int) Ghoul[0].ypos, Ghoul[0].width, Ghoul[0].height, null);
            }
            if (Ghoul[1].isAlive == true) {
                g.drawImage(GhoulB, (int) Ghoul[1].xpos, (int) Ghoul[1].ypos, Ghoul[1].width, Ghoul[1].height, null);
            }
            if (Ghoul[2].isAlive == true) {
                g.drawImage(GhoulC, (int) Ghoul[2].xpos, (int) Ghoul[2].ypos, Ghoul[2].width, Ghoul[2].height, null);
            }
            if (Ghoul[3].isAlive == true) {
                g.drawImage(GhoulD, (int) Ghoul[3].xpos, (int) Ghoul[3].ypos, Ghoul[3].width, Ghoul[3].height, null);
            }
            if (Ghoul[4].isAlive == true) {
                g.drawImage(GhoulE, (int) Ghoul[4].xpos, (int) Ghoul[4].ypos, Ghoul[4].width, Ghoul[4].height, null);
            }
            if (Ghoul[5].isAlive == true) {
                g.drawImage(GhoulF, (int) Ghoul[5].xpos, (int) Ghoul[5].ypos, Ghoul[5].width, Ghoul[5].height, null);
            }
            if (Ghoul[6].isAlive == true) {
                g.drawImage(GhoulG, (int) Ghoul[6].xpos, (int) Ghoul[6].ypos, Ghoul[6].width, Ghoul[6].height, null);
            }
            if (Ghoul[7].isAlive == true) {
                g.drawImage(GhoulH, (int) Ghoul[7].xpos, (int) Ghoul[7].ypos, Ghoul[7].width, Ghoul[7].height, null);
            }
            if (Ghoul[8].isAlive == true) {
                g.drawImage(GhoulI, (int) Ghoul[8].xpos, (int) Ghoul[8].ypos, Ghoul[8].width, Ghoul[8].height, null);
            }
            if (Ghoul[9].isAlive == true) {
                g.drawImage(GhoulJ, (int) Ghoul[9].xpos, (int) Ghoul[9].ypos, Ghoul[9].width, Ghoul[9].height, null);
            }
            if (Ghoul[10].isAlive == true) {
                g.drawImage(GhoulK, (int) Ghoul[10].xpos, (int) Ghoul[10].ypos, Ghoul[10].width, Ghoul[10].height, null);
            }
            if (Ghoul[11].isAlive == true) {
                g.drawImage(GhoulL, (int) Ghoul[11].xpos, (int) Ghoul[11].ypos, Ghoul[11].width, Ghoul[11].height, null);
            }
            if (Ghoul[12].isAlive == true) {
                g.drawImage(GhoulM, (int) Ghoul[12].xpos, (int) Ghoul[12].ypos, Ghoul[12].width, Ghoul[12].height, null);
            }
            if (Ghoul[13].isAlive == true) {
                g.drawImage(GhoulN, (int) Ghoul[13].xpos, (int) Ghoul[13].ypos, Ghoul[13].width, Ghoul[13].height, null);
            }
            if (Ghoul[14].isAlive == true) {
                g.drawImage(GhoulO, (int) Ghoul[14].xpos, (int) Ghoul[14].ypos, Ghoul[14].width, Ghoul[14].height, null);
            }
            if (Ghoul[15].isAlive == true) {
                g.drawImage(GhoulP, (int) Ghoul[15].xpos, (int) Ghoul[15].ypos, Ghoul[15].width, Ghoul[15].height, null);
            }
            if (Ghoul[16].isAlive == true) {
                g.drawImage(GhoulQ, (int) Ghoul[16].xpos, (int) Ghoul[16].ypos, Ghoul[16].width, Ghoul[16].height, null);
            }
            if (Ghoul[17].isAlive == true) {
                g.drawImage(GhoulR, (int) Ghoul[17].xpos, (int) Ghoul[17].ypos, Ghoul[17].width, Ghoul[17].height, null);
            }
            if (Ghoul[18].isAlive == true) {
                g.drawImage(GhoulS, (int) Ghoul[18].xpos, (int) Ghoul[18].ypos, Ghoul[18].width, Ghoul[18].height, null);
            }
            if (Ghoul[19].isAlive == true) {
                g.drawImage(GhoulT, (int) Ghoul[19].xpos, (int) Ghoul[19].ypos, Ghoul[19].width, Ghoul[19].height, null);
            }
            if (Ghoul[20].isAlive == true) {
                g.drawImage(GhoulU, (int) Ghoul[20].xpos, (int) Ghoul[20].ypos, Ghoul[20].width, Ghoul[20].height, null);
            }
            if (Ghoul[21].isAlive == true) {
                g.drawImage(GhoulV, (int) Ghoul[21].xpos, (int) Ghoul[21].ypos, Ghoul[21].width, Ghoul[21].height, null);
            }
            if (Ghoul[22].isAlive == true) {
                g.drawImage(GhoulW, (int) Ghoul[22].xpos, (int) Ghoul[22].ypos, Ghoul[22].width, Ghoul[22].height, null);
            }
            if (Ghoul[23].isAlive == true) {
                g.drawImage(GhoulX, (int) Ghoul[23].xpos, (int) Ghoul[23].ypos, Ghoul[23].width, Ghoul[23].height, null);
            }
            if (Ghoul[24].isAlive == true) {
                g.drawImage(GhoulY, (int) Ghoul[24].xpos, (int) Ghoul[24].ypos, Ghoul[24].width, Ghoul[24].height, null);
            }
            if (Ghoul[25].isAlive == true) {
                g.drawImage(GhoulZ, (int) Ghoul[25].xpos, (int) Ghoul[25].ypos, Ghoul[25].width, Ghoul[25].height, null);
            }
        }}

        //the two lines of code needs to stay here at the bottom
        g.dispose();
        bufferStrategy.show();
    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        canvas.addKeyListener(this);

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        char key=e.getKeyChar();
        int keyCode=e.getKeyCode();

        if (keyCode==32){
            runCorrectLevel();
        }
    }
}

