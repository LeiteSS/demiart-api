package io.github.demiart.api.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DisciplineAlreadyExistsException extends Exception
{
    public DisciplineAlreadyExistsException(String disciplineName)
    {
        super(String.format("A discipline %s já existe.", disciplineName));
    }
}
