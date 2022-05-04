package global.dao;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonDao<T> {

    private static ObjectMapper mapper = new ObjectMapper();

    private static final String HEADER = "";
    private static final String FOOTER = ".json";


    private final File file;


    protected JsonDao(T defaultObject) {
        String fileName = defaultObject.getClass().getName();
        this.file = new File(HEADER + fileName + FOOTER);
        
        if (!file.exists()) {
            write(defaultObject);
        }
    }


    protected T read(Class<T> valueType) {
        try {
            return mapper.readValue(file, valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected T read(TypeReference<T> valueType) {
        try {
            return mapper.readValue(file, valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void write(T object) {
        try {
            mapper.writeValue(file, object);
        } catch (StreamWriteException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch  (IOException e) {
            e.printStackTrace();
        }
    }
}
