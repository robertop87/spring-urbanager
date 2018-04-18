package edu.alenasoft.urbanager.data.webservice;


import edu.alenasoft.urbanager.data.entity.Room;
import edu.alenasoft.urbanager.data.repository.RoomRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
  @Autowired
  private RoomRepository repository;

  @RequestMapping(value="/rooms", method = RequestMethod.GET)
  List<Room> findAll(@RequestParam(required = false) String roomNumber) {
    List<Room> rooms = new ArrayList<>(0);
    if (null == roomNumber) {
      this.repository.findAll().forEach(room -> rooms.add(room));
    } else {
      Room room = this.repository.findByNumber(roomNumber);
      if (null != room) {
        rooms.add(room);
      }
    }
    return rooms;
  }
}
