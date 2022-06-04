/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_22_serializable_arreglos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;




/**
 *
 * @author invitado
 */
public class EVA3_22_SERIALIZABLE_ARREGLOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Collections. <Tipos de datos genericos>
        ArrayList<Persona> miListaPerso = new ArrayList();
        //Java --> Listas, Arreglos, etc: 0 --> n - 1
        miListaPerso.add(new Persona("Juan","Martinez"));//0
        miListaPerso.add(new Persona("Manuel","Martinez"));//1
        miListaPerso.add(new Persona("Ricardo","Martinez"));//2
        miListaPerso.add(new Persona("Ana","Martinez"));//3
        miListaPerso.add(new Persona("Lupita","Martinez"));//4
        miListaPerso.add(new Persona("Sancho","Martinez"));//5
        miListaPerso.add(new Persona("Pedro","Martinez"));//6
        escribirObj(miListaPerso);
        leerObj();
    }
    
    //Guardar objetos
    public static void escribirObj(Object obj){
        try {
            FileOutputStream abrirArch = new FileOutputStream("C:/Archivos/Texto4.obj");
            ObjectOutputStream guardarObj = new ObjectOutputStream(abrirArch);
            guardarObj.writeObject(obj);
            guardarObj.flush();
            guardarObj.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    //Leer objetos
    public static void leerObj(){
        try {
            FileInputStream abrirArch = new FileInputStream("C:/Archivos/Texto4.obj");
            ObjectInputStream leerObjeto = new ObjectInputStream(abrirArch);
            ArrayList<Persona> miListaPerso = (ArrayList<Persona>)leerObjeto.readObject();//Objeto (Class Object)
            for (int i = 0; i < miListaPerso.size(); i++) {
            Persona persona = miListaPerso.get(i);
            System.out.println("Nombre: " +  persona.getNombre() + " " + persona.getApellido());
            }
            leerObjeto.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}

class Persona implements Serializable{
    private String nombre;
    private String apellido;

    public Persona() {
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}    
