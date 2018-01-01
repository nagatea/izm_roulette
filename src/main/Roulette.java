package main;

import core.Location;
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
    public int stringSize;
    BasicStroke wideStroke = new BasicStroke(4.0f);
    private Location location = new Location();
    private String string;
    private String time;
    private String nextData = "";
    private BufferedImage image;
    public enum Chapter{
        PREPARE, READY, RUN, STOP, SHOW, CHANGE, END,
    }
    public static Chapter chapter;
    private RouletteTimer timer;
    private Boolean isTimerInit = true;
    private Thread timerThread;

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
                if (remain > 1){
                    data = memberList.popList();
                    remain--;
                }else{
                    remain--;
                    chapter = Chapter.END;
                    break;
                }
                image = Main.resource.image.load(data[2]);
                nextData = "Next =" + data[0] + data[1] + data[2];
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
                    count = 0;
                    chapter = Chapter.SHOW;
                }
                break;
            case SHOW:
                if (Main.input.key.isJustPressed(KeyEvent.VK_ENTER)){
                    chapter = Chapter.CHANGE;
                }
                break;
            case CHANGE:
                if (!isTimerInit){
                    isTimerInit = true;
                }
                if (Main.input.key.isJustPressed(KeyEvent.VK_ENTER)){
                    chapter = Chapter.PREPARE;
                }
                break;
            case END:
                break;
        }
    }

    public void draw(Graphics2D g){
        if (Main.isDebug){
            g.setColor(Color.GRAY);
            g.setFont(new Font("ＭＳ ゴシック", Font.BOLD, location.getFontSize(5)));
            string = "Chapter = " + chapter.toString();
            g.drawString(string, location.getWidthFontLocation(g, string, 1, "left"), location.getHeightFontLocation(g, 5));
            g.drawString(nextData, location.getWidthFontLocation(g, nextData, 1, "left"), location.getHeightFontLocation(g, 10));
            string = "Count = " + count;
            g.drawString(string, location.getWidthFontLocation(g, string, 1, "left"), location.getHeightFontLocation(g, 15));
        }
        switch (chapter){
            case READY:
                g.setColor(Color.BLACK);
                g.setFont(new Font("UD デジタル 教科書体 N-B", Font.BOLD, location.getFontSize(50)));
                string = "??";
                g.drawString(string, location.getWidthFontLocation(g, string, 50), location.getHeightFontLocation(g, 40));
                break;
            case RUN:
                if (count > 60){
                    count = 0;
                }else {
                    count++;
                }
                g.setColor(Color.BLACK);
                if(count%10 == 0){
                    int i = (int)(Math.random()*(memberList.getSize() + 1));
                    nowNumber = number[i];
                    int counter = 0;
                    while(nowNumber.equals("??") && counter < 10){
                        i = (int)(Math.random()*(memberList.getSize() + 1));
                        nowNumber = number[i];
                        counter++;
                    }
                }
                g.setFont(new Font("UD デジタル 教科書体 N-B", Font.BOLD, location.getFontSize(50)));
                g.drawString(nowNumber, location.getWidthFontLocation(g, nowNumber, 50), location.getHeightFontLocation(g, 40));
                break;
            case STOP:
                g.setColor(Color.BLACK);
                if (count >= 1000){
                    count = 1000;
                }else if (count >= 0){
                    count++;
                }
                if (count <= 200){
                    g.setFont(new Font("UD デジタル 教科書体 N-B", Font.BOLD, location.getFontSize(50)));
                    g.drawString(data[0], location.getWidthFontLocation(g, data[0], 50), location.getHeightFontLocation(g, 40));
                }else if(count <= 300){
                    //g.setFont(new Font("UD デジタル 教科書体 N-B", Font.BOLD, location.getAnimation(location.getFontSize(50), location.getFontSize(20), count-150)));
                    //g.drawString(data[0], location.getAnimation(location.getWidthFontLocation(g, data[0], 50), location.getWidthFontLocation(g, data[0], 20), count-150), location.getAnimation(location.getHeightFontLocation(g, 40), location.getHeightFontLocation(g, 80), count-150));
                    g.setFont(new Font("UD デジタル 教科書体 N-B", Font.BOLD, location.getFontSize(50)));
                    g.drawString(data[0], location.getWidthFontLocation(g, data[0], 50), location.getHeightFontLocation(g, 40));
                    g.setStroke(wideStroke);
                    g.drawRect(location.getWidthLocation(50, location.getAnimation(location.getWidthLocation(0), location.getWidthLocation(34), count-200)/2), location.getHeightLocation(35, location.getHeightLocation(65)/2), location.getAnimation(location.getWidthLocation(0), location.getWidthLocation(34), count-200), location.getHeightLocation(65));

                    g.drawImage(image, location.getWidthLocation(50, location.getAnimation(location.getWidthLocation(0), location.getWidthLocation(34), count-200)/2), location.getHeightLocation(35, location.getHeightLocation(65)/2), location.getAnimation(location.getWidthLocation(0), location.getWidthLocation(34), count-200), location.getHeightLocation(65), null);
                }else{
                    g.setStroke(wideStroke);
                    g.drawRect(location.getWidthLocation(50, location.getWidthLocation(34)/2), location.getHeightLocation(35, location.getHeightLocation(65)/2), location.getWidthLocation(34), location.getHeightLocation(65));
                    g.drawImage(image, location.getWidthLocation(50, location.getWidthLocation(34)/2), location.getHeightLocation(35, location.getHeightLocation(65)/2), location.getWidthLocation(34), location.getHeightLocation(65), null);
                }
                break;
            case SHOW:
                g.setColor(Color.BLACK);
                //g.setFont(new Font("UD デジタル 教科書体 N-B", Font.BOLD, location.getFontSize(10)));
                //g.drawString("出席番号", location.getWidthFontLocation(g, "出席番号", 18), location.getHeightFontLocation(g, 25));
                //g.setFont(new Font("UD デジタル 教科書体 N-B", Font.BOLD, location.getFontSize(30)));
                //g.drawString(data[0], location.getWidthFontLocation(g, data[0], 18), location.getHeightFontLocation(g, 45));
                //g.setFont(new Font("UD デジタル 教科書体 N-B", Font.BOLD, location.getFontSize(20)));
                //g.drawString(data[0], location.getWidthFontLocation(g, data[0], 18), location.getHeightFontLocation(g, 80));
                if (count >= 1000){
                    count = 1000;
                }else if (count >= 0){
                    count++;
                }
                g.setStroke(wideStroke);
                g.drawRect(location.getWidthLocation(50, location.getWidthLocation(34)/2), location.getHeightLocation(35, location.getHeightLocation(65)/2), location.getWidthLocation(34), location.getHeightLocation(65));
                g.drawImage(image, location.getWidthLocation(50, location.getWidthLocation(34)/2), location.getHeightLocation(35, location.getHeightLocation(65)/2), location.getWidthLocation(34), location.getHeightLocation(65), null);
                string = data[1];
                if(count <= 300){
                    g.setFont(new Font("UD デジタル 教科書体 N-B", Font.BOLD, location.getFontSize(15)));
                    time = "01:00";
                    g.drawString(time, location.getWidthFontLocation(g, time, 84), location.getHeightFontLocation(g, 45));
                    //g.setFont(new Font("UD デジタル 教科書体 N-B", Font.BOLD, location.getFontSize(20)));
                    //g.drawString(data[0], location.getWidthFontLocation(g, data[0], 20), location.getHeightFontLocation(g, 80));
                    g.setFont(new Font("UD デジタル 教科書体 N-B", Font.BOLD, location.getFontSize(15)));
                    if(string.length() > (count)/25){
                        stringSize = (count)/25;
                    }else {
                        stringSize = string.length();
                    }
                    g.drawString(string.substring(0, stringSize), location.getWidthFontLocation(g, string, 50), location.getHeightFontLocation(g, 80));
                }else {
                    if (isTimerInit){
                        timer = new RouletteTimer(1, 0);
                        timerThread = new Thread(timer);
                        timerThread.start();
                        isTimerInit = false;
                    }
                    g.setFont(new Font("UD デジタル 教科書体 N-B", Font.BOLD, location.getFontSize(15)));
                    time = timer.getTimer();
                    g.drawString(time, location.getWidthFontLocation(g, time, 84), location.getHeightFontLocation(g, 45));
                    //g.setFont(new Font("UD デジタル 教科書体 N-B", Font.BOLD, location.getFontSize(20)));
                    //g.drawString(data[0], location.getWidthFontLocation(g, data[0], 20), location.getHeightFontLocation(g, 80));
                    g.setFont(new Font("UD デジタル 教科書体 N-B", Font.BOLD, location.getFontSize(15)));
                    g.drawString(string, location.getWidthFontLocation(g, string, 50), location.getHeightFontLocation(g, 80));
                    }
                break;
            case CHANGE:
                break;
            case END:
                break;
        }
    }
}
