package onnet.mkapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString @EqualsAndHashCode(exclude= {"bairro"})
@Table(name = "mk_bairros")
public class Bairro {

	@Id
	@Column(name = "codbairro")
	private long id;

	@Column(name = "bairro")
	private String bairro;

	
}
