/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TirVaisseau;

import iut.Game;
import iut.Objet;

/**
 *
 * @author Florian
 */
public class badLaser extends Tir{
    
    public badLaser(Game g, int x, int y) {
        super(g, "badlaser", x, y);
    }

    @Override
    public String toString() {
        return "BadL";
    }

    @Override
    public void move(long l) {
        this.move(-7,0);
    }

    @Override
    public boolean isEnnemy() {
        return true;
    }

    @Override
    public boolean isFriend() {
        return false;
    }

    @Override
    public void effect(Objet objet) {
        if(objet.isFriend()){
            this.game().remove(this);
        }
    }
}
