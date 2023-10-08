/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nintendovssquareenix;

/**
 *
 * @author SebasBD
 */
public class Developer extends Thread{
    private int pagoTotal;
    private int dolarPorHora;
    private double produccionDiaria;
    private int accProduccion;
    private int tipoDesarrollador;
    private String parteJuego;
    private final int id;
    private boolean esIntegrador;
    
    public Developer (int id, int tipoDesarrollador, String parteJuego){
        this.pagoTotal = 0;
        this.parteJuego = parteJuego;
        this.id = id;
        this.dolarPorHora = 0;
        this.accProduccion = 0;
        this.produccionDiaria = 0;
        this.tipoDesarrollador = tipoDesarrollador;
        this.accProduccion = 0;
    
    }
    
    @Override
    
    public void run (){
        
        while(true){
            try{
                System.out.println("hola");
            }catch(InterruptedException e){
                System.out.println("error");
            
            }
        }
    }
    
    // O = Desarrollador de narrativa
    // 1 = Diseñador de niveles
    // 2 = Artista de sprites
    // 3 = Programador de logica
    // 4 = Desarrollador de DLC
    // 5 = Integrador
    public void DeveloperbyType(){
        if(tipoDesarrollador == 0) {
            dolarPorHora = 10;
            produccionDiaria = 0.5;
        }else if (tipoDesarrollador == 1) {
            dolarPorHora = 13;
            produccionDiaria = 0.5;
        }else if (tipoDesarrollador == 2) {
            dolarPorHora = 20;
            produccionDiaria = 3;
        }else if (tipoDesarrollador == 3) {
            dolarPorHora = 8;
            produccionDiaria = 3;
        }else if (tipoDesarrollador == 4) {
            dolarPorHora = 17;
            produccionDiaria = 0.34;
        }else if (tipoDesarrollador == 5) {
            dolarPorHora = 25;
            produccionDiaria = 0.5;
        }else{
            dolarPorHora = 0;
            produccionDiaria = 0;
            
        }
       
        setaccProduccion(0);
    }
    
    public int getDolarPorHora(){
        return dolarPorHora;
    }
    public void setaccProduccion(double accProduccion){
        accProduccion = accProduccion;
    }
    
    public void PagoDiarioDeveloper(){
        pagoTotal += (getDolarPorHora()*24); 
    }
    
}
