package Bullet;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author gajdp9323
 */

public class PanGame extends JPanel // panel definition
{
    Image imgBack = Toolkit.getDefaultToolkit().createImage("background.jpg");
    Bullet bullet = new Bullet();
    public PanGame() {
        //add(lblName); //add it to the Frame
    }
    public void paint(Graphics g)
    {
        revalidate();
        repaint();
        // Draws the img to the BackgroundPanel.
        g.drawImage(imgBack, 0, 0, null);
    }

    /*void UpdateLabel(String _sNew) {
        sLabel = _sNew;
        lblName.setText(sLabel);
    }    */
}