package com.lucareto;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.lucareto.hero.Hero;
import com.lucareto.hero.WEAPON;

public class JAXBDemo {

	public static void main(String[] args) {

		//the main entry point for this API: JAXB context, call it with the instance of the class we want to
		//generate. Surround with throw and catch 
		try {
			JAXBContext context = JAXBContext.newInstance(Hero.class);
			//creating Marshaller
			Marshaller marshaller =context.createMarshaller();
			
			//create an object of hero... just for testing
			Hero hero = new Hero();
			hero.setHeroName("Luca");
			hero.setEmail("luca@gmail.com");
			hero.setWeapon(new WEAPON());
			
			//serialize into XML
			StringWriter writer = new StringWriter();
			marshaller.marshal(hero, writer);
			
			System.out.println(writer.toString());
			
			//to convert back, create unmarshaller
			Unmarshaller unMarshaller = context.createUnmarshaller();
			Hero heroResult = (Hero) unMarshaller.unmarshal(new StringReader(writer.toString()));
			
			System.out.println(heroResult.getHeroName());
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
