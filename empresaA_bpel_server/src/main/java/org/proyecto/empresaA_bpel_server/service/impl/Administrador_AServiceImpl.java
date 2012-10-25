package org.proyecto.empresaA_bpel_server.service.impl;


import java.util.List;

import org.proyecto.empresaA_bpel_server.dao.Administrador_ADao;
import org.proyecto.empresaA_bpel_server.model.Administrador_A;
import org.proyecto.empresaA_bpel_server.model.Usuario_A;
import org.proyecto.empresaA_bpel_server.service.Administrador_AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service("administradorService")
public class Administrador_AServiceImpl implements Administrador_AService{
	
	@Autowired
	Administrador_ADao administrador_ADao;
	


	public void setAdministrador_BDao(Administrador_ADao administrador_ADao) {
		this.administrador_ADao = administrador_ADao;
	}
	
	//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
	public void save(Administrador_A administrador_A) {
		this.administrador_ADao.save(administrador_A);
		
	}

	public void update(Administrador_A administrador_A) {
		administrador_ADao.update(administrador_A);
		
	}

	public void delete(Administrador_A administrador_A) {
		administrador_ADao.delete(administrador_A);
		
	}
	
	@Transactional
	public Administrador_A findByAdministrador_AIdAdministrador_a(String Administrador_BIdAdministrador_b) {
		
		return administrador_ADao.findByAdministrador_AIdAdministrador_a(Administrador_BIdAdministrador_b);
	}
	
	@Transactional
	public Usuario_A findByAdministrador_A_login_usuario_a(String administrador_B_login_usuario_b) {
		
		return administrador_ADao.findByAdministrador_A_login_usuario_a(administrador_B_login_usuario_b);
	}
	
	@Transactional
	public List<Administrador_A> findAll (){
		return administrador_ADao.findAll();
	}
	
	

}
