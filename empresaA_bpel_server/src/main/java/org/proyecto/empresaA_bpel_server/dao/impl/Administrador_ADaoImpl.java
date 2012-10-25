package org.proyecto.empresaA_bpel_server.dao.impl;

import org.proyecto.empresaA_bpel_server.dao.Administrador_ADao;
import org.proyecto.empresaA_bpel_server.model.Administrador_A;
import org.proyecto.empresaA_bpel_server.model.Usuario_A;
import org.proyecto.empresaA_bpel_server.util.CustomHibernateDaoSupport;

import java.util.List;

import org.springframework.stereotype.Repository;


//@Repository("Administrador_ADao")


// le decimos a Spring que es una clase DAO y que se inyectará el objeto SessionFactory
//de Hibernate con la anotacion @Autowired
@Repository("administrador_ADao")
public class Administrador_ADaoImpl extends CustomHibernateDaoSupport implements Administrador_ADao {

	public void save(Administrador_A administrador_A) {
		getHibernateTemplate().save(administrador_A);
	
	}



	public void update(Administrador_A administrador_A) {
		//getHibernateTemplate().update(administrador_B);
		getHibernateTemplate().merge(administrador_A);
		
	}

	public void delete(Administrador_A administrador_A) {
		getHibernateTemplate().delete(administrador_A);
		
	}

	@SuppressWarnings("unchecked")
	public Administrador_A findByAdministrador_AIdAdministrador_a(String administrador_AIdAdministrador_a) {
		List<Administrador_A> list = getHibernateTemplate().find(
                     "from Administrador_A where idusuarios_a = ?",Integer.parseInt(administrador_AIdAdministrador_a));
		return (Administrador_A)list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public Usuario_A findByAdministrador_A_login_usuario_a(String administrador_A_login_usuario_a) {
/*		List <Administrador_A> list = getHibernateTemplate().find(
                "from Administrador_A where login_usuario_b = ?",administrador_B_login_usuario_b);
		return (Administrador_A)list.get(0);*/
		
		List <Usuario_A> list= getHibernateTemplate().find(
 				"from Usuario_A  where login_usuario_a = ?",administrador_A_login_usuario_a);
		System.out.println("tamaño lista encontrada: "+list.size());
		if(list.isEmpty())
			return null;
		return (Usuario_A)list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Administrador_A> findAll (){
		List <Administrador_A> list = getHibernateTemplate().find("from Administrador_A");
		return list;
	}

}
