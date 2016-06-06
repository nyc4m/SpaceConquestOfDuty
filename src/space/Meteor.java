/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import iut.Game;

/**
 *
 * @author Florian
 */
public abstract class Meteor extends iut.ObjetTouchable{
    public Meteor(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
    }
}

    