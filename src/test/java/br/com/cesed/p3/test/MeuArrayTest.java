package br.com.cesed.p3.test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.cesed.p3.MeuArray;

public class MeuArrayTest {

	MeuArray<String> array;

	@Before
	public void setUp() throws Exception {

		array = new MeuArray<String>();
	}

	@Test
	public void testAdd() {

		for (int i = 0; i < 6; i++) {
			array.add("Teste " + i);
		}
		assertEquals(6, array.size());

		assertEquals("Teste 1", array.get(1));

		assertThrows(NullPointerException.class, () -> {
			array.add(null);
		});

	}

	@Test
	public void testAddInt() {
		array.add("Claudio");
		array.add(0, "Claudio1");
		assertEquals("Claudio1", array.get(0));
		assertEquals("Claudio", array.get(1));

		assertThrows(IndexOutOfBoundsException.class, () -> {
			array.add(10, "12354");
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			array.add(-1, "12354");
		});

	}

	@Test
	public void testRemoveInt() {
		array.add("Claudio Aragao");
		array.add("1234546");
		array.add("7892325");
		assertEquals(3, array.size());
		array.remove(0);
		assertEquals(2, array.size());
		assertThrows(IndexOutOfBoundsException.class, () -> {
			array.remove(-1);
		});
		
	}

	@Test
	public void testRemove() {
		array.add("teste");
		array.add("teste1");
		array.add("teste3");
		array.remove("teste");
		assertEquals("teste3", array.get(1));
		assertEquals(2, array.size());
		assertThrows(NullPointerException.class, () -> {
			array.remove(null);
		});
		
		array.clear();
		array.add("teste");
		array.add("teste");
		array.add("teste");
		array.add("1");
		array.remove("teste");
		assertEquals(3, array.size());	
		assertEquals("teste", array.get(0));
		

	}

	@Test
	public void testGet() {
		array.add("Celular 1");
		array.add("Televisao");
		array.add("Computador");
		assertEquals("Celular 1", array.get(0));

		assertThrows(IndexOutOfBoundsException.class, () -> {
			array.get(-1);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			array.get(4);
		});
		array.remove(0);
		assertEquals("Televisao", array.get(0));
	}

	@Test
	public void testSize() {
		assertEquals(0, array.size());
		array.add("Carro");
		assertEquals(1, array.size());
	}

	@Test
	public void testClear() {
		array.add("1");
		assertEquals(1, array.size());
		array.clear();
		assertEquals(0, array.size());
		assertTrue(array.isEmpty());
		array.add("2");
		array.add("3");
		assertEquals(2, array.size());

	}

	@Test
	public void testContains() {
		array.add("qwert");
		array.add("1");
		assertTrue(array.contains("1"));
		assertFalse(array.contains("a"));
		array.remove(1);
		assertFalse(array.contains("1"));

	}

	@Test
	public void testIsEmpty() {
		assertTrue(array.isEmpty());
		array.add("Teste1");
		assertFalse(array.isEmpty());

	}
	
	@Test
	public void testClone() {
		MeuArray<String> aux1; 
		array.add("1");
		array.add("2");
		array.add("3");
		aux1 = array.clone();
		assertTrue(array.toString().equals(aux1.toString()));
		

	}

}
