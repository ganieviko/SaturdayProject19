package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadFromConfigPropertiesFile {

    private Properties properties;
    private final String propertyFilePath = "properties/config.properties";


    public void ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }
    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getApplicationPassword() {
        String password = properties.getProperty("password");
        if (password != null) return password;
        else throw new RuntimeException("password not specified in the Configuration.properties file.");
    }

    public String getApplicationUserName() {
        String username = properties.getProperty("username");
        if (username != null) return username;
        else throw new RuntimeException("username not specified in the Configuration.properties file.");
    }
}
