package pl.javastart.controller;

import java.io.IOException;

public class PrintingRunnable implements Runnable {

    private final int id;


    public PrintingRunnable(int id) {
        this.id = id;
    }


    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000 * id);
                Covid19Confirmed covid19Confirmed = new Covid19Confirmed(new DataRepo());
                covid19Confirmed.get();
            }

        } catch (InterruptedException | IOException ex) {
            System.out.println("Thread was interrupted");
        }
    }
}

