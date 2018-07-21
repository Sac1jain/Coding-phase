package com.myplace.demorest;

import java.util.ArrayList;
import java.util.List;

public  class AlienRepository {
	
	private   List<Alien> aliens;
	
	public AlienRepository()
	{	
		aliens=new ArrayList<Alien>();
		Alien a1=new Alien();
		a1.setId(1);
		a1.setName("Sachin");
		a1.setPoint(60);
		aliens.add(a1);
		
		Alien a2=new Alien();
		a2.setId(2);
		a2.setName("Mehek");
		a2.setPoint(90);
		aliens.add(a2);
		
		Alien a3=new Alien();
		a3.setId(3);
		a3.setName("Sanju");
		a3.setPoint(55);
		aliens.add(a3);
		
		Alien a4=new Alien();
		a4.setId(4);
		a4.setName("Rehhna");
		a4.setPoint(80);
		aliens.add(a4);
	}
	
	public  List<Alien> getAllAliens()
	{	
		return aliens;
	}
	
	public  Alien getAlien(int id)
	{
		for (Alien alien : aliens) {
			if(alien.getId()==id) {
				return alien;
			}
		}
		return new Alien();
		
	}
	
	public  List<Alien> createAlien(Alien alien) {
		aliens.add(alien);
		return aliens;
	}
	
	public  List<Alien> updateAlien(Alien alien) 
	{
		for (Alien a : aliens) {
			if(a.getId()==alien.getId())
			{
				a.setId(alien.getId());
				a.setName(alien.getName());
				a.setPoint(alien.getPoint());
			}
		}
		return aliens;
	}
	
	public  List<Alien> deleteAlien(int id)
	{
		aliens.remove(getAlien(id));
		return aliens;
	}

}
