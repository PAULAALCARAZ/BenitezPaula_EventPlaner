public class BenitezPaulaEventTask {

    private String texto;
    private  boolean estaCompleta = false;


    //Creamos un constructor que nos pide la descripcion de la tarea.
    public BenitezPaulaEventTask(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("La tarea debe tener una descripción.");
        }
        this.texto = texto;
        this.estaCompleta = false;
    }

    /*Este metodo no tiene retorno, por eso es un "void" lo que hace es cambiar
    * el estado del boleano*/
    public void alterarCompleto (){
        this.estaCompleta = !this.estaCompleta;
    }

    public boolean isCompleted(){
        return estaCompleta;
    }

    @Override
    public String toString() {
        return "[ " + (estaCompleta ? "X" : " ") + " ] " + texto;
    }
}
