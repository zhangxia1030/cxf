package demo.restful.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import demo.bean.Person;
import demo.bean.Room;
import demo.dao.RoomDao;
  
@Path("/roomservice")  
public class RoomService {  
      
	@GET  
	@Path("/value/{id}")  
	@Consumes("application/xml")  
	public String getValue(@PathParam("id")String id )  
	{  
		System.out.println("get room by id= "+id);  
		Room room=RoomDao.getRoom(id);  
		return id;  
	}
	
    @GET  
    @Path("/room/{id}")  
    //@Consumes("application/xml")
    @Produces(MediaType.APPLICATION_XML)
    public Room getRoom(@PathParam("id")String id)  
    {  
        System.out.println("get room by id= "+id);  
        Room room=RoomDao.getRoom(id);  
        return room;  
    }
    
    @GET  
    @Path("/room")  
    @Produces(MediaType.APPLICATION_XML)  
    public List<Room> getAllRoom()  
    {  
        System.out.println("get all room");  
        Room r1 = new Room();
        r1.setId(003+"");
        r1.setPersons(RoomDao.getRoom("001").getPersons());
        Room r2 = new Room();
        r2.setId(005+"");
        r2.setPersons(RoomDao.getRoom("001").getPersons()); 
        Room r3 = new Room();
        r3.setId(005+"");
        r3.setPersons(RoomDao.getRoom("001").getPersons()); 
        
        List<Room> list = new ArrayList<Room>();
        list.add(r1);
        list.add(r2);
        list.add(r3);
        return list;  
    }  
      
    @POST  
    @Path("/room")  
    @Produces(MediaType.APPLICATION_XML)
    public void addRoom(Room room)  
    {  
        System.out.println("add room which id is:"+room.getId());  
        RoomDao.addRoom(room);  
    }  
    @PUT  
    @Path("/room/{id}")  
    @Produces(MediaType.APPLICATION_XML)  
    public void updateRoom(@PathParam("id")String id,Room room)  
    {  
        System.out.println("update room which original id is:"+room.getId());  
        RoomDao.updateRoom(id,room);  
    }  
    @DELETE  
    @Path("/room/{id}")  
    @Produces(MediaType.APPLICATION_XML)  
    public void deleteRoom(@PathParam("id")String id)  
    {  
        System.out.println("remove room by id= "+id);  
        RoomDao.deleteRoom(id);  
    }  
    @POST  
    @Path("/room/{id}")  
    @Produces(MediaType.APPLICATION_XML)
    public void addPerson(@PathParam("id") String id,Person person)  
    {  
        System.out.println("add person who's name is:"+person.getName());  
        RoomDao.addPerson(id, person);  
    }  
    @DELETE  
    @Path("/room/{id}/{name}")  
    @Produces(MediaType.APPLICATION_XML)  
    public void deletePerson(@PathParam("id")String id,@PathParam("name")String name)  
    {  
        System.out.println("remove person who's name is: "+name);  
        RoomDao.deletePerson(id, name);  
    }  
}