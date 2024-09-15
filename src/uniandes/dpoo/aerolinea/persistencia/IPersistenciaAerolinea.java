package uniandes.dpoo.aerolinea.persistencia;

import uniandes.dpoo.aerolinea.modelo.Aerolinea;

public interface IPersistenciaAerolinea {
	
	public void cargarAerolineas(String archivo, Aerolinea aerolinea) throws Exception;
	
	public void salvarAerolineas(String archivo, Aerolinea aerolinea) throws Exception;

}
