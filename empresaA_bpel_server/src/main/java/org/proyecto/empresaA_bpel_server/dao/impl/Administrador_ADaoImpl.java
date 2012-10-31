package org.proyecto.empresaA_bpel_server.dao.impl;

import org.proyecto.empresaA_bpel_server.dao.Administrador_ADao;
import org.proyecto.empresaA_bpel_server.model.Administrador_A;
import org.proyecto.empresaA_bpel_server.model.Usuario_A;
import org.proyecto.empresaA_bpel_server.util.CustomHibernateDaoSupport;

import java.util.List;

import org.springframework.stereotype.Repository;



import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;







// le decimos a Spring que es una clase DAO y que se inyectará el objeto SessionFactory
//de Hibernate con la anotacion @Autowired
@Repository("administrador_BDao")
public class Administrador_ADaoImpl extends CustomHibernateDaoSupport implements Administrador_ADao {
        @Autowired
	 private SessionFactory sessionFactory;
	public void save(Administrador_A administrador_A) {
		
                this.sessionFactory.getCurrentSession().save(administrador_A);
	
	}



	public void update(Administrador_A administrador_A) {

                this.sessionFactory.getCurrentSession().merge(administrador_A);
	}

	public void delete(Administrador_A administrador_A) {

                this.sessionFactory.getCurrentSession().delete(administrador_A);
		
	}

	@SuppressWarnings("unchecked")
	public Administrador_A findByAdministrador_AIdAdministrador_a(String administrador_AIdAdministrador_a) {

                
                List <Administrador_A> list = sessionFactory.getCurrentSession().createCriteria (Administrador_A.class )
                        .add(Restrictions.eq("idusuarios_a",Integer.parseInt(administrador_AIdAdministrador_a)))
                        .list();
                return list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public Usuario_A findByAdministrador_A_login_usuario_a(String administrador_A_login_usuario_a) {

                
              List <Usuario_A> list = sessionFactory.getCurrentSession().createCriteria (Usuario_A.class )
                        .add(Restrictions.eq("login_usuario_a",administrador_A_login_usuario_a))
                        .list();
                
                
		if(list.isEmpty())
			return null;
		return (Usuario_A)list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Administrador_A> findAll (){
            
            
            
            return sessionFactory.getCurrentSession().createCriteria (Administrador_A.class )
                                     .list();
            

	}
}
