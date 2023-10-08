/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nintendovssquareenix;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SebasBD
 */
public class ProjectManager extends Thread{
    private int dolarPorHora;
    private float pagoTotal;
    private int faltas;
    private String estadoPM;
    private int diasPublicar;
    private Semaphore contador = new Semaphore(1);
    
    public ProjectManager (int diasPublicar){
        this.dolarPorHora = 20;
        this.pagoTotal = 0;
        this.faltas = 0;
        this.diasPublicar = diasPublicar;
        
    }
    
    public void actualizarContador(){
        
        try{
            setEstadoPM("cambiando contador");
            contador.acquire();
            setEstadoPM("cambiando contador");
            sleep(3000/3);//Suponiendo que el dia dure 3000, se divide entre 3 ya que son 8h
            setDiasParaPublicar(getDiasParaPublicar()-1);
            contador.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setEstadoPM(String estado){
        this.estadoPM = estado;
    }
    
    public String getEstadoPM(){
        return this.estadoPM;
    }
    public void setDiasParaPublicar(int diasPublicar){
        this.diasPublicar = diasPublicar;
    
    }
    
    public int getDiasParaPublicar(){
        return this.diasPublicar;
    }
    
    public int getDolarPorHora(){
        return this.dolarPorHora;
    }
    public float getPagoTotal (){
        return this.pagoTotal;
    }
    
    public void setPagoTotal(float pagoTotal){
        this.pagoTotal = pagoTotal;
    }
    
    public int getFaltas(){
        return faltas;
    }
    
    public void pagoDiarioPM(){
        setPagoTotal(getPagoTotal() + (getDolarPorHora() * 24));
        System.out.println(getPagoTotal());
    }
    
    @Override
    
    public void run (){
        while(true){
            pagoDiarioPM();
            actualizarContador();
            restoDia();
        }
    }
    // En esta funcion aun falta colocar las faltas que le pone el Director 
    // Y ajustar lo que dura el dia 
    public void restoDia (){
        boolean trabaja = true;
        
        for (int i=0; i < 32; i++){
            if(trabaja){
                setEstadoPM("Trabajando");
                
            }else{
                setEstadoPM("Viendo Streams");
                 
            }
            
            trabaja = !trabaja;
            
            try{
                sleep(21);
            }catch(InterruptedException ex) {
                Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
            
            }
        }
    }
}
