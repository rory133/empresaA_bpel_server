package org.proyecto.empresaA_bpel_server.service.impl;

import java.util.List;


import org.proyecto.empresaA_bpel_server.dao.Producto_ASeleccionadoDao;
import org.proyecto.empresaA_bpel_server.model.Producto_ASeleccionado;
import org.proyecto.empresaA_bpel_server.service.Producto_ASeleccionadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("producto_ASeleccionadoService")
public class Producto_ASeleccionadoServiceImpl implements Producto_ASeleccionadoService{

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
	
	public Producto_ASeleccionado findByProducto_ASeleccionadoIdProducto_a_y_carro_a(String Producto_ASeleccionadoIdProducto_a, String carro_a){
		
		return producto_ASeleccionadoDao.findByProducto_ASeleccionadoIdProducto_a_y_carro_a(Producto_ASeleccionadoIdProducto_a,carro_a);
		
	}

	public Producto_ASeleccionado findByProducto_ASeleccionadoIdProducto_a(String Producto_ASeleccionadoIdProducto_a) {
		
		return producto_ASeleccionadoDao.findByProducto_ASeleccionadoIdProducto_a(Producto_ASeleccionadoIdProducto_a);
	}

	public Producto_ASeleccionado findByProducto_ASeleccionado_nombre(String producto_ASeleccionado_nombre) {
		
		return producto_ASeleccionadoDao.findByProducto_ASeleccionado_nombre(producto_ASeleccionado_nombre);
	}
	
	public List <Producto_ASeleccionado> findByProducto_ASeleccionadoPorIdcarro_a(String carro_a){
		
		return producto_ASeleccionadoDao.findByProducto_ASeleccionadoPorIdcarro_a(carro_a);
	}
	
	public List<Producto_ASeleccionado> findAll (){
		return producto_ASeleccionadoDao.findAll();
	}

}