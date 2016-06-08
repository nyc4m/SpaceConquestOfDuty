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
public class TLaser extends Tir{
    
    public TLaser(Game g, int x, int y) {
        super(g, "laser", x, y);
    }

    @Override
    public void effect(Objet objet) {
        if(this.collision(objet)){
            if(objet.isEnnemy()){
                this.game().remove(objet);
                this.game().remove(this);
            }
        }
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
}
