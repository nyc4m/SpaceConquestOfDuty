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
public abstract class Meteor extends iut.ObjetTouchable{
    protected double dirRad;
    protected double speed;
    
    public Meteor(Game g, String nom, int x, int y, double _dirRad, double _speed) {
        super(g, nom, x, y);
        this.dirRad = _dirRad;
        this.speed = _speed;
    }
    
    @Override
    public void move(long l) {
        this.move(this.speed*Math.cos(dirRad), this.speed*Math.sin(dirRad));
    }
    
    @Override
    public void effect(Objet objet) {
    }

    @Override
    public boolean isFriend() {return false;}

    @Override
    public boolean isEnnemy() {return true;} 
}

    