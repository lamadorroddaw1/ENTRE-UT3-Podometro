
/**
 * La clase modela un sencillo podómetro que registra información
 * acerca de los pasos, distancia, ..... que una persona (hombre o mujer)
 * ha dado en una semana. 
 * 
 * @author    - Lander Amador Rodriguez - 
 * 
 */
public class Podometro {

    private char hombre;
    private char mujer;
    private double zancada_Hombre;
    private double zancada_Mujer;
    private int sabado;
    private int domingo;
    private String marca;
    private double altura;
    private char sexo;
    private double longitudZancada;
    private int totalPasosLaborales;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private int totalDistaniaSemana;
    private int totalDistanciaFinSemana;
    private int tiempo;
    private int caminatasNoche;

    /**
     * Inicializa el podómetro con la marca indicada por el parámetro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String queMarca) {
        hombre = 'H';
        mujer = 'M';
        zancada_Hombre = 0.00;
        zancada_Mujer = 0.00;
        marca = queMarca;
        sexo = 'H';
    }

    /**
     * accesor para la marca
     * Probar que se ha enlazado correctamente
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Simula la configuración del podómetro.
     * Recibe como parámetros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna además el valor adecuado al atributo longitudZancada
     * 
     * (leer enunciado)
     *  
     */
    public void configurar(double queAltura, char queSexo) {
        altura = queAltura;
        sexo = queSexo;        
        if (queSexo == 'M'){
            longitudZancada = Math.round (altura / 0.45);
            zancada_Mujer = longitudZancada;
        }        
        if (queSexo == 'H'){
            longitudZancada = Math.round (altura / 0.41);
            zancada_Hombre = longitudZancada;
        }        
    }

    /**
     *  Recibe cuatro parámetros que supondremos correctos:
     *    pasos - el nº de pasos caminados
     *    dia - nº de día de la semana en que se ha hecho la caminata 
     *              (1 - Lunes, 2 - Martes - .... - 6 - Sábado, 7 - Domingo)
     *    horaInicio – hora de inicio de la caminata
     *    horaFina – hora de fin de la caminata
     *    
     *    A partir de estos parámetros el método debe realizar ciertos cálculos
     *    y  actualizará el podómetro adecuadamente  
     *   
     *   (leer enunciado del ejercicio)
     */
    public String registrarCaminataToString(int pasos, int dia, int horaInicio,int horaFin) {                  
        String strdia = "";
        switch (dia){
            case 1:  strdia = "Lunes";
            break;
            case 2: strdia = "Martes";
            break;
            case 3: strdia = "Miercoles";
            break;
            case 4: strdia = "Jueves";
            break;
            case 5: strdia = "Viernes";
            break;
            case 6: strdia = "Sabado";
            break;
            case 7: strdia = "Domingo";
            break;
        }
        if (dia <=5 && dia >=1){
            pasos = totalPasosLaborales; 
        }
        if (dia == 6){
            pasos = totalPasosSabado;
        }
        if (dia == 7){
            pasos = totalPasosDomingo;
        }
        totalDistanciaFinSemana = totalPasosSabado + totalPasosDomingo;
        tiempo = horaFin - horaInicio; 

        return strdia;
    }

    /**
     * Muestra en pantalla la configuración del podómetro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() {
        System.out.println ("Configuracion del podómetro" +
        "\n***************************" +    
        "\nAltura: " + altura + 
        "\nsexo: " + sexo + 
        "\nlongitud zancada: " + longitudZancada);
    }

    /**
     * Muestra en pantalla información acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstadísticas() {
        System.out.println ("Estadisticas" +
        "\n***************************" +    
        "\nNº pasos dias laborales: " + totalPasosLaborales + 
        "\nNº pasos dias SÁBADO: " + totalPasosSabado + 
        "\nNº pasos dias DOMINGO: " + totalPasosDomingo +
        "\nNº caminatas realizadas a partir de las 21H: : " + sexo + 
        "\nTiempo total caminado en la semana: " + tiempo + 
        "\nDia/s con mas pasos caminados: " + "diaMayorNumeroPasos");
    }

    // /**
    // *  Calcula y devuelve un String que representa el nombre del día
    // *  en el que se ha caminado más pasos - "SÁBADO"   "DOMINGO" o  "LABORABLES"
    // */
    // public String diaMayorNumeroPasos() {
        // if (){
        // }
    // }
    
    /**
     * Restablecer los valores iniciales del podómetro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no varía
     *  
     */    
    public void reset() {
        totalPasosLaborales = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        //"diaMayorNumeroPasos" = 0;
        longitudZancada = 0;
        altura = 0;        
        //horaInicio = 0;
        //horaFin = 0;
    }
}
