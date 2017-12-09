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

    public int getWidthLocation(double per){
        width = (int)(per*Main.FRAMESIZE_W/100);
        return width;
    }

    public int getHeightLocation(double per){
        height = (int)(per*Main.FRAMESIZE_H/100);
        return height;
    }

    public int getWidthLocation(double per, int offSet){
        width = (int)(per*Main.FRAMESIZE_W/100 - offSet);
        return width;
    }

    public int getHeightLocation(double per, int offSet){
        height = (int)(per*Main.FRAMESIZE_H/100 - offSet);
        return height;
    }

    public int getFontSize(double per){
        height = (int)(per*Main.FRAMESIZE_H/100);
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

    public int getWidthFontLocation(Graphics2D g, String str, double per){
        int res = getWidthLocation(per, getWidthFontSize(g, str)/2);
        return res;
    }

    public int getWidthFontLocation(Graphics2D g, String str, double per, String align){
        int res;
        switch (align){
            case "left":
                res = getWidthLocation(per);
                break;
            case "right":
                res = getWidthLocation(per, getWidthFontSize(g, str));
                break;
            default: //center
                res = getWidthLocation(per, getWidthFontSize(g, str)/2);
                break;
        }
        return res;
    }

    public int getHeightFontLocation(Graphics2D g, int per){
        int res = getHeightLocation(per, -getHeightFontSize(g)/2);
        return res;
    }
}
