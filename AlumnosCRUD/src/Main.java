import java.util.Scanner;
public class Main {

    static Alumno[] alumnos = new Alumno[25];
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n          MENU");
            System.out.println("1)  Alta alumno");
            System.out.println("2)  Buscar por ID");
            System.out.println("3)  Actualizar promedio");
            System.out.println("4)  Baja lógica");
            System.out.println("5)  Listar activos");
            System.out.println("6)  Reportes");
            System.out.println("0)  Salir");

            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            switch(opcion) {
                case 1:
                    alta();
                    break;
                case 2:
                    buscar();
                    break;
                case 3:
                    actualizarPromedio();
                    break;
                case 4:
                    bajaLogica();
                    break;
                case 5:
                    listar();
                    break;
                case 6:
                    reportes();
                    break;
                case 0:
                    System.out.println("Fin");

            }

        } while(opcion != 0);

    }
    public static void alta() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        if(id <= 0) {
            System.out.println("ID invalido");
            return;
        }

        if(buscarPosicion(id) != -1) {
            System.out.println("ID repetido");
            return;
        }
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        if(nombre.equals("")) {
            System.out.println("Nombre vacio");
            return;
        }
        System.out.print("Promedio: ");
        double promedio = sc.nextDouble();

        if(promedio < 0 || promedio > 10) {
            System.out.println("Promedio invalido");
            return;
        }
        for(int i=0; i<alumnos.length; i++) {

            if(alumnos[i] == null) {

                alumnos[i] = new Alumno(id, nombre, promedio);
                System.out.println("Alumno agregado");
                return;

            }
        }
        System.out.println("Arreglo lleno");

    }
    public static void buscar() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        int posicion = buscarPosicion(id);
        if(posicion != -1 && alumnos[posicion].activo) {
            System.out.println("ID: " + alumnos[posicion].id);
            System.out.println("Nombre: " + alumnos[posicion].nombre);
            System.out.println("Promedio: " + alumnos[posicion].promedio);
        } else {
            System.out.println("No encontrado");
        }

    }

    public static void actualizarPromedio() {

        System.out.print("ID: ");
        int id = sc.nextInt();

        int pos = buscarPosicion(id);

        if(pos != -1 && alumnos[pos].activo) {

            System.out.print("Nuevo promedio: ");
            double promedio = sc.nextDouble();

            if(promedio < 0 || promedio > 10) {
                System.out.println("Promedio invalido");
                return;
            }

            alumnos[pos].promedio = promedio;
            System.out.println("Promedio actualizado");

        } else {

            System.out.println("No encontrado");

        }

    }

    public static void bajaLogica() {

        System.out.print("ID: ");
        int id = sc.nextInt();

        int posicion = buscarPosicion(id);

        if(posicion != -1 && alumnos[posicion].activo) {

            alumnos[posicion].activo = false;
            System.out.println("Alumno dado de baja");

        } else {

            System.out.println("No encontrado");

        }

    }

    public static void listar() {

        System.out.println("\nAlumnos activos");

        for(int i=0; i<alumnos.length; i++) {

            if(alumnos[i] != null && alumnos[i].activo) {

                System.out.println(
                        alumnos[i].id + " " +
                                alumnos[i].nombre + " " +
                                alumnos[i].promedio
                );

            }
        }
    }
    public static void reportes() {
        double suma = 0;
        int cont = 0;
        Alumno mayor = null;
        Alumno menor = null;
        int mayores8 = 0;
        for(int i=0; i<alumnos.length; i++) {

            if(alumnos[i] != null && alumnos[i].activo) {

                suma += alumnos[i].promedio;
                cont++;

                if(mayor == null || alumnos[i].promedio > mayor.promedio)
                    mayor = alumnos[i];

                if(menor == null || alumnos[i].promedio < menor.promedio)
                    menor = alumnos[i];

                if(alumnos[i].promedio >= 8)
                    mayores8++;
            }
        }
        if(cont == 0) {
            System.out.println("No hay alumnos");
            return;
        }
        System.out.println("Promedio general: " + (suma/cont));
        System.out.println("Mayor promedio:");
        System.out.println(mayor.id + " " + mayor.nombre + " " + mayor.promedio);
        System.out.println("Menor promedio:");
        System.out.println(menor.id + " " + menor.nombre + " " + menor.promedio);
        System.out.println("Alumnos >= 8: " + mayores8);

    }
    public static int buscarPosicion(int id) {
        for(int i=0; i<alumnos.length; i++) {
            if(alumnos[i] != null && alumnos[i].id == id)
                return i;
        }
        return -1;
    }
}
