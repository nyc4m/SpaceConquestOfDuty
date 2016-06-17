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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Florian
 */
public class GameInst extends Game{

    private ATH _ath;
    
    private ArrayList ennemi = new ArrayList();
    
    private int niveau = 1;
    
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
         Vague va = new Vague(this, this.niveau);
         this.ennemi = va.getElement();
        
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

    public ArrayList getEnnemi() {
        return ennemi;
    }

    public void setEnnemi(ArrayList ennemi) {
        this.ennemi = ennemi;
    }
    
    

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    
    
}
