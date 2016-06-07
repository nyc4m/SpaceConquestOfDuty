/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ennemis;

import iut.Game;
import space.ElementTouchable;

/**
 *
 * @author Florian
 */
public abstract class Meteor extends ElementTouchable{
    public Meteor(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
    }
}

    