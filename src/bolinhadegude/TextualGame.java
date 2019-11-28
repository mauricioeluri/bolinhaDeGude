package bolinhadegude;

import java.util.Scanner;

/**
 * Extensão textual do jogo da bolinha, funciona como está na especificação.
 *
 * @author Maurício El Uri
 */
public class TextualGame {

    private Scanner scanner = new Scanner(System.in);
    private int nro_bolinhas = 1, nro_consultas = 1;
    private int nro_caso = 1;

    /**
     * Função para receber um número válido pelo usuário.
     * Processa a entrada do usuário e valida se esta entrada é válida,
     * exibe uma mensagem caso a entrada for inválida, e repete este 
     * processo até que uma entrada válida seja inserida.
     * Utiliza a função validaEntrada para testar se a entrada é válida.
     * @return entrada
     */
    public int recebeInt() {
        boolean valorValido;
        String entrada;
        do {
            entrada = scanner.next();
            valorValido = validaEntrada(entrada);
            if (valorValido == false) {
                System.out.println("Entrada inválida, insira um número inteiro"
                        + " entre 0 e 10000");
            }
        } while (valorValido == false);
        return Integer.parseInt(entrada.trim());
    }

    /**
     * Função booleana que testa se a entrada é válida.
     * @param entrada
     * @return boolean
     */
    private boolean validaEntrada(String entrada) {
        try {
            int entradaConvertido = Integer.parseInt(entrada.trim());
            if (entradaConvertido >= 0 && entradaConvertido <= 10000) {
                return true;
            }
        } catch (NumberFormatException e) {
        }
        return false;
    }

    /**
     * Processamento textual do jogo da bolinha,
     * foi utilizada a implementação em brute force para 
     * processamento.
     * @param args 
     */
    public static void main(String[] args) {
        TextualGame tg = new TextualGame();

        while (tg.nro_bolinhas != 0 && tg.nro_consultas != 0) {
            JogoBF jogo = new JogoBF();

            System.out.println("Insira o número de Bolas de Gude e "
                    + "o número de consultas: ");
            tg.nro_bolinhas = tg.recebeInt();
            tg.nro_consultas = tg.recebeInt();

            if (tg.nro_bolinhas != 0 || tg.nro_consultas != 0) {
                System.out.println("Insira o número de cada Bola de gude: ");
                for (int i = 1; i <= tg.nro_bolinhas; i++) {
                    jogo.setBolinha(tg.recebeInt());
                }

                System.out.println("Insira os números a serem consultados;");
                for (int i = tg.nro_consultas; i > 0; i--) {
                    jogo.setConsulta(tg.recebeInt());
                }

                System.out.println("CASO#" + tg.nro_caso++);
                jogo.executa();
                System.out.print(jogo.getResultadosTxt());
                jogo = null;
            }
        }
    }
}
