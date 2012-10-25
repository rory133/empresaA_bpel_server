package org.proyecto.empresaA_bpel_server.dao;

import java.util.List;

import org.proyecto.empresaA_bpel_server.model.Producto_A;

public interface Producto_ADao {
	void save(Producto_A producto_A);
	
	void update(Producto_A producto_A);
	
	void delete(Producto_A producto_A);
	
	Producto_A findByProducto_AIdProducto_a(String Producto_AIdProducto_a);
	
	Producto_A findByProducto_A_nombre(String producto_B_nombre);
	
	List<Producto_A> findAll ();
}