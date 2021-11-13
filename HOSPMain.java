/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;

import static com.sun.source.util.DocTrees.instance;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maxcantu
 */
public class HOSPMain {
    private static HOSPMain instance = null;
     public Map<String, Doctor > Doctor;
     public Map<String, Paciente > paciente;

    void addDoctor(Forms.Doctor x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
   public class Paciente{
       
     int IdPac;
     String NombreP;

        public Paciente(int IdPac, String NombreP) {
            this.IdPac = IdPac;
            this.NombreP = NombreP;
            
        }

        public int getIdPac() {
            return IdPac;
        }

        public void setIdPac(int IdPac) {
            this.IdPac = IdPac;
        }

        public String getNombreP() {
            return NombreP;
        }

        public void setNombreP(String NombreP) {
            this.NombreP = NombreP;
        }

        private String IdPac() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
     } 

    public HOSPMain(Map<String, Doctor> Doctor, Map<String, Paciente> paciente) {
        this.Doctor = Doctor;
        this.paciente = paciente;
    }
   
      public class Doctor{
      int IdDoctor;
       String NombreDoc;
       String EspecialidadDoc;

        public Doctor(int IdDoctor, String NombreDoc, String EspecialidadDoc) {
            this.IdDoctor = IdDoctor;
            this.NombreDoc = NombreDoc;
            this.EspecialidadDoc = EspecialidadDoc;
        }

        public int getIdDoctor() {
            return IdDoctor;
        }

        public void setIdDoctor(int IdDoctor) {
            this.IdDoctor = IdDoctor;
        }

        public String getNombreDoc() {
            return NombreDoc;
        }

        public void setNombreDoc(String NombreDoc) {
            this.NombreDoc = NombreDoc;
        }

        public String getEspecialidadDoc() {
            return EspecialidadDoc;
        }

        public void setEspecialidadDoc(String EspecialidadDoc) {
            this.EspecialidadDoc = EspecialidadDoc;
        }

        private String IdDoctor() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
       

       
      }
        
                        
    private HOSPMain(){
        
        paciente = new HashMap<String, Paciente>();
        Doctor = new HashMap<String, Doctor>();
    }
    
     public void escritura(){
    
        try{
            FileWriter archivo = new FileWriter("Datos.csv");
            BufferedWriter flujo = new BufferedWriter(archivo);
            PrintWriter escribir = new PrintWriter(flujo);

            
        } catch(Exception e){
         System.err.println("No se puede escribir" + e.getMessage());
        
        } 
    }
     public String Leer()
    {
        String datos = "";
        String salida ="";
        try{
            
            FileReader archivo = new FileReader ("Datos.csv");
            BufferedReader flujo = new BufferedReader(archivo);
            
            
            while((salida = flujo.readLine())!=null){
                datos = salida;
            }
        
        } catch(Exception e){
            System.err.println("No se puede leer" + e.getMessage());
        }
        return datos;
    }
    
    public static HOSPMain getInstance(){
        if(instance == null){
            instance = new HOSPMain();
        }
        return instance;
    }
    public void addDoctor(Doctor x)throws Exception{
        Doctor p = Doctor.get(x.IdDoctor);
        if(p==null){
             Doctor.put(x.IdDoctor(),x);
        } else {
            throw new Exception("Doctor ya existe");
        }
            
        
    }
    
    public void addPaciente(Paciente x)throws Exception{
        Paciente p = paciente.get(x.IdPac);
        if(p==null){
            paciente.put(x.IdPac(),x);         
        } else {
            throw new Exception("Paciente ya existe");
        }
                 
    }
    
    public List<Paciente> getPaciente(){
        List<Paciente> li = new ArrayList<>();
        for (Map.Entry<String, Paciente> entry : paciente.entrySet()) {
            li.add(entry.getValue());
            
        }
        return li;    
    }
    
    public List<Doctor> getDoctor(){
        List<Doctor> li = new ArrayList<>();
        for (Map.Entry<String, Doctor> entry : Doctor.entrySet()) {
            li.add(entry.getValue());
            
        }
        return li;
        
    }
    
    
       public static void main(String args[]) {
        /* Set the Nimbus look and feel */
       
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }
}
