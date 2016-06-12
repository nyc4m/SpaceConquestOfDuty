/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import ATH.ATH;
import ATH.Icone;
import ATH.IconeMissile;
import ATH.IconeVie;
import ElementJeu.VaisseauJoueur;
import ElementJeu.Bouclier;
import ElementJeu.Missile;
import Ennemis.*;
import IHM.GagneF;
import iut.Game;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Florian
 */
public class GameInst extends Game {

    
    private ATH _ath;
    
    public GameInst() {
        super(1024, 768, "Space");

    }

    @Override
    protected void createObjects() {
        //ajout vaisseau
        VaisseauJoueur v = new VaisseauJoueur(this, "vaisseau", 30, this.height() / 2);
        this.addKeyInteractiveObject(v);
        this._ath = new ATH(this, v);
        this.add(v);
        //test ajout météor

        Meteor3 m3 = new Meteor3(this, this.getWidth() - 50, this.getHeight() / 2, -3, 0);
        this.add(m3);

        Meteor2 m2 = new Meteor2(this, this.getWidth() - 50, this.getHeight() / 2, -5, 0);
        this.add(m2);

        Meteor1 m1 = new Meteor1(this, this.getWidth() / 2, this.getHeight() / 2, -3, 0);
        this.add(m1);

        Bouclier b = new Bouclier(this, this.getWidth() - 50, this.getHeight() / 2);
        this.add(b);

        Missile m = new Missile(this, this.getWidth() - 50, this.getHeight() / 3);
        this.add(m);

    }

    @Override
    protected void drawBackground(Graphics g) {
        try {
            Image img = ImageIO.read(new File("Images/fond.png"));
            g.drawImage(img, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);
        } catch (IOException ex) {
            Logger.getLogger(GameInst.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    

    

    @Override
    protected void perdu() {
        System.out.println("vous avez perdu");
    }

    @Override
    protected void gagne() {
        GagneF f = new GagneF();
        f.setVisible(true);
    }

    public ATH getAth() {
        return _ath;
    }
    
    

    

}
