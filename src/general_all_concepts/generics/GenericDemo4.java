package general_all_concepts.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo4 {

	public static void main(String[] args) {
		List<Child> children = new ArrayList<>();
		
//		processParentElements(children); // compilation error
		
		processElements(children);
		
		Child child = children.get(0);
		child.childSpecificMethod();
		
		List<Parent> parents = new ArrayList<>();
		List<Child> children2 = new ArrayList<>();
// 		processElements2(parents);
//		processElements2(children2);
		
		List<Grandchild> grandChildren = new ArrayList<>();
//		processElements2(grandChildren); // compilation error
		
		Child child2 = children.get(0);
		child.childSpecificMethod();
	}
	
	public static void processParentElements(List<Parent> parents) {}
	
	public static void processElements(List<? extends Parent> elements) {
//		 represents a wildcard with an upper bound
		 
		Parent parent = elements.get(0);
//		Child child = elements.get(0); // compilation error
//		
//		elements.add(new Parent()); // compilation error
//		elements.add(new Child()); // compilation error
//		elements.add(new Grandchild()); // compilation error
		
		elements.add(null);
	}
	
	public void doSomething(List<? super Child> myList) {
	    // You can add elements of type Child or any superclass of Child to the list
	    myList.add(new Child());
	    //myList.add(new Grandparent()); // Grandparent is a superclass of Child
	}
	
}

class Parent {}

class Child extends Parent {
	
	public void childSpecificMethod() {}
}

class Grandchild extends Child {}
