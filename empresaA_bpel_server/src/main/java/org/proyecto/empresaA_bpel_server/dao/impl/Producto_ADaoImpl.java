package org.proyecto.empresaA_bpel_server.dao.impl;




import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.proyecto.empresaA_bpel_server.dao.Producto_ADao;
import org.proyecto.empresaA_bpel_server.model.Producto_A;
import org.proyecto.empresaA_bpel_server.util.CustomHibernateDaoSupport;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;





// le decimos a Spring que es una clase DAO y que se inyectará el objeto SessionFactory
//de Hibernate con la anotacion @Autowired
@Repository("producto_ADao")
public class Producto_ADaoImpl extends CustomHibernateDaoSupport implements Producto_ADao {

	
	 @Autowired
	 private SessionFactory sessionFactory;
	
	
	public void save(Producto_A producto_A) {


		this.sessionFactory.getCurrentSession().save(producto_A);
	
	}



	public void update(Producto_A producto_A) {
            this.sessionFactory.getCurrentSession().update(producto_A);

	}

	public void delete(Producto_A producto_A) {
            this.sessionFactory.getCurrentSession().delete(producto_A);
	
		
	}
	@SuppressWarnings("unchecked")
	public Producto_A findByProducto_AIdProducto_a(String producto_AIdProducto_a) {
		 

		List<Producto_A> list =sessionFactory.getCurrentSession()
				.createCriteria (Producto_A.class )
				.add(Restrictions.eq("idproductoa",Integer.parseInt(producto_AIdProducto_a)))
				.list();
	
		return (Producto_A)list.get(0);
		
		
	}
	
	@SuppressWarnings("unchecked")
	public Producto_A findByProducto_A_nombre(String producto_A_nombre) {
		//List <Producto_A> list = getHibernateTemplate().find(
                List <Producto_A> list = sessionFactory.getCurrentSession().createCriteria (Producto_A.class )
                        .add(Restrictions.eq("NOMBRE_PRODUCTOA",producto_A_nombre))
                        .list();
                //from Producto_A where NOMBRE_PRODUCTOA = ?",producto_A_nombre);
		return (Producto_A)list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Producto_A> findAll (){

	
   
		return sessionFactory.getCurrentSession().createCriteria (Producto_A.class )
                                     .list();
	}


}

