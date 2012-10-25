package org.proyecto.empresaA_bpel_server.bo;

import java.util.List;

import org.proyecto.empresaA_bpel_server.model.Carro_A;
import org.proyecto.empresaA_bpel_server.model.Producto_ASeleccionado;

public interface Carro_ABo {
	
	void save(Carro_A carro_A);
	
	void update(Carro_A carro_A);
	
	void delete(Carro_A carro_A);
	
	Carro_A findByCarro_AIdCarro_a(String Carro_AIdCarro_a);
	
	List<Producto_ASeleccionado> findByTodosCarro_BIdCarro_b(String carro_AIdCarro_a);
	
	List<Carro_A>findByTodosCarro_AIdCliente_a(String carro_AIdCliente_a);
		
	List<Carro_A> findAll ();

}

