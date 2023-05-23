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
		String Marca1="Toyota";
		String Modelo1="Corolla";
		int año1=2022;
		int precio1=22000;
		boolean result1= true;
		String Marca2="Jeep";
		String Modelo2="Wrangler";
		int año2=2021;
		int precio2=70000;
		boolean result2= false;
		return Stream.of(
				Arguments.of(new Coche(Marca1, Modelo1,año1,precio1),result1),
				Arguments.of(new Coche(Marca2, Modelo2,año2,precio2),result2)
				);
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
	void testLeerCochesJSONprimero(Coche coche,boolean expected) {
		
		String ruta = "data/coches.json";
		
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals(expected,coche.equals(coches[0]));
		assertEquals(expected,coches[0].equals(coche));
	}


}
