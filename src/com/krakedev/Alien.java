package com.krakedev;
//Atributos privados
public class Alien {
	private int tamanio;
	private String color;
	private int numeroOjos;
	private int numeroBrazos;
	private int numeroPies;
	private double precioExtremidad;
	private double precioOjo;
	private double precioCuerpo;
	
//constructor que recibe tamaño y color
	public Alien (int tamanio, String color) {
		//validaciones
		if(tamanio < 5) {
			this.tamanio = 5;
		}else if(tamanio > 30) {
			this.tamanio = 30;
		}else {
			this.tamanio = tamanio;
		}
		// calculo de precios
		this.color = color;
		this.precioCuerpo = this.tamanio * 0.20;
		this.precioExtremidad = this.tamanio * 0.10;
		this.precioOjo = this.tamanio * 0.05;
	}
//Metodos get para todos los atributos

	public int getTamanio() {
		return tamanio;
	}

	public String getColor() {
		return color;
	}

	public int getNumeroOjos() {
		return numeroOjos;
	}

	public int getNumeroBrazos() {
		return numeroBrazos;
	}

	public int getNumeroPies() {
		return numeroPies;
	}

	public double getPrecioExtremidad() {
		return precioExtremidad;
	}

	public double getPrecioOjo() {
		return precioOjo;
	}

	public double getPrecioCuerpo() {
		return precioCuerpo;
	}
	
	//Metodo imprimir
	public void imprimir() {
		String mensaje= "-------DATOS ALIENS-------" +
				" Tamaño:" + tamanio +
				" Color:" + color +
				" Numero de Ojos:" + numeroOjos +
				" Numero de Brazos:" + numeroBrazos+
				" Numero de pies:"+numeroPies+
				" Precio de Extremidad:"+precioExtremidad+
				" Precio de ojo:"+precioOjo+
				" Precio de cuerpo:"+precioCuerpo;
		System.out.println(mensaje);
	}
	//Metodo agregarBrazos
	public boolean agregarBrazos(int cantidadBrazos) {
		int totalExtremidades = this.numeroBrazos + this.numeroPies;
		if(totalExtremidades <= 10) {
			this.numeroBrazos = this.numeroBrazos + cantidadBrazos;
			return true;
		}else{
			return false;
	}
		
	}
}
