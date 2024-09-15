package uniandes.dpoo.aerolinea.modelo;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;

public class Vuelo {
	
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private List<Tiquete> listaTiquetes;
	
	public Vuelo(Ruta ruta, String fecha, Avion avion) {
		
		this.ruta = ruta;
		this.fecha = fecha;
		this.avion = avion;
		this.listaTiquetes = new ArrayList<>();
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public void setListaTiquetes(List<Tiquete> listaTiquete) {
		this.listaTiquetes = listaTiquete;
	}

	public List<Tiquete> getListaTiquetes() {
		return listaTiquetes;
	}
	
	public void agregarTiquete(Tiquete tiquete) throws VueloSobrevendidoException {
		listaTiquetes.add(tiquete);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Vuelo vuelo = (Vuelo) obj;
		return fecha.equals(vuelo.fecha) && ruta.equals(vuelo.ruta) && avion.equals(vuelo.avion);
	}
	
	public boolean esTemporadaAlta() {
		String [] partesFecha = this.fecha.split("-");
		int mes = Integer.parseInt(partesFecha[1]);
		
		return (mes == 6 || mes == 7 || mes == 8 || mes == 12);
	}
	
	
	
}
