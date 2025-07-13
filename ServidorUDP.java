import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServidorUDP {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(9876)) {
            System.out.println("Servidor UDP iniciado en puerto 9876...");
            byte[] buffer = new byte[1024];
            boolean activo = true;

            while (activo) {
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                socket.receive(paquete);

                String mensaje = new String(paquete.getData(), 0, paquete.getLength());
                String cliente = paquete.getAddress().getHostAddress() + ":" + paquete.getPort();
                String hora = new SimpleDateFormat("HH:mm:ss").format(new Date());

                System.out.println("[" + hora + "] Mensaje recibido de " + cliente + ": " + mensaje);

                if (mensaje.equalsIgnoreCase("FIN")) {
                    activo = false;
                    System.out.println("Servidor apagándose...");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
