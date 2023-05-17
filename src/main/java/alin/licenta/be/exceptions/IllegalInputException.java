package alin.licenta.be.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IllegalInputException extends IllegalArgumentException {

    public IllegalInputException(String message) {
        super(message);
    }
}
