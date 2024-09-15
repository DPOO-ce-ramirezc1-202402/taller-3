package uniandes.dpoo.aerolinea.modelo.cliente;

import org.json.JSONObject;

/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son empresas
 */
public class ClienteCorporativo extends Cliente
{

	private String nombreEmpresa;
	private int tamanioEmpresa;
	
	public static final String CORPORATIVO = "Corporativo";
	public static final int GRANDE = 1;
	public static final int MEDIANO = 2;
	public static final int PEQUENA = 3;
	
	public ClienteCorporativo(String nombreEmpresa, int tamanioEmpresa) {
		
		this.nombreEmpresa = nombreEmpresa;
		this.tamanioEmpresa = tamanioEmpresa;
	}
    
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public int getTamanioEmpresa() {
		return tamanioEmpresa;
	}

	public void setTamanioEmpresa(int tamanioEmpresa) {
		this.tamanioEmpresa = tamanioEmpresa;
	}
	
	@Override
	public String getTipoCliente() {
		// TODO Auto-generated method stub
		return CORPORATIVO;
	}

	@Override
	public String getIdentificador() {
		// TODO Auto-generated method stub
		return "CORP-" + nombreEmpresa.toUpperCase().replace(" ", "_");
	}

    /**
     * Crea un nuevo objeto de tipo a partir de un objeto JSON.
     * 
     * El objeto JSON debe tener dos atributos: nombreEmpresa (una cadena) y tamanoEmpresa (un número).
     * @param cliente El objeto JSON que contiene la información
     * @return El nuevo objeto inicializado con la información
     */
    public static ClienteCorporativo cargarDesdeJSON( JSONObject cliente )
    {
        String nombreEmpresa = cliente.getString( "nombreEmpresa" );
        int tam = cliente.getInt( "tamanoEmpresa" );
        return new ClienteCorporativo( nombreEmpresa, tam );
    }

    /**
     * Salva este objeto de tipo ClienteCorporativo dentro de un objeto JSONObject para que ese objeto se almacene en un archivo
     * @return El objeto JSON con toda la información del cliente corporativo
     */
    public JSONObject salvarEnJSON( )
    {
        JSONObject jobject = new JSONObject( );
        jobject.put( "nombreEmpresa", this.nombreEmpresa );
        jobject.put( "tamanoEmpresa", this.tamanoEmpresa );
        jobject.put( "tipo", CORPORATIVO );
        return jobject;
    }

	

	
}
