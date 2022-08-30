# Clases genéricas o parametrizadas

---

## Descripción

Las clases genéricas son clases que permiten definirse en términos de un conjunto de parámetros de tipo formal, esto es, declarar o usar objetos de tipos no específicos para variables, parámetros de métodos y valores de retorno dentro de la definición de una clase.

Puedes consultar más información [aquí](https://e-hello-blog.netlify.app/estructuras-datos/clases-genericas-tda)

## Sobre las clases

* **ContenedorEntero**. Representación de un contenedor de enteros.
* **ContenedorString**. Representación de un contenedor de cadenas.
* **ContenedorObject**. Representación de un contenedor de elementos de tipos Object.
* **ContenedorGenerico**. Representación de un contenedor de tipos de datos genéricos.

## Compilar y ejecutar

Para compilar cada una de las clases se utilizan los siguientes comandos

    javac ContenedorEntero.java
    javac ContenedorString.java
    javac ContenedorObject.java
    javac ContenedorGenerico.java

También se pueden compilar todas las clases al mismo tiempo con el comando

    javac *.java

Para ejecutar el método main, se utilizan los siguientes comandos, dependiento del main que se quiera ejecutar.

    java ContenedorEntero
    java ContenedorString
    java ContenedorObject
    java ContenedorGenerico
