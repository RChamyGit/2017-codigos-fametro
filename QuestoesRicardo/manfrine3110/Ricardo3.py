#Criar um algoritmo para entrar com nome, sexo e idade de uma pessoa.
#Se a pessoa for do sexo feminino e tiver menos que 25 anos, imprimir o
#nome e a mensagem: ACEITA. Caso contrário, imprimir nome e
#mensagem: NÃO ACEITA. (considerar ‘ f ’ ou ‘F’ ).

nome = input('Insira o nome da pessoa')
sexo = input('Insira o sexo da pessoa')
idade = int (input('Insira a idade de uma pessoa'))

if idade < 25 and (sexo == 'f' or sexo =='F'):
    print(nome, '\nACEITA')
else:
    print(nome, '\nNAO ACEITA')