package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TBL_USUARIOCL3")
@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDUSUARIOCL3")
	private Integer idUsuario;
	@Column(name = "USUARIOCL3")
	private String username;
	@Column(name = "PASSWORDCL3")
	private String password;
}
