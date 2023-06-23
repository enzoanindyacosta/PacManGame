import java.awt.Color;
import java.awt.Graphics;

public class Ruchira extends Item {
   
    public Ruchira(int sx, int sy, int sp){
      super(sx, sy, sp);
   }

   public void draw(Graphics g) {
      int x = super.getX();
      int y = super.getY();      
      g.setColor(Color.GREEN);
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
      int xpts[] = {x2, x3, x8, x12, x15, x14, x9, x5};
      int ypts[] = {y2, y3, y8, y12, y15, y14, y9, y5};
      g.fillPolygon(xpts, ypts, 8);      
   }    

   public boolean collideBorder() {
      boolean collide = false;
      int x = super.getX();
      int y = super.getY();
      if ((x <= 0) | (x >= 570) | (y <= 0) | (y >= 570))
         collide = true;
      return collide;
   }   
   
      public boolean collideWithVader(Monster v) {
      boolean collide = false;
      int px = super.getX();
      int py = super.getY();
      int vx = v.getX();
      int vy = v.getY();
      int sz = 30;
      if ((vx >= (px-sz)) & (vx <= (px+sz)) & (vy >= (py-sz)) & (vy <= (py+sz)))
         collide = true;
      return collide;
   }   
   
}
