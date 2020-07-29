# Criar um algoritmo que leia o salário de uma e imprimir o desconto do
# INSS segundo os dados abaixo:
# - menor ou igual a R$ 600 -> isento;
# - maior que R$ 600 e menor que R$ 1.200 -> 20%
# - maior que R$ 1.200 e menor ou igual a 2.000 -> 25%
# - maior que R$ 2.000 -> 30%


salario = input('Insira o salario da pessoa: ')
#toda leitura de teclado é gravada como string
if int(salario) <= 600:
        print('Pessoa Isenta de INSS')
elif int(salario) >600 and int(salario) <= 1200:
        print('Essa pessoa vai pagar 20% de INSS')
elif int(salario) >1200 and int(salario) <= 2000:
        print('Pessoa paga 25% de INSS')
elif int(salario) >2000:
        print('30% de INSS')

