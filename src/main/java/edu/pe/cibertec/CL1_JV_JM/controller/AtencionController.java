package edu.pe.cibertec.CL1_JV_JM.controller;

import edu.pe.cibertec.CL1_JV_JM.service.AtencionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@RestController
public class AtencionController {
    private final AtencionService atencionService;

    @GetMapping("/atender-arepa")
    public String atenderArepa() throws ExecutionException, InterruptedException {
        CompletableFuture<String> resultado = atencionService.prepararArepa();
        return resultado.get();
    }
}
