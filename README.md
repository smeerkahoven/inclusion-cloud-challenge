## inclusion-cloud-challenge
El siguiente proyecto resuelve la Prueba Tecnica de Inclusion Cloud Challenge
la cual puede encontrarse en el siguiente [enlace](https://codeforces.com/problemset/problem/1374/A).

## Instruciones

Para hacer uso del proyecto se debe descargar el codigo a la maquina local 
y ejecutar el comando build de gradle dentro de la carpeta del codigo

```sh
./gradlew build
```

una vez compilado se debe ejecutar desde consola


```sh
./gradlew bootRun
```

para que la aplicacion corra en modo standalone/web.

## Standalone

La aplicacion leerá desde 
```sh
resources/filename.txt
```

un caso de prueba 

## Web

Al momento de ejecutar el bootRun, la aplicacion tambien acepta peticiones http. Existen 2 endpoints 

### Get

```sh
localhost:8080/challenge/maximum?x={valor}&y={valor}&n={valor}
```


### Post

```sh
localhost:8080/challenge/maximum
```

donde el body debe contener la siguiente estructura


```sh
{
  "x": 7,
  "y": 5,
  "n": 12345
}

```

En caso de éxito la aplicacion retornará un json

```sh
{
    "result": 12339
}

```
mostrando el resultado del cálculo