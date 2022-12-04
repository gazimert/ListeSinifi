import java.util.Arrays;

public class MyList<T> {
    private Object[] arr;
    private int capacity;
    private int size = 0;

    public MyList() {
        capacity = 10;
        arr = new Object[10];
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        arr = new Object[capacity];
    }

    // dizinin kapasite değerini verir.
    public int getCapacity() {
        return this.capacity;
    }

    // dizideki eleman sayısını verir.
    public int size() {
        return this.size;
    }

    // sınıfa ait diziye eleman eklemek için kullanılmalıdır. Eğer dizide yeteri kadar yer yok ise, dizi boyutu 2 katına çıkartılmalıdır.
    public void add(T data) {
        size++;
        if (size > capacity) {
            capacity *= 2;
            Object[] tempArray = new Object[capacity];
            for (int i = 0; i < arr.length; i++) {
                tempArray[i] = arr[i];
            }
            arr = tempArray;
            arr[size - 1] = data;
        } else {
            arr[size - 1] = data;
        }
    }

    // Verilen indisteki değeri döndürür. Geçersiz indis girilerse null döndürür.
    public Object get(int index) {
        if (index >= 0 && index < size) {
            return arr[index];
        } else {
            return null;
        }
    }

    // Verilen indisteki veriyi silmeli ve silinen indis sonrasında ki verileri sola doğru kaydırmalı.
    public void remove(int index) {
        if (index >= 0 && index < size) {
            if (index == size - 1) {
                arr[index] = null;
                size--;
            } else {
                for (int i = index; i < size - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                size--;
                arr[size - 1] = null;
            }
            System.out.println("Değer silindi");
        } else {
            System.out.println("Geçersiz indis değeri");
        }
    }

    // verilen indisteki veriyi yenisi ile değiştirme işlemini yapmalıdır.
    public void set(int index, T data) {
        if (index >= 0 && index < size) {
            arr[index] = data;
        } else {
            System.out.println("Geçersiz indis değeri");
        }
    }

    // Sınıfa ait dizideki elemanları listeleyen bir metot.
    @Override
    public String toString() {
        Object[] tempArray = new Object[size];
        for (int i = 0; i < size; i++) {
            tempArray[i] = arr[i];
        }
        return Arrays.toString(tempArray);
    }

    // Parametrede verilen değerin listedeki indeksini verir. Değer listede yoksa -1 değerini verir.
    public int indexOf(T data){
        for (int i = 0; i < size; i++) {
            if (arr[i] == data)
                return i;
        }
        return -1;
    }

    // Belirtilen öğenin listedeki son indeksini söyler. Nesne listede yoksa -1 değerini verir.
    public int lastIndexOf(T data){
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] == data)
                return i;
        }
        return -1;
    }

    // Listenin boş olup olmadığını söyler.
    public boolean isEmpty(){
        if (size == 0)
            return true;
        return false;
    }

    // Listedeki bütün öğeleri siler, boş liste haline getirir.
    public void clear(){
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    // Parametrede verilen değerin dizide olup olmadığını söyler.
    public boolean contains(T data){
        for (int i = 0; i < size; i++) {
            if (arr[i] == data)
                return true;
        }
        return false;
    }

    // Parametrede verilen indeks aralığına ait bir liste döner.
    public MyList<T> subList(int start, int finish){
        MyList<T> liste = new MyList<>();
        for (int i = start; i <= finish; i++) {
            liste.add((T) arr[i]);
        }
        return liste;
    }
}
