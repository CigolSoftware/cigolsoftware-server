package com.cigolsoftware.cigol.utilities;

import java.util.Arrays;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import com.cigolsoftware.cigol.configurations.ControlledException;
import com.cigolsoftware.cigol.enums.Reply;

public class Tools {

	public static String capitalizeAll(final String string) {
		return String.join(" ", Arrays.asList(string.split(" ")).stream().filter(s -> !s.trim().isEmpty())
				.map(s -> StringUtils.capitalize(s.toLowerCase())).toList());
	}

	public static <S, T> T copyProperties(final S source, final T target) {
		BeanUtils.copyProperties(source, target);
		return target;
	}

	public static void ifThrow(final Boolean conditional, final Reply reply) {
		if (Boolean.TRUE.equals(conditional)) {
			throw new ControlledException(reply);
		}
	}

	private Tools() {

	}
}
