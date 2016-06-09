/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementJeu;

import iut.Game;
import iut.Objet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author bapt
 */
public class VaisseauProtege extends VaisseauJoueur implements KeyListener{
    
    public VaisseauProtege(Game g, String sprite, int x, int y) {
        super(g, sprite, x, y);
    }
    

    @Override
    public void effect(Objet o) {
        if(o.isEnnemy()){
            //GameInst game = (GameInst)this.game();
            VaisseauJoueur v = new VaisseauJoueur(this.game(), "vaisseau", this.getLeft(), this.getBottom()-87);
            
            this.game().remove(this);
            this.game().removeKeyListener(this);
            
            this.game().add(v);
            this.game().addKeyListener(v);
            this.game().add(v);
        }
    }
    

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "VaisseauProtege";
    }
    
    
    
}