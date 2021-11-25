package Chronometre.model;

public class Contador implements Runnable {
	private int time = 0;
	private String nombre;
	private SolicictarSuspender suspendido = new SolicictarSuspender();

	public Contador(int time, String nombre) {
		super();
		this.time = time;
		this.nombre = nombre;
		this.suspendido.setSuspendido(false);
	}

	public Contador() {
		time = 0;
		nombre = "";
		this.suspendido.setSuspendido(false);

	}
//sadse
	/*@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				// System.out.println(time);
				time++;

				Thread.sleep(1000);
				this.suspendido.waitReaundar();
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
		}

	}*/
	
	@Override
	public void run() {
		while(!this.suspendido.isSuspendido()) {
			time++;
			try {
				Thread.sleep(1000);
				this.suspendido.waitReaundar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
			}
		}
			
		
		
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public SolicictarSuspender getSuspendido() {
		return suspendido;
	}

	public void setSuspendido(SolicictarSuspender suspendido) {
		this.suspendido = suspendido;
	}

}
