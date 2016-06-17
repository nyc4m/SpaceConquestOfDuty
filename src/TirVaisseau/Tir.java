/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TirVaisseau;

import ElementJeu.Vague;
import iut.Game;
import iut.Objet;
import space.GameInst;

/**
 *
 * @author Florian
 */
public class Tir extends iut.ObjetTouchable{
    
    private GameInst jeu;

    public Tir(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
        this.jeu = (GameInst)g;
    }

    @Override
    public void effect(Objet objet) {
        if(this.collision(objet)){
            if(objet.isEnnemy()){
                this.supprimerEnnemi(objet);
                this.majVague();
            }
        }
    }
    
    public void majVague(){
        if(this.aucunEnnemi()){
            this.nouvelleVague();
        }
    }
    
    public boolean aucunEnnemi(){
        return this.jeu.getEnnemi().isEmpty();
    }
    
    public void supprimerEnnemi(Objet o){
        this.game().remove(o);
        this.game().remove(this);
        this.jeu.getEnnemi().remove(o);
    }
    
    public void nouvelleVague(){
        this.jeu.setNiveau(this.jeu.getNiveau()+1);
        Vague va  = new Vague(this.jeu, this.jeu.getNiveau());
        this.jeu.setEnnemi(va.getElement());
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
    public void move(long l) {
        this.move(30, 0);
    }
    
    @Override
    public String toString(){
        return "T";
    }
    
}
