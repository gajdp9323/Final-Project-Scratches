/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stats;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author phili
 */
public class Timer1 {
    Toolkit toolkit;
    Timer timer;
    public Timer1() {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTask(), 1000);
    }
    class RemindTask extends TimerTask {
    public void run() {
        
    }
  }
}
/*if (arnTimeStuffValues[1] == 59) {
                arnTimeStuffValues[2]++;
                arnTimeStuffValues[3]+=50;
                arnTimeStuffValues[4]+=50;
            }
            else {
                arnTimeStuffValues[1]++;
                arnTimeStuffValues[3]+=50;
                arnTimeStuffValues[4]+=50;
            }*/
