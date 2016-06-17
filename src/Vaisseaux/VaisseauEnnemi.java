/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vaisseaux;

import iut.Game;
import iut.Objet;

/**
 *
 * @author Baptiste
 */
public class VaisseauEnnemi extends Vaisseau {

    public VaisseauEnnemi(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    @Override
    public void effect(Objet o) {
        switch (o.toString()) {
            case "T":
                this.game().remove(this);
                break;
                }
        }

    @Override
    public boolean isFriend() {
        return false;
    }

    @Override
    public boolean isEnnemy() {
        return true;
    }

}
