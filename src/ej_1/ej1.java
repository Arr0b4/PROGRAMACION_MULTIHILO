package ej_1;

import java.io.IOException;

public class ej1 {

    public static void main(String[] args) {
        try {
            abrirNotepad h1 = new abrirNotepad();
            abrirCalculadora h2 = new abrirCalculadora();

            h1.start();
            h2.start();

            h1.join();
            h2.join();

            System.out.println("Programa finalizado.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static class abrirNotepad extends Thread {

        @Override
        public void run() {
            try {
                ProcessBuilder note =
                        new ProcessBuilder("notepad.exe");

                Process procesoNote = note.start();

                Thread.sleep(4000);
                procesoNote.destroy();
                procesoNote.waitFor();

                System.out.println("El proceso de Notepad finalizó.");

            } catch (IOException e) {
                e.printStackTrace();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class abrirCalculadora extends Thread {

        @Override
        public void run() {
            try {
                ProcessBuilder calculator =
                        new ProcessBuilder("calc.exe");

                Process procesoCalculator = calculator.start();

                Thread.sleep(8000);
                procesoCalculator.destroy();
                procesoCalculator.waitFor();

                System.out.println(
                        "El proceso de Calculadora finalizó."
                );

            } catch (IOException e) {
                e.printStackTrace();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}