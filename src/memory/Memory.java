package memory;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Memory extends JPanel implements MouseListener {
  ArrayList<Integer> order;
  
  public static Point mouse;
  
  public static int playingState = 0;
  
  public static int choice = 0;
  
  public static boolean clicked = false;
  
  public static int instructions = 0;
  
  public int level = 1;
  
  public int color = 0;
  
  public static boolean ret = false;
  
  public static boolean next = true;
  
  public static boolean confirm = false;
  
  public static int correct = 0;
  
  public static boolean flash = true;
  
  public static int highScore = 0;
  
  public Memory() {
    this.order = new ArrayList<>();
    addMouseListener(this);
    mouse = new Point(1, 1);
  }
  
  public static void pause(long pause) {
    Long start = Long.valueOf(System.currentTimeMillis());
    while (System.currentTimeMillis() <= pause + start.longValue());
  }
  
  static int a = 10;
  
  public void paint(Graphics gr) {
    super.paint(gr);
    Graphics2D g = (Graphics2D)gr;
    g.setStroke(new BasicStroke(3.0F));
    Font f = new Font("SansSerif Bold", 1, 20);
    g.setFont(f);
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    if (playingState == 0) {
      g.setColor(Color.darkGray);
      g.fillRect(0, 0, 500, 500);
      g.setColor(Color.white);
      switch (choice) {
        case 1:
          g.fillRect(165, 140, 170, 70);
          break;
        case 2:
          g.fillRect(165, 220, 170, 70);
          break;
        case 3:
          g.fillRect(165, 300, 170, 70);
          break;
        case 4:
          g.fillRect(165, 380, 170, 70);
          break;
      } 
      g.setColor(Color.red);
      g.fillRect(175, 150, 150, 50);
      g.setColor(Color.yellow);
      g.fillRect(175, 230, 150, 50);
      g.setColor(Color.blue);
      g.fillRect(175, 310, 150, 50);
      g.setColor(Color.green);
      g.fillRect(175, 390, 150, 50);
      g.setColor(Color.black);
      g.drawString("Play Memory", 190, 180);
      g.drawString("How to play", 190, 260);
      g.drawString("Hall Of Fame", 190, 340);
      g.drawString("Quit", 220, 420);
      Font e = new Font("SansSerif Bold", 1, 45);
      g.setFont(e);
      g.setColor(Color.green);
      g.drawString("Memory Game", 100, 100);
    } else if (playingState == 1) {
      g.setColor(Color.darkGray);
      g.fillRect(0, 0, 500, 500);
      g.setColor(Color.white);
      g.drawString("Level: 5", 205, 20);
      g.setColor(Color.red);
      g.fillRect(20, 20, 210, 210);
      g.setColor(Color.green);
      g.fillRect(270, 20, 210, 210);
      g.setColor(Color.blue);
      g.fillRect(20, 270, 210, 210);
      g.setColor(Color.yellow);
      g.fillRect(270, 270, 210, 210);
      switch (instructions) {
        case 0:
          g.setColor(Color.WHITE);
          g.fillRect(100, 100, 300, 300);
          g.setColor(Color.black);
          g.fillRect(110, 110, 280, 280);
          g.setColor(Color.white);
          g.setFont(new Font("SansSerif Bold", 1, 10));
          g.drawString("Right click next", 300, 380);
          g.drawString("Left click back", 115, 380);
          g.setFont(new Font("SansSerif Bold", 1, 20));
          g.drawString("The Memory Game is a", 120, 140);
          g.drawString("simple game that becomes ", 120, 170);
          g.drawString("progressively harder,", 120, 200);
          g.drawString("the higher leveled you are.", 120, 230);
          g.drawString("Each level means the length", 120, 260);
          g.drawString("of the pattern will be", 120, 290);
          g.drawString("longer. Level 5 means 5", 120, 320);
          g.drawString("colors and so on.", 120, 350);
          break;
        case 1:
          g.setColor(Color.WHITE);
          g.fillRect(100, 100, 300, 300);
          if (flash)
            g.fillRect(270, 20, 210, 210); 
          g.setColor(Color.black);
          g.fillRect(110, 110, 280, 280);
          g.setColor(Color.white);
          g.setFont(new Font("SansSerif Bold", 1, 10));
          g.drawString("Right click next", 300, 380);
          g.drawString("Left click back", 115, 380);
          g.setFont(new Font("SansSerif Bold", 1, 20));
          g.drawString("A sequence of colors will", 120, 140);
          g.drawString("flash white, and then off.", 120, 170);
          g.drawString("Your job is to memorize", 120, 200);
          g.drawString("the pattern in the exact", 120, 230);
          g.drawString("sequence it was shown.", 120, 260);
          break;
        case 2:
          g.setColor(new Color(112, 128, 144));
          if (flash)
            g.fillRect(20, 270, 210, 210); 
          g.setColor(Color.WHITE);
          g.fillRect(100, 100, 300, 300);
          g.setColor(Color.black);
          g.fillRect(110, 110, 280, 280);
          g.setColor(Color.white);
          g.setFont(new Font("SansSerif Bold", 1, 10));
          g.drawString("Right click next", 300, 380);
          g.drawString("Left click back", 115, 380);
          g.setFont(new Font("SansSerif Bold", 1, 20));
          g.drawString("After you see the last color,", 120, 140);
          g.drawString("it's your turn to input the", 120, 170);
          g.drawString("pattern. The color will light", 120, 200);
          g.drawString("up when the cursor is over", 120, 230);
          g.drawString("it and will flash grey when", 120, 260);
          g.drawString("clicked. If it doesn't flash", 120, 290);
          g.drawString("grey, click again.", 120, 320);
          break;
        case 3:
          g.setColor(Color.WHITE);
          g.fillRect(100, 100, 300, 300);
          g.setColor(Color.black);
          g.fillRect(110, 110, 280, 280);
          g.setColor(Color.white);
          g.setFont(new Font("SansSerif Bold", 1, 10));
          g.drawString("Right click next", 300, 380);
          g.drawString("Left click back", 115, 380);
          g.setFont(new Font("SansSerif Bold", 1, 20));
          g.drawString("If at any point you get", 120, 140);
          g.drawString("a color wrong, you will lose", 120, 170);
          g.drawString("and have to start over at 0.", 120, 200);
          g.drawString("If you get everything right,", 120, 230);
          g.drawString("click the 'Next' button to go", 120, 260);
          g.drawString("the next level. If you make", 120, 290);
          g.drawString("it to level 50, you can be", 120, 320);
          g.drawString("put into the Hall of Fame.", 120, 350);
          break;
      } 
    } else if (playingState == 2) {
      g.setColor(Color.darkGray);
      g.fillRect(0, 0, 500, 500);
      g.setColor(Color.white);
      g.drawString("Level: " + this.level, 205, 20);
      g.setColor(Color.red);
      g.fillRect(20, 20, 210, 210);
      g.setColor(Color.green);
      g.fillRect(270, 20, 210, 210);
      g.setColor(Color.blue);
      g.fillRect(20, 270, 210, 210);
      g.setColor(Color.yellow);
      g.fillRect(270, 270, 210, 210);
      if (!next) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(200, 200, 100, 100);
        g.setColor(Color.RED);
        g.fillOval(215, 215, 70, 70);
        g.setColor(Color.WHITE);
        g.drawString("Next", 227, 256);
      } else {
        Color swit = new Color(112, 128, 144);
        if (ret)
          this.color = choice; 
        switch (this.color) {
          case 1:
            g.setColor(Color.white);
            g.fillRect(20, 20, 210, 210);
            if (confirm) {
              g.setColor(swit);
              g.fillRect(20, 20, 210, 210);
              confirm = false;
            } 
            break;
          case 2:
            g.setColor(Color.white);
            g.fillRect(270, 20, 210, 210);
            if (confirm) {
              g.setColor(swit);
              g.fillRect(270, 20, 210, 210);
              confirm = false;
            } 
            break;
          case 3:
            g.setColor(Color.white);
            g.fillRect(20, 270, 210, 210);
            if (confirm) {
              g.setColor(swit);
              g.fillRect(20, 270, 210, 210);
              confirm = false;
            } 
            break;
          case 4:
            g.setColor(Color.white);
            g.fillRect(270, 270, 210, 210);
            if (confirm) {
              g.setColor(swit);
              g.fillRect(270, 270, 210, 210);
              confirm = false;
            } 
            break;
        } 
      } 
    } else if (playingState == 3) {
      g.setColor(Color.darkGray);
      g.fillRect(0, 0, 500, 500);
      g.setColor(Color.white);
      switch (choice) {
        case 1:
          g.fillRect(165, 140, 170, 70);
          break;
        case 2:
          g.fillRect(165, 220, 170, 70);
          break;
        case 3:
          g.fillRect(165, 300, 170, 70);
          break;
        case 4:
          g.fillRect(165, 380, 170, 70);
          break;
      } 
      g.setColor(Color.red);
      g.fillRect(175, 150, 150, 50);
      g.setColor(Color.yellow);
      g.fillRect(175, 230, 150, 50);
      g.setColor(Color.blue);
      g.fillRect(175, 310, 150, 50);
      g.setColor(Color.green);
      g.fillRect(175, 390, 150, 50);
      g.setColor(Color.black);
      g.drawString("Play Memory", 190, 180);
      g.drawString("How to play", 190, 260);
      g.drawString("Hall Of Fame", 190, 340);
      g.drawString("Quit", 220, 420);
      Font e = new Font("SansSerif Bold", 1, 45);
      g.setFont(e);
      g.setColor(Color.green);
      g.drawString("You Lost", 150, 80);
      g.setFont(new Font("SansSerif Bold", 1, 20));
      g.drawString("Your high score: " + (highScore - 1), 157, 30);
      switch (correct) {
        case 1:
          g.drawString("Red was the correct answer.", 105, 110);
          break;
        case 2:
          g.drawString("Green was the correct answer.", 105, 110);
          break;
        case 3:
          g.drawString("Blue was the correct answer.", 105, 110);
          break;
        case 4:
          g.drawString("Yellow was the correct answer.", 105, 110);
          break;
      } 
    } else if (playingState == 4) {
      Color gold = new Color(255, 215, 0);
      g.setColor(Color.darkGray);
      g.fillRect(0, 0, 500, 500);
      g.setColor(gold);
      g.setFont(new Font("SansSerif Bold", 1, 45));
      g.drawString("Hall Of Fame", 110, 100);
      g.setFont(new Font("SansSerif Bold", 1, 20));
      g.drawString("Michael Cyran", 175, 150);
      g.drawString("Wahab Dar", 190, 180);
      g.drawString("Ben Cunningham", 165, 210);
      g.setColor(Color.red);
      g.drawLine(70, 120, 430, 120);
      g.drawString("Click anywhere to go back", 120, 480);
    } else if (playingState == 5) {
      Color gold = new Color(255, 215, 0);
      g.setColor(Color.darkGray);
      g.fillRect(0, 0, 500, 500);
      g.setColor(gold);
      g.setFont(new Font("SansSerif Bold", 1, 45));
      g.drawString("Congratulations", 85, 100);
      g.setFont(new Font("SansSerif Bold", 1, 20));
      g.drawString("You've made it to level 50!", 120, 140);
      g.drawString("  You are worthy of being", 120, 170);
      g.drawString("included in the Hall of Fame.", 120, 200);
      g.drawString("If you want your name added", 120, 230);
      g.drawString("into the Hall of Fame, send", 120, 260);
      g.drawString("a screenshot and your name to", 115, 290);
      g.drawString("     mcyran6@gmail.com", 120, 320);
      g.drawString("I will add your name so that", 120, 350);
      g.drawString("everyone can see you made it.", 120, 380);
      g.setColor(Color.red);
      g.drawLine(70, 120, 430, 120);
      g.drawString("Click anywhere to go back", 120, 480);
    } 
  }
  
  public void tutorial(JFrame f) {
    boolean finished = false;
    int counter = 0;
    while (!finished) {
      updateMousePos(f);
      if (counter == 300000) {
        counter = 0;
        flash = !flash;
      } else if (instructions != 0) {
        counter++;
      } 
      if (playingState == 0)
        finished = true; 
    } 
  }
  
  public void assignPattern(JFrame f) {
    this.order.clear();
    Random r = new Random();
    int i;
    for (i = 0; i < this.level; i++)
      this.order.add(Integer.valueOf(r.nextInt(4) + 1)); 
    for (i = 0; i < this.order.size(); i++) {
      this.color = ((Integer)this.order.get(i)).intValue();
      f.repaint();
      pause(500L);
      this.color = 0;
      f.repaint();
      pause(500L);
    } 
  }
  
  public void recievePattern(JFrame f) {
    int levCounter = 0;
    boolean finished = false;
    while (!finished) {
      updateMousePos(f);
      if (clicked && choice != 0) {
        if (((Integer)this.order.get(levCounter)).intValue() == choice) {
          levCounter++;
          confirm = true;
          f.repaint();
          pause(200L);
          f.repaint();
        } else if (((Integer)this.order.get(levCounter)).intValue() != choice) {
          playingState = 3;
          finished = true;
          this.level = 1;
          correct = ((Integer)this.order.get(levCounter)).intValue();
        } 
        if (levCounter == this.level) {
          this.level++;
          if (this.level > highScore)
            highScore = this.level; 
          finished = true;
        } 
      } 
      clicked = false;
    } 
    if (this.level == 51) {
      this.level = 1;
      playingState = 5;
    } 
  }
  
  public void intermediate(JFrame f) {
    next = false;
    while (!next) {
      next = clicked;
      f.repaint();
    } 
    clicked = false;
  }
  
  public void updateMousePos(JFrame f) {
    PointerInfo a = MouseInfo.getPointerInfo();
    Point b = a.getLocation();
    if (b.getX() >= f.getLocation().getX() && b.getX() <= f.getLocation().getX() + f.getWidth() && b
      .getY() >= f.getLocation().getY() && b.getY() <= f.getLocation().getY() + f.getHeight())
      mouse.setLocation(b.getX() - f.getLocation().getX(), b.getY() - f.getLocation().getY() - 30.0D); 
    checkChoice();
    f.repaint();
  }
  
  public void checkChoice() {
    if (playingState == 0 || playingState == 3)
      if (mouse.getX() >= 175.0D && mouse.getX() <= 325.0D) {
        if (mouse.getY() >= 150.0D && mouse.getY() <= 200.0D) {
          choice = 1;
        } else if (mouse.getY() >= 230.0D && mouse.getY() <= 280.0D) {
          choice = 2;
        } else if (mouse.getY() >= 310.0D && mouse.getY() <= 360.0D) {
          choice = 3;
        } else if (mouse.getY() >= 390.0D && mouse.getY() <= 440.0D) {
          choice = 4;
        } else {
          choice = 0;
        } 
      } else {
        choice = 0;
      }  
    if (playingState == 2)
      if (mouse.getX() >= 20.0D && mouse.getX() <= 230.0D) {
        if (mouse.getY() >= 20.0D && mouse.getY() <= 230.0D) {
          choice = 1;
        } else if (mouse.getY() >= 270.0D && mouse.getY() <= 480.0D) {
          choice = 3;
        } else {
          choice = 0;
        } 
      } else if (mouse.getX() >= 270.0D && mouse.getX() <= 480.0D) {
        if (mouse.getY() >= 20.0D && mouse.getY() <= 230.0D) {
          choice = 2;
        } else if (mouse.getY() >= 270.0D && mouse.getY() <= 480.0D) {
          choice = 4;
        } else {
          choice = 0;
        } 
      } else {
        choice = 0;
      }  
  }
  
  public void mouseClicked(MouseEvent e) {
    if (playingState == 0 || playingState == 3) {
      switch (choice) {
        case 1:
          playingState = 2;
          break;
        case 2:
          playingState = 1;
          break;
        case 3:
          playingState = 4;
          break;
        case 4:
          System.exit(0);
          break;
      } 
    } else if (playingState == 1) {
      if (e.getButton() == 1) {
        instructions--;
      } else if (e.getButton() == 3) {
        instructions++;
      } 
      if (instructions == 4 || instructions == -1) {
        playingState = 0;
        instructions = 0;
      } 
    } else if (playingState == 2) {
      clicked = true;
    } else if (playingState == 4 || playingState == 5) {
      playingState = 0;
    } 
  }
  
  public void mousePressed(MouseEvent e) {}
  
  public void mouseReleased(MouseEvent e) {}
  
  public void mouseEntered(MouseEvent e) {}
  
  public void mouseExited(MouseEvent e) {}
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("The Memory Game");
    Memory m = new Memory();
    m.setFocusable(true);
    m.requestFocusInWindow();
    m.setSize(500, 500);
    frame.add(m);
    frame.setSize(510, 540);
    frame.setLocation(520, 185);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(3);
    while (true) {
      if (playingState == 0 || playingState == 3 || playingState == 4 || playingState == 5) {
        m.updateMousePos(frame);
        continue;
      } 
      while (playingState == 1)
        m.tutorial(frame); 
      while (playingState == 2) {
        m.intermediate(frame);
        m.assignPattern(frame);
        ret = true;
        m.recievePattern(frame);
        ret = false;
      } 
    } 
  }
}