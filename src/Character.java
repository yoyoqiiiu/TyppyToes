import java.awt.*;

public class Character {
    //declare variables
    public double xpos;
    public double ypos;
    public double dx;
    public double dy;
    public int width;
    public int height;
    boolean isAlive;
    public Rectangle rec;

    public Character (double pXpos, double pYpos, double pDx, double pDy, int pWidth, int pHeight){
        xpos = pXpos;
        ypos = pYpos;
        dx = pDx;
        dy = pDy;
        width = pWidth;
        height = pHeight;
        isAlive = true;
        rec = new Rectangle((int) xpos, (int) ypos, width, height);
    }
    public void printInfo(){
        System.out.println("X position: " + xpos);
        System.out.println("Y position: " + ypos);
        System.out.println("X speed: " + dx);
        System.out.println("Y speed: " + dy);
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Is your Hero alive? " + isAlive);
    }

//    public void GhoulAttack(){
//        dx = (620 - xpos)/500;
//        dy = (500 - ypos)/500;
//        xpos += dx;
//        ypos += dy;
//    }

    public void simpleMove() {
        xpos += dx;
        ypos += dy;
        rec.setLocation((int)xpos, (int)ypos);
    }

    public void Level1Speed(){
        if (xpos>1400 || xpos < 0){//right side && left side
            dx=(-1)*dx;
        }if (ypos>750 || ypos < 0){
            dy=(-1)*dy;
        }
        xpos = xpos + dx;
        ypos = ypos + dy;
        rec = new Rectangle((int) xpos, (int) ypos, width, height);
    }

    public void Level2Speed(){
        if (xpos>750 || xpos < 0){//right side && left side
            dx=(-1)*dx;
        }if (ypos>400 || ypos < 0){
            dy=(-1)*dy;
        }
        xpos = xpos + 2*dx;
        ypos = ypos + 2*dx;
        rec = new Rectangle((int) xpos, (int) ypos, width, height);
    }
}
