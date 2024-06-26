package com.soumya.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id")
	private Long customerId;
	
	@Column(name = "cust_name")
	private String customerName;
	
	@Column(name = "cust_address")
	private String customerAddress;
	
	@Column(name = "cust_email")
	private String customerEmail;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idproof_id",referencedColumnName = "id_key")
	@JsonManagedReference
	private IdProof idProof;

}
