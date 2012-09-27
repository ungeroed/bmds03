package dk.itu.smds.e2012.webservices.basic.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author rao
 */
@XmlRootElement(name = "tasks")
@XmlSeeAlso(Task.class)
public class TaskList {

    protected List<Task> list = new ArrayList<Task> ();
    
    public TaskList(){}

    public TaskList(List<Task> list) {
        this.list = list;
    }

    @XmlElement(name = "task")
    public List<Task> getList() {
        return list;
    }
}
