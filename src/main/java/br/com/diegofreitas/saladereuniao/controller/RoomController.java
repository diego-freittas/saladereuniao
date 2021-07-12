package br.com.diegofreitas.saladereuniao.controller;

import br.com.diegofreitas.saladereuniao.exception.ResourceNotFoundException;
import br.com.diegofreitas.saladereuniao.model.Room;
import br.com.diegofreitas.saladereuniao.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }
    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomsById(@PathVariable(value = "id") Long roomId) throws Throwable {
        Room room = (Room) roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found: " + roomId));
        return ResponseEntity.ok().body(room);

    }
    @PostMapping("/rooms")
    public Room createRoom (@Valid @RequestBody Room room){
        return (Room) roomRepository.save(room);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") Long roomId,
                                           @Valid @RequestBody Room roomDatails) throws Throwable {
        Room room = (Room) roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id: " + roomId));
                room.setName(roomDatails.getName());
                room.setDate(roomDatails.getDate());
                room.setStartHour(roomDatails.getStartHour());
                room.setEndHour(roomDatails.getEndHour());
                final Room updateRoom = (Room) roomRepository.save(room);
                return ResponseEntity.ok().body(updateRoom);
                //return ResponseEntity.ok() (updateRoom);
    }

    @DeleteMapping("/rooms/{id}")
    public Map<String, Boolean> deleteRoom(@PathVariable(value = "id") Long roomId) throws Throwable {
        Room room = (Room) roomRepository.findById(roomId)
                .orElseThrow(()-> new ResourceNotFoundException("Room not found for this id: " + roomId));

        roomRepository.delete(room);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;

    }
}
