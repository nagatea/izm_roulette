package core;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by nagatea on 2017/11/29.
 */
public class KeyManager implements KeyListener {
    private boolean[] keyPre;
    private boolean[] keyNow;
    private boolean[] keyNext;

    public KeyManager(JFrame frame){
        keyPre = new boolean[128];
        keyNow = new boolean[128];
        keyNext = new boolean[128];
        frame.addKeyListener(this);
    }

    public void update(){
        keyPre = keyNow.clone();
        keyNow = keyNext.clone();
    }

    public boolean isPressed(int key){
        return keyNow[key];
    }

    public boolean isJustPressed(int key){
        return !keyPre[key] && keyNow[key];
    }

    public boolean isJustReleased(int key){
        return keyPre[key] && !keyNow[key];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //unused
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() < 128) keyNext[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() < 128) keyNext[e.getKeyCode()] = false;
    }
}
