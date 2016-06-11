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
public class BVaisseau2 extends BadVaisseau{

    public BVaisseau2(Game g, String nom, int x, int y) {
        super(g, "BV2", x, y);
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
        
    }

   
}
