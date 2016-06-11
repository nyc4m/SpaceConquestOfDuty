/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementJeu;

import iut.Game;

/**
 *
 * @author Florian
 */
public class VaisseauJoueur extends Vaisseau {

    public VaisseauJoueur(Game g, int x, int y) {
        super(g, "vaisseau", x, y);
        this.missiles = 3;
        this.vie = 3;
    }
    
    @Override
    public String toString() {
        return "VJ";
    }
}
