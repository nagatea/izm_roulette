/**
 * Created by nagatea on 2017/11/28.
 */

package core;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static final int FRAMESIZE_W = 1200;
    public static final int FRAMESIZE_H = 900;
    private JFrame frame;
    public static Input input;

    public static void main(String[] args){
        (new Main()).run();
    }

    private void initialize(){
        frame = new JFrame("izm_roulette");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //×ボタンを押したときの処理
        //frame.setResizable(true); //サイズ変更の可否
        frame.getContentPane().setPreferredSize(new Dimension(FRAMESIZE_W, FRAMESIZE_H));//ウィンドウの大きさ(内側)を決める
        frame.pack();
        frame.setVisible(true); //ウィンドウを可視化する

        input = new Input(frame);
    }

    public void run(){
        initialize();
    }
}
