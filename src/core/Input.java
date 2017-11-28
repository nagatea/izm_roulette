package core;

import javax.swing.*;

/**
 * Created by nagatea on 2017/11/29.
 */
public class Input {
    public KeyManager key;

    public Input(JFrame frame){
        key = new KeyManager(frame);
    }

    public void update(){
        key.update();
    }
}
