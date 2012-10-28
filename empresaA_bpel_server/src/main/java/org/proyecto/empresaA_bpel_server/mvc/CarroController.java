package org.proyecto.empresaA_bpel_server.mvc;






import org.apache.log4j.Logger;
import org.proyecto.empresaA_bpel_server.model.Carro_A;
import org.proyecto.empresaA_bpel_server.model.ListaCarros_A;
import org.proyecto.empresaA_bpel_server.service.impl.Carro_AServiceImpl;
import org.proyecto.empresaA_bpel_server.util.Mail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@Scope("session")
@RequestMapping("/carro")
@SessionAttributes("carro_A")
public class CarroController {


	

	
	@Autowired
	Carro_AServiceImpl carro_AService;
	

	
	
	@Autowired
	private Mail mail;
	
	
	
	protected static Logger logger = Logger.getLogger("*en CarroController*");
	
	
	//creamos un nuevo carro
	@RequestMapping(value="/carro_a",
					method = RequestMethod.POST,
					headers="Accept=application/xml, application/json")
	public @ResponseBody Carro_A addCarro_A_form(@RequestBody Carro_A carro_a) {
		logger.info("salvamos un carro REST server ####");
		//Carro_A carro_a =new Carro_A();
		carro_AService.save(carro_a);
		
		//devolvemos el id delproducto recien creado
		return carro_a;

	}
	
	//actualizamos un carro
	@RequestMapping(value="/carro_a",
					method = RequestMethod.PUT,
					headers="Accept=application/xml, application/json")
	public @ResponseBody Carro_A updateCarro_A_form(@RequestBody Carro_A carro_a) {
		logger.info("actualizar un carro REST server ####");
		carro_AService.update(carro_a);
		//devolvemos el id delproducto recien creado
		return carro_a;
	
	}
	
	
	//borramos un carro
	@RequestMapping(value="/carro_a/{id}",
					method = RequestMethod.DELETE,
					headers="Accept=application/xml, application/json")
	public @ResponseBody void deleteCarro_A_form(@PathVariable("id")String  id) {
		logger.info("borrar un carro REST server ####");
		
		Carro_A carro_a=carro_AService.findByCarro_AIdCarro_a(id);
		carro_AService.delete(carro_a);
		
		
	
	}
	
	//obtener un carro
	@RequestMapping(value="/carro_a/{id}",
					method = RequestMethod.GET,
					headers="Accept=application/xml, application/json")
	public @ResponseBody Carro_A getCarro_A_form(@PathVariable("id")String  id) {
		logger.info("obtener un carro por el id REST server #### id: "+ id);
		return carro_AService.findByCarro_AIdCarro_a(id);
	
	}
	
	
	//obtener todos los carros	
@RequestMapping(value="/carros",
			method=RequestMethod.GET, 
			headers="Accept=application/xml, application/json")

public @ResponseBody  ListaCarros_A listadoCarros_A(){
	logger.info("listado de todos los carros REST server ####");
	//List<Cliente_A> clientes_a=cliente_AServiceImpl.findAll();
	
/*	ListaCarros_A lista=new ListaCarros_A();
	lista.setDataCarro(carro_AService.findAll());*/
	
	
	ListaCarros_A lista=new ListaCarros_A();
	lista.setDataCarro(carro_AService.findAll());
	if (lista.getDataCarro().isEmpty())
		lista=null;
	
   return lista;
   
   
   
   
   
   
   
   
}
	
//realizamos pago carro
@RequestMapping(value="/pagarCarro",
				method = RequestMethod.PUT,
				headers="Accept=application/xml, application/json")

public void pagarCarro( @RequestBody Carro_A carro_a) {
	
	logger.info("marcando carro como pagado REST server #### id: "+ carro_a.getIdcarro_a());
	
	
	carro_a.setPagado(true);
	carro_AService.update(carro_a);
	
	String content="apreciado usuario le informamos que el pago de su pedido numero "+carro_a.getIdcarro_a()+" se ha realizado con exito, en breve le informaremos al realziar el envio";
	String subject="pedido: "+carro_a.getIdcarro_a();		
	mail.sendMail( carro_a.getCliente_a().getLogin_usuario_a(), content, carro_a.getCliente_a().getEmail_a(), subject);


}
	
	
}

	

