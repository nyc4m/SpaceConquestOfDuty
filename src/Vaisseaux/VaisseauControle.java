/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vaisseaux;

import TirVaisseau.TLaser;
import TirVaisseau.TMissile;
import iut.Game;
import iut.Objet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import space.GameInst;

/**
 *
 * @author Baptiste
 */
public abstract class VaisseauControle extends Vaisseau implements KeyListener{
    
    protected int missiles = 3;
    protected GameInst jeu;
    
    public VaisseauControle(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
        this.jeu = (GameInst) g;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        //gestion des déplacements
        int kC = e.getKeyCode();
        int up, down, space, m;

        up = 38;
        down = 40;
        space = 32;
        m = 77;
        //deplacement de base haut/bas
        if (kC == up && this.getTop() > 87) {
            this.Vy = -20;
        }
        if (kC == down && this.getBottom() < this.game().height() - 87) {
            this.Vy = 20;
        }

        //gestion du tir
        if (kC == space) {
            TLaser t = new TLaser(this.game(), this.getMiddleX() + 50, this.getMiddleY());
            this.game().add(t);
        }
        if (kC == m) {
            try {
                this.tirerMissile();
            } catch (Exception err) {
                System.err.println(err.getMessage());
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        int kC = e.getKeyCode();
        int up, down, left, right, space, m;

        up = 38;
        down = 40;
        left = 37;
        right = 39;
        space = 32;
        m = 77;

        if (kC == up || kC == down) {
            this.Vy = 0;
        }
    }
    
        public void tirerMissile() throws Exception {
        if (!this.aucunMissile()) {
            TMissile tM = new TMissile(this.game(), this.getMiddleX() + 50, this.getMiddleY());
            this.game().add(tM);
            this.missiles--;
            System.out.println("[INFO] Missile tiré, missiles = " + missiles);
            this.jeu.getAth().majHUD();
        } else {
            throw new Exception("Vous n'avez plus de missiles");
        }
    }

    public boolean tropDeVie() {
        return this.vie >= 3;
    }

    public void ajouterVie() throws Exception {
        if (tropDeVie()) {
            throw new Exception("Trop de vie");
        } else {
            this.vie++;
            System.out.println("Vie ajoutée, vie = " + vie);
            this.jeu.getAth().majHUD();
        }

    }


    public void ajouterMissile() throws Exception {
        if (this.tropDeMissile()) {
            throw new Exception("Trop de missiles");
        } else {
            this.missiles++;
            System.out.println("[INFO] Missile ajouté, missiles = " + missiles);
        }
    }

    public boolean aucunMissile() {
        return this.missiles <= 0;
    }

    public boolean tropDeMissile() {
        return this.missiles >= 3;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void effect(Objet o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public abstract void collisionBonus(Objet o);

    @Override
    public boolean isFriend() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEnnemy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
