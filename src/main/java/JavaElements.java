import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class JavaElements {
    public static void main(String[] args) {
        /* ------------- Estructura de Datos ------------- */

        // Inicializar datos de un list y establecer datos
        List<Integer> listInicializada = new ArrayList<>(Collections.nCopies(10, 0)); // tamanio 10 y todos sus elementos con el valor de 0

        // ArrayList: Almacenamiento dinámico de elementos.
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        int val = list.get(0); // Obtener el primer elemento (10)

        // HashMap: Almacenamiento de pares clave-valor.
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        int value = map.get("A"); // Obtener el valor asociado a la clave "A" (1)

        // Queue (LinkedList): Implementación de cola.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);
        queue.add(10);
        int front = queue.peek(); // Obtener el primer elemento de la cola (5)

        // PriorityQueue: Cola de prioridad para acceso eficiente al elemento mínimo o máximo.
        // Se ordena automaticamente
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.peek(); // Obtiene el elemento mínimo sin eliminarlo de la cola
        pq.add(5);
        pq.offer(10); // También agrega el elemento pero devuelve false si la cola esta llena
        int min = pq.poll(); // Eliminar y obtener el elemento mínimo (5)

        // Stack (Pila): Implementación de pila.
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(10);
        int top = stack.peek(); // Obtener el elemento superior sin eliminarlo (10)
        int popped = stack.pop(); // Eliminar y obtener el elemento superior (10)

        // LinkedList: Lista doblemente enlazada.
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        String first = linkedList.getFirst(); // Obtener el primer elemento (A)

        // HashSet: Almacenamiento de elementos únicos.
        HashSet<Integer> set = new HashSet<>();
        set.add(5);
        set.add(5); // No se agregará duplicado
        int size = set.size(); // Tamaño del conjunto (1)

        // TreeMap: Mapa ordenado por claves.
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Z", 26);
        treeMap.put("A", 1);
        String firstKey = treeMap.firstKey(); // Primera clave (A)

        // XOR: para encontrar el número que no se repite
        /*
            Este enfoque XOR funciona ya que la operación XOR (^) entre dos números iguales es
            cero (0 ^ 0 = 0, 1 ^ 1 = 0), y XOR con cero y un número devuelve el mismo número (0 ^ n = n, n ^ 0 = n).
            Al hacer un XOR en todos los elementos de la lista, los pares se cancelarán entre sí y al final solo quedará el número único.
         */
        List<Integer> a = new ArrayList<>();
        int result = 0;
        for (int num : a) {
            result ^= num;
        }

        // Ordenar un string
        String inputString = "";
        char[] charArray = inputString.toCharArray();
        Arrays.sort(charArray);
        String sortedString = new String(charArray);

        /* ------------- Funciones útiles ------------- */

        // String.split(): Dividir una cadena en función de un delimitador.
        String text = "Hola, Mundo";
        String[] parts = text.split(","); // ["Hola", " Mundo"]

        // Arrays.sort(): Ordenar un arreglo.
        int[] numbers = {5, 2, 8, 1};
        Arrays.sort(numbers); // [1, 2, 5, 8]

        // Math.max() / Math.min(): Obtener el máximo o mínimo entre dos valores.
        int maxVal = Math.max(10, 20); // 20
        int minVal = Math.min(5, 3); // 3

        // Collections.reverse(): Invertir el orden de una lista.
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        Collections.reverse(list2); // [3, 2, 1]

        // StringBuffer / StringBuilder: Manipulación eficiente de cadenas mutables.
        StringBuilder sb = new StringBuilder("Hola");
        sb.append(" Mundo"); // "Hola Mundo"

        // Arrays.binarySearch():  Búsqueda binaria en un arreglo ordenado.
        int[] arr = {1, 2, 4, 5, 7, 8, 10};
        int index = Arrays.binarySearch(arr, 5); // Índice del valor 5 (3)

        // Collections.sort(): Ordenar una lista.
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(5, 3, 8, 2));
        Collections.sort(list3); // [2, 3, 5, 8]

        // Queue (PriorityQueue): Cola de prioridad para acceso eficiente al elemento mínimo o máximo.
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        pq.offer(10);
        pq.offer(5);
        int min2 = pq2.poll(); // Eliminar y obtener el elemento mínimo (5)

        // String.indexOf() / String.lastIndexOf(): Encontrar el índice de una subcadena.
        String text2 = "Hola, Mundo, Hola";
        int firstIndex = text2.indexOf("Hola"); // Primer índice de "Hola" (0)
        int lastIndex = text2.lastIndexOf("Hola"); // Último índice de "Hola" (13)

        // String.toCharArray(): Convertir una cadena en un arreglo de caracteres.
        String text4 = "Hola";
        char[] chars = text4.toCharArray(); // ['H', 'o', 'l', 'a']

        // String.substring(): Obtener una subcadena de una cadena.
        String text5 = "Hello, World";
        String sub = text5.substring(7); // "World"

        // String.matches(): Verificar si una cadena coincide con una expresión regular.
        String email = "example@email.com";
        boolean isValid = email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

        /* ------------- Formateo de Strings ------------- */

        // Formato con printf():
        String name = "Emily";
        double height = 1.75;
        System.out.printf("Hola, soy %s y mi altura es %.2f metros.%n", name, height);
        // Salida: Hola, soy Emily y mi altura es 1.75 metros.

        // String.format():
        int apples = 10;
        String output = String.format("Tengo %d manzanas.", apples);
        // output: "Tengo 10 manzanas."

        // Decimal a binario
        Integer.toBinaryString(10);

        /* ------------- Formateo de Números Enteros y Decimales ------------- */

        // Números Enteros (printf):
        int num = 25;
        System.out.printf("El número es %d%n", num); // Salida: El número es 25

        // Números Decimales (printf):
        double price = 19.99;
        System.out.printf("El precio es %.2f%n", price); // Salida: El precio es 19.99

        // Formato con DecimalFormat:
        DecimalFormat df = new DecimalFormat("#.##");
        double value2 = 7.1234;
        String formatted = df.format(value2); // "7.12"

        // Formateo de Números con String.format():
        double amount = 1534.56789;
        String formattedAmount = String.format("El monto es %.2f", amount); // "El monto es 1534.57"

        /* ------------- Streams ------------- */

        // Ejemplos Básicos:
        // Filtrar Elementos:
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evenNumbers = numbers2.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        // evenNumbers: [2, 4]

        // Condición
        List<Integer> numbersCondicional = Arrays.asList(1, 2, 3, 4, 5);
        boolean filtroCondicional = numbersCondicional.stream()
                .allMatch(n -> n > 5);

        // Mapeo de Elementos:
        List<String> names = Arrays.asList("John", "Emily", "Tom");
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        // nameLengths: [4, 5, 3]

        // Reducción (Suma):
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        int sum = values.stream()
                .reduce(0, Integer::sum);
        // sum: 15
        long sum2 = values.stream()
                .mapToLong(Long::valueOf)
                .sum();

        // Encontrar el Elemento Mínimo:
        List<Integer> numbers3 = Arrays.asList(5, 3, 8, 2);
        int min3 = numbers3.stream()
                .min(Integer::compareTo)
                .orElse(0);
        // min: 2

        // Ejemplos con Streams Paralelos:
        // Filtrado Paralelo:
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers2 = numbers4.parallelStream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        // evenNumbers: [2, 4, 6, 8, 10]

        // Reducción Paralela (Suma):
        List<Integer> values2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum3 = values2.parallelStream()
                .reduce(0, Integer::sum);
        // sum: 55

        // Uso de Collectors:
        // Agrupar por Longitud:
        List<String> words = Arrays.asList("apple", "banana", "orange", "grape");
        Map<Integer, List<String>> groupedByLength = words.stream()
                .collect(Collectors.groupingBy(String::length));
        // {5=[apple, grape], 6=[banana], 6=[orange]}

        // Juntar Elementos en una Cadena:
        List<String> fruits = Arrays.asList("apple", "banana", "orange");
        String result2 = fruits.stream()
                .collect(Collectors.joining(", "));
        // result: "apple, banana, orange"

        // Convertir a Set:
        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 2, 4, 5);
        Set<Integer> uniqueNumbers = numbers5.stream()
                .collect(Collectors.toSet());
        // uniqueNumbers: [1, 2, 3, 4, 5]

        /* ------------- Time formats ------------- */
        /*
            Patrón: "hh:mm:ssa"
            Descripción: Representa horas en formato de 12 horas (de 01 a 12), minutos y segundos, seguidos por el indicador AM/PM.
            Ejemplo: 09:30:45PM
            Significado:
            hh: Horas en formato de 12 horas (de 01 a 12).
            mm: Minutos.
            ss: Segundos.
            a: Indicador AM/PM.
         */
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("hh:mm:ssa");
        /*
            Patrón: "HH:mm:ss"
            Descripción: Representa horas en formato de 24 horas (de 00 a 23), minutos y segundos.
            Ejemplo: 23:15:30
            Significado:
            HH: Horas en formato de 24 horas (de 00 a 23).
            mm: Minutos.
            ss: Segundos.
         */
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    }
}
