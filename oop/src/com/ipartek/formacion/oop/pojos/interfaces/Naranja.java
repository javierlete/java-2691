package com.ipartek.formacion.oop.pojos.interfaces;

public class Naranja extends Fruto implements Rodable, Comestible {
	private boolean porElSuelo = false;
	
	@Override
	public void comer() {
		if(porElSuelo) {
			System.out.println("PUAGH QUE ASCO");
		} else {
			System.out.println("Ñam que rica");
		}
	}

	@Override
	public void rodar() {
		porElSuelo = true;
		
		System.out.println("Naranja rodando y ensuciándose");
	}

}
