/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ennemis;

import TirVaisseau.badLaser;
import iut.Game;
import iut.Objet;

/**
 *
 * @author Florian
 */
public class BVaisseau1 extends BadVaisseau{

    public BVaisseau1(Game g, int x, int y) {
        super(g, "bV1", x, y);
    }

    @Override
    public void effect(Objet objet) {
        int a = this.alea(0, 180);
        int b = this.alea(0, 60);
        if(a==b){
            badLaser bl = new badLaser(this.game(), this.getMiddleX()-80, this.getMiddleY());
            this.game().add(bl);
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
        
    }

    @Override
    public String toString() {
        return "BV1";
    }
    
    
}
