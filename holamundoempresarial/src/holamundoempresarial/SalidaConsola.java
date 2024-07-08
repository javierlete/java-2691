package holamundoempresarial;

public class SalidaConsola implements Salida {
	@Override
	public void enviar(String mensaje) {
		System.out.println(mensaje);
	}
}
