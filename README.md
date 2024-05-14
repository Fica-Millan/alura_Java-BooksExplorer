# Book Explorer
Este es un proyecto desarrollado como parte del curso de Java, enfocado en trabajar con lambdas, streams y el framework Spring.

## Descripción
Book Explorer es una aplicación de línea de comandos que interactúa con la API de [Gutendex](https://gutendex.com/?ref=public_apis) para explorar libros. Permite realizar varias acciones como mostrar los libros más descargados, obtener estadísticas sobre las descargas y buscar libros por nombre en español.

## Características
* Muestra los 10 libros más descargados.
* Proporciona estadísticas personalizadas sobre las descargas.
* Permite buscar libros por nombre en español.

![BusquedaLibro](https://github.com/Fica-Millan/alura_Java-BooksExplorer/blob/main/img/BusquedaLibro.png)
![Top10](https://github.com/Fica-Millan/alura_Java-BooksExplorer/blob/main/img/Top10_Estadisticas.png)

## Tecnologías Utilizadas
* Java
* Spring Framework
* Jackson (para deserialización de datos)

## Uso
Para ejecutar la aplicación, simplemente sigue estos pasos:

1. Clona el repositorio a tu máquina local.
2. Abre el proyecto en tu IDE favorito.
3. Ejecuta la clase BookexplorerApplication.

## Ejemplo de Uso

El fragmento de código que se muestra a continuación se encarga de imprimir los títulos de 
los 10 libros más descargados. 

* Utiliza el concepto de `streams` de Java para procesar la lista de resultados de libros 
obtenidos previamente.

1. Se ordena los libros por número de descargas utilizando el metodo `.sorted`de forma 
descendente, a travez del `.reversed`. 
2. Se limita la salida a los primeros 10 libros por medio de `.limit`. 
3. Se transforma cada título a mayúsculas con `.toUpperCase` 
4. Finalmente imprime cada título en la consola utilizando un `.forEach`. 

Este proceso proporciona una manera concisa y eficiente de mostrar los libros más populares 
en la aplicación.

```java
// Mostrar los 10 libros más descargados
System.out.println("\n\n>> TOP 10 - Los libros más descargados <<");
datos.resultados().stream()
        .sorted(Comparator.comparing(DatosLibros::numeroDescargas).reversed())
        .limit(10)
        .map(l -> l.titulo().toUpperCase())
        .forEach(System.out::println);
```


## Contribución
Si deseas contribuir a este proyecto, ¡eres bienvenido! Puedes enviar pull requests con mejoras o correcciones.

## Agradecimientos
Agradezco al **Programa ONE** de [Alura Latam](https://www.linkedin.com/company/alura-latam/) y [Oracle](https://www.linkedin.com/company/oracle/) por proporcionar el material y el contexto para desarrollar este proyecto.

## Autor
Este proyecto fue creado por [Fica](https://github.com/Fica-Millan).

¡Siéntete libre de contactarme si tienes alguna pregunta o sugerencia!

[LinkedIn](https://www.linkedin.com/in/yesica-fica-millan/)
