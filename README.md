# archisaurus

## Construcción de la imagen

Construir la aplicación web utilizando maven y posteriormente generar la imagen Docker la cual iniciará la aplicación en un servidor tomcat accesible en el puerto 18080

```
  mvn clean install -Dmaven.test.skip=true 
  docker build -t archisaurus . 
```

## Ejecución

Es posible iniciar el proyecto de las siguientes maneras

* Con Docker Compose
```
  docker-compose -f stack.yml up
```

* Con Docker Stack
```
  docker stack deploy -c stack.yml archisaurus
```
