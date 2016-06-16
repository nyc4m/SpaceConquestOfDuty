/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vaisseaux;

import ElementJeu.Explo;
import TirVaisseau.TLaser;
import TirVaisseau.TMissile;
import iut.Game;
import iut.Objet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import space.GameInst;

/**
 *
 * @author Florian
 */
public abstract class Vaisseau extends iut.ObjetTouchable implements KeyListener {

    protected int vie;
    protected int missiles;
    protected double Vx;
    protected double Vy;
    protected GameInst jeu;

    public Vaisseau(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
        this.vie = 3;
        this.missiles = 3;
    }

    @Override
    public void effect(Objet o) {
        switch (this.toString()) {
            case "VJ":
                if (o.isFriend()) {
                    this.collisionBonus(o);
                } else if (o.isEnnemy()) {
                    if (this.vie > 0) {
                        this.game().remove(o);
                        this.vie--;
                        System.out.println("vie perdu , vie restante : " + this.vie);
                        this.jeu.getAth().majHUD();
                    } else {
                        System.out.println("Ship destroyed BIATCH !!");
                        this.game().remove(this);
                        Explo e = new Explo(this.game(), this.getMiddleX() - 85, this.getMiddleY() - 85);
                        this.game().add(e);
                        this.jeu.getAth().majHUD();
                    }
                }
                break;
            case "VP":
                if (o.isEnnemy()) {
                    VaisseauJoueur v = new VaisseauJoueur(this.game(), this.getLeft(), this.getBottom() - 87);

                    this.game().remove(this);
                    this.game().removeKeyListener(this);

                    this.game().add(v);
                    this.game().addKeyListener(v);
                    this.game().add(v);
                }
                break;
        }
    }

    public void collisionBonus(Objet o) {
        switch (o.toString()) {
            case "B":
                System.out.println("ajout bouclier");
                this.ajouterBouclier();
                break;
            case "Mi":
                try {
                    this.ajouterMissile();
                    this.jeu.getAth().majHUD();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                break;
            case "V":
                try {
                    this.ajouterVie();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
        }
    }

    public void ajouterBouclier() {
        VaisseauProtege v = new VaisseauProtege(this.game(), this.getLeft(), this.getBottom() - 87);
        this.game().add(v);
        this.game().addKeyListener(v);
        this.game().remove(this);
        this.game().removeKeyListener(this);
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
    public void move(long l) {
        this.move(Vx, Vy);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //gestion des déplacements
        int kC = e.getKeyCode();
        int up, down, left, right, space, m;

        up = 38;
        down = 40;
        left = 37;
        right = 39;
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

    @Override
    public void keyTyped(KeyEvent e) {

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

    public int getVie() {
        return vie;
    }

    public int getMissiles() {
        return missiles;
    }

}
