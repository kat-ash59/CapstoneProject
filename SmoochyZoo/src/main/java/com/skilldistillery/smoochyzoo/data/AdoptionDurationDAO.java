package com.skilldistillery.smoochyzoo.data;

import java.util.List;

import com.skilldistillery.jpasmoochyzoo.entities.AdoptionDuration;

public interface AdoptionDurationDAO 
{

	public int deleteAdoptionDuration(AdoptionDuration adoptionDuration);

	public AdoptionDuration updateAdoptionDuration(AdoptionDuration adoptionDuration);

	public AdoptionDuration addAdoptionDuration(AdoptionDuration adoptionDuration);

	public List<AdoptionDuration> findAllAdoptionDurations();

	public AdoptionDuration findAdoptionDurationById(int id);

}
