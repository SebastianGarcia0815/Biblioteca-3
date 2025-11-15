import javax.swing.*;
import java.awt.*;

/**
 * Ventana que solicita al usuario aceptar los términos y condiciones.
 * Habilita el botón "Continuar" solo si el usuario marca el checkbox.
 */
public class Licencia extends JFrame {

    private JCheckBox check;
    private JButton continuar, noAceptar;

    public Licencia() {
        setTitle("Licencia");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ---------------- PANEL PRINCIPAL ----------------
        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 248, 255));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Título
        JLabel titulo = new JLabel("Términos y Condiciones");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titulo.setAlignmentX(CENTER_ALIGNMENT);

        // Checkbox con el nombre del usuario obtenido de Bienvenida
        check = new JCheckBox("Yo " + Bienvenida.texto + " acepto los términos");
        check.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        check.setBackground(new Color(240, 248, 255));
        check.setAlignmentX(CENTER_ALIGNMENT);

        // Botón Continuar (deshabilitado hasta que acepte)
        continuar = new JButton("Continuar");
        continuar.setEnabled(false);
        continuar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        continuar.setBackground(new Color(60, 179, 113));
        continuar.setForeground(Color.WHITE);

        // Botón No Acepto (solo habilitado si NO acepta)
        noAceptar = new JButton("No acepto");
        noAceptar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        noAceptar.setBackground(new Color(220, 20, 60));
        noAceptar.setForeground(Color.WHITE);

        // Evento al marcar o desmarcar el checkbox
        check.addChangeListener(e -> {
            boolean ok = check.isSelected();

            // Activa Continuar solo si acepta los términos
            continuar.setEnabled(ok);

            // Desactiva "No acepto" si aceptó todo
            noAceptar.setEnabled(!ok);
        });

        // Acción del botón Continuar
        continuar.addActionListener(e -> {
            new Principal().setVisible(true);
            dispose();
        });

        // Acción del botón No Acepto
        noAceptar.addActionListener(e -> {
            new Bienvenida().setVisible(true);
            dispose();
        });

        // Agregar componentes
        panel.add(Box.createVerticalStrut(15));
        panel.add(titulo);
        panel.add(Box.createVerticalStrut(20));
        panel.add(check);
        panel.add(Box.createVerticalStrut(20));
        panel.add(continuar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(noAceptar);

        add(panel, BorderLayout.CENTER);

        // ---------------- PANEL INFERIOR (SALIR) ----------------
        JButton salir = new JButton("Salir");
        salir.addActionListener(e -> System.exit(0));

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footer.setBackground(new Color(240, 248, 255));
        footer.add(salir);

        add(footer, BorderLayout.SOUTH);
    }
}
