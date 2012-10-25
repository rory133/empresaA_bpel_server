package org.proyecto.empresaA_bpel_server.service;

import java.util.List;

import org.proyecto.empresaA_bpel_server.model.Administrador_A;
import org.proyecto.empresaA_bpel_server.model.Usuario_A;

public interface Administrador_AService {
	
	
	void save(Administrador_A administrador_A);	
	void update(Administrador_A administrador_A);	
	void delete(Administrador_A administrador_A);	
	Administrador_A findByAdministrador_AIdAdministrador_a(String Administrador_AIdAdministrador_a);	
	Usuario_A findByAdministrador_A_login_usuario_a(String administrador_A_login_usuario_b);
	List<Administrador_A> findAll ();

}
