package org.proyecto.empresaA_bpel_server.service.impl;

import java.util.List;

import org.proyecto.empresaA_bpel_server.bo.Producto_ABo;
import org.proyecto.empresaA_bpel_server.model.Producto_A;
import org.proyecto.empresaA_bpel_server.service.Productos_AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;






@Service("productoService")


public class Productos_AServiceImpl implements Productos_AService{
	@Autowired
	private Producto_ABo producto_ABo;
	
	
	
	@Transactional
	public List<Producto_A> getProductos_A(){
		List <Producto_A> list=producto_ABo.findAll();
		return list;
		
	}
	@Transactional
	public void update(Producto_A producto_A) {
		producto_ABo.update(producto_A);
	}
	@Transactional
	public void save(Producto_A producto_A) {
		producto_ABo.save(producto_A);
	}
	public Producto_A findByProducto_AIdProducto_a(String Producto_AIdProducto_a){
		return producto_ABo.findByProducto_AIdProducto_a(Producto_AIdProducto_a);
	}
	public void delete(Producto_A producto_A) {
		producto_ABo.delete(producto_A);
		
	}
	
}