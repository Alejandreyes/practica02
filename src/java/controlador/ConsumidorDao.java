/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Consumidor;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Stein
 */
public class ConsumidorDao {
    
    private Session sesion; 
    private Transaction tx;  

    public long guardaConsumidor(Consumidor consumidor) throws HibernateException 
    { 
        long id = 0;  

        try 
        { 
            iniciaOperacion(); 
            id = (Long) sesion.save(consumidor); 
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

    public void actualizaConsumidor(Consumidor consumidor) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(consumidor); 
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

    public void eliminaConsumidor(Consumidor consumidor) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(consumidor); 
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

    public Consumidor obtenConsumidor(long idConsumidor) throws HibernateException 
    { 
        Consumidor consumidor = null;  
        try 
        { 
            iniciaOperacion(); 
            consumidor = (Consumidor) sesion.get(Consumidor.class, idConsumidor); 
        } finally 
        { 
            sesion.close(); 
        }  

        return consumidor; 
    }  

    public List<Consumidor> obtenListaConsumidores() throws HibernateException 
    { 
        List<Consumidor> listaConsumidors = null;  

        try 
        { 
            iniciaOperacion(); 
            listaConsumidors = sesion.createQuery("from Consumidor").list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return listaConsumidors; 
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
