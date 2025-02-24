package com.cristian.jobsearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CLIKeywordValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        if(!value.matches("^[a-zA-Z0-9_-]+$")){
            System.err.println("El criterio de busqueda no es valido");
            throw new ParameterException("Unicamente letras y numeros");
        }
    }
}
