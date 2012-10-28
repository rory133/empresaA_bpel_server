package org.proyecto.empresaA_bpel_server.mvc;

import org.apache.log4j.Logger;
import org.proyecto.empresaA_bpel_server.model.ListaProductos_ASeleccionados;
import org.proyecto.empresaA_bpel_server.model.Producto_ASeleccionado;
import org.proyecto.empresaA_bpel_server.service.impl.Producto_ASeleccionadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/productoASeleccionado")
public class Producto_ASeleccionadoController {
	
	
	protected static Logger logger = Logger.getLogger("*en Producto_ASeleccionadoController*SERVER####");
	
	
	@Autowired
	private Producto_ASeleccionadoServiceImpl producto_ASeleccionadoService;
	
	
	
	//creamos un nuevo productoSeleccionado
	@RequestMapping(value="/producto_a_seleccionado",
					method = RequestMethod.POST,
					headers="Accept=application/xml, application/json")
	public @ResponseBody void addProducto_ASeleccionado_form(@RequestBody Producto_ASeleccionado producto_ASeleccionado) {
		logger.info("salvamos un productoBSeleccionado REST server ####");
		
		producto_ASeleccionadoService.save(producto_ASeleccionado);
		

	}
	
	
	//borramos un productoSeleccionado
		@RequestMapping(value="/producto_a_seleccionado/{id}"
				, method = RequestMethod.DELETE,
				headers="Accept=application/xml, application/json")
		public @ResponseBody void delProducto_ASeleccionado(@PathVariable("id")String  id){
			logger.info(" en delProducto_ASeleccionado DELETE por id SERVIDOR ##### " +id);
			
			Producto_ASeleccionado producto_aSeleccionado= new Producto_ASeleccionado();
			producto_aSeleccionado=producto_ASeleccionadoService.findByProducto_ASeleccionadoIdProducto_a(id);
			producto_ASeleccionadoService.delete(producto_aSeleccionado);
			
		}
		
	
		//actualizamos un productoSeleccionado
		@RequestMapping(value="/producto_a_seleccionado",
						method = RequestMethod.PUT,
						headers="Accept=application/xml, application/json")
		public @ResponseBody String updateProducto_A_form(@RequestBody Producto_ASeleccionado producto_ASeleccionado) {
		
			logger.info(" en updateProducto_A_form PUT SERVIDOR ##### ");
			producto_ASeleccionadoService.update(producto_ASeleccionado);
			String idPruductoSeleccionado=String.valueOf(producto_ASeleccionado.getProducto_a().getIdproductoa());
			
			//devolvemos el id delproductoBseleccionado recien actualizado
			return idPruductoSeleccionado;

		}
		
		//encontramos un productoSeleccionado por su id
		@RequestMapping(value="/producto_a_seleccionado/{id}"
				, method = RequestMethod.GET,
				headers="Accept=application/xml, application/json")
		public @ResponseBody Producto_ASeleccionado getProductoBSeleccionadoPorId(@PathVariable("id")String  id){
			
			logger.info(" en getProductoBSeleccionadoPorId GET {id} SERVIDOR ##### ");
			
			Producto_ASeleccionado pruductoTemp=producto_ASeleccionadoService.findByProducto_ASeleccionadoIdProducto_a(id);
			return pruductoTemp;

		}
	
		//encontramos un productoSeleccionado por su id y el id del carro
		@RequestMapping(value="/producto_a_seleccionadoIDProductoIdCarro/{id}/{idCarro}"
				, method = RequestMethod.GET,
				headers="Accept=application/xml, application/json")
		public @ResponseBody Producto_ASeleccionado getProductoBSeleccionadoPorIdProductoIdCarro(@PathVariable("id")String  id,@PathVariable("idCarro")String  idCarro){
			
			logger.info(" en getProductoBSeleccionadoPorIdProductoIdCarro GET {id,idCarro} SERVIDOR ##### id "+ id +" idCarro : "+ idCarro);
			Producto_ASeleccionado pruductoTemp=producto_ASeleccionadoService.findByProducto_ASeleccionadoIdProducto_a_y_carro_a(id, idCarro);
			return pruductoTemp;

		}
		
		//encontramos lo productosSeleccionados por el id del carro
		@RequestMapping(value="/producto_a_seleccionadoIdCarro/{idCarro}"
				, method = RequestMethod.GET,
				headers="Accept=application/xml, application/json")
		public @ResponseBody ListaProductos_ASeleccionados getProductosBSeleccionadosPorIdCarro(@PathVariable("idCarro")String  idCarro){
			ListaProductos_ASeleccionados lista = new ListaProductos_ASeleccionados();
			logger.info(" en getProductosBSeleccionadosPorIdCarro {idCarro} SERVIDOR ##### idCarro : "+idCarro);
			logger.info(" tamañao lista productos selceecionados {idCarro} SERVIDOR ##### idCarro : "+producto_ASeleccionadoService.findByProducto_ASeleccionadoPorIdcarro_a(idCarro));
			lista.setDataProductoASeleccionado(producto_ASeleccionadoService.findByProducto_ASeleccionadoPorIdcarro_a(idCarro));
			return lista;

		}

}
