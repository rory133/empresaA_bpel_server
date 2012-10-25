package org.proyecto.empresaA_bpel_server.mvc;



import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.log4j.Logger;
import org.proyecto.empresaA_bpel_server.model.ListaProductos_A;
import org.proyecto.empresaA_bpel_server.model.Producto_A;
import org.proyecto.empresaA_bpel_server.service.impl.Productos_AServiceImpl;





@Controller
@RequestMapping("/productos")
public class Producto_AController {

	@Autowired
	private Productos_AServiceImpl productos_AServiceImpl;
	

	
	

	
	@Autowired
	ServletContext context;
	
	
	
	

	
	protected static Logger logger = Logger.getLogger("*en Producto_AController*SERVER####");
		
	
	
	
	
	
//enviamos a cliente la lista de todos los productos
	@RequestMapping(value="/productos",
			method=RequestMethod.GET, 
			headers="Accept=application/xml, application/json")

public @ResponseBody  ListaProductos_A listadoProductos_A(){
	logger.info("enServidor en listadoProductos REST server ####");
	//List<Cliente_A> clientes_a=cliente_AServiceImpl.findAll();

	ListaProductos_A lista=new ListaProductos_A();
	lista.setDataProducto(productos_AServiceImpl.getProductos_A());


   return lista;
}
	
	
//creamos un nuevo producto
	@RequestMapping(value="/admin/producto",
					method = RequestMethod.POST,
					headers="Accept=application/xml, application/json")
	public @ResponseBody String addProducto_A_form(@RequestBody Producto_A producto_a) {
		productos_AServiceImpl.save(producto_a);
		String idPruducto=String.valueOf(producto_a.getIdproductoa());
		
		//devolvemos el producto recien creado
		return idPruducto;

	}
//borramos un producto
	@RequestMapping(value="/producto/{id}"
			, method = RequestMethod.DELETE,
			headers="Accept=application/xml, application/json")
	public @ResponseBody void delProducto_A(@PathVariable("id")String  id){
		logger.info("SERVIDOR en delProducto_A DELETE por id  ##### " +id);
		
		Producto_A producto_a= new Producto_A();
		producto_a=productos_AServiceImpl.findByProducto_AIdProducto_a(id);
		
		productos_AServiceImpl.delete(producto_a);
		logger.info("##### borrando producto : ");
	}
	
	
	
//actutalizamos un producto
	@RequestMapping(value="/admin/producto",
					method = RequestMethod.PUT,
					headers="Accept=application/xml, application/json")
	public @ResponseBody String updateProducto_A_form(@RequestBody Producto_A producto_a) {
		productos_AServiceImpl.update(producto_a);
		logger.info("SERVIDOR en updateProducto_A_form se acaba de actualiza producto, con nombre"+producto_a.getNombre_productoA());
		logger.info("SERVIDOR en updateProducto_A_form se acaba de actualiza producto, con cantidad"+producto_a.getCantidad_existencias());
		String idProducto=String.valueOf(producto_a.getIdproductoa());
		
		//devolvemos el id delproducto recien actualizado
		return idProducto;
		
		
		
	}
	
//encontramos un producto por su id
	@RequestMapping(value="/producto/{id}"
			, method = RequestMethod.GET,
			headers="Accept=application/xml, application/json")
	public @ResponseBody Producto_A getProductoPorId(@PathVariable("id")String  id){
		
		logger.info(" en servidor en getProductoPorId  ##### " +id);
		
		Producto_A pruductoTemp= productos_AServiceImpl.findByProducto_AIdProducto_a(id);
		return pruductoTemp;

	}
	

	
}