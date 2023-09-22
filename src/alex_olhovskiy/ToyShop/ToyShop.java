package alex_olhovskiy.ToyShop;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ToyShop {
	public static Random rand=new Random();
	public static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<MyToy>allToies=new ArrayList<>();
		ArrayList<MyToy>vinningToies=new ArrayList<>();
		ArrayList<MyToy>takingToies=new ArrayList<>();
		
		allToies=randomFill(10);
		System.out.println("Initial pool of toys participating in the drawing");
		System.out.println(allToies);
		String c="";
		while(!c.equals("q"))
		{
			System.out.println("Press any key to continue the drawing cycle");
			c=input.next();
			
			ArrayList<MyToy>temp=(takeSample(allToies,allToies.size()));
			deltaArr(allToies,temp);
			vinningToies.addAll(temp);
			System.out.println("Won toys");
			System.out.println(vinningToies);
			System.out.println("Toys left unwon");
			System.out.println(allToies);
			
			for(int i=0;i<vinningToies.size();i++)
			{
				allToies.add(randomToyGenerator());
			}
			
			temp=takeSample(vinningToies,vinningToies.size());
			deltaArr(vinningToies,temp);
			takingToies.addAll(temp);
			System.out.println("Toys won and taken away");
			System.out.println(takingToies);
			System.out.println("Won toys that were not taken");
			System.out.println(vinningToies);
			
			System.out.println("Replenished pool of raffled toys");
			System.out.println(allToies);
		}
	}
	
	public static ArrayList<MyToy> randomFill(int num){
		ArrayList<MyToy>returnArr=new ArrayList<>();
		int minnum=num/10;
		for(int i=0;i<minnum+rand.nextInt(num);i++)
		{
			returnArr.add(randomToyGenerator());
		}
		return returnArr;
	}
	
	public static ArrayList<MyToy>takeSample(ArrayList<MyToy>arr,int num){
		ArrayList<MyToy>returnArr=new ArrayList<>();
		for(int i=0;i<1+rand.nextInt(num);i++)
		{
			MyToy mt=randomChoise(arr);
			if(!returnArr.contains(mt))
			{
				returnArr.add(mt);
			}
		}
		return returnArr;
	}
	
	public static MyToy randomToyGenerator(){
		return new MyToy(ToyType.values()[rand.nextInt(ToyType.values().length-1)]);
	}
	
	public static MyToy randomChoise(ArrayList<MyToy>arr){
		return arr.get(rand.nextInt(arr.size()));
	}
	
	public static void deltaArr(ArrayList<MyToy>arr1,ArrayList<MyToy>arr2){
		for(MyToy toy:arr2)
		{
			arr1.remove(toy);
		}
	}
}
