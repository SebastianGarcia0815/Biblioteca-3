import javax.swing.*;
import java.awt.*;

/**
 * Ventana final que muestra un mensaje personalizado
 * utilizando el nombre ingresado en la ventana Bienvenida.
 */
public class Principal extends JFrame {

    public Principal() {
        setTitle("Principal");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ---------------- PANEL DE CONTENIDO ----------------
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(245, 255, 250));

        // Mensaje personalizado
        JLabel mensaje = new JLabel("Bienvenido, " + Bienvenida.texto,
                                    SwingConstants.CENTER);
        mensaje.setFont(new Font("Segoe UI", Font.BOLD, 22));

        panel.add(mensaje, BorderLayout.CENTER);

        add(panel, BorderLayout.CENTER);

        // ---------------- PANEL INFERIOR (SALIR) ----------------
        JButton salir = new JButton("Salir");
        salir.addActionListener(e -> System.exit(0));

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footer.setBackground(new Color(245, 255, 250));
        footer.add(salir);

        add(footer, BorderLayout.SOUTH);
    }
}
