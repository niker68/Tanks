package com.niker68.tanks;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Game{
    static Tank tank0,tank1,tank2,tank3,tank4;
    static int edgeX = 25;
    static int edgeY = 25;
    static int mashtab = 10;
    static int smeshenie = 40;
    static volatile int  delay = 100;
    static volatile int  speedOfTanks = 250;
    static volatile ArrayList <Tank> listOfTanks = new ArrayList<>();
    static volatile ArrayList <Bullet> listOfBullets = new ArrayList<>();
    static Window window;
    static Thread windowThread;
    static Thread aIThread1;
    static Thread aIThread2;
    static Thread aIThread3;
    static Thread aIThread4;
    static Thread respawnThread;
    static JFrame w;
    static int deaths = 0;
    static int frags = 0;
    static int delayOfRespawn=4000;
    public static void main(String[] args) throws IOException, InterruptedException  {
        w = new JFrame("Окно с изображением");
        w.setSize(edgeX*mashtab+smeshenie*2, edgeY*mashtab+smeshenie*2);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        w.setLayout(new BorderLayout(1, 1));
        w.addKeyListener(new KeyBoard());
        //стартовая расстановка танков, 4 вражеских по углам и подконтрольный игроку в центре.
        tank0 = new Tank(12,12,false);
        tank1 = new Tank(0,0,true);
        tank2 = new Tank(0,24,true);
        tank3 = new Tank(24,0,true);
        tank4 = new Tank(24,24,true);
        listOfTanks.add(tank1);
        listOfTanks.add(tank2);
        listOfTanks.add(tank3);
        listOfTanks.add(tank4);
        //вражеские танки отданы под контроль искусственному интеллекту, отвечающему за движение.
        AI ai1 =new AI(tank1);
        AI ai2 =new AI(tank2);
        AI ai3 =new AI(tank3);
        AI ai4 =new AI(tank4);
        //вражеские танки отданы под контроль искусственному интеллекту, отвечающему за стрельбу.
        Thread AI1ShootingThread = new Thread(new AIShooting(tank1));
        AI1ShootingThread.start();
        Thread AI2ShootingThread = new Thread(new AIShooting(tank2));
        AI2ShootingThread.start();
        Thread AI3ShootingThread = new Thread(new AIShooting(tank3));
        AI3ShootingThread.start();
        Thread AI4ShootingThread = new Thread(new AIShooting(tank4));
        AI4ShootingThread.start();
        aIThread1 = new Thread(ai1);
        aIThread1.start();
        aIThread2 = new Thread(ai2);
        aIThread2.start();
        aIThread3 = new Thread(ai3);
        aIThread3.start();
        aIThread4 = new Thread(ai4);
        aIThread4.start();
        window = new Window(w);
        windowThread = new Thread(window);
        windowThread.start();
        respawnThread = new Thread(new TanksRespawn());
        respawnThread.start();
    }
    //обновление по кнопке при уничтожении подконтрольного танка. Появление его на начальной точке.
    public static void refresh(){
        if (!tank0.isAlive()) {
            System.out.println("refresh");
            tank0.setCoordinateX(12);
            tank0.setCoordinateY(12);
        }

    }
    public static void tanksRespawn(){

    }
}
