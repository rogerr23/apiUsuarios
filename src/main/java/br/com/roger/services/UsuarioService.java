package br.com.roger.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.roger.components.JwtTokenComponent;
import br.com.roger.dtos.AutenticarUsuarioRequestDto;
import br.com.roger.dtos.CriarUsuarioRequestDto;
import br.com.roger.entities.Usuario;
import br.com.roger.helpers.CryptoHelper;
import br.com.roger.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	JwtTokenComponent jwtTokenComponent;

	public String criarUsuario(CriarUsuarioRequestDto dto) {

		var usuario = new Usuario();

		usuario.setId(UUID.randomUUID());
		usuario.setNome(dto.getNome());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(CryptoHelper.SHA256Encrypt(dto.getSenha()));

		if (usuarioRepository.existsByEmail(usuario.getEmail())) {
			throw new IllegalArgumentException("O email informado já está cadastrado.");
		}

		else {
			usuarioRepository.save(usuario);

			return "Usuário cadastrado com sucesso.";

		}
	}

	public String autenticarUsuario(AutenticarUsuarioRequestDto dto) {

		var usuario = usuarioRepository.find(dto.getEmail(), CryptoHelper.SHA256Encrypt(dto.getSenha()));

		if (usuario != null) {

			return jwtTokenComponent.generateToken(usuario);

		}

		else {
			return "Acesso negado. Usuário não encontrado.";
		}

	}
}
