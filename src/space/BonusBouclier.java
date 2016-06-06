/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import iut.Game;
import iut.Objet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author bapt
 */
public class BonusBouclier extends iut.ObjetTouchable{

    
    public BonusBouclier(GameInst game) {
        super(game, "vaisseau_shield", game.getVaisseau().getMiddleX(), game.getVaisseau().getMiddleY());
    }

    @Override
    public void effect(Objet o) {
        
    }

    @Override
    public boolean isFriend() {
        return true;
    }

    @Override
    public boolean isEnnemy() {
        return false;
    }

    @Override
    public void move(long dt) {
        
    }
    
    public void moveX(double dx) {
        super.moveX(dx); //To change body of generated methods, choose Tools | Templates.
    }

    public void moveY(double dy){
        super.moveY(dy);
    }
    
    
}
