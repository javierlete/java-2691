package holamundoempresarial;

import java.io.IOException;
import java.util.Properties;

public class FabricaImpl implements Fabrica {
	private Salida salida;
	private Entrada entrada;

	public FabricaImpl() throws IOException {
		Properties props = new Properties();
		props.load(ClassLoader.getSystemResourceAsStream("holamundoempresarial.properties"));

		String claseSalida = props.getProperty("salida");
		String claseEntrada = props.getProperty("entrada");

		try {
			salida = (Salida) Class.forName(claseSalida).getConstructor().newInstance();
			entrada = (Entrada) Class.forName(claseEntrada).getConstructor().newInstance();
		} catch (Exception e) {
			throw new IOException("No se pudo crear la fabrica: " + e.getMessage());
		}
	}

	@Override
	public Salida obtenerSalida() {
		return salida;
	}

	@Override
	public Entrada obtenerEntrada() {
		return entrada;
	}

}
