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
 * @author bapt
 */
public class SMissile extends Tir{
    
    public SMissile(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
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
