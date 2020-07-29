# BUGS A CORRIGIR :

# EXCLUIR SO FUNCIONA NO PRIMEIRO ELEMENTO -> CORRIGIDO

# ALTERAR SO FUNCIONA NO PRIMEIRO ELEMENTO -> CORRIGIDO

# COISAS A FAZER:

# MUDAR A LISTA DE ATRIBUTOS PRA UMA CLASSE.
agenda = []

# definicoes de funcoes.


def inserir_nome():
    return input("Digite o seu nome:")


def inserir_cont():
    return input("Digite o seu contato:")
# teste de leitura de variavel


def imprimir_informacoes(nome, cont):
    print(nome, cont)


def arquivo_nome():
    return input("Nome do novo arquivo: ")
# fim predefinicoes

# PESQUISA VERSAO 1 -> Pessoa é uma lista salva em uma lista.
def pesquisa(nome):
    global agenda # bugfix : sem puxar o global ele assume uma agenda nova.
    nome = nome.lower()  # nome digitado convertido pra minusculo
    for i,pesqnome in enumerate(agenda):
        print('TESTE - INICIO PESQUISA! ')
        comparanome = str(agenda[i][0]) #converte objeto lista para string
        if comparanome.lower() == nome:  # converte o elemento da lista no indice atual para minusculo
            #PESQUISA COM LISTA EM LISTA NAO ESTA FUNCIONANDO
            print('TESTE - ENCONTRADO ! \n')
            return i
    return None  # else


# PESQUISA VERSÃO 2 -> Pessoa é uma classe salva em uma lista.

def pesquisa2(nome):
    return None

def inserir_informacao():
    global agenda  # não é declaração, na verdade faz a função usar a global declarada
    nome = inserir_nome()  # encapsulamento by Luciano
    cont = inserir_cont()
    agenda.append([nome, cont])  # adiciona uma lista de 2 elementos no indice da lista ( gera uma matriz )
    # substituir pela nossa classe
    # adaptar para classe


def apagar_informacao():
    global agenda  # o que é global
    nome = inserir_nome()  # encapsulada > ver linha 1
    pnome = pesquisa(nome)
    if pnome is not None:
        del agenda[pnome]  # quando encontrar algo ( 0 - N ) apagar registro da lista
    else:
        print("Nome não cadastrado!")


def alterar_informacao(): # NAO ALTERA NO ARQUIVO!
    pnome = pesquisa(inserir_nome())
    if pnome is not None:  # codigo de pesquisa pra lista
        nome = agenda[pnome][0]  # alterando a mini-lista Pessoa dentro da lista.
        cont = agenda[pnome][1]  # alterando a mini-lista Pessoa dentro da lista.
        print("Encontrado!")
        imprimir_informacoes(nome, cont)
        nome = inserir_nome()
        cont = inserir_cont()
        agenda[pnome] = [nome, cont]
    else:
        print("Nome não encontrado!")


def listar_informacao():
    print("\nAgenda\n\n")
    for i in agenda:
        imprimir_informacoes(i[0], i[1])  # substituir por objeto de classe!
    print("--------\n")


def leitura():
    global agenda
    arquivonome = arquivo_nome()
    arquivo = open(arquivonome, "r", encoding="utf-8")
    agenda = []
    for linha in arquivo.readlines():
        nome, cont = linha.strip().split("#")  # codigo que separa elementos usando um argumento #
        agenda.append([nome, cont])
    arquivo.close()


def gravar():
    global agenda
    arquivonome = arquivo_nome()
    arquivo = open(arquivonome, "w", encoding="utf-8")
    for i in agenda:
        arquivo.write("%s#%s\n" % (i[0], i[1]))  # SALVA COISAS INFORMADAS NO ARQUIVO UTILIZANDO UM SEPARADOR
        # o write não é usado no nome do arquivo e sim no OBJETO ARQUIVO
    arquivo.close()


def validar_opcoes():  # Verifica se a entrada da opcao do Menu é valida
    while True:
        try:
            valor = int(input('validar_opcoes - digite a opcao desejada'))  # int() para comparacao funcionar
            if 0 <= valor <= 6:
                return valor
            else:
                print("Valor Invalido")
        except ValueError:
            print("Valor incompreendido!")


def menu(): # menu!
    opcao = None
    while opcao != 0:
        print("BEM VINDO AO MENU \n")
        print("1-novo, 2-alterar, 3-apagar, 4-listar, 5-gravar, 6-lê, 0-sair")
        print('\nEscolha a opcao')
        opcao = validar_opcoes()
        if opcao == 0:
            print('SAINDO DO PROGRAMA!')
            break
        elif opcao == 1:
            print("ENTRANDO NA OPCAO 1")
            inserir_informacao()
        elif opcao == 2:
            alterar_informacao()
        elif opcao == 3:
            apagar_informacao()
        elif opcao == 4:
            listar_informacao()
        elif opcao == 5:
            gravar()
        elif opcao == 6:
            leitura()
    # inicio


menu()
# comentarios by Ricardo
