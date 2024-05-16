package com.ipartek.formacion.basicos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Colecciones {
	public static void main(String[] args) {
		ejemploListas();
		
		ejemploConjuntos();
		
		ejemploMapas();
	}
	
	private static void ejemploListas() {
		var lista = new ArrayList<String>();
		
		lista.add("Uno");
		lista.add("Dos");
		lista.add("Tres");
		lista.add("Tres");
		
		lista.remove("Dos");
		lista.add(0, "Cero");
		
		for(var dato: lista) {
			System.out.println(dato);
		}
		
		var i = lista.iterator();
		
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		System.out.println(lista.get(0));
		
		System.out.println(lista);
	}

	private static void ejemploConjuntos() {
		var conjunto = new HashSet<String>();
		
		conjunto.add("Uno");
		conjunto.add("Dos");
		conjunto.add("Dos");
		conjunto.add("Tres");
		
		System.out.println(conjunto);
	}

	private static void ejemploMapas() {
		var mapa = new HashMap<String, Integer>();
		
		mapa.put("Uno", 1);
		mapa.put("Dos", 2);
		
		System.out.println(mapa.get("Dos"));
		
		System.out.println(mapa);
		
		for(var par: mapa.entrySet()) {
			System.out.println(par.getKey() + ": " + par.getValue());
		}
		
		for(var clave: mapa.keySet()) {
			System.out.println(clave + ": " + mapa.get(clave));
		}
		
		for(var valor: mapa.values()) {
			System.out.println(valor);
		}
	}
}
