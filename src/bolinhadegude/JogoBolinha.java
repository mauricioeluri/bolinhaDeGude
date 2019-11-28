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

    private ArrayList<Integer> bolinhas = new ArrayList<>();
    private ArrayList<Integer> consultas = new ArrayList<>();
    private ArrayList<int[]> resultados = new ArrayList<>();

    /**
     * Função para setar o valor de cada bolinha
     * @param bolinha 
     */
    public void setBolinha(int bolinha) {
        bolinhas.add(setValue(bolinha));
    }

    /**
     * Função para setar o valor de cada consulta
     * @param consulta 
     */
    public void setConsulta(int consulta) {
        consultas.add(setValue(consulta));
    }

    /**
     * Método com verificações para validar que o valor inserido está entre
     * 0 e 10000. Caso retorne positivo, retorna o próprio valor, caso negativo,
     * retorna uma excessão. 
     * @param value
     * @return value
     * @throws IllegalArgumentException 
     */
    private int setValue(int value) throws IllegalArgumentException {
        if (value >= 0 && value <= 10000) {
            return value;
        }
        throw new IllegalArgumentException();
    }
    
    /**
     * Função que seta o resultado de alguma consulta na lista de resultados.
     * @param consulta
     * @param result 
     */
    protected void setaResultado(int consulta, int result) {
        int[] resultado = new int[2];
        resultado[0] = consulta;
        resultado[1] = result;
        resultados.add(resultado);
    }

    /**
     * Método para retornar o ArrayList com os resultados, utilizado após
     * concluir o processamento do jogo.
     * @return resultados[]
     */
    public ArrayList<int[]> getResultados() {
        return resultados;
    }
    
    /**
     * Método que retorna a lista de bolinhas inseridas
     * @return bolinhas
     */
    public ArrayList<Integer> getBolinhas() {
        return bolinhas;
    }
    
    /**
     * Método que retorna a lista de consultas inseridas
     * @return bolinhas
     */
    public ArrayList<Integer> getConsultas() {
        return consultas;
    }

    /**
     * Método para retornar os resultaos formataos de maneira textual,
     * utilizado para o processamento do jogo em formato textual.
     * @return String resultados
     */
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
