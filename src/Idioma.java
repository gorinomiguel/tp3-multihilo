import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Idioma {

	public static void leerIdiomas() throws Throwable {

		File txtBaseIdiomas = null;
		FileReader fr = null;
		BufferedReader br = null;
		String linea;
			
		txtBaseIdiomas = new File("C:\\Users\\Hernán\\Documents\\Facultad\\Sistemas de Procesamiento\\base_idiomas.txt");
		fr = new FileReader(txtBaseIdiomas);
		br = new BufferedReader(fr);
		
		String idiomaActual = "";
		String idiomaAnterior = "";
		
		while ((linea = br.readLine()) != null) {
			String listaarray[] = linea.split("\\Q|\\E");
			idiomaActual = listaarray[0].trim();
	
			if (!(idiomaAnterior.equalsIgnoreCase(idiomaActual))) {
				Global.cantidadLetrasIdioma = new HashMap<String, BigDecimal>();
				Global.cantidadLetrasIdioma.put(listaarray[1], new BigDecimal(listaarray[2]));
				Global.listaIdiomas.put(idiomaActual, Global.cantidadLetrasIdioma);
			} else {
				Global.cantidadLetrasIdioma.put(listaarray[1], new BigDecimal(listaarray[2]));
			}
	
			idiomaAnterior = listaarray[0].trim();
		}
	}
}
