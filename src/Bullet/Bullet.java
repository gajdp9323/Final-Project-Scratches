
package Bullet;

//import java.awt.Image;
import java.awt.*;
//import javax.imageio.ImageIO;
//import java.io.File;
//import java.io.IOException;
/**
 *
 * @author gajdp9323
 */
public class Bullet{
    int nX = 300;
    int nY = 300;
    //final BufferedImage imgBulletSide = ImageIO.read(new File("BulletSide.png"));
    //final BufferedImage imgBulletUp = ImageIO.read(new File("BulletSide.png"));
    Image imgBulletSide = Toolkit.getDefaultToolkit().createImage("BulletSide.png");
    Image imgBulletUp = Toolkit.getDefaultToolkit().createImage("BulletUp.png");
    
    public void paint(Graphics g) {
        g.drawImage(imgBulletSide, nX, nY, null);
        g.drawImage(imgBulletUp, nX, nY, null);
    }
}