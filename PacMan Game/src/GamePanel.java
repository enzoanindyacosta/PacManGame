// Name: Ruchira Nowreen
// ID: 0347111
// Module code: ITS66704

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

   private Timer aTimer;
   private int gameStatus = 0;   // 0 = waiting for start game
                                 // 1 = game running
                                 // 2 = game over
   private Ruchira ruchira;
   private Monster mons,mons1,mons2,mons3;
   private int score = 0;

   public GamePanel() {
      aTimer = new Timer(50, this);
      reset();
      addKeyListener(this);
   }

   public void reset() {
      aTimer = new Timer(50, this);
      ruchira = new Ruchira(300, 500, 5);
      mons = new Monster(300, 100, 5);
      mons1 = new Monster(200, 100, 5);
      mons2 = new Monster(400, 100, 5);
      mons3 = new Monster(500, 100, 5);
      score = 0;
   }

   public void startTimer() {
      if (gameStatus == 0) {
         aTimer.start();
         gameStatus = 1;
      }
   }
   
   
   public int getGameStatus(){
       return gameStatus;
   }
   
   public void setGameStatus(int gs){
       gameStatus = gs;
   }

   public void paint(Graphics g) {
      if (ruchira.collideBorder())
         gameStatus = 2;
      if (ruchira.collideWithVader(mons))
         gameStatus = 2;
      if (ruchira.collideWithVader(mons1))
         gameStatus = 2;
      if (ruchira.collideWithVader(mons2))
         gameStatus = 2;
      if (ruchira.collideWithVader(mons3))
         gameStatus = 2;
      if (gameStatus == 1) {
         score++;
         mons.hunting(ruchira);
         mons1.hunting(ruchira);
         mons2.hunting(ruchira);
         mons3.hunting(ruchira);
         ruchira.updatePosition();
         mons.updatePosition();
         mons.handleBorderCollision(); 
         mons1.updatePosition();
         mons1.handleBorderCollision(); 
         mons2.updatePosition();
         mons2.handleBorderCollision(); 
         mons3.updatePosition();
         mons3.handleBorderCollision(); 
      }
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, 600, 600);
      g.setColor(Color.BLUE);
      g.fillRect(0, 600, 600, 30);
      ruchira.draw(g);
      mons.draw(g);
      mons1.draw(g);
      mons2.draw(g);
      mons3.draw(g);
      g.setFont(new Font("Serif", Font.BOLD, 18));
      if (gameStatus == 0) {
         g.setColor(Color.WHITE);
         g.drawString("PRESS START TO BEGIN..", 200, 300);
      }
      if (gameStatus == 2) {
         g.setColor(Color.WHITE);
         g.drawString("G A M E   O V E R", 230, 300);
      }
         
      g.setColor(Color.WHITE);
      g.setFont(new Font("San Serif", Font.BOLD, 14));
      g.drawString("S C O R E : " + score, 10, 620);
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == aTimer) {
         repaint(0, 0, 600, 630);
         requestFocus();
      }
   }

   public void moveLeft() {
      ruchira.moveLeft();
   }

   public void moveRight() {
      ruchira.moveRight();
   }

   public void moveUp() {
      ruchira.moveUp();
   }

   public void moveDown() {
      ruchira.moveDown();
   }
   public void keyPressed(KeyEvent e) {
      int keyCode = e.getKeyCode();
      if (keyCode == 37) {
         moveLeft();
      } else if (keyCode == 39) {
         moveRight();
      } else if (keyCode == 38) {
         moveUp();
      } else if (keyCode == 40) {
         moveDown();
      }
   }
   
   public void keyReleased(KeyEvent e) {
   }

   public void keyTyped(KeyEvent e) {
   }
}