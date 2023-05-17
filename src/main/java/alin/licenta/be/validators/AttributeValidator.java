package alin.licenta.be.validators;

import alin.licenta.be.dto.AttributeDTO;
import alin.licenta.be.exceptions.IllegalInputException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class AttributeValidator {

    private final MessageSource messageSource;

    public void validate(AttributeDTO attributeDTO) throws IllegalInputException {
        if (attributeDTO.getName() == null) {
            throw new IllegalInputException(messageSource.getMessage("validator.error.name.null", null, Locale.ENGLISH));
        }
    }
}
