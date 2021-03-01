package com.hilaltasolar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // hibernate'in anlayacaðý bir yapý oldu
@Table(name = "kisiler") // kisi sýnýfýný db'de kiþilere kaydeder
public class Kisi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id'i arttýracak
	private long id;
	@Column(length = 999, name = "adi") // adi þeklþinde kayýt et dendi
	private String ad;
	private String soyad;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

}
