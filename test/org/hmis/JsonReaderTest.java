package org.hmis;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JsonReaderTest {
	static Stream<Arguments> Coches(){
		String Marca="Toyota";
		String Modelo="Corolla";
		int año=2022;
		int precio=22000;
		return Stream.of(
				
				Arguments.of(Marca, Modelo,año,precio));
		}
	@ParameterizedTest
	@CsvSource("data/coches.json")
	void testLeerCochesJSON(String ruta) {
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals (4, coches.length);
	}

	@ParameterizedTest
	@MethodSource("Coches")
	void testLeerCochesJSONprimero(String Marca,String Modelo,int año,int precio) {
		String ruta = "data/coches.json";
		;
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals( new Coche (Marca,Modelo ,año ,precio ), coches[0]);
		assertTrue ( new Coche (Marca,Modelo ,año ,precio ).equals(coches[0]));
		assertTrue (coches[0].equals( new Coche (Marca,Modelo ,año ,precio )));
	}


}
