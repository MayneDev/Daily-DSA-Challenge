package src.com.daily.dsa.challenge.leetcode;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;

        //default value is 0. Meaning it does not have a parent
        int[] cityConnections = new int[provinces + 1];

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {

                int iParent = getParent(i + 1, cityConnections);
                int jParent = getParent(j + 1, cityConnections);


                if (i != j && iParent != jParent && isConnected[i][j] == 1) {
                    cityConnections[jParent] = iParent;
                    provinces--;
                }
            }
        }

        return provinces;
    }

    private int getParent(int city, int[] cityConnections) {
        if (cityConnections[city] == 0 || cityConnections[city] == city) return city;
        return getParent(cityConnections[city], cityConnections);
    }
}
