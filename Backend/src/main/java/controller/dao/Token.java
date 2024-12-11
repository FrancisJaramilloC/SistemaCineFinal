package controller.dao;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class Token {

    private static final String SECRET_KEY = "my_secret_key";  // Reemplaza por una clave segura desde variables de entorno

    /**
     * Genera un token JWT con un ID y correo del usuario.
     *
     * @param idPersona ID único de la persona.
     * @param correo Correo electrónico del usuario.
     * @return Token JWT.
     */
    public static String generateToken(Integer idPersona, String correo) {
        return Jwts.builder()
                .setSubject(correo)  // Correo como identificador principal
                .claim("idPersona", idPersona)  // Agrega información adicional al token
                .setIssuedAt(new Date())  // Fecha de emisión
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))  // 1 hora de expiración
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)  // Firma con algoritmo HS256
                .compact();
    }

    /**
     * Valida un token JWT.
     *
     * @param token Token a validar.
     * @return `true` si es válido, de lo contrario `false`.
     */
    public static boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token);  // Valida la firma del token
            return true;  // Token válido
        } catch (Exception e) {
            return false;  // Token inválido o expirado
        }
    }
}
