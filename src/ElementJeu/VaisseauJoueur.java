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
 * @author Florian
 */
public class VaisseauJoueur extends Vaisseau {

    public VaisseauJoueur(Game g, int x, int y) {
        super(g, "vaisseau", x, y);
        this.missiles = 3;
        this.vie = 3;
    }

    @Override
    public void effect(Objet o) {
        if (o.isFriend()) {
            this.collisionBonus(o);
        } else if(o.isEnnemy()){
            if(this.vie>0){
                this.game().remove(o);
                this.vie-=1;
                System.out.println("T as perdu une vie mauvais !");
            }
            else{
            System.out.println("Ship damaged BIATCH !!");
            this.game().remove(this);
            Explo e = new Explo(this.game(), this.getMiddleX()-85, this.getMiddleY()-85);
            this.game().add(e);
            }
        }
    }
    
    @Override
    public String toString() {
        return "VJ";
    }
}
