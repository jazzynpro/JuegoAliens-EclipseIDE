package com.krakedev.test;

import com.krakedev.Alien;

public class TestConstructores {

	public static void main(String[] args) {
		//Instanciar objetos
		Alien alien1 = new Alien(15, "Azul");
		Alien alien2 = new Alien(36, "Verde");
		
		alien1.imprimir();
		alien2.imprimir();
	}

}
