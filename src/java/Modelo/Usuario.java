package Modelo;
// Generated 3/04/2016 11:49:30 PM by Hibernate Tools 4.3.1



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private String usuario;
     private String contrasenia;

    public Usuario() {
    }

	
    public Usuario(String usuario) {
        this.usuario = usuario;
    }
    public Usuario(String usuario, String contrasenia) {
       this.usuario = usuario;
       this.contrasenia = contrasenia;
    }
   
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasenia() {
        return this.contrasenia;
    }
    
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Usuario : "+ usuario + " contrasenia: "+ contrasenia; //To change body of generated methods, choose Tools | Templates.
    }
    



}


