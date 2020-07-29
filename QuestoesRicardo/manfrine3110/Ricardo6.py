#Armazenar em vetores nome e salários de 15 pessoas. Calcular e armazenar em outro vetor o
#novosalário,sabendo-­‐se que o reajuste foi de 15%.
#Imprimir uma listagem com nome,salário e novo salário reajustado.

nomes = []
salarios = []

for i in range(15):
    nomes.append(input('Digite o nome da pessoa: '))
    salarios.append(float(input('Digite o salario: ')))


novosalario = [(salarios[i]+(salarios[i]*0.15)) for i in range(15)]

for i in range(15):
    print('Nome: ',nomes[i],'\nSalario: ',salarios[i],'\nSalario reajustado: ',novosalario[i])


#Aluno: Ricardo Chamy do Nascimento