package main;

import core.Main;
import core.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by nagatea on 2017/12/01.
 */
public class MainScene extends Scene {
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
        g.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 50));
        g.drawString("This is MainScene", (int)((float)0.5* Main.FRAMESIZE_W - 155), (int)((float) 0.2*Main.FRAMESIZE_H));
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
