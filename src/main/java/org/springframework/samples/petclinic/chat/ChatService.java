package org.springframework.samples.petclinic.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChatService {
    private ChatRepository chatRepository;

    @Autowired
    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Transactional
    public Chat save(Chat c){
        return chatRepository.save(c);

    }

    @Transactional
    public Chat getByPartidaId(Integer id){
        return chatRepository.findByPartidaId(id);
    }
    
    @Transactional
    public void edit(Chat c) throws DataAccessException{
        Chat toUpdate = chatRepository.findById(c.getId()).get();
        toUpdate.setId(c.getId());
        toUpdate.setMensajes(c.getMensajes());
        toUpdate.setPartida(c.getPartida());
        chatRepository.save(toUpdate);
    }
}
