package api.hellfishg.monsterhunter.monsterhunter.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestControllerAdvice
@Tag(name = "GlobalExceptionHandler", description = "Maneja automaticamente todas las excepciones de los controladores")
public class GlobalExceptionHandler {

    @Operation(summary = "Maneja las excepciones de forma general")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Error general controladores", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json"))
    })
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Error inesperado");
        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Operation(summary = "Maneja las excepciones de conexión a la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Error interno en la base de datos", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json"))
    })
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<?> handleDatabaseConnectionException(DataAccessException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Error inesperado");
        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<>("Error en la coneccion de base de datos:\n" + ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @ExceptionHandler(MonsterNotFoundException.class)
     *                                                   public
     *                                                   ResponseEntity<Object>
     *                                                   handleMonsterNotFoundException(MonsterNotFoundException
     *                                                   ex) {
     *                                                   Map<String, Object> body =
     *                                                   new LinkedHashMap<>();
     *                                                   body.put("timestamp",
     *                                                   LocalDateTime.now());
     *                                                   body.put("error", "Not
     *                                                   Found");
     *                                                   body.put("message",
     *                                                   ex.getMessage());
     *                                                   body.put("status",
     *                                                   HttpStatus.NOT_FOUND.value());
     * 
     *                                                   return new
     *                                                   ResponseEntity<>(body,
     *                                                   HttpStatus.NOT_FOUND);
     *                                                   }
     * 
     *                                                   // Puedes agregar más
     *                                                   métodos para otras
     *                                                   excepciones aquí.
     */
}
