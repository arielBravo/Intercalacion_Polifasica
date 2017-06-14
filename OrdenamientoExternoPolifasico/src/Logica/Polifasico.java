/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author ariel
 */
public class Polifasico {
    public void Ordenar(int campo, String directorio) throws IOException, FileNotFoundException, ParseException {
        
        String rutaAuxiliar1="auxiliar1.csv";
        String rutaAuxiliar2 = "auxiliar2.csv";
        int nroPasada = 1;
        int z=1,w=1;
        
        while(z!=0 && w!=0){
           OrdenamientoPolifasico.Particion(directorio, rutaAuxiliar1, rutaAuxiliar2, campo);
           OrdenamientoPolifasico.Fusiona(directorio, rutaAuxiliar1, rutaAuxiliar2, campo);
           w=(int) nroRegistros(rutaAuxiliar2);
           z=(int) nroRegistros(rutaAuxiliar1);
          
        }
        
        OrdenamientoPolifasico.eliminarAuxFile(rutaAuxiliar1, rutaAuxiliar2);
        
       
    }
    
    
    public static long nroRegistros(String ruta) throws IOException{
            long count=0;
            FileReader fr = new FileReader(ruta);
            BufferedReader bf = new BufferedReader(fr);
            boolean sCad;
            while (sCad = bf.readLine()!=null)
            {
                count++;
            }
            fr.close();
            bf.close();
            return count; 
    }   
}
