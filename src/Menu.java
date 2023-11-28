/**
 *      @author
 *      Guillermo Sanchez Ortega
 *      Joe David González Herrera
 *      Grabiel Ramirez Bañuelos
 *      Alan Salas Parada
 */

import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Menu {
    boolean seguro=false;
    Scanner scanner = new Scanner(System.in);
    AVL arbolPrincipal = new AVL();
    //private Object avl;
    public void insertarPaciente(){
        System.out.println("\t\tAsignación de Cuenta");
        System.out.println("\tIngresa los datos del paciente\n");

        System.out.print("NSS: ");
        int nss = scanner.nextInt();            System.out.println();
        System.out.print("Nombre(s): ");
        String nom = scanner.next();            System.out.println();
        System.out.print("Apellido Paterno: ");
        String apellidoPat = scanner.next();    System.out.println();
        System.out.print("Apellido Materno: ");
        String apellidoMat = scanner.next();    System.out.println();
        System.out.print("Sexo(M ó F): ");
        char sex = scanner.next().charAt(0);    System.out.println();
        System.out.print("Edad: ");
        int ed = scanner.nextInt();             System.out.println();

        Paciente nuevoPaciente = new Paciente(nss, nom, apellidoPat, apellidoMat, sex, ed);
        arbolPrincipal.insertar(nuevoPaciente);
    }
    public void insertarCita(){
        System.out.println("\t\tAsignación de Cita");
        System.out.println("\tIngresa los datos del paciente\n");

        System.out.print("NSS: ");
        int nss = scanner.nextInt();   System.out.println();
        Paciente paciente = obtenerPaciente(nss);

        if(paciente==null){
            return;
        }
        System.out.println("\tCitas: ");
        paciente.citas.mostrarLista();      System.out.println();

        System.out.print("Año(AAAA): ");
        String an = scanner.next();         System.out.println();
        System.out.print("Mes(MM): ");
        String me = scanner.next();         System.out.println();
        System.out.print("Dia(DD): ");
        String di = scanner.next();         System.out.println();
        System.out.print("Hora(HHmm): ");
        String ho = scanner.next();         System.out.println();
        System.out.print("Minuto: ");
        String mi = scanner.next();         System.out.println();

        // Concatenar las partes de la fecha y hora con un separador
        String fechaHoraTexto = an + "-" + me + "-" + di + "T" + ho + ":" + mi;

        // Utilizar un formateador de fecha y hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime fecha = LocalDateTime.parse(fechaHoraTexto, formatter);

        // Concatenar las partes de la fecha y hora con un separador
        System.out.print("Nombre del médico: ");
        String nombreMedico = scanner.next();   System.out.println();
        System.out.print("Consultorio: ");
        int consultorio = scanner.nextInt();    System.out.println();

        Citas nuevaCita = new Citas(fecha, nombreMedico, consultorio);
        paciente.agregarCita(nuevaCita);
    }
    public void modificarPaciente(){
        System.out.println("\t\tModificar Datos");
        System.out.println("\tIngresa los datos del paciente\n");

        System.out.print("NSS: ");
        int nss = scanner.nextInt();    System.out.println();
        Paciente paciente = obtenerPaciente(nss);
        if(paciente==null){
            return;
        }
        System.out.println();
        System.out.println("""
                ¿Que dato desea modificar?
                \t1. Nombre
                \t2. Apellido Paterno
                \t3. Apellido Materno
                \t4. Sexo
                \t5. Edad
                
                \t0. Cancelar
                """);
        int opcion = scanner.nextInt();
        switch (opcion){
            case 1 -> {
                System.out.print("Nombre(s): ");
                paciente.nombres = scanner.next();System.out.println();
            }
            case 2 -> {
                System.out.print("Apellido Paterno: ");
                paciente.apellidoPaterno = scanner.next();System.out.println();
            }
            case 3 -> {
                System.out.print("Apellido Materno: ");
                paciente.apellidoMaterno = scanner.next();System.out.println();
            }
            case 4 -> {
                System.out.print("Sexo(M ó F): ");
                paciente.sexo = scanner.next().charAt(0);System.out.println();
            }
            case 5 -> {
                System.out.print("Edad: ");
                paciente.edad = scanner.nextInt();System.out.println();
            }
            case 7 -> {
                AVL miAVL = new AVL();

                System.out.println("Exportando datos del AVL a un archivo...");
                System.out.print("Ingrese el nombre del archivo: ");
                String nombreArchivo = scanner.next();System.out.println();
                miAVL.exportarAVL(nombreArchivo+".txt");
            }
            case 0 -> {
                return;
            }
            default -> System.out.println("Opcion invalida!");
        }
        System.out.println("Datos del paciente modificados con éxito");
    }
    public void modificarCita(){
        System.out.println("\t\tModificar Cita");
        System.out.println("\tIngresa los datos del paciente\n");

        System.out.print("NSS: ");
        int nss = scanner.nextInt();System.out.println();
        Paciente paciente = obtenerPaciente(nss);
        if (paciente == null) {
            return;
        }

        System.out.println("\tElige la cita que quieres modificar");
        paciente.citas.mostrarLista();

        System.out.println("Ingrese el índice de la cita que desea modificar: ");
        int indiceCitaModificar = scanner.nextInt();

        if (indiceCitaModificar < 1 || indiceCitaModificar > paciente.citas.obtenerTamano()) {
            System.out.println("Índice de cita no válido. Operación cancelada.");
            return;
        }

        // Obtener la cita seleccionada
        Citas citaSeleccionada = paciente.citas.obtenerCitaPorIndice(indiceCitaModificar);

        // Mostrar detalles de la cita seleccionada
        System.out.println("Detalles de la cita seleccionada:");
        citaSeleccionada.mostrarCita();

        // Pedir al usuario que ingrese los nuevos datos
        System.out.println();
        System.out.println("Ingrese los nuevos datos para la cita:");

        System.out.print("Año(AAAA): ");
        String an = scanner.next();System.out.println();
        System.out.print("Mes(MM): ");
        String me = scanner.next();System.out.println();
        System.out.print("Dia(DD): ");
        String di = scanner.next();System.out.println();
        System.out.print("Hora(HH): ");
        String ho = scanner.next();System.out.println();
        System.out.print("Minuto(MM): ");
        String mi = scanner.next();System.out.println();

        // Concatenar las partes de la fecha y hora con un separador
        String fechaHoraTexto = an + "-" + me + "-" + di + "T" + ho + ":" + mi;

        // Utilizar un formateador de fecha y hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime nuevaFecha = LocalDateTime.parse(fechaHoraTexto, formatter);

        System.out.print("Nombre del médico: ");
        String nuevoNombreMedico = scanner.next();System.out.println();
        System.out.print("Consultorio: ");
        int nuevoConsultorio = scanner.nextInt();System.out.println();

        // Crear una nueva cita con los datos actualizados
        Citas nuevaCita = new Citas(nuevaFecha, nuevoNombreMedico, nuevoConsultorio);

        // Modificar la cita en la lista
        paciente.citas.modificarCitaPorIndice(indiceCitaModificar, nuevaCita);

        System.out.println("\tCita modificada con éxito.");
    }
    public void buscar(){
        System.out.println("\t\tBuscar Paciente");
        System.out.println("\tIngresa los datos del paciente\n");
        System.out.print("NSS: ");
        int nss = scanner.nextInt();System.out.println();
        NodoAVL nodoPaciente = arbolPrincipal.buscar(nss);
        if(nodoPaciente == null){
            System.out.println("Paciente no encontrado\nVerifique su entrada");
        } else{
            Paciente paciente = nodoPaciente.paciente;
            paciente.mostrar();
        }
    }
    private Paciente obtenerPaciente(int nss) {
        NodoAVL nodoPaciente = arbolPrincipal.buscar(nss);
        if(nodoPaciente==null){
            System.out.println("Paciente no encontrado\nVerifique su entrada");
            return null;
        }
        return nodoPaciente.paciente;
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
        if (arbolPrincipal.raiz == null) {
            System.out.println("El árbol AVL está vacío. No hay datos para exportar.");
        } else {
            System.out.println("Exportando datos del AVL a un archivo...");
            System.out.println("Ingrese el nombre del archivo: ");
            String nombreArchivo = scanner.next();
            arbolPrincipal.exportarAVL(nombreArchivo+".txt");
        }
    }
    public void eliminar(){
        System.out.println("\t\tEliminar Paciente");
        System.out.println("\tIngresa los datos del paciente\n");
        System.out.println("NSS: ");
        int nss = scanner.nextInt();System.out.println();
        NodoAVL eliminar = arbolPrincipal.eliminar(arbolPrincipal.raiz, nss);
    }
    public void salir(){
        System.out.println("Cerrando el programa. ¡Hasta luego!");
        try {
            // Agrega un tiempo de espera de 2 segundos
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Maneja la excepción si se interrumpe el hilo durante la espera
            e.printStackTrace();
        }
        System.exit(0);
    }
    public void datosPrueba(){
        if(!seguro) {
            System.out.println("\tDATOS DE PRUEBA RECUPERADOS");
            System.out.println("\t\tBienvenido de vuelta!");System.out.println();

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

            arbolPrincipal.insertar(test1);
            arbolPrincipal.insertar(test2);
            arbolPrincipal.insertar(test3);
            arbolPrincipal.insertar(test4);
            arbolPrincipal.insertar(test5);

            seguro = true;
        }
    }
    public void mostrar(){

        int opcion;
        do{
            System.out.println("\tMENU PRINCIPAL");
            System.out.println("""
                1. Insertar
                2. Modificar
                3. Buscar
                4. Mostrar en Preorden
                5. Mostrar en Inorden
                6. Mostrar en Postorden
                7. Exportar
                8. Eliminar
                9. Salir
                """);
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("\tSeleccione una opción");
                    System.out.println("a) Insertar Paciente \nb)Insertar Cita");
                    char o = scanner.next().charAt(0);
                    if(o == 'a'){
                        insertarPaciente();
                    }else if(o=='b'){
                        insertarCita();
                    }
                }
                case 2 -> {
                    System.out.println("\tSeleccione una opción");
                    System.out.println("a) Modificar Paciente \nb)Modificar Cita");
                    char op= scanner.next().charAt(0);
                    if(op == 'a'){
                        modificarPaciente();
                    }else if(op=='b'){
                        modificarCita();
                    }
                }
                case 3 -> buscar();
                case 4 -> {
                    System.out.println("Mostrando en Preorden");
                    mostrarPreorden();
                }
                case 5 -> {
                    System.out.println("Mostrar en Inorden");
                    mostrarInorden();
                }
                case 6 -> {
                    System.out.println("Mostrar en Postorden");
                    mostrarPostorden();
                }
                case 7 -> exportar();
                case 8 -> eliminar();
                case 9 -> {
                    System.out.println("¿Desas exportar los datos antes de salir? (s/n)");
                    char decide = scanner.next().charAt(0);
                    if(decide == 's'){
                        exportar();
                    }else if(decide=='n'){
                        salir();
                    }else{
                        System.out.println("Opción no válida. Intente de nuevo.");
                    }
                }
                case 42 -> datosPrueba();
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 8);
    }
}
