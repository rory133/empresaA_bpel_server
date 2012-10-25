package org.proyecto.empresaA_bpel_server.service;

import java.util.List;

import org.proyecto.empresaA_bpel_server.model.Producto_ASeleccionado;

public interface Producto_ASeleccionadoService {
	
	void save(Producto_ASeleccionado producto_ASeleccionado);
	
	void update(Producto_ASeleccionado producto_ASeleccionado);
	
	void delete(Producto_ASeleccionado producto_ASeleccionado);
	
	Producto_ASeleccionado findByProducto_ASeleccionadoIdProducto_a(String Producto_ASeleccionadoIdProducto_a);
	
	Producto_ASeleccionado findByProducto_ASeleccionadoIdProducto_a_y_carro_a(String Producto_ASeleccionadoIdProducto_a, String carro_a);

	Producto_ASeleccionado findByProducto_ASeleccionado_nombre(String producto_ASeleccionado_nombre);
	
	List <Producto_ASeleccionado> findByProducto_ASeleccionadoPorIdcarro_a(String carro_a);
	
	List<Producto_ASeleccionado> findAll ();

}
