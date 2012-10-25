package org.proyecto.empresaA_bpel_server.dao.impl;

import org.proyecto.empresaA_bpel_server.dao.Carro_ADao;
import org.proyecto.empresaA_bpel_server.model.Carro_A;
import org.proyecto.empresaA_bpel_server.model.Producto_ASeleccionado;
import org.proyecto.empresaA_bpel_server.util.CustomHibernateDaoSupport;

import java.util.List;
import org.springframework.stereotype.Repository;


//@Repository("Carro_ADao")


// le decimos a Spring que es una clase DAO y que se inyectará el objeto SessionFactory
//de Hibernate con la anotacion @Autowired
@Repository("carro_ADao")
public class Carro_ADaoImpl extends CustomHibernateDaoSupport implements Carro_ADao {

	public void save(Carro_A carro_A) {
		System.out.println("datos carro cliente:"+carro_A.getCliente_a().getNombre_a());
		System.out.println("datos carro IdCliente:"+carro_A.getCliente_a().getIdusuarios_a());
		System.out.println("datos carro fecha:"+carro_A.getFecha_a());
		System.out.println("datos carro pagado:"+carro_A.getPagado());
		System.out.println("datos carro enviado:"+carro_A.getEnviado());
		System.out.println("datos carro tamaño productos seleccionado"+carro_A.getProducto_BSeleccionado().size());
		
		getHibernateTemplate().save(carro_A);
		System.out.println("salvado carro");
	
	}



	public void update(Carro_A carro_A) {
		getHibernateTemplate().update(carro_A);
		
	}

	public void delete(Carro_A carro_A) {
		getHibernateTemplate().delete(carro_A);
		
	}
	
	@SuppressWarnings("unchecked")
	public Carro_A findByCarro_AIdCarro_a(String carro_AIdCarro_a) {
		List<Carro_A> list = getHibernateTemplate().find(
                     "from Carro_A where idcarro_a = ?",Integer.parseInt(carro_AIdCarro_a));
		return (Carro_A)list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto_ASeleccionado>findByTodosCarro_AIdCarro_a(String carro_AIdCarro_a) {
		List<Producto_ASeleccionado> list = getHibernateTemplate().find(
                    "from Producto_ASeleccionado where idcarro_a = ?",Integer.parseInt(carro_AIdCarro_a));
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Carro_A>findByTodosCarro_AIdCliente_a(String carro_AIdCliente_a) {
		List<Carro_A> list = getHibernateTemplate().find(
                    "from Carro_A where idcliente = ?",Integer.parseInt(carro_AIdCliente_a) );
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Carro_A> findAll(){
		System.out.println("en finAll de Carrodaoimpl");
		List <Carro_A> list = getHibernateTemplate().find("from Carro_A order by idcarro_a");
	
		return list;
	}

}
