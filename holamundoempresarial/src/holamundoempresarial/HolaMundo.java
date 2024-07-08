package holamundoempresarial;

import java.io.IOException;

public class HolaMundo {
	public static void main(String[] args) throws IOException {
		Fabrica fabrica = new FabricaImpl();
		
		Salida salida = fabrica.obtenerSalida();
		Entrada entrada = fabrica.obtenerEntrada();
		
		salida.enviar(entrada.recibir());
	}
}
