/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package barberos2;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 * 
 * @author diego omalli <sguergachi at gmail.com>
 */
public class NuevoProceso extends Thread{
    public DefaultListModel modeloJlist = new DefaultListModel();
    @Override
    public void run() {
        while(true){
            for (int i = 0; i < Panel.barberos.length; i++) {
                if(!Panel.barberos[i]){
                     try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    EnableBarberChair(i);
                }
            }
            for (int j = 0; j < Panel.clientes.length; j++) {
                if(!Panel.clientes[j]){

                    DisableChairClient(j);
                }
            }
        }
    }
    public void checkChairClient(){
        System.out.println("entro");
        int indexBarber=(-1);
        for (int i = 0; i < Panel.barberos.length; i++) {
            if(!Panel.barberos[i]){
                indexBarber=i;
                i=Panel.barberos.length;
            }
        }
        if(Panel.clientes[0]=true){
            if(Panel.clientes[1]=true){
                if(Panel.clientes[2]=true){
                      Panel.clientes[2]=false;
                      DisableChairClient(2);
                }else{
                     Panel.clientes[1]=false;
                     DisableChairClient(1);
                }
            }else{
                Panel.clientes[0]=false;
                DisableChairClient(0);
            }
              Panel.barberos[indexBarber]=true;
             StartCutBarber(indexBarber);
             System.out.println("Comenzo A atenderte el barbero "+indexBarber);
        }
         
    }
    public void EnableBarberChair(int index){
        switch(index){
            case 0:
                Panel.Bar1.setText("Desocupado");
                Panel.Bar1.setSelected(false);
                
            break;
            case 1:
                Panel.Bar2.setText("Desocupado");
                Panel.Bar2.setSelected(false);
               
            break;
            case 2:
                Panel.Bar3.setText("Desocupado");
                Panel.Bar3.setSelected(false);
            break;
            
        }
    }
    public void DisableChairClient(int index){
        switch(index){
            case 0:
                Panel.Cli1.setVisible(false);
                
            break;
            case 1:
                Panel.Cli2.setVisible(false);
           
            break;
            case 2:
                 Panel.Cli3.setVisible(false);
                 
            break;
            
        }
        
    }
    public void EnableChairClient(int index){
        System.out.println("entro2");
        switch(index){
            case 0:
                Panel.Cli1.setVisible(true);
               
            break;
            case 1:
                Panel.Cli2.setVisible(true);
                
            break;
            case 2:
                 Panel.Cli3.setVisible(true);
                 
            break;
            
        }
         try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void StartCutBarber(int index){
        ClienteAtention clientObject= new ClienteAtention();
        switch(index){
            case 0:
                Panel.Bar1.setText("Ocupado");
                Panel.Bar1.setSelected(true);
                clientObject.setIndexBarbertention(index);
                clientObject.start();
           
            break;
            case 1:
                Panel.Bar2.setText("Ocupado");
                Panel.Bar2.setSelected(true);
                clientObject.setIndexBarbertention(index);
                clientObject.start();
                
            break;
            case 2:
                Panel.Bar3.setText("Ocupado");
                Panel.Bar3.setSelected(true);
                clientObject.setIndexBarbertention(index);
                clientObject.start();
                
            break;
        }
        //checkChairClient();
    }
    public void CreateNewProcess(){
        int bandera=0;
        int indexBarber=0;
        int indexClient=0;
        for (int i = 0; i < Panel.barberos.length; i++) {
                if(Panel.barberos[i]==false){
                    Panel.barberos[i]=true;
                    bandera=1;
                    indexBarber=i;
                    System.out.println("barebro "+i);
                    i=Panel.barberos.length; // break al for
                    
                }
            }
        if(bandera==1){
            StartCutBarber(indexBarber);
        }else{
            for (int i = 0; i < Panel.clientes.length; i++) {
                if(!Panel.clientes[i]){
                    Panel.clientes[i]=true;
                    bandera=1;
                    indexClient=i;
                    i=Panel.clientes.length;
                    
                }
            }
            if(bandera==1){
                EnableChairClient(indexClient);
            }else{
                modeloJlist.addElement("Cliente en espera");
                Panel.esperaClientesList.setModel(modeloJlist);
             
            }
        }
    }

}
