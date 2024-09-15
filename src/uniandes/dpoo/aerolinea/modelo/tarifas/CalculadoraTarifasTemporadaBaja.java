package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{
	
	protected final int COSTO_POR_KM_CORPORATIVO = 900;
	protected final int COSTO_POR_KM_NATURAL = 600;
	protected final double DESCUENTOS_GRANDES = 0.2;
	protected final double DESCUENTOS_MEDIANAS = 0.1;
	protected final double DESCUENTOS_PEQ = 0.02;
	
	@Override
	protected int calcularDistanciaVuelo(Ruta ruta) {
		// TODO Auto-generated method stub
		Aeropuerto origen = ruta.getOrigen();
		Aeropuerto destino = ruta.getDestino();
		
		int distancia = Aeropuerto.calcularDistancia(origen, destino);
		
		return distancia;
	}

	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		Ruta ruta = vuelo.getRuta();
		int distancia = calcularDistanciaVuelo(ruta);
		
		int costoBase = 0;
		
		if (cliente instanceof ClienteCorporativo) {
			costoBase = distancia * COSTO_POR_KM_CORPORATIVO;
		} else if (cliente instanceof ClienteNatural){
			costoBase = distancia * COSTO_POR_KM_NATURAL;
		}
		return costoBase;
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		double descuento = 0;
		
		if (cliente instanceof ClienteCorporativo) {
			
			ClienteCorporativo corporativo = (ClienteCorporativo) cliente;
			int tamanioEmpresa = corporativo.getTamanioEmpresa();
			
			switch (tamanioEmpresa) {
				case ClienteCorporativo.GRANDE:
					descuento = DESCUENTOS_GRANDES;
					break;
				
				case ClienteCorporativo.MEDIANO:
					descuento = DESCUENTOS_MEDIANAS;
					break;
				
				case ClienteCorporativo.PEQUENA:
					descuento = DESCUENTOS_PEQ;
					break;
			}
		} else if (cliente instanceof ClienteNatural){
			
			descuento = 0;
			
		}
		return descuento;
	}
}
































