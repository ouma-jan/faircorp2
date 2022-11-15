package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api/windows")
@Transactional
public class WindowController {
    @Autowired
    WindowDao windowDao;
    @Autowired
    RoomDao roomDao;


    /**
     * lists all windows
     * @return the list of windows
     * @see com.emse.spring.faircorp.dao.WindowDao
     * @see com.emse.spring.faircorp.dto.WindowDto
     */
    @GetMapping // (5)
    public List<WindowDto> findAll() {

        return windowDao.findAll().stream()
                .map(WindowDto::new)
                .collect(Collectors.toList());  // (6)
    }
    /**
     * lists one specific window
     * @param id the id of window you are searching for
     * @return the {@link com.emse.spring.faircorp.dto.WindowDto} if it is found and null if not
     * @see com.emse.spring.faircorp.dao.WindowDao
     * @see com.emse.spring.faircorp.dto.WindowDto
     */
    @GetMapping(path = "/{id}")
    WindowDto findById(@PathVariable Long id){
        return windowDao.findById(id).map(WindowDto::new).orElse(null);
    }
    /**
     * lists all windows of one specific room
     * @param room_id the id of room you are searching for its windows
     * @return the list of {@link com.emse.spring.faircorp.dto.WindowDto}
     * @see com.emse.spring.faircorp.dao.WindowDao
     * @see com.emse.spring.faircorp.dto.WindowDto
     */
    @GetMapping(path = "/r/{room_id}")
    public List<WindowDto> findByRoomId(@PathVariable Long room_id){

        return windowDao.findByRoomId(room_id).stream().map(WindowDto::new).collect(Collectors.toList());
    }
    /**
     * creates a new window in the api
     * @param dto the data transfer you want to add as request body
     * @return the windowdto created
     * @see com.emse.spring.faircorp.model.Window
     * @see com.emse.spring.faircorp.dao.WindowDao
     */
    @PostMapping
    public WindowDto create(@RequestBody  WindowDto dto){
        Room room =roomDao.getById(dto.getRoomId());
        Window window =null;

        if(dto.getId()==null){
            window=windowDao.save(new Window(dto.getName(), dto.getWindowStatus(), room));

        }
        else{
            window=windowDao.getById(dto.getId());
            window.setWindowStatus(dto.getWindowStatus());
            window.setName(dto.getName());
        }
        return new WindowDto(window);

    }
    /**
     * modifies the status of a window
     * @param id the id of what window you want to modify it status
     * @return the windowdto modified
     * @see com.emse.spring.faircorp.model.Window
     * @see com.emse.spring.faircorp.dao.WindowDao
     * @see  com.emse.spring.faircorp.dto.WindowDto
     */
    @PutMapping(path = "/{id}/switch")
    public WindowDto switchStatus(@PathVariable Long id) {
        Window window = windowDao.findById(id).orElseThrow(IllegalArgumentException::new);
        window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
        return new WindowDto(window);
    }
    /**
     * deletes a specific window
     * @param id the id of window you want to delete
     * @see com.emse.spring.faircorp.dao.WindowDao
     */
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        windowDao.deleteById(id);
    }
}
