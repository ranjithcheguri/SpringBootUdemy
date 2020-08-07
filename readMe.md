# SPRING BOOT MASTERCLASS
__`Spring is Dependency Injection Framework`__

#### Dependency
<img src="./Images/dependency.png" height="350" width="800">
- If a class is dependent on another class for some work to do, it is called dependency.
- This is `tight coupling` which is not good way to program

#### Dependency Injection / Inversion of Control
<img src="./Images/dependencyInjection.png" height="350" width="800">

- who is creating the instance of dependency in this example?

- The spring framework is creating the instance in here .(using autowiring)

- We are taking the control from the class that needs the dependency and giving the control to the framework to the spring framework. And this is called __`Inversion of control`__ and that leads us nicely into the next terminology

- IOC Container is a generic terminology to represent anything that is implementing inversion of control.

- In the case of Spring framework the typical IOC container is the application context.

#### Spring concepts

<img src="./Images/springConcepts.png" height="350" width="480">

#### Loose Coupling

- `start.spring.io` to start a spring project, it will provide all the required dependencies
- Here we have implemented loose coupling by passing the algorithm to use for sorting in the constructor.


>SortAlgorithm.java
```java

package com.ranjith.springbootdemo;

public interface SortAlgorithm {
	public int[] sort(int[] numbers);
}
```

>BubbleSortAlgoritm.java
```java
package com.ranjith.springbootdemo;

public class BubbleSortAlgorithm implements SortAlgorithm{
	public int[] sort(int[] numbers){
		// dummy impl
		return numbers;
	}
}
```
>QuickSortAlgorithm.java
```java
package com.ranjith.springbootdemo;

public class QucikSortAlgorithm implements SortAlgorithm{
	public int[] sort(int[] numbers){
		// dummy impl
		return numbers;
	}
}
```

>BinarySearchImpl.java
```java
package com.ranjith.springbootdemo;

public class BinarySearchImpl {
	SortAlgorithm sortAlgorithm;
	
	// ctrl + shift + s (short cut)
	// This is loose coupling, we pass the dependency to the binary search in constructor
	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}

	public int binarySearch(int[] numbers, int number) {
		//dummy implementation
		// 1. Sort
		
		/*
		 	This tight coupling, betwwen Binary search and bubble sort
			
			BubbleSortAlgorithm bsa = new BubbleSortAlgorithm();
			int[] sortednumbers = bsa.sort(numbers); 
		 */		
		
		// good programming 
		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		System.out.println("Algorithm used is :" + sortAlgorithm);
		
		// 2. Impl Binary Search
		// 3. Return index
		int index = 0;
		return index;
	}
}
```

>SpringbootdemoApplication.java
```java
package com.ranjith.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		BinarySearchImpl bs = new BinarySearchImpl(new BubbleSortAlgorithm());
		int result = bs.binarySearch(new int[] {1, 2, 3, 4}, 3);
		System.out.println(result);
		// ouput = Algorithm used is :com.ranjith.springbootdemo.BubbleSortAlgorithm@3764951d		
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}
}
```

#### @AutoWiring, @Component

- In the above example we are creating binarySearch object, we are creating bubbleSort object. Do we really need to do that ? Wouldn't it be great if our spring creates those for us ?
- Yes, We can use beans to create these objects with the help of spring framework
- In the above example we have one bean (binary Search) and one dependency (bubbleSort)
- If you look in the maven dependencies, spring beans, spring context, spring core are all there (indicates spring is already available for us). Things that we need to tell the spring framework are:
	- What are beans? (`@Component` to indicate beans, here BubbleSort, QuickSort)
	- What are the dependencies of the beans? (`@AutoWired` to indicate dependency, here sortAlgorithm in BinarySearchImpl)
	- Where to search for beans? (`@ComponentScan()` is used, or we can use `@SpringBootApplication` above main class, which indicates it searches current package and subpackages of it)

- SpringApplication.run(...) in main will return the Application context. We can use that application context to get the required beans. `applicationContext.getBean(BinarySearchImpl.class)`

- Now spring is managing beans, managing dependencies for those beans.

- To understand how these are managed by spring you can debug by `logging.level.org.springframework = debug` in `application.properties` file, which will produce lot of debug statements when you run
- You can search `BinarySearchImpl` and track whats being done.

- Process: First componentScan to find where it should search i.e here entire package --> find @Component tagged classes --> creates beans for those classes (if no dependencies) --> (If dependencies) Autowiring via constructor to bean --> this ends creation of beans(with dependencies).

- check issue 1, in that case, we can use `@Primary` for either BubbleSort/QuickSort. (This is dynamic auto wiring )

- __`Contructor Injection / Setter Injection`__ - when you autowire the dependencies in the component you can do it in either way.
- Even though there is no setter, you can just use `@AutoWired SortAlgorithm sortAlgorithm;` and this is enough, kind of works like setter. so need to implement setter also.

#### Issues Faced:

- `Issue 1` : Parameter 0 of constructor in com.ranjith.springbootdemo.BinarySearchImpl required a single bean, but 2 were found:
- `Context`: When I used @Component for both bubble and quick sort. (@Autowired for sortAlgorithm variable in BinarySearchImpl)
- `Action`: Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed.
- __`Spring trouble shooting guide`__ https://github.com/in28minutes/in28minutes-initiatives/tree/master/The-in28Minutes-TroubleshootingGuide-And-FAQ

>SpringbootdemoApplication.java (after autowiring)
```java
package com.ranjith.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = SpringApplication.run(SpringbootdemoApplication.class, args);
		BinarySearchImpl bs = applicationContext.getBean(BinarySearchImpl.class);
		
		int result = bs.binarySearch(new int[] {1, 2, 3, 4}, 3);
		System.out.println(result);
	}
}
```
#### Spring Modules

<img src="./Images/springModules.png" height="450" width="800">

#### @AutoWiring by name and by @Primary

- @Primary is used for one of the component either bubbleSort or Quick sort. ( just like how we used previously )

- by name is --> instead of creating instance like this `SortAlgorithm sortAlgorithm`, we can directly create `SortAlgorithm bubbleSortAlgorithm` (it directly invokes bubbleSort, we need not initialize that variable also)
- What if I use `SortAlgorithm bubbleSortAlgorithm` and `@Primary` tag for QucikSortAlgorithm ? Quicksort algorithm will be executed __`priority of autowiring by @Primary > autowiring by name`__


#### @Qualifier

- Other than autowiring by name and primary, we can also define qualifier like `@Qualifier("quick")` for QuickSortAlgorithm and `@Qualifier("bubble")` for BubbleSortAlgorithm and we can autowire in BinarySearchImpl using the same `@Qualifier("bubble")`.

- Using this qualifiers, if we need to use different sorting techniques at different places, we can just use the Qualifier tag for that SortAlgorithm Interface instantiation i.e `@Qualifier("quick) SortAlgorithm sortAlgorithm"`

- using just `Qualifier` without any tag name also worked, but we have that for only one component, (just like how primary works)


