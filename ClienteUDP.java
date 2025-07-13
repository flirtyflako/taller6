import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese su identificador (ej. Cliente01): ");
            String clienteId = scanner.nextLine();

            InetAddress servidor = InetAddress.getByName("localhost");
            int puerto = 9876;

            for (int i = 1; i <= 5; i++) {
                String mensaje = clienteId + " - Mensaje " + i;
                byte[] buffer = mensaje.getBytes();

                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, servidor, puerto);
                socket.send(paquete);

                System.out.println("Enviado: " + mensaje);
                Thread.sleep(2000);
            }

            // Opcional: enviar mensaje de cierre
            if (clienteId.equalsIgnoreCase("Cliente01")) {
                String fin = "FIN";
                byte[] buffer = fin.getBytes();
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, servidor, puerto);
                socket.send(paquete);
                System.out.println("Mensaje de cierre enviado.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
