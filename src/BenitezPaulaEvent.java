import java.time.LocalDate;
import java.util.ArrayList;

enum Prioridad{
    HIGH, MEDIUM, LOW
}

public class BenitezPaulaEvent {
    private String title;
    private LocalDate date;
    private Prioridad prioridad;
    private ArrayList<BenitezPaulaEventTask>tasks;

    //Este constructor pide los detalles del evento, nombre, frecha y nivel de prioridad.
    public BenitezPaulaEvent(String title, LocalDate date, Prioridad prioridad){
        this.title= title;
        this.date= date;
        this.prioridad= prioridad;
        this.tasks= new ArrayList<>();

    }

    public void addTask(BenitezPaulaEventTask task){
        this.tasks.add(task);
    }

    public ArrayList<BenitezPaulaEventTask>getTasks(){
        return tasks;

    }

    public String getTitle(){
        return title;

    }

    @Override
    public String toString() {
        int tasksCompleta= 0;
        for (int i=0; i<tasks.size();  i++){
            if (tasks.get(i).isCompleted()) {
                tasksCompleta++;
            }

        }
        return "Evento: " + title + " | Fecha: " + date + " | Prioridad: " + prioridad +
                " | Tareas completadas: " + tasksCompleta + "/" + tasks.size();

    }
}
