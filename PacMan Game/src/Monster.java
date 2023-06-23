import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Monster extends Item {
   
   private Random rdm = new Random(); 
   
   public Monster(int sx, int sy, int sp){
      super(sx, sy, sp);
   }  
         
   public void draw(Graphics g) {
      int x = super.getX();
      int y = super.getY();      
      g.setColor(Color.BLUE);
      int x1 = x;
      int y1 = y;
      int x2 = x+10;
      int y2 = y;
      int x3 = x+20;
      int y3 = y;
      int x4 = x+30;
      int y4 = y;
      int x5 = x;
      int y5 = y+10;
      int x6 = x+10;
      int y6 = y+10;
      int x7 = x+20;
      int y7 = y+10;
      int x8 = x+30;
      int y8 = y+10;
      int x9 = x;
      int y9 = y+20;
      int x10 = x+10;
      int y10 = y+20;
      int x11 = x+20;
      int y11 = y+20;
      int x12 = x+30;
      int y12 = y+20;
      int x13 = x;
      int y13 = y+30;
      int x14 = x+10;
      int y14 = y+30;
      int x15 = x+20;
      int y15 = y+30;
      int x16 = x+30;
      int y16 = y+30;      
      int xpts[] = {x2, x3, x7, x8, x12, x11, x15, x14, x10, x9, x5, x6};
      int ypts[] = {y2, y3, y7, y8, y12, y11, y15, y14, y10, y9, y5, y6};
      g.fillPolygon(xpts, ypts, 12);      
   }  
   
   public void handleBorderCollision() {
      int x = super.getX();
      int y = super.getY();       
      if ((x <= 0) | (x >= 570) | (y <= 0) | (y >= 570)) {
         super.reverseDirection();
      }
      updatePosition();
   }
   
   public void hunting(Ruchira p) {
      int dir = rdm.nextInt(8);
      int px = p.getX();
      int py = p.getY();
      int vx = super.getX();
      int vy = super.getY();
      
      if (dir == 0) super.moveLeft();
      else if (dir == 1) super.moveRight();
      else if (dir == 2) super.moveUp();
      else if (dir == 3) super.moveDown();
      else if (dir == 4){
          if(vx < px)
              super.moveRight();
          else
              super.moveLeft();     
      }
      else if (dir == 5) {
           if (vy < py) 
               super.moveDown();
            else 
               super.moveUp();
           }
       }
    }
         

