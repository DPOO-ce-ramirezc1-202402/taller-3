package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente {
	
	private String nombre;
	
	public static final String NATURAL = "Natural";
	
	public ClienteNatural(String nombre) {
		
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String getTipoCliente() {
		// TODO Auto-generated method stub
		return NATURAL;
	}

	@Override
	public String getIdentificador() {
		// TODO Auto-generated method stub
		return "NAT-" + nombre.toUpperCase().replace(" ", "_");
	}
}
