//Philip
package Stats;

import java.awt.Color;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class PanStats extends JPanel // panel definition
{
    //PanDisp panDisp;
    //String sName;
    public JLabel Player1Lives;
    public JLabel Player2Lives;
    public JLabel Player1Score;
    public JLabel Player2Score;
    
    private JLabel Timer;
    int nPlayer1Lives = 5, nPlayer2Lives = 5, nPlayer1Score = 0,nPlayer2Score = 0, nTimeMin = 0, nTimeSec = 0;
    int arnTimerStuff [] = new int[4];

    public PanStats(PanDisp _panDisp) {
        revalidate();
        repaint();
        setBackground(Color.red);
        Player1Lives = new JLabel(" Player1 Lives: "+ nPlayer1Lives);
        Player1Score = new JLabel(" Player1 Score: "+ nPlayer1Score);
        Timer  = new JLabel (" Time "+ nTimeMin + ":" + nTimeSec);
        Player2Score  = new JLabel(" Player2 Score: "+ nPlayer2Score);
        Player2Lives  = new JLabel(" Player2 Lives: "+ nPlayer2Lives);
        add(Player1Lives);
        add(Player1Score);
        add(Timer);
        add(Player2Score);
        add(Player2Lives);
        new Timer1();
        if (nTimeSec == 59) {
            nTimeMin++;
            nPlayer1Score+=50;
            nPlayer2Score+=50;
        }
        else {
            nTimeSec++;
            nPlayer1Score+=50;
            nPlayer2Score+=50;
        }
    }
}