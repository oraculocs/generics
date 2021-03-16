package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Produto;
import services.CalculationService;

public class ProgramProduto {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		/*
		 * Uma empresa de consultoria deseja avaliar a performance de produtos,
		 * funcionários, dentre outras coisas. Um dos cálculos que ela precisa é encontrar
		 * o maior dentre um conjunto de elementos. Fazer um programa que leia um
		 * conjunto de produtos a partir de um arquivo, conforme exemplo, e depois
		 * mostre o mais caro deles.
		 * 
		 * Computer,890.50
		 * IPhone X,910.00
		 * Tablet,550.00
		 * Most expensive:
		 * IPhone, 910.00
		 */
		
		List<Produto> list = new ArrayList<>();
		
		String path = "c:\\temp\\generic.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				list.add(new Produto(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			
			Produto x = CalculationService.max(list);
			System.out.println("Most expensive: ");
			System.out.println(x);
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
