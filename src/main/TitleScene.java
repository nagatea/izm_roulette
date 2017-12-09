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
    private String string;
    private Location location = new Location();
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
        g.drawImage(titleImage, location.getWidthLocation(50, location.getWidthLocation(50)/2), location.getHeightLocation(50, location.getHeightLocation(40)/2), location.getWidthLocation(50), location.getHeightLocation(40), null);
        g.setColor(Color.black);
        g.setFont(new Font("ＭＳ ゴシック", Font.BOLD, location.getFontSize(10)));
        string = "たいとる";
        g.drawString(string, location.getWidthFontLocation(g, string, 50), location.getHeightFontLocation(g, 15));
        g.setFont(new Font("ＭＳ ゴシック", Font.BOLD, location.getFontSize(3.5)));
        string = "PRESS ENTER";
        g.drawString("PRESS ENTER", location.getWidthFontLocation(g, string, 50), location.getHeightFontLocation(g, 85));
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
