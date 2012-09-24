package dk.itu.smds.e2012.webservices.basic.xml;
/*
 * Author: csp
 *
 */

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;

@XmlRootElement(name = "tasks")
public class Tasks implements Serializable {

    @XmlElement(name = "task")
    public ArrayList<Task> tasks;

    public Tasks(){}
}
