/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TirVaisseau;

import iut.Game;

/**
 *
 * @author Florian
 */
public class SMissileC extends SMissile{
    
    public SMissileC(Game g, int x, int y) {
        super(g, "SMissileC", x, y);
    }
    
    @Override
    public void move(long l) {
        this.move(30, 0);
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
