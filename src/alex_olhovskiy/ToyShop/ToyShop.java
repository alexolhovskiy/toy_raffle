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
		System.out.println("Изначальный пул игрушек, участвующих в розыгрыше");
		System.out.println(allToies);
		String c="";
		while(!c.equals("q"))
		{
			System.out.println("Нажмите любую клавишу чтобы продолжить цикл розыгрыша");
			c=input.next();
			
			ArrayList<MyToy>temp=(takeSample(allToies,allToies.size()));
			deltaArr(allToies,temp);
			vinningToies.addAll(temp);
			System.out.println("Выиграные игрушки");
			System.out.println(vinningToies);
			System.out.println("Игрушки оставшиеся не выиграными");
			System.out.println(allToies);
			
			for(int i=0;i<vinningToies.size();i++)
			{
				allToies.add(randomToyGenerator());
			}
			
			temp=takeSample(vinningToies,vinningToies.size());
			deltaArr(vinningToies,temp);
			takingToies.addAll(temp);
			System.out.println("Выиграные игрушки, которые забрали");
			System.out.println(takingToies);
			System.out.println("Выиграные игрушки, которые не забрали");
			System.out.println(vinningToies);
			
			System.out.println("Пополненный пул разыгрываемых игрушек");
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
