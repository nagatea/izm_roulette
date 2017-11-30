/**
 * Created by nagatea on 2017/11/29.
 */

package main;

import core.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class TitleScene extends Scene {
    private BufferedImage titleImage = Main.resource.image.load("test/image/title.png");
    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void step() {
        super.step();
        if (Main.input.key.isJustPressed(KeyEvent.VK_ESCAPE)){
            System.exit(0);
        }
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        g.drawImage(titleImage, 50, 350, 1000, 400, null);
        //g.setColor(Color.white);
        //g.fillRect(0, 0, 600, 800);
        g.setColor(Color.black);
        g.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 100));
        g.drawString("たいとる", 400, 300);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
