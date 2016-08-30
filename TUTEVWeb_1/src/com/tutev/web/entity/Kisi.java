package com.tutev.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="gnl_kisi")
public class Kisi implements Serializable{

	private static final long serialVersionUID = 9087679367198685093L;
	
	Long id;
	String ad;
	String soyad;
	Date dogumTarihi;
	
	
	@Id
    @SequenceGenerator(name = "gnl_kisi_seq", sequenceName = "gnl_kisi_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "gnl_kisi_seq")
    @Column(name = "kisi_id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="ad",length=50)
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	
	@Column(name="soyad",length=50)
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	
	@Column(name="dogum_tarih")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDogumTarihi() {
		return dogumTarihi;
	}
	public void setDogumTarihi(Date dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}
	
	@Override
	public String toString() {
		return "Kisi [id=" + id + ", ad=" + ad + ", soyad=" + soyad
				+ ", dogumTarihi=" + dogumTarihi + "]";
	}
}
