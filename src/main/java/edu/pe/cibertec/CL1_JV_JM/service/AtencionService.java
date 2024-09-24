package edu.pe.cibertec.CL1_JV_JM.service;

import edu.pe.cibertec.CL1_JV_JM.remote.service.PreparacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Service
public class AtencionService {
    private final PreparacionService preparacionService;

    public CompletableFuture<String> prepararArepa() {
        CompletableFuture<String> tarea1 = preparacionService.amasarMasa();
        CompletableFuture<String> tarea2 = preparacionService.cocinarArepa();
        CompletableFuture<String> tarea3 = preparacionService.freirQueso();
        CompletableFuture<String> tarea4 = preparacionService.freirPlatano();

        return CompletableFuture.allOf(tarea1, tarea2, tarea3, tarea4)
                .thenApply(result -> {
                    try {
                        String valorTarea1 = tarea1.join();
                        String valorTarea2 = tarea2.join();
                        String valorTarea3 = tarea3.join();
                        String valorTarea4 = tarea4.join();
                        return "Resultado de tareas: " +
                                valorTarea1 + " - " +
                                valorTarea2 + " - " +
                                valorTarea3 + " - " +
                                valorTarea4;
                    } catch (Exception ex) {
                        return "Error al combinar los datos: " + ex.getMessage();
                    }
                })
                .exceptionally(ex -> "Error al ejecutar tareas: " + ex.getMessage());
    }
}
