package mirkoabozzi.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("Evento con id " + id + " non trovato");
    }
}
