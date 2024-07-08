package holamundoempresarial;

public class SalidaConsolaFormateada implements Salida {
	@Override
	public void enviar(String mensaje) {
		System.out.printf("*** %s ***%n", mensaje);
	}
}
