package org.springframework.samples.petclinic.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.core.style.ToStringCreator;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.samples.petclinic.statistics.Achievement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
	
	@NotNull
	@Size(min = 1, max = 25)
	@Column(name = "username")
	@Id
	String username;
	
	@NotNull
	@Column(name = "password")
	@NotEmpty(message = "No puede estar vacio")
	String password;

	@NotNull
	@NotEmpty(message = "No puede estar vacio")
	@Email
	@Column(unique=true)
	private String email;

	@Column(name = "foto_perfil")
	private String fotoPerfil;

	@Size(min = 0, max = 280)
	@Column(name = "biografia")
	private String biografia;

	@NotEmpty(message = "No puede estar vacio")
	private String nombre;

	@NotEmpty(message = "No puede estar vacio")
	private String apellidos;



	@ManyToMany
	private Set<Achievement> achievements;

	private boolean enabled;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Authorities> authorities;

	public boolean isNew() {
		return this.username == null;
	}

	@Override
	public String toString() {
		return new ToStringCreator(this)

				.append("username", this.getUsername()).append("new", this.isNew()).append("apellidos", this.getApellidos())
				.append("nombre", this.getNombre()).append("password", this.password).append("email", this.email)
				.append("biografia", this.biografia).toString();
	}
}