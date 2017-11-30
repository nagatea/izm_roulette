/**
 * Created by nagatea on 2017/11/28.
 */

package core;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

import main.TitleScene;

public class Main {
    public static int FRAMESIZE_W = 1200;
    public static int FRAMESIZE_H = 900;
    private JFrame frame;
    public static Input input;
    public static Resource resource;
    public BufferStrategy buf;

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
        resource = new Resource();

        frame.createBufferStrategy(2);
        buf = frame.getBufferStrategy();

        SceneManager.changeScene(new TitleScene());
    }

    public void run(){
        initialize();
        while (true){
            Dimension size = frame.getContentPane().getSize();
            System.out.println("w = " + size.width);
            System.out.println("h = " + size.height);
            FRAMESIZE_W = size.width;
            FRAMESIZE_H = size.height;
            input.update();
            Graphics2D g = (Graphics2D) buf.getDrawGraphics();
            SceneManager.step();
            SceneManager.draw(g);
            buf.show();
            g.dispose();
        }
    }
}
