package bolinhadegude;

import java.util.ArrayList;

/**
 *
 * Classe abstrata do jogo da bolinha, as outras classes à estendem, a fim de
 * obter reutilização de código.
 *
 * @author Maurício El Uri
 */
abstract class JogoBolinha {

    ArrayList<Integer> bolinhas = new ArrayList<>();
    ArrayList<Integer> consultas = new ArrayList<>();
    ArrayList<int[]> resultados = new ArrayList<>();

    public void setBolinha(int bolinha) {
        bolinhas.add(setValue(bolinha));
    }

    public void setConsulta(int consulta) {
        consultas.add(setValue(consulta));
    }

    public int setValue(int value) throws IllegalArgumentException {
        if (value >= 0 && value <= 10000) {
            return value;
        }
        throw new IllegalArgumentException();
    }

    public ArrayList<int[]> getResultados() {
        return resultados;
    }

    public String getResultadosTxt() {
        String resultadoTxt = "";
        for (int[] resultado : resultados) {
            if (resultado[1] != -1) {
                resultadoTxt += resultado[0] + " encontrado em "
                        + (resultado[1] + 1) + "\n";
            } else {
                resultadoTxt += resultado[0] + " não encontrado\n";
            }
        }
        return resultadoTxt;
    }
}
