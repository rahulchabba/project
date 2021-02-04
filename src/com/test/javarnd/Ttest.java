package com.test.javarnd;/*
 * Copyright (c) 2021.
 * Author : Rahul Sharma
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.script.ScriptException;


public class Ttest {
/*public static void main(String[] args) {
	String str = "ALIA’S house get distinct characters";
	str.chars().mapToObj(e -> Character.toString((char) e))
    .distinct()
    .forEach(System.out::print);
	System.out.println(countUniqueCharacters(str));
} 

public static int countUniqueCharacters(String input) {
	 return (int) input.chars()
	            .distinct()
	            .count();
}
 

*/
	  public static void main(String[] args) throws ScriptException {
		/*  List<Integer> levels = Arrays.asList(5,3,6,7,4);  
		  System.out.println(maxTrailing(levels));*/
		  
		 List< List<Integer> > logs =   Arrays.asList(Arrays.asList(184),
				 Arrays.asList(2),
				 Arrays.asList(38,47),
				 Arrays.asList(44,6),
				 Arrays.asList(67,46),
				 Arrays.asList(30,3),
				 Arrays.asList(3,32),
				 Arrays.asList(21,48),
				 Arrays.asList(14,40),
				 Arrays.asList(11,57),
				 Arrays.asList(3,37),
				 Arrays.asList(32,17),
				 Arrays.asList(48,29),
				 Arrays.asList(3,10),
				 Arrays.asList(13,41),
				 Arrays.asList(58,14),
				 Arrays.asList(20,6),
				 Arrays.asList(53,43),
				 Arrays.asList(60,69),
				 Arrays.asList(44,38),
				 Arrays.asList(52,57),
				 Arrays.asList(30,3),
				 Arrays.asList(62,54),
				 Arrays.asList(35,50),
				 Arrays.asList(49,18),
				 Arrays.asList(66,45),
				 Arrays.asList(4,51),
				 Arrays.asList(22,27),
				 Arrays.asList(37,51),
				 Arrays.asList(33,24),
				 Arrays.asList(37,61),
				 Arrays.asList(66,32),
				 Arrays.asList(5,56),
				 Arrays.asList(67,48),
				 Arrays.asList(27,6),
				 Arrays.asList(4,40),
				 Arrays.asList(55,8),
				 Arrays.asList(3,46),
				 Arrays.asList(25,46),
				 Arrays.asList(5,38),
				 Arrays.asList(24,15),
				 Arrays.asList(8,1),
				 Arrays.asList(27,39),
				 Arrays.asList(19,29),
				 Arrays.asList(64,5),
				 Arrays.asList(65,52),
				 Arrays.asList(13,30),
				 Arrays.asList(27,61),
				 Arrays.asList(50,29),
				 Arrays.asList(47,23),
				 Arrays.asList(5,7),
				 Arrays.asList(26,50),
				 Arrays.asList(25,1),
				 Arrays.asList(58,29),
				 Arrays.asList(8,62),
				 Arrays.asList(18,63),
				 Arrays.asList(63,43),
				 Arrays.asList(12,37),
				 Arrays.asList(7,31),
				 Arrays.asList(36,42),
				 Arrays.asList(35,70),
				 Arrays.asList(41,30),
				 Arrays.asList(32,60),
				 Arrays.asList(18,68),
				 Arrays.asList(32,12),
				 Arrays.asList(30,6),
				 Arrays.asList(68,48),
				 Arrays.asList(48,67),
				 Arrays.asList(37,34),
				 Arrays.asList(37,36),
				 Arrays.asList(40,44),
				 Arrays.asList(29,55),
				 Arrays.asList(33,32),
				 Arrays.asList(4,40),
				 Arrays.asList(11,40),
				 Arrays.asList(39,39),
				 Arrays.asList(11,46),
				 Arrays.asList(47,10),
				 Arrays.asList(19,54),
				 Arrays.asList(7,6),
				 Arrays.asList(12,62),
				 Arrays.asList(40,36),
				 Arrays.asList(45,9),
				 Arrays.asList(42,29),
				 Arrays.asList(64,11),
				 Arrays.asList(55,21),
				 Arrays.asList(5,45),
				 Arrays.asList(18,25),
				 Arrays.asList(64,37),
				 Arrays.asList(18,22),
				 Arrays.asList(60,16),
				 Arrays.asList(3,57),
				 Arrays.asList(8,12),
				 Arrays.asList(66,49),
				 Arrays.asList(55,38),
				 Arrays.asList(29,2),
				 Arrays.asList(50,66),
				 Arrays.asList(16,68),
				 Arrays.asList(39,24),
				 Arrays.asList(34,69),
				 Arrays.asList(19,32),
				 Arrays.asList(7,30),
				 Arrays.asList(54,35),
				 Arrays.asList(14,24),
				 Arrays.asList(57,59),
				 Arrays.asList(5,31),
				 Arrays.asList(29,59),
				 Arrays.asList(70,19),
				 Arrays.asList(68,48),
				 Arrays.asList(15,7),
				 Arrays.asList(21,64),
				 Arrays.asList(1,44),
				 Arrays.asList(53,70),
				 Arrays.asList(35,16),
				 Arrays.asList(26,21),
				 Arrays.asList(65,10),
				 Arrays.asList(40,57),
				 Arrays.asList(33,13),
				 Arrays.asList(48,35),
				 Arrays.asList(36,58),
				 Arrays.asList(19,35),
				 Arrays.asList(23,52),
				 Arrays.asList(70,59),
				 Arrays.asList(37,34),
				 Arrays.asList(41,9),
				 Arrays.asList(2,63),
				 Arrays.asList(36,61),
				 Arrays.asList(2,2),
				 Arrays.asList(29,31),
				 Arrays.asList(51,36),
				 Arrays.asList(45,67),
				 Arrays.asList(53,57),
				 Arrays.asList(69,26),
				 Arrays.asList(3,27),
				 Arrays.asList(15,59),
				 Arrays.asList(23,38),
				 Arrays.asList(31,45),
				 Arrays.asList(33,57),
				 Arrays.asList(20,30),
				 Arrays.asList(39,11),
				 Arrays.asList(4,2),
				 Arrays.asList(62,52),
				 Arrays.asList(54,51),
				 Arrays.asList(11,5),
				 Arrays.asList(40,24),
				 Arrays.asList(20,62),
				 Arrays.asList(60,27),
				 Arrays.asList(64,14),
				 Arrays.asList(41,59),
				 Arrays.asList(47,66),
				 Arrays.asList(45,67),
				 Arrays.asList(41,11),
				 Arrays.asList(67,5),
				 Arrays.asList(47,3),
				 Arrays.asList(26,28),
				 Arrays.asList(30,27),
				 Arrays.asList(8,29),
				 Arrays.asList(9,33),
				 Arrays.asList(50,3),
				 Arrays.asList(27,20),
				 Arrays.asList(23,31),
				 Arrays.asList(57,58),
				 Arrays.asList(14,12),
				 Arrays.asList(12,63),
				 Arrays.asList(70,66),
				 Arrays.asList(62,70),
				 Arrays.asList(10,45),
				 Arrays.asList(61,32),
				 Arrays.asList(46,18),
				 Arrays.asList(58,49),
				 Arrays.asList(5,1),
				 Arrays.asList(41,29),
				 Arrays.asList(3,25),
				 Arrays.asList(27,50),
				 Arrays.asList(11,52),
				 Arrays.asList(13,65),
				 Arrays.asList(53,33),
				 Arrays.asList(56,11),
				 Arrays.asList(3,66),
				 Arrays.asList(61,10),
				 Arrays.asList(9,3),
				 Arrays.asList(59,64),
				 Arrays.asList(25,31),
				 Arrays.asList(60,61),
				 Arrays.asList(40,12),
				 Arrays.asList(13,47)
);
		 
		 
		 System.out.println(cacheContentsss(logs));
		    } 
	

	  public static int maxTrailing(List<Integer> levels) {
		    // Write your code here
		    int min=levels.get(0),max=-1;
		    for(int i=0;i<levels.size();i++)
		    {
		        if(levels.get(i)<min)
		        min=levels.get(i);
		        int x=levels.get(i)-min;
		        if(x!=0 && x>max)
		        max=x;
		    }
		    return max;
		    }

	  
	  public static List<Integer> cacheContentsss(List<List<Integer>> callLogs) {

		   Map<Integer, List<Integer>> allItems=new TreeMap<>();
		   for (List<Integer> callLog : callLogs) {
		       List<Integer> orDefault = allItems.getOrDefault(callLog.get(0), new ArrayList<>());
		       orDefault.addAll(callLog.subList(1,callLog.size()));
		       allItems.put(callLog.get(0), orDefault);
		   }

		   Set<Integer> inCache=new HashSet<>();

		   Map<Integer, Integer> cacheMap = new HashMap<>();
		   allItems.forEach((key, values) -> {
		       for(int thisItem : values){
		           cacheMap.put(thisItem, cacheMap.getOrDefault(thisItem, 0) + 2);
		           if(cacheMap.get(thisItem)>5){
		               inCache.add(thisItem);
		           }
		       }

		       Set<Integer> integers = cacheMap.keySet();
		       integers.forEach(integer -> {
		           if (!values.contains(integer)) {
		               if(cacheMap.get(integer)>0) {
		                   cacheMap.put(integer, cacheMap.get(integer) - 1);
		                   if(cacheMap.get(integer)<3){
		                       inCache.remove(integer);
		                   }
		               }
		           }
		       });
		   });

		   return new ArrayList<>(inCache);
		}


	  
	  
	} 
