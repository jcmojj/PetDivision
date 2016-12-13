package br.com.mykidpet.modelo.tag;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//import br.com.mykidpet.modelo.maquina.ModeloDeMaquina;
@Entity
public class ModeloDeTag implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private TagColor tagColor;
	@Enumerated(EnumType.STRING)
	private TagFormat tagFormat;
	private BigDecimal alturaTag;
	private BigDecimal espessuraTag;
	private BigDecimal comprimentoTag;
	private BigDecimal diametroTag;
	@Enumerated(EnumType.STRING)
	private TagMaterial tagMaterial;
	private BigDecimal alturaIma;
	private BigDecimal comprimentoIma;
	private BigDecimal espessuraIma;
	@Enumerated(EnumType.STRING)
	private MagnetMaterial magnetMaterial;
	@OneToMany//(mappedBy = "modeloDeTag")
	private List<Tag> tags;
	// @ManyToMany
	// private List<ModeloDeMaquina> modelodeMaquina;

	// Constructor
	public ModeloDeTag(TagColor tagColor, TagFormat tagFormat, BigDecimal alturaTag, BigDecimal espessuraTag,
			BigDecimal comprimentoTag, BigDecimal diametroTag, TagMaterial tagMaterial, BigDecimal alturaIma,
			BigDecimal comprimentoIma, BigDecimal espessuraIma, MagnetMaterial magnetMaterial) {
		super();
		this.tagColor = tagColor;
		this.tagFormat = tagFormat;
		this.alturaTag = alturaTag;
		this.espessuraTag = espessuraTag;
		this.comprimentoTag = comprimentoTag;
		this.diametroTag = diametroTag;
		this.tagMaterial = tagMaterial;
		this.alturaIma = alturaIma;
		this.comprimentoIma = comprimentoIma;
		this.espessuraIma = espessuraIma;
		this.magnetMaterial = magnetMaterial;
	}

	// getters and setters


	public TagColor getTagColor() {
		return tagColor;
	}

	public void setTagColor(TagColor tagColor) {
		this.tagColor = tagColor;
	}

	public TagFormat getTagFormat() {
		return tagFormat;
	}

	public void setTagFormat(TagFormat tagFormat) {
		this.tagFormat = tagFormat;
	}

	public BigDecimal getAlturaTag() {
		return alturaTag;
	}

	public void setAlturaTag(BigDecimal alturaTag) {
		this.alturaTag = alturaTag;
	}

	public BigDecimal getEspessuraTag() {
		return espessuraTag;
	}

	public void setEspessuraTag(BigDecimal espessuraTag) {
		this.espessuraTag = espessuraTag;
	}

	public BigDecimal getComprimentoTag() {
		return comprimentoTag;
	}

	public void setComprimentoTag(BigDecimal comprimentoTag) {
		this.comprimentoTag = comprimentoTag;
	}

	public BigDecimal getDiametroTag() {
		return diametroTag;
	}

	public void setDiametroTag(BigDecimal diametroTag) {
		this.diametroTag = diametroTag;
	}

	public TagMaterial getTagMaterial() {
		return tagMaterial;
	}

	public void setTagMaterial(TagMaterial tagMaterial) {
		this.tagMaterial = tagMaterial;
	}

	public BigDecimal getAlturaIma() {
		return alturaIma;
	}

	public void setAlturaIma(BigDecimal alturaIma) {
		this.alturaIma = alturaIma;
	}

	public BigDecimal getComprimentoIma() {
		return comprimentoIma;
	}

	public void setComprimentoIma(BigDecimal comprimentoIma) {
		this.comprimentoIma = comprimentoIma;
	}

	public BigDecimal getEspessuraIma() {
		return espessuraIma;
	}

	public void setEspessuraIma(BigDecimal espessuraIma) {
		this.espessuraIma = espessuraIma;
	}

	public MagnetMaterial getMagnetMaterial() {
		return magnetMaterial;
	}

	public void setMagnetMaterial(MagnetMaterial magnetMaterial) {
		this.magnetMaterial = magnetMaterial;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}