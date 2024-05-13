package com.aluracursos.bookexplorer.principal;

import com.aluracursos.bookexplorer.model.Datos;
import com.aluracursos.bookexplorer.model.DatosLibros;
import com.aluracursos.bookexplorer.service.ConsumoAPI;
import com.aluracursos.bookexplorer.service.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);

    public void muestraElMenu (){
        var json = consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);
        var datos = conversor.obtenerDatos(json,Datos.class);

        //TOP 10 - Los libros mas descargados
        System.out.println("\n\n>> TOP 10 - Los libros más descargados <<");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibros::numeroDescargas).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);

        //Datos Estadisticos
        DoubleSummaryStatistics est = datos.resultados().stream()
                .filter(d -> d.numeroDescargas() > 0)
                .collect(Collectors.summarizingDouble(DatosLibros::numeroDescargas));
        System.out.println("\n\n>> Datos Estadisticos de la API << ");
        System.out.println("Cantidad máxima de descargas: "+ est.getMax());
        System.out.println("Cantidad mínima de descragas: "+ est.getMin());
        System.out.println("Cantidad media de descargas: "+ est.getAverage());

        //Busqueda de libros por nombre
        System.out.println(("\n\n>> Busqueda de libros por nombre, en español <<"));
        System.out.println(("Ingrese el nombre del libro que desea encontrar:"));
        var tituloLibro = teclado.nextLine();
        json = consumoAPI.obtenerDatos(URL_BASE+"?search="+tituloLibro.replace(" ", "+")+"&languages=es");
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();

        if(libroBuscado.isPresent()){
            System.out.println("\nDATOS DEL LIBRO: ");
            System.out.println(libroBuscado.get());
        }else {
            System.out.println("\n- Libro no encontrado -");
        }
    }
}
