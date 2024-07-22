package constructoress;

public class constructores {
    public static void main(String[] args) {
        // Crear una lista de constructores con sus puntos
        Constructor[] constructores = {
            new Constructor("Ferrari", 7694),
            new Constructor("Mercedes", 6180),
            new Constructor("Red Bull Racing", 4307),
            new Constructor("McLaren", 3831),
            new Constructor("Williams", 3137),
            new Constructor("Renault", 1689),
            new Constructor("Lotus", 1142),
            new Constructor("Honda", 835),
            new Constructor("Tyrrell", 707),
            new Constructor("Brabham", 523)
        };

        // Imprimir la tabla
        printTable(constructores);
    }

    public static void printTable(Constructor[] constructores) {
        // Imprimir encabezado
        System.out.println("+-------------------------+--------+");
        System.out.println("| Nombre                  | Puntos |");
        System.out.println("+-------------------------+--------+");

        // Imprimir cada fila de la tabla
        for (Constructor constructor : constructores) {
            System.out.printf("| %-23s | %6.0f |\n", constructor.getNombre(), constructor.getPuntos());
        }

        // Imprimir línea de cierre
        System.out.println("+-------------------------+--------+");
    }
}

class Constructor {
    private String nombre;
    private double puntos;

    public Constructor(String nombre, double puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPuntos() {
        return puntos;
    }
}
