package br.com.roger.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CriarUsuarioRequestDto {

	@Size(min = 8, max = 150, message = "Por Favor, inforem o noem de 8 a 150 caracteres.")
	@NotEmpty(message = "Por Favor, informe o nome do usuário.")
	private String nome;

	@Email(message = "Por Favor, informe um endereço de email válido.")
	@NotEmpty(message = "Por Favor, informe o email do usuário.")
	private String email;

	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\\$%\\^&\\*])(?=\\S+$).{8,}$", message = "Por favor, informe a senha com letras minúsculas, maiúsculas, números, símbolos e pelomenos 8 caracteres.")
	@NotEmpty(message = "Por Favor, informe a senha do usuário.")
	private String senha;

}
