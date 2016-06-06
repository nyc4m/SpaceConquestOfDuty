/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import iut.Game;
import iut.Objet;

/**
 *
 * @author bapt
 */
public class Bouclier extends iut.ObjetTouchable{

    public Bouclier(Game g, int x, int y) {
        super(g, "shield", x, y);
    }

    @Override
    public void effect(Objet o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFriend() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEnnemy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move(long dt) {
        this.moveX(-50);
    }
    
    
}
