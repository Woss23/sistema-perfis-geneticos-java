import java.util.Scanner;

public class SistemaGenetico {

    private static final int CAPACIDADE_MAXIMA = 100;
    private static Paciente[] pacientes = new Paciente[CAPACIDADE_MAXIMA];
    private static int qtd_pacientes_cadastrados = 0;

    
    static Scanner scanner = new Scanner(System.in);

    // Cadastrar paciente
    public static void cadastrarPaciente() {
        if (qtd_pacientes_cadastrados >= CAPACIDADE_MAXIMA) {
            System.out.println("Limite de 100 pacientes atingido. Não é possível cadastrar.");
            return;
        }

        System.out.print("Código: ");
        int codigo = lerInt();

        if (buscarPaciente(codigo) != null) {
            System.out.println("Já existe um paciente cadastrado com este código.");
            return;
        }

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = lerInt();

        System.out.print("Sexo (M/F): ");
        String sexo = scanner.nextLine();

        String dna = lerSequenciaDNAValida();
        if (dna == null) {
            System.out.println("Cadastro cancelado: sequência de DNA inválida.");
            return;
        }

        Paciente novo = new Paciente(codigo, nome, idade, sexo, dna);
        pacientes[qtd_pacientes_cadastrados] = novo;
        qtd_pacientes_cadastrados++;

        System.out.println("Paciente cadastrado com sucesso!");
    }

    // Listar pacientes
    public static void listarPacientes() {
        if (qtd_pacientes_cadastrados == 0) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }

        System.out.println("----- LISTA DE PACIENTES -----");
        for (int i = 0; i < qtd_pacientes_cadastrados; i++) {
            Paciente p = pacientes[i];
            System.out.println("Código: " + p.getCodigo()
                    + " | Nome: " + p.getNome()
                    + " | Idade: " + p.getIdade()
                    + " | Sexo: " + p.getSexo()
                    + " | DNA: " + p.getSequenciaDNA());
        }
    }

    // Buscar paciente por código
    public static Paciente buscarPaciente(int codigo) {
        for (int i = 0; i < qtd_pacientes_cadastrados; i++) {
            if (pacientes[i].getCodigo() == codigo) {
                return pacientes[i];
            }
        }
        return null;
    }

    // Sobrecarga: Buscar paciente por nome
    public static Paciente buscarPaciente(String nome) {
        if (nome == null) {
            return null;
        }
        for (int i = 0; i < qtd_pacientes_cadastrados; i++) {
            if (pacientes[i].getNome().toLowerCase().contains(nome.toLowerCase())) {
                return pacientes[i];
            }
        }
        return null;
    }

    // Alterar paciente
    public static void alterarPaciente() {
        System.out.print("Código do paciente a alterar: ");
        int codigo = lerInt();

        Paciente paciente = buscarPaciente(codigo);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.println("Paciente encontrado -> Código: " + paciente.getCodigo()
                + " | Nome: " + paciente.getNome()
                + " | Idade: " + paciente.getIdade()
                + " | Sexo: " + paciente.getSexo()
                + " | DNA: " + paciente.getSequenciaDNA());

        System.out.print("Novo nome: ");
        paciente.setNome(scanner.nextLine());

        System.out.print("Nova idade: ");
        paciente.setIdade(lerInt());

        System.out.print("Novo sexo (M/F): ");
        paciente.setSexo(scanner.nextLine());

        String dna = lerSequenciaDNAValida();
        if (dna == null) {
            System.out.println("Sequência de DNA inválida. Nome/idade/sexo foram atualizados; o DNA foi mantido.");
            return;
        }
        paciente.setSequenciaDNA(dna);

        System.out.println("Paciente atualizado com sucesso!");
    }

    // Remover paciente
    public static boolean removerPaciente(int codigo) {
        int indice = -1;

        for (int i = 0; i < qtd_pacientes_cadastrados; i++) {
            if (pacientes[i].getCodigo() == codigo) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            return false;
        }

        // Desloca todos os elementos posteriores uma posição para a esquerda
        for (int i = indice; i < qtd_pacientes_cadastrados - 1; i++) {
            pacientes[i] = pacientes[i + 1];
        }

        pacientes[qtd_pacientes_cadastrados - 1] = null;
        qtd_pacientes_cadastrados--;

        return true;
    }

    // Auxiliares
    private static int lerInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um número válido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // limpa a quebra de linha pendente
        return valor;
    }

    private static String lerSequenciaDNAValida() {
        System.out.print("Sequência de DNA (A, C, G, T): ");
        String dna = scanner.nextLine();

        if (!validarDNA(dna)) {
            return null;
        }

        return dna.toUpperCase();
    }

    private static boolean validarDNA(String dna) {
        if (dna == null || dna.isEmpty()) {
            return false;
        }
        for (int i = 0; i < dna.length(); i++) {
            char c = Character.toUpperCase(dna.charAt(i));
            if (c != 'A' && c != 'C' && c != 'G' && c != 'T') {
                return false;
            }
        }
        return true;
    }
}
