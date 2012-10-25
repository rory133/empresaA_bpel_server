package org.proyecto.empresaA_bpel_server.bo.impl;

import java.util.List;


import org.proyecto.empresaA_bpel_server.bo.Producto_ABo;
import org.proyecto.empresaA_bpel_server.dao.Producto_ADao;
import org.proyecto.empresaA_bpel_server.model.Producto_A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository("producto_ABo")//le decimos a Spring que tiene que manejar este bean

public class Producto_ABoImpl implements Producto_ABo{
	
	@Autowired
	Producto_ADao producto_ADao;


	
	public void setProducto_BDao(Producto_ADao producto_ADao) {
		this.producto_ADao = producto_ADao;
	}
	
	//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
	public void save(Producto_A producto_A) {
		this.producto_ADao.save(producto_A);
		
	}

	public void update(Producto_A producto_A) {
		producto_ADao.update(producto_A);
		
	}

	public void delete(Producto_A producto_A) {
		producto_ADao.delete(producto_A);
		
	}

	public Producto_A findByProducto_AIdProducto_a(String Producto_AIdProducto_a) {
		
		return producto_ADao.findByProducto_AIdProducto_a(Producto_AIdProducto_a);
	}

	public Producto_A findByProducto_A_nombre(String producto_A_nombre) {
		
		return producto_ADao.findByProducto_A_nombre(producto_A_nombre);
	}

	public List<Producto_A> findAll (){
		return producto_ADao.findAll();
	}

}
