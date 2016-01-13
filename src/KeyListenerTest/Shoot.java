/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyListenerTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author gajdp9323
 */
public class Shoot {
    int nX, nY, nDirection, nXE, nYE;
    Image imgBullet;
    public Shoot(int nXCor, int nYCor, int nDirect, int nEnemyX, int nEnemyY) {
        this.nX=nXCor;
        this.nY=nYCor;
        this.nDirection=nDirect;
        this.nXE=nEnemyX;
        this.nYE=nEnemyY;
        if (nDirection == 1 || nDirection == 3) {
            imgBullet = Toolkit.getDefaultToolkit().createImage("BulletUp.png");
            if (nDirection == 1) {
                BulletUp();
            }
            else if (nDirection == 3) {
                BulletDown();
            }
        }
        else if (nDirection == 2 || nDirection == 4) {
            imgBullet = Toolkit.getDefaultToolkit().createImage("BulletSide.png");
            if (nDirection == 2) {
                BulletRight();
            }
            else if (nDirection == 4) {
                BulletLeft();
            }
        }
    }
    public void BulletUp(){
        while (nY>0) {
            if (nY>(nYE+90) && nY<(nYE+90)) {
                
            }
            this.nY=-2;
            paint(null);
        }
    }
    public void BulletDown(){
        while (nY<1000) {
            this.nY=+2;
            paint(null);
        }
    }
    public void BulletRight(){
        while (nX<1000) {
            this.nX=+2;
            paint(null);
        }
    }
    public void BulletLeft(){
        while (nX>0) {
            this.nX=-2;
            paint(null);
        }
    }
    public void paint(Graphics g) {
        g.drawImage(imgBullet, nX, nY, null);
  }
}
