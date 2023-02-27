/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralPacientes.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes = new ArrayList<>();

    /**
     * Vector de clínicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de clínicas
     */
    public CentralPacientes() {

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Clínica del Country");
        listaClinicas.add("Clínica Palermo");
        listaClinicas.add("Clínica Reina Sofía");
        listaClinicas.add("Clínica El Bosque");
        listaClinicas.add("Clínica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el número de pacientes de la clínica
     *
     * @return El número de pacientes de la clínica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {

        // TODO: Realiar el método que agrega al principio
        pacientes.add(0,pac);
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista está vacía el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        // TODO: Agragar un paciente al final de la lista
        pacientes.add(pac);
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el código especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente antes del paciente con el código dado

        for (int i = 0; i<pacientes.size(); i++ ) {
            if (pacientes.get(i).darCodigo() == cod){
                pacientes.add(i,pac);
                break;
            }
        }


    }

    /**
     * Adiciona un paciente a la lista de pacientes después del paciente con el código especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente después del paciente con el código cod
        for (int i = 0; i<pacientes.size(); i++ ) {
            if (pacientes.get(i).darCodigo() == cod){
                pacientes.add(i+1,pac);
                break;
            }
        }
    }

    /**
     * Busca el paciente con el código dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        Paciente p = null;
        for (int i = 0; i<pacientes.size(); i++ ) {
            if (pacientes.get(i).darCodigo() == codigo) {
                p = pacientes.get(i);
            }
        }
        return p;
    }

    /**
     * Elimina el paciente con el código especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        // TODO: Si no existe el paciente con el código dado, genera la excepción
        for (int i = 0; i<pacientes.size(); i++ ) {
            if (pacientes.get(i).darCodigo() == cod){
                pacientes.remove(i);
                break;
            }
        }
    }

    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de clínicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        return pacientes.size();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres()
    {
        int count = 0;
        for (int i = 0; i<pacientes.size(); i++ ) {
            if (pacientes.get(i).darSexo() == 1){
                count ++;
            }
        }
        return count;
    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres()
    {
        int count = 0;
        for (int i = 0; i<pacientes.size(); i++ ) {
            if (pacientes.get(i).darSexo() == 2){
                count ++;
            }
        }
        return count;
    }

    /**
     * De las 6 opciones de clínicas que tiene la central
     * ¿Cuál es el nombre de la más ocupada, la que tiene más pacientes?
     *
     * @return nombre de la clínica
     */
    public String metodo4()
    {
        int count = 0;
        int counta = 0;
        int countb = 0;
        int countc = 0;
        int countd = 0;
        int counte = 0;
        String mayor = "Clinica del Country";
        int greatest = count;

        for (int i = 0; i<pacientes.size(); i++ ) {

            if (pacientes.get(i).darClinica().equals(listaClinicas.get(0))){
                count ++;
            }
            else if (pacientes.get(i).darClinica().equals(listaClinicas.get(1))){
                counta ++;
            }
            else if (pacientes.get(i).darClinica().equals(listaClinicas.get(2))){
                countb ++;
            }
            else if (pacientes.get(i).darClinica().equals(listaClinicas.get(3))){
                countc ++;
            }
            else if (pacientes.get(i).darClinica().equals(listaClinicas.get(4))){
                countd ++;
            }
            else if (pacientes.get(i).darClinica().equals(listaClinicas.get(5))){
                counte ++;
            }
        }
         if (greatest<counta){
             mayor = "Clinica Palermo";
             greatest = counta;
         }
        if (greatest<countb){
            mayor = "Clinica Reina Sofia";
            greatest = countb;
        }
        if (greatest<countc){
            mayor = "Clinica el Bosque";
            greatest = countc;
        }
        if (greatest<countd){
            mayor = "Clinica San Ignacio";
            greatest = countd;
        }
        if (greatest<counte){
            mayor = "Otra";
            greatest = counte;
        }

        return mayor;
    }


}
