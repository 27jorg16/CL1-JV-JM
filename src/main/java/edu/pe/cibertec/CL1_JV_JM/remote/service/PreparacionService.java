package edu.pe.cibertec.CL1_JV_JM.remote.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class PreparacionService {
    @Async
    public CompletableFuture<String> amasarMasa() {
        try {
            log.info("Amasando la masa para las arepas");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return CompletableFuture.completedFuture("Masa amasada, terminado");
    }

    @Async
    public CompletableFuture<String> cocinarArepa() {
        try {
            log.info("Empezando a cocinar la arepa");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return CompletableFuture.completedFuture("Arepa cocinada, terminado");
    }

    @Async
    public CompletableFuture<String> freirQueso() {
        try {
            log.info("Empezando a freír Queso");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return CompletableFuture.completedFuture("Queso frito, terminado");
    }

    @Async
    public CompletableFuture<String> freirPlatano() {
        try {
            log.info("Empezando el freír platano");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return CompletableFuture.completedFuture("Platano frito, terminado");
    }
}
