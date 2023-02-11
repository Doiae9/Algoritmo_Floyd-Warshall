package com.example.algoritmo_floyd_warshall;

public class CaminosMinimos {
    private long inf= 99999999;
    public String algoritmoFloyd(long[][] matriz) {
        int vertices = matriz.length;
        long matrizAdyacencia[][] = matriz;
        String caminos[][] = new String[vertices][vertices]; //guarda todos los caminos.
        String caminosAuxiliares[][] = new String[vertices][vertices];
        String caminoRecorrido = "", cadena = "", caminitos = "";
        int i, j, k; //indices
        float temporal1, temporal2, temporal3, temporal4, minimo; //camino minimo
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                caminos[i][j] = "";
                caminosAuxiliares[i][j] = "";
            }
        } //
        for (k = 0; k < vertices; k++) {
            for (i = 0; i < vertices; i++) {
                for (j = 0; j < vertices; j++) {
                    temporal1 = matrizAdyacencia[i][j];
                    temporal2 = matrizAdyacencia[i][k];
                    temporal3 = matrizAdyacencia[k][j];
                    temporal4 = temporal2 + temporal3;
                    //encontrar el minimo
                    minimo = Math.min(temporal1, temporal4);
                    if (temporal1 != temporal4) {
                        if (minimo == temporal4) {
                            caminoRecorrido = "";
                            caminosAuxiliares[i][j] = k + "";
                            caminos[i][j] = caminosR(i, k, caminosAuxiliares,
                                    caminoRecorrido) + (k + 1);
                        }
                    }
                    matrizAdyacencia[i][j] = (long) minimo; //casteamos
                }
            }
        }
        // Agregamos el camino mínimo a la cadena.
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                //matriz de casos minimos
                cadena = cadena + "[" + matrizAdyacencia[i][j] + "]";
            }
            cadena = cadena + "\n";

        }
        ///////////////////////////////////////////
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                //Aqui va a entrar cuando el grafo sea adyacente, ya que este numero inmenso se usa para verificar
                //que el numero se encuentra muy alejado
                if (matrizAdyacencia[i][j] != inf) {
                    if (i != j) {
                        if (caminos[i][j].equals("")) {
                            caminitos += "De ("+(i+1)+"--->"+(j+1)
                                    +") irse por ..("+(i+1)+", "+(j+1)
                                    +") \n";

                        } else {
                            caminitos += "De ("+(i+1)+ "--->"+(j+1)
                                    +") irse por ..("+(i+1)+ ", "+caminos[i][j]
                                    +", "+(j+1)+") \n";
                        }
                    }

                }
            }
        }
        return "La matriz de caminos más cortos entre los diferentes vértices es: \n"
                + cadena+"\n los diferentes caminos más cortos entre vértices son \n"
                +caminitos;
    }

    public String caminosR(int i, int k, String[][] caminosAuxiliares,
                           String caminoRecorrido) {
        if (caminosAuxiliares[i][k] == "") {
            return "";
        } else {
            // Recursividad
            caminoRecorrido += caminosR(i, Integer.parseInt(caminosAuxiliares[i][k].toString()),
                    caminosAuxiliares, caminoRecorrido)+(Integer.parseInt(caminosAuxiliares[i][k].toString())+1) + ", ";
            return caminoRecorrido;

        }
    }

    public long getInf() {return inf;}
}

