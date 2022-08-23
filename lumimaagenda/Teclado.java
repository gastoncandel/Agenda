package lumimaagenda;
import java.util.Scanner;

public class Teclado
{
    private static final Scanner TECLADO = new Scanner(System.in);
    private static final String MENSAJE_ERROR_NUMERICO = 
            "Debe ingesar un numero.";

    public static String leerTexto(String mensaje){
        print(mensaje);
        return TECLADO.nextLine();
    }

    public static char leerChar(String mensaje, String posibles){
        char c=' ';
        boolean salir = false;

        do{
            try{
                
                c = leerTexto(mensaje).charAt(0);
                
                if (!existeCaracter(c, posibles)){
                    println("Caracteres validos: " + posibles);
                } 
                else{
                    salir = true;
                }
            }
            catch(Exception e)
            {
                println("Debe ingresar nuevamente!!\n");
            }
        } while (!salir);
        return c;
    }
    
    public static char leerChar(String mensaje){
        boolean salir = false;
        char c = 0;

        while (!salir){
            try{
                c = leerTexto(mensaje).charAt(0);
                salir = true;
            }
            catch (Exception e){
                
                println("Debe ingresar nuevamente!!\n");
            }
        }
        return c;
    }

    public static int leerInt(String mensaje){
        int n = 0;
        boolean salir = false;

        while (!salir){
            try{
                n = new Integer(leerTexto(mensaje));
                salir = true;
            } 
            catch (NumberFormatException e){
                System.out.println(MENSAJE_ERROR_NUMERICO + "\n");
            }
        }
        return n;
    }

    public static int leerInt(String mensaje, int limInf, int limSup){
        int n = 0;

        do{
            try{
                n = new Integer(leerTexto(mensaje));
                if (n < limInf || n > limSup){
                    println("Dato fuera de rango (" + limInf + " ... " + limSup 
                            + ") \n");
                }
            } 
            catch (NumberFormatException e){
                println(MENSAJE_ERROR_NUMERICO + "\n");
                n = limInf - 1;
            }
        } while (n < limInf || n > limSup);

        return n;
    }

    public static long leerLong(String mensaje){
        long n = 0;
        boolean salir = false;

        while (!salir){
            try{
                n = new Long(leerTexto(mensaje));
                salir = true;
            } 
            catch (NumberFormatException e){
                println(MENSAJE_ERROR_NUMERICO + "\n");
            }
        }
        return n;
    }

    public static long leerLong(String mensaje, long limInf, long limSup){
        long n = 0;

        do{
            try{
                n = new Long(leerTexto(mensaje));
                if (n < limInf || n > limSup){
                    println("Dato fuera de rango (" + limInf + " ... " + limSup 
                            + ") \n");
                }
            } 
            catch (NumberFormatException e){
                println(MENSAJE_ERROR_NUMERICO + "\n");
                n = limInf - 1;
            }
        }while (n < limInf || n > limSup);

        return n;
    }

    public static float leerFloat(String mensaje){
        float n = 0;
        boolean salir = false;

        while (!salir){
            try{
                n = Float.parseFloat(leerTexto(mensaje));
                salir = true;
            } 
            catch (NumberFormatException e){
                println(MENSAJE_ERROR_NUMERICO + "\n");
            }
        }
        return n;
    }

    public static float leerFloat(String mensaje, float limInf, float limSup){
        float n = 0;

        do{
            try{
                n = Float.parseFloat(leerTexto(mensaje));
                if (n < limInf || n > limSup){
                    println("Dato fuera de rango (" + limInf + " ... " + limSup 
                            + ") \n");
                }
            } 
            catch (NumberFormatException e){
                println(MENSAJE_ERROR_NUMERICO + "\n");
                n = limInf - 1;
            }
        } while (n < limInf || n > limSup);

        return n;
    }

    public static double leerDouble(String mensaje){
        double n = 0;
        boolean salir = false;

        while (!salir){
            try{
                n = new Double(leerTexto(mensaje));
                salir = true;
            } 
            catch (NumberFormatException e){
                println(MENSAJE_ERROR_NUMERICO + "\n");
            }
        }
        return n;
    }

    public static double leerDouble(String mensaje, double limInf, double limSup)
    {
        double n = 0;

        do{
            try{
                n = new Double(leerTexto(mensaje));
                if (n < limInf || n > limSup){
                    println("Dato fuera de rango (" + limInf + " ... " + limSup 
                            + ") \n");
                }
            }
            catch (NumberFormatException e){
                println(MENSAJE_ERROR_NUMERICO + "\n");
                n = limInf - 1;
            }
        }while (n < limInf || n > limSup);

        return n;
    }

    private static void print(String mensaje){
        System.out.print(mensaje);
    }

    private static void println(String mensaje){
        System.out.println(mensaje);
    }

    private static boolean existeCaracter(char c, String posibles){
        for (int i = 0; i < posibles.length(); i++){
            if (posibles.charAt(i) == c){
                return true;
            }
        }
        return false;
    }
}
