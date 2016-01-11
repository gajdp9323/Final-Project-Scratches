package KeyListenerTest;

//Philip G
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class KeyListenerTester extends JFrame implements KeyListener {

    JLabel label;

    public KeyListenerTester(String s) {
        JPanel p = new JPanel();
        label = new JLabel("Key Listener!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.add(label);
        add(p);
        addKeyListener(this);
        setSize(200, 100);
        setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Up key typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Down key typed");
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key pressed");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key pressed");
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Up key pressed");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Down key pressed");
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("W key pressed");
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("A key pressed");
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("S key pressed");
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("D key pressed");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key Released");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key Released");
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Up key Released");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Down key Released");
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("W key Released");
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("A key Released");
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("S key Released");
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("D key Released");
        }
    }
    public static void main(String[] args) {
        new KeyListenerTester("Key Listener Tester");
    }
}