package main;

import core.Main;
import core.SceneManager;

import java.awt.*;
import java.awt.event.KeyEvent;

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
                if (Main.input.key.isJustPressed(KeyEvent.VK_ENTER)){
                    chapter = Chapter.RUN;
                }
                break;
            case RUN:
                if (Main.input.key.isJustPressed(KeyEvent.VK_ENTER)){
                    chapter = Chapter.STOP;
                }
                break;
            case STOP:
                if (Main.input.key.isJustPressed(KeyEvent.VK_ENTER)){
                    chapter = Chapter.CHANGE;
                }
                break;
            case CHANGE:
                if (Main.input.key.isJustPressed(KeyEvent.VK_ENTER)){
                    chapter = Chapter.READY;
                }
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
                g.setColor(Color.BLACK);
                g.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 50));
                g.drawString("RUN", (int)((float)0.5* Main.FRAMESIZE_W - 155), (int)((float) 0.5*Main.FRAMESIZE_H));
                break;
            case STOP:
                g.setColor(Color.BLACK);
                g.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 50));
                g.drawString("STOP", (int)((float)0.5* Main.FRAMESIZE_W - 155), (int)((float) 0.5*Main.FRAMESIZE_H));
                break;
            case CHANGE:
                g.setColor(Color.BLACK);
                g.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 50));
                g.drawString("CHANGE", (int)((float)0.5* Main.FRAMESIZE_W - 155), (int)((float) 0.5*Main.FRAMESIZE_H));
                break;
        }
    }
}
