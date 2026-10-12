public class Aplicacao {

    public static void main(String[] args) {
        SistemaGenetico sistemaGenetico = new SistemaGenetico();
        int opcao;

        do {
            System.out.println("=========================================");
            System.out.println(" SISTEMA DE PERFIS GENÉTICOS");
            System.out.println("=========================================");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Listar pacientes");
            System.out.println("3 - Pesquisar paciente por código");
            System.out.println("4 - Pesquisar paciente por nome");
            System.out.println("5 - Alterar paciente");
            System.out.println("6 - Remover paciente");
            System.out.println("0 - Encerrar");
            System.out.println("=========================================");
            System.out.print("Escolha uma opção: ");

            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    SistemaGenetico.cadastrarPaciente();
                    break;

                case 2:
                    SistemaGenetico.listarPacientes();
                    break;

                case 3: {
                    System.out.print("Código: ");
                    int codigo = lerOpcao();
                    Paciente encontrado = SistemaGenetico.buscarPaciente(codigo);
                    if (encontrado != null) {
                        System.out.println("Código: " + encontrado.getCodigo()
                                + " | Nome: " + encontrado.getNome()
                                + " | Idade: " + encontrado.getIdade()
                                + " | Sexo: " + encontrado.getSexo()
                                + " | DNA: " + encontrado.getSequenciaDNA());
                    } else {
                        System.out.println("Paciente não encontrado.");
                    }
                    break;
                }

                case 4: {
                    System.out.print("Nome (ou trecho do nome): ");
                    String nome = SistemaGenetico.scanner.nextLine();
                    Paciente encontrado = SistemaGenetico.buscarPaciente(nome);
                    if (encontrado != null) {
                        System.out.println("Código: " + encontrado.getCodigo()
                                + " | Nome: " + encontrado.getNome()
                                + " | Idade: " + encontrado.getIdade()
                                + " | Sexo: " + encontrado.getSexo()
                                + " | DNA: " + encontrado.getSequenciaDNA());
                    } else {
                        System.out.println("Paciente não encontrado.");
                    }
                    break;
                }

                case 5:
                    SistemaGenetico.alterarPaciente();
                    break;

                case 6: {
                    System.out.print("Código do paciente a remover: ");
                    int codigo = lerOpcao();
                    boolean removido = SistemaGenetico.removerPaciente(codigo);
                    System.out.println(removido ? "Paciente removido com sucesso!" : "Paciente não encontrado.");
                    break;
                }

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println();

        } while (opcao != 0);

        SistemaGenetico.scanner.close();
    }

    private static int lerOpcao() {
        while (!SistemaGenetico.scanner.hasNextInt()) {
            System.out.print("Digite um número válido: ");
            SistemaGenetico.scanner.next();
        }
        int valor = SistemaGenetico.scanner.nextInt();
        SistemaGenetico.scanner.nextLine();
        return valor;
    }
}
