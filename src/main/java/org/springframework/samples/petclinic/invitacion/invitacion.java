package org.springframework.samples.petclinic.invitacion;

import org.springframework.samples.petclinic.model.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.user.User;

public class invitacion extends BaseEntity{
    
    @ManyToOne
	private User receiver;
	
	@ManyToOne
	private User sender;

	public invitacion() {
	}

    public invitacion(User sender, User receiver) {
		this.sender = sender;
		this.receiver = receiver;
		
		sender.getSendedInvitations().add(this);
		receiver.getReceivedInvitations().add(this);		
	}

    public void accept() {
		sender.getFriends().add(receiver);
		receiver.getFriends().add(sender);
		sender.getAuxFriends().add(receiver);
		receiver.getAuxFriends().add(sender);
	}
	
	public void unlink() {
		sender.getSendedInvitations().remove(this);
		receiver.getReceivedInvitations().remove(this);
		
		receiver = null;
		sender = null;
	}

	public boolean esDelUsuario(String username) {
		return sender.getUsername().equals(username) || receiver.getUsername().equals(username);
	}

    public User getReceiver() {
        return null;
    }
}
