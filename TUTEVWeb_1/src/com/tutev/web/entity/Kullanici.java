package com.tutev.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="gnl_kullanici")
public class Kullanici {
	
	Long id;
	String kullaniciAdi;
	String sifre;
	Kisi kisi;
	
	@Id
    @SequenceGenerator(name = "gnl_kullanici_seq", sequenceName = "gnl_kullanici_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "gnl_kullanici_seq")
    @Column(name = "kullanici_id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "kullanici_adi",length=30,unique=true)
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
	
	@Column(name = "kullanici_sifre")
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	
	@ManyToOne(optional = true)
    @JoinColumn(name="kisi_id",columnDefinition = "kisi_id")
	public Kisi getKisi() {
		return kisi;
	}
	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}
	@Override
	public String toString() {
		return "Kullanici [id=" + id + ", kullaniciAdi=" + kullaniciAdi
				+ ", sifre=" + sifre + ", kisi=" + kisi + "]";
	}
}
