/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento de Tecnolog�as de la Informaci�n y Comunicaciones
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
     * Vector de cl�nicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de cl�nicas
     */
    public CentralPacientes() {

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Cl�nica del Country");
        listaClinicas.add("Cl�nica Palermo");
        listaClinicas.add("Cl�nica Reina Sof�a");
        listaClinicas.add("Cl�nica El Bosque");
        listaClinicas.add("Cl�nica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de pacientes de la cl�nica
     *
     * @return El n�mero de pacientes de la cl�nica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {

        // TODO: Realiar el m�todo que agrega al principio
        pacientes.add(0,pac);
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista est� vac�a el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        // TODO: Agragar un paciente al final de la lista
        pacientes.add(pac);
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el c�digo especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente antes del paciente con el c�digo dado

        for (int i = 0; i<pacientes.size(); i++ ) {
            if (pacientes.get(i).darCodigo() == cod){
                pacientes.add(i,pac);
                break;
            }
        }


    }

    /**
     * Adiciona un paciente a la lista de pacientes despu�s del paciente con el c�digo especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente despu�s del paciente con el c�digo cod
        for (int i = 0; i<pacientes.size(); i++ ) {
            if (pacientes.get(i).darCodigo() == cod){
                pacientes.add(i+1,pac);
                break;
            }
        }
    }

    /**
     * Busca el paciente con el c�digo dado en la lista de pacientes.
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
     * Elimina el paciente con el c�digo especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        // TODO: Si no existe el paciente con el c�digo dado, genera la excepci�n
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
     * Retorna la lista de cl�nicas manejadas por la central
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
    // Puntos de Extensi�n
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
     * De las 6 opciones de cl�nicas que tiene la central
     * �Cu�l es el nombre de la m�s ocupada, la que tiene m�s pacientes?
     *
     * @return nombre de la cl�nica
     */
    public String metodo4()
    {
        int count = 0;
        int counta = 0;
        int countb = 0;
        int countc = 0;
        int countd = 0;
        int counte = 0;


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
        String mayor = listaClinicas.get(0);
        int greatest = count;

         if (greatest<counta){
             mayor = listaClinicas.get(1);
             greatest = counta;
         }
        if (greatest<countb){
            mayor = listaClinicas.get(2);
            greatest = countb;
        }
        if (greatest<countc){
            mayor = listaClinicas.get(3);
            greatest = countc;
        }
        if (greatest<countd){
            mayor = listaClinicas.get(4);
            greatest = countd;
        }
        if (greatest<counte){
            mayor = listaClinicas.get(5);
        }

        return mayor;
    }


}
