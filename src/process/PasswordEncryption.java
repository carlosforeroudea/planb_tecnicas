
package process;

/**
 *
 * @author carlosforero
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryption {
    public static String encryptPassword(String password) {
        try {
            // Crear una instancia de MessageDigest con el algoritmo SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // Convertir la contraseña en bytes
            byte[] passwordBytes = password.getBytes();
            
            // Calcular el hash de la contraseña
            byte[] hashBytes = md.digest(passwordBytes);
            
            // Convertir el hash a una representación hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte hashByte : hashBytes) {
                sb.append(String.format("%02x", hashByte));
            }
            
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Manejo de excepción en caso de que no se encuentre el algoritmo
            e.printStackTrace();
            return null;
        }
    }

}

