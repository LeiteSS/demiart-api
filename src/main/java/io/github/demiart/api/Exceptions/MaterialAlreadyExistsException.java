package io.github.demiart.api.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MaterialAlreadyExistsException extends Exception
{
    public MaterialAlreadyExistsException(String materialName)
    {
        super(String.format("O Material %s já existe.", materialName));
    }
}
