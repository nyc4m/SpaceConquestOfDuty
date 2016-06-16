/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vaisseaux;

import iut.Game;
import iut.Objet;
import java.awt.event.KeyListener;
import space.GameInst;

/**
 *
 * @author Florian
 */
public class VaisseauJoueur extends Vaisseau{

    public VaisseauJoueur(Game g, int x, int y) {
        super(g, "vaisseau", x, y);
        this.jeu = (GameInst)g;
    }
    
    @Override
    public String toString() {
        return "VJ";
    }

    @Override
    public void collisionBonus(Objet o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void effect(Objet o) {
        switch(o.toString()){
            case "B" : this.ajouterBouclier();
        }
    }
    
    public void ajouterBouclier() {
        VaisseauProtege v = new VaisseauProtege(this.game(), this.getLeft(), this.getBottom() - 87);
        this.game().add(v);
        this.game().addKeyListener(v);
        this.game().remove(this);
        this.game().removeKeyListener(this);
    }
}
