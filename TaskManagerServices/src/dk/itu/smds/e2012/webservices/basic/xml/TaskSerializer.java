package dk.itu.smds.e2012.webservices.basic.xml;/*
 * Author: csp
 *
 */

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.*;

public class TaskSerializer {


    public TaskList deserialize(String xml) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(TaskList.class);

        // convert String into InputStream
        InputStream is = new ByteArrayInputStream(xml.getBytes());

        // read it with BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        TaskList tasks = (TaskList) jaxbContext.createUnmarshaller().unmarshal(br);

        return tasks;
    }
    
    public Task deserializeTask(String xml) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Task.class);

        // convert String into InputStream
        InputStream is = new ByteArrayInputStream(xml.getBytes());

        // read it with BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        Task task = (Task) jaxbContext.createUnmarshaller().unmarshal(br);

        return task;
    }

    public String serialize(TaskList tasks) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(TaskList.class);

        StringWriter writer = new StringWriter();

        jaxbContext.createMarshaller().marshal(tasks, writer);

        return writer.toString();
    }
    
    public String serialize(Task task) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Task.class);

        StringWriter writer = new StringWriter();

        jaxbContext.createMarshaller().marshal(task, writer);

        return writer.toString();
    }


}
