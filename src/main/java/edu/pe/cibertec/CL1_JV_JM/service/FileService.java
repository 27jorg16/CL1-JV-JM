package edu.pe.cibertec.CL1_JV_JM.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.pe.cibertec.CL1_JV_JM.model.Producto;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.StringWriter;

@Slf4j
@Service
public class FileService {

    private static final String XML_FILE_PATH = "producto.xml";
    private static final String JSON_FILE_PATH = "producto.json";

    public void crearArchivoXML(Producto producto) throws Exception {
        Thread.sleep(10000);  // 10 segundos de demora
        JAXBContext context = JAXBContext.newInstance(Producto.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(producto, new File(XML_FILE_PATH));
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(producto, stringWriter);
        log.info("XML creado: " + stringWriter);
    }

    public Producto leerArchivoXML() throws Exception {
        Thread.sleep(5000);  // 5 segundos de demora
        JAXBContext context = JAXBContext.newInstance(Producto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Producto) unmarshaller.unmarshal(new File(XML_FILE_PATH));
    }

    public void crearArchivoJSON(Producto producto) throws Exception {
        Thread.sleep(7000);  // 7 segundos de demora
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File(JSON_FILE_PATH), producto);
        log.info("JSON creado: " + producto);
    }

    public Producto leerArchivoJSON() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(JSON_FILE_PATH), Producto.class);
    }
}