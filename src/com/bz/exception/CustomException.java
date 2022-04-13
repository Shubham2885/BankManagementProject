package com.bz.exception;

public class CustomException {

	public static class CustomerNotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public CustomerNotFoundException(String messge) {
		 super(messge);
		}
	}
	
	public static class AccountNotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public AccountNotFoundException(String messge) {
		 super(messge);
		}
	}
}
