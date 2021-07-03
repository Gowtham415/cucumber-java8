package framework;

import org.apache.maven.shared.utils.PropertyUtils;

import java.io.File;
import java.nio.file.Path;
import java.util.Properties;

public class PropertyFileReader {

    public Properties properties;

    public PropertyFileReader() {
        Path path = Path.of(System.getProperty("user.dir") + "/src/main/resources/cucumber.properties");
        this.properties = PropertyUtils.loadOptionalProperties(path.toFile());
    }

    public String getProperty(String propertyName){
        return properties.getProperty(propertyName);
    }
}
