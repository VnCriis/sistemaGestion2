import javax.swing.*;

public class Main {
    static JFrame ventana = new JFrame();
    public static void main(String [] args){
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setContentPane(new login().loginJPanel);
        ventana.pack();
        ventana.setSize(840,700);
        ventana.setVisible(true);
    }
}