package core;

import java.awt.*;

/**
 * Created by nagatea on 2017/11/28.
 */

public class SceneManager {
    public enum CHANGE{NOMAL} //列挙型
    public static Scene nextScene;
    public static Scene nowScene;
    private static boolean changeNow = false;
    private static int frame;
    private static int lastFrame;
    private static CHANGE mode;

    public static void step(){
        if(changeNow) {
            nextScene.step();
            frame++;
            if (frame > lastFrame) {
                nextScene.initialize();
                nowScene = nextScene;
                nextScene = null;
                changeNow = false;
            }
        }
        nowScene.step();
    }

    public static void draw(Graphics2D g){
        if(changeNow){
            g.translate(300, 0);
            nextScene.draw(g);
        }
        nowScene.draw(g);
    }

    public static void changeScene(Scene scene){
        nowScene = scene;
        nowScene.initialize();
    }

    public static void changeScene(Scene scene, double sec, CHANGE _mode){
        scene.dispose();
        mode = _mode;
        lastFrame = (int)(60*sec);
        frame = 0;
        nextScene = scene;
        scene.initialize();
    }

    public static Scene getScene(){
        return nowScene;
    }

}
