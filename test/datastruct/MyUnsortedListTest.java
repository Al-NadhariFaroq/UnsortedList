package datastruct;

import org.junit.*;
import static org.junit.Assert.*;

public class MyUnsortedListTest {
	@Test
	public void isNotEmptyTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(1);
		assertFalse("new list", list.isEmpty());
	}
	
	@Test
	public void isEmptyTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		assertTrue("new list", list.isEmpty());
	}
	
	@Test
	public void isNotEmptyMultipleElementTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		for(int i = 0; i < 10; i++) {
			list.append(15);
		}
		assertFalse("new list with multiple elements", list.isEmpty());
	}
	
	@Test
	public void sizeCreationOneElementTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(1);
		assertEquals("1 element", 1, list.size());
	}
	
	@Test
	public void sizeCreationMultipleElementTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4);
		assertEquals("create a list elements", 4, list.size());
	}
	
	@Test
	public void sizeElementsPrependTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		for(int i = 0; i < 10; i++) {
			list.prepend(15);
		}
		assertEquals("10 elements", 10, list.size());
	}
	
	@Test
	public void sizePopTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4);
		list.pop();
		assertEquals("pop 1 element", 3, list.size());
	}
	
	@Test
	public void sizePopLastTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4);
		list.popLast();
		assertEquals("poplast 1 element", 3, list.size());
	}
	
	@Test
	public void sizeRemoveTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4);
		list.remove(0);
		assertEquals("remove 1 element", 3, list.size());
	}
	
	@Test
	public void prependTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		UnsortedList<Integer> listTest = MyUnsortedList.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
		for(int i = 0; i < 10; i++) {
			list.prepend(i);
		}
		assertEquals("10 elements prepend", list, listTest);
	}

	@Test
	public void appendTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		UnsortedList<Integer> listTest = MyUnsortedList.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		for(int i = 0; i < 10; i++) {
			list.append(i);
		}
		assertEquals("10 elements append", list, listTest);
	}
	
	@Test
	public void insertStartTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		UnsortedList<Integer> listTest = MyUnsortedList.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
		for(int i = 0; i < 10; i++) {
			list.insert(i, 0);
		}
		assertEquals("10 elements insert in 0", list, listTest);
	}

	@Test
	public void insertEndTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		UnsortedList<Integer> listTest = MyUnsortedList.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		for(int i = 0; i < 10; i++) {
			list.insert(i, i);
		}
		assertEquals("10 elements insert in last", list, listTest);
	}	
	
	@Test
	public void insertMiddleTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		UnsortedList<Integer> listTest = MyUnsortedList.of(0, 1, 2, 10, 3, 4, 5, 6, 7, 8, 9);
		list.insert(10, 3);
		assertEquals("insert 1 element", list, listTest);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void insertBadIndex() throws Exception {
		UnsortedList<Integer> list = MyUnsortedList.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		list.insert(10, 20);
	}
	
	@Test
	public void popTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		UnsortedList<Integer> listTest = MyUnsortedList.of(2, 3, 4, 5, 6, 7, 8, 9);
		list.pop();
		list.pop();
		assertEquals("pop 2 elements", list, listTest);
	}
	
	@Test(expected = EmptyListException.class)
	public void popBadIndex() throws Exception {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.pop();
	}
	
	@Test
	public void popLastTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		UnsortedList<Integer> listTest = MyUnsortedList.of(0, 1, 2, 3, 4, 5, 6, 7);
		list.popLast();
		list.popLast();
		assertEquals("poplast 2 elements", list, listTest);
	}
	
	@Test(expected = EmptyListException.class)
	public void popLastBadIndex() throws Exception {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.popLast();
	}
	
	@Test
	public void removeTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		UnsortedList<Integer> listTest = MyUnsortedList.of(0, 2, 4, 5, 6, 7, 8, 9);
		list.remove(1);
		list.remove(2);
		assertEquals("remove 2 elements", list, listTest);
	}
	
	@Test
	public void removeElementTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		Object o = list.remove(5);
		assertEquals("remove 1 elements", 5, (int) o);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void popRemoveBadIndex() throws Exception {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.remove(10);
	}
	
	@Test
	public void sizeElementsAppendTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		for(int i = 0; i < 10; i++) {
			list.append(15);
		}
		assertEquals("10 elements", 10, list.size());
	}
	
	@Test
	public void isEmptyCreateMultipleElementTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4);
		assertFalse("new list", list.isEmpty());
	}
	
	@Test
	public void isEmptyWithPopTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.append(0);
		list.pop();
		assertTrue("pop 1 element", list.isEmpty());
	}
	
	@Test
	public void isEmptyPrependPop() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		for(int i = 0; i < 10; i++) {
			list.prepend(15);;
		}
		
		for(int i = 0; i < 10; i++) {
			list.pop();
		}
		assertTrue("prepend and pop 10 elements", list.isEmpty());
	}
	
	@Test
	public void isEmptyAppendPopTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		for(int i = 0; i < 10; i++) {
			list.append(15);
		}
		
		for(int i = 0; i < 10; i++) {
			list.pop();
		}
		
		assertTrue("append and pop 10 elements", list.isEmpty());
	}
	
	@Test
	public void isEmptyPopLastTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.append(0);
		list.popLast();
		assertTrue("popLast 1 element", list.isEmpty());
	}
	
	@Test
	public void isEmptyPrependPopLast() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		for(int i = 0; i < 10; i++) {
			list.prepend(15);;
		}
		
		for(int i = 0; i < 10; i++) {
			list.popLast();
		}
		
		assertTrue("prepend and popLast 10 elements", list.isEmpty());
	}
	
	@Test
	public void isEmptyAppendPoplast() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		for(int i = 0; i < 10; i++) {
			list.append(15);
		}
		
		for(int i = 0; i < 10; i++) {
			list.popLast();
		}
		
		assertTrue("append and popLast 10 elements", list.isEmpty());
	}
	
	@Test
	public void isEmptyRemoveTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.append(0);
		list.remove(0);
		assertTrue("Remove 1 element", list.isEmpty());
	}
	
	@Test
	public void isEmptyPrependRemoveTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		for(int i = 0; i < 10; i++) {
			list.prepend(15);;
		}
		
		for(int i = 0; i < 10; i++) {
			list.remove(0);
		}
		
		assertTrue("prepend and remove 10 elements", list.isEmpty());
	}
	
	@Test
	public void isEmptyAppendRemoveTest() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		for(int i = 0; i < 10; i++) {
			list.append(15);
		}
		
		for(int i = 0; i < 10; i++) {
			list.remove(0);
		}
		
		assertTrue("append and remove 10 elements", list.isEmpty());
	}
	
	@Test
	public void popLastIsEmptyTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(0, 1);
		list.popLast();
		list.popLast();
		assertTrue("append and remove 1 elements", list.isEmpty());
	}
	
	@Test
	public void toStringTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		String chaine = "MyUnsortedList { size = 10, [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] }";
		assertEquals("", chaine, list.toString());
	}

	@Test
	public void equalsTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		UnsortedList<Integer> list1 = MyUnsortedList.of(0, 1, 2, 3, 4, 5, 6, 7, 9);
		assertFalse("", list.equals(list1));
	}
	
	@Test
	public void equalsDifferentObjectTest() {
		UnsortedList<Integer> list = MyUnsortedList.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		int list1 = 1;
		assertFalse("", list.equals(list1));
	}
}
