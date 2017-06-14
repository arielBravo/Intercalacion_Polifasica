/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.FileWriter;
/**
 *
 * @author ariel
 */
public class OrdenamientoPolifasico {
        public static void Fusiona(String rutaOriginal, String rutaAuxiliar1, String rutaAuxiliar2, int campo) throws FileNotFoundException, IOException, ParseException{         
        int limit=1;
        CsvWriter Original = new CsvWriter(new FileWriter(rutaOriginal),',');
        CsvReader auxiliar1 = new CsvReader(rutaAuxiliar1,',');
        CsvReader auxiliar2 = new CsvReader(rutaAuxiliar2,',');
        String auxR1="", auxR2="";
        boolean end1=true, end2=true;
        
        if (auxiliar1.readRecord())
        {    
            auxR1=auxiliar1.get(campo);
            end1=false;
        }
        if (auxiliar2.readRecord())
        {    
            auxR2=auxiliar2.get(campo);
            end2=false;
        }
        
        
        while((!end1 || !end2))
        {
            
            while(!end1 && !end2 && (ComprobarCampos(auxR1, auxiliar1.get(campo), campo) && ComprobarCampos(auxR2, auxiliar2.get(campo), campo)) )
            {
               
                if ( ComprobarCampos(auxiliar1.get(campo),auxiliar2.get(campo), campo) ) 
                {
                    Original.write(auxiliar1.get(0));
                    Original.write(auxiliar1.get(1));
                    Original.write(auxiliar1.get(2));
                    Original.write(auxiliar1.get(3));
                    auxR1 = auxiliar1.get(campo);
                    Original.endRecord();
                    end1=true;
                    if (auxiliar1.readRecord()){
                        if (ComprobarCampos(auxR1, auxiliar1.get(campo), campo)) 
                            auxR1 = auxiliar1.get(campo);
                        end1=false;
                    }                        
                }else
                {
                    Original.write(auxiliar2.get(0));
                    Original.write(auxiliar2.get(1));
                    Original.write(auxiliar2.get(2));
                    Original.write(auxiliar2.get(3));
                    auxR2 = auxiliar2.get(campo);
                    Original.endRecord();
                    end2=true;
                    if (auxiliar2.readRecord()){
                        end2=false;
                        if ( ComprobarCampos(auxR2, auxiliar2.get(campo), campo) )
                            auxR2 = auxiliar2.get(campo);
                        
                    }
                       
                }                
            }
            
            while (!end1 && ComprobarCampos(auxR1, auxiliar1.get(campo), campo) )
            {
                Original.write(auxiliar1.get(0));
                Original.write(auxiliar1.get(1));
                Original.write(auxiliar1.get(2));
                Original.write(auxiliar1.get(3));
                auxR1 = auxiliar1.get(campo);
                Original.endRecord();
                end1=true;
                if (auxiliar1.readRecord()){
                    end1=false;
                }       
            }
            
            while (!end2 && ComprobarCampos(auxR2, auxiliar2.get(campo),campo) ) 
            {
                
                Original.write(auxiliar2.get(0));
                Original.write(auxiliar2.get(1));
                Original.write(auxiliar2.get(2));
                Original.write(auxiliar2.get(3));
                auxR2 = auxiliar2.get(campo);
                Original.endRecord();
                end2=true;
                if (auxiliar2.readRecord()){
                    end2=false;
                }                   
            }
            if (!end1)         
                auxR1 = auxiliar1.get(campo);
            if (!end2)
                auxR2 = auxiliar2.get(campo);
            limit++;
        }  
        Original.close();
       auxiliar1.close();
        auxiliar2.close();         
     }
     
     public static void Particion(String rutaOriginal,String rutaAuxiliar1,String rutaAuxiliar2, int campo) throws FileNotFoundException, IOException, ParseException{
        CsvReader original = new CsvReader(rutaOriginal,',');
        CsvWriter auxiliar1 = new CsvWriter(new FileWriter(rutaAuxiliar1),',');
        CsvWriter auxiliar2 = new CsvWriter(new FileWriter(rutaAuxiliar2),',');
        String R,Aux;
        boolean band=true;
        if (original.readRecord())
            band = false;
        R = original.get(0);
        auxiliar1.write(R);
        R = original.get(1);
        auxiliar1.write(R);
        R = original.get(2);
        auxiliar1.write(R);
        R = original.get(3);
        auxiliar1.write(R);
        R = original.get(campo);
        auxiliar1.endRecord();
        Aux=R;
        band=true;
        while(original.readRecord()){
            R=original.get(campo);
            if(ComprobarCampos(Aux, R, campo)){
                Aux=R;
                
                if(band==true){
                    
                    R = original.get(0);
                    auxiliar1.write(R);
                    R = original.get(1);
                    auxiliar1.write(R);
                    R = original.get(2);
                    auxiliar1.write(R);
                    R = original.get(3);
                    auxiliar1.write(R);
                    auxiliar1.endRecord();
                }
                else{
                    R = original.get(0);
                   auxiliar2.write(R);
                    R = original.get(1);
                   auxiliar2.write(R);
                    R = original.get(2);
                    auxiliar2.write(R);
                    R = original.get(3);
                    auxiliar2.write(R);
                    auxiliar2.endRecord(); 
                }
            }
            else{
                Aux=R;
                if(band==true){
                    R = original.get(0);
                    auxiliar2.write(R);
                    R = original.get(1);
                    auxiliar2.write(R);
                    R = original.get(2);
                    auxiliar2.write(R);
                    R = original.get(3);
                    auxiliar2.write(R);
                    auxiliar2.endRecord(); 
                    band=false;
                }
                else{
                    R = original.get(0);
                    auxiliar1.write(R);
                    R = original.get(1);
                    auxiliar1.write(R);
                    R = original.get(2);
                   auxiliar1.write(R);
                    R = original.get(3);
                    auxiliar1.write(R);
                    auxiliar1.endRecord();
                    band=true;
                }
            }
        }
        original.close();
        auxiliar1.close();
        auxiliar2.close();   
    }
     
      public static boolean ComprobarCampos(String R1, String R2, int campo) throws ParseException
     {
         switch(campo)
         {
             case 0:
                 return Integer.parseInt(R1)<=Integer.parseInt(R2);
             case 1:
                 return R1.compareTo(R2)<=0;
             case 2:
                 if(R1.equals("TRUE")){
                     R1="1";
                 }
                 else{
                     R1="0";
                 }
                 if(R2.equals("TRUE")){
                     R2="1";
                 }
                 else{
                     R2="0";
                 }
                 return Integer.parseInt(R1)<=Integer.parseInt(R2);
             case 3:
                 SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
                try
                {
                   Date fecha1 = sd.parse(R1);
                   Date fecha2 = sd.parse(R2);
                   return fecha1.compareTo(fecha2)<=0;
                }
                catch (ParseException e){}

         }
         return false;
     }
      public static void eliminarAuxFile(String rutaAuxiliar1,String rutaAuxiliar2) throws IOException{
        CsvWriter auxiliar1 = new CsvWriter(new FileWriter(rutaAuxiliar1),',');
        CsvWriter auxiliar2 = new CsvWriter(new FileWriter(rutaAuxiliar2),',');
        auxiliar1.close();
        auxiliar2.close();
        boolean existe = new File(rutaAuxiliar1).exists();
        if (existe)
        {
            File ficheroAux = new File(rutaAuxiliar1);
            ficheroAux.delete();
        }
        existe= new File(rutaAuxiliar2).exists();
        if (existe)
        {
            File ficheroAux = new File(rutaAuxiliar2);
            ficheroAux.delete();
        }
    }
}
