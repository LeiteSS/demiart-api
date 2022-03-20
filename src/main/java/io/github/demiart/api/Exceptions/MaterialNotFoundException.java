package io.github.demiart.api.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MaterialNotFoundException extends Exception
{
    public MaterialNotFoundException(String materialName)
    {
        super(String.format("O Material %s não foi encontrado.", materialName));
    }

    public MaterialNotFoundException(Long id)
    {
        super(String.format("O material de numero %s não foi encontrado", id));
    }
}
