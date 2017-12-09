package main;

import core.Location;
import core.Main;
import core.Scene;

import java.awt.*;
import java.awt.event.KeyEvent;



/**
 * Created by nagatea on 2017/12/01.
 */
public class MainScene extends Scene {
    private Roulette roulette;
    private Location location = new Location();
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
        g.setFont(new Font("ＭＳ ゴシック", Font.BOLD, location.getFontSize(5)));
        String string = "This is MainScene(残り"+ Roulette.remain +"人)";
        g.drawString(string, location.getWidthFontLocation(g, string, 50), location.getHeightFontLocation(g, 10));
        roulette.draw(g);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
