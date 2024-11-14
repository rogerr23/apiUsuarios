package br.com.roger.components;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.roger.entities.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenComponent {

	public String generateToken(Usuario usuario) {

		var dataAtual = new Date();

		return Jwts.builder().setSubject(usuario.getEmail()).setNotBefore(dataAtual)
				.setExpiration(new Date(dataAtual.getTime() + 900000))
				.signWith(SignatureAlgorithm.HS256, "e5934c93-0002-47b4-a9c2-86ac68e518f3").compact();

	}

}
