/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Prestador;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Stein
 */
public class PrestadorDao {
    
    private Session sesion; 
    private Transaction tx;  

    public long guardaPrestador(Prestador prestador) throws HibernateException 
    { 
        long id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Long) sesion.save(prestador); 
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

    public void actualizaPrestador(Prestador prestador) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(prestador); 
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

    public void eliminaPrestador(Prestador prestador) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(prestador); 
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

    public Prestador obtenPrestador(long idPrestador) throws HibernateException 
    { 
        Prestador prestador = null;  
        try 
        { 
            iniciaOperacion(); 
            prestador = (Prestador) sesion.get(Prestador.class, idPrestador); 
        } finally 
        { 
            sesion.close(); 
        }  

        return prestador; 
    }  

    public List<Prestador> obtenListaPrestadores() throws HibernateException 
    { 
        List<Prestador> listaPrestadors = null;  

        try 
        { 
            iniciaOperacion(); 
            listaPrestadors = sesion.createQuery("from Prestador").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaPrestadors; 
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
