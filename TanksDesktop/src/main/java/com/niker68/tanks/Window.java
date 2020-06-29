package com.niker68.tanks;


import javax.swing.*;

public class Window extends JFrame implements Runnable{

    private Canvas canv;
       private JFrame w;
        public Window(JFrame w){
            this.w = w;
            canv=new Canvas();
            w.add(canv);
            w.setVisible(true);
        }
        @Override
        public void run() {

            /* Задание заголовка окна*/
            while(!Thread.currentThread().isInterrupted()) {
                //System.out.println("отрисовал");
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                w.repaint();

            }
        }






    }
