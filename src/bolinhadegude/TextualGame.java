package bolinhadegude;

import java.util.Scanner;

/**
 * Extensão textual do jogo da bolinha, funciona como está na especificação.
 *
 * @author Maurício El Uri
 */
public class TextualGame {

    Scanner scanner = new Scanner(System.in);
    int nro_bolinhas = 1, nro_consultas = 1;
    int nro_caso = 1;

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

    public boolean validaEntrada(String entrada) {
        try {
            int entradaConvertido = Integer.parseInt(entrada.trim());
            if (entradaConvertido >= 0 && entradaConvertido <= 10000) {
                return true;
            }
        } catch (NumberFormatException e) {
        }
        return false;
    }

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
