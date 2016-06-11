/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ennemis;

import iut.Game;

/**
 *
 * @author Florian
 */
public class MeteorWTF extends Meteor{

    public MeteorWTF(Game g, int x, int y, double _dirRad, double _speed) {
        super(g, "meteor1", x, y, _dirRad, _speed);
    }

    @Override
    public void move(long l) {
        if(this.sortie()){
            this.game().remove(this);
        }
        else {
        this.move(-this.speed, this.speed*Math.sin(this.dirRad));
        this.dirRad += 0.08;
        }
    }

    @Override
    public String toString() {
        return "M-WTF";
    }
    
    
}
