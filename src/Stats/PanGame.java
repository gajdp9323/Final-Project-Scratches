package Stats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
/**
 *
 * @author gajdp9323
 */

public class PanGame extends JPanel // panel definition
{
    Image img = Toolkit.getDefaultToolkit().createImage("background.jpg");
    
    public PanGame() {
        //add(lblName); //add it to the Frame
    }
    public void paint(Graphics g)
    {
        
        revalidate();
        repaint();
        // Draws the img to the BackgroundPanel.
        g.drawImage(img, 0, 0, null);
    }

    /*void UpdateLabel(String _sNew) {
        sLabel = _sNew;
        lblName.setText(sLabel);
    }    */
}