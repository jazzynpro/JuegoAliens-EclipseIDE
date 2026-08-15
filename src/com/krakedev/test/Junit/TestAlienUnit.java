package com.krakedev.test.Junit;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.Alien;

public class TestAlienUnit {
	@Test
	public void testTamanioYPreciobase() {
		Alien a1 = new Alien(66, "Rojo");
		assertEquals(30, a1.getTamanio(), 0.0001);
		assertEquals(6, a1.getPrecioCuerpo(), 0.0001);
		assertEquals(3, a1.getPrecioExtremidad(), 0.0001);
		assertEquals(1.5, a1.getPrecioOjo(), 0.0001);
		
		a1.imprimir(); }
		
		// Rama 1: Tamaño menor a 5 (Debe ajustarse a 5)
		@Test
		public void testConstructorTamanioMenorA5() {
			Alien alienPeque = new Alien(2, "Verde");

			// Comprobar que el tamaño se corrigió a 5
			assertEquals(5, alienPeque.getTamanio());
			assertEquals("Verde", alienPeque.getColor());

			// Comprobar los precios calculados basados en el tamaño 5
			assertEquals(1.00, alienPeque.getPrecioCuerpo(), 0.0001);     // 5 * 0.20
			assertEquals(0.50, alienPeque.getPrecioExtremidad(), 0.0001); // 5 * 0.10
			assertEquals(0.25, alienPeque.getPrecioOjo(), 0.0001);        // 5 * 0.05
		}

		// Rama 2: Tamaño mayor a 30 (Debe ajustarse a 30)
		@Test
		public void testConstructorTamanioMayorA30() {
			Alien alienGigante = new Alien(50, "Azul");

			// Comprobar que el tamaño se corrigió a 30
			assertEquals(30, alienGigante.getTamanio());
			assertEquals("Azul", alienGigante.getColor());

			// Comprobar precios calculados basados en el tamaño 30
			assertEquals(6.00, alienGigante.getPrecioCuerpo(), 0.0001);     // 30 * 0.20
			assertEquals(3.00, alienGigante.getPrecioExtremidad(), 0.0001); // 30 * 0.10
			assertEquals(1.50, alienGigante.getPrecioOjo(), 0.0001);        // 30 * 0.05
		}

		// Rama 3: Tamaño en el rango válido entre 5 y 30 (Se mantiene el valor ingresado)
		@Test
		public void testConstructorTamanioValidoYMetodoImprimir() {
			Alien alienNormal = new Alien(10, "Rojo");

			// Comprobar que se mantiene el tamaño de 10
			assertEquals(10, alienNormal.getTamanio());
			assertEquals("Rojo", alienNormal.getColor());

			// Comprobar valores por defecto de enteros (0)
			assertEquals(0, alienNormal.getNumeroOjos());
			assertEquals(0, alienNormal.getNumeroBrazos());
			assertEquals(0, alienNormal.getNumeroPies());

			// Comprobar precios calculados basados en el tamaño 10
			assertEquals(2.00, alienNormal.getPrecioCuerpo(), 0.0001);     // 10 * 0.20
			assertEquals(1.00, alienNormal.getPrecioExtremidad(), 0.0001); // 10 * 0.10
			assertEquals(0.50, alienNormal.getPrecioOjo(), 0.0001);        // 10 * 0.05

			// Ejecución del método imprimir para cubrir la totalidad de líneas de la clase
			alienNormal.imprimir();
		}
}
