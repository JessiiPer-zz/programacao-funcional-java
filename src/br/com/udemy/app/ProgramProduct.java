package br.com.udemy.app;

import java.util.ArrayList;
import java.util.List;

import br.com.udemy.entities.Product;
import br.com.udemy.services.ProductService;

public class ProgramProduct {

	public static void main(String[] args) {
		
//		EXPRESSÃO LAMBDA CORRESPONDE A UMA FUNÇÃO ANÔNIMA DE PRIMEIRA CLASSE.
		
		ProductService ps = new ProductService();
		
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("HD Case", 90.00));
		list.add(new Product("Celular", 1500.00));
		list.add(new Product("TV", 2500.00));
		list.add(new Product("Notebook", 3500.00));
		list.add(new Product("Mouse", 50.00));
		
		ps.testComparator(list);
		
		ps.testPredicate(list);
		
		ps.testConsumer(list);
		
		ps.testMap(list);
		
		double value = ps.filteredSum(list, p -> p.getName().charAt(0) == 'M');
		System.out.println(value);
	
		
	
	}
}
