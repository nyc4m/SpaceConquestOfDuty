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
import space.GameInst;

/**
 *
 * @author Florian
 */
public abstract class Vaisseau extends iut.ObjetTouchable{

    protected int vie;
    protected double Vx;
    protected double Vy;
    protected GameInst jeu;

    public Vaisseau(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
        this.vie = 3;
    }

    @Override
    public abstract void effect(Objet o);

    public abstract void collisionBonus(Objet o);

    

    public abstract boolean isFriend();


    public abstract boolean isEnnemy();

    public void move(long l) {
        this.move(Vx, Vy);
    }
    
    

}
