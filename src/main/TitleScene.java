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
        if (Main.input.key.isJustPressed(KeyEvent.VK_ENTER)){
            SceneManager.changeScene(new MainScene());
        }
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        g.drawImage(titleImage, (int)((float)0.5*Main.FRAMESIZE_W - 500) , (int)((float)0.5*Main.FRAMESIZE_H - 200), 1000, 400, null);
        g.setColor(Color.black);
        g.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 100));
        g.drawString("たいとる", (int)((float)0.5*Main.FRAMESIZE_W - 200), (int)((float) 0.25*Main.FRAMESIZE_H - 50));
        g.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 50));
        g.drawString("PRESS ENTER", (int)((float)0.5*Main.FRAMESIZE_W - 155), (int)((float) 0.85*Main.FRAMESIZE_H));
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
