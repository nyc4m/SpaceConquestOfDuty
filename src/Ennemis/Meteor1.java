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
public class Meteor1 extends Meteor{
    int dirX;
    int dirY;

    public Meteor1(Game g, int x, int y, int _dirX, int _dirY) {
        super(g, "meteor1", x, y);
        this.dirX = _dirX;
        this.dirY = _dirY;
    }

    @Override
    public void effect(Objet objet) {
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
    public int getType() {
        return 1;
    }
    
}
