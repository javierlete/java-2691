package com.ipartek.formacion.oop.pruebas;

import java.util.ArrayList;

import com.ipartek.formacion.oop.pojos.interfaces.Balon;
import com.ipartek.formacion.oop.pojos.interfaces.Comestible;
import com.ipartek.formacion.oop.pojos.interfaces.Naranja;
import com.ipartek.formacion.oop.pojos.interfaces.Rodable;

public class InterfacesPrueba {
	public static void main(String[] args) {
		var bolsa = new ArrayList<Rodable>();
		
		bolsa.add(new Naranja());
		bolsa.add(new Balon());
		
		for(var elemento: bolsa) {
			if(elemento instanceof Comestible c) {
				c.comer();
			}

			elemento.rodar();
			
			if(elemento instanceof Comestible c) {
				c.comer();
			}
		}
	}
}
