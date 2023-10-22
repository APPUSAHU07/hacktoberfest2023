public class BinarySearch {

    public static <T extends Comparable<T>> SearchResult<T> binarySearch(T[] arr, T target) {
        int left = 0;
        int right = arr.length - 1;
        int steps = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            steps++;

            int comparison = target.compareTo(arr[mid]);

            if (comparison == 0) {
                return new SearchResult<>(mid, arr[mid], steps);
            } else if (comparison < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new SearchResult<>(-1, null, steps);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer target = 5;

        SearchResult<Integer> result = binarySearch(arr, target);

        if (result.getIndex() != -1) {
            System.out.println("Element " + result.getElement() + " found at index " + result.getIndex() + " in " + result.getSteps() + " steps.");
        } else {
            System.out.println("Element not found in " + result.getSteps() + " steps.");
        }
    }
}

class SearchResult<T> {
    private int index;
    private T element;
    private int steps;

    public SearchResult(int index, T element, int steps) {
        this.index = index;
        this.element = element;
        this.steps = steps;
    }

    public int getIndex() {
        return index;
    }

    public T getElement() {
        return element;
    }

    public int getSteps() {
        return steps;
    }
}
