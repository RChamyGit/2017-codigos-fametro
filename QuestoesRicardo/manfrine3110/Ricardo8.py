#Crie uma lista que receba nome e idade e mostre somente as pessoas
#maiores de 18 anos

class Pessoa(object):
    def __init__(self, nome=None, idade=None):
        self.nome = nome
        self.idade = idade


listapessoas = []

for i in range(2):
    listapessoas.append(Pessoa(input('Digite o nome: '),int(input("Digite a idade"))))

for i in range(2):
    if listapessoas[i].idade > 18:
        print(listapessoas[i].nome ,listapessoas[i].idade)


#Autor: Ricardo Chamy do Nascimento
