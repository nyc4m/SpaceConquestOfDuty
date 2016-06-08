/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementJeu;

import iut.Game;
import iut.Objet;

/**
 *
 * @author bapt
 */
public class Bonus extends iut.ObjetTouchable {

    private double vitesse = -0.2;

    public Bonus(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    @Override
    public void effect(Objet o) {
        if (o.isFriend()) {
            switch (o.toString()) {
                case "B":
                    System.out.println("Collision avec bouclier");
                    break;
                case "M":
                    System.out.println("Collision avec Missile");
                    break;
                case "L":
                    System.out.println("Collission avec un laser");
                    break;
                default:
                    this.game().remove(this);
                    break;
            }
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
    public void move(long dt) {
        this.moveX(vitesse * dt);
    }

    public double getVitesse() {
        return vitesse;
    }

}
