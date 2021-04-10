# programacion2-Workshop3
### Ejecutar cada paquete por separado. 
- Ejecutar la aplicación "server" una sola vez le aparecera una dirección ip como primer mensaje, copiela.
- En la carpeta agent ir a /src/model/agent.java y en el atributo serverAddress poner la ip que copio cuando ejecuto el server, hacer lo mismo para la carpeta cliente: /src/model/client.java en el atributo serverAddress.
1. Requerimiento 3:
- Para reportar varios casos, es necesario ejecutar el cliente (aplicación "client") más de una vez (puede ser en el mismo pc).
- Los casos reportados se guardan en una carpeta data, dentro de la aplicación (carpeta) "server".
2. Requerimiento 4:
- Para soportar chat entre varios clientes y agentes, se debe ejecutar en un pc distinto (que tengan distinta ip). Esto quiere decir, que para que hayan varios agentes, se debe ejecutar la aplicación "agent" en distinta ip al igual que la aplicación "client" (el funcionamiento del chat es distinto al de registro de casos, por esto los cliente si deben estar con ips distintas). 
