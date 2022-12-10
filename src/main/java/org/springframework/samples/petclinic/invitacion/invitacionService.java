package org.springframework.samples.petclinic.invitacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.user.User;
import org.springframework.samples.petclinic.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class invitacionService {
    

    @Autowired
	private invitacionRepository invitacionRepository;
	
	@Autowired
	private UserRepository userRepository;

    public List<invitacion> getInvitationsOf(String username) {
		return invitacionRepository.getInvitationsOf(username);
	}

    @Transactional
	public void sendInvitation(String sender_username, String receiver_username) {
		User receiver = userRepository.findById(receiver_username).get();
		User sender = userRepository.findById(sender_username).get();
		
		if(receiver != null && sender.canInvite(receiver.getEmail())) {
			invitacionRepository.save(new invitacion(sender, receiver));
		}
	}

    @Transactional
	public void acceptInvitation(String username, Integer invitacion_id) {
		invitacion invitacion = invitacionRepository.findById(invitacion_id).get();
		
		if(invitacion != null && invitacion.getReceiver().getUsername().equals(username)) {
			invitacion.accept();
			invitacionRepository.deleteById(invitacion_id);
		}
	}

	@Transactional
	public void deleteInvitationById(Integer id){
        invitacionRepository.deleteById(id);
    }

    @Transactional
    public List<User> getAvailableUsers(String username) {
        List<User> users = userRepository.findAll();
        List<User> result = new ArrayList<User>();
        User sender = userRepository.findById(username).get();
        for (User receiver : users) {
            if (sender.canInvite(receiver.getUsername())) {
                result.add(receiver);
            }
        }
        return result;
    }





}
