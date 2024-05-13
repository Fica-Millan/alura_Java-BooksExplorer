package com.aluracursos.bookexplorer.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") String fechaDeNacimiento
) {

    @Override
    public String toString() {
        return "Nombre: " + nombre + "- Fecha de nacimiento: " + fechaDeNacimiento;
    }

}
