package org.proyecto.empresaA_bpel_server.service.impl;

import java.util.List;

import org.proyecto.empresaA_bpel_server.bo.Cliente_ABo;
import org.proyecto.empresaA_bpel_server.dao.Cliente_ADao;
import org.proyecto.empresaA_bpel_server.model.Cliente_A;
import org.proyecto.empresaA_bpel_server.model.Usuario_A;
import org.proyecto.empresaA_bpel_server.service.Cliente_AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service("clienteService")
public class Cliente_AServiceImpl implements Cliente_AService{
	
	@Autowired
	Cliente_ADao cliente_ADao;
	@Autowired
	Cliente_ABo cliente_ABo;


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
	
	@Transactional
	public Cliente_A findByCliente_AIdCliente_a(String Cliente_AIdCliente_a) {
		
		return cliente_ADao.findByCliente_AIdCliente_a(Cliente_AIdCliente_a);
	}
	
	
	@Transactional
	public Usuario_A findByCliente_A_login_usuario_a(String cliente_A_login_usuario_a) {
		
		return cliente_ADao.findByCliente_A_login_usuario_a(cliente_A_login_usuario_a);
	}
	
	@Transactional
	public List<Cliente_A> findAll (){
		//return cliente_ADao.findAll();
		return cliente_ABo.findAll();
	}
	
	

}
