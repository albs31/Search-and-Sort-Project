import java.util.ArrayList;

public class SortandSearchAlgorithms {

public static void load() {
        System.out.println("SortandSearchAlgorithms class loaded.");
}

    // selection
    public static ArrayList<Book> selectionSort(ArrayList<Book> books) {
        ArrayList<Book> list = new ArrayList<>(books); 
        int n = list.size();
 
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).getTitle().compareToIgnoreCase(list.get(minIndex).getTitle()) < 0) {
                    minIndex = j;
                }
            }
            Book temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }
        return list;
    }
 
    // insertion
    public static ArrayList<Book> insertionSort(ArrayList<Book> books) {
        ArrayList<Book> list = new ArrayList<>(books);
        int n = list.size();
 
        for (int i = 1; i < n; i++) {
            Book key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).getTitle().compareToIgnoreCase(key.getTitle()) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
        return list;
    }

    // merge sorts
    public static ArrayList<Book> mergeSort(ArrayList<Book> books) {
        ArrayList<Book> list = new ArrayList<>(books);
if (list.size() <= 1) return list;
 
        int mid = list.size() / 2;
        ArrayList<Book> left  = mergeSort(new ArrayList<>(list.subList(0, mid)));
        ArrayList<Book> right = mergeSort(new ArrayList<>(list.subList(mid, list.size())));
 
        return merge(left, right);
    }
 
    private static ArrayList<Book> merge(ArrayList<Book> left, ArrayList<Book> right) {
        ArrayList<Book> result = new ArrayList<>();
        int i = 0, j = 0;
 
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getTitle().compareToIgnoreCase(right.get(j).getTitle()) <= 0) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }
        while (i < left.size())  result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));
        return result;
    }

    // linear search
    public static int linearSearch(ArrayList<Book> list, String target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }

    // iterative binary search
    public static int binarySearchIterative(ArrayList<Book> list, String target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = list.get(mid).getTitle().compareToIgnoreCase(target);

            if (cmp == 0) return mid;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    // recursive binary search
    public static int binarySearchRecursive(ArrayList<Book> list, String target, int low, int high) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        int cmp = list.get(mid).getTitle().compareToIgnoreCase(target);

        if (cmp == 0) return mid;
        else if (cmp < 0)
            return binarySearchRecursive(list, target, mid + 1, high);
        else
            return binarySearchRecursive(list, target, low, mid - 1);
    }
}
