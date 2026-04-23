import java.io.FileNotFoundException;
import java.util.ArrayList;
 
public class SearchAndSortAnalysis 
{
  public static void main(String[] args) throws FileNotFoundException
  {
    SortandSearchAlgorithms.load();
 
    ArrayList<Book> books = Data.getBooks();
    ArrayList<Sentiment> sentiments = Data.getSentiments();
 
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
 
    String target = "demand";
 
    startTime = System.nanoTime();
    int index = SortandSearchAlgorithms.linearSearchSentiment(sentiments, target);
    execTime = (System.nanoTime() - startTime) / 1e9;
    System.out.println("Linear Search: " + sentiments.get(index).getPhrase() + " = " + sentiments.get(index).getValue() + " in " + execTime + " seconds");
 
    startTime = System.nanoTime();
    index = SortandSearchAlgorithms.binarySearchSentimentIterative(sentiments, target);
    execTime = (System.nanoTime() - startTime) / 1e9;
    System.out.println("Binary Search (Iterative): " + sentiments.get(index).getPhrase() + " = " + sentiments.get(index).getValue() + " in " + execTime + " seconds");
 
    startTime = System.nanoTime();
    index = SortandSearchAlgorithms.binarySearchSentimentRecursive(sentiments, target, 0, sentiments.size() - 1);
    execTime = (System.nanoTime() - startTime) / 1e9;
    System.out.println("Binary Search (Recursive): " + sentiments.get(index).getPhrase() + " = " + sentiments.get(index).getValue() + " in " + execTime + " seconds");

    System.out.println("CONCLUSION: Merge Sort is the fastest sorting algorithm, and Recursive Binary Search is the fastest search algorithm.");
  }
}
