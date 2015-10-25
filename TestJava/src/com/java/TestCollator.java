package com.java;

import java.text.Collator;

public class TestCollator {

	public static void main(String[] args) {
		Collator collator =  Collator.getInstance();
		System.out.println("a equals b -> " + (collator.compare("a", "b")==0 ? "true":"false"));
		System.out.println("a equals à -> " + (collator.compare("a", "à")==0 ? "true":"false"));
		System.out.println("A equals a -> " + (collator.compare("a", "A")==0 ? "true":"false"));
		collator.setDecomposition(Collator.CANONICAL_DECOMPOSITION);
		String single = "abgaskr\u00FCmmerdichtung";
		String combined = "abgaskr\u0075\u0308mmerdichtung";

		System.out.println("Single equals combined? " + 
		    (collator.compare(single, combined) == 0 ? "true": "false"));
		
		
	}

}
