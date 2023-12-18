package org.java.spring.service;

import java.util.List;

import org.java.spring.pojo.Message;
import org.java.spring.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepo messageRepo;

    public List<Message> findAll() {
        return messageRepo.findAll();
    }

    public Message findById(int id) {
        return messageRepo.findById(id).get();
    }

    public void save(Message message) {
        messageRepo.save(message);
    }

    public void deleteById(int id) {
        messageRepo.deleteById(id);
    }
}
