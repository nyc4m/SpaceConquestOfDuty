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
public class Bouclier extends Bonus{

    
    public Bouclier(Game g, int x, int y) {
        
        super(g, "shield", x, y);
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
    
    
}
