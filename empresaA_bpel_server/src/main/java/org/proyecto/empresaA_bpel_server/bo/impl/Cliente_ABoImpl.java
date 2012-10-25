package org.proyecto.empresaA_bpel_server.bo.impl;

import java.util.List;

import org.proyecto.empresaA_bpel_server.bo.Cliente_ABo;
import org.proyecto.empresaA_bpel_server.dao.Cliente_ADao;
import org.proyecto.empresaA_bpel_server.model.Cliente_A;
import org.proyecto.empresaA_bpel_server.model.Usuario_A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("cliente_ABo")//le decimos a Spring que tiene que manejar este bean
public class Cliente_ABoImpl implements Cliente_ABo{
	
	@Autowired
	Cliente_ADao cliente_ADao;

	public void setCliente_BDao(Cliente_ADao cliente_ADao) {
		this.cliente_ADao = cliente_ADao;
	}
	
	//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
	public void save(Cliente_A cliente_A) {
		this.cliente_ADao.save(cliente_A);
		
	}

	public void update(Cliente_A cliente_A) {
		cliente_ADao.update(cliente_A);
		
	}

	public void delete(Cliente_A cliente_A) {
		cliente_ADao.delete(cliente_A);
		
	}

	public Cliente_A findByCliente_AIdCliente_a(String Cliente_BIdCliente_b) {
		
		return cliente_ADao.findByCliente_AIdCliente_a(Cliente_BIdCliente_b);
	}

	public Usuario_A findByCliente_A_login_usuario_a(String cliente_B_login_usuario_b) {
		
		return cliente_ADao.findByCliente_A_login_usuario_a(cliente_B_login_usuario_b);
	}
	
	public List<Cliente_A> findAll (){
		return cliente_ADao.findAll();
	}

}

