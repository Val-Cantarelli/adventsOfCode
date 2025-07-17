## PT or EN: internacionalization - doc?

## 1. Overview:(ideia geral do início ao fim do problema)

Vamos falar rapidamente de um problema sugerido
no [AdventsOfCode de 2022, do dia 07](https://adventofcode.com/2022/day/7).

Ele basicamente simula um Sistema de Arquivos. Você recebe uma entrada em formato texto e algumas instruções de como
interpretar cada linha. Como resposta final ele requer que você encontre a somatória de todos os diretórios de
até 100.000 de tamanho.

Acredito que abordar esse problema de trás para frente nos ajuda a enxergar com mais clareza a necessidade de boas
estruturas de dados, a separação de conceitos e a decomposição do problema em partes menores. Apesar de já termos algum
indicativo de como modelar as classes, focar inicialmente no parsing pode nos provocar reflexões mais
ricas sobre que estrutura utilizar, como modelar os dados e quais etapas devem compor o fluxo de leitura e interpretação
da entrada.

```
 System.out.println(
                    content.values().stream()
                            .filter( dir -> dir.size() <= 100000)
                            .mapToInt(dir -> dir.size())
                            .sum()
            );
```

---

## 2. Entrada:

Esse é o exemplo de entrada:

```
$ cd /
$ ls
dir a
14848514 b.txt
8504156 c.dat
dir d
$ cd a
$ ls
dir e
29116 f
2557 g
62596 h.lst
```

Antes de seguirmos, vale relembrar:

- $ cd dir x: muda do diretório atual para o x;
- $ cd ls : lista o conteúdo do diretório atual;
- $ cd .. : retorna um nível na hierarquia de diretórios;

- dir e : diretório de nome "e"
- 29116 f: arquivo de tamanho 29116 e nome "f"

Quando falamos de sistemas de arquivos, os diretórios podem ser compostos de arquivos e/ou outros diretórios.
O tamanho de um arquivo é facilmente obtido no momento da leitura, mas no que diz respeito a diretorios não temos como
oferecer essa informação de imediato. Diretórios podem ser compostos por outros diretórios recursivamente e, por isso,
vamos, ao mesmo tempo em que lemos, guardar informações da entrada em um mapa para quando no futuro entrarmos no
diretório
podermos atualizar os arquivos que o compõem.
---

## 3. Parsing:

Antes de entrar no parsing em si, tentei apresentar os conceitos que o permeiam. Agora, falando mais profundamente
sobre o parsing, é possível identificar que temos 2 padrões de comportamento no arquivo de entrada:
- "$": indica um comando a ser tratado;
- dir x or 1234 r: advém de uma listagem de um determinado diretório;

Eu gosto de pensar em primeiro criar elementos para depois consumi-los. Então, vamos começar falando da listagem.
Identificamos a criação de um diretório ou arquivo no momento em que lemos sua definição na listagem, porém antes disso
é necessário sabermos em que diretório estamos - suge aqui a necessidade de uma variável: currentDir.

Então quando lemos "dir a":
- crio o diretório a;
- adiciono ele ao currentDir - no nosso exemplo é "/". E aqui gostaríamos de ter também uma lista
dentro para guardarmos os filhos, certo? Mantemos isso em mente.
- adiciono ele também ao mapa - mesmo que esse diretório esteja vazio por enquanto. E aqui temos o seguinte detalhe:
- key: currentPath
- value: Dir a

        currentPath: no futuro, quando quiser atualizar o conteúdo de dir a, quero ser capaz de rapidamente acessar esse

diretório do mapa independentemente de onde estou e o path absoluto é uma excelente solução.
Ou seja, quando eu entrar e listar o dir a, vou usar a key "/a" que me provê o dir a para adcionar os seus filhos.

### 3.1. Separação conceitual entre estrutura hierárquica e lookup direto:

Usamos tanto currentPath quanto currentDir para propósitos diferentes. Um detalhe importante é entender que,
ao criar um diretório, eu o adiciono como filho de um currentDir que já está no mapa e também como um elemento
individual nesse mesmo mapa.
    

