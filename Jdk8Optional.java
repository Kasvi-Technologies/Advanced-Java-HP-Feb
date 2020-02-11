package com.hp.jdk8features;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Jdk8Optional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Optional 
		
		//to check null values., 
		//You no need to handle any NullPointer exceptions
		
		String str = null;
		
		Optional<String> str1 = Optional.empty();
		System.out.println(str1.isPresent());
		
		Optional<String> gender = Optional.of("Male");
		System.out.println(gender.isPresent() + " " + gender.get());
		
		//ifPresent  - will perform actions
		gender.ifPresent((s)->System.out.println("gender:"+s));
		str1.ifPresent((s1)->System.out.println("will not be executed this business logic"));
		
		//orElse., if value not present, then it will use the specified value in orElse
		System.out.println(gender.orElse("defaultvalue")); //it prints male
		System.out.println(str1.orElse("defaultvalue")); //it prints defaultvalue
		
		//orElseGet - will get the value based on Action
		System.out.println(gender.orElseGet(()-> "Hi"));
		System.out.println(str1.orElseGet(()-> gender.get()));
		
		//filter
		Optional<String> finalStr = gender.filter(str10 -> str10.equals("Male"));
		System.out.println("finalStr:" + finalStr);
		
		Optional<String> genderStr = Optional.ofNullable(str);
		//if str is null, then getnderStr is Empty optional
		//if str has value, then genderStr will have Optional Object with that string
		System.out.println("genderStr:" + genderStr);
		System.out.println(genderStr.isPresent());
		
		
		List<String> strLst = Arrays.asList("sad","sadasd","sadasd");
		Optional<List<String>> strlstOptional = Optional.ofNullable(strLst);
		
		
		
	}

}
