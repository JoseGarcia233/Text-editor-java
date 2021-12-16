
package txt_editor;
import java.awt.event.*;
import java.awt.Image;
import javax.swing.*;

public class sobre_owner  extends JFrame implements ActionListener{
    
    
    
    @Override
    public void actionPerformed(ActionEvent act){
        
        this.setVisible(false);
        
    }
    
    
    
    sobre_owner (){
        
        setBounds(450, 150, 600, 450);
        setTitle("About");
        setLayout(null);
       
        ImageIcon ownp = new ImageIcon(ClassLoader.getSystemResource("txt_editor/ownerp/jose txt.jpg"));
        Image ownps = ownp.getImage().getScaledInstance(175, 110, Image.SCALE_DEFAULT);
        ImageIcon ownps1 = new ImageIcon(ownps);
        JLabel ownpN = new JLabel(ownps1);
        ownpN.setBounds(160, 55, 260, 125);
        add(ownpN);
        
        
        JLabel txtlab= new JLabel("<html> text editor By jose garcia  student <br>from itla <br><html>");
        
              txtlab.setBounds(190, 110, 250, 250);
              add(txtlab);
        
              
              JButton ko;
              ko = new JButton("Accept");
              ko.setBounds(480, 350, 90, 35);
              ko.addActionListener(this);
              add(ko);
    }
    
    public static void main(String[] args) {
        new sobre_owner().setVisible(true);
    }
}

 