package com.kfallas.proyecto.sample.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SampleTests {

	
	@Test
	void suma() {
		Integer resultado = 1+1;
		assertEquals(2, resultado);
	}
	
	@Test
	void resta() {
		Integer resultado = 3-1;
		assertEquals(2, resultado);
	}
}
