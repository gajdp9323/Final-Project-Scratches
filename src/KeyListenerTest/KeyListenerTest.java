package KeyListenerTest;
//Purpose of code is to sample movement and make score increase when certain conditions are met
//Philip G
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class KeyListenerTester extends JFrame implements KeyListener {
    Image imgPlayer1 = Toolkit.getDefaultToolkit().createImage("Player1.png");
    Image imgPlayer2 = Toolkit.getDefaultToolkit().createImage("Player2.png");
    Image imgBulletUp = Toolkit.getDefaultToolkit().createImage("BulletUp.png");
    Image imgBulletSide = Toolkit.getDefaultToolkit().createImage("BulletSide.png");
    JLabel label;
    static int nX1 = 300, nY1 = 300, nX2 = 100, nY2 = 100, nScore1 = 0, nScore2 = 0, nLastDirection1 = 1, nLastDirection2 = 1;
    static int nX1BulletUP = nX1, nY1BulletUP = nY1, nX1BulletSIDE = nX1, nY1BulletSIDE = nY1, nX2BulletSIDE = nX2, nY2BulletSIDE = nY2, nX2BulletUP = nX2, nY2BulletUP = nY2;
    //static int nX1Temp = nX1, nX2Temp = nX2, nY1Temp = nY1, nY2Temp = nY2;
    public KeyListenerTester(String s) {
        JPanel p = new JPanel();
        setTitle(s);
        label = new JLabel("Key Listener!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.add(label);
        add(p);
        addKeyListener(this);
        setSize(400, 400);
        setMinimumSize(new Dimension(400, 400));
        setVisible(true);

    }
////////////////////////////////////////////////////////////////////////////////////////////////////////
///the keyTyped code is nessessary for KeyListenerTester to work but nothing is needed inside it
    @Override
    public void keyTyped(KeyEvent e) {
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void keyPressed(KeyEvent e) {
        nX1BulletUP = nX1; nY1BulletUP = nY1; nX1BulletSIDE = nX1; nY1BulletSIDE = nY1; nX2BulletSIDE = nX2; nY2BulletSIDE = nY2; nX2BulletUP = nX2; nY2BulletUP = nY2;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            //System.out.println("Right key pressed");   //debug code
            nLastDirection1 = 2;
            nX1 +=2; //to move right
            //System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            //System.out.println("Left key pressed");
            nX1 -=2; //to move left
            nLastDirection1 = 4;
            //System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            //System.out.println("Up key pressed");
            nY1 -=2; //to move up
            nLastDirection1 = 1;
            //System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            //System.out.println("Down key pressed");
            nY1 +=2; //to move down
            nLastDirection1 = 3;
            //System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
        }
        if (e.getKeyCode() == KeyEvent.VK_M) {
            //System.out.println("Right key pressed");   //debug code
            Shoot(nX1, nY1, nLastDirection1, nX2, nY2); //to move right
            //System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            //System.out.println("W key pressed");
            nY2 -=2; //to move up
            nLastDirection2 = 1;
            //System.out.println("Object 2 at (" + nX2 + ", " + nY2 + ")");
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            //System.out.println("A key pressed");
            nX2 -=2; //to move right
            nLastDirection2 = 4;
            //System.out.println("Object 2 at (" + nX2 + ", " + nY2 + ")");
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            //System.out.println("S key pressed");
            nY2 +=2; //to move down
            nLastDirection2 = 3;
            //System.out.println("Object 2 at (" + nX2 + ", " + nY2 + ")");
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            //System.out.println("D key pressed");
            nX2 +=2; //to move left
            nLastDirection2 = 2;
            //System.out.println("Object 2 at (" + nX2 + ", " + nY2 + ")");
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            //System.out.println("Right key pressed");   //debug code
            Shoot(nX2, nY2, nLastDirection2, nX1, nY1); //to move right
            //System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key Released");
            System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
            System.out.println("Object 2 at (" + nX2 + ", " + nY2 + ")");
            System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
            /*if (nX1Temp<(nX1-10) || nX1Temp>(nX1+10) || nX2Temp<(nX2-10) || nX2Temp>(nX2+10)) {
                nScore+=100;
                nX1Temp = nX1; nX2Temp = nX2; nY1Temp = nY1; nY2Temp = nY2; //to shorten code since this in repeated alot
            }
            else nX1Temp = nX1;*/ //don't need easy scoreing now got bullets to kinda work
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key Released");
            System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
            System.out.println("Object 2 at (" + nX2 + ", " + nY2 + ")");
            System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Up key Released");
            System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
            System.out.println("Object 2 at (" + nX2 + ", " + nY2 + ")");
            System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Down key Released");
            System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
            System.out.println("Object 2 at (" + nX2 + ", " + nY2 + ")");
            System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("W key Released");
            System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
            System.out.println("Object 2 at (" + nX2 + ", " + nY2 + ")");
            System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("A key Released");
            System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
            System.out.println("Object 2 at (" + nX2 + ", " + nY2 + ")");
            System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("S key Released");
            System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
            System.out.println("Object 2 at (" + nX2 + ", " + nY2 + ")");
            System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("D key Released");
            System.out.println("Object 1 at (" + nX1 + ", " + nY1 + ")");
            System.out.println("Object 2 at (" + nX2 + ", " + nY2 + ")");
            System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void paint(Graphics g) {
        //System.out.println(g); //g = sun.java2d.SunGraphics2D[font=java.awt.Font[family=Dialog,name=Dialog,style=plain,size=12],color=java.awt.Color[r=0,g=0,b=0]]
        int nWidth1 = imgPlayer1.getWidth(rootPane)/2, nWidth2 = imgPlayer2.getWidth(rootPane)/2;
        int nHeight1 = imgPlayer1.getHeight(rootPane)/2, nHeight2 = imgPlayer2.getHeight(rootPane)/2;
        int nBWUp = imgBulletUp.getWidth(rootPane)/2, nBWSide = imgBulletSide.getWidth(rootPane)/2;
        int nBHUp = imgBulletUp.getHeight(rootPane)/2, nBHSide = imgBulletSide.getHeight(rootPane)/2;
        revalidate();
        repaint();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 2000, 2000);
        /*g.setColor(Color.RED);    //images work now
        g.fillRect (nX1, nY1, 5, 5);
        g.setColor(Color.BLUE);
        g.fillRect (nX2, nY2, 5, 5);*/
        g.drawImage(imgBulletUp, nX1BulletUP-nBWUp, nY1BulletUP-nBHUp, null);
        g.drawImage(imgBulletSide, nX1BulletSIDE-nBWSide, nY1BulletSIDE-nBHSide, null);
        g.drawImage(imgBulletUp, nX2BulletUP-nBWUp, nY2BulletUP-nBHUp, null);
        g.drawImage(imgBulletSide, nX2BulletSIDE-nBWSide, nY2BulletSIDE-nBHSide, null);
        g.drawImage(imgPlayer1, nX1-nWidth1, nY1-nHeight1, null);
        g.drawImage(imgPlayer2, nX2-nWidth2, nY2-nHeight2, null);
  }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void Shoot(int nX, int nY, int nDirection, int nXE, int nYE) {
        //System.out.println("Hi");
        if (nX == nX1 && nY == nY1) {
            //System.out.println("Bonjour");
            if (nDirection == 1) {
                while (nY1BulletUP>0) {
                    if (nY1BulletUP>(nYE-10) && nY1BulletUP<(nYE+10) && nX1BulletUP>(nXE-10)&& nX1BulletUP<(nXE+10)) {
                        nScore1+=10000;
                        System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
                        break;
                    }
                    nY1BulletUP-=2;
                    revalidate();
                    repaint();
                    //System.out.println("1Not working");
                }
            }
            if (nDirection == 2) {
                while (nX1BulletSIDE<1000) {
                    if (nY1BulletSIDE>(nYE-10) && nY1BulletSIDE<(nYE+10) && nX1BulletSIDE>(nXE-10)&& nX1BulletSIDE<(nXE+10)) {
                        nScore1+=10000;
                        System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
                        break;
                    }
                    nX1BulletSIDE+=2;
                    revalidate();
                    repaint();
                    //System.out.println("2Not working");
                }
            }
            if (nDirection == 3) {
                while (nY1BulletUP<1000) {
                    if (nY1BulletUP>(nYE-10) && nY1BulletUP<(nYE+10) && nX1BulletUP>(nXE-10)&& nX1BulletUP<(nXE+10)) {
                        nScore1+=10000;
                        System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
                        break;
                    }
                    nY1BulletUP+=2;
                    revalidate();
                    repaint();
                    //System.out.println("3Not working");
                }
            }
            if (nDirection == 4) {
                while (nX1BulletSIDE>0) {
                    if (nY1BulletSIDE>(nYE-10) && nY1BulletSIDE<(nYE+10) && nX1BulletSIDE>(nXE-10)&& nX1BulletSIDE<(nXE+10)) {
                        nScore1+=10000;
                        System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
                        break;
                    }
                    nX1BulletSIDE-=2;
                    revalidate();
                    repaint();
                    //System.out.println("4Not working");
                }
            }
        }
        else if (nX == nX2 && nY == nY2) {
            //System.out.println("Salut");
            if (nDirection == 1) {
                while (nY2BulletUP>0) {
                    if (nY2BulletUP>(nYE-10) && nY2BulletUP<(nYE+10) && nX2BulletSIDE>(nXE-10)&& nX2BulletSIDE<(nXE+10)) {
                        nScore2+=10000;
                        System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
                        break;
                    }
                    nY2BulletUP-=2;
                    revalidate();
                    repaint();
                    //System.out.println("5Not working");
                }
            }
            if (nDirection == 2) {
                while (nX2BulletSIDE<1000) {
                    if (nY2BulletUP>(nYE-10) && nY2BulletUP<(nYE+10) && nX2BulletSIDE>(nXE-10)&& nX2BulletSIDE<(nXE+10)) {
                        nScore2+=10000;
                        System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
                        break;
                    }
                    nX2BulletSIDE+=2;
                    revalidate();
                    repaint();
                    //System.out.println("6Not working");
                }
            }
            if (nDirection == 3) {
                while (nY2BulletUP<1000) {
                    if (nY2BulletUP>(nYE-10) && nY2BulletUP<(nYE+10) && nX2BulletSIDE>(nXE-10)&& nX2BulletSIDE<(nXE+10)) {
                        nScore2+=10000;
                        System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
                        break;
                    }
                    nY2BulletUP+=2;
                    revalidate();
                    repaint();
                    //System.out.println("7Not working");
                }
            }
            if (nDirection == 4) {
                while (nX2BulletSIDE>0) {
                    if (nY2BulletUP>(nYE-10) && nY2BulletUP<(nYE+10) && nX2BulletSIDE>(nXE-10)&& nX2BulletSIDE<(nXE+10)) {
                        nScore2+=10000;
                        System.out.println("Player1 Score: " + nScore1 + "  Player2 Score: " + nScore2);
                        break;
                    }
                    nX2BulletSIDE-=2;
                    revalidate();
                    repaint();
                    //System.out.println("8Not working");
                }
            }
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        new KeyListenerTester("Key Listener Tester");
    }
}