#Escreva um algoritmo que leia dois vetores de 10 posições e faça a
#multiplicação dos elementos de mesmo índice, colocando o resultado em
#um terceiro vetor. Mostre o vetor resultante.


#criar vetor : vetor = [a lista cresce dinamicante, mas para gravar 10 valores definimos limite com range(10)]
vetor1 = [int(input('Insira um numero no primeiro vetor: ')) for i in range(10)]
#vetor recebe a entrada de um usuário, convertida para int(), fazendo isso num loop de i ( i++ ) , que se repete 10 vezes.
vetor2 = [int(input('Insira um numero no segundo vetor: '))for i in range(10)]

vetor3 = [vetor1[i]*vetor2[i] for i in range(10)]
#vetor3 recebe 10 vezes a multiplicacao dos valores de vetor1 e vetor2 nas suas posicoes i.


for i in range(10):
    print(vetor3[i])