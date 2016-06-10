/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import iut.Game;
import iut.Objet;

/**
 *
 * @author bapt
 */
public class Icone extends iut.Objet{

    public Icone(Game g, String nom, double _x, double _y) {
        super(g, nom, _x, _y);
    }

    @Override
    public boolean collision(Objet o) {
        return false;
    }

    @Override
    public void effect(Objet o) {
        System.out.println("[INFO] Colision avec Icone");}

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
        }
    
}
