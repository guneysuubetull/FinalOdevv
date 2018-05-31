package com.medipol.yazilimaraclari.SpringBootOrnek;

import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTServisiOrnek {

	private List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();

	public RESTServisiOrnek() {
		
	}
	
	public RESTServisiOrnek(List<Ogrenci> ogrenciler) {
		this.ogrenciler = ogrenciler;
	}
	
	class Ogrenci {
		String ad, soyad;
		public String getAd() { return ad;}
		public String getSoyad() { return soyad;}
	}

	/** http://localhost:8093/ogrenci/listele */
	@RequestMapping("/ogrenci/listele")
	public List<Ogrenci> ogrenciListele() {
		return ogrenciler;
	}

	/** http://localhost:8093/ogrenci/olustur?ad=Mehmet&soyad=Kara4  */
	@RequestMapping(value="/ogrenci/olustur",method = RequestMethod.GET)
	public synchronized Ogrenci ogrenciOlustur(String ad, String soyad) {
		return ogrenciEkle(ogrenciler, ad, soyad);
	}
	
	/** http://localhost:8093//ogrenci/olustur/post */
	@RequestMapping(
			value="/ogrenci/olustur/post", // hangi uri'den cevap verecegi
			method = RequestMethod.POST // sadece post istegi
	)
	public synchronized Ogrenci ogrenciOlusturPost(String ad, String soyad) {
		return ogrenciEkle(ogrenciler, ad, soyad);
	}
	
	protected Ogrenci ogrenciEkle(List<Ogrenci> liste, String ad, String soyad) {
		Ogrenci ogrenci = new Ogrenci();
		ogrenci.ad=ad;
		ogrenci.soyad=soyad;
		liste.add(ogrenci);
		return ogrenci;
	}
}
