package com.niker68.tanks;

public class TanksRespawn implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
        try {
            Thread.sleep(Game.delayOfRespawn);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!Game.tank1.isAlive()){
            Game.tank1.setCoordinateY(0);
            Game.tank1.setCoordinateX(0);
            Game.tank1.setAlive(true);
        }
        if (!Game.tank2.isAlive()){
            Game.tank2.setCoordinateY(24);
            Game.tank2.setCoordinateX(0);
            Game.tank2.setAlive(true);
        }
        if (!Game.tank3.isAlive()){
            Game.tank3.setCoordinateY(0);
            Game.tank3.setCoordinateX(24);
            Game.tank3.setAlive(true);
        }
        if (!Game.tank4.isAlive()){
            Game.tank4.setCoordinateY(24);
            Game.tank4.setCoordinateX(24);
            Game.tank4.setAlive(true);
        }
        }
    }
}
