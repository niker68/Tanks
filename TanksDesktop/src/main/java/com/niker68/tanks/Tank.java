package com.niker68.tanks;

public class Tank implements TankInterface {
    private int coordinateX;
    private int coordinateY;

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public boolean isAlive() {
        return isAlive;
    }

    private boolean isAlive = true;

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    private boolean enemyTank;

    private EnumOfOrientation orientation = EnumOfOrientation.down;

    public EnumOfOrientation getOrientation() {
        return orientation;
    }


    public Tank(int coordinateX,int coordinateY,boolean enemyTank){
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.enemyTank = enemyTank;
    }

    @Override
    public boolean MoveUp() {
        if (coordinateY!=0) {
            orientation = EnumOfOrientation.up;
            coordinateY = coordinateY - 1;
            return true;
        }else {return false;}
    }

    @Override
    public boolean MoveDown() {

        if (coordinateY<Game.edgeY) {
            coordinateY = coordinateY+1;
            orientation = EnumOfOrientation.down;
            return true;
        }else {return false;}
    }
    @Override
    public boolean MoveRight() {
        if (coordinateX<Game.edgeX) {
            coordinateX = coordinateX+1;
            orientation = EnumOfOrientation.right;
            //System.out.println("танк вправо");
            return true;
        }else {return false;}


    }


    public void TankDestroyed(){
        coordinateX = -100;
        coordinateY = -100;
        isAlive = false;
    }
    @Override
    public boolean MoveLeft() {
        if (coordinateX>0) {
            coordinateX = coordinateX-1;
            orientation = EnumOfOrientation.left;
            return true; //System.out.println("танк влево");
        }else{
        return false;}
    }

    @Override
    public void shoot() {
        //System.out.println("Танк выстрелил");
        Bullet bullet;
        if (enemyTank){
            bullet = new Bullet(true,coordinateX,coordinateY);
        } else{
            bullet = new Bullet(false,coordinateX,coordinateY);
        }

        Game.listOfBullets.add(bullet);
        bullet.setCoordinatebulletX(this.coordinateX);
        bullet.setCoordinatebulletY(this.coordinateY);
        if (orientation.equals(EnumOfOrientation.down)){
            bullet.setDirection(EnumOfOrientation.down);
        }
        if (orientation.equals(EnumOfOrientation.up)){
            bullet.setDirection(EnumOfOrientation.up);
        }
        if (orientation.equals(EnumOfOrientation.right)){
            bullet.setDirection(EnumOfOrientation.right);
        }
        if (orientation.equals(EnumOfOrientation.left)){
            bullet.setDirection(EnumOfOrientation.left);
        }

            Thread thread = new Thread(bullet);
            thread.start();
    }

}
