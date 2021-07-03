package framework;

import org.apache.maven.shared.utils.PropertyUtils;

public class AutomationUI {
    private PropertyFileReader propertyFileReader;

    public AutomationUI(PropertyFileReader propertyFileReader) {
        this.propertyFileReader = propertyFileReader;
    }

    public PropertyFileReader getPropertyFileReader() {
        return propertyFileReader;
    }
}
