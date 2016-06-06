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
public class BonusBouclier extends iut.ObjetTouchable{

    
    public BonusBouclier(GameInst game) {
        super(game, "vaisseau_shield", game.getPosXvaisseau(), game.getPosYvaisseau());
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
    
    
}
