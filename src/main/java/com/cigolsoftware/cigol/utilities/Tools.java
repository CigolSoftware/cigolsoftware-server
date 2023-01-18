package com.cigolsoftware.cigol.utilities;

import java.util.Arrays;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

public class Tools {

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
