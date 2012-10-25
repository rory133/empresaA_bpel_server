package org.proyecto.empresaA_bpel_server.service.impl;

import java.util.List;

import org.proyecto.empresaA_bpel_server.dao.Carro_ADao;
import org.proyecto.empresaA_bpel_server.model.Carro_A;
import org.proyecto.empresaA_bpel_server.model.Producto_ASeleccionado;
import org.proyecto.empresaA_bpel_server.service.Carro_AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("carroService")
public class Carro_AServiceImpl implements Carro_AService {

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

	public Carro_A findByCarro_AIdCarro_a(String Carro_AIdCarro_a) {
		
		return carro_ADao.findByCarro_AIdCarro_a(Carro_AIdCarro_a);
	}

	public List<Producto_ASeleccionado> findByTodosCarro_AIdCarro_a(String carro_AIdCarro_a){
		
		return carro_ADao.findByTodosCarro_AIdCarro_a(carro_AIdCarro_a);
	}
	
	public List<Carro_A>findByTodosCarro_AIdCliente_a(String carro_AIdCliente_a){
		
		return carro_ADao.findByTodosCarro_AIdCliente_a(carro_AIdCliente_a);
	}
	
	public List<Carro_A> findAll (){
		return carro_ADao.findAll();
	}

}
