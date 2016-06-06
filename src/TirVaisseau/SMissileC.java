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
public class SMissileC extends Tir{
    
    public SMissileC(Game g, int x, int y) {
        super(g, "SMissileC", x, y);
    }
    
    @Override
    public void move(long l) {
        this.move(30, 0);
    }
    
    @Override
    public void effect(Objet objet) {
        if(this.collision(objet)){
            if(objet.isEnnemy()){
                this.game().remove(objet);
                this.game().remove(this);
            }
        }
    }
}
