package Chronometre.model;

public class SolicictarSuspender {
	private boolean suspendido;//false-> el hilo esta corriendo //true-> hilo paraoh
	
	public synchronized void setSuspendido(boolean b) {
		this.suspendido=b;
		notifyAll();
	}
	
	public synchronized void waitReaundar() throws InterruptedException {
		while(this.suspendido) {
			wait();
			
		}
	}

	public boolean isSuspendido() {
		return suspendido;
	}
	
	
	
}
