
package txt_editor;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.*;
public class txt_editor extends JFrame implements ActionListener {
     JTextArea arl;
     int sali;
     String txx;
     @Override
     public void actionPerformed(ActionEvent act){
        
         if(act.getActionCommand().equals("New")){
          
             
             
             sali = JOptionPane.showConfirmDialog(this,"Do you want to save changes?","Type Express text Editor",JOptionPane.YES_NO_OPTION);
             
             if(sali==JOptionPane.YES_OPTION){
                 JFileChooser guar = new JFileChooser();
             guar.setApproveButtonText("Guardar");
             FileNameExtensionFilter restrin = new FileNameExtensionFilter("Solo.txt Archivos","txt");
             guar.addChoosableFileFilter(restrin);
             int accn = guar.showOpenDialog(this);
             if(accn != JFileChooser.APPROVE_OPTION){
          
             return;
             
             } 
             File arch_nom = new File(guar.getSelectedFile() + ".txt");
             BufferedWriter arch_ot = null;
             try{
                arch_ot = new BufferedWriter(new FileWriter(arch_nom));
                arl.write(arch_ot);
             }catch(Exception e){
                 
             }
             
             }else if(sali==JOptionPane.NO_OPTION){
                 arl.setText("");
             }
             
             
             arl.setText("");
             
          }
         
         else if(act.getActionCommand().equals("Open")){
             JFileChooser eleg = new  JFileChooser();
             eleg.setAcceptAllFileFilterUsed(false);
             FileNameExtensionFilter restrin = new FileNameExtensionFilter("Solo.txt Archivos","txt");
             eleg.addChoosableFileFilter(restrin);
             
             int accn = eleg.showOpenDialog(this);
             if(accn != JFileChooser.APPROVE_OPTION){
          
             return;
             }
             
             File arch_nom = eleg.getSelectedFile();
             
             try{
                BufferedReader leer = new BufferedReader(new FileReader(arch_nom));
                arl.read(leer,null);
             }catch(Exception e){
                 
             }
             
         }
         else if(act.getActionCommand().equals("Save")){
             JFileChooser guar = new JFileChooser();
             guar.setApproveButtonText("Guardar");
             FileNameExtensionFilter restrin = new FileNameExtensionFilter("Solo.txt Archivos","txt");
             guar.addChoosableFileFilter(restrin);
             int accn = guar.showOpenDialog(this);
             if(accn != JFileChooser.APPROVE_OPTION){
          
             return;
             
             } 
             File arch_nom = new File(guar.getSelectedFile() + ".txt");
             BufferedWriter arch_ot = null;
             try{
                arch_ot = new BufferedWriter(new FileWriter(arch_nom));
                arl.write(arch_ot);
             }catch(Exception e){
                 
             }
             
             
          }
          else if (act.getActionCommand().equals("Exit")){
          
              
              
              System.exit(0);
              
          }
          else if (act.getActionCommand().equals("Copy")){
           txx = arl.getSelectedText();
              
          }
       
         else if (act.getActionCommand().equals("Paste")){
             arl.insert(txx,arl.getCaretPosition() );
          }
         
         else if (act.getActionCommand().equals("Delete")){
            arl.replaceSelection("");
          }
         
          else if (act.getActionCommand().equals("Cut")){
            txx = arl.getSelectedText();
            
            arl.replaceRange("", arl.getSelectionStart(), arl.getSelectionEnd());
          }
         
         else if (act.getActionCommand().equals("About")){
           
             new sobre_owner().setVisible(true);
          }
     }
     
     txt_editor(){
      
     // codificaion de la ventana principal size, localicaion cenetrada
      setBounds(0,0,700,500); 
      setTitle("Type Express text Editor");
      setLocationRelativeTo(null);
      JMenuBar menBr = new JMenuBar();
      
      // aqui  creamos un objeto del menubar que contendra la opcion y configuracion del boton  archivo donde esta,nuevo,abrir,guarda,guardarcomo y salir 
      JMenu File = new JMenu("File");
      
      JMenuItem doc_nw = new JMenuItem("New");
      doc_nw.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK ));
      
      doc_nw.addActionListener(this);
      
      JMenuItem Opn = new JMenuItem("Open");
      Opn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK ));
      
      Opn.addActionListener(this);
      
      JMenuItem sv = new JMenuItem("Save");
      sv.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK ));
      
      sv.addActionListener(this);
      
      JMenuItem svs = new JMenuItem("Save as");
      svs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK ));
      svs.addActionListener(this);
      
      JMenuItem xt = new JMenuItem("Exit");
      xt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
      
      xt.addActionListener(this);
      
      // aqui creamos un objeto del menubar que contendra la opcion editar con sus opciones, copoiar, cortar, pegar
      JMenu Edt = new JMenu("Edit");
      
      JMenuItem cp = new JMenuItem("Copy");
      cp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
      
      cp.addActionListener(this);
      
      JMenuItem ps = new JMenuItem("Paste");
      ps.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
      
      ps.addActionListener(this);
      
      JMenuItem ct = new JMenuItem("Cut");
      ct.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
      
      ct.addActionListener(this);
      
      JMenuItem dlt = new JMenuItem("Delete");
      dlt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
      
      dlt.addActionListener(this);
      JMenu Hp = new JMenu("Help");
      JMenuItem obt = new JMenuItem("About");
      
      obt.addActionListener(this);
      
      //Agregando el menubar
      menBr.add(File);
      menBr.add(Edt);
      menBr.add(Hp);
      
     setJMenuBar(menBr);
     
     //Agregando EL MENUITEM DEL MENUBAR ARCHIVOS
       File.add(doc_nw); 
       File.add(Opn); 
       File.add(sv); 
       File.add(svs); 
       File.add(xt); 
       
      //Agregando EL MENUITEM DEL MENUBAR  Editar
        Edt.add(cp);
        Edt.add(ct);
        Edt.add(ps);
        Edt.add(dlt);
        //Agregando EL MENUITEM DEL MENUBAR  Ayuda
        
        Hp.add(obt);
        
       
       
        
        arl = new  JTextArea();
       JScrollPane  sc_pn = new JScrollPane(arl, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(sc_pn, BorderLayout.CENTER);
        
        
          
      
   
     }
     public static void main(String[] args) {
        
      new txt_editor().setVisible(true);
    }

}
