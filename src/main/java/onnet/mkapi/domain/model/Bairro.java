package onnet.mkapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "mk_bairros")
public class Bairro {

	@Id
	@Column(name = "codbairro")
	private long id;

	@Column(name = "bairro")
	@EqualsAndHashCode.Exclude private String bairro;

	
}
