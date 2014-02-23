package com.sample.security;

import java.util.HashSet;
import java.util.Set;

public class UserTracker {
	private static Set<String> loggedInUsersDetails = new HashSet<String>();
	synchronized public static boolean increment(String userName) {  
		if(loggedInUsersDetails.add(userName.toLowerCase())){
			return true;
		}else 
			return false;
		
		}       
	
	synchronized public static void decrement(String userName) {    
		loggedInUsersDetails.remove(userName.toLowerCase());  
		} 

}
