public class VectorUtils {

    /**
     * Fukcia vypocita skalarny sucin vektorov a a b.
     * Z definicie skalarneho sucinu vyplyva, ze vektory a a b musia mat rovnaku dlzku.
     *
     * @param a pole reprezentujuce vektor, nesmie byt null.
     * @param b pole reprezentujuce vektor, nesmie byt null.
     * @return null ak doslo k chybe, alebo su nevhodne parametre. Inak vrati spocitany skalarny sucin.
     */
    public static Integer dotProduct(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            return null;
        }
       int sucin = 0;
       for (int i = 0; i < a.length; i++) {
           sucin += a[i]*b[i];
       }

       return sucin;
    }
}
