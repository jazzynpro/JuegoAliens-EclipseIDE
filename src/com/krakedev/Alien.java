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
		this.precioCuerpo = tamanio * 0.20;
		this.precioExtremidad = tamanio * 0.10;
		this.precioOjo = tamanio * 0.5;
	}
}
