package lumimaagenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Agenda {

    private static final String RUTA = "C:\\Users\\gaston\\Desktop";

    private final String nombreArchivo;
    private ArrayList<Contacto> losContactos;

    public Agenda() {
        nombreArchivo = RUTA + "agenda.txt";
        losContactos = new ArrayList();

    }

    public Agenda(String nombreArchivo) {
        this.nombreArchivo = RUTA + nombreArchivo;
        losContactos = new ArrayList();

    }

    public void inicio() {
        String opcion = "";
        recuperarLaAgenda();
        do {
            opcion = new Selector("Agenda,"
                    + "Agregar   Un Contacto,"
                    + "Buscar    Un Contacto,"
                    + "Eliminar  Un Contacto,"
                    + "Modificar Un Contacto,"
                    + "Mostrar   La Agenda,"
                    + "Guardar   La Agenda,"
                    + "Recuperar La Agenda,"
            ).getOpcion();

            switch (opcion) {
                case "1":
                    agregarUncontacto();
                    break;
                case "2":
                    buscarUncontacto();
                    break;
                case "3":
                    eliminarUncontacto();
                    break;
                case "4":
                    modificarUncontacto();
                    break;
                case "5":
                    mostrarLaAgenda();
                    break;
                case "6":
                    guardarLaAgenda();
                    break;
                case "7":
                    recuperarLaAgenda();
                    break;
            }
        } while (!opcion.equals("SALIR"));
        guardarLaAgenda();

    }

    private void agregarUncontacto() {
        Contacto c = new Contacto();

        String opcion = new Selector("Agregar Un Contacto En Memoria,"
                + "Desde Teclado,En Forma Random,Cancelar Operacion").getOpcion();
        switch (opcion) {
            case "1":
                c = Contacto.getInstance();
                break;
            case "2":
                c = Contacto.getContactoRandom();
                break;
        }

        if (!opcion.equals("3")) {
            if (losContactos.add(c)) {
                System.out.println("CONTACTO AGREGADO CORRECTAMENTE!");
            }
            else {
                System.out.println("ERROR AL AGREGAR EL CONTACTO");
            }
            

        }
    }

    private void buscarUncontacto() {
        System.out.println("\nBuscar Un Contacto\n");
        int idBuscado = Teclado.leerInt("Id (1..20000): ", 1, 20000);

        Contacto contactoEncontrado = buscarContacto(idBuscado);
        if (contactoEncontrado == null) {
            System.out.println("El Contacto No Existe en La Agenda!!!");
        }
        else {
            contactoEncontrado.mostrar();
        }

    }

    private void eliminarUncontacto() {
        System.out.println("\nEliminar Un Contacto\n");
        int idBuscado = Teclado.leerInt("Id (1..20000): ", 1, 20000);

        Contacto contactoencontrado = buscarContacto(idBuscado);
        if (contactoencontrado == null) {
            System.out.println("El Contacto No Existe en La Agenda!!!");
        }
        else {
            contactoencontrado.mostrar();
            if (Character.toUpperCase(Teclado.leerChar("Desea Eliminar Al "
                    + "Contacto (S/N): ", "SNsn")) == 'S') {
                losContactos.remove(contactoencontrado);
                System.out.println("El Contacto Fue Eliminado !!!");
            }

        }

    }

    private void modificarUncontacto() {

        System.out.println("A Cargo Del Alumno!");
    }

    private void guardarLaAgenda() {
        File archivo;
        BufferedWriter escribe;
        FileWriter flujoEscritura;

        try {
            archivo = new File(nombreArchivo);

            if (!archivo.exists()) {//Si no Existe el fichero lo crea
                archivo.createNewFile();
            }
            flujoEscritura = new FileWriter(archivo.getAbsoluteFile());
            escribe = new BufferedWriter(flujoEscritura);
            for (int i = 0; i < losContactos.size(); i++) {
                escribe.write(losContactos.get(i).toString() + "\r\n");
            }
            escribe.close();
            System.out.println("\nOK: ARCHIVO GUARDADO CORRECTAMENTE!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private void recuperarLaAgenda() {
        File archivo;
        BufferedReader bufferDeLectura;
        FileReader flujoDeLectura;
        String linea = "";

        try {
            archivo = new File(nombreArchivo);
            if (archivo.exists()) {
                flujoDeLectura = new FileReader(archivo);
                bufferDeLectura = new BufferedReader(flujoDeLectura);
                linea = bufferDeLectura.readLine();
                while (linea != null) {
                    losContactos.add(new Contacto(linea));
                    linea = bufferDeLectura.readLine();
                }
                bufferDeLectura.close();
                System.out.println("\nOK: ARCHIVO LEIDO CORRECTAMENTE!");
            }
            else {
                archivo.createNewFile();
                System.out.println("\nOK: ARCHIVO CREADO VACIO!");
            }
        } catch (IOException ex) {
            System.out.println("\nError: " + ex.getMessage());
        }

    }

    private void mostrarLaAgenda() {
        System.out.println("\nListado de los datos de la agenda\n");
        for (Contacto c : losContactos) {
            System.out.println(c);
        }

    }

    public void eliminar(int id) {
        boolean encontre = false;
        Contacto muere = null;
        
        for (int i = 0; i < losContactos.size() && !encontre; i++) {
            if (id == losContactos.get(i).getId()) {
                encontre = true;
                muere = losContactos.get(i);
            }
        }

        if (encontre) {
            losContactos.remove(muere);
            guardarLaAgenda();
            System.out.println("CONTACTO ELIMINADO!!!!!");
        }
        else {
            System.out.println("\nNO EXISTE EL CONTACTO!!");
        }
    }

    private Contacto buscarContacto(int idBuscado) {
        for (Contacto c : losContactos) {
            if (idBuscado == c.getId()) {
                return c;
            }
        }
        return null;
    }
}
