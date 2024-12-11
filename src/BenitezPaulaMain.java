
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class BenitezPaulaMain {

    private static ArrayList<BenitezPaulaEvent> events= new ArrayList<>();
    private static Scanner sc= new Scanner(System.in);
    private static DateTimeFormatter dateFormato= DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args){
        BenitezPaulaMain programa=new BenitezPaulaMain();
        programa.inicio();

    }

    public void inicio() {
        String escoge;
        do{
            showMenu();
            escoge= sc.nextLine().trim();
            switch (escoge){
                case "1":
                    addEvent();
                    break;
                case "2":
                    deleteEvent();
                    break;
                case "3":
                    listEvents();
                    break;
                case "4":
                    toggleTaskCompletion();
                    break;
                case "5":
                    System.out.println("El programa ha finalizado, Hasta pronto! ;) ");
                    break;
                default:
                    System.out.println("Opción Invalida. Selecciona una de las siguientes opciones: ");

            }

        }while (!escoge.equals("5"));

    }

    private static void showMenu() {
        System.out.println("Bienvenido a Event Planner. Selecciona una de las siguientes opción: ");
        System.out.println("[1] Añadir evento");
        System.out.println("[2] Borrar evento");
        System.out.println("[3] Listar eventos");
        System.out.println("[4] Marcar/desmarcar tarea de un evento como completada");
        System.out.println("[5] Salir");

    }

    private static void addEvent(){
        System.out.println("ingrese el titulo del Evento: ");
        String title = sc.nextLine().trim();

        LocalDate date= null;
        boolean validDate= false;
        do{
            System.out.println("Ingrese la fecha del evento (dd/MM/yyyy): ");
            String dateInput= sc.nextLine().trim();
            try{
                date=LocalDate.parse(dateInput, dateFormato);
                validDate=true; //Si la fecha es válida, salimos del bucle
            }catch (DateTimeParseException e){
                System.out.println("El formato de fecha inválido. Por favor intentalo de nuevo.");
            }
        }while (!validDate); //El bucle se repetirá hasta que la fecha sea valida

        Prioridad prioridad= null;
        boolean validPrioridad= false;
        do {
            System.out.println("Ingrese la prioridad del evento (HIGH, MEDIUM, LOW): ");
            String priorityInput=sc.nextLine().trim().toUpperCase();
            try{
                prioridad=Prioridad.valueOf(priorityInput);
                validPrioridad= true;
            }catch (IllegalArgumentException e){
                System.out.println("Prioridad inválida. Por favor elija entre HIGH, MEDIUM o LOW.");
            }
        }while (!validPrioridad);


        BenitezPaulaEvent newEvent= new BenitezPaulaEvent(title,date,prioridad);
        events.add(newEvent);

        System.out.println("¿Deseas añadir tareas al evento? (escribe s o/n): ");
        String addTasksResponse= sc.nextLine().trim();
        if(addTasksResponse.equalsIgnoreCase("s")){
            String taskText;
            do{
                System.out.println("Ingresa la descripción de la tarea (o deje vacío para terminar): ");
                taskText= sc.nextLine().trim();
                if (!taskText.isEmpty()){
                    newEvent.addTask(new BenitezPaulaEventTask (taskText));
                }
            }while (!taskText.isEmpty());
        }
        System.out.println("Evento añadido exitosamente. ");

    }
/* Usamos un bucle for para recorrer los eventos, Si encontramos el evento, lo asignamos y salimos del bucle*/
    private static void deleteEvent(){
        System.out.println("Ingrese el título del evento que desea borrar: ");
        String title = sc.nextLine().trim();

        BenitezPaulaEvent eventToDelete= null;
        for (BenitezPaulaEvent event: events){
            if (event.getTitle().equals(title)){
                eventToDelete = event;
                break;
            }
        }

        if (eventToDelete!= null){
            events.remove(eventToDelete);
            System.out.println("Evento borrado");
        }else {
            System.out.println("No se encontró ningún evento con ese título");
        }

    }

    private static void listEvents() {
        if (events.isEmpty()) {
            System.out.println("No hay eventos registrados.");
        } else {
            events.forEach(event -> System.out.println(event));
        }
    }
    private static void toggleTaskCompletion(){
        System.out.println("Ingresa el título del Evento");
        String title = sc.nextLine().trim();

        BenitezPaulaEvent event = events.stream()
                .filter(e -> e.getTitle().equals(title))
                .findFirst()
                .orElse(null);

        if (event == null) {
            System.out.println("No se encontró ningún evento con ese título.");
            return;
        }

        ArrayList<BenitezPaulaEventTask> tasks = event.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("El evento no tiene tareas asociadas.");
            return;
        }

        System.out.println("Tareas del evento:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("[%d] %s%n", i + 1, tasks.get(i));
        }

        System.out.print("Seleccione el número de la tarea para marcar/desmarcar como completada: ");
        int taskIndex;
        try {
            taskIndex = Integer.parseInt(sc.nextLine().trim()) - 1;
            if (taskIndex < 0 || taskIndex >= tasks.size()) {
                System.out.println("Número de tarea inválido.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debe ser un número.");
            return;
        }

        tasks.get(taskIndex).alterarCompleto();
        System.out.println("Estado de la tarea actualizado.");

    }


}