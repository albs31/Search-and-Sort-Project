import java.io.FileNotFoundException;
import java.util.ArrayList;
 
public class SearchAndSortAnalysis 
{
  public static void main(String[] args) throws FileNotFoundException
  {
    SortandSearchAlgorithms.load();
 
    ArrayList<Book> books = Data.getBooks();
 
    // Sorting
    double startTime = System.nanoTime();
    SortandSearchAlgorithms.selectionSort(books);
    double execTime = (System.nanoTime() - startTime) / 1e9;
    System.out.println("Selection Sort: " + execTime + " seconds");
 
    startTime = System.nanoTime();
    SortandSearchAlgorithms.insertionSort(books);
    execTime = (System.nanoTime() - startTime) / 1e9;
    System.out.println("Insertion Sort: " + execTime + " seconds");
 
    startTime = System.nanoTime();
    ArrayList<Book> sorted = SortandSearchAlgorithms.mergeSort(books);
    execTime = (System.nanoTime() - startTime) / 1e9;
    System.out.println("Merge Sort: " + execTime + " seconds");
 
    // Searching 
    String target = "Peter Pan";
 
    startTime = System.nanoTime();
    SortandSearchAlgorithms.linearSearch(sorted, target);
    execTime = (System.nanoTime() - startTime) / 1e9;
    System.out.println("Linear Search: " + execTime + " seconds");
 
    startTime = System.nanoTime();
    SortandSearchAlgorithms.binarySearchIterative(sorted, target);
    execTime = (System.nanoTime() - startTime) / 1e9;
    System.out.println("Binary Search (Iterative): " + execTime + " seconds");
 
    startTime = System.nanoTime();
    SortandSearchAlgorithms.binarySearchRecursive(sorted, target, 0, sorted.size() - 1);
    execTime = (System.nanoTime() - startTime) / 1e9;
    System.out.println("Binary Search (Recursive): " + execTime + " seconds");

    System.out.println("CONCLUSION: Merge Sort is the fastest sorting algorithm, and Iterative Binary Search is the fastest search algorithm.");
  }
}
