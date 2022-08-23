package lumimaagenda;



public class Contacto{

    private int id;
    private String apellido;
    private String nombres;
    private String telefono;
    private String mail;
    
    public Contacto() {
    }

    public static Contacto getContactoRandom() {
        Contacto c = new Contacto();
        c.id = intRand(10000,20000);
     
        c.apellido = nombreRandom();
        c.nombres = nombreRandom() + " " + nombreRandom();
        c.mail = mailRandom();
        c.telefono = telefonoRandom();

        return c;
    }

    public Contacto(int id, String apellido, String nombres, String telefono,
            String mail) {
        this.id = id;
        this.apellido = apellido;
        this.nombres = nombres;
        this.telefono = telefono;
        this.mail = mail;
       
    }

    public Contacto(String losAtributos) {
        String[] separados = losAtributos.split(",");
        this.id = Integer.valueOf(separados[0]);
        this.apellido = separados[1];
        this.nombres = separados[2];
        this.telefono = separados[3];
        this.mail = separados[4];
        
    }

    public static Contacto getInstance() {
        Contacto c = new Contacto();

        c.id = Teclado.leerInt("ID (10000..20000): ", 10000, 200000);
        c.nombres = Teclado.leerTexto("Nombre: ");
        c.apellido= Teclado.leerTexto("Apellido: ");
        
        c.telefono = Teclado.leerTexto("Telefono: ");
        c.mail = Teclado.leerTexto("Mail: ");
        return c;
    }

    private static String nombreRandom() {
        String s = "" + letraRandom('A', 'Z');
        int cantidad = intRand(7, 20);

        for (int i = 0; i < cantidad; i++) {

            s += letraRandom('a', 'z');
        }

        return s;
    }

    private static String telefonoRandom() {
        String s = "";
        int cantidad = 8;

        for (int i = 0; i < cantidad; i++) {
            s += letraRandom('0', '9');
        }

        return s;
    }

    private static String mailRandom() {
        String s = "";
        int cantidad = intRand(5, 10);
        for (int i = 0; i < cantidad; i++) {
            if (Math.random() < 0.3) {
                s += letraRandom('0', '9');
            }
            else {
                s += letraRandom('a', 'z');
            }
        }
        cantidad = intRand(5, 10);
        s += '@';
        for (int i = 0; i < cantidad; i++) {
            if (Math.random() < 0.3) {
                s += letraRandom('0', '9');
            }
            else {
                s += letraRandom('a', 'z');
            }
        }
        double x = Math.random();
        s += x < 0.3 ? ".com" : x < 0.6 ? ".net" : ".edu";
        return s;
    }

    @Override
    public String toString() {
        return id + "," + apellido + "," + nombres + "," + telefono + "," + mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    

    private static int intRand(int d, int h) {
        return (int) (Math.random() * (h - d + 1) + d);
    }

    private static char letraRandom(char d, char h) {
        return (char) (Math.random() * (h - d + 1) + d);
    }

    public void mostrar() {
        System.out.println("Contacto:\n" +
                "id: "+id+"\n"+
                "Nombre: "+apellido+", "+nombres+
                "Telefono: "+telefono+"\n"+
                "Mail: "+mail+"\n");
    }

}
