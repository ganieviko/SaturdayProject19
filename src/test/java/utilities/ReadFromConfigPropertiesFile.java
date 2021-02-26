package utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadFromConfigPropertiesFile {
    public static String getValueFor(String key){
        String filePath = "src/test/resources/properties/config.properties";
        String value = null;

        try {
            InputStream input = new FileInputStream(filePath);
            Properties properties = new Properties();
            properties.load(input);
            value = properties.getProperty(key);
        }catch (IOException e){
            e.printStackTrace();
        }
        return value;
    }
}
