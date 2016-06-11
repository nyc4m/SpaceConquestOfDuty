package TirVaisseau;


import iut.Game;
import iut.Objet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Florian
 */
public class TMissile extends Tir{
    
    public TMissile(Game g, int x, int y) {
        super(g, "missile", x, y);
    }

    @Override
    public void effect(Objet objet) {
        if(this.collision(objet)){
            if(objet.isEnnemy()){
                SMissileH smh = new SMissileH(this.game(), this.getMiddleX(), this.getMiddleY());
                SMissileB smb = new SMissileB(this.game(), this.getMiddleX(), this.getMiddleY());
                SMissileC smc = new SMissileC(this.game(), this.getMiddleX(), this.getMiddleY());
                this.game().add(smh);
                this.game().add(smb);
                this.game().add(smc);
        
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
    
    
}
