package com.krakedev.test.Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
		@Test
		public void testAgregarBrazosExitoso() {
			Alien alien = new Alien(10, "Verde"); // totalExtremidades inicial es 0 (<= 10)

			// Evaluamos la rama TRUE del if
			boolean resultado = alien.agregarBrazos(4);

			assertTrue(resultado);
			assertEquals(4, alien.getNumeroBrazos());
		}

		@Test
		public void testAgregarBrazosFallido() {
			Alien alien = new Alien(10, "Verde");
			// Primero sumamos 11 piernas para hacer que totalExtremidades supere 10
			alien.agregarPiernas(11); 

			// Evaluamos la rama FALSE del if (totalExtremidades es 11 > 10)
			boolean resultado = alien.agregarBrazos(2);

			assertFalse(resultado);
			assertEquals(0, alien.getNumeroBrazos()); // Los brazos no debieron cambiar
		}

		// -----------------------------------------------------
		// PRUEBAS PARA agregarPiernas
		// -----------------------------------------------------

		@Test
		public void testAgregarPiernasExitoso() {
			Alien alien = new Alien(10, "Azul"); // totalExtremidades inicial es 0 (<= 10)

			// Evaluamos la rama TRUE del if
			boolean resultado = alien.agregarPiernas(6);

			assertTrue(resultado);
			assertEquals(6, alien.getNumeroPies());
		}

		@Test
		public void testAgregarPiernasFallido() {
			Alien alien = new Alien(10, "Azul");
			// Sumamos 11 brazos para exceder el límite permitido
			alien.agregarBrazos(11); 

			// Evaluamos la rama FALSE del if (totalExtremidades es 11 > 10)
			boolean resultado = alien.agregarPiernas(2);

			assertFalse(resultado);
			assertEquals(0, alien.getNumeroPies()); // Las piernas no debieron cambiar
		}
		
		@Test
		public void testValidarPrecioTotal() {
			
			Alien alien = new Alien(10, "Azul");
			
			assertEquals(2, alien.getPrecioTotal(), 0.0001);
			//alien.agregarBrazos(2);
			//alien.agregarPiernas(2);
			//alien.agregarOjos(2);
			
			//assertEquals(7, alien.getPrecioTotal(), 0.0001);
			
		}
		// -----------------------------------------------------
		// PRUEBAS DE COBERTURA DE RAMAS DE "agregarOjos"
		// -----------------------------------------------------

		// Rama 1: Tamaño de 5 a 10 (Límite máximo: 3 ojos)
		@Test
		public void testAgregarOjosTamanioPequenioExitoso() {
			Alien alien = new Alien(8, "Verde"); // Rango 5 <= 8 <= 10 -> maximoOjos = 3
			boolean resultado = alien.agregarOjos(3);

			assertTrue(resultado);
			assertEquals(3, alien.getNumeroOjos());
		}

		@Test
		public void testAgregarOjosTamanioPequenioExcedido() {
			Alien alien = new Alien(8, "Verde"); // Rango 5 <= 8 <= 10 -> maximoOjos = 3
			boolean resultado = alien.agregarOjos(4); // Excede el límite de 3

			assertFalse(resultado);
			assertEquals(0, alien.getNumeroOjos());
		}

		// Rama 2: Tamaño de 11 a 20 (Límite máximo: 5 ojos)
		@Test
		public void testAgregarOjosTamanioMedianoExitoso() {
			Alien alien = new Alien(15, "Amarillo"); // Rango 10 < 15 <= 20 -> maximoOjos = 5
			boolean resultado = alien.agregarOjos(5);

			assertTrue(resultado);
			assertEquals(5, alien.getNumeroOjos());
		}

		@Test
		public void testAgregarOjosTamanioMedianoExcedido() {
			Alien alien = new Alien(15, "Amarillo"); // Rango 10 < 15 <= 20 -> maximoOjos = 5
			boolean resultado = alien.agregarOjos(6); // Excede el límite de 5

			assertFalse(resultado);
			assertEquals(0, alien.getNumeroOjos());
		}

		// Rama 3: Tamaño de 21 a 30 (Límite máximo: 7 ojos)
		@Test
		public void testAgregarOjosTamanioGrandeExitoso() {
			Alien alien = new Alien(25, "Morado"); // Rango 20 < 25 <= 30 -> maximoOjos = 7
			boolean resultado = alien.agregarOjos(7);

			assertTrue(resultado);
			assertEquals(7, alien.getNumeroOjos());
		}

		@Test
		public void testAgregarOjosTamanioGrandeExcedido() {
			Alien alien = new Alien(25, "Morado"); // Rango 20 < 25 <= 30 -> maximoOjos = 7
			boolean resultado = alien.agregarOjos(8); // Excede el límite de 7

			assertFalse(resultado);
			assertEquals(0, alien.getNumeroOjos());
		}

		// -----------------------------------------------------
		// PRUEBAS DE CÁLCULO DE PRECIO TOTAL Y COMPORTAMIENTO
		// -----------------------------------------------------

		@Test
		public void testValidarPrecioTotalInicial() {
			// Tamaño 10 -> Cuerpo: 2.0, Extremidad: 1.0, Ojo: 0.5
			Alien alien = new Alien(10, "Azul");
			
			// Inicialmente sin miembros: Total = 2.0 + (0*1.0) + (0*0.5) = 2.0
			assertEquals(2.0, alien.getPrecioTotal(), 0.0001);
		}

		@Test
		public void testValidarCalculoPrecioTotalConElementos() {
			// Tamaño 10:
			// precioCuerpo = 10 * 0.20 = 2.0
			// precioExtremidad = 10 * 0.10 = 1.0
			// precioOjo = 10 * 0.05 = 0.5
			Alien alien = new Alien(10, "Azul");

			// Agregar 2 brazos -> Subtotal extremidades = 2 * 1.0 = 2.0
			alien.agregarBrazos(2);

			// Agregar 2 piernas -> Subtotal extremidades = (2+2) * 1.0 = 4.0
			alien.agregarPiernas(2);

			// Agregar 2 ojos -> Subtotal ojos = 2 * 0.5 = 1.0
			alien.agregarOjos(2);

			// Precio Total esperado = 2.0 (Cuerpo) + 4.0 (Extremidades) + 1.0 (Ojos) = 7.0
			double precioEsperado = 2.0 + (4 * 1.0) + (2 * 0.5);
			assertEquals(7.0, alien.getPrecioTotal(), 0.0001);
		}
}
