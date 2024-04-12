import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        String nome = "Vitor Fidelis";
        String tipoConta = "Corrente";
        double saldo = 5000.99;
        double opcao = 0;
        int tentativasInicio = 3;

        System.out.println("Bem vindo!");
        System.out.println("\n__________________________________\n");
        System.out.println("Nome do cliente: " + nome);
        System.out.println("Tipo de conta:" + tipoConta);
        System.out.println("Saldo: R$" + saldo);
        System.out.println("\n__________________________________\n");

        String menu = """
                Operações:
                    1- consultar saldo
                    2- receber pix
                    3- fazer pix
                    4- sair
                                        
                    Digite um número de 1 a 4:
                """;
        while (opcao != 4) {
            System.out.println(menu);
            opcao = leitura.nextDouble();
            if (opcao == 1) {
                System.out.println("Seu saldo é de: R$" + saldo);
            } else if (opcao == 2){
                System.out.println("Digite o valor que está recebendo:");
                saldo += leitura.nextDouble();
                System.out.println("Seu saldo atualizado é de: R$" + saldo);
            } else if (opcao == 3){
                System.out.println("Digite o valor que deseja enviar:");
                double valor = leitura.nextDouble();
                if (valor > saldo){
                    System.out.println("Seu saldo é insuficiente para completar a transação.");
                    System.out.println(menu);
                    opcao = leitura.nextDouble();
                } else {
                    saldo -= valor;
                    System.out.println("Seu saldo atualizado é de: R$" + saldo);
                }
            }

            if (opcao == 4){
                System.out.println("Obrigado, até a próxima");
            }

            while (opcao > 4){
                tentativasInicio--;
                System.out.println("Opção inválida. Você possui mais " + tentativasInicio + " tentativas.");

                System.out.println(menu);
                opcao = leitura.nextDouble();

                if (tentativasInicio == 0){
                    System.out.println("""
                            Você excedeu o numero de tentativas. :(
                            Tente novamente mais tarde.
                            """);
                    opcao = 4;
                }
            }
        }

        }
    }