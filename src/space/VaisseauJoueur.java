/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import iut.Game;
import iut.Objet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Florian
 */
public class VaisseauJoueur extends iut.ObjetTouchable implements KeyListener{
    
    
    public VaisseauJoueur(Game g) {
        super(g, "vaisseau", 30, g.getHeight()/2-50);
    }

    @Override
    public void effect(Objet objet) {
        if(this.collision(objet)){
            if(objet.isEnnemy()){
                this.game().remove(this);
            }
            else if(objet.isFriend()){
                System.out.println("J'ai heurté un truc cool");
            }
        }
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
    public void move(long l) {//méthode appelée en permanence (utiliser moveX et moveY)
    }
    
    /*public void setennemy();*/

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //gestion des déplacements
        int kC = e.getKeyCode();
        int up, down, left, right, space;
        
        up=38; down = 40; left=37; right=39; space=32; 
        //deplacement de base haut/bas
        if(kC==up)
            this.move(0,-15);
        if(kC==down)
            this.move(0,15);
        
        //gestion du tir
        if(kC==32){
            TLaser t = new TLaser(this.game(),this.getMiddleX(),this.getMiddleY());
            this.game().add(t);
        }
        
        //deplacement gauche/droite optionnel
        /*
        if(kC==right)
            this.moveX(10);
        if(kC==left)
            this.moveX(-10);
        */
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
