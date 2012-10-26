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
		//getHibernateTemplate().save(producto_B);
		//this.getSessionFactory().getCurrentSession().save(Producto_A.class);
		//this.getSessionFactory().getCurrentSession().save(producto_B);
		System.out.println("en save productoB");
		this.sessionFactory.getCurrentSession().save(producto_A);
	
	}



	public void update(Producto_A producto_A) {
		getHibernateTemplate().update(producto_A);
		System.out.println("en update productoA");
		System.out.println("nombre productoA productoA: "+ producto_A.getNombre_productoA());
		//this.sessionFactory.getCurrentSession().update(producto_B);
		//this.getSessionFactory().getCurrentSession().update(producto_B);
	}

	public void delete(Producto_A producto_A) {
		getHibernateTemplate().delete(producto_A);
		
	}
	@SuppressWarnings("unchecked")
	public Producto_A findByProducto_AIdProducto_a(String producto_BIdProducto_b) {
		 
/*		List<Producto_A> list = getHibernateTemplate().find(
				"from Producto_A where IDPRODUCTOB = ?",Integer.parseInt(producto_BIdProducto_b)); 
		return (Producto_A)list.get(0);*/
		
		List<Producto_A> list = this.getSessionFactory().getCurrentSession().createCriteria (Producto_A.class ).add(Restrictions.eq("idproductob",Integer.parseInt(producto_BIdProducto_b))).list();
		return (Producto_A)list.get(0);
		
		
	}
	
	@SuppressWarnings("unchecked")
	public Producto_A findByProducto_A_nombre(String producto_B_nombre) {
		List <Producto_A> list = getHibernateTemplate().find(
                "from Producto_A where NOMBRE_PRODUCTOB = ?",producto_B_nombre);
		return (Producto_A)list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Producto_A> findAll (){
		System.out.println("en findAll");
		  return (List<Producto_A>) this.getSessionFactory().getCurrentSession().createCriteria (Producto_A.class ).list();
   
		
	}

}

