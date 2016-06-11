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
public class MeteorWTF extends Meteor{

    private double dirX;
    private double dirY;
    private double dirRad;

    public MeteorWTF(Game g, double dirRad, int x, int y) {
        super(g, "meteor1", x, y);
        this.dirRad = dirRad;
        this.dirX = -5;
        this.dirY = Math.sin(this.dirRad);
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
        this.dirY = 20*Math.sin(this.dirRad);
        this.dirRad += 0.08;
    }
    
}
