/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package excepciones;

/**
 *
 * @author diana
 */


  public class BusinessException extends Exception{
    
    /**
     * Construye una nueva excepción de lógica de negocio sin mensaje de detalle.
     */
    public BusinessException() {
    }

    /**
     * Construye una nueva excepción de lógica de negocio con el detalle del mensaje especificado.
     * 
     * @param message el mensaje que detalla la excepción.
     */
    public BusinessException(String message) {
        super(message);
    }

    /**
     * Construye una nueva excepción de lógica de negocio con el mensaje de detalle y la causa raíz especificados.
     * 
     * @param message el mensaje que detalla la excepción.
     * @param cause la causa raíz de la excepción.
     */
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construye una nueva excepción de lógica de negocio con la causa raíz especificada y un mensaje de detalle
     * predeterminado.
     * 
     * @param cause la causa raíz de la excepción.
     */
    public BusinessException(Throwable cause) {
        super(cause);
    }

    /**
     * Construye una nueva excepción de lógica de negocio con el mensaje de detalle, la causa raíz, la supresión de la
     * pila de seguimiento habilitada o deshabilitada y la capacidad de la pila de seguimiento modificable especificados.
     * 
     * @param message el mensaje que detalla la excepción.
     * @param cause la causa raíz de la excepción.
     * @param enableSuppression indica si la supresión de la pila de seguimiento está habilitada o deshabilitada.
     * @param writableStackTrace indica si la pila de seguimiento es modificable o no.
     */
    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
   
}

