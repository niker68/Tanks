package com.niker68.tanks;

public class Bullet implements Runnable{
    boolean isAlive = true;
    boolean isReadyForShoot = true;
    private int coordinatebulletX;
    private int coordinatebulletY;
    private EnumOfOrientation direction = EnumOfOrientation.down;
    private boolean bulletOfEnemy;

    public Bullet (boolean bulletOfEnemy, int coordinateX, int coordinateY){
        this.bulletOfEnemy = bulletOfEnemy;
        this.coordinatebulletX = coordinateX;
        this.coordinatebulletY = coordinateY;
    }

    public void setCoordinatebulletX(int coordinatebulletX) {
        this.coordinatebulletX = coordinatebulletX;
    }

    public void setCoordinatebulletY(int coordinatebulletY) {
        this.coordinatebulletY = coordinatebulletY;
    }

    public int getCoordinateX() {
        return coordinatebulletX;
    }

    public int getCoordinateY() {
        return coordinatebulletY;
    }
    //установка направления выстрела
    public void setDirection(EnumOfOrientation direction) {
        this.direction = direction;
    }
    //при попадании снаряда, происходит его удаление из списка отрисовываемых снарядов.
    public void  destroyOfBullet(){
        this.isAlive = false;
        Game.listOfBullets.remove(this);
    }
    //проверка попадания по подконтрольному танку, вражеских снарядов.
    //если есть попадание, то увеличивается счетчик смертей и уничтожается танк.
    public boolean checkOfHitMe(){
        if (((Math.abs(coordinatebulletX-Game.tank0.getCoordinateX()))<=1)&&((Math.abs(coordinatebulletY-Game.tank0.getCoordinateY()))<=1)&&(bulletOfEnemy)){
            Game.tank0.TankDestroyed();
            destroyOfBullet();
            Game.deaths++;
            System.out.println("Попадание");
            return true;
        }else {
            return false;
        }
    }
    //проверка попадания по вражеским танкам.
    //если есть попадание, то уничтожается вражеский танк и увеличивается счетчик фрагов.
    public void checkOfHitEnemyes(){
        for (Tank tank:Game.listOfTanks){
            if (((Math.abs(coordinatebulletX-tank.getCoordinateX()))<=1)&&((Math.abs(coordinatebulletY-tank.getCoordinateY()))<=1)&&(!bulletOfEnemy)){
                tank.TankDestroyed();
                destroyOfBullet();
                Game.frags++;
                System.out.println("Попадание");
                isAlive = false;
            }
        }

    }

    /*
    отрисовка движения снарядов и уничтожение их после вылета за пределы поля.
     */
    @Override
    public void run() {

        if (direction.equals(EnumOfOrientation.down)) { //движение вниз
            coordinatebulletY=coordinatebulletY+1;

            while (isAlive) {
                try {
                    if (coordinatebulletY >= Game.edgeY){
                        isAlive = false;
                    }
                    Thread.sleep(Game.delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                coordinatebulletY = coordinatebulletY + 1;
                if(checkOfHitMe()){
                    isAlive = false;
                }
                checkOfHitEnemyes();
            }
            //System.out.println("долетел до нижней границы");
            destroyOfBullet();
        }

        if (direction.equals(EnumOfOrientation.up)) { //движение вверх
            coordinatebulletY=coordinatebulletY-1;
            while (isAlive) {
                try {
                    if (coordinatebulletY <=0){
                        isAlive = false;
                    }
                    Thread.sleep(Game.delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                coordinatebulletY = coordinatebulletY - 1;
                if(checkOfHitMe()){
                    isAlive = false;
                }
                checkOfHitEnemyes();
            }
            //System.out.println("долетел до верхней границы");
            destroyOfBullet();
        }

        if (direction.equals(EnumOfOrientation.left)) { //движение влево
            coordinatebulletX=coordinatebulletX-1;
            while (isAlive) {
                try {
                    if (coordinatebulletX <= 0){
                        isAlive = false;
                    }
                    Thread.sleep(Game.delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                coordinatebulletX = coordinatebulletX - 1;
                if(checkOfHitMe()){
                    isAlive = false;
                }
                checkOfHitEnemyes();
            }
            //System.out.println("долетел до левой границы");
            destroyOfBullet();
        }
        if (direction.equals(EnumOfOrientation.right)) { //движение вправо
            coordinatebulletX=coordinatebulletX+1;
            while (isAlive) {
                try {
                    if (coordinatebulletX >= Game.edgeX){
                        isAlive = false;
                    }
                    Thread.sleep(Game.delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                coordinatebulletX = coordinatebulletX + 1;
                if(checkOfHitMe()){
                    isAlive = false;
                }
                checkOfHitEnemyes();
            }
            //System.out.println("долетел до правой границы");
            destroyOfBullet();
        }
    }
}
