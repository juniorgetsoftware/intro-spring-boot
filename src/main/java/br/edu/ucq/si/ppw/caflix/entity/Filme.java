package br.edu.ucq.si.ppw.caflix.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "filme")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@JsonProperty("id")
	private Long id;

	@ToString.Include
	@JsonProperty("nome")
	@Column(name = "nome")
	@NotBlank(message = "Nome não pode ser nulo e nem vazio")
	private String nome;

	@JsonProperty("ano")
	@Column(name = "ano")
	@Min(message = "Ano não pode ser menor do que 1500",value = 1500)
	@NotNull(message = "Ano não pode ser nulo")
	private Integer ano;

	@JsonProperty("sinopse")
	@Column(name = "sinopse", length = 2500)
	@NotBlank(message = "Sinopse não pode ser nulo e nem vazio")
	private String sinopse;

	@JsonProperty("url_capa")
	@Column(name = "url_capa")
	@URL(message = "Não é um formato de URL válido")
	private String urlCapa;

}
