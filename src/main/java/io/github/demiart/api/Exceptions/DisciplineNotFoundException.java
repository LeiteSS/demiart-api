package io.github.demiart.api.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DisciplineNotFoundException extends Exception
{
    public DisciplineNotFoundException(String disciplineName)
    {
        super(String.format("A disciplina %s não foi encontrada.", disciplineName));
    }

    public DisciplineNotFoundException(Long id)
    {
        super(String.format("A disciplina de numero %s não foi encontrada.", id));
    }
}
