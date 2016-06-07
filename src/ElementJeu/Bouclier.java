/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementJeu;

import iut.Objet;
import space.GameInst;
import space.VaisseauProtege;

/**
 *
 * @author bapt
 */
public class Bouclier extends Bonus {
    
    public Bouclier(GameInst g, int x, int y) {

        super(g, "shield", x, y);
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
        this.moveX(this.getVitesse() * dt);
    }

    @Override
    public String toString() {
        return "B";
    }

}
