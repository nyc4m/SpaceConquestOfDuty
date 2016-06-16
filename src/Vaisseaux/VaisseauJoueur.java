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
public class VaisseauJoueur extends VaisseauControle {

    public VaisseauJoueur(Game g, int x, int y) {
        super(g, "vaisseau", x, y);
        this.jeu = (GameInst) g;
    }

    @Override
    public String toString() {
        return "VJ";
    }

    public void collisionBonus(Objet o) {
        switch (o.toString()) {
            case "V":
                try {
                    this.ajouterVie();
                    this.jeu.getAth().majHUD();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                break;
            case "Mi":
                try {
                    this.ajouterMissile();
                    this.jeu.getAth().majHUD();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }

            case "B" : this.ajouterBouclier();
            break;
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
    public void effect(Objet o) {
        if(o.isFriend()){
            this.collision(o);
        }
    }

    public void ajouterBouclier() {
        VaisseauProtege v = new VaisseauProtege(this.game(), this.getLeft(), this.getBottom() - 87);
        this.game().add(v);
        this.game().addKeyListener((KeyListener) v);
        this.game().remove(this);
        this.game().removeKeyListener((KeyListener) this);
    }
}
