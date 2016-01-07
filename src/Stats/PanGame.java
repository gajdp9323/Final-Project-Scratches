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
        /*try {
            Thread.sleep(1000);
        } catch(InterruptedException ie) {
            if (nTimeSec == 59) nTimeMin++; nPlayer1Score+=50;nPlayer2Score+=50;
            else nTimeSec++;
        }*/
    }

    /*void UpdateLabel(String _sNew) {
        sLabel = _sNew;
        lblName.setText(sLabel);
    }    */
}