package edu.pe.cibertec.CL1_JV_JM;

import edu.pe.cibertec.CL1_JV_JM.model.Producto;
import edu.pe.cibertec.CL1_JV_JM.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class Cl1JvJmApplication implements CommandLineRunner {
	private final FileService fileService;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JvJmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Producto producto = new Producto("Laptop", 1200.00, "Electrónica");

		// Crear y leer XML
		fileService.crearArchivoXML(producto);
		Producto productoXML = fileService.leerArchivoXML();
		log.info("Producto XML: " + productoXML.toString());

		// Crear y leer JSON
		fileService.crearArchivoJSON(producto);
		Producto productoJSON = fileService.leerArchivoJSON();
		log.info("Producto JSON: " + productoJSON.toString());
	}
}
