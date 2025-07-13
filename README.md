# Comunicación UDP con múltiples clientes en Java

## Descripción
Este proyecto implementa un sistema de comunicación basado en UDP donde múltiples clientes envían mensajes al servidor. El servidor escucha en un puerto específico, imprime los mensajes recibidos con información del remitente y la hora, y finaliza cuando recibe un mensaje especial ("FIN").

## Componentes
- **ServidorUDP.java**: Escucha en el puerto 9876 y muestra los mensajes entrantes.
- **ClienteUDP.java**: Solicita el identificador del usuario y envía 5 mensajes al servidor, con pausas de 2 segundos entre ellos.

## Evidencia de funcionamiento
Los mensajes enviados y recibidos son mostrados en consola, con hora y dirección IP de origen. Un cliente puede enviar el mensaje "FIN" para apagar el servidor.

## Tecnologías utilizadas
- `DatagramSocket`
- `DatagramPacket`
- `InetAddress`

## Cómo ejecutar
1. Ejecutar primero `ServidorUDP.java`
2. Ejecutar una o más veces `ClienteUDP.java` con distintos identificadores

## Autor
Tu Nombre - Proyecto para curso de Programación Concurrente en Java.
