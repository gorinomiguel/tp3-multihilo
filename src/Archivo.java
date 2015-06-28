import java.util.concurrent.atomic.AtomicInteger;

public class Archivo implements Runnable {
	String linea;
	
	public Archivo(String linea){
		this.linea = linea;
	}
 
	@Override
	public void run() {
		char caracter;

		for (int i = 0; i < this.linea.length(); i++) {
			caracter = Character.toLowerCase(this.linea.charAt(i));
			if (Character.isLetter(caracter)) {
				if (Global.cantidadLetras.containsKey(caracter)) {
					Global.cantidadLetras.get(caracter).incrementAndGet();
					Global.cantidadLetrasTotales++;
				} else {
					Global.cantidadLetras.put(caracter, new AtomicInteger(1));
					Global.cantidadLetrasTotales++;
				}
			}

		}
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}
	}
}
