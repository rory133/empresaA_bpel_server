package org.proyecto.empresaA_bpel_server.bo;

import java.util.List;

import org.proyecto.empresaA_bpel_server.model.Cliente_A;
import org.proyecto.empresaA_bpel_server.model.Usuario_A;

public interface Cliente_ABo {
	
	void save(Cliente_A cliente_A);
	
	void update(Cliente_A cliente_A);
	
	void delete(Cliente_A cliente_A);
	
	Cliente_A findByCliente_AIdCliente_a(String Cliente_AIdCliente_a);
	
	Usuario_A findByCliente_A_login_usuario_a(String cliente_A_login_usuario_a);
	
	List<Cliente_A> findAll ();

}
