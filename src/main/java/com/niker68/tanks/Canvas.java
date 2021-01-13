package com.niker68.tanks;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

class Canvas extends JComponent {

    /*Метод, перерисовывающий элемент внутри окна
     *при обновлении*/

    private Graphics2D g2d;
    public void paintTank(Graphics2D g2d, Tank tank){
        g2d.fillRect(tank.getCoordinateX()*Game.mashtab-15+Game.smeshenie,tank.getCoordinateY()*Game.mashtab-15+Game.smeshenie,30,30);
        if (tank.getOrientation().equals(EnumOfOrientation.up)){
          g2d.fillRect((tank.getCoordinateX()+1)*Game.mashtab-15+Game.smeshenie,(tank.getCoordinateY()-1)*Game.mashtab-15+Game.smeshenie,10,10);
        }
        if (tank.getOrientation().equals(EnumOfOrientation.down)){
            g2d.fillRect((tank.getCoordinateX()+1)*Game.mashtab-15+Game.smeshenie,(tank.getCoordinateY()+3)*Game.mashtab-15+Game.smeshenie,10,10);
        }
        if (tank.getOrientation().equals(EnumOfOrientation.left)){
            g2d.fillRect((tank.getCoordinateX()-1)*Game.mashtab-15+Game.smeshenie,(tank.getCoordinateY()+1)*Game.mashtab-15+Game.smeshenie,10,10);
        }
        if (tank.getOrientation().equals(EnumOfOrientation.right)){
            g2d.fillRect((tank.getCoordinateX()+3)*Game.mashtab-15+Game.smeshenie,(tank.getCoordinateY()+1)*Game.mashtab-15+Game.smeshenie,10,10);
        }
    }
    public void paintBullet(Graphics2D g2d,Bullet bullet){
        g2d.fillOval(bullet.getCoordinateX()*Game.mashtab-3+Game.smeshenie, bullet.getCoordinateY()*Game.mashtab-3+Game.smeshenie, 6, 6);
    }
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g2d=(Graphics2D)g;
        g2d.drawString(("Deaths: "+Integer.toString(Game.deaths)),10,10);
        g2d.drawString(("Frags: "+Integer.toString(Game.frags)),100,10);
        //g2d.fillOval(Game.tank0.bullet.getCoordinateX()*Game.mashtab-3+Game.smeshenie, Game.tank0.bullet.getCoordinateY()*Game.mashtab-3+Game.smeshenie, 6, 6); //отрисовка снаряда танка1

        g2d.setColor(Color.green);
        //g2d.fillRect(Game.tank0.getCoordinateX()*Game.mashtab-15+Game.smeshenie,Game.tank0.getCoordinateY()*Game.mashtab-15+Game.smeshenie,30,30); //отрисовка танка1
        for (Tank tank : Game.listOfTanks) {
            paintTank(g2d, tank);
        }
        g2d.setColor(Color.BLACK);
        paintTank(g2d,Game.tank0);
        g2d.setColor(Color.blue);
        Iterator<Bullet> bulletsIterator = Game.listOfBullets.iterator();//создаем итератор
        while(bulletsIterator.hasNext()) {//до тех пор, пока в списке есть элементы

            Bullet nextBullet = bulletsIterator.next();//получаем следующий элемент
            if (!nextBullet.isAlive) {
                bulletsIterator.remove();//удаляем кота с нужным именем
            } else {
            paintBullet(g2d, nextBullet);}
        }

        g2d.setColor(Color.black);
        /*g2d.drawLine(0,10,300,10);
        g2d.drawLine(0,20,300,20);
        g2d.drawLine(0,30,300,30);
        g2d.drawLine(0,40,300,40);
        g2d.drawLine(0,50,300,50);
        g2d.drawLine(0,60,300,60);
        g2d.drawLine(0,70,300,70);
        g2d.drawLine(0,80,300,80);
        g2d.drawLine(0,90,300,90);
        g2d.drawLine(0,100,300,100);
        g2d.drawLine(10,0,10,300);
        g2d.drawLine(20,0,20,300);
        g2d.drawLine(30,0,30,300);
        g2d.drawLine(40,0,40,300);
        g2d.drawLine(50,0,50,300);
        g2d.drawLine(60,0,60,300);
        g2d.drawLine(70,0,70,300);
        g2d.drawLine(80,0,80,300);
        g2d.drawLine(90,0,90,300);
        g2d.drawLine(100,0,100,300);*/


        /* 	Вызывает обновление себя после завершения рисования	*/
        super.repaint();
    }
}
