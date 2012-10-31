package org.proyecto.empresaA_bpel_server.dao.impl;

import java.util.Iterator;
import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.proyecto.empresaA_bpel_server.dao.Producto_ASeleccionadoDao;
import org.proyecto.empresaA_bpel_server.model.Producto_ASeleccionado;
import org.proyecto.empresaA_bpel_server.util.CustomHibernateDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("Producto_ASeleccionadoDao")
public class Producto_ASeleccionadoDaoImpl extends CustomHibernateDaoSupport implements Producto_ASeleccionadoDao{
	
         @Autowired
	 private SessionFactory sessionFactory;
    
    
      public void save(Producto_ASeleccionado producto_ASeleccionado) {
   
                 this.sessionFactory.getCurrentSession().save(producto_ASeleccionado);
	}



	public void update(Producto_ASeleccionado producto_ASeleccionado) {

                this.sessionFactory.getCurrentSession().merge(producto_ASeleccionado);
	}

	public void delete(Producto_ASeleccionado producto_ASeleccionado) {

                this.sessionFactory.getCurrentSession().delete(producto_ASeleccionado);
		
	}
	@SuppressWarnings("unchecked")
	public Producto_ASeleccionado findByProducto_ASeleccionadoIdProducto_a(String producto_ASeleccionadoIdProducto_a) {

              List <Producto_ASeleccionado> list = sessionFactory.getCurrentSession().createCriteria (Producto_ASeleccionado.class )
                        .add(Restrictions.eq("idproductoSeleccionado",Integer.parseInt(producto_ASeleccionadoIdProducto_a)))
                        .list();
                return (Producto_ASeleccionado) list.get(0);
                
                
                
                
	}
	
	@SuppressWarnings("unchecked")
	public Producto_ASeleccionado findByProducto_ASeleccionado_nombre(String producto_ASeleccionado_nombre) {
		
             List <Producto_ASeleccionado> list = sessionFactory.getCurrentSession().createCriteria (Producto_ASeleccionado.class )
                        .add(Restrictions.eq("NOMBRE_PRODUCTOA",producto_ASeleccionado_nombre))
                        .list();
                return list.get(0);   
                
                
	}

	
	@SuppressWarnings("unchecked")
	public Producto_ASeleccionado findByProducto_ASeleccionadoIdProducto_a_y_carro_a(String Producto_ASeleccionadoIdProducto_a, String carro_a){
    

        List <Producto_ASeleccionado> list = sessionFactory.getCurrentSession().createCriteria (Producto_ASeleccionado.class )
                        .add(Restrictions.eq("carro_a.idcarro_a",Integer.parseInt(carro_a)))
                        .list();
                
                
		if(list.isEmpty()){
			return null;
		}
		else{
			
		System.out.println("hay productos seleccionados con ese carro  en find ");
		Iterator<Producto_ASeleccionado> itr = list.iterator();
		while (itr.hasNext()) {
			Producto_ASeleccionado element = itr.next();
			System.out.println("en bucle while id del producto actual : "+element.getIdproductoSeleccionado());
			if(element.getProducto_a().getIdproductoa()==Integer.parseInt(Producto_ASeleccionadoIdProducto_a)){
				System.out.println("Se encontro ese producto en find, esta es su id:"+element.getIdproductoSeleccionado());
				return element;
			}
		}

		
		return null;
		
		}
		
	}
	@SuppressWarnings("unchecked")
	public List <Producto_ASeleccionado> findByProducto_ASeleccionadoPorIdcarro_a(String carro_a){

                List <Producto_ASeleccionado> lista = sessionFactory.getCurrentSession()
                		.createCriteria (Producto_ASeleccionado.class )
                        .add(Restrictions. eq("carro_a.idcarro_a",Integer.parseInt(carro_a)))
                        .list();
	
		return lista;
		
	
		
	}
	

	@SuppressWarnings("unchecked")
	public List<Producto_ASeleccionado> findAll (){

              return sessionFactory.getCurrentSession().createCriteria (Producto_ASeleccionado.class )
                                     .list();
	}


}

