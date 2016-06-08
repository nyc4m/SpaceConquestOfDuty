/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TirVaisseau;

import iut.Game;
import iut.Objet;

/**
 *
 * @author Florian
 */
public class SMissileH extends SMissile{
    
    public SMissileH(Game g, int x, int y) {
        super(g,"SMissileH", x, y);
    }

    @Override
    public void move(long l) {
        this.move(30, -30);
    }

    
    
    
}
