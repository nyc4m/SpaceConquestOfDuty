/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementJeu;

import Ennemis.*;
import iut.Game;
import iut.Objet;

/**
 *
 * @author Florian
 */
public class Vague {

    private final int level;
    private Game g;

    public Vague(Game g, int _level) {
        this.level = _level;
        
    }
    


    public void init(Game g2) {
        switch (this.level) {
            case 1:
                g2.add((Objet) this.makeEnemy("M1", g2.getWidth(), g2.getHeight()));
               
                break;
            case 2:
               g2.add((Objet) this.makeEnemy("M1", g2.getWidth(), g2.getHeight()));
               g2.add((Objet) this.makeEnemy("M2", g2.getWidth(), g2.getHeight()));
                break;
            case 3:
                g2.add((Objet) this.makeEnemy("M1", g2.getWidth(), g2.getHeight()));
                g2.add((Objet) this.makeEnemy("M2", g2.getWidth(), g2.getHeight()));
                g2.add((Objet) this.makeEnemy("M3", g2.getWidth(), g2.getHeight()));
        }
    }

    public Objet makeEnemy(String type, int x, int y) {
        Objet a = null;
        switch (type) {
            case "M1":
                Meteor1 m1 = new Meteor1(this.g, x, y, Math.PI, 5);
                a = m1;
                break;
            case "M2":
                Meteor2 m2 = new Meteor2(this.g, x, y, Math.PI, 3);
                a = m2;
                break;
            case "M3":
                Meteor3 m3 = new Meteor3(this.g, x, y, Math.PI, 2);
                a = m3;
                break;
            case "BV1":
                BVaisseau1 bv1 = new BVaisseau1(this.g, x, y);
                a = bv1;
                break;
        }
        return a;
    }

    
  
    
}

