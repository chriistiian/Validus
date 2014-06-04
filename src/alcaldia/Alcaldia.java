/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alcaldia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 *
 * @author Administrador
 */



public class Alcaldia {
public String Texto="";
public String [] Matriz;
public Validacion ob=new Validacion();


public void archivoTXT(String Ruta){
        
        try {
            FileReader fr = new FileReader(Ruta);
            BufferedReader br = new BufferedReader(fr);
            String txt,ruta=Ruta;
            //ob.Nombre_archivo(ruta);
            while ((txt=br.readLine())!= null) {
            ob.Recorer(txt);
            ob.posicionX++;
            }
         
        } catch (Exception e) {
        }

}
}
