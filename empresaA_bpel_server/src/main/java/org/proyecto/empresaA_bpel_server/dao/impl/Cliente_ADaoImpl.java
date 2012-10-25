package org.proyecto.empresaA_bpel_server.dao.impl;



import org.proyecto.empresaA_bpel_server.dao.Cliente_ADao;
import org.proyecto.empresaA_bpel_server.model.Cliente_A;
import org.proyecto.empresaA_bpel_server.model.Usuario_A;
import org.proyecto.empresaA_bpel_server.util.CustomHibernateDaoSupport;

import java.util.List;
import org.springframework.stereotype.Repository;


//@Repository("Cliente_ADao")


// le decimos a Spring que es una clase DAO y que se inyectará el objeto SessionFactory
//de Hibernate con la anotacion @Autowired
@Repository("cliente_ADao")
public class Cliente_ADaoImpl extends CustomHibernateDaoSupport implements Cliente_ADao {
	
	



	public void save(Cliente_A cliente_A) {
		getHibernateTemplate().save(cliente_A);
	
	}



	public void update(Cliente_A cliente_A) {
		
		
		//getHibernateTemplate().update(cliente_B);
		getHibernateTemplate().merge(cliente_A);
		
	}

	public void delete(Cliente_A cliente_A) {
		getHibernateTemplate().delete(cliente_A);
		
	}

	@SuppressWarnings("unchecked")
	public Cliente_A findByCliente_AIdCliente_a(String cliente_AIdCliente_a) {
		List<Cliente_A> list = getHibernateTemplate().find(
                     "from Cliente_A where idusuarios_a= ?",Integer.parseInt(cliente_AIdCliente_a));
		return (Cliente_A)list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public Usuario_A findByCliente_A_login_usuario_a(String cliente_A_login_usuario_a) {
		System.out.println("login usuario pasado: "+cliente_A_login_usuario_a);
		
		//List<Cliente_A> list = this.getSessionFactory().getCurrentSession().createCriteria (Cliente_A.class ).add(Restrictions.eq("login_usuario_b",cliente_B_login_usuario_b)).list();
		//return (Producto_A)list.get(0);
		
		//List<Cliente_A> list = this.getSessionFactory().getCurrentSession().createCriteria (Cliente_A.class ).add(Restrictions.eq("login_usuario_b",cliente_B_login_usuario_b)).list();
		
		/*List <Cliente_A> list = getHibernateTemplate().find(
               "from Cliente_A where login_usuario_b = ?",cliente_B_login_usuario_b);*/
		
		List <Usuario_A> list= getHibernateTemplate().find(
	 				"from Usuario_A  where login_usuario_a = ?",cliente_A_login_usuario_a);
		System.out.println("tamaño lista encontrada: "+list.size());
		if(list.isEmpty())
			return null;
		return (Usuario_A)list.get(0);
		
	}

	@SuppressWarnings("unchecked")
	public List<Cliente_A> findAll (){
		List <Cliente_A> list = getHibernateTemplate().find("from Cliente_A");
		return list;
	}

}