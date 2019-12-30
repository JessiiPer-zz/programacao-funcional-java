package br.com.udemy.services;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import br.com.udemy.entities.Product;

public class ProductService {

	//A PARTIR DE UMA LISTA DE PRODUTOS, CALCULE A SOMA DOS PREÇOS SOMENTE DOS PRODUTOS QUE COMECEM COM A LETRA T
	//BASICAMENTE, VAMOS TESTAR UMA FUNÇÃO QUE RECEBA UMA FUNÇÃO
	public double filteredSum(List<Product> list, Predicate<Product> criteria) { //O Predicate é uma interface funcional, que possui um metodo abstrato teste, onde seu retorno é um boolean.
		double sum = 0.0;
		for(Product p : list) {
			if(criteria.test(p)) {
				sum += p.getPrice();
			}
		}
		return sum;
	}
	
	// A PARTIR DA LISTA DE PRODUTOS GERE UMA NOVA LISTA, CONTENDO OS NOMES DOS PRODUTOS EM CAIXA ALTA
	// MAP = É UMA FUNÇÃO QUE APLICA UMA FUNÇÃO A TODOS OS ELEMENTOS DE UMA STREAM
	public void testMap(List<Product> list){
		//Function<Product, String> func = p -> p.getName().toUpperCase(); // só pra lembrar que essa expressão veio do Function
		
		 List<String> nomes = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
		nomes.forEach(System.out :: println);
	}
	
	//USANDO O COMPARATOR PARA ORDENAR MINHA LISTA POR ORDEM ALFABÉTICA.
	public void testComparator(List<Product> list) {
		Comparator<Product> comp = (p1,p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		list.sort(comp);
		System.out.println(list);
	}
	
	//A PARTIR DE UMA LISTA DE PRODUTOS, REMOVA DA LISTA SOMENTE AQUELES CUJO PREÇO MÍNIMO SEJA 100 REAIS.
	public void testPredicate(List<Product> list) {
		//Predicate<Product> prod = p -> p.getPrice() >= 100;
		//list.removeIf(prod);
		list.removeIf(Product :: nonStaticProductPredicate); //Method References
		list.removeIf(p -> p.getPrice() >= 100); //veio do predicado
		list.forEach(System.out::println);
	}
	
	//AUMENTAR 10% EM CIMA DO VALOR DO PRODUTO - USANDO CONSUMER
	public void testConsumer(List<Product> list) {
		Consumer<Product> cons = p -> {
			p.setPrice(p.getPrice() * 1.1);
		};
		list.forEach(cons);
		list.forEach(System.out::print);
		//list.forEach(p -> p.setPrice(p.getPrice() * 1.1)); // Forma abreviada do consumer
	
	}
}
