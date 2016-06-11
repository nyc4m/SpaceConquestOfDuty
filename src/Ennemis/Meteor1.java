/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ennemis;

import iut.Game;

/**
 *
 * @author Florian
 */
public class Meteor1 extends Meteor{

    public Meteor1(Game g, int x, int y, double _dirRad, double _speed) {
        super(g, "meteor1", x, y, _dirRad, _speed);
    }

    @Override
    public String toString() {
        return "M1"; 
    }
}
