package com.renfa.exception;

public class EmptyResultException extends Exception{  
     public EmptyResultException(String s){  
          super("EmptyResultException: " + s);  
     }  
}  