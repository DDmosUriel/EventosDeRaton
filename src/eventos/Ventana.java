 
package eventos;
 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame{
    private JPanel panel;
    private JLabel saludo;
    private JTextField cajaTxt;
    private JButton btn;
    
    public Ventana(){
        setBounds(50, 50, 500, 500);
        setTitle("EVENTOS");
        
        iniciarComponentes();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
 private void iniciarComponentes(){
     colocarPanel();
     colocarEtiqueta();
     colocarCajaTexto();
     colocarBoton();
     
 }

  private void colocarPanel(){
      panel = new JPanel();
      panel.setLayout(null);
      //panel.setBounds(50, 50, 500, 500);
      this.add(panel);
  }
  private void colocarEtiqueta(){
      JLabel etiqueta = new JLabel("Ingrese su nombre ");
      etiqueta.setBounds(30, 10, 200, 30);
      etiqueta.setFont(new Font("cooper black",2,20));
      panel.add(etiqueta);
  }  
  private void colocarCajaTexto(){
      cajaTxt = new JTextField();
      cajaTxt.setBounds(30, 50, 300, 30);
      panel.add(cajaTxt);
  }
  private void colocarBoton(){
      btn = new JButton("pulse aqui");
      btn.setBounds(350,50,130,30);
      btn.setFont(new Font("arial",0,15));
      panel.add(btn);
      
      saludo = new JLabel();
      saludo.setBounds(50, 200, 300, 40);
      saludo.setFont(new Font("arial",1,20));
      panel.add(saludo);
  
  ActionListener oirAccion = new ActionListener(){
      
          public void action_Performed(ActionEvent ae){
            saludo.setText("Buen Día "+cajaTxt.getText());
            }
  };
        btn.addActionListener(oirAccion);
 }
}







