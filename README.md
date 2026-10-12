Sistema de Perfis Genéticos

Aplicação de console em Java para cadastrar e gerenciar pacientes e suas sequências de DNA. O projeto implementa as quatro operações de um CRUD (criar, ler, atualizar e remover) e foi desenvolvido para praticar Programação Orientada a Objetos na graduação em Sistemas de Informação (Mackenzie).

 
Funcionalidades
Cadastrar paciente: código, nome, idade, sexo e sequência de DNA
Listar todos os pacientes cadastrados
Pesquisar por código (busca exata)
Pesquisar por nome (aceita apenas um trecho do nome, sem diferenciar maiúsculas de minúsculas)
Alterar os dados de um paciente
Remover um paciente pelo código
Regras e validações
Não permite dois pacientes com o mesmo código.
A sequência de DNA só aceita as letras A, C, G e T (em maiúsculas ou minúsculas) e é armazenada em maiúsculas.
Campos numéricos (código, idade e opção do menu) pedem a digitação novamente se o valor não for um número.
Limite de 100 pacientes cadastrados.

Requisitos
Requisitos funcionais
Código	Requisito
RF01	O sistema deve cadastrar pacientes com código, nome, idade, sexo e sequência de DNA.
RF02	O sistema não deve permitir dois pacientes com o mesmo código.
RF03	O sistema deve aceitar apenas sequências de DNA com as letras A, C, G e T e armazená-las em maiúsculas.
RF04	O sistema deve listar todos os pacientes cadastrados.
RF05	O sistema deve pesquisar um paciente pelo código.
RF06	O sistema deve pesquisar um paciente pelo nome ou por um trecho dele, sem diferenciar maiúsculas de minúsculas.
RF07	O sistema deve alterar nome, idade, sexo e sequência de DNA de um paciente. Se o novo DNA for inválido, mantém o anterior.
RF08	O sistema deve remover um paciente pelo código.

Requisitos não funcionais
Código	Requisito
RNF01	A aplicação deve ser executada no console, em Java.
RNF02	O sistema deve armazenar no máximo 100 pacientes.
RNF03	Os dados ficam apenas na memória durante a execução do programa.
RNF04	Entradas numéricas inválidas devem ser rejeitadas, pedindo nova digitação.
RNF05	O código deve separar modelo de dados, regras de negócio e interface (menu) em classes distintas.

Conceitos de POO aplicados
Classes e objetos: Paciente (modelo de dados), SistemaGenetico (regras de negócio) e Aplicacao (menu e interação com o usuário)
Encapsulamento: atributos privados com getters e setters
Construtores: um vazio e um completo na classe Paciente
Sobrecarga de métodos: buscarPaciente(int codigo) e buscarPaciente(String nome)
Vetores (arrays): armazenamento dos pacientes, com deslocamento dos elementos ao remover um registro
Separação de responsabilidades: o menu fica separado das regras do sistema
Estrutura
├── Aplicacao.java         # Classe principal: menu e fluxo do programa
├── SistemaGenetico.java   # Operações do CRUD, buscas e validação do DNA
└── Paciente.java          # Modelo de dados do paciente
Diagrama de classes
usa
armazena
1
0..100
Paciente
-int codigo
-String nome
-int idade
-String sexo
-String sequenciaDNA
+getCodigo() : int
+getNome() : String
+getIdade() : int
+getSexo() : String
+getSequenciaDNA() : String
+setNome(String) : void
+setIdade(int) : void
+setSexo(String) : void
+setSequenciaDNA(String) : void
SistemaGenetico
-Paciente[] pacientes
-int qtd_pacientes_cadastrados
+cadastrarPaciente() : void
+listarPacientes() : void
+buscarPaciente(int) : Paciente
+buscarPaciente(String) : Paciente
+alterarPaciente() : void
+removerPaciente(int) : boolean
Aplicacao
+main(String[]) : void

Como executar

Pré-requisito: ter o JDK (Java Development Kit) instalado.

Clone o repositório ou baixe os arquivos:
bash
   git clone https://github.com/Woss23/NOME-DO-REPOSITORIO.git
   cd NOME-DO-REPOSITORIO
Compile:
bash
   javac -encoding UTF-8 *.java
Execute:
bash
   java Aplicacao

Também é possível abrir os três arquivos em uma IDE (IntelliJ, Eclipse, VS Code ou NetBeans) e executar a classe Aplicacao.

Exemplo de uso
=========================================
 SISTEMA DE PERFIS GENÉTICOS
=========================================
1 - Cadastrar paciente
2 - Listar pacientes
3 - Pesquisar paciente por código
4 - Pesquisar paciente por nome
5 - Alterar paciente
6 - Remover paciente
0 - Encerrar
=========================================
Escolha uma opção:

Use apenas dados fictícios ao testar o sistema.

Limitações e próximos passos
Os dados ficam somente na memória: ao encerrar o programa, tudo é perdido.
A pesquisa por nome mostra apenas o primeiro paciente encontrado.
Ideias de evolução:
 Salvar os dados em arquivo ou em um banco de dados
 Usar ArrayList no lugar de vetor de tamanho fixo
 Organizar o código em pacotes (model, service, view)
 Tratar exceções e adicionar testes
 Criar um diagrama de classes (UML) do sistema
 
Autor

Rafael Henrique Wöss Estudante de Sistemas de Informação na Universidade Presbiteriana Mackenzie

LinkedIn • GitHub
