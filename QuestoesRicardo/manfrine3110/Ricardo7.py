#Foram anotadas as idades e alturas de 20 alunos. Faça um Programa que determine quantos alunos com mais
#de 15 anos possuem altura inferior à média de altura desses alunos.

aluno_altura = []
aluno_idade = []
acumulador = 0
media_altura = 0
for i in range(20):
    aluno_idade.append(int(input('Digite a idade do aluno : ')))
    aluno_altura.append(float(input('Digite a altura do aluno: ')))
    media_altura = media_altura + aluno_altura[i]

media_altura = media_altura/20 #media

#print(media_altura)
for i in range(20):
    if aluno_idade[i] > 15 and aluno_altura[i] < media_altura:
        acumulador = acumulador + 1

print('Quantidade de alunos com mmais de 15 anos e altura menor que a media: ', acumulador)

#Autor = Ricardo Chamy do Nascimento
