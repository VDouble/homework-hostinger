package configurations;

import java.util.Properties;

import static configurations.PropertiesReader.readProps;

/**
 * <h1>Tests Properties class</h1>
 * The Tests Properties class store all properties
 * needed for tests execution.
 * <p>
 * All properties can be get by public static.
 * Properties is read from config.properties file.
 *
 * @author  Vytenis Vaišvilas
 * @version 1.0-SNAPSHOT
 * @since   2020-02-28
 */

public class TestsProps {

    private static Properties properties = readProps("config.properties");

    public static String URL = properties.getProperty("URL");

}
