package Busqueda;

public class BusquedaHash<T> {
    private int TABLE_SIZE;

    // Clase para representar un par clave-valor
    private static class Entry<T> {
        String key;
        T value;
        Entry<T> next;

        Entry(String key, T value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Entry<T>[] table;

    public BusquedaHash(int table_size) {
        TABLE_SIZE = table_size;
        table = new Entry[TABLE_SIZE];
    }

    // Método para agregar un par clave-valor al Hashtable
    public void put(String key, T value) {
        int index = hash(key);

        if (table[index] == null) {
            // Si la posición está vacía, simplemente agregamos el nuevo Entry
            table[index] = new Entry<T>(key, value);
        } else {
            // Si hay colisión, agregamos al final de la lista enlazada
            Entry<T> current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Entry<T>(key, value);
        }
    }

    // Método para obtener el valor asociado a una clave
    public T get(String key) {
        int index = hash(key);
        Entry<T> current = table[index];

        // Buscamos la clave en la lista enlazada
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        // Si la clave no se encuentra, retornamos un valor por defecto (puedes elegir otro valor según tu necesidad)
        return null;
    }

    // Función de hash simple para obtener el índice en el arreglo
    private int hash(String key) {
        return Math.abs(key.hashCode() % TABLE_SIZE);
    }

    public static void main(String[] args) {
        BusquedaHash<Vehiculo> hashtable = new BusquedaHash<Vehiculo>(100);

        // Agregamos pares clave-valor al Hashtable
        hashtable.put("volkswagen", new Vehiculo("Golf", "VW"));
        hashtable.put("volkswagen", new Vehiculo("Gol", "VW"));
        hashtable.put("renault", new Vehiculo("Megane", "Renault"));
        hashtable.put("ford", new Vehiculo("Mustang", "Ford"));

        // Recuperamos valores por clave
        System.out.println("Valor asociado a 'Golf': " + hashtable.get("volkswagen").toString());
        System.out.println("Valor asociado a 'Megane': " + hashtable.get("renault").toString());
        System.out.println("Valor asociado a 'Mustang': " + hashtable.get("ford").toString());
    }
}
