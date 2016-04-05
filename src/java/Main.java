
import Modelo.Usuario;
import controlador.UsuarioDao;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stein
 */
public class Main {
    public static void main(String[] args) {
        UsuarioDao d=new UsuarioDao();
        List<Usuario> lista=d.obtenListaUsuarios();
        for(Usuario next: lista){
            System.out.println(next);
        }
    }
    
}
