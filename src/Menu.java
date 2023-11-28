import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Menu {
    boolean seguro=false;
    Scanner scanner = new Scanner(System.in);
    AVL arbolPrincipal = new AVL();
    public void insertarPaciente(){
        System.out.println("\t\tAsignación de Cuenta");
        System.out.println("\tIngresa los datos del paciente\n");

        System.out.println("NSS: ");
        int nss = scanner.nextInt();
        System.out.println("Nombre(s): ");
        String nom = scanner.next();
        System.out.println("Apellido Paterno: ");
        String apellidoPat = scanner.next();
        System.out.println("Apellido Materno: ");
        String apellidoMat = scanner.next();
        System.out.println("Sexo(M ó F): ");
        char sex = scanner.next().charAt(0);
        System.out.println("Edad: ");
        int ed = scanner.nextInt();

        Paciente nuevoPaciente = new Paciente(nss, nom, apellidoPat, apellidoMat, sex, ed);
        arbolPrincipal.insertar(nuevoPaciente);
    }
    public void insertarCita(){
        System.out.println("\t\tAsignación de Cita");
        System.out.println("\tIngresa los datos del paciente\n");

        System.out.println("NSS: ");
        int nss = scanner.nextInt();
        Paciente paciente = obtenerPaciente(nss);
      
        if(paciente==null){
            return;
        }
        System.out.println("Citas");
        paciente.citas.mostrarLista();

        System.out.println("Año(AAAA): ");
        String an = scanner.next();
        System.out.println("Mes(MM): ");
        String me = scanner.next();
        System.out.println("Dia(DD): ");
        String di = scanner.next();
        System.out.println("Hora(HHmm): ");
        String ho = scanner.next();
        System.out.println("Minuto ");
        String mi = scanner.next();
        
         // Concatenar las partes de la fecha y hora con un separador
        String fechaHoraTexto = an + "-" + me + "-" + di + "T" + ho + ":" + mi;

        // Utilizar un formateador de fecha y hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime fecha = LocalDateTime.parse(fechaHoraTexto, formatter);
        
        // Concatenar las partes de la fecha y hora con un separador
        System.out.println("Nombre del médico: ");
        String nombreMedico = scanner.next();
        System.out.println("Consultorio: ");
        int consultorio = scanner.nextInt();
        
        Citas nuevaCita = new Citas(fecha, nombreMedico, consultorio);
        paciente.agregarCita(nuevaCita);
        
       
    }
    public void modificarPaciente(){
        System.out.println("\t\tModificar Datos");
        System.out.println("\tIngresa los datos del paciente\n");

        System.out.println("NSS: ");
        int nss = scanner.nextInt();
        Paciente paciente = obtenerPaciente(nss);
        if(paciente==null){
            return;
        }

        System.out.println("¿Que dato desea modificar?");
        System.out.println("""
                1. Nombre
                2. Apellido Paterno
                3. Apellido Materno
                4. Sexo
                5. Edad
                
                0. Cancelar
                """);
        int opcion = scanner.nextInt();
        switch (opcion){
            case 1:
                System.out.println("Nombre(s): ");
                paciente.nombres = scanner.next();
                break;
            case 2:
                System.out.println("Apellido Paterno: ");
                paciente.apellidoPaterno = scanner.next();
                break;
            case 3:
                System.out.println("Apellido Materno: ");
                paciente.apellidoMaterno = scanner.next();
                break;
            case 4:
                System.out.println("Sexo(M ó F): ");
                paciente.sexo = scanner.next().charAt(0);
                break;
            case 5:
                System.out.println("Edad: ");
                paciente.edad = scanner.nextInt();
                break;
            case 0:
                return;
            default:
                System.out.println("Opcion invalida!");
                break;
        }
        System.out.println("Datos del paciente modificados con éxito");
    }
    public void modificarCita(){
       System.out.println("\t\tModificar Cita");
       System.out.println("\tIngresa los datos del paciente\n");

    System.out.println("NSS: ");
    int nss = scanner.nextInt();
    Paciente paciente = obtenerPaciente(nss);
    if (paciente == null) {
        return;
    }

    System.out.println("Elige la cita que quieres modificar");
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
    System.out.println("Ingrese los nuevos datos para la cita:");

    System.out.println("Año(AAAA): ");
    String an = scanner.next();
    System.out.println("Mes(MM): ");
    String me = scanner.next();
    System.out.println("Dia(DD): ");
    String di = scanner.next();
    System.out.println("Hora(HH): ");
    String ho = scanner.next();
    System.out.println("Minuto(MM): ");
    String mi = scanner.next();

    // Concatenar las partes de la fecha y hora con un separador
    String fechaHoraTexto = an + "-" + me + "-" + di + "T" + ho + ":" + mi;

    // Utilizar un formateador de fecha y hora
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    LocalDateTime nuevaFecha = LocalDateTime.parse(fechaHoraTexto, formatter);

    System.out.println("Nombre del médico: ");
    String nuevoNombreMedico = scanner.next();
    System.out.println("Consultorio: ");
    int nuevoConsultorio = scanner.nextInt();

    // Crear una nueva cita con los datos actualizados
    Citas nuevaCita = new Citas(nuevaFecha, nuevoNombreMedico, nuevoConsultorio);

    // Modificar la cita en la lista
    paciente.citas.modificarCitaPorIndice(indiceCitaModificar, nuevaCita);

    System.out.println("Cita modificada con éxito.");
    }
    public void buscar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba el NSS del paciente que quiere buscar");
        int nss = scanner.nextInt();
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

    }
    public void eliminar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba el NSS del paciente que quiere eliminar");
        int nss = scanner.nextInt();
        arbolPrincipal.eliminar(arbolPrincipal.raiz,nss);
    }
    public void salir(){

    }
    public void datosPrueba(){
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

    public void mostrar(){

        int opcion;
        do{
            System.out.println("\tMENU PRINCIPAL");
            System.out.println("""
                1. Insertar"
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
                case 1:
                    System.out.println("a) Insertar Paciente \nb)Insertar Cita");
                    char o = scanner.next().charAt(0);
                    if(o == 'a'){
                        insertarPaciente();
                    }else if(o=='b'){
                        insertarCita();
                    }
                    break;
                case 2:
                    System.out.println("a) Modificar Paciente \nb)Modificar Cita");
                    char op= scanner.next().charAt(0);
                    if(op == 'a'){
                        modificarPaciente();
                    }else if(op=='b'){
                        modificarCita();
                    }
                    break;
                case 3://buscr

                    buscar();
                    break;
                case 4:
                    System.out.println("Mostrando en Preorden");
                    arbolPrincipal.mostrarPreorden();
                    break;
                case 5:
                    System.out.println("Mostrar en Inorden");
                    arbolPrincipal.mostrarInorden();
                    break;
                case 6:
                    System.out.println("Mostrar en Postorden");
                    arbolPrincipal.mostrarPostorden();
                    break;
                case 7://exportar

                    break;
                case 8://eliminar

                    break;
                case 9://salir
                    System.out.println("¿Desas exportar los datos antes de salir?");



                    salir();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 8);
    }
}
