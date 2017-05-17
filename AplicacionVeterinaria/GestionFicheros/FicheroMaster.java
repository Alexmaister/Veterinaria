package GestionFicheros;
import ClasesAbstractas.Master;
import java.io.*;
import Clases.*;
import Excepciones.ExcepcionMascota;
import Excepciones.ExcepcionPersona;
import Gestion.GestionMapaClienteMascota;

import java.util.*;

/**
 * Created by Ale on 17/05/2017.
 */
public class FicheroMaster /*extends Master*/ {

    File master=new File("Master.txt");
    Scanner lector;
    FileWriter escritor ;
    GestionMapaClienteMascota gmapa=new GestionMapaClienteMascota();
   public void guardarRelacion(Map<Persona,ArrayList<Mascota>> relacion) {
    gmapa.setMapa(relacion);
       try {
           escritor= new FileWriter(master,true);
           escritor.write(gmapa.mapaACadena());
       }catch (IOException e){
           System.out.println(e);
       }finally{
           try {
               escritor.close();
           }catch(IOException e){}
       }
   }

    public List<Persona> leerPersonas(){
       List personas=new ArrayList<Persona>();
       Persona p=null;
       String aux=null;
       String[] s={""};
       Map<Persona,ArrayList<Mascota>> relacion=null;
       try {
           lector = new Scanner(master);
               while (lector.hasNext()) {
                   aux=lector.nextLine();
                   s=aux.split(";");
                   for(int i=0;i<s.length;i++) {
                       relacion=new LinkedHashMap<Persona,ArrayList<Mascota>>(convertidorStringMap(s[i]));
                       personas.add(p=new Persona(relacion.keySet().toString()));
                   }
               }
       }catch(FileNotFoundException e){
           System.out.println(e);
       }catch(ExcepcionPersona ep){}finally{
           lector.close();
       }
        return personas;
    }

    private Map<Persona,ArrayList<Mascota>> convertidorStringMap(String mapa) {
        Map<Persona,ArrayList<Mascota>> map=new LinkedHashMap<Persona,ArrayList<Mascota>>();
        Persona p = null;
        Mascota m = null;
        ArrayList<Mascota> lista = null;
        String[] s=null;
        String[] s2=null;
        s = mapa.split("-");
        try {
            p = new Persona(s[0]);
            s2 = s[1].split(",");
            for (int i=0;i<s2.length;i++) {

                    m = new Mascota(s2[i]);
                    lista.add(m);

                }
            }catch (ExcepcionPersona ep) {
            }catch(ExcepcionMascota em){}
        map.put(p,lista);
    return map;
    }

}
