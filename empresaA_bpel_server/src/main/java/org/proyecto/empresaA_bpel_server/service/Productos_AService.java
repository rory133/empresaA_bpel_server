package org.proyecto.empresaA_bpel_server.service;

import java.util.List;

import org.proyecto.empresaA_bpel_server.model.Producto_A;



public interface Productos_AService {
	
	public List<Producto_A> getProductos_A();
	public void save(Producto_A producto_A);
	public Producto_A findByProducto_AIdProducto_a(String Producto_BIdProducto_b);
	public void update(Producto_A producto_A);
	void delete(Producto_A producto_A);

}
