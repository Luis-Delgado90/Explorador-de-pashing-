/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisispishing;
import java.io.*;
import java.util.*;

/**
 *
 * @author User
 */
public class AnalisisPishing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String, Integer> lista = new HashMap<>();
        lista.put("¡Necesito ayuda urgente!", 3);
        lista.put("Actividad sospechosa de Outlook", 2);
        lista.put("¡Importante! Su contraseña está a punto de expirar", 3);
        lista.put("Acción requerida", 2);
        lista.put("Se ha identificado una vulnerabilidad", 2);
        lista.put("Oferta exclusiva", 2);
        lista.put("Promocion", 2);
        lista.put("Banco", 3);
        lista.put("confirme la transferencia", 3);
        lista.put("¿Ha sido usted?", 2);
        lista.put("movimiento extraño en su cuenta bancaria", 3);
        lista.put("urgente", 3);
        lista.put("Contraseña expirada", 3);
        lista.put("Actividad sospechosa", 3);
        lista.put("Urgente: accione de inmediato", 3);
        lista.put("oferta", 2);
        lista.put("ganador", 1);
        lista.put("urgente", 2);
        lista.put("Se requiere un cambio de contraseña inmediatamente", 2);
        lista.put("Verificación de cuenta", 3);
        lista.put("Contraseña expirada", 2);
        lista.put("Actividad sospechosa", 2);
        lista.put("Urgente: accione de inmediato", 3);
        lista.put("Actualice sus datos", 3);
        lista.put("Inicie sesión para evitar el bloqueo", 3);
        lista.put("Facebook", 3);
        lista.put("Gmail", 3);
        lista.put("Instagram", 3);
        
        String texto = "C:/Users/User/Documents/NetBeansProjects/AnalisisPishing/src/analisispishing/lista.txt";
        int totalPuntos = 0;
        Map<String, Integer> ocurrencias = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(texto))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                for (Map.Entry<String, Integer> entry : lista.entrySet()) {
                    String palabraClave = entry.getKey();
                    int puntos = entry.getValue();

                    int ocurrenciasEnLinea = contador(linea, palabraClave);
                    if (ocurrenciasEnLinea > 0) {
                        totalPuntos += ocurrenciasEnLinea * puntos;
                        ocurrencias.put(palabraClave, ocurrenciasEnLinea);
                        System.out.println("Palabra clave: " + palabraClave + ", Ocurrencias: " + ocurrenciasEnLinea +", Puntos: " + ocurrenciasEnLinea * puntos);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total de puntos: " + totalPuntos);
    
    }
    
}
