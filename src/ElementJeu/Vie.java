/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementJeu;

import iut.Game;

/**
 *
 * @author Baptiste
 */
public class Vie extends Bonus{
    
    public Vie(Game g, int x, int y) {
        super(g, "vie", x, y);
    }
    
    public String toString(){
        return "V";
    }
    
}
