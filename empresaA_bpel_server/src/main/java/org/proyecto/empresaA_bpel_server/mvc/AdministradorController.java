package org.proyecto.empresaA_bpel_server.mvc;




import javax.servlet.ServletContext;


import org.apache.log4j.Logger;
import org.proyecto.empresaA_bpel_server.model.Administrador_A;
import org.proyecto.empresaA_bpel_server.model.ListaAdministradores_A;
import org.proyecto.empresaA_bpel_server.model.Usuario_A;
import org.proyecto.empresaA_bpel_server.service.impl.Administrador_AServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/administradores")
public class AdministradorController {
	
	@Autowired
	private Administrador_AServiceImpl administrador_AServiceImpl;
	
	
	@Autowired
	ServletContext context;
	
	


	
	protected static Logger logger = Logger.getLogger("*en Administrador_B_BControlleren servidor#######*");
	
	
	

	
	
	
	
	@RequestMapping(value="/administrador",
			method = RequestMethod.POST,
			headers="Accept=application/xml, application/json")
	public @ResponseBody void addCliente_B_form(@RequestBody Administrador_A administrador_a) {


		logger.info("addAdministrador_B_form ");
		
		administrador_a.setAUTHORITY("ROLE_ADMIN");
		administrador_a.setENABLED(true);
		administrador_AServiceImpl.save(administrador_a);
		
		logger.info("se ha sumado administrador en servidor####### "+administrador_a.getNombre_a());
		administrador_AServiceImpl.save(administrador_a);




	}


	//devolvemos una lista con todos los administradores
@RequestMapping(value="/administradores",
				method=RequestMethod.GET, 
				headers="Accept=application/xml, application/json")
	
	public @ResponseBody  ListaAdministradores_A listadoAdministradores_B(){
		logger.info("enServidor en listadoAdministradores REST server ####");
		

		ListaAdministradores_A lista=new ListaAdministradores_A();
		lista.setDataAdministrador(administrador_AServiceImpl.findAll());
	

	   return lista;
	}


//buscamos y devolvemos un administrador por su id
	@RequestMapping(value="/administrador/{id}"
			, method = RequestMethod.GET,
			headers="Accept=application/xml, application/json")
	public @ResponseBody Administrador_A getAdministradorPorId(@PathVariable("id")String  id){
		
		logger.info(" en servidor en getAdministradoPorId  ##### " );
		
		Administrador_A adminTemp=administrador_AServiceImpl.findByAdministrador_AIdAdministrador_a(id);		
		
		return adminTemp;	
	
	}


	//buscamos y devolvemos un administrador por su login
		@RequestMapping(value="/administradorLogin/{login}"
				, method = RequestMethod.GET,
				headers="Accept=application/xml, application/json")
		public @ResponseBody Usuario_A getAdministradorPorLogin(@PathVariable("login")String  login){
			
			logger.info(" en servidor en getAdministradoPorLogin #####: "+login );
			
					
			Usuario_A usuarioTemp=administrador_AServiceImpl.findByAdministrador_A_login_usuario_a(login);
			logger.info(" en servidor en getAdministradoPorLogin usuarioTemp.getLogin_usuario_b() #####: "+usuarioTemp.getLogin_usuario_a() );
			return usuarioTemp;	
		
		}

	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ModelAndView editAdministrador_B_form(String id){


	
		Administrador_A administrador_b= new Administrador_A();
		administrador_b= administrador_AServiceImpl.findByAdministrador_AIdAdministrador_a(id);
					
		logger.info("producto pasado a edit-modificar: "+administrador_b.getNombre_a());
		
		
		//List<Producto_A> lista =productos_BServiceImpl.getProductos_B();
		//return new ModelAndView("producto_b/listaProductos","productos", lista);
		return new ModelAndView("administrador_b/modificar", "administrador_b",administrador_b);
	
}

	
	//actualizamos un cliente
	@RequestMapping(value="/administrador/{id}",
			method = RequestMethod.PUT,
			headers="Accept=application/xml, application/json")
public @ResponseBody void updateCliente(@PathVariable ("id") String id, @RequestBody Administrador_A administrador_b) {


		logger.info("en servido inicio de updateAdministrador_B en servidor####### ");
		administrador_b.setAUTHORITY("ROLE_ADMIN");
		administrador_b.setENABLED(true);
		administrador_AServiceImpl.update(administrador_b);



}
	
	//borrar administrador
	@RequestMapping(value="/administrador/{id}"
			, method = RequestMethod.DELETE,
			headers="Accept=application/xml, application/json")
	public @ResponseBody void delAdministrador_B_form(@PathVariable("id")String  id){
		logger.info(" en deladministrador_B_form DELETE por id  ##### " +id);
		
		Administrador_A administrador_b= new Administrador_A();
		administrador_b= administrador_AServiceImpl.findByAdministrador_AIdAdministrador_a(id);
		logger.info(" en getClienteHTML DELETE por id ya encontrado cliente  ##### ");
		administrador_AServiceImpl.delete(administrador_b);
			
		logger.info("##### borrando administrador : ");
	}	
	
	

	

}