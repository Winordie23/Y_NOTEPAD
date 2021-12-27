/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package y_note;

import java.awt.FileDialog;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.TextEvent;
import java.io.BufferedReader;
import java.io.*;
import java.util.logging.*;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Aminadab23
 */
public class YNOTE extends javax.swing.JFrame {
String prog = "YNote";
String file = "";
String holdText;
String fn;
String dir;
boolean txtchanged = false;
String fileName;
Clipboard clip = getToolkit().getSystemClipboard();

    /**
     * Creates new form YNOTE
     */
    public YNOTE() {
        initComponents();
    }
public void CheckFile() {
    BufferedReader read;
    StringBuffer sb = new StringBuffer();
    try {
       read = new BufferedReader(new FileReader(fileName));
        String line;
        while((line = read.readLine())!= null){
            sb.append(line + "\n");
        }
        tarea.setText(sb.toString());
        read.close();
    }
    catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(null,"File NOt Found");
    }
    catch (IOException ioe){
        
    }
}
   private void saveAs() {
        FileDialog fd= new FileDialog(YNOTE.this, "save",FileDialog.SAVE);
        fd.show();
        if(fd.getFile()!=null)
        {
            fn=fd.getFile();
            dir=fd.getDirectory();
            file= dir + fn +".txt";
            setTitle(file);
            try
            {
                DataOutputStream d= new DataOutputStream(new FileOutputStream(file));
                holdText= tarea.getText();
                BufferedReader br= new BufferedReader(new StringReader(holdText));
                while((holdText= br.readLine()) !=null)
                {
                    d.writeBytes(holdText + "\r\n");
                    d.close();
                }
            }
            catch(Exception e)
            {
                System.out.println("file not found");
            }
            tarea.requestFocus();
            save(file);
        }
        }

    private void save(String file) {
        setTitle(prog + " "+ file);
        try{
            FileWriter out = new FileWriter(fn);
            out.write(tarea.getText());
            out.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error " + ex);
            txtchanged= false;
            save.setEnabled(false);
    //    Logger.getLogger(YNOTE.class.getName()).log(Level.SEVERE, null, ex);
    }
        
       
    }
    private void newfile() {
        if (tarea.getText().length() < 1){
            setTitle("untiteled-"+prog);
            txtchanged= false;
        }
        else if (!txtchanged){
            setTitle("untitled-"+prog);
            tarea.setText("");
            txtchanged= false;
        }
        else {
            int conf = JOptionPane.showConfirmDialog(null, "do you want to save?");
            if (conf== JOptionPane.YES_OPTION)
            {
                if("".equals(file)){
                    saveAs();
                }
                else {
                    save(file);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tarea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        open = new javax.swing.JMenuItem();
        NEW = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        saveas = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        copy = new javax.swing.JMenuItem();
        past = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        tool = new javax.swing.JMenu();
        print = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("YNote");

        tarea.setColumns(20);
        tarea.setRows(5);
        tarea.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tareaInputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(tarea);

        File.setText("File");

        open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        open.setText("Open");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        File.add(open);

        NEW.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        NEW.setText("New");
        NEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NEWActionPerformed(evt);
            }
        });
        File.add(NEW);

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        save.setText("Save");
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        File.add(save);

        saveas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveas.setText("Save as");
        saveas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveasActionPerformed(evt);
            }
        });
        File.add(saveas);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        exit.setText("exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        File.add(exit);

        jMenuBar1.add(File);

        Edit.setText("Edit");

        copy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        copy.setText("Copy");
        Edit.add(copy);

        past.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        past.setText("past");
        Edit.add(past);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("cut");
        Edit.add(jMenuItem2);

        jMenuBar1.add(Edit);

        tool.setText("Tool");

        print.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        print.setText("print");
        tool.add(print);

        jMenuBar1.add(tool);

        jMenu1.setText("Help");

        jMenuItem1.setText("contact");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
     if (tarea.getText().length() < 1){
      FileDialog fd= new FileDialog(this, "choose file",FileDialog.LOAD);
        fd.show();
        if(fd.getFile()!=null)
        {
            fn=fd.getFile();
            dir=fd.getDirectory();
            file= dir + fn +".txt";
            setTitle(file);
            checkFile();
        
        tarea.requestFocus();}
        else if (!txtchanged){
                FileDialog fd1 = new FileDialog(this, "choose File", FileDialog.LOAD);
                fd.show();
                if (fd1.getFile()!= null){
                    fileName = fd1.getDirectory()+ fd1.getFile();
                    setTitle(fileName);
                    checkFile();
                }
                tarea.requestFocus();
                        }
        else {
            int conf = JOptionPane.showConfirmDialog(this, "do you want to open?");
            if (conf == JOptionPane.YES_OPTION){
                if("".equals(file)){
                    saveAs();
                }
            }
        }}
        
        
        
        
    }//GEN-LAST:event_openActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
if (file.equals("")){
    saveAs();
}
else
    save(file);

        // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    private void tareaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tareaInputMethodTextChanged
 if (TextEvent.TEXT_VALUE_CHANGED !=0){
     if(!txtchanged)
             setTitle("* "+ getTitle());
     txtchanged = true;
     save.setEnabled(true);
 }           // TODO add your handling code here:
    }//GEN-LAST:event_tareaInputMethodTextChanged

    private void saveasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveasActionPerformed
       saveAs(); // TODO add your handling code here:
    }//GEN-LAST:event_saveasActionPerformed

    private void NEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NEWActionPerformed
     
        newfile(); // TODO add your handling code here:
    }//GEN-LAST:event_NEWActionPerformed

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_saveMouseClicked

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
       if ("".equals(tarea.getText())){
           System.exit(0);
       }
       else if (!txtchanged){
System.exit(0);
       }
       else {
           int conf = JOptionPane.showConfirmDialog(this, "do you want to save!","choice",JOptionPane.YES_NO_OPTION);
           if (conf == JOptionPane.YES_OPTION){
                if("".equals(file))
                    saveAs();
                else 
                    save(file);
                
           }
           if (conf==JOptionPane.NO_OPTION)
               System.exit(0);
       }
                
       
       
    }//GEN-LAST:event_exitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YNOTE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu File;
    private javax.swing.JMenuItem NEW;
    private javax.swing.JMenuItem copy;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem open;
    private javax.swing.JMenuItem past;
    private javax.swing.JMenuItem print;
    private javax.swing.JMenuItem save;
    private javax.swing.JMenuItem saveas;
    private javax.swing.JTextArea tarea;
    private javax.swing.JMenu tool;
    // End of variables declaration//GEN-END:variables

    private void checkFile() {
      JOptionPane.showMessageDialog(null, "not supported yet");
    }

    
    
}

