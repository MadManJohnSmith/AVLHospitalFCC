import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
public class Menu {
    boolean seguro=false;
    AVL arbolPrincipal = new AVL();
    public void insertarPaciente(){
        Paciente nuevoPaciente = new Paciente();
        arbolPrincipal.insertar(nuevoPaciente);
    }
    public void insertarCita(){

    }
    public void modificarPaciente(){

    }
    public void modificarCita(){

    }
    public void buscar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba el NSS del paciente que quiere buscar");
        int nss = scanner.nextInt();
        arbolPrincipal.buscar(nss);
    }
    public void mostrarPreorden(){
        arbolPrincipal.mostrarPreorden();
    }
    public void mostrarInorden(){
        arbolPrincipal.mostrarInorden();
    }
    public void mostrarPostorden(){
         arbolPrincipal.mostrarPostorden();
    }
    public void exportar(){

    }
    public void eliminar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("De el NSS del paciente que quiere eliminar");
        int nss = scanner.nextInt();
        arbolPrincipal.eliminar(arbolPrincipal.raiz,nss);
    }
    public void salir(){

    }
    public void modoPrueba(){
        if(!seguro) {
            System.out.println("\tMODO DE PRUEBA");
            System.out.println("Bienvenido de vuelta!");
            Paciente test1 = new Paciente(99092013, "Karla", "Ramírez",
                    "Palacios", 'F', 21);
            test1.agregarCita(LocalDateTime.of(2017, 10, 20, 8, 0),
                    "Juárez", 1);
            test1.agregarCita(LocalDateTime.of(2017, 10, 22, 10, 0),
                    "García", 11);
            test1.agregarCita(LocalDateTime.of(2017, 10, 23, 16, 0),
                    "Cárdenas", 2);

            Paciente test2 = new Paciente(31051985, "José", "Hernández",
                    "Meza", 'M', 41);
            test2.agregarCita(LocalDateTime.of(2017, 11, 20, 8, 0),
                    "Zarate", 20);
            test2.agregarCita(LocalDateTime.of(2017, 11, 21, 9, 0),
                    "Corona", 6);
            test2.agregarCita(LocalDateTime.of(2017, 11, 22, 8, 0),
                    "Zarate", 20);
            test2.agregarCita(LocalDateTime.of(2017, 11, 23, 9, 0),
                    "Corona", 6);
            test2.agregarCita(LocalDateTime.of(2017, 11, 24, 8, 0),
                    "Zarate", 20);

            Paciente test3 = new Paciente(15092017, "Luis", "Robles",
                    "Anzurez", 'M', 56);
            test3.agregarCita(LocalDateTime.of(2017, 6, 20, 10, 0),
                    "Pérez", 21);
            test3.agregarCita(LocalDateTime.of(2017, 7, 21, 7, 0),
                    "Tzonpantzi", 10);
            test3.agregarCita(LocalDateTime.of(2017, 8, 22, 9, 0),
                    "Pérez", 21);
            test3.agregarCita(LocalDateTime.of(2017, 9, 23, 7, 0),
                    "Andrade", 3);

            Paciente test4 = new Paciente(16091989, "Tania", "Romero",
                    "Cuamatzi", 'F', 23);
            test4.agregarCita(LocalDateTime.of(2017, 12, 7, 8, 0),
                    "Juárez", 1);
            test4.agregarCita(LocalDateTime.of(2017, 12, 22, 9, 0),
                    "Tzonpantzi", 10);
            test4.agregarCita(LocalDateTime.of(2018, 1, 23, 8, 0),
                    "Juárez", 1);

            Paciente test5 = new Paciente(16062017, "Diana", "Gómez",
                    "Arroyo", 'F', 18);
            test5.agregarCita(LocalDateTime.of(2017, 12, 20, 7, 0),
                    "Zarate", 20);
            test5.agregarCita(LocalDateTime.of(2018, 1, 21, 17, 0),
                    "Corona", 6);
            test5.agregarCita(LocalDateTime.of(2018, 2, 22, 14, 0),
                    "Corona", 6);
            test5.agregarCita(LocalDateTime.of(2018, 3, 23, 9, 0),
                    "Zarate", 20);

            seguro = true;
        }
    }
}
