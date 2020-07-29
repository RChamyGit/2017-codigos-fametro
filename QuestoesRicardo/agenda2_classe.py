# BUGS A CORRIGIR :

    # EXCLUIR SO FUNCIONA NO PRIMEIRO ELEMENTO -> CORRIGIDO
    # ALTERAR SO FUNCIONA NO PRIMEIRO ELEMENTO -> CORRIGIDO

# VERSAO 2 -> utiliza uma classe em vez de uma lista.
    #progresso da atualizacao para classe:
        #gravar elemento em agenda : ok
        #adaptar algoritmo de pesquisa: ok
        #alterar elemento na agenda: ok
        #listar elementos da agenda: ok
        #excluir elemento na lista: ok

        #gravar objeto no arquivo: ok
        #ler objeto do arquivo: ok

agenda = []


#  definicao da classe


class Pessoa(object):
    def __init__(self, nome=None, telefone=None):
        self.nome = nome
        self.telefone = telefone

    def listarPessoa(self):
        print('Nome: %s\n' % (self.nome))
        print('Telefone: %s\n' % (self.telefone))


# definicoes de funcoes.


def inserir_nome():
    return input("Digite o seu nome:")


def inserir_telefone():
    return input("Digite o seu contato:")
# teste de leitura de variavel


# def imprimir_informacoes(nome, cont):
    # print(nome, cont)
    # encapsulado na classe Pessoa.

# fim predefinicoes

# PESQUISA VERSAO 1 -> Pessoa é uma lista salva em uma lista.
# PESQUISA VERSÃO 2 -> Pessoa é uma classe salva em uma lista.


def inserir_contato():
    global agenda  # não é declaração, na verdade faz a função usar a global declarada
    nome = inserir_nome()  # encapsulamento by Luciano
    telefone = inserir_telefone()
    pessoa = Pessoa(nome, telefone)
    agenda.append(pessoa)  # coloca objeto pessoa gravado na lista


def listar_informacao():
    print("\nAgenda\n\n")  # 2.0 -> adicionar codigo para lista vazia.
    for pessoa in agenda:
        pessoa.listarPessoa()
        print("--------\n")
    print("--------------\n")


def pesquisa(nome):
    global agenda  # bugfix : sem puxar o global ele assume uma agenda nova.
    nome = nome.lower()  # nome digitado convertido pra minusculo
    for i, pessoa in enumerate(agenda):
        print('TESTE - INICIO PESQUISA! ')
        # comparanome = str(agenda[i][0])  # converte objeto lista para string -> obsoleto com a classe.
        if pessoa.nome == nome:  # converte o elemento da lista no indice atual para minusculo
            # PESQUISA COM LISTA EM LISTA NAO ESTA FUNCIONANDO
            print('TESTE - ENCONTRADO ! \n')
            return i
    return None  # else


def alterar_informacao():  # NAO ALTERA NO ARQUIVO!
    global agenda
    pesqindice = pesquisa(inserir_nome())  # nome alterado para compreensao.
    if pesqindice is not None:  # codigo de pesquisa pra lista
        # nome = agenda[pnome][0]  # alterando a mini-lista Pessoa dentro da lista. 2.0 -> associacao para print desnecessaria.
        # cont = agenda[pnome][1]  # alterando a mini-lista Pessoa dentro da lista.
        print("Encontrado!")
        agenda[pesqindice].listarPessoa()
        pessoa = Pessoa(inserir_nome(),inserir_telefone())
        agenda[pesqindice] = pessoa
    else:
        print("Nome não encontrado!")

def apagar_informacao():
    global agenda  # o que é global
    nome = inserir_nome()  # encapsulada > ver linha 1
    indicenome = pesquisa(nome)
    if indicenome is not None:
        del agenda[indicenome]  # quando encontrar algo ( 0 - N ) apagar registro da lista
    else:
        print("Nome não cadastrado!")


def arquivo_gravar():
    global agenda
    # arquivonome = arquivo_nome() 2.0 -> eliminado pra evitar confusao
    arquivo = open('projetomanfrine10-11-2017fametro.txt', "w", encoding="utf-8")  # modo w - escrever!
    for pessoa in agenda:
        arquivo.write("%s,%s\n" % (pessoa.nome,pessoa.telefone))  # SALVA COISAS INFORMADAS NO ARQUIVO UTILIZANDO UM SEPARADOR
        # o write não é usado no nome do arquivo e sim no OBJETO ARQUIVO
    arquivo.close()


def arquivo_leitura(): # apaga lista atual e gera uma nova lendo o arquivo.
    global agenda

    arquivo = open('projetomanfrine10-11-2017fametro.txt', "r", encoding="utf-8")
    agenda = []
    pessoa = Pessoa()
    for linha in arquivo.readlines():
        pessoa.nome, pessoa.telefone = linha.strip().split(",")
        agenda.append(pessoa)
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


def menu():  # menu!
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
            inserir_contato()
        elif opcao == 2:
            alterar_informacao()
        elif opcao == 3:
            apagar_informacao()
        elif opcao == 4:
            listar_informacao()
        elif opcao == 5:
            arquivo_gravar()
        elif opcao == 6:
            arquivo_leitura()
    # inicio


menu()
# comentarios by Ricardo
# classe by Luti