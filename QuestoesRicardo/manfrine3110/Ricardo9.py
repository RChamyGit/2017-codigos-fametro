#Crie uma algoritmo que contenha uma função
#que possa ser utilizado com uma lista.

def funcao_maior_elemento_lista(lista):
    soma = 0
    for i in range(len(lista)):
        soma = soma + lista[i]
    return soma

lista_numeros = [1,4,5,6,7,10,15]

print(funcao_maior_elemento_lista(lista_numeros))

#Autor: Ricardo Chamy do Nascimento
#funcao que recebe uma lista e imprime a soma de seus valores como retorno.
