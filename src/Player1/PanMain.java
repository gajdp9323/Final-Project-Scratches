package Player1;


import javax.swing.*;
import java.awt.*;

public class PanMain extends JPanel // panel definition
{
    PanDisp panDisp = new PanDisp();

    public PanMain() {
        // this next line tells PanMain that it has a border layout.
        setLayout(new BorderLayout());
        add(panDisp, BorderLayout.CENTER);       
    }
}