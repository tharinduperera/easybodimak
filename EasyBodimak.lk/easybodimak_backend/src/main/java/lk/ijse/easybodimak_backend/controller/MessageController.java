package lk.ijse.easybodimak_backend.controller;

import lk.ijse.easybodimak_backend.dto.MessageDTO;
import lk.ijse.easybodimak_backend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PutMapping
    public void saveMessage(@RequestBody MessageDTO messageDTO) {
        messageService.saveMessage(messageDTO);
    }

    @DeleteMapping("/{megid}")
    public void deleteAd(@PathVariable("megid") String megid){
        messageService.deleteMessage(megid);
    }

    @GetMapping
    public List<MessageDTO> getAllMessages(){
        return messageService.getAllMessages();
    }
}

