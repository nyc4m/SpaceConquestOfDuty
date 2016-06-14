/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vaisseaux;

import iut.Game;

/**
 *
 * @author Florian
 */
public class VaisseauJoueur extends Vaisseau {

    public VaisseauJoueur(Game g, int x, int y) {
        super(g, "vaisseau", x, y);
        this.missiles = super.missiles;
        this.vie = super.vie;
    }
    
    @Override
    public String toString() {
        return "VJ";
    }
}
