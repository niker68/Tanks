package com.niker68.tanks;

public class AI implements Runnable{
    private Tank tank;
    public AI(Tank tank){
        this.tank = tank;
    }
    public void MoveUp() throws InterruptedException {
        for (int i=0;i<(int)(Math.random()*3+3);i++){
            if (tank.MoveUp()){
            }else
            {tank.MoveDown();}
            Thread.sleep(Game.speedOfTanks);
        }
    }
    public void MoveDown() throws InterruptedException {
        for (int i=0;i<(int)(Math.random()*3+3);i++){
            if (tank.MoveDown()){
            } else {
                tank.MoveUp();
            }
            Thread.sleep(Game.speedOfTanks);
        }
    }
    public void MoveLeft() throws InterruptedException {
        for (int i=0;i<(int)(Math.random()*3+3);i++){
            if (tank.MoveLeft()){
            } else{
                tank.MoveRight();
            }
            Thread.sleep(Game.speedOfTanks);
        }
    }
    public void MoveRight() throws InterruptedException {
        for (int i=0;i<(int)(Math.random()*3+3);i++){
            if (tank.MoveRight()){
            } else {
                tank.MoveLeft();
            }
            Thread.sleep(Game.speedOfTanks);
        }
    }
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            while(tank.isAlive()){

            int i =(int) (Math.random()*3);
            switch (i) {
                case  (0):
                    try {
                        Thread.sleep(Game.speedOfTanks);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        MoveUp();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case (1):
                    try {
                        MoveDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case (2):
                    try {
                        MoveLeft();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case (3):
                    try {
                        MoveRight();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;

            }
        }
        }
    }
}
