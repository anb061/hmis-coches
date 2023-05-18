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
				
				Arguments.of(new Coche(Marca, Modelo,año,precio)));
		}
	@ParameterizedTest
	@CsvSource({"data/coches.json,4" ,"noExiste,0"})
	void testLeerCochesJSON(String ruta,int tamano) {
		JsonReader js=new JsonReader();
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
		if (coches!=null) {
			assertEquals (tamano, coches.length);
		}else {
			assertNull(coches);
		}
		
		
	}

	@ParameterizedTest
	@MethodSource("Coches")
	void testLeerCochesJSONprimero(Coche coche) {
		
		String ruta = "data/coches.json";
		
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals( coche, coches[0]);
		assertTrue (coche.equals(coches[0]));
		assertTrue (coches[0].equals(coche));
	}


}
