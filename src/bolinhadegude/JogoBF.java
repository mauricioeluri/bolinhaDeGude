package bolinhadegude;

/**
 * Extensão do jogo da bolinha, utilizando o paradigma força bruta para
 * encontrar os resultados.
 *
 * @author Maurício El Uri
 */
public class JogoBF extends JogoBolinha {

    /**
     * Método para executar o processamento dos resultados do jogo, utilizando o
     * paradigma de Força bruta. Ao fim do processamento, chama a função que
     * seta o resultado na lista de resultados.
     *
     * @param consulta
     */
    private void executaConsulta(int consulta) {
        int resultado = -1;
        for (int i = 1; i < getBolinhas().size(); i++) {
            if (consulta == getBolinhas().get(i - 1)) {
                resultado = i - 1;
            }
        }
        setaResultado(consulta, resultado);
    }

    /**
     * Método que executa todas as consultas necessárias para processar os
     * resultados. Para cada consulta na lista de consultas, chama o método
     * executaConsulta, e adiciona seu resultado na lista de resultados.
     */
    public void executa() {
        for (int consulta : getConsultas()) {
            executaConsulta(consulta);
        }
    }
}
