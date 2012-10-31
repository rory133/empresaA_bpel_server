package org.proyecto.empresaA_bpel_server.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.proyecto.empresaA_bpel_server.dao.Carro_ADao;
import org.proyecto.empresaA_bpel_server.model.Carro_A;
import org.proyecto.empresaA_bpel_server.model.Producto_ASeleccionado;
import org.proyecto.empresaA_bpel_server.util.CustomHibernateDaoSupport;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


//@Repository("Carro_ADao")


// le decimos a Spring que es una clase DAO y que se inyectará el objeto SessionFactory
//de Hibernate con la anotacion @Autowired
@Repository("carro_BDao")
public class Carro_ADaoImpl extends CustomHibernateDaoSupport implements Carro_ADao {
        @Autowired
	 private SessionFactory sessionFactory;
        
        
	public void save(Carro_A carro_A) {

                this.sessionFactory.getCurrentSession().save(carro_A);
                

	
	}



	public void update(Carro_A carro_A) {

                this.sessionFactory.getCurrentSession().update(carro_A);
	
	}

	public void delete(Carro_A carro_A) {
		
                 this.sessionFactory.getCurrentSession().delete(carro_A);
		
	}
	
	@SuppressWarnings("unchecked")
	public Carro_A findByCarro_AIdCarro_a(String carro_AIdCarro_a) {

                List <Carro_A> list = sessionFactory.getCurrentSession().createCriteria (Carro_A.class )
                        .add(Restrictions.eq("idcarro_a",Integer.parseInt(carro_AIdCarro_a)))
                        .list();
                return list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto_ASeleccionado>findByTodosCarro_AIdCarro_a(String carro_AIdCarro_a) {

            List <Producto_ASeleccionado> list = sessionFactory.getCurrentSession().createCriteria (Producto_ASeleccionado.class )
                        .add(Restrictions.eq("idcarro_a",Integer.parseInt(carro_AIdCarro_a)))
                        .list();
                return list;
                
                
	}
	
	@SuppressWarnings("unchecked")
	public List<Carro_A>findByTodosCarro_AIdCliente_a(String carro_AIdCliente_a) {

              List <Carro_A> list = sessionFactory.getCurrentSession().createCriteria (Carro_A.class )
                        .add(Restrictions.eq("idcliente",Integer.parseInt(carro_AIdCliente_a)))
                        .list();
              return list;
                
	}

	@SuppressWarnings("unchecked")
	public List<Carro_A> findAll(){
                  return sessionFactory.getCurrentSession().createCriteria (Carro_A.class )
                                     .list();
                
                
	}

}
