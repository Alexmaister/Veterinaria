package Test;

import Excepciones.ExcepcionFecha;
import Gestion.GestionClientes;
import GestionFicheros.FicheroDiario;
import Clases.*;
/**
 * Created by Ale on 18/05/2017.
 */
public class PruebaDiario {
    public static void main(String...a){
        GestionClientes gc=new GestionClientes();
        FicheroDiario diario=new FicheroDiario();
        Persona p=null;

            p = new Persona("Alejandroooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo", "Ortiz Zuritaaaaaaaaaaaaaaaaaaaaaaaaeeee", "45812032B",new Fecha(3,2,1993),"" ,"","","41100","");
            diario.guardarPersona(p);



    }
}
