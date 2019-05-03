package com.chocobo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    
	public static void main( String[] args )
    {
        start();
    }
    
    public static void start() {
    	System.out.println( "Hello World!\n" );
        Scanner sc = new Scanner(System.in);
        
        Map<Integer, Map<String, String>> storedMap = new HashMap<>();
        String choose = null;
        
        do {
        	do {
        		System.out.println("Choose Answer [1/2/3], Q to exit : ");
                choose = sc.nextLine();
			} while(!choose.equals("1") && !choose.equals("2") && !choose.equals("3") && !choose.equalsIgnoreCase("q"));
		
	        int castChoose = StringUtils.isNumeric(choose) ? Integer.parseInt(choose) : 0; 
	        switch (castChoose) {
				case 1:
					String decision = null;
					do {
						System.out.println("What do you want [Store|load] : ");
						decision = sc.nextLine();
					} while (!decision.equalsIgnoreCase("store") && !decision.equalsIgnoreCase("load"));
					
					if (decision.equalsIgnoreCase("store")) {
						store(storedMap, sc);
					}else {
						System.out.println("result "+ load(storedMap) + "\n");
					}
					
					break;
				case 2:
					System.out.println("Sorry, Dont Understand the question (No Answer)");
					break;
				case 3:
					System.out.println("Amount : $" + geneatePayableAmount(registerUserForTest(sc)));
					break;
		
				default:
					break;
				}
        } while (!choose.equals("q"));
    }
    
    private static void store(Map<Integer, Map<String,String>> storedMap, Scanner sc) {
    	String index = null;
    	String key = null;
    	String value = null;
    	
//    	String inputtedValue = null;
//    	do {
//    		System.out.print("Input Your Values to store : ");
//    		inputtedValue = sc.nextLine();
//    	}while(inputtedValue.isEmpty());
    	
//    	String[] splitted = inputtedValue.split("\n");
//    	List<String> keys = new ArrayList<String>();
//    	List<String> values = new ArrayList<String>();
//    	for (String s : splitted) {
//			if (s.contains(";")) {
//				String[] split = s.split(";");
//				for (String str : split) {
//					if (str.contains("key")) {
//						keys.add(str.split("=")[1]);
//					}else {
//						values.add(str.split("=")[1]);
//					}
//				}
//			}else {
//				values.add(s.split("=")[1]);
//			}
//		}
    	Map<String, String> map = new HashMap<String, String>();
    	
    	do {
    		System.out.print("Index : ");
        	index = sc.nextLine();
    	}while(index.isEmpty() && !StringUtils.isNumeric(index));
    	
    	String answer = null;
    	do {
    		System.out.print("Key : ");
        	key = sc.nextLine();
			
        	System.out.print("Value : ");
        	value = sc.nextLine();	
	    	
	    	map.put(key, value);
	    	System.out.println("add another key-value for this index "+index+" [q to quit] : ");
	    	answer = sc.nextLine();
    	}while (!answer.equalsIgnoreCase("q"));
    	

    	storedMap.put(Integer.parseInt(index), map);
    	System.out.println("stored successfully\n");
    }
    
    @Deprecated
    public static String load(Map<String, String> storedMap, String asd) {
    	StringBuilder result = new StringBuilder();
    	List<String> keys = new ArrayList<String>();
    	List<String> values = new ArrayList<String>();
    	storedMap.entrySet().stream().forEach(e ->
    		storeTemp(keys, values, e.getKey(), e.getValue())
    	);
    	
    	for (int i = 1; i <= keys.size(); i++) {
    		if (i == keys.size()) {
    			result.append("key"+i+"=").append(keys.get(i-1));
			}else {
				result.append("key"+i+"=").append(keys.get(i-1)).append(";");
			}
		}
    	
    	for (int i = 1; i <= values.size(); i++) {
    		if (i == values.size() && i != 1) {
    			result.append("value"+i+"=").append(keys.get(i-1));
			}else if (i == values.size() && i ==1) {
				result.append("\\nvalue"+i+"=").append(keys.get(i-1));
			}else if (i ==1) {
				result.append("\\nvalue"+i+"=").append(keys.get(i-1)).append("\\n");
			}else {
				result.append("value"+i+"=").append(keys.get(i-1)).append("\\n");
			}
		}
    	return result.toString();
    }
    
    public static String load(Map<Integer,Map<String,String>> storedMap) {
    	StringBuilder result = new StringBuilder();
    	Integer maxLoopIdx = storedMap.size();
    	Integer currLoopIdx = 1;
    	for (Map.Entry<Integer, Map<String, String>> map : storedMap.entrySet()) {
    		int maxLoopValue = map.getValue().size();
			int currLoopValue = 1;
			for (Map.Entry<String, String> valuemap : map.getValue().entrySet()) {
				if (currLoopValue == maxLoopValue) {
					result.append(valuemap.getKey()).append("=").append(valuemap.getValue());
				}else {
					result.append(valuemap.getKey()).append("=").append(valuemap.getValue()).append(";");
				}
				currLoopValue++;
			}
			if (currLoopIdx != maxLoopIdx) {
				result.append("\\n");
			}
			currLoopIdx++;
		}
    	return result.toString();
    }
    
    public static void storeTemp(List<String> keys, List<String> values, String key, String value) {
    	keys.add(key);
    	values.add(value);
    }
    
    public static User registerUserForTest(Scanner sc) {
    	User user = new User();
    	
    	System.out.print("User Type [Employee|Affiliate|Customer]: ");
    	user.setUserType(sc.nextLine());
    	
    	System.out.print("Product Type [Groceries]: ");
    	user.setProductType(sc.nextLine());
    	
    	String count = null;
    	do {
	    	System.out.print("User Long Time Joined : ");
	    	count = sc.nextLine();
    	}while(!StringUtils.isNumeric(count));
    	user.setLongTimeJoined(Integer.parseInt(count));
    	
    	String amount = null;
    	do {
    		System.out.print("Bill Amount : ");
    		amount = sc.nextLine();
		} while (!StringUtils.isNumeric(amount));
    	user.setAmount(amount);
    	
    	return user;
    }
    
    public static String geneatePayableAmount(User user) {
    	double result = 0;
    	
    	int castAmount = Integer.parseInt(user.getAmount());
    	int billDisc = (castAmount / 100) * 5;
    	int userDisc = 0;
    	
    	if (user.getUserType().equalsIgnoreCase("employee")) {
			userDisc = 30; 
		}else if (user.getUserType().equalsIgnoreCase("affiliate")) {
			userDisc = 10;
		}else if (user.getUserType().equalsIgnoreCase("customer")) {
			if (user.getLongTimeJoined() >= 2) {
				userDisc = 5;
			}
		}
    	
    	if (user.getProductType().equalsIgnoreCase("groceries")) {
			result = castAmount - billDisc;
		}else {
			result = (castAmount - ((double) castAmount * userDisc / 100)) - billDisc; 
		}
    	
    	return String.valueOf(result);
    }
    
}
