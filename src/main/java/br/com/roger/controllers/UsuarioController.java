package br.com.roger.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.roger.dtos.AutenticarUsuarioRequestDto;
import br.com.roger.dtos.CriarUsuarioRequestDto;
import br.com.roger.services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping("criar")
	public String criar(@Valid @RequestBody CriarUsuarioRequestDto dto) {
		return usuarioService.criarUsuario(dto);
	}

	@PostMapping("autenticar")
	public String autenticar(@Valid @RequestBody AutenticarUsuarioRequestDto dto) {
		return usuarioService.autenticarUsuario(dto);
	}

}
