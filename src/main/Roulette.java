package main;

import core.Main;

import java.awt.*;

/**
 * Created by nagatea on 2017/12/01.
 */
public class Roulette {
    public enum Chapter{
        READY, RUN, STOP, CHANGE,
    }
    public static Chapter chapter;

    public Roulette(){
        chapter = Chapter.READY;
    }

    public void step(){
        switch (chapter){
            case READY:
                break;
            case RUN:
                break;
            case STOP:
                break;
            case CHANGE:
                break;
        }
    }

    public void draw(Graphics2D g){
        switch (chapter){
            case READY:
                g.setColor(Color.BLACK);
                g.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 50));
                g.drawString("READY", (int)((float)0.5* Main.FRAMESIZE_W - 155), (int)((float) 0.5*Main.FRAMESIZE_H));
                break;
            case RUN:
                break;
            case STOP:
                break;
            case CHANGE:
                break;
        }
    }
}
