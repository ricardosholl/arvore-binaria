class No {
    int dado;
    No esquerda;
    No direita;

    No(int dado) {
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
    }
}

class ArvoreBinaria {
    No raiz;

    // Algoritmo para inserção de novos nós
    public void inserir(int dado) {
        raiz = inserirRecursivo(raiz, dado);
    }

    private No inserirRecursivo(No atual, int dado) {
        if (atual == null) {
            return new No(dado);
        }

        if (dado < atual.dado) {
            atual.esquerda = inserirRecursivo(atual.esquerda, dado);
        } else if (dado > atual.dado) {
            atual.direita = inserirRecursivo(atual.direita, dado);
        }

        return atual;
    }

    // Algoritmo para remoção de nós
    public void remover(int dado) {
        raiz = removerRecursivo(raiz, dado);
    }

    private No removerRecursivo(No atual, int dado) {
        if (atual == null) {
            return null;
        }

        if (dado == atual.dado) {
            // Nó sem filhos
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            }
            // Nó com apenas um filho
            if (atual.esquerda == null) {
                return atual.direita;
            }
            if (atual.direita == null) {
                return atual.esquerda;
            }
            // Nó com dois filhos
            atual.dado = menorValor(atual.direita);
            atual.direita = removerRecursivo(atual.direita, atual.dado);
            return atual;
        }

        if (dado < atual.dado) {
            atual.esquerda = removerRecursivo(atual.esquerda, dado);
            return atual;
        }

        atual.direita = removerRecursivo(atual.direita, dado);
        return atual;
    }

    private int menorValor(No raiz) {
        int menorV = raiz.dado;
        while (raiz.esquerda != null) {
            menorV = raiz.esquerda.dado;
            raiz = raiz.esquerda;
        }
        return menorV;
    }

    // Algoritmo para impressão da árvore em ordem
    public void imprimirEmOrdem() {
        imprimirEmOrdemRecursivo(raiz);
    }

    private void imprimirEmOrdemRecursivo(No no) {
        if (no == null) {
            return;
        }

        imprimirEmOrdemRecursivo(no.esquerda);
        System.out.print(no.dado + " ");
        imprimirEmOrdemRecursivo(no.direita);
    }

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        // Inserção de nós
        arvore.inserir(5);
        arvore.inserir(3);
        arvore.inserir(7);
        arvore.inserir(1);
        arvore.inserir(4);
        arvore.inserir(6);
        arvore.inserir(8);

        // Impressão da árvore em ordem
        System.out.println("Árvore em ordem:");
        arvore.imprimirEmOrdem();
        System.out.println();

        // Remoção de um nó
        arvore.remover(4);

        // Impressão da árvore em ordem após remoção
        System.out.println("Árvore em ordem após remoção de 4:");
        arvore.imprimirEmOrdem();
        System.out.println();
    }
}
