package com.example.omnirio.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "attributes")
public class Attribute {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attribute_id")
	private Long attributeId;
	
	@Column(name = "attribute_name")
	private String attributeName;
	
	@Column(name = "attribute_value")
	private String attributeValue;
	
	
	public Long getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(Long attributeId) {
		this.attributeId = attributeId;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public String getAttributeValue() {
		return attributeValue;
	}
	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
	@Override
	public String toString() {
		return "Attribute [attributeId=" + attributeId + ", attributeName=" + attributeName + ", attributeValue="
				+ attributeValue + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(attributeId, attributeName, attributeValue);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attribute other = (Attribute) obj;
		return Objects.equals(attributeId, other.attributeId) && Objects.equals(attributeName, other.attributeName)
				&& Objects.equals(attributeValue, other.attributeValue);
	}
}
