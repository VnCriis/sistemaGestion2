import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class estudiante {
    JPanel estudianteJPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton button1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;

    public estudiante(JTextField textField1, JTextField textField2, JTextField textField3, JTextField textField4) {
        this.textField1 = textField1;
        this.textField2 = textField2;
        this.textField3 = textField3;
        this.textField4 = textField4;
    }

    public estudiante() {

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(Main.ventana, "¿Está seguro que desea salir?", "Confirmar salida", JOptionPane.OK_CANCEL_OPTION);
                if (opcion == JOptionPane.OK_OPTION){
                    Main.ventana.setContentPane(new login().loginJPanel);
                    Main.ventana.revalidate();
                }
            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == radioButton1) {
                    Main.ventana.setContentPane(new estudiantePP().estudianteppJPanel);
                    Main.ventana.revalidate();
                } else if (e.getSource() == radioButton2) {
                    Main.ventana.setContentPane(new estudianteOV().estudianteovJPanel);
                    Main.ventana.revalidate();
                } else if (e.getSource() == radioButton3) {
                    Main.ventana.setContentPane(new estudianteMP().estudiantempJPanel);
                    Main.ventana.revalidate();
                }
            }
        };
        radioButton1.addActionListener(listener);
        radioButton2.addActionListener(listener);
        radioButton3.addActionListener(listener);
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public void setTextField2(JTextField textField2) {
        this.textField2 = textField2;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public void setTextField3(JTextField textField3) {
        this.textField3 = textField3;
    }

    public JTextField getTextField4() {
        return textField4;
    }

    public void setTextField4(JTextField textField4) {
        this.textField4 = textField4;
    }
}
