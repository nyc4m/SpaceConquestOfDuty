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
import java.util.ArrayList;
import space.GameInst;

/**
 *
 * @author Baptiste, Amaury, Florian
 */
public class Vague {

    private ArrayList element = new ArrayList();

    public Vague(GameInst g, int _level) {
        Meteor1 m1 = new Meteor1(g, g.getWidth() - 50, g.getHeight() / 3, 0, -2);
        Meteor m2 = new Meteor2(g, g.getWidth() - 50, g.getHeight() / 2, 0, -2);
        Meteor m3 = new Meteor3(g, g.getWidth() - 50, g.getHeight() / 2, 0, -2);
        BadVaisseau bv1 = new BVaisseau1(g, g.getX() + 900, g.getY()+500);
        BadVaisseau bv2 = new BVaisseau1(g, g.getX() + 900, g.getY()+200);
        Bouclier b = new Bouclier(g,g.getX()+900,g.getY()+100);
        Vie v = new Vie(g,g.getX()+900,g.getY()+600);
        

        switch (_level) {
            case 1:
                g.add(m1);
                g.add(bv1);
                this.element.add(m1);
                this.element.add(bv1);
                break;
            case 2:
                g.add(m1);
                g.add(m2);
                g.add(bv1);
                g.add(b);
                g.add(v);
                this.element.add(m1);
                this.element.add(m2);
                this.element.add(bv1);
                this.element.add(b);
                this.element.add(v);
                break;
            case 3:
                g.add(m1);
                g.add(m2);
                g.add(m3);
                g.add(bv1);
                g.add(bv2);
                break;
            case 4:
                System.out.println("Victoire");
        }
    }

    public ArrayList getElement() {
        return element;
    }

}
