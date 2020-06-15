/**
 * 
 */
package com.incubyte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author saiprasad
 *
 */
public class Calculator {


	public Integer add(String numbers) {
		try {
			if(numbers == null || numbers.isEmpty()) {
				return 0;
			}
			Integer result = 0;			
			List<String> numberList = createList(numbers);

			if(numberList != null) {
				List<String> negatives = numberList.stream()
						.filter(n-> Integer.parseInt(n)<0).collect(Collectors.toList());
				if(negatives != null && negatives.size()>1) {
					throw new RuntimeException("negatives not allowed: "+String.join(",",negatives));
				}
				result = numberList.stream().mapToInt(n-> Integer.parseInt(n) ).sum();
			}
			return result;
		}
		catch(NumberFormatException ex) {
			throw new RuntimeException("invalid argument passed: "+numbers);
		}
	}

	private List<String> createList(String text) {
		if(text.startsWith("//")) {
			//split using custom delimiter:
			Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(text);
			m.matches();
			String customDelimiter = m.group(1);
			String numbers = m.group(2);
			String []arr = numbers.split(Pattern.quote(customDelimiter));
			return Arrays.asList(arr);		
		} else {
			String []arr = text.split(",|\n");
			return Arrays.asList(arr);	
		}
	}

}
