/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementJeu;

import Ennemis.*;
import IHM.GagneF;
import iut.Game;
import iut.Objet;
import space.GameInst;

/**
 *
 * @author Florian
 */
public class Vague {

    private  int level;


    public Vague(int _level) {
        this.level = _level;

    }
/**
 * Méthode qui initialise et qui palce les objets en fonction du niveau
 * @param g L'instance du jeux
 */
    public void init(Game g) {
        Meteor1 m1 = new Meteor1(g, g.getWidth() - 50, g.getHeight() / 3, -6, 0);
        Meteor m2 = new Meteor2(g, g.getWidth() - 50, g.getHeight() / 2, -5,0);
        Meteor m3 = new Meteor3(g, g.getWidth() - 50, g.getHeight() / 2, -3, 0);
        BadVaisseau bv1 = new BVaisseau1(g, g.getX()+900,g.getY());
        
       
        switch (this.level) {
            case 1:
                g.add(m1);
                g.add(bv1);
                break;
            case 2:
                g.add(m1);
                g.add(m2);
                g.add(bv1);
                break;
            case 3:
                g.add(m1);
                g.add(m2);
                g.add(m3);
                g.add(bv1);
                break;
            case 4:
               System.out.println("Victoire");
        }
    }
    /**
     * Augmente le niveau
     */
    public void levelUp(){
        
        this.level +=1;
    }
}

