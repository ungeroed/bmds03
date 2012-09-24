/**
 * 
 */
package dk.itu.smds.e2012.webservices.basic.xml;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;
/**
 * @author Yndal
 *
 */

@XmlRootElement(name = "task")
public class Task implements Serializable {
	
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
	
	@XmlElementWrapper(name = "attendants")
	@XmlElement(name = "user")
	public ArrayList<String> attendants;

    public Task(){}

    public Task(String id, String name, String date, String status, String description){
        this.attendants = new ArrayList<String>();
        this.id = id;
        this.name = name;
        this.date = date;
        this.status = status;
        this.description = description;
    }

}
