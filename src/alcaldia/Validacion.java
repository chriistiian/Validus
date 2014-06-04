/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alcaldia;
// PRUEBA DE CLAREEEEE
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

/**
 *
 * @author UNILLANOS
 */
public class Validacion {

    String Texto;
    String Genero;
    String edad;
    public String[] Matriz;
    public static int posicionX;
    public static int posicionY;
    public String entidades[] = {"500010054010", "500010054009", "500010054008"};
    /*
     Entidad
     * Es la funcion que busca en la tabla REPS la entidad prestadora del servivio
    
     */

    private boolean Entidad(String ent) {
        boolean existe_ent = false;

        for (int i = 0; i < entidades.length; i++) {
            if (entidades[i].equals(ent)) {
                existe_ent = true;
            }
        }

        return existe_ent;
    }

    /*
     Nombre_archivo
     *Validad los 8 cambos del nombre del archivo
     */
    public void Nombre_archivo(String ruta) {

        int i = 0;
        StringTokenizer tokens = new StringTokenizer(ruta, "\\");
        int nDatos = tokens.countTokens();
        String nom_archivo;
        while (tokens.hasMoreTokens()) {
            nom_archivo = tokens.nextToken();
            if (nom_archivo.length() == 39) {
                //VARIABLE 0
                if ("SGD".equals(nom_archivo.substring(0, 3))) {
                } else {
                    System.out.println("Error nombre archivo posicion 0");
                }
                //VARIABLE 1
                if ("280".equals(nom_archivo.substring(3, 6))) {
                } else {
                    System.out.println("Error nombre archivo posicion 1");
                }
                //VARIABLE 2
                if ("RPED".equals(nom_archivo.substring(6, 10))) {
                } else {
                    System.out.println("Error nombre archivo posicion 2");
                }
                //VARIABLE 3
                if (validar_F(nom_archivo.substring(10, 18)) == true) {
                } else {
                    System.out.println("Error nombre archivo posicion 3 -");
                }
                //VARIABLE 4
                if ("MU".equals(nom_archivo.substring(18, 20)) || "DE".equals(nom_archivo.substring(18, 20)) || "DI".equals(nom_archivo.substring(18, 20)) || "NI".equals(nom_archivo.substring(18, 20))) {
                } else {
                    System.out.println("Error nombre archivo posicion 4" + nom_archivo.substring(18, 20));
                }
                //VARIABLE 5
                if (nom_archivo.substring(20, 32).length() == 12) {
                } else {
                    System.out.println("Error nombre archivo posicion 5");
                }

                //VARIABLE 6
                if ("C".equals(nom_archivo.substring(32, 33)) || "S".equals(nom_archivo.substring(32, 33)) || "P".equals(nom_archivo.substring(32, 33)) || "E".equals(nom_archivo.substring(32, 33)) || "N".equals(nom_archivo.substring(32, 33))) {
                } else {
                    System.out.println("Error nombre archivo posicion 6");
                }

                //VARIABLE 7
                if ("01".equals(nom_archivo.substring(33, 35)) || "02".equals(nom_archivo.substring(33, 35)) || "03".equals(nom_archivo.substring(33, 35)) || "04".equals(nom_archivo.substring(33, 35)) || "05".equals(nom_archivo.substring(33, 35))) {
                } else {
                    System.out.println("Error nombre archivo posicion 7");
                }

                //VARIABLE 8
                if (".txt".equals(nom_archivo.substring(35, 39))) {
                } else {
                    System.out.println("Error nombre archivo posicion 8" + nom_archivo.substring(33, 35));
                }

            } else {
                System.out.println("Nombre del archivo no esta correto ");
            }

        }

        /* for (int j = 0; j < i; j++) {
         System.out.println(Matriz[j] + " * " + posicionY + " * " + nDatos);
         }*/
    }
    /*
     Informacion_personal
     *Esta funcion validad los 13 primeras variables , la informacion personal del  paciente
     *Los datos
     * TIPO DE REGISTRO, CONSECUTIVO DEL REGISTRO, CODIGO DE HABILITACION DE IPS, TIPO DE IDENTIFICACION DEL USUARIO
     * NUMERO DE IDENTIFICACION DEL USUARIO, PRIMER APELLIDO, SEGUNDO APELLIDO, PRIMER NOMBRE, SEGUNDO NOMBRE	
     * FECHA DE NACIMIENTO, SEXO, CODIGO PERTENENCIA ETNICA, CODIGO DE OCUPACION, CODIGO DE NIVEL EDUCATIVO
    
     */

    private void Informacion_personal(String txt) {

        String i_persona[] = txt.split("@");
        //System.out.println(txt);

        /*
        
         for (int h = 0; h < i_persona.length; h++) {
         System.out.println(i_persona[h] + " - " + h);
         }
         /*/
        //VARIABLES 0
        if (Integer.parseInt(i_persona[0]) == 2) {
        } else {
            System.out.println("NO VALIDO VAR-0");
        }
        //VARIABLES 1
        if (posicionY >= 0) {
        } else {
            System.out.println("NO VALIDO VAR-1");
        }
        //VARIABLES 2

        if (Entidad(i_persona[2]) == true) {
        } else {
            System.out.println("NO VALIDO VAR-2");
        }

        //VARIABLES 3
        if ("RC".equals(i_persona[3]) || "TI".equals(i_persona[3]) || "CC".equals(i_persona[3]) || "PA".equals(i_persona[3]) || "MS".equals(i_persona[3]) || "AS".equals(i_persona[3]) || "CD".equals(i_persona[3]) || "NV".equals(i_persona[3])) {
        } else {
            System.out.println("NO VALIDO VAR-3");
        }

        //VARIABLES 4
        if (i_persona[4].length() <= 18) {
        } else {
            System.out.println("NO VALIDO VAR-4");
        }
        //VARIABLES 5 -6 -7 -8
        if (i_persona[5].length() <= 30 && i_persona[6].length() <= 30 && i_persona[7].length() <= 30 && i_persona[8].length() <= 30) {
        } else {
            System.out.println("NO VALIDO VAR 5<->8");
        }

        //VARIABLES 9
        if (validar_Fecha(i_persona[9]) == true) {
        } else {
            System.out.println("NO VALIDO VAR-9");
        }
        //System.out.println(i_persona[10]);
        //VARIABLES 10
        if (("F".equals(i_persona[10])) || ("M".equals(i_persona[10]))) {
            Genero = i_persona[10];

        } else {
            System.out.println("NO VALIDO VAR-10");
        }

        //VARIABLES 11
        if (Integer.parseInt(i_persona[11]) >= 1 && Integer.parseInt(i_persona[11]) <= 6) {
        } else {
            System.out.println("NO VALIDO VAR-11");
        }
        //VARIABLES 12
        if (i_persona[12].length() > 0 && i_persona[12].length() < 10000) {
        } else {
            System.out.println("NO VALIDO VAR-12");
        }

        //VARIABLES 13
        if (Integer.parseInt(i_persona[11]) >= 1 && Integer.parseInt(i_persona[11]) <= 13) {
        } else {
            System.out.println("NO VALIDO VAR-13");
        }
    }

    /*
     Identificacion_riesgo
     * Esta funcion validad las variables 14 hasta 28, la identificacion de riesgos de los paciente
     * Los datos
     *GESTACION, SIFILIS GESTACIONAL O CONGENITA, HIPERTENSION INDUCIDA POR LA GESTACION, HIPOTIROIDISMO, CONGENITO,
     *  *SINTOMATICO RESPIRATORIO, TUBERCULOSIS MULTIDROGORESISTENTE, LEPRA, OBESIDAD O DESNUTRICION PROTEICO CALORICA,
     *  *VICTIMA DEL MALTRATO,	VICTIMA DE VIOLENCIA SEXUAL, INFECCIONES DE TRANSMISION SEXUAL, ENFERMEDAD MENTAL, CANCER DE CERVIX	CANCER DE SENO	FLUOROSIS DENTAL
    
     */
    private void Identificacion_riesgo(String txt) {
        String i_riesgo[] = txt.split("@");
        /*
         for (int h = 0; h < i_riesgo.length; h++) {
         System.out.println(i_riesgo[h] + " - " + (h + 14));
         }
         */
        //VARIABLE 14
        if (Integer.parseInt(i_riesgo[0]) >= 0 && Integer.parseInt(i_riesgo[0]) <= 2 || "21".equals(i_riesgo[0])) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,21 - GESTACIÓN");
        }
        //VARIABLE 15
        if (Integer.parseInt(i_riesgo[1]) >= 0 && Integer.parseInt(i_riesgo[1]) <= 3 || "21".equals(i_riesgo[1])) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,3,21 - SÍFILIS GESTACIONAL O CONGÉNITA");
        }
        //VARIABLE 16
        if (Integer.parseInt(i_riesgo[2]) >= 0 && Integer.parseInt(i_riesgo[2]) <= 2 || "21".equals(i_riesgo[2])) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,21 - HIPERTENSIÓN INDUCIDA POR LA GESTACIÓN ");
        }
        //VARIABLE 17
        if (Integer.parseInt(i_riesgo[3]) >= 0 && Integer.parseInt(i_riesgo[3]) <= 2 || "21".equals(i_riesgo[3])) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,21 - HIPOTIROIDISMO CONGÉNITO");
        }
        //VARIABLE 18
        if (Integer.parseInt(i_riesgo[4]) >= 1 && Integer.parseInt(i_riesgo[4]) <= 2 || "21".equals(i_riesgo[4])) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,21 - SINTOMÁTICO RESPIRATORIO ");
        }
        //VARIABLE 19
        if (Integer.parseInt(i_riesgo[5]) >= 0 && Integer.parseInt(i_riesgo[5]) <= 2 || "21".equals(i_riesgo[5])) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,21 - TUBERCULOSIS MULTIDROGORESISTENTE");
        }
        //VARIABLE 20
        if (Integer.parseInt(i_riesgo[6]) >= 1 && Integer.parseInt(i_riesgo[6]) <= 3 || "21".equals(i_riesgo[6])) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 1,2,3,21 - LEPRA");
        }
        //VARIABLE 21
        if (Integer.parseInt(i_riesgo[7]) >= 1 && Integer.parseInt(i_riesgo[7]) <= 3 || "21".equals(i_riesgo[7])) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 1,2,3,21 - OBESIDAD O DESNUTRICIÓN PROTEICO CALÓRICA ");
        }
        //VARIABLE 22
        if (Integer.parseInt(i_riesgo[8]) >= 0 && Integer.parseInt(i_riesgo[8]) <= 3 || "21".equals(i_riesgo[8])) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 1,2,3,21 - VÍCTIMA DE MALTRATO");
        }
        //VARIABLE 23
        if (Integer.parseInt(i_riesgo[9]) >= 1 && Integer.parseInt(i_riesgo[9]) <= 2 || "21".equals(i_riesgo[9])) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 1,2,21 - VÍCTIMA DE VIOLENCIA  SEXUAL");
        }
        //VARIABLE 24
        if (Integer.parseInt(i_riesgo[10]) >= 1 && Integer.parseInt(i_riesgo[10]) <= 2 || "21".equals(i_riesgo[10])) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 1,2,21 - INFECCIONES DE TRASMISIÓN SEXUAL ");
        }
        //VARIABLE 25
        if (Integer.parseInt(i_riesgo[11]) >= 1 && Integer.parseInt(i_riesgo[11]) <= 7 || "21".equals(i_riesgo[11])) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 1-7, 21 - ENFERMEDAD MENTAL ");
        }
        //VARIABLE 26
        if (Integer.parseInt(i_riesgo[12]) >= 0 && Integer.parseInt(i_riesgo[12]) <= 2 || "21".equals(i_riesgo[12])) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 1,2,21 - CÁNCER DE CÉRVIX");
        }
        //VARIABLE 27
        if (Integer.parseInt(i_riesgo[13]) >= 1 && Integer.parseInt(i_riesgo[13]) <= 2 || "21".equals(i_riesgo[13])) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 1,2,21 - CÁNCER DE SENO");
        }
        //VARIABLE 28
        if (Integer.parseInt(i_riesgo[14]) >= 1 && Integer.parseInt(i_riesgo[14]) <= 2 || "21".equals(i_riesgo[14])) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 1,2,21 - FLUOROSIS DENTAL");
        }

    }

    /*
     Actividad_I_S_R_CNP
     * Esta funcion validad las variables 29 hasta 34, actividad de  intervencion segun el riesgo de los paciente
     *Los Datos
     *FECHA DEL PESO	PESO EN KILOGRAMOS, FECHA DE LA TALLA, TALLA EN CENTIMETROS, FECHA PROBABLE DE PARTO
     * EDAD GESTACIONAL AL NACER
    
     */
    private void Actividad_I_S_R_CNP(String txt) {
        String A_ISR_1[] = txt.split("@");
        /*
         for (int h = 0; h < A_ISR_1.length; h++) {
         System.out.println(A_ISR_1[h] + " - " + (h + 29));
         }
        
         /*/
        //VARIABLE 29
        if (validar_Fecha(A_ISR_1[0]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - FECHA DEL PESO");
        }
        //VARIABLE 30
        if (Integer.parseInt(A_ISR_1[1]) >= 0 && Integer.parseInt(A_ISR_1[1]) <= 100 || "999".equals(A_ISR_1[1])) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 999,  >0- PESO EN KILOGRAMOS");
        }
        //VARIABLE 31
        if (validar_Fecha(A_ISR_1[2]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - FECHA DE LA TALLA");
        }
        //VARIABLE 32
        if (Integer.parseInt(A_ISR_1[3]) >= 0 && Integer.parseInt(A_ISR_1[3]) <= 100 || "999".equals(A_ISR_1[3])) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 999, > 0 - TALLA EN CENTÍMETROS ");
        }
        //VARIABLE 33
        if (validar_Fecha(A_ISR_1[4]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - FECHA PROBABLE DE PARTO ");
        }
        //VARIABLE 34
        if (Integer.parseInt(A_ISR_1[5]) >= 0 && Integer.parseInt(A_ISR_1[5]) >= 20 || "999".equals(A_ISR_1[5])) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,999 - EDAD GESTACIONAL AL NACER ");
        }
        System.out.println("CNP");

    }

    /*
     Actividad_I_S_R_VACUNACION
     * Esta funcion validad las variables 35 hasta 47, actividad de  intervencion segun el riesgo de los paciente (VACUNACION)
     *Los Datos
     * BCG, HEPATITIS B MENOR DE 1 AÑO, PENTAVALENTE, POLIO,	DPT MENORES DE 5 AÑOS, ROTAVIRUS, NEUMOCOCO
     * INFLUENZA EN NIÑOS, FIEBRE AMARILLA NIÑOS DE 1 AÑO, HEPATITIS A, TRIPLE VIRAL NIÑOS, 
     * VIRUS DEL PAPILOMA HUMANO (VPH),TD o TT MUJERES EN EDAD FERTIL 15 a 49 AÑOS
    
     */
    private void Actividad_I_S_R_VACUNACION(String txt) {
        String A_ISR_V[] = txt.split("@");
        /*
         for (int h = 0; h < A_ISR_V.length; h++) {
         System.out.println(A_ISR_V[h] + " - " + (h + 35));
         }/*/
        //VARIABLE 35
        if (Integer.parseInt(A_ISR_V[0]) == 0 || Integer.parseInt(A_ISR_V[0]) == 1 || Integer.parseInt(A_ISR_V[0]) >= 16 || Integer.parseInt(A_ISR_V[0]) <= 20 || Integer.parseInt(A_ISR_V[0]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,16-20,22 - BCG");
        }
        //VARIABLE 36
        if (Integer.parseInt(A_ISR_V[1]) == 0 || Integer.parseInt(A_ISR_V[1]) == 1 || Integer.parseInt(A_ISR_V[1]) >= 16 || Integer.parseInt(A_ISR_V[1]) <= 20 || Integer.parseInt(A_ISR_V[1]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,16-20,22 - HEPATITIS B MENORES DE 1 AÑO");
        }
        //VARIABLE 37
        if (Integer.parseInt(A_ISR_V[2]) == 0 || Integer.parseInt(A_ISR_V[2]) == 1 || Integer.parseInt(A_ISR_V[2]) >= 16 || Integer.parseInt(A_ISR_V[2]) <= 20 || Integer.parseInt(A_ISR_V[2]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0-3,16-20,22 - PENTAVALENTE ");
        }
        //VARIABLE 38
        if (Integer.parseInt(A_ISR_V[3]) >= 0 || Integer.parseInt(A_ISR_V[3]) <= 5 || Integer.parseInt(A_ISR_V[3]) >= 16 || Integer.parseInt(A_ISR_V[3]) <= 20 || Integer.parseInt(A_ISR_V[3]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0-5, 16-20,22 - POLIO");
        }
        //VARIABLE 39
        if (Integer.parseInt(A_ISR_V[4]) == 0 || Integer.parseInt(A_ISR_V[4]) == 4 || Integer.parseInt(A_ISR_V[4]) == 5 || Integer.parseInt(A_ISR_V[4]) >= 16 || Integer.parseInt(A_ISR_V[4]) <= 20 || Integer.parseInt(A_ISR_V[4]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,4,5,16-20,22 - DPT MENORES DE 5 AÑOS");
        }
        //VARIABLE 40
        if (Integer.parseInt(A_ISR_V[5]) >= 0 || Integer.parseInt(A_ISR_V[5]) <= 2 || Integer.parseInt(A_ISR_V[5]) >= 16 || Integer.parseInt(A_ISR_V[5]) <= 20 || Integer.parseInt(A_ISR_V[5]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0-2,16-20,22 - ROTAVIRUS");
        }
        //VARIABLE 41
        if (Integer.parseInt(A_ISR_V[6]) >= 0 || Integer.parseInt(A_ISR_V[6]) <= 3 || Integer.parseInt(A_ISR_V[6]) >= 16 || Integer.parseInt(A_ISR_V[6]) <= 20 || Integer.parseInt(A_ISR_V[6]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0-3, 16-20,22 - NEUMOCOCO");
        }
        //VARIABLE 42
        if (Integer.parseInt(A_ISR_V[7]) >= 0 || Integer.parseInt(A_ISR_V[7]) <= 3 || Integer.parseInt(A_ISR_V[7]) >= 16 || Integer.parseInt(A_ISR_V[7]) <= 20 || Integer.parseInt(A_ISR_V[7]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0-3,16-20, 22 - INFLUENZA NIÑOS");
        }
        //VARIABLE 43
        if (Integer.parseInt(A_ISR_V[8]) >= 0 || Integer.parseInt(A_ISR_V[8]) <= 1 || Integer.parseInt(A_ISR_V[8]) >= 16 || Integer.parseInt(A_ISR_V[8]) <= 20 || Integer.parseInt(A_ISR_V[8]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,16-20,22 - FIEBRE AMARILLA NIÑOS DE 1 AÑO");
        }
        //VARIABLE 44
        if (Integer.parseInt(A_ISR_V[9]) == 0 || Integer.parseInt(A_ISR_V[9]) == 1 || Integer.parseInt(A_ISR_V[9]) == 5 || Integer.parseInt(A_ISR_V[9]) >= 16 || Integer.parseInt(A_ISR_V[9]) <= 20 || Integer.parseInt(A_ISR_V[9]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,16-20,22 - HEPATITIS A ");
        }
        //VARIABLE 45
        if (Integer.parseInt(A_ISR_V[10]) >= 0 || Integer.parseInt(A_ISR_V[10]) <= 2 || Integer.parseInt(A_ISR_V[10]) >= 16 || Integer.parseInt(A_ISR_V[10]) <= 20 || Integer.parseInt(A_ISR_V[10]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0-2,16-20, 22 - TRIPLE VIRAL NIÑOS  ");
        }
        //VARIABLE 46
        if (Integer.parseInt(A_ISR_V[11]) >= 0 || Integer.parseInt(A_ISR_V[11]) <= 3 || Integer.parseInt(A_ISR_V[11]) >= 16 || Integer.parseInt(A_ISR_V[11]) <= 20 || Integer.parseInt(A_ISR_V[11]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0-4,16-20,22 - VIRUS DEL PAPILOMA HUMANO (VPH)");
        }
        //VARIABLE 47
        if (Integer.parseInt(A_ISR_V[12]) >= 0 || Integer.parseInt(A_ISR_V[12]) <= 5 || Integer.parseInt(A_ISR_V[12]) == 5 || Integer.parseInt(A_ISR_V[12]) >= 16 || Integer.parseInt(A_ISR_V[12]) <= 20 || Integer.parseInt(A_ISR_V[12]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0-20,22 - TD O TT MUJERES EN EDAD FÉRTIL 15 A 49 AÑOS");
        }
        System.out.println("VACUNACION");

    }

    /*
     Actividad_I_S_R_SPP
     * Esta funcion validad las variables 48 hasta 61, actividad de  intervencion segun el riesgo de los paciente (PLANIFICACION,PARTO,RECIEN NACIDO)
     *Los Datos
     * CONTROL DE PLACA BACTERIANA, FECHA DE ATENCION DEL PARTO O CESAREA, FECHA DE SALIDA DE LA ATENCION DEL PARTO O CESAREA,
     * FECHA DE CONSEJERIA EN LACTANCIA MATERNA, CONTROL DEL RECIEN NACIDO, PLANIFICACION FAMILIAR PRIMERA VEZ,
     * SUMINISTRO DE METODO ANTICONCEPTIVO, FECHA SUMINISTRO DE METODO ANTICONCEPTIVO, CONTROL PRENATAL PRIMERA VEZ,
     * CONTROL PRENATAL, ULTIMO CONTROL PRENATAL, SUMINISTRO DE ACIDO FOLICO EN EL ULTIMO CONTROL PRENATAL,
     * SUMINISTRO DE SULFATO FERROSO EN SU ULTIMO CONTROL PRENATAL, SUMINISTRO DE CARBONATO DE CALCIO EN EL ULTIMO CONTROL PRENATAL
    
     */
    private void Actividad_I_S_R_SPP(String txt) {

        String A_ISR_SPP[] = txt.split("@");
        /*
         for (int h = 0; h < A_ISR_SPP.length; h++) {
         System.out.println(A_ISR_SPP[h] + " - " + (h + 48));
         }
         /*/
        //VARIABLE 48
        if (Integer.parseInt(A_ISR_SPP[0]) >= 0 || Integer.parseInt(A_ISR_SPP[0]) <= 2 || Integer.parseInt(A_ISR_SPP[0]) >= 16 || Integer.parseInt(A_ISR_SPP[0]) <= 20 || Integer.parseInt(A_ISR_SPP[0]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,16,17,18,19,20,22 - CONTROL DE PLACA BACTERIANA");
        }
        //VARIABLE 49
        if (validar_Fecha(A_ISR_SPP[1]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - ATENCIÓN PARTO O CESÁREA");
        }
        //VARIABLE 50
        if (validar_Fecha(A_ISR_SPP[2]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - SALIDA DE LA ATENCIÓN DEL PARTO O CESÁREA");
        }
        //VARIABLE 51
        if (validar_Fecha(A_ISR_SPP[3]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - CONSEJERÍA EN LACTANCIA MATERNA");
        }
        //VARIABLE 52
        if (validar_Fecha(A_ISR_SPP[4]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - CONTROL RECIÉN NACIDO");
        }
        //VARIABLE 53
        if (validar_Fecha(A_ISR_SPP[5]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - PLANIFICACIÓN FAMILIAR PRIMERA VEZ");
        }
        //VARIABLE 54
        if (Integer.parseInt(A_ISR_SPP[6]) >= 0 || Integer.parseInt(A_ISR_SPP[6]) <= 21) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0-18,20,21 - SUMINISTRO DE MÉTODO ANTICONCEPTIVO");
        }
        //VARIABLE 55
        if (validar_Fecha(A_ISR_SPP[7]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - SUMINISTRO DE MÉTODO ANTICONCEPTIVO");
        }
        //VARIABLE 56
        if (validar_Fecha(A_ISR_SPP[8]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - CONTROL PRENATAL DE PRIMERA VEZ");
        }
        //VARIABLE 57
        if (Integer.parseInt(A_ISR_SPP[9]) >= 0 || Integer.parseInt(A_ISR_SPP[9]) < 10 || Integer.parseInt(A_ISR_SPP[9]) == 999) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,999 - CONTROL PRENATAL");
        }
        //VARIABLE 58
        if (validar_Fecha(A_ISR_SPP[10]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - ÚLTIMO CONTROL PRENATAL ");
        }
        //VARIABLE 59
        if (Integer.parseInt(A_ISR_SPP[11]) >= 0 || Integer.parseInt(A_ISR_SPP[11]) <= 1 || Integer.parseInt(A_ISR_SPP[11]) >= 16 || Integer.parseInt(A_ISR_SPP[11]) <= 21) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,16,17,18,19,20,21 - SUMINISTRO DE ÁCIDO FÓLICO EN EL ÚLTIMO CONTROL PRENATAL  ");
        }
        //VARIABLE 60
        if (Integer.parseInt(A_ISR_SPP[12]) >= 0 || Integer.parseInt(A_ISR_SPP[12]) <= 1 || Integer.parseInt(A_ISR_SPP[12]) >= 16 || Integer.parseInt(A_ISR_SPP[12]) <= 21) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,16,17,18,19,20,21 - SUMINISTRO DE SULFATO FERROSO EN EL ÚLTIMO CONTROL PRENATAL  ");
        }
        //VARIABLE 61
        if (Integer.parseInt(A_ISR_SPP[13]) >= 0 || Integer.parseInt(A_ISR_SPP[13]) <= 1 || Integer.parseInt(A_ISR_SPP[13]) >= 16 || Integer.parseInt(A_ISR_SPP[13]) <= 21) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,16,17,18,19,20,21 - SUMINISTRO DE CARBONATO DE CALCIO EN EL ÚLTIMO CONTROL PRENATAL  ");
        }
        System.out.println("SSP");

    }

    /*
     Actividad_I_S_R_AMCD
     * Esta funcion validad las variables 62 hasta 71, actividad de  intervencion segun el riesgo de los paciente (AGUDEZA VISUAL, MALTRATO,CRECIMIENTO Y DESARROLLO)
     *Los Datos
     * VALORACION DE AGUDEZA VISUAL, CONSULTA POR OFTALMOLOGIA, FECHA DE DIAGNOSTICO DESNUTRICION PROTEICO CALORICA,
     * CONSULTA MUJER O MENOR VICTIMA DE MALTRATO, CONSULTA VICTIMAS DE VIOLENCIA SEXUAL, CONSULTA NUTRICION
     * CONSULTA DE PSICOLOGIA, CONSULTA DE CRECIMIENTO Y DESARROLLO PRIMERA VEZ, 
     * SUMINISTRO DE SULFATO FERROSO EN LA ULTIMA CONSULTA DEL MENOR DE 10 AÑOS, SUMINISTRO DE VITAMINA A EN LA ULTIMA CONSULTA DEL MENOR DE 10 AÑOS

     */
    private void Actividad_I_S_R_AMCD(String txt) {
        String A_ISR_AMCD[] = txt.split("@");
        /*for (int h = 0; h < A_ISR_AMCD.length; h++) {
         System.out.println(A_ISR_AMCD[h] + " - " + (h + 62));
         }
         */
        //VARIABLE 62
        if (validar_Fecha(A_ISR_AMCD[0]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - VALORACIÓN DE LA AGUDEZA VISUAL ");
        }
        //VARIABLE 63
        if (validar_Fecha(A_ISR_AMCD[1]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - CONSULTA POR OFTALMOLOGÍA  ");
        }
        //VARIABLE 64
        if (validar_Fecha(A_ISR_AMCD[2]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - FECHA DIAGNÓSTICO DESNUTRICIÓN PROTEICO CALÓRICA ");
        }
        //VARIABLE 65
        if (validar_Fecha(A_ISR_AMCD[3]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - CONSULTA MUJER O MENOR VÍCTIMA DEL MALTRATO ");
        }
        //VARIABLE 66
        if (validar_Fecha(A_ISR_AMCD[4]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - CONSULTA VÍCTIMAS DE VIOLENCIA SEXUAL ");
        }
        //VARIABLE 67
        if (validar_Fecha(A_ISR_AMCD[5]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - CONSULTA NUTRICIÓN ");
        }
        //VARIABLE 68
        if (validar_Fecha(A_ISR_AMCD[6]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - CONSULTA DE PSICOLOGÍA ");
        }
        //VARIABLE 69
        if (validar_Fecha(A_ISR_AMCD[7]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - CONSULTA DE CRECIMIENTO Y DESARROLLO PRIMERA VEZ ");
        }
        //VARIABLE 70
        if (Integer.parseInt(A_ISR_AMCD[8]) == 0 || Integer.parseInt(A_ISR_AMCD[8]) == 1 || Integer.parseInt(A_ISR_AMCD[8]) >= 16 || Integer.parseInt(A_ISR_AMCD[8]) <= 21) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,16,17,18,20,21 - SUMINISTRO DE SULFATO FERROSO EN LA ÚLTIMA CONSULTA DEL MENOR DE 10 AÑOS");
        }
        //VARIABLE 71
        if (Integer.parseInt(A_ISR_AMCD[9]) == 0 || Integer.parseInt(A_ISR_AMCD[9]) == 1 || Integer.parseInt(A_ISR_AMCD[9]) >= 16 || Integer.parseInt(A_ISR_AMCD[9]) <= 21) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,16,17,18,20,21 - SUMINISTRO DE VITAMINA A EN LA ÚLTIMA CONSULTA DEL MENOR DE 10 AÑOS");
        }
        System.out.println("Actividad_I_S_R_AMCD");

    }

    /*
     Actividad_I_S_R_JA_1
     * Esta funcion validad las variables 72 hasta 81, actividad de  intervencion segun el riesgo de los paciente (JOVEN,ADULTO,HEPATITIS,SIFILES)
     *Los Datos
     * CONSULTA DE JOVEN DE PRIMERA VEZ, CONSULTA DE ADULTO DE PRIMERA VEZ, PRESERVATIVOS ENTREGADOS A PACIENTES CON ITS, ASESORIA PRE TEST ELISA PARA VIH,
     * ASESORIA POST TEST ELISA PARA VIH, PACIENTE CON DIAGNOSTICO DE ANSIEDAD, DEPRESION, ESQUIZOFRENIA, DEFICIT DE ATENCION, CONSUMO DE PSA Y BIPOLARIDAD, 
     * RECIBIÓ ATENCIÓN EN LOS ULTIMOS 6 MESES POR EQUIPO INTERDISCIPLINARIO COMPLETO,	FECHA DE ANTIGENO DE SUPERFICIE HEPATITIS B EN GESTANTES, 
     * RESULTADO ANTIGENO DE SUPERFICIE HEPATITIS B EN GESTANTES, FECHA SEROLOGIA PARA SIFILIS,	RESULTADO SEROLOGIA PARA SIFILIS
    
     */
    private void Actividad_I_S_R_JA_1(String txt) {
        String A_ISR_JA_1[] = txt.split("@");
        /*
         for (int h = 0; h < A_ISR_JA_1.length; h++) {
         System.out.println(A_ISR_JA_1[h] + " - " + (h + 72));
         }
         /*/
        //VARIABLE 72
        if (validar_Fecha(A_ISR_JA_1[0]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - CONSULTA DE JOVEN PRIMERA VEZ ");
        }
        //VARIABLE 73
        if (validar_Fecha(A_ISR_JA_1[1]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - CONSULTA DE ADULTO PRIMERA VEZ ");
        }
        //VARIABLE 74
        if (Integer.parseInt(A_ISR_JA_1[2]) <= 999) {
        } else {
            System.out.println("DATO INCORRECTO  - PRESERVATIVOS ENTREGADOS A PACIENTES CON ITS");
        }
        //VARIABLE 75
        if (validar_Fecha(A_ISR_JA_1[3]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - ASESORÍA PRE TEST ELISA PARA VIH");
        }
        //VARIABLE 76
        if (validar_Fecha(A_ISR_JA_1[4]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - ASESORÍA POS TEST ELISA PARA VIH");
        }
        //VARIABLE 77
        if (Integer.parseInt(A_ISR_JA_1[5]) >= 0 || Integer.parseInt(A_ISR_JA_1[5]) <= 2 || Integer.parseInt(A_ISR_JA_1[5]) >= 16 || Integer.parseInt(A_ISR_JA_1[5]) <= 20 || Integer.parseInt(A_ISR_JA_1[5]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,16,17,18,19,20,22 - PACIENTE CON DIAGNÓSTICO DE: ANSIEDAD, DEPRESIÓN, ESQUIZOFRENIA, DÉFICIT DE ATENCIÓN, CONSUMO SPA Y BIPOLARIDAD RECIBIÓ ATENCIÓN EN LOS ÚLTIMOS 6 MESES POR EQUIPO INTERDISCIPLINARIO COMPLETO ");
        }
        //VARIABLE 78
        if (validar_Fecha(A_ISR_JA_1[6]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - FECHA ANTÍGENO DE SUPERFICIE HEPATITIS B EN GESTANTES ");
        }
        //VARIABLE 79
        if (Integer.parseInt(A_ISR_JA_1[7]) >= 0 || Integer.parseInt(A_ISR_JA_1[7]) <= 2 || Integer.parseInt(A_ISR_JA_1[7]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,22 - RESULTADO ANTÍGENO DE SUPERFICIE HEPATITIS B EN GESTANTES");
        }
        //VARIABLE 80
        if (validar_Fecha(A_ISR_JA_1[8]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - SEROLOGÍA PARA SÍFILIS");
        }
        //VARIABLE 81
        if (Integer.parseInt(A_ISR_JA_1[9]) >= 0 || Integer.parseInt(A_ISR_JA_1[9]) <= 2 || Integer.parseInt(A_ISR_JA_1[9]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,22 - RESULTADO SEROLOGÍA PARA SÍFILIS");
        }

        System.out.println("Actividad_I_S_R_JA_1");
    }
    /*
     Actividad_I_S_R_JA_2
     * Esta funcion validad las variables 82 hasta 92, actividad de  intervencion segun el riesgo de los paciente (VIH,TSH,CANCER,COLPOSCOPIA)
     *Los Datos
     *FECHA DE TOMA DE ELISA PARA VIH, RESULTADO ELISA PARA VIH	FECHA TSH NEONATAL, RESULTADO TSH NEONATAL, TAMIZAJE CANCER DE CUELLO UTERINO,
     * CITOLOGIA CERVICO UTERINA, CITOLOGIA CERVICOUTERINA RESULTADOS SEGÚN BETHESDA, CALIDAD EN LA MUESTRA DE CITOLOGIA CERVICO UTERINA,
     * CODIGO DE HABILITACION IPS DONDE SE TOMA CITOLOGIA CERVICOUTERINA, FECHA COLPOSCOPIA, CODIGO HABILITACION DONDE SE TOMA COLPOSCOPIA
    
     */

    private void Actividad_I_S_R_JA_2(String txt) {
        String A_ISR_JA_2[] = txt.split("@");
        /*
         for (int h = 0; h < A_ISR_JA_2.length; h++) {
         System.out.println(A_ISR_JA_2[h] + " - " + (h + 82));
         }
         */
        //VARIABLE 82
        if (validar_Fecha(A_ISR_JA_2[0]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - TOMA DE ELISA PARA VIH ");
        }
        //VARIABLE 83
        if (Integer.parseInt(A_ISR_JA_2[1]) >= 0 || Integer.parseInt(A_ISR_JA_2[1]) <= 2 || Integer.parseInt(A_ISR_JA_2[1]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,22 - RESULTADO ELISA PARA VIH ");
        }
        //VARIABLE 84
        if (validar_Fecha(A_ISR_JA_2[2]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - TSH NEONATAL");
        }
        //VARIABLE 85
        if (Integer.parseInt(A_ISR_JA_2[3]) >= 0 || Integer.parseInt(A_ISR_JA_2[3]) <= 2 || Integer.parseInt(A_ISR_JA_2[3]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,22 - RESULTADO DE TSH NEONATAL");
        }
        //VARIABLE 86
        if (Integer.parseInt(A_ISR_JA_2[4]) >= 0 || Integer.parseInt(A_ISR_JA_2[4]) <= 3 || Integer.parseInt(A_ISR_JA_2[4]) >= 16 || Integer.parseInt(A_ISR_JA_2[4]) <= 20 || Integer.parseInt(A_ISR_JA_2[4]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,3,16,17,18,19,20,22 -  CÁNCER DE CUELLO UTERINO");
        }
        //VARIABLE 87
        if (validar_Fecha(A_ISR_JA_2[5]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - CERVICO UTERINA");
        }
        //VARIABLE 88
        if (Integer.parseInt(A_ISR_JA_2[6]) >= 0 || Integer.parseInt(A_ISR_JA_2[6]) <= 18 || Integer.parseInt(A_ISR_JA_2[6]) == 999) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,999 - CITOLOGÍA CERVICO UTERINA RESULTADOS SEGÚN BETHESDA");
        }
        //VARIABLE 89
        if (Integer.parseInt(A_ISR_JA_2[7]) >= 0 || Integer.parseInt(A_ISR_JA_2[7]) <= 4 || Integer.parseInt(A_ISR_JA_2[7]) == 999) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,3,4,999 - CALIDAD EN LA MUESTRA DE CITOLOGÍA CERVICOUTERINA");
        }
        //VARIABLE 90
        if (Entidad(A_ISR_JA_2[8]) == true || Integer.parseInt(A_ISR_JA_2[8]) == 0 || Integer.parseInt(A_ISR_JA_2[8]) == 999) {
        } else {
            System.out.println("NO SE ENCONTRO ENTIDAD EN LA TABLA REPS - CÓDIGO DE HABILITACIÓN IPS DONDE SE TOMA CITOLOGÍA CERVICOUTERINA");
        }
        //VARIABLE 91
        if (validar_Fecha(A_ISR_JA_2[9]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDA - COLPOSCOPIA");
        }
        //VARIABLE 92
        if (Entidad(A_ISR_JA_2[10]) == true || Integer.parseInt(A_ISR_JA_2[10]) == 0 || Integer.parseInt(A_ISR_JA_2[10]) == 999) {
        } else {
            System.out.println("NO SE ENCONTRO ENTIDAD EN LA TABLA REPS - CÓDIGO DE HABILITACIÓN IPS DONDE SE TOMA COLPOSCOPIA");
        }

        System.out.println("Actividad_I_S_R_JA_2");
    }

    /*
     Actividad_I_S_R_JA_3
     * Esta funcion validad las variables 93 hasta 104, actividad de  intervencion segun el riesgo de los paciente (BIOPSIA CERVICAL,MAMOGRAFIA, BIOPSIA SENO,HEMOGLOBINA)
     *Los Datos
     *FECHA DE BIOPSIA CERVICAL	RESULTADO DE BIOPSIA CERVICAL, CODIGO DE HABILITACION DONDE SE TOMA BIOPSIA CERVICAL, FECHA MAMOGRAFIA,
     * RESULTADO DE MAMOGRAFIA, CODIGO DE HABILITACION DONDE SE TOMA MOMOGRAFIA, FECHA TOMA DE BIOPSIA SENO POR BACAF, FECHA DE RESULTADO
     * BIOPSIA DE SENO,	RESULTADO BIOPSIA SENO,	CODIGO DE HABILITACION IPS DONDE SE TOMA BIOPSIA SENO, FECHA TOMA DE HEMOGLOBINA, HEMOGLOBINA

     */
    private void Actividad_I_S_R_JA_3(String txt) {
        String A_ISR_JA_3[] = txt.split("@");
        /*
         for (int h = 0; h < A_ISR_JA_3.length; h++) {
         System.out.println(A_ISR_JA_3[h] + " - " + (h + 93));
         }
         */
        //VARIABLE 93
        if (validar_Fecha(A_ISR_JA_3[0]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - BIOPSIA CERVICAL");
        }
        //VARIABLE 94
        if (Integer.parseInt(A_ISR_JA_3[1]) >= 0 || Integer.parseInt(A_ISR_JA_3[1]) <= 6 || Integer.parseInt(A_ISR_JA_3[1]) == 999) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,3,4,5,6,999 - RESULTADO DE BIOPSIA CERVICAL");
        }
        //VARIABLE 95 REVISAR "REPS"
        if (Entidad(A_ISR_JA_3[2]) == true || Integer.parseInt(A_ISR_JA_3[2]) == 0 || Integer.parseInt(A_ISR_JA_3[2]) == 999) {
        } else {
            System.out.println("NO SE ENCONTRO ENTIDAD EN LA TABLA REPS - CÓDIGO DE HABILITACIÓN IPS DONDE SE TOMA BIOPSIA CERVICAL");
        }
        //VARIABLE 96
        if (validar_Fecha(A_ISR_JA_3[3]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - MAMOGRAFIA");
        }
        //VARIABLE 97
        if (Integer.parseInt(A_ISR_JA_3[4]) >= 0 || Integer.parseInt(A_ISR_JA_3[4]) <= 7 || Integer.parseInt(A_ISR_JA_3[4]) == 999) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,3,4,5,6,7,999 -  RESULTADO MAMOGRAFIA");
        }
        //VARIABLE 98  REVISAR "REPS"
        if (Entidad(A_ISR_JA_3[5]) == true || Integer.parseInt(A_ISR_JA_3[5]) == 0 || Integer.parseInt(A_ISR_JA_3[5]) == 999) {
        } else {
            System.out.println("NO SE ENCONTRO ENTIDAD EN LA TABLA REPS - CÓDIGO DE HABILITACIÓN IPS DONDE SE TOMA MAMOGRAFÍA ");
        }
        //VARIABLE 99
        if (validar_Fecha(A_ISR_JA_3[6]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - TOMA BIOPSIA SENO POR BACAF");
        }
        //VARIABLE 100
        if (validar_Fecha(A_ISR_JA_3[7]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - RESULTADO BIOPSIA SENO ");
        }
        //VARIABLE 101
        if (Integer.parseInt(A_ISR_JA_3[8]) >= 0 || Integer.parseInt(A_ISR_JA_3[8]) <= 5 || Integer.parseInt(A_ISR_JA_3[8]) == 999) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,3,4,5,999 - RESULTADO BIOPSIA SENO ");
        }
        //VARIABLE 102 CODIGO REPS
        if (Entidad(A_ISR_JA_3[9]) == true || Integer.parseInt(A_ISR_JA_3[9]) == 0 || Integer.parseInt(A_ISR_JA_3[9]) == 999) {
        } else {
            System.out.println("NO SE ENCONTRO ENTIDAD EN LA TABLA REPS - CÓDIGO DE HABILITACIÓN IPS DONDE SE TOMA BIOPSIA SENO ");
        }
        //VARIABLE 103
        if (validar_Fecha(A_ISR_JA_3[10]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - TOMA DE HEMOGLOBINA ");
        }
        //VARIABLE 104
        if (Integer.parseInt(A_ISR_JA_3[11]) == 0 || A_ISR_JA_3[11].length() <= 4) {
        } else {
            System.out.println("DATO INCORRECTO - HEMOGLOBINA ");
        }
        System.out.println("Actividad_I_S_R_JA_3");
    }

    /*
     Actividad_I_S_R_JA_4
     * Esta funcion validad las variables 105 hasta 118, actividad de  intervencion segun el riesgo de los paciente (HEMOGLOBINA,HDL,BACILOSCOPIA,HIPOTIROIDISMO CONGENITO,SIFILIS GESTACIONAL,LEPRA)
     *Los Datos
     *FECHA DE LA TOMA DE GLICEMIA BASAL, FECHA DE CREATININA, CREATININA, FECHA DE HEMOGLOBINA GLICOSILADA, HEMOGLOBINA GLICOSILADA
     * FECHA DE TOMA DE MICROALBUMINURIA, FECHA DE TOMA DE HDL, FECHA TOMA DE BACILOSCOPIA DE DIAGNÓSTICO, BASILOSCOPIA DE DIAGNOSTICO
     * TRATAMIENTO PARA HIPOTIROIDISMO CONGENITO, TRATAMIENTO PARA SIFILIS GESTACIONAL,	TRATAMIENTO PARA SIFILIS CONGENITA,TRATAMIENTO PARA LEPRA
     * FECHA DE TERMINACION, TRATAMIENTO PARA LEISHMANIASIS

     */
    private void Actividad_I_S_R_JA_4(String txt) {
        String A_ISR_JA_4[] = txt.split("@");
        /*
         for (int h = 0; h < A_ISR_JA_4.length; h++) {
         System.out.println(A_ISR_JA_4[h] + " - " + (h + 105));
         }
         */
        //VARIABLE 105
        if (validar_Fecha(A_ISR_JA_4[0]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - TOMA DE GLICEMIA BASAL ");
        }
        //VARIABLE 106
        if (validar_Fecha(A_ISR_JA_4[1]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - CREATININA ");
        }
        //VARIABLE 107 
        if (Integer.parseInt(A_ISR_JA_4[2]) == 0 || Integer.parseInt(A_ISR_JA_4[2]) == 999 || Double.parseDouble(A_ISR_JA_4[2]) > 0) {
        } else {
            System.out.println("DATO INCORRECTO - CREATININA   ");
        }
        //VARIABLE 108
        if (validar_Fecha(A_ISR_JA_4[3]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - HEMOGLOBINA GLICOSILADA ");
        }
        //VARIABLE 109
        if (Integer.parseInt(A_ISR_JA_4[4]) == 0 || Integer.parseInt(A_ISR_JA_4[4]) == 999 || Double.parseDouble(A_ISR_JA_4[4]) > 0) {
        } else {
            System.out.println("DATO INCORRECTO  - HEMOGLOBINA GLICOSILADA");
        }
        //VARIABLE 110
        if (validar_Fecha(A_ISR_JA_4[5]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - TOMA DE MICROALBUMINURIA ");
        }
        //VARIABLE 111
        if (validar_Fecha(A_ISR_JA_4[6]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - TOMA DE HDL ");
        }
        //VARIABLE 112
        if (validar_Fecha(A_ISR_JA_4[7]) == true) {
        } else {
            System.out.println("FORMATO FECHA NO VALIDO - TOMA DE BACILOSCOPIA DE DIAGNÓSTICO");
        }
        //VARIABLE 113
        if (Integer.parseInt(A_ISR_JA_4[8]) >= 1 || Integer.parseInt(A_ISR_JA_4[8]) <= 4 || Integer.parseInt(A_ISR_JA_4[8]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 1,2,3,4,22 - BACILOSCOPIA DE DIAGNÓSTICO  ");
        }
        //VARIABLE 114 
        if (Integer.parseInt(A_ISR_JA_4[9]) >= 0 || Integer.parseInt(A_ISR_JA_4[9]) <= 2 || Integer.parseInt(A_ISR_JA_4[9]) >= 16 || Integer.parseInt(A_ISR_JA_4[9]) <= 20 || Integer.parseInt(A_ISR_JA_4[9]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,16,17,18,19,20,22 - TRATAMIENTO PARA HIPOTIROIDISMO CONGÉNITO");
        }
        //VARIABLE 115
        if (validar_Fecha(A_ISR_JA_4[10]) == true) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,16,17,18,19,20,22 -  TRATAMIENTO PARA SÍFILIS GESTACIONAL");
        }
        //VARIABLE 116
        if (Integer.parseInt(A_ISR_JA_4[11]) >= 0 || Integer.parseInt(A_ISR_JA_4[11]) <= 2 || Integer.parseInt(A_ISR_JA_4[11]) >= 16 || Integer.parseInt(A_ISR_JA_4[11]) <= 20 || Integer.parseInt(A_ISR_JA_4[11]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,16,17,18,19,20,22 - TRATAMIENTO PARA SÍFILIS CONGÉNITA");
        }
        //VARIABLE 117
        if (Integer.parseInt(A_ISR_JA_4[12]) >= 0 || Integer.parseInt(A_ISR_JA_4[12]) <= 2 || Integer.parseInt(A_ISR_JA_4[12]) >= 16 || Integer.parseInt(A_ISR_JA_4[12]) <= 20 || Integer.parseInt(A_ISR_JA_4[12]) == 22) {
        } else {
            System.out.println("DATO INCORRECTO DATOS PERMITIDOS 0,1,2,16,17,18,19,20,22 - TRATAMIENTO PARA LEPRA ");
        }
        //VARIABLE 118
        if (validar_Fecha(A_ISR_JA_4[13]) == true) {
        } else {
            System.out.println("FORMARTO FECHA NO VALIDAD - TERMINACIÓN TRATAMIENTO PARA LEISHMANIASIS");
        }
        System.out.println("Actividad_I_S_R_JA_3");
    }

    private void Control_Registro(String txt) {

        /*Control Registro*/
        String[] Matrix;
        int i = 0;
        StringTokenizer tokens = new StringTokenizer(txt, "|");
        int nDatos = tokens.countTokens();
        Matrix = new String[nDatos];
        while (tokens.hasMoreTokens()) {
            Matrix[i] = tokens.nextToken();
            //VARIABLE 1
            if (i == 0) {
                if (Integer.parseInt(Matrix[i]) == 1) {
                    // System.out.println(" VALIDO VAR 0 ");
                } else {
                    System.out.println("NO VALIDO VAR 0");
                }
            }
            //VARIABLE 2
            if (i == 1) {
                boolean enti = false;

                for (int j = 0; j < entidades.length; j++) {
                    if (Matrix[i].equals(entidades[j])) {
                        enti = true;
                    }
                }

                if (enti == true) {
                    // System.out.println("VALIDO VAR 1");
                } else {
                    System.out.println("NO VALIDO VAR 1-ENTIDAD");
                }
            }
            //VARIABLE 3
            if (i == 2) {
                if (validar_Fecha(Matrix[i]) == true) {
                    boolean a = false, m = false, d = false;
                    String fecha_inicio[] = Matrix[i].split("-");
                    if (Integer.parseInt(fecha_inicio[0]) > 2012) {
                        a = true;
                    } else {
                        System.out.println("NO VALIDO AÑO NO PERMITIDA VAR 2");
                    }
                    if ((Integer.parseInt(fecha_inicio[1]) == 1 && Integer.parseInt(fecha_inicio[2]) == 1) || (Integer.parseInt(fecha_inicio[1]) == 4 && Integer.parseInt(fecha_inicio[2]) == 1) || (Integer.parseInt(fecha_inicio[1]) == 7 && Integer.parseInt(fecha_inicio[2]) == 1) || (Integer.parseInt(fecha_inicio[1]) == 10 && Integer.parseInt(fecha_inicio[2]) == 1)) {
                        a = true;
                    } else {
                        System.out.println("NO VALIDO MES Y DIA NO PERMITIDA VAR 2");
                    }

                } else {
                    System.out.println("FECHA NO PERMITIDA");
                }
            }
            //VARIABLE 4
            if (i == 3) {
                if (validar_Fecha(Matrix[i]) == true) {
                    boolean a = false, m = false, d = false;
                    String fecha_inicio[] = Matrix[i].split("-");
                    if (Integer.parseInt(fecha_inicio[0]) > 2012) {
                        a = true;
                    } else {
                        System.out.println("NO VALIDO AÑO NO PERMITIDA VAR 3");
                    }
                    if (Integer.parseInt(fecha_inicio[1]) == 3 && Integer.parseInt(fecha_inicio[2]) == 31 || Integer.parseInt(fecha_inicio[1]) == 6 && Integer.parseInt(fecha_inicio[2]) == 30 || Integer.parseInt(fecha_inicio[1]) == 9 && Integer.parseInt(fecha_inicio[2]) == 30 || Integer.parseInt(fecha_inicio[1]) == 12 && Integer.parseInt(fecha_inicio[2]) == 31) {
                        a = true;
                    } else {
                        System.out.println("NO VALIDO AÑO NO PERMITIDA VAR 3");
                    }

                } else {
                    System.out.println("NO VALIDO FECHA NO PERMITIDA VAR 3");
                }
            }
            //VARIABLE 5
            if (i == 4) {
                if (Integer.parseInt(Matrix[i]) > 0) {
                } else {
                    System.out.println("NO VALIDO NO TIENE CAMPOS VAR 4");
                }
            }

            i++;
            if (nDatos == i) {
                posicionY++;
            }
        }
        /*for (int j = 0; j < i; j++) {
         System.out.println(Matriz[j] + " * " + posicionY + " * " + nDatos);
         }*/

    }

    private void Validador_4505(String txt) {
        String[] Matrix;
        String Inf_personal = "";
        String Iden_riesgo = "";
        String Act_ISR_1 = "";
        String Act_ISR_2 = "";
        String Act_ISR_3 = "";
        String Act_ISR_4 = "";
        String Act_ISR_5 = "";
        String Act_ISR_6 = "";
        String Act_ISR_7 = "";
        String Act_ISR_8 = "";
        int i = 0;
        StringTokenizer tokens = new StringTokenizer(txt, "|");
        int nDatos = tokens.countTokens();
        Matrix = new String[nDatos];
        while (tokens.hasMoreTokens()) {

            for (int j = 0; j < 14; j++) {
                Matrix[i] = tokens.nextToken();
                Inf_personal += Matrix[i] + "@";
                i++;
            }
            if (i == 14) {
                Informacion_personal(Inf_personal);
            }
            for (int j = 14; j < 29; j++) {
                Matrix[i] = tokens.nextToken();
                Iden_riesgo += Matrix[i] + "@";
                i++;

            }
            if (i == 29) {
                Identificacion_riesgo(Iden_riesgo);
            }
            for (int j = 29; j < 35; j++) {
                Matrix[i] = tokens.nextToken();
                Act_ISR_1 += Matrix[i] + "@";
                i++;

            }
            if (i == 35) {
                Actividad_I_S_R_CNP(Act_ISR_1);
            }
            for (int j = 35; j < 48; j++) {
                Matrix[i] = tokens.nextToken();
                Act_ISR_2 += Matrix[i] + "@";
                i++;

            }
            if (i == 48) {
                Actividad_I_S_R_VACUNACION(Act_ISR_2);
            }
            for (int j = 48; j < 62; j++) {
                Matrix[i] = tokens.nextToken();
                Act_ISR_3 += Matrix[i] + "@";
                i++;

            }
            if (i == 62) {
                Actividad_I_S_R_SPP(Act_ISR_3);
            }
            for (int j = 62; j < 72; j++) {
                Matrix[i] = tokens.nextToken();
                Act_ISR_4 += Matrix[i] + "@";
                i++;

            }
            if (i == 72) {
                Actividad_I_S_R_AMCD(Act_ISR_4);
            }
            for (int j = 72; j < 82; j++) {
                Matrix[i] = tokens.nextToken();
                Act_ISR_5 += Matrix[i] + "@";
                i++;
            }
            if (i == 82) {
                Actividad_I_S_R_JA_1(Act_ISR_5);
            }
            for (int j = 82; j < 93; j++) {
                Matrix[i] = tokens.nextToken();
                Act_ISR_6 += Matrix[i] + "@";
                i++;

            }
            if (i == 93) {
                Actividad_I_S_R_JA_2(Act_ISR_6);
            }
            for (int j = 93; j < 105; j++) {
                Matrix[i] = tokens.nextToken();
                Act_ISR_7 += Matrix[i] + "@";
                i++;

            }
            if (i == 105) {
                Actividad_I_S_R_JA_3(Act_ISR_7);
            }
            for (int j = 105; j < 119; j++) {
                Matrix[i] = tokens.nextToken();
                Act_ISR_8 += Matrix[i] + "@";
                i++;

            }
            if (i == 119) {
                Actividad_I_S_R_JA_4(Act_ISR_8);
            }

        }

    }

    private boolean validar_Fecha(String fecha) {
        if (fecha == null) {
            return false;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //año-mes-dia  

        if (fecha.trim().length() != dateFormat.toPattern().length()) {
            return false;
        }

        dateFormat.setLenient(false);

        try {
            dateFormat.parse(fecha.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    private boolean validar_F(String fecha) {
        if (fecha == null) {
            return false;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd"); //año-mes-dia  

        if (fecha.trim().length() != dateFormat.toPattern().length()) {
            return false;
        }

        dateFormat.setLenient(false);

        try {
            dateFormat.parse(fecha.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    private String sexo(String Sexo) {
        String genero = Sexo;
        return genero;
    }

    public void Recorer(String txt) {

        int i = 0, pos = 0;
        StringTokenizer tokens = new StringTokenizer(txt, "|"); // Separa tokens de la fila
        int nDatos = tokens.countTokens(); // Numero de tokens

        if (nDatos == 5) {
            //Control_Registro(txt);
            posicionY++;
        } else if (nDatos == 119) {
            Validador_4505(txt);
            posicionY++;
        }

        /* for (int j = 0; j < i; j++) {
         System.out.println(Matriz[j] + " * " + posicionY + " * " + nDatos);
         }*/
    }

    public void Mostrar(String Vetor[]) {
    }
}
