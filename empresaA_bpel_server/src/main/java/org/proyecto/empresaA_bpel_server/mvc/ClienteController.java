package org.proyecto.empresaA_bpel_server.mvc;


import java.util.Date;
import org.apache.log4j.Logger;
import org.proyecto.empresaA_bpel_server.model.Cliente_A;
import org.proyecto.empresaA_bpel_server.model.ListaClientes_A;
import org.proyecto.empresaA_bpel_server.service.Cliente_AService;
import org.proyecto.empresaA_bpel_server.util.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;





@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
/*	@Autowired
	private Cliente_AServiceImpl cliente_BServiceImpl;*/
	
	@Autowired
	private Cliente_AService cliente_BServiceImpl;

	
	

	@Autowired
	private Mail mail;
	


	
	protected static Logger logger = Logger.getLogger("*en Cliente_B_BController*en servidor#######");
	
	
	
	

	

	//actualizamos un cliente
	@RequestMapping(value="/cliente/{id}",
			method = RequestMethod.PUT,
			headers="Accept=application/xml, application/json")
public @ResponseBody void updateCliente(@PathVariable ("id") String id, @RequestBody Cliente_A cliente_a) {


		logger.info("en servido inicio de updateCliente_B r####### ");

		cliente_BServiceImpl.update(cliente_a);

		logger.info("se envia correo de informacion de actualizacion en servidor####### a"+cliente_a.getNombre_a());
		String content="apreciado usuario se ha procedido a a actualizar sus datos en nuestra base de datos";
		String subject="realizada correctamente actualizació en empresa_b";		
		mail.sendMail(cliente_a.getLogin_usuario_a(), content, cliente_a.getEmail_a(), subject);


}
	
	
	//creamos un nuevo cliente
	@RequestMapping(value="/cliente",
					method = RequestMethod.POST,
					headers="Accept=application/xml, application/json")
	public @ResponseBody void addCliente_B_form(@RequestBody Cliente_A cliente_a) {

		
		logger.info("inicio de addCliente_B en servidor####### ");
	
		
		
		cliente_a.setFecha_alta_a(new Date());
		cliente_a.setAUTHORITY("ROLE_CLIENTE");
		cliente_a.setENABLED(true);
		logger.info("se ha sumado cliente en servidor####### "+cliente_a.getNombre_a());
		cliente_BServiceImpl.save(cliente_a);
		
		logger.info("se envia correo de bienvenida en servidor####### a"+cliente_a.getNombre_a());
		String content="apreciado usuario gracias por darse de alta en nuestra página ahora pordrá realizar los pedidos que desee";
		String subject="realizada correctamente alta en empresa_b";		
		mail.sendMail(cliente_a.getLogin_usuario_a(), content, cliente_a.getEmail_a(), subject);

		
}
	

	
	
	//devolvemos una lista con todos los clientes
@RequestMapping(value="/clientes",
				method=RequestMethod.GET, 
				headers="Accept=application/xml, application/json")
	
	public @ResponseBody  ListaClientes_A listadoClientes_B(){
		logger.info("enServidor en listadoClientes REST server ####");
		//List<Cliente_A> clientes_b=cliente_BServiceImpl.findAll();

		ListaClientes_A lista=new ListaClientes_A();
		lista.setDataCliente(cliente_BServiceImpl.findAll());
	

	   return lista;
	}


	
	
	
	//buscamos y devolvemos un clientes por su login
	@RequestMapping(value="/clienteLogin/{login}",
			method = RequestMethod.GET,
			headers="Accept=application/xml, application/json")
	public @ResponseBody Cliente_A getClientePorLogin(@PathVariable("login")String  login){
		
		logger.info(" en Servidor en getClientePorLogin por login  ##### " +login);
		
		Cliente_A clientTemp =(Cliente_A)cliente_BServiceImpl.findByCliente_A_login_usuario_a(login);
		if(null!=clientTemp){		
			Integer id=clientTemp.getIdusuarios_a();
			logger.info(" en getClienteHTML por login  #####  el id obtenido con cliente_BServiceImpl.findByCliente_B_login_usuario_a(login).getIdusuarios_a() es "  +id);
			Cliente_A clientTemp2= cliente_BServiceImpl.findByCliente_AIdCliente_a(String.valueOf(id));
			return clientTemp2;
		}
		
		
		
		return null;


	
	}
	//buscamos y devolvemos un clientes por su id
	@RequestMapping(value="/cliente/{id}"
			, method = RequestMethod.GET,
			headers="Accept=application/xml, application/json")
	public @ResponseBody Cliente_A getClientePorId(@PathVariable("id")String  id){
		
		logger.info(" en servidor en getClientePorId  ##### " +id);
		
		Cliente_A clientTemp= cliente_BServiceImpl.findByCliente_AIdCliente_a(id);
		
		logger.info("en getClienteHTML por login  ##### imprimo nombre cliente optendio con cliente_BServiceImpl.findByCliente_BIdCliente_a(id); "+clientTemp.getNombre_a());
		
		
		return clientTemp;

	
	}


	@RequestMapping(value="/cliente/{id}"
			, method = RequestMethod.DELETE,
			headers="Accept=application/xml, application/json")
	public @ResponseBody void delCliente_B_form(@PathVariable("id")String  id){
		logger.info(" en delcliente_B_form DELETE por id  ##### " +id);
		
		Cliente_A cliente_b= new Cliente_A();
		cliente_b= cliente_BServiceImpl.findByCliente_AIdCliente_a(id);
		logger.info(" en getClienteHTML DELETE por id ya encontrado cliente  ##### ");
	
		cliente_BServiceImpl.delete(cliente_b);
		logger.info(" en getClienteHTML DELETE por id ya borrado cliente  ##### ");
		logger.info("##### borrando cliente : ");
	}


}
