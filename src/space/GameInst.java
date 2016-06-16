/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import ATH.ATH;
import ElementJeu.*;
import Ennemis.BVaisseau1;
import IHM.GagneF;
import Vaisseaux.VaisseauJoueur;
import iut.Game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Florian
 */
public class GameInst extends Game{

    private ATH _ath;
    
    public GameInst() {
        super(1024, 768, "Space");
    }

    @Override
    protected void createObjects() {
        //ajout vaisseau
        VaisseauJoueur v = new VaisseauJoueur(this, 30, this.height()-80);
        this._ath = new ATH(this,v);
        this.addKeyInteractiveObject(v);
        this.add(v);
        //test ajout météor
        
        BVaisseau1 bv1 = new BVaisseau1(this, this.getWidth()-200, this.getHeight()/2);
        this.add(bv1);
        
        Bouclier b = new Bouclier(this, this.getWidth()-50, this.getHeight()/2);
        this.add(b);
        
        Missile m = new Missile(this, this.getWidth()-50, this.getHeight()/3);
        this.add(m);
        
        Vie vie = new Vie(this, this.getWidth()-50, this.getHeight()/4);
        this.add(vie);
        
    }

    @Override
    protected void drawBackground(Graphics g) {
        try {
            Image img = ImageIO.read(new File("Images/fond.png"));
            g.drawImage(img, this.getX(), this.getY(), this.getWidth(), this.getHeight(), Color.white, this);
        } 
        catch (IOException ex) {
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
