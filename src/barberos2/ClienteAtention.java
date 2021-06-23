/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package barberos2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ClienteAtention extends Thread {

    /**
     * @return the indexBarbertention
     */
    public int getIndexBarbertention() {
        return indexBarbertention;
    }

    /**
     * @param indexBarbertention the indexBarbertention to set
     */
    public void setIndexBarbertention(int indexBarbertention) {
        this.indexBarbertention = indexBarbertention;
    }
    private int indexBarbertention=(-1);
    public ClienteAtention(int indexAtention){
        this.indexBarbertention=indexAtention;
        
    }
    public ClienteAtention(){
        
    }
    
    @Override
    public void run() {
            
            Sleep();
            NuevoProceso.charginBarber(getIndexBarbertention());
            Panel.barberos[getIndexBarbertention()] = false;
            
    }
    private int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    private void Sleep(){
         int aleatoryNumber = getRandomNumberInRange(10, 15);
        try {
                Thread.sleep(aleatoryNumber * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
