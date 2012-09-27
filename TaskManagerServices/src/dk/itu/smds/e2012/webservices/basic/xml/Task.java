/**
 * 
 */
package dk.itu.smds.e2012.webservices.basic.xml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rao
 */
    @XmlRootElement(name = "task")
    public class Task implements Serializable{

        @XmlID
        @XmlAttribute
        public String id;
        
        @XmlAttribute
        public String name;
        
        @XmlAttribute
        public String date;
        
        @XmlAttribute
        public String status;
        
        @XmlElement
        public String description;
        
        @XmlElement
        public String attendants;
               
        
        
    }
