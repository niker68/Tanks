package com.niker68.tanks;

public class AIShooting implements Runnable {
private Tank tank;
public AIShooting(Tank tank){
    this.tank = tank;
}
    @Override
    public void run() {
    while(!Thread.currentThread().isInterrupted()){
        while (tank.isAlive()) {
            try {
                Thread.sleep((int)(Math.random()*300+400));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tank.shoot();
        }}
    }
}
