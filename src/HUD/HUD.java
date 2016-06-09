/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HUD;

import iut.Game;
import iut.Objet;
import java.awt.Image;

/**
 *
 * @author Baptiste
 */
public class HUD extends iut.Objet{

    public HUD(Game g, String nom, double _x, double _y) {
        super(g, nom, _x, _y);
    }

    @Override
    public boolean collision(Objet objet) {
        return false;
    }

    @Override
    public void effect(Objet objet) {
        System.out.println("[INFO] Touched by something but you don't care since it's a fucking HUD");
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
        
    }

    
}
