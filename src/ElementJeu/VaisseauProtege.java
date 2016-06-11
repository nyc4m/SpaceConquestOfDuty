/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementJeu;

import iut.Game;
import iut.Objet;

/**
 *
 * @author bapt
 */
public class VaisseauProtege extends Vaisseau{
    
    public VaisseauProtege(Game g, int x, int y) {
        super(g, "vaisseau_shield", x, y);
    }
    

    @Override
    public void effect(Objet o) {
        if(o.isEnnemy()){
            //GameInst game = (GameInst)this.game();
            VaisseauJoueur v = new VaisseauJoueur(this.game(), this.getLeft(), this.getBottom()-87);
            
            this.game().remove(this);
            this.game().removeKeyListener(this);
            
            this.game().add(v);
            this.game().addKeyListener(v);
            this.game().add(v);
        }
    }

    @Override
    public String toString() {
        return "VP";
    }
    
    
}
