/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementJeu;

import TirVaisseau.TLaser;
import TirVaisseau.TMissile;
import iut.Game;
import iut.Objet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Florian
 */
public class VaisseauJoueur extends iut.ObjetTouchable implements KeyListener {

    private int vie;
    private int missiles;
    private double Vx;
    private double Vy;

    public VaisseauJoueur(Game g, String sprite, int x, int y) {
        super(g, sprite, x, y);
        this.missiles = 3;
        this.vie = 3;
    }

    @Override
    public void effect(Objet o) {
        if (o.isFriend()) {
            this.collisionBonus(o);
        } else if(o.isEnnemy()){
            System.out.println("Ship damaged BIATCH !!");
            this.game().remove(this);
            Explo e = new Explo(this.game(), this.getMiddleX()-85, this.getMiddleY()-85);
            this.game().add(e);
        }
    }

    public void collisionBonus(Objet o) {
        switch (o.toString()) {
            case "B":
                this.ajouterBouclier();
                break;
            case "M":
                try {
                    this.ajouterMissile();
                    System.out.println("[INFO]Missile added");
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                break;
        }
    }

    public void ajouterBouclier() {
        this.game().remove(this);
        this.game().removeKeyListener(this);
        VaisseauProtege v = new VaisseauProtege(this.game(), "vaisseau_shield", this.getLeft(), this.getBottom() - 87);
        this.game().add(v);
        this.game().addKeyListener(v);
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
    public void move(long l) {//méthode appelée en permanence (utiliser moveX et moveY
        this.move(Vx, Vy);
        this.Vy = this.Vy/1.2;
    }

    /*public void setennemy();*/
    @Override
    public void keyTyped(KeyEvent e) {
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
        if (kC == down && this.getBottom() < this.game().height()-87) {
            this.Vy = 20;
        }

        //gestion du tir
        if (kC == space) {
            TLaser t = new TLaser(this.game(), this.getMiddleX() + 50, this.getMiddleY());
            this.game().add(t);
        }
        if (kC == m) {
            try{
            this.tirerMissile();
            }catch(Exception err){
                System.err.println(err.getMessage());
            }
        }
    }

    public void tirerMissile() throws Exception{
        if (!this.aucunMissile()) {
            TMissile tM = new TMissile(this.game(), this.getMiddleX() + 50, this.getMiddleY());
            this.game().add(tM);
            this.missiles--;
        }else{
            throw new Exception("Vous n'avez plus de missiles");
        }
    }

    public void ajouterMissile() throws Exception {
        if (this.tropDeMissile()) {
            throw new Exception("Trop de missiles");
        } else {
            this.missiles++;
            System.out.println("missiles = " + missiles);
        }
    }

    public boolean aucunMissile() {
        return this.missiles <= 0;
    }
    
    public boolean tropDeMissile(){
        return this.missiles>=3;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public String toString() {
        return "VaisseauJoueur";
    }
}
