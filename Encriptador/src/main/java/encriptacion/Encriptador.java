/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encriptacion;

import interfaz.IEncriptador;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Dell
 */
public class Encriptador implements IEncriptador {

    private static Encriptador instance;

    private static final long serialVersionUID = 5486865543976730876L;

    private static final String key = "08wR?!5!S6_WO&-v$f#0RUdrEfRoclTh";
    private static final String salt = "huwlzO@a&t8tr83$l6hiy#k+vl!0cr";

    private SecretKey secretKeyTemp;

    // Constructor privado para evitar instancias externas
    private Encriptador() {
        SecretKeyFactory secretKeyFactory;
        KeySpec keySpec;
        try {
            secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            keySpec = new PBEKeySpec(key.toCharArray(), salt.getBytes(), 65536, 256);
            secretKeyTemp = secretKeyFactory.generateSecret(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Método público y estático para obtener la única instancia
    public static Encriptador getInstance() {
        if (instance == null) {
            synchronized (Encriptador.class) { // Asegura la seguridad en entornos multihilo
                if (instance == null) {
                    instance = new Encriptador();
                }
            }
        }
        return instance;
    }

    /**
     * Encripta
     *
     * @param data
     * @return
     */
    private String getAES(String data) {
        byte[] iv = new byte[16];

        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            SecretKeySpec secretKey = new SecretKeySpec(secretKeyTemp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes("UTF-8")));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * Desencripta
     *
     * @param data
     * @return
     */
    private String getAESDecrypt(String data) {
        byte[] iv = new byte[16];
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            SecretKeySpec secretKey = new SecretKeySpec(secretKeyTemp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(data)));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String encriptar(String clave) {
        String nuevaClave = this.getAES(clave);
        return nuevaClave;
    }

    @Override
    public String desencriptar(String clave) {
        String nuevaClave = this.getAESDecrypt(clave);
        return nuevaClave;
    }
}
