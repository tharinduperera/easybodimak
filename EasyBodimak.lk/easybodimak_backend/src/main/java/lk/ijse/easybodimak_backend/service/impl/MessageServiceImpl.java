package lk.ijse.easybodimak_backend.service.impl;

import lk.ijse.easybodimak_backend.dto.MessageDTO;
import lk.ijse.easybodimak_backend.entity.Message;
import lk.ijse.easybodimak_backend.repository.MessageRepository;
import lk.ijse.easybodimak_backend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveMessage(MessageDTO messageDTO) {
        Message message = new Message();
        message.setMegid(messageDTO.getMegid());
        message.setEmail(messageDTO.getEmail());
        message.setDate(new Date().toString());
        message.setName(messageDTO.getName());
        message.setSubject(messageDTO.getSubject());
        message.setMessage(messageDTO.getMessage());
        messageRepository.save(message);

    }

    @Override
    public List<MessageDTO> getAllMessages() {
        List<Message> messages = messageRepository.findAll();
        List<MessageDTO> messageDTOS = new ArrayList<>();
        messages.forEach(c -> messageDTOS.add(new MessageDTO(
                c.getMegid(),
                c.getEmail(),
                c.getDate(),
                c.getName(),
                c.getSubject(),
                c.getMessage()
        )));
        return messageDTOS;

    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteMessage(String megid) {
        messageRepository.deleteById(megid);
    }

}
