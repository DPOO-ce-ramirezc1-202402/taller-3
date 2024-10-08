package uniandes.dpoo.aerolinea.modelo;

/**
 * Esta clase tiene la información de una ruta entre dos aeropuertos que cubre una aerolínea.
 */
public class Ruta
{
	private String horaSalida;
	private String horaLlegada;
	private String codigoRuta;
	private Aeropuerto origen;
	private Aeropuerto destino; 
	
	public Ruta(Aeropuerto origen, Aeropuerto destino, String horaSalida,String horaLlegada, String codigoRuta) {
		
		this.codigoRuta = codigoRuta;
		this.setDestino(destino);
		this.setOrigen(origen);
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida; 
	}
	
	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getCodigoRuta() {
		return codigoRuta;
	}

	public void setCodigoRuta(String codigoRuta) {
		this.codigoRuta = codigoRuta;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public Aeropuerto getOrigen() {
		return origen;
	}

	public void setOrigen(Aeropuerto origen) {
		this.origen = origen;
	}

	public Aeropuerto getDestino() {
		return destino;
	}

	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}
	
	public int getDuracion() {
		
		int horasSalida = getHoras(horaSalida);
		int minutosSalida = getMinutos(horaSalida);
		
		int horasLlegada = getHoras(horaLlegada);
		int minutosLlegada = getMinutos(horaLlegada);
		
		int totalMinSalida = (horasSalida*60) + minutosSalida;
		int totalMinLlegada = (horasLlegada*60) + minutosLlegada;
		
		if (totalMinLlegada < totalMinSalida ) {
			totalMinLlegada += 24 * 60;
		}
		return totalMinLlegada - totalMinSalida;
	}

    /**
     * Dada una cadena con una hora y minutos, retorna los minutos.
     * 
     * Por ejemplo, para la cadena '715' retorna 15.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de minutos entre 0 y 59
     */
    public static int getMinutos( String horaCompleta )
    {
        int minutos = Integer.parseInt( horaCompleta ) % 100;
        return minutos;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna las horas.
     * 
     * Por ejemplo, para la cadena '715' retorna 7.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de horas entre 0 y 23
     */
    public static int getHoras( String horaCompleta )
    {
        int horas = Integer.parseInt( horaCompleta ) / 100;
        return horas;
    }

	
	
	
    
}
