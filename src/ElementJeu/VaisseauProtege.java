/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementJeu;

import iut.Game;

/**
 *
 * @author bapt
 */
public class VaisseauProtege extends Vaisseau{
    
    public VaisseauProtege(Game g, int x, int y) {
        super(g, "vaisseau_shield", x, y);
    }

    @Override
    public String toString() {
        return "VP";
    }
    
    
}
