package lk.ijse.easybodimak_backend.service;

import lk.ijse.easybodimak_backend.dto.MessageDTO;

import java.util.List;

public interface MessageService {
    public void saveMessage(MessageDTO messageDTO);
    public List<MessageDTO> getAllMessages();
    void deleteMessage(String megid);
}
