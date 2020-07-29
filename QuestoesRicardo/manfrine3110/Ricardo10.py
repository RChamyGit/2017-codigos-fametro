#Crie um algoritmo que crie uma classe ao seu nível de análise e mostre como utilizar
#os atributos e instanciar os objetos em Python.

class Veiculo(object):
    #definicao de nome da classe e descricao de seu objeto
    def __init__(self, modelo=None, fabricante=None, cor=None, placa=None):
    #funcao que funciona como construtor
        self.modelo = modelo
        self.fabricante = fabricante
        self.cor = cor
        self.placa = placa
    #fim definicao de classe
    def listaObjeto(self):
      print('Modelo: ',self.modelo,'Fabricante: ',self.fabricante,'Cor: ',self.cor,'Placa: ',self.placa)
      #funcao para imprimir seus elementos.

#instanciacao do objeto com entrada de dados via usuario
carro = Veiculo(input('Insira o modelo do carro: '), input('Insira o fabricante do carro'),input('Insira a cor do carro'),
                    input('Insira a placa do carro'))

carro.listaObjeto()
#alterando fabricante

carro.fabricante = 'Honda'

carro.listaObjeto()