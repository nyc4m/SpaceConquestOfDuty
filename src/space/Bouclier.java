/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import iut.Game;
import iut.Objet;
import iut.ObjetTouchable;

/**
 *
 * @author bapt
 */
public class Bouclier extends iut.ObjetTouchable{

    private int delai = 0;
    private double vitesse = -0.5;
    
    public Bouclier(GameInst g, int x, int y) {
        
        super(g, "shield", x, y);
    }

    @Override
    public void effect(Objet o) {
        if(o.isFriend()){
            BonusBouclier b = new BonusBouclier((GameInst)this.game());
            this.game().add(b);
            this.game().remove(this);
        }
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
         this.moveX(vitesse*dt);
    }
    

    
    
    
}
