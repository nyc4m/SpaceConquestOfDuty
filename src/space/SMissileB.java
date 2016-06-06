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
 * @author Florian
 */
public class SMissileB extends Tir{
    
    public SMissileB(Game g, int x, int y) {
        super(g,"SMissileB", x, y);
    }
    
    @Override
    public void move(long l) {
        this.move(30, 30);
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
