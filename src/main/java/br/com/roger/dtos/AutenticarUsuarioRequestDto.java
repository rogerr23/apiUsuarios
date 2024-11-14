package br.com.roger.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AutenticarUsuarioRequestDto {

	@Email(message = "Por Favor, informe um endereço de email válido.")
	@NotBlank(message = "Por Favor, informe o email do usuário.")
	private String email;

	@Size(min = 8, message = "Por Favor, informe a senha com pelo menos 8 caracteres.")
	@NotBlank(message = "Por Favor, informe a senha do usuário.")
	private String senha;

}
