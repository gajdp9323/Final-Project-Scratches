package Minigame_Final_Version;
//Purpose of code is to create a small mingame if main game doesn't work how we want it to
//Philip G

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
//import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
///import java.awt.Rectangle;
//import java.awt.Frame;

//import javax.swing.KeyStroke;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Minigame extends JFrame implements KeyListener {
    Image imgPlayer1 = Toolkit.getDefaultToolkit().createImage("JavaShipP1Up.png");
    Image imgPlayer2 = Toolkit.getDefaultToolkit().createImage("JavaShipP2Up.png");
    Image imgBulletUp = Toolkit.getDefaultToolkit().createImage("BulletUp.png");
    Image imgBulletSide = Toolkit.getDefaultToolkit().createImage("BulletSide.png");
    Image imgBack = Toolkit.getDefaultToolkit().createImage("background.jpg");
    JLabel label;
    static int nLooping = 1, nX1 = 500, nY1 = 300, nX2 = 100, nY2 = 100, nScore1 = 0, nScore2 = 0, nLastDirection1 = 1, nLastDirection2 = 1;
    static int nX1BulletUP = nX1, nY1BulletUP = nY1, nX1BulletSIDE = nX1, nY1BulletSIDE = nY1, nX2BulletSIDE = nX2, nY2BulletSIDE = nY2, nX2BulletUP = nX2, nY2BulletUP = nY2;
    static int nShootX, nShootY, nShootDirect, nShootXE, nShootYE;
    static boolean isW=false, isA=false, isS=false, isD=false, isUp=false, isLeft=false, isDown=false, isRight=false, isSpace=false, isM=false;
    //static int nX1Temp = nX1, nX2Temp = nX2, nY1Temp = nY1, nY2Temp = nY2;
    public Minigame(String s) {
        //Frame fWindowFrame = new Frame();
        //Rectangle rWindowSize = fWindowFrame.getBounds();
        JPanel p = new JPanel();
        setTitle(s);
        label = new JLabel("Key Listener!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.add(label);
        add(p);
        addKeyListener(this);
        setSize(1000, 800);
        //setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        setMinimumSize(new Dimension(1000, 800));
        setVisible(true);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////
///the keyTyped code is nessessary for KeyListenerTester to work but nothing is needed inside it
    @Override
    public void keyTyped(KeyEvent e) {
    }
//    @Override
//    public void keyDown(KeyEvent e) {
//    }
///////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void keyPressed(KeyEvent e) {
        revalidate();
        repaint();
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            isRight=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            isLeft=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            isUp=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            isDown=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_M) {
            isM=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            isW=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            isS=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            isA=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            isD=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            isSpace=true;
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void keyReleased(KeyEvent e) {
        revalidate();
        repaint();
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            isRight=false;
            System.out.println("Right key Released");
            System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            isLeft=false;
            System.out.println("Left key Released");
            System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            isUp=false;
            System.out.println("Up key Released");
            System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            isDown=false;
            System.out.println("Down key Released");
            System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            isW=false;
            System.out.println("W key Released");
            System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            isA=false;
            System.out.println("A key Released");
            System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            isS=false;
            System.out.println("S key Released");
            System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            isD=false;
            System.out.println("D key Released");
            System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
        }
        /*if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            isSpace=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_M) {
            isM=false;
        }*/
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void paint(Graphics g) {
        //System.out.println(g); //g = sun.java2d.SunGraphics2D[font=java.awt.Font[family=Dialog,name=Dialog,style=plain,size=12],color=java.awt.Color[r=0,g=0,b=0]]
        int nWidth1 = imgPlayer1.getWidth(rootPane)/2, nWidth2 = imgPlayer2.getWidth(rootPane)/2;
        int nHeight1 = imgPlayer1.getHeight(rootPane)/2, nHeight2 = imgPlayer2.getHeight(rootPane)/2;
        //int nBWUp = imgPlayer1.getWidth(rootPane)/2, nBWSide = imgPlayer1.getWidth(rootPane)/2;
        //int nBHUp = imgPlayer2.getHeight(rootPane)/2, nBHSide = imgPlayer2.getHeight(rootPane)/2;
        revalidate();
        repaint();
        g.drawImage(imgBack, -400, -400, null);
        g.drawImage(imgBulletUp, nX1BulletUP+2, nY1BulletUP+2, null);
        g.drawImage(imgBulletSide, nX1BulletSIDE+2, nY1BulletSIDE+2, null);
        g.drawImage(imgPlayer1, nX1-nWidth1, nY1-nHeight1, null);
        g.drawImage(imgBulletUp, nX2BulletUP+2, nY2BulletUP+2, null);
        g.drawImage(imgBulletSide, nX2BulletSIDE+2, nY2BulletSIDE+2, null);
//        g.drawImage(imgBulletUp, nX1BulletUP-nBWUp, nY1BulletUP-nBHUp, null);
//        g.drawImage(imgBulletSide, nX1BulletSIDE-nBWSide, nY1BulletSIDE-nBHSide, null);
//        g.drawImage(imgPlayer1, nX1-nWidth1, nY1-nHeight1, null);
//        g.drawImage(imgBulletUp, nX2BulletUP-nBWUp, nY2BulletUP-nBHUp, null);
//        g.drawImage(imgBulletSide, nX2BulletSIDE-nBWSide, nY2BulletSIDE-nBHSide, null);
        g.drawImage(imgPlayer2, nX2-nWidth2, nY2-nHeight2, null);
        shipsMove();
        
  }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void Shoot(int nX, int nY, int nDirection, int nXE, int nYE) {
        revalidate();
        repaint();
        //System.out.println("Bang!");
        nShootX = nX;
        nShootY = nY;
        nShootDirect = nDirection;
        nShootXE = nXE;
        nShootYE = nYE;
        nLooping = 0;
        if (nX == nX1 && nY == nY1) {
            //System.out.println("Bonjour");
            if (nDirection == 1) {
                if (nY1BulletUP<0) {
                    isM=false;
                }
                else if (nY1BulletUP>(nYE-15) && nY1BulletUP<(nYE+15) && nX1BulletUP>(nXE-15)&& nX1BulletUP<(nXE+15)) {
                    nScore1+=1;
                    System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
                    isM=false;
                }
                nY1BulletUP-=2;
                    //System.out.println("1Not working");
            }
            if (nDirection == 2) {
                if (nX1BulletSIDE>1000) {
                    isM=false;
                }
                else if (nY1BulletSIDE>(nYE-15) && nY1BulletSIDE<(nYE+15) && nX1BulletSIDE>(nXE-15)&& nX1BulletSIDE<(nXE+15)) {
                    nScore1+=1;
                    System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
                    isM=false;
                }
                nX1BulletSIDE+=2;
                    //System.out.println("2Not working");
            }
            if (nDirection == 3) {
                if (nY1BulletUP>800) {
                    isM=false;
                }
                else if (nY1BulletUP>(nYE-15) && nY1BulletUP<(nYE+15) && nX1BulletUP>(nXE-15)&& nX1BulletUP<(nXE+15)) {
                    nScore1+=1;
                    System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
                    isM=false;
                }
                nY1BulletUP+=2;
                //System.out.println("3Not working");
            }
            if (nDirection == 4) {
                if (nX1BulletSIDE<0) {
                    isM=false;
                }
                else if (nY1BulletSIDE>(nYE-15) && nY1BulletSIDE<(nYE+15) && nX1BulletSIDE>(nXE-15)&& nX1BulletSIDE<(nXE+15)) {
                    nScore1+=1;
                    System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
                    isM=false;
                }
                nX1BulletSIDE-=2;
                //System.out.println("4Not working");
            }
        }
        else if (nX == nX2 && nY == nY2) {
            //System.out.println("Salut");
            if (nDirection == 1) {
                if (nY2BulletUP<0) {
                    isSpace=false;
                }
                else if (nY2BulletUP>(nYE-15) && nY2BulletUP<(nYE+15) && nX2BulletSIDE>(nXE-15)&& nX2BulletSIDE<(nXE+15)) {
                    nScore2+=1;
                    System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
                    isSpace=false;
                }
                nY2BulletUP-=2;
                //System.out.println("5Not working");
            }
            if (nDirection == 2) {
                if (nX2BulletSIDE>1000) {
                    isSpace=false;
                }
                else if (nY2BulletUP>(nYE-15) && nY2BulletUP<(nYE+15) && nX2BulletSIDE>(nXE-15)&& nX2BulletSIDE<(nXE+15)) {
                    nScore2+=1;
                    System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
                    isSpace=false;
                }
                nX2BulletSIDE+=2;
                //System.out.println("6Not working");
            }
            if (nDirection == 3) {
                //System.out.println("Bad3");
                if (nY2BulletUP>800) {
                    isSpace=false;
                }
                else if (nY2BulletUP>(nYE-15) && nY2BulletUP<(nYE+15) && nX2BulletSIDE>(nXE-15)&& nX2BulletSIDE<(nXE+15)) {
                    nScore2+=1;
                    System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
                    isSpace=false;
                }
                nY2BulletUP+=2;
                //System.out.println("7Not working");
            }
            if (nDirection == 4) {
                //System.out.println("Bad4");
                if (nX2BulletSIDE<0) {
                    isSpace=false;
                }
                else if (nY2BulletUP>(nYE-15) && nY2BulletUP<(nYE+15) && nX2BulletSIDE>(nXE-15)&& nX2BulletSIDE<(nXE+15)) {
                    nScore2+=1;
                    System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
                    isSpace=false;
                }
                nX2BulletSIDE-=2;
                //System.out.println("8Not working");
            }
        }
    }
    public void shipsMove(){
//        nX1BulletUP = nX1; nY1BulletUP = nY1; nX1BulletSIDE = nX1; nY1BulletSIDE = nY1; nX2BulletSIDE = nX2; nY2BulletSIDE = nY2; nX2BulletUP = nX2; nY2BulletUP = nY2;
        if (isM==true) {
            //System.out.println("Right key pressed");   //debug code
            Shoot(nX1, nY1, nLastDirection1, nX2, nY2); //call shoot class
            //System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
        }
        else if (isSpace==true) {
            //System.out.println("Right key pressed");   //debug code
            Shoot(nX2, nY2, nLastDirection2, nX1, nY1); //call shoot class
            //System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
        }
        else {
            nX1BulletUP = nX1; nY1BulletUP = nY1; nX1BulletSIDE = nX1; nY1BulletSIDE = nY1;
            nX2BulletSIDE = nX2; nY2BulletSIDE = nY2; nX2BulletUP = nX2; nY2BulletUP = nY2;
            if (isRight==true) {
                //System.out.println("Right key pressed");   //debug code
                nLastDirection1 = 2;
                //if(nX1<java.awt.Toolkit.getDefaultToolkit().getScreenSize().width)nX1 +=1; //to move right
                if(nX1<1000)nX1 +=1; //to move right
                imgPlayer1 = Toolkit.getDefaultToolkit().createImage("JavaShipP1Right.png");
                //System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
            }
            if (isLeft==true) {
                //System.out.println("Left key pressed");
                if(nX1>0)nX1 -=1; //to move left
                nLastDirection1 = 4;
                imgPlayer1 = Toolkit.getDefaultToolkit().createImage("JavaShipP1Left.png");
                //System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
            }
            if (isUp==true) {
                //System.out.println("Up key pressed");
                if(nY1>0)nY1 -=1; //to move up
                nLastDirection1 = 1;
                imgPlayer1 = Toolkit.getDefaultToolkit().createImage("JavaShipP1Up.png");
                //System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
            }
            if (isDown==true) {
                //System.out.println("Down key pressed");
                //if(nY1<java.awt.Toolkit.getDefaultToolkit().getScreenSize().height)nY1 +=1; //to move down
                if(nY1<800)nY1 +=1; //to move down
                nLastDirection1 = 3;
                imgPlayer1 = Toolkit.getDefaultToolkit().createImage("JavaShipP1Down.png");
                //System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
            }
            if (isW==true) {
                //System.out.println("W key pressed");
                if(nY2>0)nY2 -=1; //to move up
                nLastDirection2 = 1;
                imgPlayer2 = Toolkit.getDefaultToolkit().createImage("JavaShipP2Up.png");
                //System.out.println("Object 2 at (" + nX2 + ", " + nY2 + ")");
            }
            if (isS==true) {
                //System.out.println("S key pressed");
                //if(nY2<java.awt.Toolkit.getDefaultToolkit().getScreenSize().height)nY2 +=1; //to move down
                if(nY2<800)nY2 +=1; //to move down
                nLastDirection2 = 3;
                imgPlayer2 = Toolkit.getDefaultToolkit().createImage("JavaShipP2Down.png");
                //System.out.println("Object 2 at (" + nX2 + ", " + nY2 + ")");
            }
            if (isA==true) {
                //System.out.println("A key pressed");
                if(nX2>0)nX2 -=1; //to move right
                nLastDirection2 = 4;
                imgPlayer2 = Toolkit.getDefaultToolkit().createImage("JavaShipP2Left.png");
                //System.out.println("Object 2 at (" + nX2 + ", " + nY2 + ")");
            }
            if (isD==true) {
                //System.out.println("D key pressed");
                //if(nX2<java.awt.Toolkit.getDefaultToolkit().getScreenSize().width)nX2 +=1; //to move left
                if(nX2<1000)nX2 +=1; //to move left
                nLastDirection2 = 2;
                imgPlayer2 = Toolkit.getDefaultToolkit().createImage("JavaShipP2Right.png");
                //System.out.println("Object 2 at (" + nX2 + ", " + nY2 + ")");
            }
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        new Minigame("Space Wars: Shoot Freeze By: Philip G. -assisted by Samuel M.");
    }
}
