package com.example.demo.repository;
import com.example.demo.entity.*;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact,Serializable> {
	
	public abstract Contact findById(int id);
	
}
