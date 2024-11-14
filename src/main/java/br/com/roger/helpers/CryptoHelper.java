package br.com.roger.helpers;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class CryptoHelper {

	public static String SHA256Encrypt(String value) {

		try {

			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedHash = digest.digest(value.getBytes(StandardCharsets.UTF_8));

			return HexFormat.of().formatHex(encodedHash);
		}

		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Erro ao criptografar usando SHA-256", e);
		}
	}
}
