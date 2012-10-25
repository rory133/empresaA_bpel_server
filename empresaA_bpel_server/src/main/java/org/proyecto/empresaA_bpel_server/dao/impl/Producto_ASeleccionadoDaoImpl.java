package org.proyecto.empresaA_bpel_server.dao.impl;

import java.util.Iterator;
import java.util.List;


import org.proyecto.empresaA_bpel_server.dao.Producto_ASeleccionadoDao;
import org.proyecto.empresaA_bpel_server.model.Producto_ASeleccionado;
import org.proyecto.empresaA_bpel_server.util.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("Producto_ASeleccionadoDao")
public class Producto_ASeleccionadoDaoImpl extends CustomHibernateDaoSupport implements Producto_ASeleccionadoDao{
	public void save(Producto_ASeleccionado producto_ASeleccionado) {
		
		//System.out.println("productoBseleccionado a guardar en save: "+ producto_BSeleccionado.getIdproductob());
		//System.out.println("productoBseleccionado id productob a guardar en save : "+ producto_BSeleccionado.getIdproductob());
		System.out.println("CANTIDAD productoBseleccionado id productob a guardar en save : "+ producto_ASeleccionado.getCantidad());
		getHibernateTemplate().save(producto_ASeleccionado);
		//getHibernateTemplate().merge(producto_BSeleccionado);
		//getHibernateTemplate().saveOrUpdate(producto_BSeleccionado);
	
	}



	public void update(Producto_ASeleccionado producto_ASeleccionado) {
		
		//System.out.println("productoBseleccionado a guardar en update: "+ producto_BSeleccionado.getIdproductob());
		//System.out.println("productoBseleccionado id productob a guardar en update: "+ producto_BSeleccionado.getIdproductob());
		System.out.println("CANTIDAD productoBseleccionado id productob a guardar en update : "+ producto_ASeleccionado.getCantidad());
		//getHibernateTemplate().update(producto_BSeleccionado);
		getHibernateTemplate().merge(producto_ASeleccionado);
	}

	public void delete(Producto_ASeleccionado producto_ASeleccionado) {
		System.out.println("en delete productoSeleccionado: "+producto_ASeleccionado.getIdproductoSeleccionado());
		getHibernateTemplate().delete(producto_ASeleccionado);
		
	}
	@SuppressWarnings("unchecked")
	public Producto_ASeleccionado findByProducto_ASeleccionadoIdProducto_a(String producto_BSeleccionadoIdProducto_b) {
	
		List<Producto_ASeleccionado> list = getHibernateTemplate().find(
                     "from Producto_ASeleccionado where IDPRODUCTOSELECCIONADO = ?",Integer.parseInt(producto_BSeleccionadoIdProducto_b));
					//"from Producto_ASeleccionado where IDPRODUCTOB = ?",Integer.parseInt(producto_BSeleccionadoIdProducto_b));
		
		return (Producto_ASeleccionado)list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public Producto_ASeleccionado findByProducto_ASeleccionado_nombre(String producto_BSeleccionado_nombre) {
		List <Producto_ASeleccionado> list = getHibernateTemplate().find(
                "from Producto_ASeleccionado where NOMBRE_PRODUCTOB = ?",producto_BSeleccionado_nombre);
		return (Producto_ASeleccionado)list.get(0);
	}
	
/*	@SuppressWarnings("unchecked")
	public Producto_ASeleccionado findByProducto_BSeleccionadoIdProducto_b_y_carro_b(String Producto_BSeleccionadoIdProducto_b, String carro_b){
		System.out.println("carro_b en find: "+carro_b);
		System.out.println("productoseleccionado en find: "+Producto_BSeleccionadoIdProducto_b);
		List <Producto_ASeleccionado> list = getHibernateTemplate().find(
        	"from Producto_ASeleccionado where IDCARRO_B = ?", Integer.parseInt(carro_b));
		if(!list.isEmpty())
		return (Producto_ASeleccionado)list.get(0);
		
		return null;
		
	}*/
	
	@SuppressWarnings("unchecked")
	public Producto_ASeleccionado findByProducto_ASeleccionadoIdProducto_a_y_carro_a(String Producto_BSeleccionadoIdProducto_a, String carro_a){
		System.out.println("carro_b en find-por iddproducto y por idCarro: "+carro_a);
		System.out.println("productoseleccionado en find-por iddproducto y por idCarro: "+Producto_BSeleccionadoIdProducto_a);
		List <Producto_ASeleccionado> list = getHibernateTemplate().find(
        	"from Producto_ASeleccionado where IDCARRO_B = ?", Integer.parseInt(carro_a));
		System.out.println("despues de buscar productos find-por iddproducto y por idCarro");
		if(list.isEmpty()){
			return null;
		}
		else{
			
		System.out.println("hay productos seleccionados con ese carro  en find ");
		Iterator<Producto_ASeleccionado> itr = list.iterator();
		while (itr.hasNext()) {
			Producto_ASeleccionado element = itr.next();
			System.out.println("en bucle while id del producto actual : "+element.getIdproductoSeleccionado());
			if(element.getProducto_a().getIdproductoa()==Integer.parseInt(Producto_BSeleccionadoIdProducto_a)){
				System.out.println("Se encontro ese producto en find, esta es su id:"+element.getIdproductoSeleccionado());
				return element;
			}
		}

		
		return null;
		
		}
		
	}
	@SuppressWarnings("unchecked")
	public List <Producto_ASeleccionado> findByProducto_ASeleccionadoPorIdcarro_a(String carro_b){
		System.out.println("carro_b en find por id carro: "+carro_b);
		List <Producto_ASeleccionado> list = getHibernateTemplate().find(
        	"from Producto_ASeleccionado where idcarro_b = ?", Integer.parseInt(carro_b));
		System.out.println("tamaño lista en findByProducto_BSeleccionadoPorIdcarro_b: "+list.size());
		
	/*	if(list.isEmpty()){
			return null;
		}*/		
		return list;
		
	
		
	}
	

	@SuppressWarnings("unchecked")
	public List<Producto_ASeleccionado> findAll (){
		List <Producto_ASeleccionado> list = getHibernateTemplate().find("from Producto_ASeleccionado");
		return list;
	}

}

