
package modelo;

public class Temporizador extends Thread {
    private static final int TIEMPO_LIMITE = 10;  // tiempo límite en minutos

    private TemporizadorListener listener;
    private volatile boolean corriendo = true;

    public Temporizador(TemporizadorListener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        int tiempoRestante = TIEMPO_LIMITE * 60;  // convertir minutos a segundos

        while (corriendo && tiempoRestante > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tiempoRestante--;
        }

        if (tiempoRestante <= 0) {
            listener.tiempoAgotado();
        }
    }

    public void detener() {
        corriendo = false;
    }
}

