import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar destinatario principal
        System.out.print("Ingrese el destinatario principal: ");
        String destinatarioPrincipal = scanner.nextLine();

        // Solicitar asunto
        System.out.print("Ingrese el asunto del correo: ");
        String asunto = scanner.nextLine();

        // Solicitar cuerpo del correo
        System.out.print("Ingrese el cuerpo del correo: ");
        String cuerpo = scanner.nextLine();

        // Crear instancia del Builder con los campos obligatorios
        Email.EmailBuilder emailBuilder = new Email.EmailBuilder(destinatarioPrincipal, asunto, cuerpo);

        // Preguntar si se desea agregar más destinatarios
        System.out.print("¿Desea agregar más destinatarios? (s/n): ");
        String agregarDestinatarios = scanner.nextLine();

        while (agregarDestinatarios.equalsIgnoreCase("s")) {
            System.out.print("Ingrese otro destinatario: ");
            String destinatarioAdicional = scanner.nextLine();
            emailBuilder.withDestinatario(destinatarioAdicional);

            System.out.print("¿Desea agregar otro destinatario? (s/n): ");
            agregarDestinatarios = scanner.nextLine();
        }

        // Preguntar si se desea agregar adjuntos
        System.out.print("¿Desea agregar adjuntos? (s/n): ");
        String agregarAdjuntos = scanner.nextLine();

        while (agregarAdjuntos.equalsIgnoreCase("s")) {
            System.out.print("Ingrese el nombre del archivo adjunto: ");
            String adjunto = scanner.nextLine();
            emailBuilder.withAdjunto(adjunto);

            System.out.print("¿Desea agregar otro adjunto? (s/n): ");
            agregarAdjuntos = scanner.nextLine();
        }

        // Construir el Email
        Email email = emailBuilder.build();

        // Mostrar el correo construido
        System.out.println("\nCorreo electrónico construido:");
        System.out.println(email);
    }
}
