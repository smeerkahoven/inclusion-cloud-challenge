package com.inclusion.cloud.component;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileLoaderComponent implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(final ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public List<String> loadFileFromResources(final String fileName) throws IOException {
        final Resource resource = resourceLoader.getResource("classpath:" + fileName);
        final List<String> output = new ArrayList<>();
        if (resource.exists()) {
            try (final BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.add(line);
                }
            }
        } else {
            System.out.println("File not found: " + fileName);
        }

        return  output;
    }
}
