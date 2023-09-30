/******************************************************************************

 https://gb.ru/lessons/367278/homework
*******************************************************************************/
// import static org.junit.Assert.*;  // https://junit.org/junit4/javadoc/latest/org/junit/Assert.html

import src.model.ToysHouse;

import src.model.PrizHouse;

import src.model.ToyComparatorByName;

import src.model.ObjIO;


import src.view.View;
import src.view.ConsoleUI;
import src.presenter.Presenter;

//Console;

import java.io.*; // Serializable
import java.util.ArrayList;

public class Main
{
	public static String toysFiles = "ToyStore.txt";
	public static String toysPriz = "PrizToy.txt";

//	public static String fHumanTreeLog = "HumanTree.log";


	public static ToysHouse newToysHouse;
	public static PrizHouse newPrizHouse;
	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		System.out.println("Hello World\n OOP_ToysLottery \n");
		
		TestMVP();
	}


	public static void TestMVP(){
		View view = new ConsoleUI();

		newToysHouse = new ToysHouse();
		newToysHouse.setFileName(toysFiles);

		ObjIO serialize = new ObjIO();
		ArrayList<String> aList = serialize.readFileTXT(toysFiles);
		deCode(aList);


		newPrizHouse = new PrizHouse();
		ArrayList<String> aListP = serialize.readFileTXT(toysPriz);

//		System.out.println("aListP  \n " + aListP.toString());


		deCodePriz(aListP);
		newPrizHouse.setFileName(toysPriz);

		ToyComparatorByName sortName =  new ToyComparatorByName();
		new Presenter(view, newToysHouse, newPrizHouse, serialize, sortName);
		view.start();
	}

	public static void deCodePriz(ArrayList<String>  aList){
		String[] secondArray = new String[3];
		int fooInd, fooWinner;

		for (int j = 0; j < aList.size(); j++) {
			secondArray = aList.get(j).split(";");

			if (secondArray.length == 3){
				try {
					fooInd = Integer.parseInt(secondArray[0]);
				} catch (NumberFormatException e) {
					fooInd = 0;
				}

				try {
					fooWinner = Integer.parseInt(secondArray[2]);
				} catch (NumberFormatException e) {
					fooWinner = 0;
				}

//				System.out.println(fooInd + " \t " +  secondArray[1]
//						+ " \t " + fooWinner);
				newPrizHouse.addWinner(fooInd, secondArray[1] , fooWinner);
			}
		}

	}


	public static void deCode(ArrayList<String> aList){
		String[] secondArray = new String[4];
		int fooCount, fooWeight;

		for (int j = 0; j < aList.size(); j++) {
			secondArray = aList.get(j).split(";");
//			System.out.println(j + " deCode \n");

			if (secondArray.length == 4){
				try {
					fooCount = Integer.parseInt(secondArray[2]);
				} catch (NumberFormatException e) {
					fooCount = 0;
				}

				try {
					fooWeight = Integer.parseInt(secondArray[3]);
				} catch (NumberFormatException e) {
					fooWeight = 0;
				}
				newToysHouse.addToy(secondArray[1], fooCount, fooWeight);
			}
		}
	}
}
