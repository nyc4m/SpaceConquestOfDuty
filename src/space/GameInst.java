/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Florian
 */
public class GameInst extends Game {
    
    private VaisseauJoueur vaisseau;
    private int xHud = 10; //position en x du HUD
    private int yHud = 10; //position en y du HUD
    private int vie;
    private int missile;
    
    private final int ESPACEMENT = 10; //espacement entre chaque icone
    private final int LARGEUR_ICONE_VIE = 50; //Dimension des icones du HUD
    private final int LARGEUR_ICONE_MISSILE = 50;
    private final int HAUTEUR_ICONE_MISSILE = 50;
    
    public GameInst() {
        super(1024, 768, "Space");
        
    }
    
    @Override
    protected void createObjects() {
        //ajout vaisseau
        VaisseauJoueur v = new VaisseauJoueur(this, "vaisseau", 30, this.height() / 2);
        this.vaisseau = v;
        this.missile = v.getMissiles();
        this.vie = v.getVie();
        this.addKeyInteractiveObject(v);
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
        
        this.initHUD();
        
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
    
    public void initHUD() {
        for (int i = 0; i < 3; i++) {
            IconeVie iV = new IconeVie(this, this.xHud + (LARGEUR_ICONE_VIE + ESPACEMENT) * i, this.yHud);
            IconeMissile iM = new IconeMissile(this, this.xHud + (LARGEUR_ICONE_MISSILE + ESPACEMENT) * i, this.yHud + HAUTEUR_ICONE_MISSILE + ESPACEMENT);
            this.add(iM);
            this.add(iV);
        }
        
    }
    
    public void enleverIconeVie(int x) {
        this.enleverIcone("IconeVie", x, this.yHud);
    }
    
    public void enleverIconeMissile(int x) {
        this.enleverIcone("IconeMissile", x, this.yHud + this.ESPACEMENT + this.HAUTEUR_ICONE_MISSILE);
    }
    
    public void enleverIcone(String nom, int x, int y) {
        switch (nom) {
            case "IconeVie":
                this.remove(new IconeVie(this, x, y));
                break;
            case "IconeMissile":
                this.remove(new IconeMissile(this, x, y));
                break;
        }
    }
    
    public void majHUD() {
        if (this.vaisseau.getVie() != this.vie) {
            this.vie = this.vaisseau.getVie();
            switch (this.vie) {
                case 0:
                    this.enleverIconeVie(this.xHud);
                    break;
                case 1:
                    this.enleverIconeVie(this.xHud + this.ESPACEMENT + this.LARGEUR_ICONE_VIE);
                    break;
                case 2:
                    this.enleverIconeVie(this.xHud + (this.ESPACEMENT + this.LARGEUR_ICONE_VIE) * 2);
            }
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
    
    public VaisseauJoueur getVaisseau() {
        return this.vaisseau;
    }
    
    public void setVaisseau(VaisseauJoueur v) {
        this.vaisseau = v;
    }
    
}
