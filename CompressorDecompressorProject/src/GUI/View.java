/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import CodeFiles.Compress;
import CodeFiles.Decompress;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.JFrame;

/**
 *
 * @author Rahul
 */
public class View extends JFrame implements ActionListener{
    JButton compressButton;
    JButton decompressButton;
     View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        compressButton = new JButton("Select File to Compress");
        compressButton.setBounds(20,200 , 200 , 30);
        compressButton.addActionListener(this);
        decompressButton = new JButton("Select File to Decompress");
        decompressButton.setBounds(250,200 , 200 , 30);
        decompressButton.addActionListener(this);

        
        this.add(compressButton);
        this.add(decompressButton);
        
        this.setSize(500,300);
        this.getContentPane().setBackground(Color.black);
     }
     @Override
     public void actionPerformed(ActionEvent e){
         if(e.getSource() == compressButton){
             JFileChooser fileChoooser = new JFileChooser();
             int response = fileChoooser.showSaveDialog(null);
             
             if(response == JFileChooser.APPROVE_OPTION){
                 File file = new File(fileChoooser.getSelectedFile().getAbsolutePath());
                 System.out.print(file);
                 try{
                     Compress.compressFunction(file);
                 }
                 catch(Exception excp){
                     JOptionPane.showMessageDialog(null, excp.toString());
                 }
             }
         }
         if(e.getSource() == decompressButton){
             JFileChooser fileChoooser = new JFileChooser();
             int response = fileChoooser.showSaveDialog(null);
             
             if(response == JFileChooser.APPROVE_OPTION){
                 File file = new File(fileChoooser.getSelectedFile().getAbsolutePath());
                 System.out.print(file);
                 try{
                     Decompress.decompressFunction(file);
                 }
                 catch(Exception excp){
                     JOptionPane.showMessageDialog(null, excp.toString());
                 }
         }
     }
  }
    public static void main(String [] args){
         View view = new View();
         view.setVisible(true);
     }
}
