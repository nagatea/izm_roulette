package main;

import core.Main;
import core.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;



/**
 * Created by nagatea on 2017/12/01.
 */
public class MainScene extends Scene {
    private Roulette roulette;
    @Override
    public void initialize() {
        super.initialize();
        roulette = new Roulette();
    }

    @Override
    public void step() {
        super.step();
        roulette.step();
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 50));
        g.drawString("This is MainScene", (int)((float)0.5* Main.FRAMESIZE_W - 155), (int)((float) 0.2*Main.FRAMESIZE_H));
        roulette.draw(g);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
