package com.niker68.tanks;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard extends KeyAdapter implements KeyListener {
    public void keyPressed(KeyEvent event) {
        //задание клавиш управления с клавиатуры.
        int key = event.getKeyCode();
        if (key == KeyEvent.VK_UP) Game.tank0.MoveUp();
        if (key == KeyEvent.VK_DOWN) Game.tank0.MoveDown();
        if (key == KeyEvent.VK_RIGHT) Game.tank0.MoveRight();
        if (key == KeyEvent.VK_LEFT) Game.tank0.MoveLeft();
        if (key == KeyEvent.VK_SPACE) Game.tank0.shoot();
        if (key == KeyEvent.VK_NUMPAD0) Game.refresh();
    }
}