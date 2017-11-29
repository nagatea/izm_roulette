/**
 * Created by nagatea on 2017/11/29.
 */

package main;

import core.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class TitleScene extends Scene {
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
        //g.setColor(Color.white);
        //g.fillRect(0, 0, 600, 800);
        g.setColor(Color.black);
        g.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 100));
        g.drawString("たいとる", 500, 300);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
