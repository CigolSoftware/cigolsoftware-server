package com.cigolsoftware.cigol.utilities;

import java.util.Arrays;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import com.cigolsoftware.cigol.dto.Body;
import com.cigolsoftware.cigol.enums.Reply;

public class Tools {

	public static ResponseEntity<Body<Void>> badRequest(final Reply reply) {
		return ResponseEntity.badRequest().body(Body.body(reply));
	}

	public static String capitalizeAll(final String string) {
		return String.join(" ", Arrays.asList(string.split(" ")).stream().filter(s -> !s.trim().isEmpty())
				.map(s -> StringUtils.capitalize(s.toLowerCase())).toList());
	}

	public static <S, T> T copyProperties(final S source, final T target) {
		BeanUtils.copyProperties(source, target);
		return target;
	}

	private Tools() {

	}
}
