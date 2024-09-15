package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Ruta;

public abstract class CalculadoraTarifas {
	
	private Vuelo vuelo;
	private Cliente cliente;
	private Ruta ruta;
	
	public static final double IMPUESTO = 0.28;
	
	public int calcularTarifa (Vuelo vuelo, Cliente cliente, Ruta ruta) {
		
		int costoBase = calcularCostoBase(vuelo, cliente);
		
		double porcentajeDescuento = calcularPorcentajeDescuento(cliente);
		
		int costoConDescuento = (int) (costoBase * (1-porcentajeDescuento));
		
		int valorImpuestos = calcularValorImpuestos(costoConDescuento);
		
		int total = costoConDescuento + valorImpuestos;
		
		return total;
		
	}
	
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	protected abstract int calcularDistanciaVuelo(Ruta ruta);
	protected int calcularValorImpuestos(int costoBase) {
		return (int) (costoBase * IMPUESTO);
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

}
