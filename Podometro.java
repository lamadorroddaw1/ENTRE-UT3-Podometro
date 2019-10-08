
/**
 * La clase modela un sencillo pod�metro que registra informaci�n
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
    private double totalDistaniaSemana;
    private double totalDistanciaFinSemana;
    private int tiempo;
    private int caminatasNoche;

    /**
     * Inicializa el pod�metro con la marca indicada por el par�metro.
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
     * Simula la configuraci�n del pod�metro.
     * Recibe como par�metros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna adem�s el valor adecuado al atributo longitudZancada
     * 
     * (leer enunciado)
     *  
     */
    public void configurar(double queAltura, char queSexo) {
        altura = queAltura;
        sexo = queSexo;        
        if (queSexo == 'M'){
            longitudZancada = Math.round (altura * 0.45);
            zancada_Mujer = longitudZancada;
        }        
        if (queSexo == 'H'){
            longitudZancada = Math.round (altura * 0.41);
            zancada_Hombre = longitudZancada;
        }        
    }

    /**
     *  Recibe cuatro par�metros que supondremos correctos:
     *    pasos - el n� de pasos caminados
     *    dia - n� de d�a de la semana en que se ha hecho la caminata 
     *              (1 - Lunes, 2 - Martes - .... - 6 - S�bado, 7 - Domingo)
     *    horaInicio � hora de inicio de la caminata
     *    horaFina � hora de fin de la caminata
     *    
     *    A partir de estos par�metros el m�todo debe realizar ciertos c�lculos
     *    y  actualizar� el pod�metro adecuadamente  
     *   
     *   (leer enunciado del ejercicio)
     */
    public void registrarCaminata(int pasos, int dia, int horaInicio,int horaFin) {                  
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
            totalPasosLaborales = pasos; 
        }
        if (dia == 6){
            totalPasosSabado = pasos;
        }
        if (dia == 7){
            totalPasosDomingo = pasos;
        }
        if(horaInicio >= 2100){
            caminatasNoche++;
        }
        if(sexo == hombre){
            totalDistanciaFinSemana = (pasos * longitudZancada) /1000;
        }
        else {
            totalDistanciaFinSemana = (pasos * longitudZancada) /1000;
        }           
        int horas = horaFin/100-horaInicio/100;
        int minutos = (((horaFin /100) * 100 - horaFin) - ((horaInicio/100)*100-horaInicio));
        if(minutos <0){
            minutos += 60; horas--;
        }  
        tiempo += horas *60 + minutos;
    }  

    /**
     * Muestra en pantalla la configuraci�n del pod�metro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() {
        System.out.println ("Configuracion del pod�metro" +
            "\n***************************" +    
            "\nAltura: " + altura + 
            "\nsexo: " + sexo + 
            "\nlongitud zancada: " + longitudZancada);
    }

    /**
     * Muestra en pantalla informaci�n acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstad�sticas() {
        System.out.println ("Estadisticas" +
            "\n***************************" +    
            "\nN� pasos dias laborales: " + totalPasosLaborales + 
            "\nN� pasos dias S�BADO: " + totalPasosSabado + 
            "\nN� pasos dias DOMINGO: " + totalPasosDomingo +
            "\nN� caminatas realizadas a partir de las 21H: " + caminatasNoche + 
            "\nTiempo total caminado en la semana: " + tiempo + 
            "\nDia/s con mas pasos caminados: " + diaMayorNumeroPasos());
    }

     /**
     *  Calcula y devuelve un String que representa el nombre del d�a
     *  en el que se ha caminado m�s pasos - "S�BADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() {
        if (totalPasosSabado > totalPasosDomingo && totalPasosLaborales < totalPasosSabado) {
            return "S�BADO";
        }
        else if (totalPasosDomingo > totalPasosSabado && totalPasosLaborales < totalPasosDomingo){
            return "DOMINGO";
        }
        else {
            return "LABORABLES";
        }         
    }

    /**
     * Restablecer los valores iniciales del pod�metro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no var�a
     *  
     */    
    public void reset() {
        totalPasosLaborales = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;        
        longitudZancada = 0;
        altura = 0;
        sexo = mujer;
      }
}
