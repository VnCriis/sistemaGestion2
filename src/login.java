import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login {
    JPanel loginJPanel;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;

    public login() {
        this.textField1 = textField1;
        this.passwordField1 = passwordField1;
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField1.getText();
                int contraseña = Integer.parseInt(passwordField1.getText());
                String opcionSeleccionada = (String) comboBox1.getSelectedItem();
                if (opcionSeleccionada != null) {
                    Connection conexion = connection.obtenerConexion();
                    switch (opcionSeleccionada) {
                        case "Estudiante":
                            try {
                                String sql = "SELECT * FROM tutores WHERE usuario = ? AND contraseña = ?";
                                PreparedStatement statement = conexion.prepareStatement(sql);
                                statement.setString(1, nombre);
                                statement.setString(2, String.valueOf(contraseña));
                                ResultSet resultSet = statement.executeQuery();
                                if (resultSet.next()) {
                                    int idEstudiante = resultSet.getInt("id");
                                    String consulta = "SELECT * FROM listaestudiantes WHERE id_estudiante = ?";
                                    PreparedStatement statement1 = conexion.prepareStatement(consulta);
                                    statement1.setInt(1, idEstudiante);
                                    ResultSet resultSet1 = statement1.executeQuery();
                                    if (resultSet1.next()){
                                        Main.ventana.setContentPane(new estudiante().estudianteJPanel);
                                        Main.ventana.revalidate();
                                    }else {
                                        JOptionPane.showMessageDialog(null, "No se encontró información del estudiante en listaestudiantes");
                                    }
                                    resultSet1.close();
                                    statement1.close();
                                }else {
                                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
                                }
                            } catch (SQLException exception) {
                                JOptionPane.showMessageDialog(null, "Error al realizar la consulta SQL");
                                exception.printStackTrace();
                            }
                            break;
                        case "Tutor":
                            try {
                                String sql = "SELECT * FROM estudiantes WHERE usuario = ? AND contraseña = ?";
                                PreparedStatement statement = conexion.prepareStatement(sql);
                                statement.setString(1, nombre);
                                statement.setString(2, String.valueOf(contraseña));
                                ResultSet resultSet = statement.executeQuery();
                                if (resultSet.next()) {
                                    int idTutor = resultSet.getInt("id");
                                    String consulta = "SELECT * FROM listatutores WHERE id_tutor = ?";
                                    PreparedStatement statement1 = conexion.prepareStatement(consulta);
                                    statement1.setInt(1, idTutor);
                                    ResultSet resultSet1 = statement1.executeQuery();
                                    if (resultSet1.next()){
                                        Main.ventana.setContentPane(new tutor().tutorJPanel);
                                        Main.ventana.revalidate();
                                    }else {
                                        JOptionPane.showMessageDialog(null, "No se encontró información del estudiante en listaestudiantes");
                                    }
                                    resultSet1.close();
                                    statement1.close();
                                }else {
                                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
                                }
                            } catch (SQLException exception) {
                                JOptionPane.showMessageDialog(null, "Error al realizar la consulta SQL");
                                exception.printStackTrace();
                            }
                            break;
                    }
                }
            }

        });
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public void setPasswordField1(JPasswordField passwordField1) {
        this.passwordField1 = passwordField1;
    }

}
