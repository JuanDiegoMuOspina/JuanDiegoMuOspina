package com.juan.clase.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.juan.clase.bean.Celular;
import com.juan.clase.bean.User;
import com.juan.clase.repository.UserRepository;

import output.RespuesBd;

import com.juan.clase.repository.CelularRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/celular") // This means URL's start with /demo (after Application path)
public class MainControllercelular {
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private CelularRepository userCelular;

	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody RespuesBd addNewUserCelular(@RequestParam String marca, @RequestParam(required = false) String modelo,
			 Long numero) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		RespuesBd respuesta = new RespuesBd();
		Celular n= new Celular();
		n.setMarca(marca);
		n.setModelo(modelo);
		n.setNumero(numero);

		try {
			userCelular.save(n);
			respuesta.setError("usuario celular Salvado");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			respuesta.setRespuesta("Error en agregar usuario  celular");
			respuesta.setError(e.getMessage());
		}
		return respuesta;

	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Celular> getAllUsers() {
		// This returns a JSON or XML with the users
		return userCelular.findAll();
	}
	@GetMapping(path = "/micell")
	public @ResponseBody Optional<Celular> Mycelular(@RequestParam int id) {
		// This returns a JSON or XML with the users
		return  userCelular.findById(id);
	}
}