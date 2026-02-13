import java.util.Scanner;
public class Main {
    static Persona[] personas = new Persona[20];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n      MENU ");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID (solo activas)");
            System.out.println("3) Baja lógica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    alta();
                    break;
                case 2:
                    buscar();
                    break;
                case 3:
                    bajaLogica();
                    break;
                case 4:
                    listarActivas();
                    break;
                case 5:
                    actualizarNombre();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }

        } while (opcion != 0);
    }
    public static void alta() {

        System.out.print("Ingrese ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        if (id <= 0) {
            System.out.println("ID inválido.");
            return;
        }

        if (buscarPorId(id) != -1) {
            System.out.println("ID repetido.");
            return;
        }

        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();

        if (nombre.isEmpty()) {
            System.out.println("Nombre no puede estar vacío.");
            return;
        }

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                personas[i] = new Persona(id, nombre);
                System.out.println("Persona agregada correctamente.");
                return;
            }
        }

        System.out.println("Arreglo lleno.");
    }
    public static void buscar() {

        System.out.print("Ingrese ID a buscar: ");
        int id = sc.nextInt();

        int pos = buscarPorId(id);

        if (pos != -1 && personas[pos].activa) {
            System.out.println("Encontrada: " + personas[pos].nombre);
        } else {
            System.out.println("No encontrada o inactiva.");
        }
    }
    public static void bajaLogica() {

        System.out.print("Ingrese ID a dar de baja: ");
        int id = sc.nextInt();

        int pos = buscarPorId(id);

        if (pos != -1 && personas[pos].activa) {
            personas[pos].activa = false;
            System.out.println("Persona dada de baja");
        } else {
            System.out.println("No encontrada o ya inactiva");
        }
    }
    public static void listarActivas() {

        System.out.println("\nPERSONAS ACTIVAS ");

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].activa) {
                System.out.println("ID: " + personas[i].id +
                        "        Nombre: " + personas[i].nombre);
            }
        }
    }
    public static void actualizarNombre() {

        System.out.print("Ingrese ID a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        int pos = buscarPorId(id);

        if (pos != -1 && personas[pos].activa) {

            System.out.print("Nuevo nombre: ");
            String nuevoNombre = sc.nextLine();

            if (nuevoNombre.isEmpty()) {
                System.out.println("Nombre vacío.");
                return;
            }

            personas[pos].nombre = nuevoNombre;
            System.out.println("Nombre actualizado.");
        } else {
            System.out.println("No encontrada o inactiva.");
        }
    }
    public static int buscarPorId(int id) {

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].id == id) {
                return i;
            }
        }
        return -1;
    }
}
