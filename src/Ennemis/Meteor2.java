/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ennemis;

import iut.Game;
import iut.Objet;

/**
 *
 * @author Florian
 */
public class Meteor2 extends Meteor{
    int dirX;
    int dirY;

    public Meteor2(Game g, int x, int y, int _dirX, int _dirY) {
        super(g, "meteor2", x, y);
        this.dirX = _dirX;
        this.dirY = _dirY;
    }

    @Override
    public void effect(Objet o) {
        if(this.collision(o)){
            if (o.toString()=="T"){
                System.out.println("scinder m2");
                Meteor1 m1 = new Meteor1(this.game(), this.getMiddleX()-60,this.getMiddleY()-68,-10,-10);
                Meteor1 m2 = new Meteor1(this.game(), this.getMiddleX()-60,this.getMiddleY()-68,-10,10);
                this.game().add(m1);
                this.game().add(m2);
            }
        }
    }

    @Override
    public boolean isFriend() {
        return false;
    }

    @Override
    public boolean isEnnemy() {
        return true;
    }

    @Override
    public void move(long l) {
        this.move(this.dirX,this.dirY);
    }

    @Override
    public String toString() {
        return "M2"; 
    }
    
    
}
