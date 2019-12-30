package br.com.udemy.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProgramStream {

	public static void main(String[] args) {
		
		//STREAM - É UMA SEQUENCIA DE ELEMENTOS ADVINDA DEUMA FONTE DE DADOS QUE OFERECE SUPORTE A "OPERAÇÕES AGREGADAS"
		
		List<Integer> list = Arrays.asList(1,2,3,4);
		
		//CRIAR UMA STREAM A PARTIR DE UMA LISTA
		Stream<Integer> st1 = list.stream().map(x -> x * 2);
		System.out.println(Arrays.toString(st1.toArray()));
		
		//CRIAR UMA STREAM A PARTIR DO STREAM.OF
		Stream<String> st2 = Stream.of("Maria", "João", "Ana");
		System.out.println(Arrays.toString(st2.toArray()));
		
		//CRIAR UMA STRAM A PARTIR DE UMA INTERAÇÃO
		Stream<Integer> st3 = Stream.iterate(0, x -> x +3);
		System.out.println(Arrays.toString(st3.limit(10).toArray()));
		
		//FIBONACCH
		Stream<Long> st4 = Stream.iterate(new Long[] {0L,1L}, p -> new Long[] {p[1], p[0] + p[1]}).map(p-> p[0]);
		System.out.println(Arrays.toString(st4.limit(10).toArray()));
		
		/*PIPELINE: STREAMS SÃO PROJETADAS DE TAL MANEIRA QUE A MAIOR PARTE DE SUAS OPERAÇÕES RETORNAM NOVAS STREAMS.
		 *  DESSA FORMA, É POSSÍVEL CRIAR UMA CADEIA DE OPERAÇÕES QUE FORMAM UM FLUXO DE PROCESSAMENTO. 
		 *  A ISSO DAMOS O NOME DE PIPELINE;
		 */
		
		int sum = list.stream().reduce(0, (x , y) -> x + y);
		System.out.println("Soma: " + sum);
		
		List<Integer> newList = list.stream()
							.filter(x -> x % 2 == 0)
							.map(x -> x * 2)
							.collect(Collectors.toList());
		System.out.println(Arrays.toString(newList.toArray()));
	}
}
