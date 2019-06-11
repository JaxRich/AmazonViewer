package com.ssbaez.amazonviewer.model;

public interface MyInterfaceV2 {
	
	default void defaultMethod() {
		privateMethod("Hello from the method the default method");
	}
	
	private void privateMethod(final String string) {
		System.out.println(string);
	}
	
	void normalMethod();


}
