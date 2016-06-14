/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ennemis;

import TirVaisseau.badLaser;
import iut.Game;

/**
 *
 * @author Florian
 */
public abstract class BadVaisseau extends iut.ObjetTouchable{

    public BadVaisseau(Game g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    @Override
    public String toString() {
        return "BV";
    }
    
    public int alea(int min, int max){
        return min+(int)(Math.random()*((max-min)+1));
    }

    @Override
    public void move(long l){
        int a = this.alea(0, 20);
        int b = this.alea(0, 20);
        System.out.println(a);
        if(a==b){
            badLaser bl = new badLaser(this.game(), this.getMiddleX()-80, this.getMiddleY());
            this.game().add(bl);
        }
    }

    @Override
    public boolean isFriend() {
        return false;
    }

    @Override
    public boolean isEnnemy() {
        return true;
    }
    
    
    
}
