package org.proyecto.empresaA_bpel_server.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "listaProductosabSeleccionados")
public class ListaProductos_ASeleccionados {
	private List<Producto_ASeleccionado> dataProductoASeleccionado;

	public List<Producto_ASeleccionado> getDataProductoASeleccionado() {
		return dataProductoASeleccionado;
	}

	public void setDataProductoBSeleccionado(
			List<Producto_ASeleccionado> dataProductoASeleccionado) {
		this.dataProductoASeleccionado = dataProductoASeleccionado;
	}

	
	
	
}
