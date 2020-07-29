#Um time de basquete possui 12 jogadores. Elabore um algoritmo que,
#dados dois vetores NOME e ALTURA, calcule e imprima o nome do
#jogador mais alto e a sua altura:

nometimes = []
alturatimes = []
for i in range(12):
    nometimes.append(input('Insira o nome do jogador: '))
    alturatimes.append(float(input('Insira a altura do jogador ')))

maisalto = 0
for i, alturatimes[i] in enumerate(alturatimes):
    if alturatimes[i]>maisalto:
        maisalto = alturatimes[i]
        posicao = i

print('Nome: ', nometimes[posicao], 'Altura: ',alturatimes[posicao])