package com.soumya.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Id_proof")
public class IdProof {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_key")
	private Long idProofkey;
	
	@Column(name = "id_type")
	private String idProofType;
	
	@Column(name = "id_num")
	private String idProofNumber;
	
	@OneToOne(mappedBy = "idProof")
	@JsonBackReference
	private Customer customer;
	
	
}
