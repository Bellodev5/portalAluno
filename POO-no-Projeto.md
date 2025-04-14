# **Conceitos Aplicados de Programação Orientada a Objetos**

## **🔑 Princípios da POO usados no projeto**

| Pilar           | Descrição                                                       |
|-----------------|-----------------------------------------------------------------|
| Encapsulamento  | Oculta detalhes internos, expondo apenas o necessário.         |
| Herança         | Permite que classes reutilizem estrutura e comportamento de outras. |
| Abstração       | Mostra apenas os aspectos essenciais de um objeto.             |

## **🔒 Encapsulamento — Aprofundando o conceito**

📌 **Conceito**:  
Encapsulamento consiste em esconder os detalhes de implementação de uma classe e expor apenas o necessário para o funcionamento correto do sistema. Isso permite proteger os dados e manter um código mais organizado, modular e reutilizável.

🧱 **Classe Cilindro**

```java
public double areaTotalCilindro() {
    return 2 * (Math.PI * raio * raio) + 2 * (Math.PI * raio * altura);
}

public double volumeCilindro() {
    return Math.PI * raio * raio * altura;
}
```

✅ **O que esse código mostra?**  
Os métodos estão encapsulados dentro da classe Cilindro. A fórmula para calcular área e volume não está visível na classe principal — isso é ocultação da complexidade. Se no futuro o cálculo mudar, só será necessário alterar a classe Cilindro, mantendo a classe principal intocada.

🧾 **Método toString()**

```java
@Override
public String toString() {
    return String.format("\nRaio: %.2f \nAltura: %.2f \nVolume: %.2f \nÁrea Total: %.2f\n",
        getRaio(), getAltura(), volumeCilindro(), areaTotalCilindro());
}
```

✅ **O que ele reforça?**  
Esse método exibe as informações do cilindro sem que a classe principal precise saber como os cálculos são feitos. O encapsulamento permite que a classe Cilindro controle como seus dados são exibidos.

🔒 **Proteção dos dados**
```java
private double raio;
private double altura;

public Cilindro(double raio, double altura) {
    this.raio = raio;
    this.altura = altura;
}
```
Proteção de dados: As variáveis raio e altura são declaradas como private. Isso significa que elas não podem ser acessadas diretamente de fora da classe. Para manipular ou acessar esses dados, é necessário usar os métodos públicos da classe (como areaTotalCilindro e volumeCilindro).
Controle de acesso: A classe oferece um controle mais rigoroso sobre os dados. O programador não pode alterar os valores de raio ou altura diretamente, evitando que esses valores sejam modificados de forma inadequada.


🧠 **Classe Principal**

```java
System.out.print("Digite o raio: ");
raio = scanner.nextDouble();
System.out.print("Digite a altura: ");
altura = scanner.nextDouble();

Cilindro cilindro = new Cilindro(raio, altura);
System.out.println(cilindro.toString());
```

✅ **Encapsulamento aplicado**:  
A classe principal apenas coleta os dados e usa os métodos públicos da classe Cilindro. Não há necessidade de duplicar ou entender a lógica dos cálculos. Isso garante o princípio da responsabilidade única: a classe principal apenas controla o fluxo, e a Cilindro realiza os cálculos. E através da proteção de dados ao tornar privado os dados como o raio e altura, permite que o código se torna mais seguro e de fácil manutenção.

## 📌 **Abstração - Aprofundando o conceito**

```java
public double areaTotalCilindro() {
    return 2 * (Math.PI * raio * raio) + 2 * (Math.PI * raio * altura);
}

public double volumeCilindro() {
    return Math.PI * raio * raio * altura;
}
```

🔍 **Onde está a abstração?**  
Quem está usando essa classe (por exemplo, a classe principal) não precisa entender a matemática por trás do cálculo. O usuário do método só precisa saber que:

- `volumeCilindro()` → retorna o volume
- `areaTotalCilindro()` → retorna a área total

✅ Isso é abstração: você mostra somente o essencial (o método que calcula) e esconde a complexidade da fórmula.

**Exemplo 2: Classe Principal**

```java
Cilindro cilindro = new Cilindro(raio, altura);
System.out.println(cilindro.toString());
```

🔍 **O que o programador está vendo aqui?**  
Apenas uma instância do objeto e o uso de um método que imprime os dados prontos (`toString()`). Não é necessário saber o que está acontecendo “por dentro” da classe Cilindro. A classe Cilindro oferece uma interface simples de usar, escondendo todos os detalhes.

✅ Ou seja: quem usa a classe vê só a interface pública (os métodos), não a implementação interna.

🧩 **Comparando com Encapsulamento**  
Encapsulamento e abstração são parecidos, mas têm focos diferentes:

| Conceito       | Foco Principal                                  |
|----------------|-------------------------------------------------|
| Encapsulamento | Proteger os dados internos, permitindo acesso apenas controlado. |
| Abstração      | Esconder a complexidade, expondo apenas a funcionalidade relevante. |

## 🧬 **Herança — Aprofundando o conceito**

📌 **Conceito**:  
Herança é a capacidade de criar uma nova classe com base em outra existente. A classe filha herda atributos e métodos da classe pai, podendo também adicionar ou sobrescrever comportamentos.

🧩 **Classe Pessoa (Superclasse)**

```java
protected String nome;
protected char sexo;
protected int idade;
```

✅ **O que está acontecendo aqui?**  
Os atributos nome, sexo e idade estão como `protected` — ou seja, são acessíveis dentro da própria classe e pelas suas subclasses. Isso já indica a intenção de herança: esses atributos serão usados por outras classes.

👨‍🎓 **Classe Aluno (Subclasse)**

```java
public class Aluno extends Pessoa {
    private double notaAvaliacao;

    // Construtor, getters e setters
}
```

✅ **O que representa?**  
A classe Aluno herda todos os atributos da classe Pessoa e adiciona o atributo específico `notaAvaliacao`. Isso é um exemplo clássico de especialização: um aluno é uma pessoa, com características a mais.

🧠 **Por que usar isso?**  
Evita duplicação de código: não precisamos reescrever nome, sexo, idade em `Aluno`. Se precisarmos de outra classe, como `Professor`, ela também pode herdar de `Pessoa` — reaproveitando tudo.

📝 **Cenário prático com herança**:

Suponha que temos este construtor e método na classe `Pessoa`:

```java
public Pessoa(String nome, char sexo, int idade) {
    this.nome = nome;
    this.sexo = sexo;
    this.idade = idade;
}

public String apresentar() {
    return "Nome: " + nome + " | Idade: " + idade + " | Sexo: " + sexo;
}
```

A classe `Aluno` poderia fazer:

```java
public class Aluno extends Pessoa {
    private double notaAvaliacao;

    public Aluno(String nome, char sexo, int idade, double nota) {
        super(nome, sexo, idade); // Chama o construtor da classe Pai
        this.notaAvaliacao = nota;
    }

	public void exibirDadosAluno(){
        System.out.println("Avaliação do portal: " + (notaAvaliacao == -1 ? "(Ainda não avaliado)" : notaAvaliacao));
    }    
}
```

## **📦 Conclusão**  
Tanto no exemplo do Cilindro quanto no exemplo de Pessoa e Aluno, vemos:

| Pilar          | Aplicação prática no código                                        |
|----------------|--------------------------------------------------------------------|
| Encapsulamento | Oculta as fórmulas matemáticas dentro da classe Cilindro, expondo apenas os métodos prontos. |
| Herança        | Permite que Aluno herde de Pessoa, reutilizando código e promovendo uma estrutura lógica. |
| Abstração      | A classe Cilindro esconde a complexidade dos cálculos e fornece apenas métodos simples para obter o volume e a área total. O programador não precisa entender os detalhes internos da fórmula, apenas interagir com a interface pública dos métodos. |

## **Agora temos**:

- Um método herdado (`apresentar`) sendo usado diretamente.
- Um método próprio (`exibirDadosAluno`) que combina herança + encapsulamento.
- A abstração, que se faz presente por exemplo, quando a classe `Cilindro` oculta a complexidade dos cálculos e expõe apenas os métodos necessários para que o programador interaja de forma simples, sem precisar entender os detalhes da implementação.

---
```
