package netpolix.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="videos")
public class Video implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_isan", nullable = false)
	private Integer isan;
	
	@NotEmpty
	private String titulo;
	
	@NotEmpty
	private String ano;
	
	@NotEmpty
	private String duracion;
	
	@NotNull
	@OneToOne
	@JoinColumn(name= "categoria_id")
	private Categoria categoria;
	

	public Integer getIsan() {
		return isan;
	}

	public void setIsan(Integer isan) {
		this.isan = isan;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	private static final long serialVersionUID = 1L;
}
