/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
 
import Modelo.Usuario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
@ManagedBean
public class UserView {
     
    private String usuario;
    private String lastname;
 
    public String getUsuario() {
        return usuario;
    }
 
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
 
    public String getLastname() {
        return lastname;
    }
 
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
 
    public void save() {
        UsuarioDao dao= new UsuarioDao();
        List<Usuario> lista=dao.obtenListaUsuarios();
        for (Usuario next: lista) {
            if (next.getUsuario().equals(usuario) && next.getContrasenia().equals(lastname)){
                FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Welcome " + usuario ));
            }
        }
        
        
    }
}
