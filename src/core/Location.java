package core;

import java.awt.*;

/**
 * Created by nagatea on 2017/12/08.
 */
public class Location {
    private int width;
    private int height;
    private FontMetrics fontMetrics;

    public Location(){
        width = Main.FRAMESIZE_W;
        height = Main.FRAMESIZE_H;
    }

    public int getWidthLocation(int per){
        width = (int)((float)per*Main.FRAMESIZE_W/100);
        return width;
    }

    public int getHeightLocation(int per){
        height = (int)((float)per*Main.FRAMESIZE_H/100);
        return height;
    }

    public int getWidthLocation(int per, int offSet){
        width = (int)((float)per*Main.FRAMESIZE_W/100 - offSet);
        return width;
    }

    public int getHeightLocation(int per, int offSet){
        height = (int)((float)per*Main.FRAMESIZE_H/100 - offSet);
        return height;
    }

    public int getFontSize(int per){
        height = (int)((float)per*Main.FRAMESIZE_H/100);
        return height;
    }

    private int getWidthFontSize(Graphics2D g, String str){
        fontMetrics = g.getFontMetrics();
        int res = fontMetrics.stringWidth(str);
        return res;
    }

    private int getHeightFontSize(Graphics2D g){
        fontMetrics = g.getFontMetrics();
        int res = fontMetrics.getHeight();
        return res;
    }

    public int getWidthFontLocation(Graphics2D g, String str, int per){
        int res = getWidthLocation(per, getWidthFontSize(g, str)/2);
        return res;
    }

    public int getHeightFontLocation(Graphics2D g, int per){
        int res = getHeightLocation(per, getHeightFontSize(g)/2);
        return res;
    }
}
