# **Event Planner**  📱🎯

**Event Planner** es una aplicación de consola en Java para gestionar eventos y tareas asociadas. Permite crear, listar, eliminar eventos y marcar/desmarcar tareas como completadas.  

---

## **Características**  
- **Añadir eventos**: Define título, fecha y prioridad (`HIGH`, `MEDIUM`, `LOW`).  
- **Gestionar tareas**: Agrega, lista y marca/desmarca tareas de eventos.  
- **Eliminar eventos**: Borra eventos por título.  
- **Listar eventos**: Muestra los detalles de los eventos y su progreso de tareas.  

---

## **Uso**  

### **Requisitos**  
1. **Java 8+**  
2. IDE o editor como IntelliJ, Eclipse o VS Code.  

### **Ejecución**  
1. Clona este repositorio:  
   ```bash
   git clone https://github.com/tu-usuario/event-planner.git
   cd event-planner
   ```  
2. Compila y ejecuta:  
   ```bash
   javac BenitezPaulaMain.java  
   java BenitezPaulaMain  
   ```  

---

## **Estructura**  
- **`BenitezPaulaMain`**: Lógica principal y menú interactivo.  
- **`BenitezPaulaEvent`**: Representa un evento con título, fecha, prioridad y tareas.  
- **`BenitezPaulaEventTask`**: Define tareas con descripción y estado de completitud.  
- **`Prioridad`**: Enum para las prioridades del evento.  

---

## **Ejemplo**  

### Menú principal  
```
[1] Añadir evento  
[2] Borrar evento  
[3] Listar eventos  
[4] Gestionar tareas  
[5] Salir  
```  

### Crear un evento  
```
Título: Cumpleaños  
Fecha (dd/MM/yyyy): 15/03/2024  
Prioridad: HIGH  
Añadir tareas (s/n): s  
Tarea: Comprar pastel  
Tarea: Reservar restaurante  
```  

**¡Listo para organizar tus eventos!**  
