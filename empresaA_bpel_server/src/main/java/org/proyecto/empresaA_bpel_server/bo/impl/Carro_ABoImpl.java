package org.proyecto.empresaA_bpel_server.bo.impl;

import java.util.List;

import org.proyecto.empresaA_bpel_server.bo.Carro_ABo;
import org.proyecto.empresaA_bpel_server.dao.Carro_ADao;
import org.proyecto.empresaA_bpel_server.model.Carro_A;
import org.proyecto.empresaA_bpel_server.model.Producto_ASeleccionado;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("carro_BBo")//le decimos a Spring que tiene que manejar este bean
public class Carro_ABoImpl implements Carro_ABo{
	
	@Autowired
	Carro_ADao carro_ADao;

	public void setCarro_BDao(Carro_ADao carro_ADao) {
		this.carro_ADao = carro_ADao;
	}
	
	//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
	public void save(Carro_A carro_A) {
		this.carro_ADao.save(carro_A);
		
	}

	public void update(Carro_A carro_A) {
		carro_ADao.update(carro_A);
		
	}

	public void delete(Carro_A carro_A) {
		carro_ADao.delete(carro_A);
		
	}

	public Carro_A findByCarro_AIdCarro_a(String Carro_BIdCarro_b) {
		
		return carro_ADao.findByCarro_AIdCarro_a(Carro_BIdCarro_b);
	}

	public List<Producto_ASeleccionado> findByTodosCarro_BIdCarro_b(String carro_BIdCarro_b){
		
		return carro_ADao.findByTodosCarro_AIdCarro_a(carro_BIdCarro_b);
	}
	
	public List<Carro_A>findByTodosCarro_AIdCliente_a(String carro_BIdCliente_b){
		
		return carro_ADao.findByTodosCarro_AIdCliente_a(carro_BIdCliente_b);
	}
	
	public List<Carro_A> findAll (){
		return carro_ADao.findAll();
	}

}
