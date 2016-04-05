/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Stein
 */
import Modelo.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Stein
 */
public class UsuarioDao {
    
    private Session sesion; 
    private Transaction tx;  

    public long guardaUsuario(Usuario usuario) throws HibernateException 
    { 
        long id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Long) sesion.save(usuario); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        }  

        return id; 
    }  

    public void actualizaUsuario(Usuario usuario) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(usuario); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
    }  

    public void eliminaUsuario(Usuario usuario) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(usuario); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            manejaExcepcion(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
    }  

    public Usuario obtenUsuario(long idUsuario) throws HibernateException 
    { 
        Usuario usuario = null;  
        try 
        { 
            iniciaOperacion(); 
            usuario = (Usuario) sesion.get(Usuario.class, idUsuario); 
        } finally 
        { 
            sesion.close(); 
        }  

        return usuario; 
    }  

    public List<Usuario> obtenListaUsuarios() throws HibernateException 
    { 
        List<Usuario> listaUsuarios = null;  

        try 
        { 
            iniciaOperacion(); 
            listaUsuarios = sesion.createQuery("from Usuario").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaUsuarios; 
    }  

    private void iniciaOperacion() throws HibernateException 
    { 
        sesion = HibernateUtil.getSessionFactory().openSession(); 
        tx = sesion.beginTransaction(); 
    }  

    private void manejaExcepcion(HibernateException he) throws HibernateException 
    { 
        tx.rollback(); 
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he); 
    } 
}