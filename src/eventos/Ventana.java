 
package eventos;
 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Ventana extends JFrame{
    private JPanel panel;
    private JLabel saludo;
    private JTextField cajaTxt;
    private JButton btn;
    private JTextArea areaTexto;
    
    public Ventana(){
        setBounds(50, 50, 500, 500);
        setTitle("EVENTOS");
        
        iniciarComponentes();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
 private void iniciarComponentes(){
     colocarPanel();
     //colocarEtiqueta();
     //colocarCajaTexto();
     colocarBoton();
     
     colocarAreaTexto();
 }

  private void colocarPanel(){
      panel = new JPanel();
      panel.setLayout(null);
      //panel.setBounds(50, 50, 500, 500);
      this.add(panel);
      
      eventoMovimientoRaton();
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
//      JScrollPane scroll = new JScrollPane(cajaTxt,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//      scroll.setBounds(30, 50, 300, 30);
//      
//      panel.add(scroll);
      panel.add(cajaTxt);
  }
  private void colocarAreaTexto(){
      areaTexto = new JTextArea();  
      areaTexto.setBounds(20, 20, 200, 300);
      areaTexto.setFont(new Font("arial",0,15));
      panel.add(areaTexto);
      
      JScrollPane scroll = new JScrollPane(areaTexto,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scroll.setBounds(20, 20, 200, 300);
      panel.add(scroll);
      
  }
  private void colocarBoton(){
      btn = new JButton("pulse aqui");
      btn.setBounds(150,350,150,40);
      btn.setFont(new Font("arial",0,15));
      panel.add(btn);
      //eventoOyenteRaton();
     // eventoOyenteDeAccion();
//      saludo = new JLabel();
//      saludo.setBounds(50, 200, 300, 40);
//      saludo.setFont(new Font("arial",1,20));
//      panel.add(saludo);
  }
  private void eventoOyenteDeAccion(){
       ActionListener oirAccion = new ActionListener(){
      
          @Override
          public void actionPerformed(ActionEvent ae){
            saludo.setText("Buen Día "+cajaTxt.getText());
            }
        };
        btn.addActionListener(oirAccion);
  }
  private void eventoOyenteRaton(){
      MouseListener oyenteRaton = new MouseListener(){
          @Override
          public void mouseClicked(MouseEvent e) {
              if(e.isAltDown()){
                  areaTexto.append("alt\n");
              }
              else if(e.isControlDown()){
                  areaTexto.append("control\n");
              }
              else if(e.getClickCount()==2){
                  areaTexto.append("doble click");
              }
              //areaTexto.append("has dado click\n"); 
              //System.out.println("has dado click");
          }

          @Override
          public void mousePressed(MouseEvent e) {
              //areaTexto.append("Mouse Pressed\n");
          }

          @Override
          public void mouseReleased(MouseEvent e) {
              //areaTexto.append("Mouse Released\n");
          }

          @Override
          public void mouseEntered(MouseEvent e) {
              //areaTexto.append("Mouse Entered\n");
          }

          @Override
          public void mouseExited(MouseEvent e) {
              //areaTexto.append("Mouse Exited\n");
          }

      };
      
      btn.addMouseListener(oyenteRaton);
        
    }
  private void eventoMovimientoRaton(){
      MouseMotionListener oyenteMovimientoRaton = new MouseMotionListener(){
          
          @Override
          public void mouseDragged(MouseEvent e) {
              areaTexto.append("mousedrager\n");
          }

          @Override
          public void mouseMoved(MouseEvent e) {
              areaTexto.append("mousemove\n");
          }
      };
      
      panel.addMouseMotionListener(oyenteMovimientoRaton);
  }
}




