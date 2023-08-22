package com.inclusion.cloud.component;

import com.inclusion.cloud.model.MaximumModel;
import com.inclusion.cloud.service.MaximumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Consola
 * Ejecuta la solucion tomando como parametro el nombre del archivo
 */
@Component
public class ConsoleComponent {
    @Autowired
    private MaximumService maximumService;
    @Autowired
    private FileLoaderComponent fileLoaderComponent;
    public void startConsole() throws IOException {

        final List<String> output= fileLoaderComponent.loadFileFromResources("filename.txt");

        if(!output.isEmpty()){
            final List<MaximumModel> models = new ArrayList<>();
            final int size = Integer.parseInt(output.get(0));
            System.out.println("Entrada:");
            for ( int i = 1 ; i< size ; i++){
                System.out.println(output.get(i));
                final String [] values = output.get(i).split("\\s+");
                final MaximumModel model = buildModel(values);
                models.add(model);
            }
            System.out.println("Salida:");
            maximumService.findMaximum(models).forEach(System.out::println);
        }
    }

    private MaximumModel buildModel(final String[] values) {
        final MaximumModel model = new MaximumModel();
        try {
            model.setX(Integer.parseInt(values[0]));
            model.setY(Integer.parseInt(values[1]));
            model.setN(Integer.parseInt(values[2]));
        } catch (final NumberFormatException e) {
            throw new NumberFormatException("Formato inválido");
        }
        return model;
    }

}
