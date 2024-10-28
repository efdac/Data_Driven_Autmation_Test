package Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    public static Properties properties = new Properties(); ;

    public static Properties Read_Properties(String fileName){

        try {
            FileInputStream file = new FileInputStream(fileName);
            properties.load(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }
}
