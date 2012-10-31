package org.proyecto.empresaA_bpel_server.dao.impl;



import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.proyecto.empresaA_bpel_server.dao.Cliente_ADao;
import org.proyecto.empresaA_bpel_server.model.Cliente_A;
import org.proyecto.empresaA_bpel_server.model.Usuario_A;
import org.proyecto.empresaA_bpel_server.util.CustomHibernateDaoSupport;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


//@Repository("Cliente_ADao")


// le decimos a Spring que es una clase DAO y que se inyectará el objeto SessionFactory
//de Hibernate con la anotacion @Autowired
@Repository("cliente_ADao")
public class Cliente_ADaoImpl extends CustomHibernateDaoSupport implements Cliente_ADao {
	
	@Autowired
	 private SessionFactory sessionFactory;



	public void save(Cliente_A cliente_A) {

                this.sessionFactory.getCurrentSession().save(cliente_A);
	
	}



	public void update(Cliente_A cliente_A) {

                 this.sessionFactory.getCurrentSession().merge(cliente_A);
		
	}

	public void delete(Cliente_A cliente_A) {

                this.sessionFactory.getCurrentSession().delete(cliente_A);

		
	}

	@SuppressWarnings("unchecked")
	public Cliente_A findByCliente_AIdCliente_a(String cliente_AIdCliente_a) {

              List <Cliente_A> list = sessionFactory.getCurrentSession().createCriteria (Cliente_A.class )
                        .add(Restrictions.eq("idusuarios_a",Integer.parseInt(cliente_AIdCliente_a)))
                        .list();
                return list.get(0);
                
                
	}
	
	@SuppressWarnings("unchecked")
	public Usuario_A findByCliente_A_login_usuario_a(String cliente_A_login_usuario_a) {

                
                List <Usuario_A> list = sessionFactory.getCurrentSession().createCriteria (Usuario_A.class )
                        .add(Restrictions.eq("login_usuario_a",cliente_A_login_usuario_a))
                        .list();
                
		if(list.isEmpty())
			return null;
		return (Usuario_A)list.get(0);
		
	}

	@SuppressWarnings("unchecked")
	public List<Cliente_A> findAll (){

                return sessionFactory.getCurrentSession().createCriteria (Cliente_A.class )
                                     .list();
	}


}