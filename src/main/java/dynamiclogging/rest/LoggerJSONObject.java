package dynamiclogging.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoggerJSONObject {

    public String name;
    public String level;
    
    public LoggerJSONObject() {
    }

    public LoggerJSONObject(String name, String level) {
        this.name = name;
        this.level = level;
    }

}
