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
import javax.sound.sampled.*;
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
    public int lives;
    public boolean TypIsIntersectingGho;
    public double pspeed;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;

    public boolean startScreen1=true;
    public boolean level1;
    public boolean startScreen2;
    public boolean level2;
    public boolean startScreen3;
    public boolean level3;
    public boolean gameOver;
    public boolean happyEnding;

    private Clip backgroundMusic;
    private boolean musicPlaying = false;

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
        playMusic();

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
    } if (level1 && points>50){
        level1=false;
        startScreen2=true;
        return;
    } if (startScreen2){
        startScreen2=false;
        level2=true;
        startLevel2();
    } if (level2 && points>30){
        level2=false;
        startScreen3=true;
        return;
    } if (startScreen3){
        startScreen3=false;
        level3=true;
        startLevel3();
    } if (level3 && points>20){
        level3=false;
        happyEnding=true;
        return;
    } if (gameOver){
        gameOver=false;
        level1=true;
        startLevel1();
    } if (happyEnding){
        happyEnding=false;
        startScreen1=true;
    }
}
public void startLevel1(){
        points=0;
        Typpy = new Character(600, 500, 1, 1, 130, 200);
    Ghoul=new Character[26];
    for (int i=0; i<Ghoul.length; i++){
        int xpos = (int) (Math.random()*1300)*2;
        int ypos = (int) (Math.random()*1000)-500;
        Ghoul[i] = new Character(xpos, ypos, 1, 1, 80, 80);
        Ghoul[i].isAlive=true;
    }
    lives=5;
    pspeed=0.4;
}
    public void startLevel2(){
        points=0;
        Typpy = new Character(600, 500, 1, 1, 130, 200);
        Ghoul=new Character[26];
        for (int i=0; i<Ghoul.length; i++){
            int xpos = (int) (Math.random()*1300)*2;
            int ypos = (int) (Math.random()*1000)-500;
            Ghoul[i] = new Character(xpos, ypos, 1, 1, 80, 80);
            Ghoul[i].isAlive=true;
        }
        pspeed=0.7;
        lives=7;
    }
    public void startLevel3(){
        points=0;
        Typpy = new Character(600, 500, 1, 1, 130, 200);
        Ghoul=new Character[26];
        for (int i=0; i<Ghoul.length; i++){
            int xpos = (int) (Math.random()*1300)*2;
            int ypos = (int) (Math.random()*1000)-500;
            Ghoul[i] = new Character(xpos, ypos, 1, 1, 80, 80);
            Ghoul[i].isAlive=true;
        }
        pspeed=1.2;
        lives=10;
    }

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        //for the moment we will loop things forever.
        while (true) {
            if (Ghoul != null && Typpy != null){
            GhoulAttack();
            moveThings();//move all the game objects
            }
            if (level1 || level2 || level3){
                runCorrectLevel();
            }
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
                    double speed = pspeed; // you can pick any speed you want 1, 2, 5 etc.
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
                if (Ghoul[i].rec.intersects(Typpy.rec)) {
                    TypIsIntersectingGho = true;
                    if (!Ghoul[i].isInter){
                        Ghoul[i].isInter=true;
                        lives = lives - 1;
                        Ghoul[i].ypos = (int) -(Math.random() * 700);
                        Ghoul[i].xpos = (int) (Math.random() * 1300);}
                } if (Ghoul[i].rec.intersects(Typpy.rec) == false) {
                    Ghoul[i].isInter = false;
                }
            }
        }
        if (level1 && lives==0){
            level1=false;
            gameOver=true;
        } if (level2 && lives==0){
            level2=false;
            gameOver=true;
        } if (level3 && lives==0){
            gameOver=true;
        }
    }

    //Paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //draw the images
        if (gameOver){
            g.setColor(new Color(100, 100, 100));
            g.fillRect(0, 0, WIDTH, HEIGHT);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.BOLD, 15));
            g.drawString("If is the end, will you still be hopeful?", 100, 100);
            g.drawString("Please be hopeful. This is not the end.", 100, 200);
            g.drawString("*PRESS ANY KEY TO RESUME*", 100, 600);
        } else if (happyEnding){
            g.setColor(new Color(200, 130, 40));
            g.fillRect(0, 0, WIDTH, HEIGHT);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.BOLD, 15));
            g.drawString("12 A.M. 1st January, 2000.", 100, 100);
            g.drawString("You feel your eyelids slowly enclosing. It is way past your sleep time anyways.", 100, 100);
            g.drawString("Nothing has happened. Everything remains exactly as it was.", 100, 200);
            g.drawString("Whatever we were to each other, that we are still.", 100, 300);
            g.drawString("*PRESS ENTER KEY TO RESTART*", 100, 600);
        } else if (startScreen1){
            g.setColor(new Color(20, 30, 100));
            g.fillRect(0, 0, WIDTH, HEIGHT);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.BOLD, 15));
            g.drawString("11 P.M. 31st December, 1999.", 100, 100);
            g.drawString("You woke up in dismay, sensing the imminent end of the world.", 100, 200);
            g.drawString("You feel disembodied. You do not know who you are, where you are, and most importantly, what to do. ", 100, 300);
            g.drawString("Out of the blue, you feel the urge to type.", 100, 400);
            g.drawString("*PRESS ANY KEY TO START*", 100, 600);
        } else if (startScreen2){
            g.setColor(new Color(20, 30, 100));
            g.fillRect(0, 0, WIDTH, HEIGHT);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.BOLD, 15));
            g.drawString("11:30 P.M. 31st December, 1999.", 100, 100);
            g.drawString("You do not believe in that apocalyptic crap. You don't think you do.", 100, 200);
            g.drawString("You're feeling dizzy. Not the sleepy kind.", 100, 300);
            g.drawString("*PRESS ENTER KEY TO CONTINUE*", 100, 600);
        } else if (startScreen3){
            g.setColor(new Color(20, 30, 100));
            g.fillRect(0, 0, WIDTH, HEIGHT);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.BOLD, 15));
            g.drawString("11:59 P.M. 31st December, 1999.", 100, 100);
            g.drawString("Either this is the end, or you are delusional.", 100, 200);
            g.drawString("*PRESS ENTER KEY TO CONTINUE*", 100, 600);
        } else if (level1 || level2 || level3){
            g.drawImage(BackgroundPic, 0, 0, WIDTH, HEIGHT, null);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.BOLD, 15));
            g.drawString("Lives:" + lives, 50, 50);
            g.drawString("Points:" + points, 150, 50);
        if (Typpy!=null) {
            if (Typpy.isAlive == true) {
                g.drawImage(TyppyPic, (int) Typpy.xpos, (int) Typpy.ypos, Typpy.width, Typpy.height, null);
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

    void playMusic() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(
                    getClass().getResource("/WeirdFishes.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("Music error: " + e.getMessage());
        }
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

        if (gameOver) {
            gameOver=false;
            startScreen1=true;
        } else if (happyEnding && keyCode==10) {
            runCorrectLevel();
        } else if (startScreen1) {
            runCorrectLevel();
        } else if ((startScreen2 || startScreen3) && keyCode==10){
                runCorrectLevel();
        } else if ((level1 || level2 || level3) && keyCode==65 && Ghoul[0].xpos > 0 && Ghoul[0].xpos < 1300 && Ghoul[0].ypos < 700 && Ghoul[0].xpos > 0){
            Ghoul[0].ypos = (int) -(Math.random() * 700);
            Ghoul[0].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==66 && Ghoul[1].xpos > 0 && Ghoul[1].xpos < 1300 && Ghoul[1].ypos < 700 && Ghoul[1].xpos > 0){
            Ghoul[1].ypos = (int) -(Math.random() * 700);
            Ghoul[1].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==67 && Ghoul[2].xpos > 0 && Ghoul[2].xpos < 1300 && Ghoul[2].ypos < 700 && Ghoul[2].xpos > 0){
            Ghoul[2].ypos = (int) -(Math.random() * 700);
            Ghoul[2].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==68 && Ghoul[3].xpos > 0 && Ghoul[3].xpos < 1300 && Ghoul[3].ypos < 700 && Ghoul[3].xpos > 0){
            Ghoul[3].ypos = (int) -(Math.random() * 700);
            Ghoul[3].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==69 && Ghoul[4].xpos > 0 && Ghoul[4].xpos < 1300 && Ghoul[4].ypos < 700 && Ghoul[4].xpos > 0){
            Ghoul[4].ypos = (int) -(Math.random() * 700);
            Ghoul[4].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==70 && Ghoul[5].xpos > 0 && Ghoul[5].xpos < 1300 && Ghoul[5].ypos < 700 && Ghoul[5].xpos > 0){
            Ghoul[5].ypos = (int) -(Math.random() * 700);
            Ghoul[5].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==71 && Ghoul[6].xpos > 0 && Ghoul[6].xpos < 1300 && Ghoul[6].ypos < 700 && Ghoul[6].xpos > 0){
            Ghoul[6].ypos = (int) -(Math.random() * 700);
            Ghoul[6].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==72 && Ghoul[7].xpos > 0 && Ghoul[7].xpos < 1300 && Ghoul[7].ypos < 700 && Ghoul[7].xpos > 0){
            Ghoul[7].ypos = (int) -(Math.random() * 700);
            Ghoul[7].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==73 && Ghoul[8].xpos > 0 && Ghoul[8].xpos < 1300 && Ghoul[8].ypos < 700 && Ghoul[8].xpos > 0){
            Ghoul[8].ypos = (int) -(Math.random() * 700);
            Ghoul[8].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==74 && Ghoul[9].xpos > 0 && Ghoul[9].xpos < 1300 && Ghoul[9].ypos < 700 && Ghoul[9].xpos > 0){
            Ghoul[9].ypos = (int) -(Math.random() * 700);
            Ghoul[9].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==75 && Ghoul[10].xpos > 0 && Ghoul[10].xpos < 1300 && Ghoul[10].ypos < 700 && Ghoul[10].xpos > 0){
            Ghoul[10].ypos = (int) -(Math.random() * 700);
            Ghoul[10].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==76 && Ghoul[11].xpos > 0 && Ghoul[11].xpos < 1300 && Ghoul[11].ypos < 700 && Ghoul[11].xpos > 0){
            Ghoul[11].ypos = (int) -(Math.random() * 700);
            Ghoul[11].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==77 && Ghoul[12].xpos > 0 && Ghoul[12].xpos < 1300 && Ghoul[12].ypos < 700 && Ghoul[12].xpos > 0){
            Ghoul[12].ypos = (int) -(Math.random() * 700);
            Ghoul[12].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==78 && Ghoul[13].xpos > 0 && Ghoul[13].xpos < 1300 && Ghoul[13].ypos < 700 && Ghoul[13].xpos > 0){
            Ghoul[13].ypos = (int) -(Math.random() * 700);
            Ghoul[13].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==79 && Ghoul[14].xpos > 0 && Ghoul[14].xpos < 1300 && Ghoul[14].ypos < 700 && Ghoul[14].xpos > 0){
            Ghoul[14].ypos = (int) -(Math.random() * 700);
            Ghoul[14].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==80 && Ghoul[15].xpos > 0 && Ghoul[15].xpos < 1300 && Ghoul[15].ypos < 700 && Ghoul[15].xpos > 0){
            Ghoul[15].ypos = (int) -(Math.random() * 700);
            Ghoul[15].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==81 && Ghoul[16].xpos > 0 && Ghoul[16].xpos < 1300 && Ghoul[16].ypos < 700 && Ghoul[16].xpos > 0){
            Ghoul[16].ypos = (int) -(Math.random() * 700);
            Ghoul[16].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==82 && Ghoul[17].xpos > 0 && Ghoul[17].xpos < 1300 && Ghoul[17].ypos < 700 && Ghoul[17].xpos > 0){
            Ghoul[17].ypos = (int) -(Math.random() * 700);
            Ghoul[17].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==83 && Ghoul[18].xpos > 0 && Ghoul[18].xpos < 1300 && Ghoul[18].ypos < 700 && Ghoul[18].xpos > 0){
            Ghoul[18].ypos = (int) -(Math.random() * 700);
            Ghoul[18].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==84 && Ghoul[19].xpos > 0 && Ghoul[19].xpos < 1300 && Ghoul[19].ypos < 700 && Ghoul[19].xpos > 0){
            Ghoul[19].ypos = (int) -(Math.random() * 700);
            Ghoul[19].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==85 && Ghoul[20].xpos > 0 && Ghoul[20].xpos < 1300 && Ghoul[20].ypos < 700 && Ghoul[20].xpos > 0){
            Ghoul[20].ypos = (int) -(Math.random() * 700);
            Ghoul[20].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==86 && Ghoul[21].xpos > 0 && Ghoul[21].xpos < 1300 && Ghoul[21].ypos < 700 && Ghoul[21].xpos > 0){
            Ghoul[21].ypos = (int) -(Math.random() * 700);
            Ghoul[21].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==87 && Ghoul[22].xpos > 0 && Ghoul[22].xpos < 1300 && Ghoul[22].ypos < 700 && Ghoul[22].xpos > 0){
            Ghoul[22].ypos = (int) -(Math.random() * 700);
            Ghoul[22].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==88 && Ghoul[23].xpos > 0 && Ghoul[23].xpos < 1300 && Ghoul[23].ypos < 700 && Ghoul[23].xpos > 0){
            Ghoul[23].ypos = (int) -(Math.random() * 700);
            Ghoul[23].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==89 && Ghoul[24].xpos > 0 && Ghoul[24].xpos < 1300 && Ghoul[24].ypos < 700 && Ghoul[24].xpos > 0){
            Ghoul[24].ypos = (int) -(Math.random() * 700);
            Ghoul[24].xpos = (int) (Math.random() * 1300);
            points++;
        } else if ((level1 || level2 || level3) && keyCode==90 && Ghoul[25].xpos > 0 && Ghoul[25].xpos < 1300 && Ghoul[25].ypos < 700 && Ghoul[25].xpos > 0){
            Ghoul[25].ypos = (int) -(Math.random() * 700);
            Ghoul[25].xpos = (int) (Math.random() * 1300);
            points++;
        }
    }
}

