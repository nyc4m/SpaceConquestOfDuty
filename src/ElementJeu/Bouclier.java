/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementJeu;

import space.GameInst;

/**
 *
 * @author bapt
 */
public class Bouclier extends Bonus {
    
    public Bouclier(GameInst g, int x, int y) {
        super(g, "shield", x, y);
    }

    @Override
    public String toString() {
        return "B";
    }

}
