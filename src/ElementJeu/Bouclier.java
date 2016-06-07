/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementJeu;

import iut.Objet;
import space.GameInst;
import space.VaisseauProtege;

/**
 *
 * @author bapt
 */
public class Bouclier extends iut.ObjetTouchable{

    private final int delai = 0;
    private final double vitesse = -0.5;
    
    public Bouclier(GameInst g, int x, int y) {
        
        super(g, "shield", x, y);
    }

    @Override
    public void effect(Objet o) {
        if(o.isFriend()){
            this.ajouterBouclier();
        }
    }
    
    public void ajouterBouclier(){
        GameInst game = (GameInst)this.game();
            game.remove(game.getVaisseau());
            VaisseauProtege v = new VaisseauProtege(game, "vaisseau_shield", game.getVaisseau().getLeft(), game.getVaisseau().getBottom()-87);
            game.remove(this);
            game.remove(game.getVaisseau());
            game.setVaisseau(v); 
            game.add(v);
            game.addKeyListener(v);
    }

    @Override
    public boolean isFriend() {
        return true;
    }

    @Override
    public boolean isEnnemy() {
        return false;
    }
    

    @Override
    public void move(long dt) {
         this.moveX(vitesse*dt);
    }
    
    @Override
    public String toString() {
        return "B"; 
    }
    
}
