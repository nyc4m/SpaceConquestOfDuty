/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import iut.Game;
import iut.Objet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Florian
 */
public class VaisseauJoueur extends iut.ObjetTouchable implements KeyListener {

    private boolean ennemy = true;
    private BonusBouclier bouclier = null;

    public VaisseauJoueur(Game g) {
        super(g, "vaisseau", 30, g.getHeight() / 2 - 50);
    }

    public void effect(Objet o) {
        if (o.isFriend()) {
            System.out.println("Bonus");
            this.bouclier = new BonusBouclier((GameInst) this.game());
            this.game().add(this.bouclier);

        } else if (this.bouclier != null) {
            this.game().remove(this.bouclier);
            this.bouclier = null;
        } else {
            System.out.println("Ship damaged BIATCH !!");
        }
    }

    /**
     * Ajoute un bouclier au vaiseau
     */
    public void ajouterBouclier() {
    }

    @Override
    public boolean isFriend() {
        return true;
    }

    @Override
    public boolean isEnnemy() {
        return ennemy;
    }

    @Override
    public void move(long l) {//méthode appelée en permanence (utiliser moveX et moveY

    }

    /*public void setennemy();*/
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int kC = e.getKeyCode();
        int up, down, left, right;
        up = 38;
        down = 40;
        left = 37;
        right = 39;
        //deplacement de base haut/bas
        if (kC == up) {
            this.moveY(-15);
            if (this.bouclier != null) {
                this.bouclier.moveY(-15);
            }
        }

        if (kC == down) {
            this.moveY(15);
            if (bouclier != null) {
                this.bouclier.moveY(15);
            }
        }

        this.game().repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    /*public object testCollision(){
        
    }*/
}
