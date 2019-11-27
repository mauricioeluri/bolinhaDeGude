package bolinhadegude;

/**
 * Extensão do jogo da bolinha, utilizando o paradigma força bruta para
 * encontrar os resultados.
 *
 * @author Maurício El Uri
 */
public class JogoBF extends JogoBolinha {

    public int[] executaConsulta(int consulta) {
        int[] resultado = new int[2];
        resultado[0] = consulta;
        resultado[1] = -1;
        for (int i = 1; i < bolinhas.size(); i++) {
            if (consulta == bolinhas.get(i - 1)) {
                resultado[1] = i - 1;
            }
        }
        return resultado;
    }

    public void executa() {
        for (int consulta : consultas) {
            resultados.add(executaConsulta(consulta));
        }
    }
}
