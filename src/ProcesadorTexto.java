import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcesadorTexto {

	public static void main(String[] arg) throws Throwable {

		String linea; 
		String ruta = "";
		Frecuencia frec = new Frecuencia();
		Idioma idioma = new Idioma();

		FileReader fr = null;
		BufferedReader br = null;
		File texto = null;

		System.out.println("Por favor, ingresar la ruta del directorio en donde se encuentra el archivo de texto a procesar:");
		Scanner scanner = new Scanner(System.in);
		ruta = scanner.nextLine();
		
		long startTime = System.currentTimeMillis();

		texto = new File(ruta);
		fr = new FileReader(texto);
		br = new BufferedReader(fr);

		ExecutorService threadPool = Executors.newFixedThreadPool(10);

		while ((linea = br.readLine()) != null) {

			Archivo tarea = new Archivo(linea);
			threadPool.execute(tarea);
		}

		threadPool.shutdown();

		while (!threadPool.isTerminated()) {
		}

		frec.calcularFrecuencia();	
		idioma.leerIdiomas();
		frec.compararIdiomas();

		long endTime = System.currentTimeMillis();
		long totalTime = (endTime - startTime) / 1000;
		System.out.println("Tiempo de ejecucion: " + totalTime + " segs");
	}
}