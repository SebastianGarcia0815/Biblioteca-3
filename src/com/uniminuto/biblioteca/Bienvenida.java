import javax.swing.*;
import java.awt.*;

/**
 * Ventana inicial del programa.
 * Permite al usuario ingresar su nombre y pasar a la ventana de licencia.
 */
public class Bienvenida extends JFrame {

    // Variable estática usada para compartir el nombre del usuario entre ventanas
    public static String texto = "";

    private JTextField campoTexto;
    private JButton botonIngresar;

    public Bienvenida() {
        setTitle("Bienvenida");                             // Título de la ventana
        setSize(400, 220);                                   // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // Cerrar programa al cerrar ventana
        setLocationRelativeTo(null);                         // Centrar en pantalla
        setLayout(new BorderLayout());                       // Layout principal

        // ---------------- PANEL PRINCIPAL ----------------
        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 255));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Título
        JLabel titulo = new JLabel("¡Bienvenido!");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setAlignmentX(CENTER_ALIGNMENT);

        // Etiqueta de instrucción
        JLabel label = new JLabel("Ingresa tu nombre:");
        label.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        label.setAlignmentX(CENTER_ALIGNMENT);

        // Campo donde el usuario escribe su nombre
        campoTexto = new JTextField(15);
        campoTexto.setMaximumSize(new Dimension(200, 30));
        campoTexto.setAlignmentX(CENTER_ALIGNMENT);

        // Botón que continúa hacia la Licencia
        botonIngresar = new JButton("Ingresar");
        botonIngresar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        botonIngresar.setBackground(new Color(100, 149, 237));
        botonIngresar.setForeground(Color.WHITE);
        botonIngresar.setFocusPainted(false);
        botonIngresar.setAlignmentX(CENTER_ALIGNMENT);

        // Acción del botón Ingresar
        botonIngresar.addActionListener(e -> {
            // Guardamos el nombre ingresado
            texto = campoTexto.getText().trim();

            // Validación: no permitir nombre vacío
            if (texto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingresa tu nombre.");
                return;
            }

            // Avanzar a la ventana Licencia
            new Licencia().setVisible(true);
            dispose();  // Cierra esta ventana liberando recursos
        });

        // Permite usar Enter para ingresar
        getRootPane().setDefaultButton(botonIngresar);

        // Componentes del panel
        panel.add(Box.createVerticalStrut(15));
        panel.add(titulo);
        panel.add(Box.createVerticalStrut(15));
        panel.add(label);
        panel.add(campoTexto);
        panel.add(Box.createVerticalStrut(15));
        panel.add(botonIngresar);
        panel.add(Box.createVerticalStrut(10));

        add(panel, BorderLayout.CENTER);

        // ---------------- PANEL INFERIOR (SALIR) ----------------
        JButton salir = new JButton("Salir");
        salir.addActionListener(e -> System.exit(0));

        JPanel panelFooter = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelFooter.setBackground(new Color(245, 245, 255));
        panelFooter.add(salir);

        add(panelFooter, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        // Inicia la ventana de forma segura en el hilo de Swing
        SwingUtilities.invokeLater(() -> new Bienvenida().setVisible(true));
    }
}
