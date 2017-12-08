package main;

import core.Main;
import core.SceneManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.*;

/**
 * Created by nagatea on 2017/12/01.
 */
public class Roulette {
    public MemberList memberList;
    public ArrayList<String[]> list;
    public static String[] data;
    public String[] number;
    public String nowNumber = "0";
    public static int remain;
    public int count;
    private BufferedImage image;
    public enum Chapter{
        PREPARE, READY, RUN, STOP, CHANGE,
    }
    public static Chapter chapter;

    public Roulette(){
        memberList = new MemberList();
        list = memberList.getMemberList();
        remain = memberList.getSize() + 1;
        memberList.shuffleList();
        chapter = Chapter.PREPARE;
    }

    public void step(){
        switch (chapter){
            case PREPARE:
                number = memberList.getNumber();
                if (remain >= 1){
                    data = memberList.popList();
                    remain--;
                }else{
                    data = memberList.getList();
                }
                image = Main.resource.image.load(data[2]);
                System.out.println(data[0] + data[1] + data[2]);
                chapter = Chapter.READY;
                break;
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
                    chapter = Chapter.PREPARE;
                }
                break;
        }
    }

    public void draw(Graphics2D g){
        if (count > 60){
            count = 0;
        }else {
            count++;
        }
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
                if(count%20 == 0){
                    int i = (int)(Math.random()*(memberList.getSize()));
                    nowNumber = number[i];
                }
                g.drawString(nowNumber, (int)((float)0.5* Main.FRAMESIZE_W - 155), (int)((float) 0.7*Main.FRAMESIZE_H));
                break;
            case STOP:
                g.setColor(Color.BLACK);
                g.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 50));
                g.drawString("STOP", (int)((float)0.5* Main.FRAMESIZE_W - 155), (int)((float) 0.5*Main.FRAMESIZE_H));
                g.drawString(data[0], (int)((float)0.5* Main.FRAMESIZE_W - 155), (int)((float) 0.7*Main.FRAMESIZE_H));
                g.drawString(data[1], (int)((float)0.5* Main.FRAMESIZE_W - 155), (int)((float) 0.8*Main.FRAMESIZE_H));
                g.drawImage(image, (int)((float)0.8*Main.FRAMESIZE_W - 200) , (int)((float)0.5*Main.FRAMESIZE_H - 200), 400, 400, null);
                break;
            case CHANGE:
                g.setColor(Color.BLACK);
                g.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 50));
                g.drawString("CHANGE", (int)((float)0.5* Main.FRAMESIZE_W - 155), (int)((float) 0.5*Main.FRAMESIZE_H));
                break;
        }
    }
}
