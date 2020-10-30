package ru.rwe;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.HashMap;

public class Property {
    private Property(){}
    public static final Map<String, Boolean> TEST_MODE = new HashMap<>();

    static{
        Logger log = Logger.getLogger(Property.class);

        try{
            Configuration config = new PropertiesConfiguration("app.properties");
            TEST_MODE.put("test-mode", config.getBoolean("test-mode"));

        }catch(Exception e){
            log.info(e);
            throw new RuntimeException(e);
        }

    }

}
