package com.juan.clase.repository;


import org.springframework.data.repository.CrudRepository;

import com.juan.clase.bean.Celular;



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface celularRepository extends CrudRepository<Celular, Integer> {

}