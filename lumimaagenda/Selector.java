package lumimaagenda;

public class Selector {
    private String[]opciones;
    private int opcion;
   
    public Selector (String lasOpciones) {
        opciones=lasOpciones.split(",");
        opcion=0;
    }

    public String getOpcion() {
        int j;
        System.out.println("------------------------------------------------------------------------");
        System.out.println(opciones[0]);//TITULO
        System.out.println("------------------------------------------------------------------------");
        for ( j = 1; j < opciones.length; j++) {
            //System.out.println("("+j+")" + "----------------- " + opciones[j]);
            System.out.println(String.format("(%3d) ----------------- %s",j,opciones[j]));
                   }
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println(String.format("(%3d) ----------------- %s",j,"SALIR"));
        System.out.println("------------------------------------------------------------------------");
        String respuesta;
        respuesta = String.valueOf(Teclado.leerInt("INGRESE UNA OPCION: ", 1, opciones.length));
        return (respuesta.equals(String.valueOf(opciones.length))) ? "SALIR":respuesta;
    }
        
}
    
