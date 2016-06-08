/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementJeu;

import iut.Game;
import iut.Objet;

/**
 *
 * @author Florian
 */
public class Explo extends iut.Objet{

    public Explo(Game g, double _x, double _y) {
        super(g, "big_exp", _x, _y);
    }

    @Override
    public boolean collision(Objet objet) {
        return false;
    }

    @Override
    public void effect(Objet objet) {
    }

    @Override
    public boolean isFriend() {
        return true;
    }

    @Override
    public boolean isEnnemy() {
        return true;
    }

    @Override
    public void move(long l) {
    }
    
}
