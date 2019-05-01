package br.com.cesed.p3;

import java.util.ArrayList;
import java.util.Arrays;

/***
 * 
 * @author tessa
 *
 * @param <T>
 */
public class MeuArray<T> {
	/***
	 * Definir o tamanho inicial do array
	 */
	private static int TAMANHO_INICIAL = 5;

	/***
	 * Definir o tamanho atual do array após as inserções
	 */
	private int tamanho;

	
	/***
	 * Definição do array
	 */
	@SuppressWarnings("unchecked")
	T[] array = (T[]) new Object[TAMANHO_INICIAL];

	/***
	 * Metodo para adicionar um objeto ao arraylist
	 * @param obj
	 */
	@SuppressWarnings("unchecked")
	public void add(T obj) {
		if (tamanho == array.length) {
			int tamanhoAtual = array.length + TAMANHO_INICIAL;
			T[] aux = (T[]) new Object[tamanhoAtual];
			for (int i = 0; i < tamanho; i++) {
				aux[i] = array[i];
			}
			array = aux;
		}
		if (obj != null) {
			array[tamanho] = obj;
			tamanho++;
		} else {
			throw new NullPointerException();
		}

	}
/***
 * Metodo para add um objeto no ArrayList em uma determinada posição pedida
 * @param index
 * @param obj
 */
	public void add(int index, T obj) {
		if (!obj.equals(null)) {
			for (int i = array.length - 1; i > index; i--) {
				array[i] = array[i - 1];
			}
			array[index] = obj;

		} else{
			throw new NullPointerException();
		}

	}
/***
 * Metodo para remover um objeto dado uma determinada posição
 * @param index
 */
	public void remove(int index) {
		if (index <= tamanho) {
			array[index] = null;
			for (int i = index; i < tamanho; i++) {
				array[i] = array[i + 1];

			}
			tamanho--;
		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	/***
	 * Metodo para remover o objeto passado no parametro
	 * @param obj
	 */
	public void remove(T obj) {
		if (obj != null) {
			for (int i = 0; i < tamanho; i++) {
				if (obj.equals(array[i])) {
					array[i] = null;
					for (int j = i; j < tamanho - 1; j++) {
						array[j] = array[j + 1];
					}
				}

			}
		} else {
			throw new NullPointerException();
		}
		tamanho--;
	}

	/***
	 * Metodo que retorna um objeto passando a posição que ele se encontra
	 * @param index
	 * @return posição do array
	 */
	public T get(int index) {
		if (index > tamanho || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}
/***
 * Metodo que retorna o tamanho do arraylist
 * @return tamanho
 */
	public int size() {
		return tamanho;
	}
/***
 * Metodo que limpa o arrayList
 */
	@SuppressWarnings({ "unchecked", "unused" })
	public void clear() {
		T[] array = (T[]) new Object[TAMANHO_INICIAL];
		tamanho = 0;
	}
/***
 * Metodo que retorna true ou false se existir um objeto na Lista
 * @param obj
 * @return
 */
	public boolean contains(T obj) {
		boolean condicao = false;

		if (obj != null) {
			for (int i = 0; i < tamanho; i++) {
				if (array[i].equals(obj)) {
					condicao = true;
				}
			}
		} else {
			throw new NullPointerException();
		}

		return condicao;
	}
/***
 * Metodo para saber se a lista esta vazia
 * @return
 */
	public boolean isEmpty() {
		return tamanho == 0;
	}

/***
 * Metodo para clonar uma lista
 * @return lista clonada
 */
	public MeuArray<T> clone(){
		
		MeuArray<T> aux = new MeuArray<T>();
		for(int i = 0; i<tamanho; i++) {
			aux.add(array[i]);
		}
		
		return aux;
		
	}

	@Override
	public String toString() {
		return "MeuArray [ array=" + Arrays.toString(array) + "]";
	}

}
