import java.util.ArrayList;
import java.util.List;

public class Email {
    private final List<String> destinatarios;  // Campo obligatorio
    private final String asunto;               // Campo obligatorio
    private final String cuerpo;               // Campo obligatorio
    private final List<String> adjuntos;       // Campo opcional

    // Constructor privado, solo accesible desde el builder
    private Email(EmailBuilder builder) {
        this.destinatarios = builder.destinatarios;
        this.asunto = builder.asunto;
        this.cuerpo = builder.cuerpo;
        this.adjuntos = builder.adjuntos;
    }

    // Getters
    public List<String> getDestinatarios() {
        return destinatarios;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public List<String> getAdjuntos() {
        return adjuntos;
    }

    // Clase Builder
    public static class EmailBuilder {
        private final List<String> destinatarios; // Campo obligatorio
        private final String asunto;              // Campo obligatorio
        private final String cuerpo;              // Campo obligatorio
        private List<String> adjuntos = new ArrayList<>(); // Campo opcional

        // Constructor del builder con los campos obligatorios
        public EmailBuilder(String destinatario, String asunto, String cuerpo) {
            this.destinatarios = new ArrayList<>();
            this.destinatarios.add(destinatario);
            this.asunto = asunto;
            this.cuerpo = cuerpo;
        }

        // Método para agregar más destinatarios
        public EmailBuilder withDestinatario(String destinatario) {
            this.destinatarios.add(destinatario);
            return this;
        }

        // Método para agregar adjuntos
        public EmailBuilder withAdjunto(String adjunto) {
            this.adjuntos.add(adjunto);
            return this;
        }

        // Método que construye y devuelve la instancia de Email
        public Email build() {
            return new Email(this);
        }
    }

    @Override
    public String toString() {
        return "Email{" +
                "destinatarios=" + destinatarios +
                ", asunto='" + asunto + '\'' +
                ", cuerpo='" + cuerpo + '\'' +
                ", adjuntos=" + adjuntos +
                '}';
    }
}

