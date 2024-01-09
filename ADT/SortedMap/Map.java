public interface Map extends Container{
    // inserisce un’associazione nella mappa
    // se esisteva gia’ un’associazione con la stessa
    // chiave, sostituisco il valore vecchio e lo restituisce
    // null, se non esisteva
    Object put(Object key, Object value);
    // restituisce l’elemento associato a key
    Object get(Object key);
    // restituisce l’elemento associato a key e
    // rimuove l’associazione
    Object remove(Object key);
    // restituisce un array con le chiavi contenute
    // nella mappa
    Object[] keys();
}