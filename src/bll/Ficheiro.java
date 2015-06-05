/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos
 */
public class Ficheiro {
    
   Map<String, String> mapR = new HashMap<String, String>();
    
    public void criarFicheiro(String nome) throws IOException{

        File f = new File(nome);    
        if (!f.exists()){    
            f.createNewFile();    
        } 
        else
        {
            System.out.println("Ficheiro já existe");
        }
    }    
    
    public  boolean escreverFicheiro(String user,String pass,String nome) throws IOException{
      
        Scanner input = new Scanner(System.in);

        lerFicheiro(nome);
       
            
            if(verificarUser(user,nome) == true)
            {
               mapR.put(user,pass);
            FileOutputStream fos = new FileOutputStream(nome);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(mapR);
                    
            oos.close();

            String messag = "User inserido com sucesso";
            String titl = "";
            int reply = JOptionPane.showConfirmDialog(null, messag, titl, JOptionPane.DEFAULT_OPTION);
            
            return true;
   }
           String messag = "User existente";
           String titl = "Insira novo user";
          int reply = JOptionPane.showConfirmDialog(null, messag, titl, JOptionPane.DEFAULT_OPTION);
            
          return false;
    }
  
     public void lerFicheiro(String nome) throws IOException{
      
         
         FileInputStream fin= new FileInputStream (nome);

               ObjectInputStream ois = new ObjectInputStream(fin);
       try {
           mapR = (HashMap<String, String>)ois.readObject();
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Ficheiro.class.getName()).log(Level.SEVERE, null, ex);
       }
            fin.close();

  }
     
     public boolean verificarUser(String user,String nome)
     {
       try {
           lerFicheiro(nome);
       } catch (IOException ex) {
           Logger.getLogger(Ficheiro.class.getName()).log(Level.SEVERE, null, ex);
       }
         for(String s : mapR.keySet())
         {
             if(s.equals(user))
             return false;
         }
         return true;
     }
     
       public boolean verificarPass(String pass,String nome)
     {
       try {
           lerFicheiro(nome);
       } catch (IOException ex) {
           Logger.getLogger(Ficheiro.class.getName()).log(Level.SEVERE, null, ex);
       }
         for(String s : mapR.values())
         {
             if(s.equals(pass))
             return false;
         }
         return true;
     }
       
       public String retornaLogin(String a)
       {
           return a;
       }
}