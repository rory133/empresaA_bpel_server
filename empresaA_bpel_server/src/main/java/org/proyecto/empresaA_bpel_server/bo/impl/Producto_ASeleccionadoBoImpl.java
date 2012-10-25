package org.proyecto.empresaA_bpel_server.bo.impl;

import java.util.List;

import org.proyecto.empresaA_bpel_server.bo.Producto_ASeleccionadoBo;
import org.proyecto.empresaA_bpel_server.dao.Producto_ASeleccionadoDao;
import org.proyecto.empresaA_bpel_server.model.Producto_ASeleccionado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("producto_BSeleccionadoBo")//le decimos a Spring que tiene que manejar este bean
public class Producto_ASeleccionadoBoImpl implements Producto_ASeleccionadoBo{
	
	@Autowired
	Producto_ASeleccionadoDao producto_ASeleccionadoDao;

	public void setProducto_BSeleccionadoDao(Producto_ASeleccionadoDao producto_ASeleccionadoDao) {
		this.producto_ASeleccionadoDao = producto_ASeleccionadoDao;
	}
	
	//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
	public void save(Producto_ASeleccionado producto_ASeleccionado) {
		this.producto_ASeleccionadoDao.save(producto_ASeleccionado);
		
	}

	public void update(Producto_ASeleccionado producto_ASeleccionado) {
		producto_ASeleccionadoDao.update(producto_ASeleccionado);
		
	}

	public void delete(Producto_ASeleccionado producto_ASeleccionado) {
		producto_ASeleccionadoDao.delete(producto_ASeleccionado);
		
	}

	public Producto_ASeleccionado findByProducto_ASeleccionadoIdProducto_a(String Producto_BSeleccionadoIdProducto_b) {
		
		return producto_ASeleccionadoDao.findByProducto_ASeleccionadoIdProducto_a(Producto_BSeleccionadoIdProducto_b);
	}

	public Producto_ASeleccionado findByProducto_ASeleccionado_nombre(String producto_BSeleccionado_nombre) {
		
		return producto_ASeleccionadoDao.findByProducto_ASeleccionado_nombre(producto_BSeleccionado_nombre);
	}
	
	public List<Producto_ASeleccionado> findAll (){
		return producto_ASeleccionadoDao.findAll();
	}

}