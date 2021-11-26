package Chornometre;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import Chronometre.model.Contador;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PrimaryController {
	Contador c1 ;
	

	static int vhoras = 0;
	static int vminutos = 0;
	@FXML
	private Button boton1;
	@FXML
	private Button boton2;
	@FXML
	private Button boton3;
	@FXML
	private Label segundos;
	@FXML
	private Label minutos;
	@FXML
	private Label horas;

	@FXML
	protected void initialize() {

		Timer t = new Timer();
		c1= new Contador(0, "c1");
		t.schedule(new TimerTask() {

			@Override
			public void run() {
				Platform.runLater(() -> {
					actualizarContador(c1.getTime());

				});
			}
		}, 0, 1000);

	}

	private void actualizarContador(int tiempo) {
		if (tiempo < 10) {
			segundos.setText("0" + tiempo + "");

		}

		if (tiempo >= 10 && tiempo < 60) {
			segundos.setText(tiempo + "");

		} else if (tiempo == 60) {

			c1.setTime(0);
			segundos.setText("00");

			if (Integer.parseInt(minutos.getText()) <= 59 && Integer.parseInt(minutos.getText()) <= 9) {
				vminutos++;
				minutos.setText("0" + vminutos + "");
			} else if (Integer.parseInt(minutos.getText()) <= 59 && Integer.parseInt(minutos.getText()) >= 10) {
				vminutos++;
				minutos.setText(+vminutos + "");
			} else if (Integer.parseInt(minutos.getText()) == 59) {
				vhoras++;
				horas.setText(vhoras + "");
			}
		}

	}

	@FXML
	public void clic1() {
		Thread t1 = new Thread(c1);
		if (boton1.getText().equals("Inicia")) {

			
			t1.start();
			
			boton1.setText("Contando");
			boton3.setDisable(false);

			boton1.setDisable(true);
		}

	}

	@FXML
	public void clic2() {
		//esta el hilo activo
		if (boton2.getText().matches("Pausa")) {
			boton2.setText("Reanudar");
			boton1.setText("Detenido");
			//se detiene
			c1.getSuspendido().setSuspendido(true);
		} else
			//esta el hilo pausado
		if (boton2.getText().equals("Reanudar")) {
			boton2.setText("Pausa");
			boton1.setText("Contando");
			//se reactiva
			c1.getSuspendido().setSuspendido(false);
		}
	}

	@FXML
	public void clic3() {
		//esta el hilo activo
		if (boton2.getText().matches("Pausa")) {
			boton2.setText("Reanudar");
			boton1.setText("Detenido");
		c1.getSuspendido().setSuspendido(true);
		}
		//esta el hilo pausado
		if (boton2.getText().equals("Reanudar")) {
			boton2.setText("Pausa");
			boton1.setText("Contando");
		

		}
		Thread.currentThread().interrupt();
		boton1.setDisable(false);
		boton1.setText("Inicia");
		
		boton3.setDisable(true);
		c1.setTime(0);
		segundos.setText("00");
		minutos.setText("00");
		horas.setText("00");
	}
}
