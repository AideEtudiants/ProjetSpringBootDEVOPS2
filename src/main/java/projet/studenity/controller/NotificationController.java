package projet.studenity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.studenity.model.Cart;
import projet.studenity.model.Notification;
import projet.studenity.service.NotificationService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/noti")
public class NotificationController {
    @Autowired
    private NotificationService notiService;

    @PostMapping(value="/all")
    public List<Notification> deleteFromCart(@RequestBody int idUser){
        return notiService.getListNotification(idUser);
    }

    @GetMapping(value="/test")
    public List<Notification> test() {
        return notiService.getListNotification(4);

    }
}