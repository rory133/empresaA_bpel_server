package org.proyecto.empresaA_bpel_server.bo;

import java.util.List;

import org.proyecto.empresaA_bpel_server.model.Producto_ASeleccionado;



public interface Producto_ASeleccionadoBo {
	
	void save(Producto_ASeleccionado producto_ASeleccionado);
	
	void update(Producto_ASeleccionado producto_ASeleccionado);
	
	void delete(Producto_ASeleccionado producto_ASeleccionado);
	
	Producto_ASeleccionado findByProducto_ASeleccionadoIdProducto_a(String Producto_ASeleccionadoIdProducto_a);
	
	Producto_ASeleccionado findByProducto_ASeleccionado_nombre(String producto_ASeleccionado_nombre);
	
	List<Producto_ASeleccionado> findAll ();

}
