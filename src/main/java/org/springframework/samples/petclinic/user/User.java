package org.springframework.samples.petclinic.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	private String username;
	
	@NotNull
	@Column(name = "password")
	private String password;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "nombre")
	private String nombre;

	@NotNull
	@Size(min = 1, max = 75)
	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "foto_perfil")
	private String fotoPerfil;

	@Size(min = 0, max = 280)
	@Column(name = "biografia")
	private String biografia;

	private boolean enabled;

	@NotNull
	@NotEmpty(message = "No puede estar vacio")
	@Email
	@Column(unique=true)
	private String email;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Authorities> authorities;
}