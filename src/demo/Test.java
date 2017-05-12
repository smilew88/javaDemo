package demo;

import java.util.Arrays;
import java.util.List;

import net.hydromatic.linq4j.Linq4j;

public class Test {

	public static void main(String[] args) {
		List<Integer> iList = Arrays.asList(1,2,3,4,5);
		Linq4j.asEnumerable(iList).select(it->String.valueOf(it*3)).toList();
		Linq4j.asEnumerable(iList).select(it->
		{
			Integer a = it+1;
			a+=1;
			return a;
		}).toList();
		int aa =Linq4j.asEnumerable(iList).aggregate(0,(acc,it)->acc+it);
		System.out.println(aa);
	}
}
