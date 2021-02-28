package configurations;

import java.io.IOException;
import java.util.Properties;

/**
 * <h1>Properties Reader class</h1>
 * The Properties Reader class implements logic of controlling a
 * reading of files with extension .properties
 * <p>
 *
 * @author  Vytenis Vaišvilas
 * @version 1.0-SNAPSHOT
 * @since   2020-02-28
 */

public class PropertiesReader {

    /**
     * This method is used to read files with extensions .properties
     * @param propertiesFilePath This is parameter defines path to file.
     * @return Properties This returns all properties from given file.
     */

    public static Properties readProps(String propertiesFilePath)
    {
        Properties prop = new Properties();
        try {
            prop.load(TestsProps.class.getClassLoader().getResourceAsStream(propertiesFilePath));

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }
}
